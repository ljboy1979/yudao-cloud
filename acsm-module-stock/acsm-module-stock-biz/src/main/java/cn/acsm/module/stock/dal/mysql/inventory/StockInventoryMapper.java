package cn.acsm.module.stock.dal.mysql.inventory;

import cn.acsm.module.stock.api.inventory.qo.InventoryQO;
import cn.acsm.module.stock.api.inventory.vo.StockInventoryApiReqVO;
import cn.acsm.module.stock.controller.admin.inventory.vo.StockInventoryExportReqVO;
import cn.acsm.module.stock.controller.admin.inventory.vo.StockInventoryPageReqVO;
import cn.acsm.module.stock.dal.dataobject.inventory.StockInventoryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 库存清单 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface StockInventoryMapper extends BaseMapperX<StockInventoryDO> {

    default PageResult<StockInventoryDO> selectPage(StockInventoryPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<StockInventoryDO>()
                .eqIfPresent(StockInventoryDO::getType, reqVO.getType())
                .eqIfPresent(StockInventoryDO::getWarehouseId, reqVO.getWarehouseId())
                .eqIfPresent(StockInventoryDO::getWarehouseCode, reqVO.getWarehouseCode())
                .likeIfPresent(StockInventoryDO::getWarehouseName, reqVO.getWarehouseName())
                .eqIfPresent(StockInventoryDO::getWarehouseType, reqVO.getWarehouseType())
                .eqIfPresent(StockInventoryDO::getGoodsId, reqVO.getGoodsId())
                .eqIfPresent(StockInventoryDO::getGoodsNumber, reqVO.getGoodsNumber())
                .likeIfPresent(StockInventoryDO::getGoodsName, reqVO.getGoodsName())
                .eqIfPresent(StockInventoryDO::getGoodsType, reqVO.getGoodsType())
                .eqIfPresent(StockInventoryDO::getPackagingType, reqVO.getPackagingType())
                .eqIfPresent(StockInventoryDO::getPackagingSpecificationId, reqVO.getPackagingSpecificationId())
                .eqIfPresent(StockInventoryDO::getPackingSpecification, reqVO.getPackingSpecification())
                .eqIfPresent(StockInventoryDO::getInventoryQuantity, reqVO.getInventoryQuantity())
                .eqIfPresent(StockInventoryDO::getMeasureUnit, reqVO.getMeasureUnit())
                .eqIfPresent(StockInventoryDO::getUpperWarningLimit, reqVO.getUpperWarningLimit())
                .eqIfPresent(StockInventoryDO::getLowerWarningLimit, reqVO.getLowerWarningLimit())
                .betweenIfPresent(StockInventoryDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(StockInventoryDO::getSubjectId, reqVO.getSubjectId())
                .eqIfPresent(StockInventoryDO::getUserId, reqVO.getUserId())
                .eqIfPresent(StockInventoryDO::getSourceId, reqVO.getSourceId())
                .orderByDesc(StockInventoryDO::getId));
    }

    default List<StockInventoryDO> selectList(StockInventoryExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<StockInventoryDO>()
                .eqIfPresent(StockInventoryDO::getType, reqVO.getType())
                .eqIfPresent(StockInventoryDO::getWarehouseId, reqVO.getWarehouseId())
                .eqIfPresent(StockInventoryDO::getWarehouseCode, reqVO.getWarehouseCode())
                .likeIfPresent(StockInventoryDO::getWarehouseName, reqVO.getWarehouseName())
                .eqIfPresent(StockInventoryDO::getWarehouseType, reqVO.getWarehouseType())
                .eqIfPresent(StockInventoryDO::getGoodsId, reqVO.getGoodsId())
                .eqIfPresent(StockInventoryDO::getGoodsNumber, reqVO.getGoodsNumber())
                .likeIfPresent(StockInventoryDO::getGoodsName, reqVO.getGoodsName())
                .eqIfPresent(StockInventoryDO::getGoodsType, reqVO.getGoodsType())
                .eqIfPresent(StockInventoryDO::getPackagingType, reqVO.getPackagingType())
                .eqIfPresent(StockInventoryDO::getPackagingSpecificationId, reqVO.getPackagingSpecificationId())
                .eqIfPresent(StockInventoryDO::getPackingSpecification, reqVO.getPackingSpecification())
                .eqIfPresent(StockInventoryDO::getInventoryQuantity, reqVO.getInventoryQuantity())
                .eqIfPresent(StockInventoryDO::getMeasureUnit, reqVO.getMeasureUnit())
                .eqIfPresent(StockInventoryDO::getUpperWarningLimit, reqVO.getUpperWarningLimit())
                .eqIfPresent(StockInventoryDO::getLowerWarningLimit, reqVO.getLowerWarningLimit())
                .betweenIfPresent(StockInventoryDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(StockInventoryDO::getSubjectId, reqVO.getSubjectId())
                .eqIfPresent(StockInventoryDO::getUserId, reqVO.getUserId())
                .eqIfPresent(StockInventoryDO::getSourceId, reqVO.getSourceId())
                .orderByDesc(StockInventoryDO::getId));
    }

    // 远程调用获取数据
    /**
     * 批量获取数据
     * @param qo
     * @return
     */
    List<StockInventoryApiReqVO> getList(@Param("qo") InventoryQO qo);

}
