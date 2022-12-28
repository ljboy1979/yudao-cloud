package cn.acsm.module.stock.service.record;

import cn.acsm.module.stock.controller.admin.record.vo.*;
import cn.acsm.module.stock.dal.dataobject.record.StockRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 库存记录 Service 接口
 *
 * @author 芋道源码
 */
public interface StockRecordService {

    /**
     * 3.7.2.9.创建入库记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createRecordWarehousing(@Valid StockRecordCreateReqVO createReqVO);

    /**
     * 3.7.2.10.创建出库记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createRecordIssue(@Valid StockRecordCreateReqVO createReqVO);

    /**
     * 更新库存记录
     *
     * @param updateReqVO 更新信息
     */
    void updateRecord(@Valid StockRecordUpdateReqVO updateReqVO);

    /**
     * 3.7.2.18.删除入库记录单
     *
     * @param id 编号
     */
    void deleteRecord(Long id);

    /**
     * 获得库存记录
     *
     * @param id 编号
     * @return 库存记录
     */
    StockRecordDO getRecord(Long id);

    /**
     * 获得库存记录列表
     *
     * @param ids 编号
     * @return 库存记录列表
     */
    List<StockRecordDO> getRecordList(Collection<Long> ids);

    /**
     * 获得库存记录分页
     *
     * @param pageReqVO 分页查询
     * @return 库存记录分页
     */
    Page<StockRecordFeignVO> getRecordPage(StockRecordPageReqVO pageReqVO);

    /**
     * 获得库存记录列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 库存记录列表
     */
    List<StockRecordDO> getRecordList(StockRecordExportReqVO exportReqVO);

    /**
     * 3.7.2.14.查询出/入库记录
     *
     * @param pageReqVO 分页查询
     * @return 库存记录分页
     */
    Page<StockRecordDO> getRecordOutEnterPage(StockRecordOutEnterVO pageReqVO);

}
