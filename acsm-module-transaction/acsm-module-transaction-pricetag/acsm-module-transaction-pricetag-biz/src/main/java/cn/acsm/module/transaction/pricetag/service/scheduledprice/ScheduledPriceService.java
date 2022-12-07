package cn.acsm.module.transaction.pricetag.service.scheduledprice;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.pricetag.controller.admin.scheduledprice.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.scheduledprice.ScheduledPriceDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 预定价格 Service 接口
 *
 * @author 芋道源码
 */
public interface ScheduledPriceService {

    /**
     * 创建预定价格
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createScheduledPrice(@Valid ScheduledPriceCreateReqVO createReqVO);

    /**
     * 更新预定价格
     *
     * @param updateReqVO 更新信息
     */
    void updateScheduledPrice(@Valid ScheduledPriceUpdateReqVO updateReqVO);

    /**
     * 删除预定价格
     *
     * @param id 编号
     */
    void deleteScheduledPrice(String id);

    /**
     * 获得预定价格
     *
     * @param id 编号
     * @return 预定价格
     */
    ScheduledPriceDO getScheduledPrice(String id);

    /**
     * 获得预定价格列表
     *
     * @param ids 编号
     * @return 预定价格列表
     */
    List<ScheduledPriceDO> getScheduledPriceList(Collection<String> ids);

    /**
     * 获得预定价格分页
     *
     * @param pageReqVO 分页查询
     * @return 预定价格分页
     */
    PageResult<ScheduledPriceDO> getScheduledPricePage(ScheduledPricePageReqVO pageReqVO);

    /**
     * 获得预定价格列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 预定价格列表
     */
    List<ScheduledPriceDO> getScheduledPriceList(ScheduledPriceExportReqVO exportReqVO);

}
