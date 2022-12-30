package cn.acsm.module.stock.dal.mysql.inventoryrecord;

import cn.acsm.module.stock.controller.admin.inventoryrecord.vo.StockInventoryRecordExportReqVO;
import cn.acsm.module.stock.controller.admin.inventoryrecord.vo.StockInventoryRecordPageReqVO;
import cn.acsm.module.stock.dal.dataobject.inventoryrecord.StockInventoryRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 盘点记录 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface StockInventoryRecordMapper extends BaseMapperX<StockInventoryRecordDO> {

    default PageResult<StockInventoryRecordDO> selectPage(StockInventoryRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<StockInventoryRecordDO>()
                .eqIfPresent(StockInventoryRecordDO::getType, reqVO.getType())
                .eqIfPresent(StockInventoryRecordDO::getWarehouseId, reqVO.getWarehouseId())
                .eqIfPresent(StockInventoryRecordDO::getWarehouseCode, reqVO.getWarehouseCode())
                .likeIfPresent(StockInventoryRecordDO::getWarehouseName, reqVO.getWarehouseName())
                .eqIfPresent(StockInventoryRecordDO::getInventoryCode, reqVO.getInventoryCode())
                .eqIfPresent(StockInventoryRecordDO::getHeadId, reqVO.getHeadId())
                .likeIfPresent(StockInventoryRecordDO::getHeadName, reqVO.getHeadName())
                .betweenIfPresent(StockInventoryRecordDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(StockInventoryRecordDO::getSubjectId, reqVO.getSubjectId())
                .eqIfPresent(StockInventoryRecordDO::getUserId, reqVO.getUserId())
                .eqIfPresent(StockInventoryRecordDO::getSourceId, reqVO.getSourceId())
                .orderByDesc(StockInventoryRecordDO::getId));
    }

    default List<StockInventoryRecordDO> selectList(StockInventoryRecordExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<StockInventoryRecordDO>()
                .eqIfPresent(StockInventoryRecordDO::getType, reqVO.getType())
                .eqIfPresent(StockInventoryRecordDO::getWarehouseId, reqVO.getWarehouseId())
                .eqIfPresent(StockInventoryRecordDO::getWarehouseCode, reqVO.getWarehouseCode())
                .likeIfPresent(StockInventoryRecordDO::getWarehouseName, reqVO.getWarehouseName())
                .eqIfPresent(StockInventoryRecordDO::getInventoryCode, reqVO.getInventoryCode())
                .betweenIfPresent(StockInventoryRecordDO::getOperationTime, reqVO.getOperationTime())
                .eqIfPresent(StockInventoryRecordDO::getHeadId, reqVO.getHeadId())
                .likeIfPresent(StockInventoryRecordDO::getHeadName, reqVO.getHeadName())
                .betweenIfPresent(StockInventoryRecordDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(StockInventoryRecordDO::getSubjectId, reqVO.getSubjectId())
                .eqIfPresent(StockInventoryRecordDO::getUserId, reqVO.getUserId())
                .eqIfPresent(StockInventoryRecordDO::getSourceId, reqVO.getSourceId())
                .orderByDesc(StockInventoryRecordDO::getId));
    }

}
