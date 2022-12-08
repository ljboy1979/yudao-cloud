package cn.acsm.module.transaction.order.service.reserveinfo;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.order.controller.admin.reserveinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.reserveinfo.ReserveInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 预定订单 Service 接口
 *
 * @author 芋道源码
 */
public interface ReserveInfoService {

    /**
     * 创建预定订单
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createReserveInfo(@Valid ReserveInfoCreateReqVO createReqVO);

    /**
     * 更新预定订单
     *
     * @param updateReqVO 更新信息
     */
    void updateReserveInfo(@Valid ReserveInfoUpdateReqVO updateReqVO);

    /**
     * 删除预定订单
     *
     * @param id 编号
     */
    void deleteReserveInfo(String id);

    /**
     * 获得预定订单
     *
     * @param id 编号
     * @return 预定订单
     */
    ReserveInfoDO getReserveInfo(String id);

    /**
     * 获得预定订单列表
     *
     * @param ids 编号
     * @return 预定订单列表
     */
    List<ReserveInfoDO> getReserveInfoList(Collection<String> ids);

    /**
     * 获得预定订单分页
     *
     * @param pageReqVO 分页查询
     * @return 预定订单分页
     */
    PageResult<ReserveInfoDO> getReserveInfoPage(ReserveInfoPageReqVO pageReqVO);

    /**
     * 获得预定订单列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 预定订单列表
     */
    List<ReserveInfoDO> getReserveInfoList(ReserveInfoExportReqVO exportReqVO);

}
