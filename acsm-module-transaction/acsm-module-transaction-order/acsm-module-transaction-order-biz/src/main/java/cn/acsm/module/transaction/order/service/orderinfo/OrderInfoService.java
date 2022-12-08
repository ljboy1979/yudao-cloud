package cn.acsm.module.transaction.order.service.orderinfo;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.order.controller.admin.orderinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.orderinfo.OrderInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 订单 Service 接口
 *
 * @author 芋道源码
 */
public interface OrderInfoService {

    /**
     * 创建订单
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createInfo(@Valid OrderInfoCreateReqVO createReqVO);

    /**
     * 更新订单
     *
     * @param updateReqVO 更新信息
     */
    void updateInfo(@Valid OrderInfoUpdateReqVO updateReqVO);

    /**
     * 删除订单
     *
     * @param id 编号
     */
    void deleteInfo(String id);

    /**
     * 获得订单
     *
     * @param id 编号
     * @return 订单
     */
    OrderInfoDO getInfo(String id);

    /**
     * 获得订单列表
     *
     * @param ids 编号
     * @return 订单列表
     */
    List<OrderInfoDO> getInfoList(Collection<String> ids);

    /**
     * 获得订单分页
     *
     * @param pageReqVO 分页查询
     * @return 订单分页
     */
    PageResult<OrderInfoDO> getInfoPage(OrderInfoPageReqVO pageReqVO);

    /**
     * 获得订单列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 订单列表
     */
    List<OrderInfoDO> getInfoList(OrderInfoExportReqVO exportReqVO);

}
