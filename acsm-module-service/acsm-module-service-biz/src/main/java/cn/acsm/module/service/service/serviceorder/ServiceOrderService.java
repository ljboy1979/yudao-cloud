package cn.acsm.module.service.service.serviceorder;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import javax.validation.*;
import cn.acsm.module.service.controller.admin.serviceorder.vo.*;
import cn.acsm.module.service.dal.dataobject.serviceorder.ServiceOrderDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 服务交易单 Service 接口
 *
 * @author smile
 */
public interface ServiceOrderService {

    /**
     * 创建服务交易单
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createOrder(@Valid ServiceOrderCreateReqVO createReqVO);

    /**
     * 更新服务交易单
     *
     * @param updateReqVO 更新信息
     */
    void updateOrder(@Valid ServiceOrderUpdateReqVO updateReqVO);

    /**
     * 删除服务交易单
     *
     * @param id 编号
     */
    void deleteOrder(Long id);

    /**
     * 获得服务交易单
     *
     * @param id 编号
     * @return 服务交易单
     */
    ServiceOrderDO getOrder(Long id);

    /**
     * 获得服务交易单列表
     *
     * @param ids 编号
     * @return 服务交易单列表
     */
    List<ServiceOrderDO> getOrderList(Collection<Long> ids);

    /**
     * 获得服务交易单分页
     *
     * @param pageReqVO 分页查询
     * @return 服务交易单分页
     */
    PageResult<ServiceOrderDO> getOrderPage(ServiceOrderPageReqVO pageReqVO);

    /**
     * 获得服务交易单列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 服务交易单列表
     */
    List<ServiceOrderDO> getOrderList(ServiceOrderExportReqVO exportReqVO);

}
