package cn.acsm.module.transaction.order.service.deliverydetails;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.order.controller.admin.deliverydetails.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.deliverydetails.DeliveryDetailsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 配送详情 Service 接口
 *
 * @author 芋道源码
 */
public interface DeliveryDetailsService {

    /**
     * 创建配送详情
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createDeliveryDetails(@Valid DeliveryDetailsCreateReqVO createReqVO);

    /**
     * 更新配送详情
     *
     * @param updateReqVO 更新信息
     */
    void updateDeliveryDetails(@Valid DeliveryDetailsUpdateReqVO updateReqVO);

    /**
     * 删除配送详情
     *
     * @param id 编号
     */
    void deleteDeliveryDetails(String id);

    /**
     * 获得配送详情
     *
     * @param id 编号
     * @return 配送详情
     */
    DeliveryDetailsDO getDeliveryDetails(String id);

    /**
     * 获得配送详情列表
     *
     * @param ids 编号
     * @return 配送详情列表
     */
    List<DeliveryDetailsDO> getDeliveryDetailsList(Collection<String> ids);

    /**
     * 获得配送详情分页
     *
     * @param pageReqVO 分页查询
     * @return 配送详情分页
     */
    PageResult<DeliveryDetailsDO> getDeliveryDetailsPage(DeliveryDetailsPageReqVO pageReqVO);

    /**
     * 获得配送详情列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 配送详情列表
     */
    List<DeliveryDetailsDO> getDeliveryDetailsList(DeliveryDetailsExportReqVO exportReqVO);

}
