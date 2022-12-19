package cn.acsm.module.purchase.service.order;

import cn.acsm.module.purchase.controller.admin.order.vo.PurchaseOrderCreateReqVO;
import cn.acsm.module.purchase.controller.admin.order.vo.PurchaseOrderExportReqVO;
import cn.acsm.module.purchase.controller.admin.order.vo.PurchaseOrderPageReqVO;
import cn.acsm.module.purchase.controller.admin.order.vo.PurchaseOrderUpdateReqVO;
import cn.acsm.module.purchase.convert.order.PurchaseOrderConvert;
import cn.acsm.module.purchase.dal.dataobject.order.PurchaseOrderDO;
import cn.acsm.module.purchase.dal.mysql.order.PurchaseOrderMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.purchase.enums.ErrorCodeConstants.ORDER_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 采购单 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Resource
    private PurchaseOrderMapper orderMapper;

    @Override
    public Long createOrder(PurchaseOrderCreateReqVO createReqVO) {
        // 插入
        PurchaseOrderDO order = PurchaseOrderConvert.INSTANCE.convert(createReqVO);
        orderMapper.insert(order);
        // 返回
        return order.getId();
    }

    @Override
    public void updateOrder(PurchaseOrderUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateOrderExists(updateReqVO.getId());
        // 更新
        PurchaseOrderDO updateObj = PurchaseOrderConvert.INSTANCE.convert(updateReqVO);
        orderMapper.updateById(updateObj);
    }

    @Override
    public void deleteOrder(Long id) {
        // 校验存在
        this.validateOrderExists(id);
        // 删除
        orderMapper.deleteById(id);
    }

    private void validateOrderExists(Long id) {
        if (orderMapper.selectById(id) == null) {
            throw exception(ORDER_NOT_EXISTS);
        }
    }

    @Override
    public PurchaseOrderDO getOrder(Long id) {
        return orderMapper.selectById(id);
    }

    @Override
    public List<PurchaseOrderDO> getOrderList(Collection<Long> ids) {
        return orderMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<PurchaseOrderDO> getOrderPage(PurchaseOrderPageReqVO pageReqVO) {
        return orderMapper.selectPage(pageReqVO);
    }

    @Override
    public List<PurchaseOrderDO> getOrderList(PurchaseOrderExportReqVO exportReqVO) {
        return orderMapper.selectList(exportReqVO);
    }

}
