package cn.acsm.module.stock.service.recorddetail;

import cn.acsm.module.stock.controller.admin.recorddetail.vo.*;
import cn.acsm.module.stock.dal.dataobject.recorddetail.StockRecordDetailDO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 库存记录字表-明细 Service 接口
 *
 * @author 芋道源码
 */
public interface StockRecordDetailService {

    /**
     * 创建库存记录字表-明细
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createRecordDetail(@Valid StockRecordDetailCreateReqVO createReqVO);

    /**
     * 更新库存记录字表-明细
     *
     * @param updateReqVO 更新信息
     */
    void updateRecordDetail(@Valid StockRecordDetailUpdateReqVO updateReqVO);

    /**
     * 删除库存记录字表-明细
     *
     * @param id 编号
     */
    void deleteRecordDetail(Long id);

    /**
     * 获得库存记录字表-明细
     *
     * @param id 编号
     * @return 库存记录字表-明细
     */
    StockRecordDetailDO getRecordDetail(Long id);

    /**
     * 获得库存记录字表-明细列表
     *
     * @param ids 编号
     * @return 库存记录字表-明细列表
     */
    List<StockRecordDetailDO> getRecordDetailList(Collection<Long> ids);

    /**
     * 3.7.2.11.获取入库货品及现有库存量
     * @param pageReqVO 分页查询
     * @return
     */
    Page<StockRecordDetailDO> getRecordDetailPage(StockRecordDetailPageReqVO pageReqVO);

    /**
     * 获取出入库记录详情
     * @param pageReqVO 分页查询
     * @return
     */
    Page<StockRecordDetailDO> getRecordDetailOutPage(StockRecordDetailPageInOutVO pageReqVO);

    /**
     * 获得库存记录字表-明细列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 库存记录字表-明细列表
     */
    List<StockRecordDetailDO> getRecordDetailList(StockRecordDetailExportReqVO exportReqVO);

    /**
     * 获得库存记录字表-明细列表, 用于连接打印机打印
     *
     * @param printVO 查询条件
     * @return 库存记录字表-明细列表
     */
    List<StockRecordDetailPrintRespVO> getRecordDetailList(StockRecordDetailPrintVO printVO);

    /**
     * 3.7.2.13.修改出/入库记录
     *
     * @param updateReqVO 更新信息
     */
    void updateRecordDetailOutEnter(@Valid StockRecordDetailOutEnterVO updateReqVO);

    /**
     * 3.7.2.15.根据出入库id或批次号查询出入库明细
     * @param pageReqVO 分页查询
     * @return
     */
    Page<StockRecordDetailRespVO> getRecordDetailPage(StockRecordDetailPageVO pageReqVO);

    /**
     * 3.7.2.20.临期时间管理
     * @param pageReqVO 分页查询
     * @return
     */
    Page<StockRecordDetailDO> getRecordDetailPage(StockRecordTempPageVO pageReqVO);
}
