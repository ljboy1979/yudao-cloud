package cn.acsm.module.transaction.shelves.service.stockrecord;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.shelves.controller.admin.stockrecord.vo.*;
import cn.acsm.module.transaction.shelves.dal.dataobject.stockrecord.StockRecordDO;
import cn.acsm.module.transaction.shelves.dal.dataobject.stockrecord.StockRecordInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 货架库存记录 Service 接口
 *
 * @author 芋道源码
 */
public interface StockRecordService {

    /**
     * 创建货架库存记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createStockRecord(@Valid StockRecordCreateReqVO createReqVO);

    /**
     * 更新货架库存记录
     *
     * @param updateReqVO 更新信息
     */
    void updateStockRecord(@Valid StockRecordUpdateReqVO updateReqVO);

    /**
     * 删除货架库存记录
     *
     * @param id 编号
     */
    void deleteStockRecord(String id);

    /**
     * 获得货架库存记录
     *
     * @param id 编号
     * @return 货架库存记录
     */
    StockRecordDO getStockRecord(String id);

    /**
     * 获得货架库存记录列表
     *
     * @param ids 编号
     * @return 货架库存记录列表
     */
    List<StockRecordDO> getStockRecordList(Collection<String> ids);

    /**
     * 获得货架库存记录分页
     *
     * @param pageReqVO 分页查询
     * @return 货架库存记录分页
     */
    PageResult<StockRecordDO> getStockRecordPage(StockRecordPageReqVO pageReqVO);

    /**
     * 获得货架库存记录列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 货架库存记录列表
     */
    List<StockRecordDO> getStockRecordList(StockRecordExportReqVO exportReqVO);

    PageResult<StockRecordInfoDO> findStockRecordPage(StockRecordPageReqVO pageVO);
}
