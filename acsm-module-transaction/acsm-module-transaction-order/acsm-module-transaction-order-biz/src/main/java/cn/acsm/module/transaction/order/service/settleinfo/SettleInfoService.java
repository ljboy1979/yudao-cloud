package cn.acsm.module.transaction.order.service.settleinfo;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.order.controller.admin.settleinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.settleinfo.SettleInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 订单结账 Service 接口
 *
 * @author 芋道源码
 */
public interface SettleInfoService {

    /**
     * 创建订单结账
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createSettleInfo(@Valid SettleInfoCreateReqVO createReqVO);

    /**
     * 更新订单结账
     *
     * @param updateReqVO 更新信息
     */
    void updateSettleInfo(@Valid SettleInfoUpdateReqVO updateReqVO);

    /**
     * 删除订单结账
     *
     * @param id 编号
     */
    void deleteSettleInfo(String id);

    /**
     * 获得订单结账
     *
     * @param id 编号
     * @return 订单结账
     */
    SettleInfoDO getSettleInfo(String id);

    /**
     * 获得订单结账列表
     *
     * @param ids 编号
     * @return 订单结账列表
     */
    List<SettleInfoDO> getSettleInfoList(Collection<String> ids);

    /**
     * 获得订单结账分页
     *
     * @param pageReqVO 分页查询
     * @return 订单结账分页
     */
    PageResult<SettleInfoDO> getSettleInfoPage(SettleInfoPageReqVO pageReqVO);

    /**
     * 获得订单结账列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 订单结账列表
     */
    List<SettleInfoDO> getSettleInfoList(SettleInfoExportReqVO exportReqVO);

}
