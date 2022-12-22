package cn.acsm.module.purchase.service.deliver;

import cn.acsm.module.purchase.controller.admin.deliver.vo.*;
import cn.acsm.module.purchase.convert.deliver.PurchaseDeliverConvert;
import cn.acsm.module.purchase.dal.dataobject.deliver.PurchaseDeliverDO;
import cn.acsm.module.purchase.dal.dataobject.details.PurchaseDetailsDO;
import cn.acsm.module.purchase.dal.mysql.deliver.PurchaseDeliverMapper;
import cn.acsm.module.purchase.dal.mysql.details.PurchaseDetailsMapper;
import cn.acsm.module.purchase.dal.mysql.order.PurchaseOrderMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static cn.acsm.module.purchase.constant.PurchaseOrderConstant.STATUS;
import static cn.acsm.module.purchase.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 采购交付 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class PurchaseDeliverServiceImpl implements PurchaseDeliverService {

    @Resource
    private PurchaseDeliverMapper deliverMapper;

    @Resource
    private PurchaseDetailsMapper purchaseDetailsMapper;

    @Resource
    private PurchaseOrderMapper orderMapper;

    @Override
    public Long createDeliver(PurchaseDeliverCreateReqVO createReqVO) {
        // 获取采购数量
        PurchaseDetailsDO detailsDO = purchaseDetailsMapper.selectById(createReqVO.getPurchaseDetailsId());
        BigDecimal buyNumber = detailsDO.getBuyNumber();

        // 获取已有交付数量
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("purchase_details_id", createReqVO.getPurchaseDetailsId());
        wrapper.eq("delivery_status", createReqVO.getPurchaseDetailsId());
        List<PurchaseDeliverDO> list = purchaseDetailsMapper.selectList(wrapper);
        // 已有交付数量
        BigDecimal sum = new BigDecimal(list.stream().map(s -> s.getActualDeliveryCount()).mapToDouble(Double::doubleValue).sum());
        if(buyNumber.compareTo(sum.add(createReqVO.getDeliveryQuantity())) < 0) {
            throw exception(DELIVER_TRANSBOUNDARY);
        }
        // 插入
        PurchaseDeliverDO deliver = PurchaseDeliverConvert.INSTANCE.convert(createReqVO);
        deliverMapper.insert(deliver);
        // 返回
        return deliver.getId();
    }

    @Override
    public void updateDeliver(PurchaseDeliverUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateDeliverExists(updateReqVO.getId());
        // 如果交付状态不为空则设置交付时间为当前时间
        if(StringUtils.isNotBlank(updateReqVO.getDeliveryStatus())) {
            // 将实际交付时间设置为当前交付时间
            updateReqVO.setActualDelivery(new Date());
        }
        // 更新
        PurchaseDeliverDO updateObj = PurchaseDeliverConvert.INSTANCE.convert(updateReqVO);
        deliverMapper.updateById(updateObj);
    }

    @Override
    public void deleteDeliver(Long id) {
        // 校验存在
        this.validateDeliverExists(id);
        // 删除
        deliverMapper.deleteById(id);
    }

    private void validateDeliverExists(Long id) {
        if (deliverMapper.selectById(id) == null) {
            throw exception(DELIVER_NOT_EXISTS);
        }
    }

    @Override
    public PurchaseDeliverDO getDeliver(Long id) {
        return deliverMapper.selectById(id);
    }

    @Override
    public List<PurchaseDeliverDO> getDeliverList(Collection<Long> ids) {
        return deliverMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<PurchaseDeliverDO> getDeliverPage(PurchaseDeliverPageReqVO pageReqVO) {
        return deliverMapper.selectPage(pageReqVO);
    }

    @Override
    public List<PurchaseDeliverDO> getDeliverList(PurchaseDeliverExportReqVO exportReqVO) {
        return deliverMapper.selectList(exportReqVO);
    }

    /**
     * 根据采购单明细id获取交付数量
     *
     * @param reqCountVO
     * @return 采购交付数量
     */
    @Override
    public BigDecimal getDeliveryCount(PurchaseDeliverReqCountVO reqCountVO) {
        // 验证当前采购单状态是否正常
        QueryWrapper orderWrapper = new QueryWrapper();
        orderWrapper.eq("purchase_number", reqCountVO.getPurchase_number());
        orderWrapper.eq("status", STATUS);
        if(ObjectUtils.isNotEmpty(orderMapper.selectOne(orderWrapper))) {
            throw exception(ORDER_STATUS_2);
        }

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("purchase_details_id", reqCountVO.getPurchaseDetailsId());
        List<PurchaseDeliverDO> list = deliverMapper.selectList(wrapper);
        return new BigDecimal(list.stream().map(s -> s.getActualDeliveryCount()).mapToDouble(Double::doubleValue).sum());
    }

}
