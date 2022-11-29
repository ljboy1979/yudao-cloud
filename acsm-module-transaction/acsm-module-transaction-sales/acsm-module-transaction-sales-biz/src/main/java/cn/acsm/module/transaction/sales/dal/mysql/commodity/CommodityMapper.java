package cn.acsm.module.transaction.sales.dal.mysql.commodity;

import java.util.*;

import cn.acsm.module.transaction.sales.dal.dataobject.commodity.CommodityDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.sales.dal.dataobject.commodity.CommodityDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.*;

/**
 * 商品 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface CommodityMapper extends BaseMapperX<CommodityDO> {

    default PageResult<CommodityDO> selectPage(CommodityPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CommodityDO>()
                .eqIfPresent(CommodityDO::getCommodityCode, reqVO.getCommodityCode())
                .eqIfPresent(CommodityDO::getArticleNo, reqVO.getArticleNo())
                .eqIfPresent(CommodityDO::getCommodityBarCode, reqVO.getCommodityBarCode())
                .likeIfPresent(CommodityDO::getCommodityName, reqVO.getCommodityName())
                .eqIfPresent(CommodityDO::getType, reqVO.getType())
                .eqIfPresent(CommodityDO::getSort, reqVO.getSort())
                .eqIfPresent(CommodityDO::getKeyWord, reqVO.getKeyWord())
                .eqIfPresent(CommodityDO::getManufacturer, reqVO.getManufacturer())
                .eqIfPresent(CommodityDO::getBatch, reqVO.getBatch())
                .eqIfPresent(CommodityDO::getAvailableNum, reqVO.getAvailableNum())
                .likeIfPresent(CommodityDO::getProviderName, reqVO.getProviderName())
                .eqIfPresent(CommodityDO::getProviderId, reqVO.getProviderId())
                .eqIfPresent(CommodityDO::getOldProviderId, reqVO.getOldProviderId())
                .eqIfPresent(CommodityDO::getSpecNum, reqVO.getSpecNum())
                .eqIfPresent(CommodityDO::getLableIds, reqVO.getLableIds())
                .eqIfPresent(CommodityDO::getWarnStockNum, reqVO.getWarnStockNum())
                .eqIfPresent(CommodityDO::getWeightUnit, reqVO.getWeightUnit())
                .eqIfPresent(CommodityDO::getPackageUnit, reqVO.getPackageUnit())
                .eqIfPresent(CommodityDO::getCommodityCategoryId, reqVO.getCommodityCategoryId())
                .likeIfPresent(CommodityDO::getManufacturerName, reqVO.getManufacturerName())
                .eqIfPresent(CommodityDO::getWholesalePrice, reqVO.getWholesalePrice())
                .eqIfPresent(CommodityDO::getRetailPrice, reqVO.getRetailPrice())
                .eqIfPresent(CommodityDO::getStockNum, reqVO.getStockNum())
                .eqIfPresent(CommodityDO::getSaleState, reqVO.getSaleState())
                .eqIfPresent(CommodityDO::getIntroduction, reqVO.getIntroduction())
                .eqIfPresent(CommodityDO::getTraceStatus, reqVO.getTraceStatus())
                .eqIfPresent(CommodityDO::getPlantId, reqVO.getPlantId())
                .eqIfPresent(CommodityDO::getCommodityPlantId, reqVO.getCommodityPlantId())
                .eqIfPresent(CommodityDO::getSellType, reqVO.getSellType())
                .eqIfPresent(CommodityDO::getAddType, reqVO.getAddType())
                .eqIfPresent(CommodityDO::getAddress, reqVO.getAddress())
                .eqIfPresent(CommodityDO::getNum, reqVO.getNum())
                .eqIfPresent(CommodityDO::getSyncStatus, reqVO.getSyncStatus())
                .betweenIfPresent(CommodityDO::getArriveDate, reqVO.getArriveDate())
                .eqIfPresent(CommodityDO::getCommodityType, reqVO.getCommodityType())
                .eqIfPresent(CommodityDO::getCommodityImg, reqVO.getCommodityImg())
                .eqIfPresent(CommodityDO::getPublicityPrice, reqVO.getPublicityPrice())
                .eqIfPresent(CommodityDO::getProductionAddress, reqVO.getProductionAddress())
                .eqIfPresent(CommodityDO::getOriginPlace, reqVO.getOriginPlace())
                .likeIfPresent(CommodityDO::getAntName, reqVO.getAntName())
                .eqIfPresent(CommodityDO::getCreateId, reqVO.getCreateId())
                .eqIfPresent(CommodityDO::getVideoUrl, reqVO.getVideoUrl())
                .eqIfPresent(CommodityDO::getStatus, reqVO.getStatus())
                .eqIfPresent(CommodityDO::getExpertAdvice, reqVO.getExpertAdvice())
                .betweenIfPresent(CommodityDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(CommodityDO::getId));
    }

    default List<CommodityDO> selectList(CommodityExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<CommodityDO>()
                .eqIfPresent(CommodityDO::getCommodityCode, reqVO.getCommodityCode())
                .eqIfPresent(CommodityDO::getArticleNo, reqVO.getArticleNo())
                .eqIfPresent(CommodityDO::getCommodityBarCode, reqVO.getCommodityBarCode())
                .likeIfPresent(CommodityDO::getCommodityName, reqVO.getCommodityName())
                .eqIfPresent(CommodityDO::getType, reqVO.getType())
                .eqIfPresent(CommodityDO::getSort, reqVO.getSort())
                .eqIfPresent(CommodityDO::getKeyWord, reqVO.getKeyWord())
                .eqIfPresent(CommodityDO::getManufacturer, reqVO.getManufacturer())
                .eqIfPresent(CommodityDO::getBatch, reqVO.getBatch())
                .eqIfPresent(CommodityDO::getAvailableNum, reqVO.getAvailableNum())
                .likeIfPresent(CommodityDO::getProviderName, reqVO.getProviderName())
                .eqIfPresent(CommodityDO::getProviderId, reqVO.getProviderId())
                .eqIfPresent(CommodityDO::getOldProviderId, reqVO.getOldProviderId())
                .eqIfPresent(CommodityDO::getSpecNum, reqVO.getSpecNum())
                .eqIfPresent(CommodityDO::getLableIds, reqVO.getLableIds())
                .eqIfPresent(CommodityDO::getWarnStockNum, reqVO.getWarnStockNum())
                .eqIfPresent(CommodityDO::getWeightUnit, reqVO.getWeightUnit())
                .eqIfPresent(CommodityDO::getPackageUnit, reqVO.getPackageUnit())
                .eqIfPresent(CommodityDO::getCommodityCategoryId, reqVO.getCommodityCategoryId())
                .likeIfPresent(CommodityDO::getManufacturerName, reqVO.getManufacturerName())
                .eqIfPresent(CommodityDO::getWholesalePrice, reqVO.getWholesalePrice())
                .eqIfPresent(CommodityDO::getRetailPrice, reqVO.getRetailPrice())
                .eqIfPresent(CommodityDO::getStockNum, reqVO.getStockNum())
                .eqIfPresent(CommodityDO::getSaleState, reqVO.getSaleState())
                .eqIfPresent(CommodityDO::getIntroduction, reqVO.getIntroduction())
                .eqIfPresent(CommodityDO::getTraceStatus, reqVO.getTraceStatus())
                .eqIfPresent(CommodityDO::getPlantId, reqVO.getPlantId())
                .eqIfPresent(CommodityDO::getCommodityPlantId, reqVO.getCommodityPlantId())
                .eqIfPresent(CommodityDO::getSellType, reqVO.getSellType())
                .eqIfPresent(CommodityDO::getAddType, reqVO.getAddType())
                .eqIfPresent(CommodityDO::getAddress, reqVO.getAddress())
                .eqIfPresent(CommodityDO::getNum, reqVO.getNum())
                .eqIfPresent(CommodityDO::getSyncStatus, reqVO.getSyncStatus())
                .betweenIfPresent(CommodityDO::getArriveDate, reqVO.getArriveDate())
                .eqIfPresent(CommodityDO::getCommodityType, reqVO.getCommodityType())
                .eqIfPresent(CommodityDO::getCommodityImg, reqVO.getCommodityImg())
                .eqIfPresent(CommodityDO::getPublicityPrice, reqVO.getPublicityPrice())
                .eqIfPresent(CommodityDO::getProductionAddress, reqVO.getProductionAddress())
                .eqIfPresent(CommodityDO::getOriginPlace, reqVO.getOriginPlace())
                .likeIfPresent(CommodityDO::getAntName, reqVO.getAntName())
                .eqIfPresent(CommodityDO::getCreateId, reqVO.getCreateId())
                .eqIfPresent(CommodityDO::getVideoUrl, reqVO.getVideoUrl())
                .eqIfPresent(CommodityDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(CommodityDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(CommodityDO::getId));
    }

}
