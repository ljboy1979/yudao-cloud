package cn.acsm.module.transaction.order.service.deliveryinfo;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.order.controller.admin.deliveryinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.deliveryinfo.DeliveryInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 配送 Service 接口
 *
 * @author 芋道源码
 */
public interface DeliveryInfoService {

    /**
     * 创建配送
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createDeliveryInfo(@Valid DeliveryInfoCreateReqVO createReqVO);

    /**
     * 更新配送
     *
     * @param updateReqVO 更新信息
     */
    void updateDeliveryInfo(@Valid DeliveryInfoUpdateReqVO updateReqVO);

    /**
     * 删除配送
     *
     * @param id 编号
     */
    void deleteDeliveryInfo(String id);

    /**
     * 获得配送
     *
     * @param id 编号
     * @return 配送
     */
    DeliveryInfoDO getDeliveryInfo(String id);

    /**
     * 获得配送列表
     *
     * @param ids 编号
     * @return 配送列表
     */
    List<DeliveryInfoDO> getDeliveryInfoList(Collection<String> ids);

    /**
     * 获得配送分页
     *
     * @param pageReqVO 分页查询
     * @return 配送分页
     */
    PageResult<DeliveryInfoDO> getDeliveryInfoPage(DeliveryInfoPageReqVO pageReqVO);

    /**
     * 获得配送列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 配送列表
     */
    List<DeliveryInfoDO> getDeliveryInfoList(DeliveryInfoExportReqVO exportReqVO);

}
