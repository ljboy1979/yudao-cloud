package cn.acsm.module.stock.dal.mysql.record;

import cn.acsm.module.stock.controller.admin.record.vo.StockRecordExportReqVO;
import cn.acsm.module.stock.controller.admin.record.vo.StockRecordPageReqVO;
import cn.acsm.module.stock.dal.dataobject.record.StockRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 库存记录 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface StockRecordMapper extends BaseMapperX<StockRecordDO> {

    default PageResult<StockRecordDO> selectPage(StockRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<StockRecordDO>()
                .eqIfPresent(StockRecordDO::getType, reqVO.getType())
                .eqIfPresent(StockRecordDO::getOperationType, reqVO.getOperationType())
                .eqIfPresent(StockRecordDO::getWarehouseId, reqVO.getWarehouseId())
                .eqIfPresent(StockRecordDO::getWarehouseCode, reqVO.getWarehouseCode())
                .likeIfPresent(StockRecordDO::getWarehouseName, reqVO.getWarehouseName())
                .eqIfPresent(StockRecordDO::getBatchNo, reqVO.getBatchNo())
                .betweenIfPresent(StockRecordDO::getOperationTime, reqVO.getOperationTime())
                .eqIfPresent(StockRecordDO::getHeadId, reqVO.getHeadId())
                .likeIfPresent(StockRecordDO::getHeadName, reqVO.getHeadName())
                .betweenIfPresent(StockRecordDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(StockRecordDO::getSubjectId, reqVO.getSubjectId())
                .eqIfPresent(StockRecordDO::getUserId, reqVO.getUserId())
                .eqIfPresent(StockRecordDO::getSourceId, reqVO.getSourceId())
                .orderByDesc(StockRecordDO::getId));
    }

    default List<StockRecordDO> selectList(StockRecordExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<StockRecordDO>()
                .eqIfPresent(StockRecordDO::getType, reqVO.getType())
                .eqIfPresent(StockRecordDO::getOperationType, reqVO.getOperationType())
                .eqIfPresent(StockRecordDO::getWarehouseId, reqVO.getWarehouseId())
                .eqIfPresent(StockRecordDO::getWarehouseCode, reqVO.getWarehouseCode())
                .likeIfPresent(StockRecordDO::getWarehouseName, reqVO.getWarehouseName())
                .eqIfPresent(StockRecordDO::getBatchNo, reqVO.getBatchNo())
                .betweenIfPresent(StockRecordDO::getOperationTime, reqVO.getOperationTime())
                .eqIfPresent(StockRecordDO::getHeadId, reqVO.getHeadId())
                .likeIfPresent(StockRecordDO::getHeadName, reqVO.getHeadName())
                .betweenIfPresent(StockRecordDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(StockRecordDO::getSubjectId, reqVO.getSubjectId())
                .eqIfPresent(StockRecordDO::getUserId, reqVO.getUserId())
                .eqIfPresent(StockRecordDO::getSourceId, reqVO.getSourceId())
                .orderByDesc(StockRecordDO::getId));
    }

}
