package cn.acsm.module.transaction.sales.dal.mysql.commodity;

import java.util.*;

import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import cn.acsm.module.transaction.sales.dal.dataobject.commodity.CommodityCustomDO;
import cn.acsm.module.transaction.sales.dal.dataobject.commodity.CommodityDO;
import cn.acsm.module.transaction.sales.dal.dataobject.shelves.ShelvesSalesRespDo;
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
                .likeIfPresent(CommodityDO::getCommodityName, reqVO.getCommodityName())
                .eqIfPresent(CommodityDO::getCommodityCategoryId, reqVO.getCommodityCategoryId())
                .betweenIfPresent(CommodityDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(CommodityDO::getCreateTime));
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

    default Long findSelectCount(CommodityDO commodityDO) {
        return selectCount(new LambdaQueryWrapperX<CommodityDO>()
                .eqIfPresent(CommodityDO::getCommodityCode, commodityDO.getCommodityCode())
                .eqIfPresent(CommodityDO::getArticleNo, commodityDO.getArticleNo())
                .eqIfPresent(CommodityDO::getCommodityBarCode, commodityDO.getCommodityBarCode())
                .eqIfPresent(CommodityDO::getCommodityName, commodityDO.getCommodityName())
                .eqIfPresent(CommodityDO::getType, commodityDO.getType())
                .eqIfPresent(CommodityDO::getSort, commodityDO.getSort())
                .eqIfPresent(CommodityDO::getKeyWord, commodityDO.getKeyWord())
                .eqIfPresent(CommodityDO::getManufacturer, commodityDO.getManufacturer())
                .eqIfPresent(CommodityDO::getBatch, commodityDO.getBatch())
                .eqIfPresent(CommodityDO::getAvailableNum, commodityDO.getAvailableNum())
                .likeIfPresent(CommodityDO::getProviderName, commodityDO.getProviderName())
                .eqIfPresent(CommodityDO::getProviderId, commodityDO.getProviderId())
                .eqIfPresent(CommodityDO::getOldProviderId, commodityDO.getOldProviderId())
                .eqIfPresent(CommodityDO::getSpecNum, commodityDO.getSpecNum())
                .eqIfPresent(CommodityDO::getLableIds, commodityDO.getLableIds())
                .eqIfPresent(CommodityDO::getWarnStockNum, commodityDO.getWarnStockNum())
                .eqIfPresent(CommodityDO::getWeightUnit, commodityDO.getWeightUnit())
                .eqIfPresent(CommodityDO::getPackageUnit, commodityDO.getPackageUnit())
                .eqIfPresent(CommodityDO::getCommodityCategoryId, commodityDO.getCommodityCategoryId())
                .likeIfPresent(CommodityDO::getManufacturerName, commodityDO.getManufacturerName())
                .eqIfPresent(CommodityDO::getWholesalePrice, commodityDO.getWholesalePrice())
                .eqIfPresent(CommodityDO::getRetailPrice, commodityDO.getRetailPrice())
                .eqIfPresent(CommodityDO::getStockNum, commodityDO.getStockNum())
                .eqIfPresent(CommodityDO::getSaleState, commodityDO.getSaleState())
                .eqIfPresent(CommodityDO::getIntroduction, commodityDO.getIntroduction())
                .eqIfPresent(CommodityDO::getTraceStatus, commodityDO.getTraceStatus())
                .eqIfPresent(CommodityDO::getPlantId, commodityDO.getPlantId())
                .eqIfPresent(CommodityDO::getCommodityPlantId, commodityDO.getCommodityPlantId())
                .eqIfPresent(CommodityDO::getSellType, commodityDO.getSellType())
                .eqIfPresent(CommodityDO::getAddType, commodityDO.getAddType())
                .eqIfPresent(CommodityDO::getAddress, commodityDO.getAddress())
                .eqIfPresent(CommodityDO::getNum, commodityDO.getNum())
                .eqIfPresent(CommodityDO::getSyncStatus, commodityDO.getSyncStatus())
                .eqIfPresent(CommodityDO::getCommodityType, commodityDO.getCommodityType())
                .eqIfPresent(CommodityDO::getCommodityImg, commodityDO.getCommodityImg())
                .eqIfPresent(CommodityDO::getPublicityPrice, commodityDO.getPublicityPrice())
                .eqIfPresent(CommodityDO::getProductionAddress, commodityDO.getProductionAddress())
                .eqIfPresent(CommodityDO::getOriginPlace, commodityDO.getOriginPlace())
                .likeIfPresent(CommodityDO::getAntName, commodityDO.getAntName())
                .eqIfPresent(CommodityDO::getCreateId, commodityDO.getCreateId())
                .eqIfPresent(CommodityDO::getVideoUrl, commodityDO.getVideoUrl())
                .eqIfPresent(CommodityDO::getStatus, commodityDO.getStatus())
                .notIn(CommodityDO::getId,commodityDO.getId())
                .orderByDesc(CommodityDO::getId));
    }

    List<ShelvesSalesRespDo> findSales(ShelvesSalesReqDto shelvesSalesReqDto);

    List<ShelvesSalesRespDo> findSpecifications(ShelvesSalesReqDto shelvesSalesReqDto);

    CommodityCustomDO getCommodityById(String id);
}
