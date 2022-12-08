package cn.acsm.module.transaction.order.service.reservedetails;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.order.controller.admin.reservedetails.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.reservedetails.ReserveDetailsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 订单预定详情 Service 接口
 *
 * @author 芋道源码
 */
public interface ReserveDetailsService {

    /**
     * 创建订单预定详情
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createReserveDetails(@Valid ReserveDetailsCreateReqVO createReqVO);

    /**
     * 更新订单预定详情
     *
     * @param updateReqVO 更新信息
     */
    void updateReserveDetails(@Valid ReserveDetailsUpdateReqVO updateReqVO);

    /**
     * 删除订单预定详情
     *
     * @param id 编号
     */
    void deleteReserveDetails(String id);

    /**
     * 获得订单预定详情
     *
     * @param id 编号
     * @return 订单预定详情
     */
    ReserveDetailsDO getReserveDetails(String id);

    /**
     * 获得订单预定详情列表
     *
     * @param ids 编号
     * @return 订单预定详情列表
     */
    List<ReserveDetailsDO> getReserveDetailsList(Collection<String> ids);

    /**
     * 获得订单预定详情分页
     *
     * @param pageReqVO 分页查询
     * @return 订单预定详情分页
     */
    PageResult<ReserveDetailsDO> getReserveDetailsPage(ReserveDetailsPageReqVO pageReqVO);

    /**
     * 获得订单预定详情列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 订单预定详情列表
     */
    List<ReserveDetailsDO> getReserveDetailsList(ReserveDetailsExportReqVO exportReqVO);

}
