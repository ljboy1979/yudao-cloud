package cn.acsm.module.transaction.order.service.orderdetail;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.order.controller.admin.orderdetail.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.orderdetail.OrderDetailDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 订单详情 Service 接口
 *
 * @author 芋道源码
 */
public interface OrderDetailService {

    /**
     * 创建订单详情
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createDetail(@Valid OrderDetailCreateReqVO createReqVO);

    /**
     * 更新订单详情
     *
     * @param updateReqVO 更新信息
     */
    void updateDetail(@Valid OrderDetailUpdateReqVO updateReqVO);

    /**
     * 删除订单详情
     *
     * @param id 编号
     */
    void deleteDetail(String id);

    /**
     * 获得订单详情
     *
     * @param id 编号
     * @return 订单详情
     */
    OrderDetailDO getDetail(String id);

    /**
     * 获得订单详情列表
     *
     * @param ids 编号
     * @return 订单详情列表
     */
    List<OrderDetailDO> getDetailList(Collection<String> ids);

    /**
     * 获得订单详情分页
     *
     * @param pageReqVO 分页查询
     * @return 订单详情分页
     */
    PageResult<OrderDetailDO> getDetailPage(OrderDetailPageReqVO pageReqVO);

    /**
     * 获得订单详情列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 订单详情列表
     */
    List<OrderDetailDO> getDetailList(OrderDetailExportReqVO exportReqVO);

}
