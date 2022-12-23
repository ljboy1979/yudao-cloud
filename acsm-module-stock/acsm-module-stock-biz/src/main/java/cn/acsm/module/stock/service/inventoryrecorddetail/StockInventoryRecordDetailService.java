package cn.acsm.module.stock.service.inventoryrecorddetail;

import cn.acsm.module.stock.controller.admin.inventoryrecorddetail.vo.*;
import cn.acsm.module.stock.dal.dataobject.inventoryrecorddetail.StockInventoryRecordDetailDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 盘点记录表子表-明细 Service 接口
 *
 * @author 芋道源码
 */
public interface StockInventoryRecordDetailService {

    /**
     * 创建盘点记录表子表-明细
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createInventoryRecordDetail(@Valid StockInventoryRecordDetailCreateReqVO createReqVO);

    /**
     * 更新盘点记录表子表-明细
     *
     * @param updateReqVO 更新信息
     */
    void updateInventoryRecordDetail(@Valid StockInventoryRecordDetailUpdateReqVO updateReqVO);

    /**
     * 删除盘点记录表子表-明细
     *
     * @param id 编号
     */
    void deleteInventoryRecordDetail(Long id);

    /**
     * 获得盘点记录表子表-明细
     *
     * @param id 编号
     * @return 盘点记录表子表-明细
     */
    StockInventoryRecordDetailDO getInventoryRecordDetail(Long id);

    /**
     * 获得盘点记录表子表-明细列表
     *
     * @param ids 编号
     * @return 盘点记录表子表-明细列表
     */
    List<StockInventoryRecordDetailDO> getInventoryRecordDetailList(Collection<Long> ids);

    /**
     * 获得盘点记录表子表-明细分页
     *
     * @param pageReqVO 分页查询
     * @return 盘点记录表子表-明细分页
     */
    PageResult<StockInventoryRecordDetailDO> getInventoryRecordDetailPage(StockInventoryRecordDetailPageReqVO pageReqVO);

    /**
     * 获得盘点记录表子表-明细列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 盘点记录表子表-明细列表
     */
    List<StockInventoryRecordDetailDO> getInventoryRecordDetailList(StockInventoryRecordDetailExportReqVO exportReqVO);

    /**
     * 3.7.2.17.根据盘点记录id或批次号查询盘点明细
     *
     * @param pageReqVO 分页查询
     * @return 盘点记录表子表-明细分页
     */
    Page<StockInventoryRecordDetailDO> getInventoryRecordDetailPage(StockInventoryRecordDetailPageVO pageReqVO);

}
