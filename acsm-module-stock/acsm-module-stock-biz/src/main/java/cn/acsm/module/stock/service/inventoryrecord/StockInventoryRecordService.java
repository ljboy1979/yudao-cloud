package cn.acsm.module.stock.service.inventoryrecord;

import cn.acsm.module.stock.controller.admin.inventoryrecord.vo.*;
import cn.acsm.module.stock.dal.dataobject.inventoryrecord.StockInventoryRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 盘点记录 Service 接口
 *
 * @author 芋道源码
 */
public interface StockInventoryRecordService {

    /**
     * 创建盘点记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createInventoryRecord(@Valid StockInventoryRecordCreateReqVO createReqVO);

    /**
     * 更新盘点记录
     *
     * @param updateReqVO 更新信息
     */
    void updateInventoryRecord(@Valid StockInventoryRecordUpdateReqVO updateReqVO);

    /**
     * 删除盘点记录
     *
     * @param id 编号
     */
    void deleteInventoryRecord(Long id);

    /**
     * 获得盘点记录
     *
     * @param id 编号
     * @return 盘点记录
     */
    StockInventoryRecordDO getInventoryRecord(Long id);

    /**
     * 获得盘点记录列表
     *
     * @param ids 编号
     * @return 盘点记录列表
     */
    List<StockInventoryRecordDO> getInventoryRecordList(Collection<Long> ids);

    /**
     * 获得盘点记录分页
     *
     * @param pageReqVO 分页查询
     * @return 盘点记录分页
     */
    PageResult<StockInventoryRecordDO> getInventoryRecordPage(StockInventoryRecordPageReqVO pageReqVO);

    /**
     * 获得盘点记录列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 盘点记录列表
     */
    List<StockInventoryRecordDO> getInventoryRecordList(StockInventoryRecordExportReqVO exportReqVO);

    /**
     * 3.7.2.16.查询盘点记录
     *
     * @param pageReqVO 分页查询
     * @return 盘点记录分页
     */
    Page<StockInventoryRecordDO> getInventoryRecordPage(StockInventoryRecordPageVO pageReqVO);

}
