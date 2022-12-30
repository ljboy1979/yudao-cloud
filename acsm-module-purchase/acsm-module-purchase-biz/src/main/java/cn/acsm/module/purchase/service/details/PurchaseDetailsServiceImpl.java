package cn.acsm.module.purchase.service.details;

import cn.acsm.module.purchase.api.orderdetails.vo.OrderDetailsApiVO;
import cn.acsm.module.purchase.controller.admin.details.vo.*;
import cn.acsm.module.purchase.convert.details.PurchaseDetailsConvert;
import cn.acsm.module.purchase.dal.dataobject.details.PurchaseDetailsDO;
import cn.acsm.module.purchase.dal.mysql.details.PurchaseDetailsMapper;
import cn.acsm.module.purchase.dal.mysql.order.PurchaseOrderMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static cn.acsm.module.purchase.constant.PurchaseOrderConstant.*;
import static cn.acsm.module.purchase.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 采购单明细 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
@Slf4j
public class PurchaseDetailsServiceImpl implements PurchaseDetailsService {

    @Resource
    private PurchaseDetailsMapper detailsMapper;

    @Resource
    private PurchaseOrderMapper orderMapper;

    @Override
    public Long createDetails(PurchaseDetailsCreateReqVO createReqVO) {

        // 插入
        PurchaseDetailsDO details = PurchaseDetailsConvert.INSTANCE.convert(createReqVO);
        detailsMapper.insert(details);
        // 返回
        return details.getId();
    }

    @Override
    @CachePut(value = "deliverDetails", key = "#updateReqVO.id")
    public void updateDetails(PurchaseDetailsUpdateReqVO updateReqVO) {
        // 限制条件，【采购单表】中采购状态为"未采购"，才可修改
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("purchase_number", updateReqVO.getPurchaseNumber());
        wrapper.eq("purchase_status", PURCHASE_STATUS_1);
        if(ObjectUtils.isEmpty(orderMapper.selectOne(wrapper))) {
            log.error("当前采购单状态为未开始的不存在，采购单号：{}",updateReqVO.getPurchaseNumber());
            throw exception(ORDER_STATUS_ONE_NOT_EXISTS);
        }
        // 校验存在
        this.validateDetailsExists(updateReqVO.getId());
        // 更新
        PurchaseDetailsDO updateObj = PurchaseDetailsConvert.INSTANCE.convert(updateReqVO);
        detailsMapper.updateById(updateObj);
    }

    @Override
    @CacheEvict(value = "deliverDetails", key = "#purchaseDetailsDelReqVO.id")
    public void deleteDetails(PurchaseDetailsDelReqVO purchaseDetailsDelReqVO) {
        // 限制条件，【采购单表】中采购状态为"采购执行中"，才可删除
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("purchase_number", purchaseDetailsDelReqVO.getPurchaseNumber());
        wrapper.eq("purchase_status", PURCHASE_STATUS_2);
        if(ObjectUtils.isEmpty(orderMapper.selectOne(wrapper))) {
            exception(ORDER_STATUS_TWO_NOT_EXISTS);
        }
        // 校验存在
        this.validateDetailsExists(purchaseDetailsDelReqVO.getId());
        // 删除
        detailsMapper.deleteById(purchaseDetailsDelReqVO.getId());
    }

    /**
     * 删除采购单明细
     */
    @CacheEvict(value = "deliverDetails", key = "#id")
    @Override
    public void deleteDetails(Long id) {
        validateDetailsExists(id);
        // 删除
        detailsMapper.deleteById(id);
    }

    private void validateDetailsExists(Long id) {
        if (detailsMapper.selectById(id) == null) {
            throw exception(DETAILS_NOT_EXISTS);
        }
    }

    @Cacheable(value = "deliverDetails", key = "#id")
    @Override
    public PurchaseDetailsDO getDetails(Long id) {
        return detailsMapper.selectById(id);
    }

    @Cacheable(value = "deliverDetails", key = "#ids")
    @Override
    public List<PurchaseDetailsDO> getDetailsList(Collection<Long> ids) {
        return detailsMapper.selectBatchIds(ids);
    }

    @Cacheable(value = "deliverDetails", key = "'getDetailsPage'.concat('-').concat(#pageReqVO.pageNo)" +
            ".concat('-').concat(#pageReqVO.pageSize)")
    @Override
    public PageResult<PurchaseDetailsDO> getDetailsPage(PurchaseDetailsPageReqVO pageReqVO) {
        return detailsMapper.selectPage(pageReqVO);
    }

    @Cacheable(value = "deliverDetails", key = "'getDetailsList'.concat('-').concat(#exportReqVO.purchaseId)" +
            ".concat('-').concat(#exportReqVO.purchaseNumber)")
    @Override
    public List<PurchaseDetailsDO> getDetailsList(PurchaseDetailsExportReqVO exportReqVO) {
        return detailsMapper.selectList(exportReqVO);
    }

    /**
     * 获得采购单明细信息
     *
     * @return 采购单明细列表信息
     */
    public List<OrderDetailsApiVO> getDetailsList() {
        List<PurchaseDetailsDO> purchaseDetailsDOS = detailsMapper.selectList();
        return purchaseDetailsDOS.stream().map(detail -> {
            OrderDetailsApiVO apiVO = new OrderDetailsApiVO();
            BeanUtils.copyProperties(detail, apiVO);
            return apiVO;
        }).collect(Collectors.toList());
    }

}
