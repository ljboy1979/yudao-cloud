package cn.acsm.module.production.facility.dal.mysql.info;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.production.facility.dal.dataobject.info.InfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.production.facility.controller.admin.info.vo.*;

/**
 * 设施 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface InfoMapper extends BaseMapperX<InfoDO> {

    default PageResult<InfoDO> selectPage(InfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<InfoDO>()
                .eqIfPresent(InfoDO::getBaseId, reqVO.getBaseId())
                .likeIfPresent(InfoDO::getName, reqVO.getName())
                .eqIfPresent(InfoDO::getFacilityCode, reqVO.getFacilityCode())
                .eqIfPresent(InfoDO::getClassify, reqVO.getClassify())
                .eqIfPresent(InfoDO::getFacilityType, reqVO.getFacilityType())
                .eqIfPresent(InfoDO::getAreaNumber, reqVO.getAreaNumber())
                .eqIfPresent(InfoDO::getMuNumber, reqVO.getMuNumber())
                .eqIfPresent(InfoDO::getLongitude, reqVO.getLongitude())
                .eqIfPresent(InfoDO::getLatitude, reqVO.getLatitude())
                .eqIfPresent(InfoDO::getBdLongitude, reqVO.getBdLongitude())
                .eqIfPresent(InfoDO::getBdLatitude, reqVO.getBdLatitude())
                .eqIfPresent(InfoDO::getCoordinateGroup, reqVO.getCoordinateGroup())
                .eqIfPresent(InfoDO::getOpacity, reqVO.getOpacity())
                .eqIfPresent(InfoDO::getViewColor, reqVO.getViewColor())
                .eqIfPresent(InfoDO::getBorderColor, reqVO.getBorderColor())
                .eqIfPresent(InfoDO::getPlantId, reqVO.getPlantId())
                .eqIfPresent(InfoDO::getCommoditySpec, reqVO.getCommoditySpec())
                .eqIfPresent(InfoDO::getCommodityNum, reqVO.getCommodityNum())
                .likeIfPresent(InfoDO::getPlantName, reqVO.getPlantName())
                .eqIfPresent(InfoDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(InfoDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(InfoDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(InfoDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(InfoDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(InfoDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(InfoDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(InfoDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(InfoDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(InfoDO::getIndustryLabel, reqVO.getIndustryLabel())
                .eqIfPresent(InfoDO::getAddress, reqVO.getAddress())
                .eqIfPresent(InfoDO::getSecondFacilityType, reqVO.getSecondFacilityType())
                .eqIfPresent(InfoDO::getStorageConditions, reqVO.getStorageConditions())
                .eqIfPresent(InfoDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(InfoDO::getCorpName, reqVO.getCorpName())
                .eqIfPresent(InfoDO::getSyncStatus, reqVO.getSyncStatus())
                .eqIfPresent(InfoDO::getTunnelInfoId, reqVO.getTunnelInfoId())
                .eqIfPresent(InfoDO::getAreaId, reqVO.getAreaId())
                .eqIfPresent(InfoDO::getRuralId, reqVO.getRuralId())
                .eqIfPresent(InfoDO::getVillagesAreaId, reqVO.getVillagesAreaId())
                .likeIfPresent(InfoDO::getAreaName, reqVO.getAreaName())
                .likeIfPresent(InfoDO::getRuralName, reqVO.getRuralName())
                .likeIfPresent(InfoDO::getVillagesAreaName, reqVO.getVillagesAreaName())
                .eqIfPresent(InfoDO::getRegionalManagementId, reqVO.getRegionalManagementId())
                .eqIfPresent(InfoDO::getInduFacilityInfoState, reqVO.getInduFacilityInfoState())
                .betweenIfPresent(InfoDO::getExpirationTime, reqVO.getExpirationTime())
                .eqIfPresent(InfoDO::getIndufacilityinfoImage, reqVO.getIndufacilityinfoImage())
                .eqIfPresent(InfoDO::getAreaNumberUnit, reqVO.getAreaNumberUnit())
                .eqIfPresent(InfoDO::getBuilding, reqVO.getBuilding())
                .eqIfPresent(InfoDO::getFloor, reqVO.getFloor())
                .eqIfPresent(InfoDO::getHouseNumber, reqVO.getHouseNumber())
                .betweenIfPresent(InfoDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(InfoDO::getSource, reqVO.getSource())
                .eqIfPresent(InfoDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(InfoDO::getId));
    }

    default List<InfoDO> selectList(InfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<InfoDO>()
                .eqIfPresent(InfoDO::getBaseId, reqVO.getBaseId())
                .likeIfPresent(InfoDO::getName, reqVO.getName())
                .eqIfPresent(InfoDO::getFacilityCode, reqVO.getFacilityCode())
                .eqIfPresent(InfoDO::getClassify, reqVO.getClassify())
                .eqIfPresent(InfoDO::getFacilityType, reqVO.getFacilityType())
                .eqIfPresent(InfoDO::getAreaNumber, reqVO.getAreaNumber())
                .eqIfPresent(InfoDO::getMuNumber, reqVO.getMuNumber())
                .eqIfPresent(InfoDO::getLongitude, reqVO.getLongitude())
                .eqIfPresent(InfoDO::getLatitude, reqVO.getLatitude())
                .eqIfPresent(InfoDO::getBdLongitude, reqVO.getBdLongitude())
                .eqIfPresent(InfoDO::getBdLatitude, reqVO.getBdLatitude())
                .eqIfPresent(InfoDO::getCoordinateGroup, reqVO.getCoordinateGroup())
                .eqIfPresent(InfoDO::getOpacity, reqVO.getOpacity())
                .eqIfPresent(InfoDO::getViewColor, reqVO.getViewColor())
                .eqIfPresent(InfoDO::getBorderColor, reqVO.getBorderColor())
                .eqIfPresent(InfoDO::getPlantId, reqVO.getPlantId())
                .eqIfPresent(InfoDO::getCommoditySpec, reqVO.getCommoditySpec())
                .eqIfPresent(InfoDO::getCommodityNum, reqVO.getCommodityNum())
                .likeIfPresent(InfoDO::getPlantName, reqVO.getPlantName())
                .eqIfPresent(InfoDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(InfoDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(InfoDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(InfoDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(InfoDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(InfoDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(InfoDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(InfoDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(InfoDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(InfoDO::getIndustryLabel, reqVO.getIndustryLabel())
                .eqIfPresent(InfoDO::getAddress, reqVO.getAddress())
                .eqIfPresent(InfoDO::getSecondFacilityType, reqVO.getSecondFacilityType())
                .eqIfPresent(InfoDO::getStorageConditions, reqVO.getStorageConditions())
                .eqIfPresent(InfoDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(InfoDO::getCorpName, reqVO.getCorpName())
                .eqIfPresent(InfoDO::getSyncStatus, reqVO.getSyncStatus())
                .eqIfPresent(InfoDO::getTunnelInfoId, reqVO.getTunnelInfoId())
                .eqIfPresent(InfoDO::getAreaId, reqVO.getAreaId())
                .eqIfPresent(InfoDO::getRuralId, reqVO.getRuralId())
                .eqIfPresent(InfoDO::getVillagesAreaId, reqVO.getVillagesAreaId())
                .likeIfPresent(InfoDO::getAreaName, reqVO.getAreaName())
                .likeIfPresent(InfoDO::getRuralName, reqVO.getRuralName())
                .likeIfPresent(InfoDO::getVillagesAreaName, reqVO.getVillagesAreaName())
                .eqIfPresent(InfoDO::getRegionalManagementId, reqVO.getRegionalManagementId())
                .eqIfPresent(InfoDO::getInduFacilityInfoState, reqVO.getInduFacilityInfoState())
                .betweenIfPresent(InfoDO::getExpirationTime, reqVO.getExpirationTime())
                .eqIfPresent(InfoDO::getIndufacilityinfoImage, reqVO.getIndufacilityinfoImage())
                .eqIfPresent(InfoDO::getAreaNumberUnit, reqVO.getAreaNumberUnit())
                .eqIfPresent(InfoDO::getBuilding, reqVO.getBuilding())
                .eqIfPresent(InfoDO::getFloor, reqVO.getFloor())
                .eqIfPresent(InfoDO::getHouseNumber, reqVO.getHouseNumber())
                .betweenIfPresent(InfoDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(InfoDO::getSource, reqVO.getSource())
                .eqIfPresent(InfoDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(InfoDO::getId));
    }

}
