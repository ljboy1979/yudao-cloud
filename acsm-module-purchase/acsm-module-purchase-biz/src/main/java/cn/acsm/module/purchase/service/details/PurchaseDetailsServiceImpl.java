package cn.acsm.module.purchase.service.details;

import cn.acsm.module.purchase.controller.admin.details.vo.*;
import cn.acsm.module.purchase.convert.details.PurchaseDetailsConvert;
import cn.acsm.module.purchase.dal.dataobject.details.PurchaseDetailsDO;
import cn.acsm.module.purchase.dal.mysql.details.PurchaseDetailsMapper;
import cn.acsm.module.purchase.dal.mysql.order.PurchaseOrderMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

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

    @Override
    public PurchaseDetailsDO getDetails(Long id) {
        return detailsMapper.selectById(id);
    }

    @Override
    public List<PurchaseDetailsDO> getDetailsList(Collection<Long> ids) {
        return detailsMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<PurchaseDetailsDO> getDetailsPage(PurchaseDetailsPageReqVO pageReqVO) {
        return detailsMapper.selectPage(pageReqVO);
    }

    @Override
    public List<PurchaseDetailsDO> getDetailsList(PurchaseDetailsExportReqVO exportReqVO) {
        return detailsMapper.selectList(exportReqVO);
    }

}
