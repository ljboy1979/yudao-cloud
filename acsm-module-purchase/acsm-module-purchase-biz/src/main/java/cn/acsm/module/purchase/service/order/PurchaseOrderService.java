package cn.acsm.module.purchase.service.order;

import cn.acsm.module.purchase.controller.admin.order.vo.*;
import cn.acsm.module.purchase.dal.dataobject.order.PurchaseOrderDO;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 采购单 Service 接口
 *
 * @author 芋道源码
 */
public interface PurchaseOrderService {

    /**
     * 创建采购单
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    CommonResult<String> createOrder(@Valid PurchaseOrderCreateReqVO createReqVO);

    /**
     * 更新采购单
     *
     * @param updateReqVO 更新信息
     */
    void updateOrder(@Valid PurchaseOrderUpdateReqVO updateReqVO);

    /**
     * 删除采购单
     *
     * @param id 编号
     */
    void deleteOrder(PurchaseOrderDelReqVO purchaseOrderDelReqVO);

    /**
     * 获得采购单
     *
     * @param id 编号
     * @return 采购单
     */
    PurchaseOrderDO getOrder(Long id);

    /**
     * 获得采购单列表
     *
     * @param ids 编号
     * @return 采购单列表
     */
    List<PurchaseOrderDO> getOrderList(Collection<Long> ids);

    /**
     * 获得采购单分页
     *
     * @param pageReqVO 分页查询
     * @return 采购单分页
     */
    PageResult<PurchaseOrderDO> getOrderPage(PurchaseOrderPageReqVO pageReqVO);

    /**
     * 获得采购单列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 采购单列表
     */
    List<PurchaseOrderDO> getOrderList(PurchaseOrderExportReqVO exportReqVO);

    /**
     * 变更采购状态
     *
     * @param updateReqVO 更新信息
     */
    void updateOrderStatus(PurchaseOrderUpdateStatusReqVO updateReqVO);

    /**
     * 3.6.2.5.查询采购合同单
     */
    PageResult<QueryPurchaseOrderPageInfoVO> getOrderPageInfo(PurchaseOrderPageInfoVO pageReqVO);

    /**
     * 3.6.2.3.获取采购产品列表
     */
    Page<QueryPurchaseOrderPageInfoVO> getOrderPageInfo(PurchaseOrderProductsVO pageReqVO);


}
