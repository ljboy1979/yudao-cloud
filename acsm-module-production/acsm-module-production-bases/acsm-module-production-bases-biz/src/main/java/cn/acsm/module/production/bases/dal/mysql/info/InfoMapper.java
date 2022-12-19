package cn.acsm.module.production.bases.dal.mysql.info;

import java.util.*;

import cn.acsm.module.production.bases.controller.admin.info.vo.InfoExportReqVO;
import cn.acsm.module.production.bases.controller.admin.info.vo.InfoPageReqVO;
import cn.acsm.module.production.bases.dal.dataobject.info.InfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.production.bases.controller.admin.info.vo.*;

/**
 * 基地信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface InfoMapper extends BaseMapperX<InfoDO> {

    default PageResult<InfoDO> selectPage(InfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<InfoDO>()
                .eqIfPresent(InfoDO::getAreaId, reqVO.getAreaId())
                .likeIfPresent(InfoDO::getAreaName, reqVO.getAreaName())
                .eqIfPresent(InfoDO::getVillagesAreaId, reqVO.getVillagesAreaId())
                .likeIfPresent(InfoDO::getVillagesAreaName, reqVO.getVillagesAreaName())
                .eqIfPresent(InfoDO::getRuralId, reqVO.getRuralId())
                .likeIfPresent(InfoDO::getRuralName, reqVO.getRuralName())
                .likeIfPresent(InfoDO::getBaseName, reqVO.getBaseName())
                .likeIfPresent(InfoDO::getContactName, reqVO.getContactName())
                .eqIfPresent(InfoDO::getContactPhone, reqVO.getContactPhone())
                .eqIfPresent(InfoDO::getAddress, reqVO.getAddress())
                .eqIfPresent(InfoDO::getEmail, reqVO.getEmail())
                .eqIfPresent(InfoDO::getCoordinateGroup, reqVO.getCoordinateGroup())
                .eqIfPresent(InfoDO::getAreaNumber, reqVO.getAreaNumber())
                .eqIfPresent(InfoDO::getMuNumber, reqVO.getMuNumber())
                .eqIfPresent(InfoDO::getViewColor, reqVO.getViewColor())
                .eqIfPresent(InfoDO::getStaticPicture, reqVO.getStaticPicture())
                .eqIfPresent(InfoDO::getAltitude, reqVO.getAltitude())
                .eqIfPresent(InfoDO::getPersistSupply, reqVO.getPersistSupply())
                .eqIfPresent(InfoDO::getBaseCode, reqVO.getBaseCode())
                .eqIfPresent(InfoDO::getWaterSource, reqVO.getWaterSource())
                .eqIfPresent(InfoDO::getTerrain, reqVO.getTerrain())
                .eqIfPresent(InfoDO::getSoilType, reqVO.getSoilType())
                .eqIfPresent(InfoDO::getSoilPh, reqVO.getSoilPh())
                .eqIfPresent(InfoDO::getClimateType, reqVO.getClimateType())
                .eqIfPresent(InfoDO::getAnnualRainfall, reqVO.getAnnualRainfall())
                .eqIfPresent(InfoDO::getAverageTemperature, reqVO.getAverageTemperature())
                .eqIfPresent(InfoDO::getBasesContent, reqVO.getBasesContent())
                .eqIfPresent(InfoDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(InfoDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(InfoDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(InfoDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(InfoDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(InfoDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(InfoDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(InfoDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(InfoDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(InfoDO::getGapId, reqVO.getGapId())
                .eqIfPresent(InfoDO::getAffiliatedEnterprises, reqVO.getAffiliatedEnterprises())
                .eqIfPresent(InfoDO::getClassify, reqVO.getClassify())
                .eqIfPresent(InfoDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(InfoDO::getCorpName, reqVO.getCorpName())
                .eqIfPresent(InfoDO::getBorderColor, reqVO.getBorderColor())
                .eqIfPresent(InfoDO::getPanoramaUrl, reqVO.getPanoramaUrl())
                .betweenIfPresent(InfoDO::getBuildDate, reqVO.getBuildDate())
                .eqIfPresent(InfoDO::getSyncStatus, reqVO.getSyncStatus())
                .eqIfPresent(InfoDO::getPropagandaVideo, reqVO.getPropagandaVideo())
                .eqIfPresent(InfoDO::getOpacity, reqVO.getOpacity())
                .eqIfPresent(InfoDO::getOldId, reqVO.getOldId())
                .eqIfPresent(InfoDO::getBasesImage, reqVO.getBasesImage())
                .betweenIfPresent(InfoDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(InfoDO::getSource, reqVO.getSource())
                .eqIfPresent(InfoDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(InfoDO::getId));
    }

    default List<InfoDO> selectList(InfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<InfoDO>()
                .eqIfPresent(InfoDO::getAreaId, reqVO.getAreaId())
                .likeIfPresent(InfoDO::getAreaName, reqVO.getAreaName())
                .eqIfPresent(InfoDO::getVillagesAreaId, reqVO.getVillagesAreaId())
                .likeIfPresent(InfoDO::getVillagesAreaName, reqVO.getVillagesAreaName())
                .eqIfPresent(InfoDO::getRuralId, reqVO.getRuralId())
                .likeIfPresent(InfoDO::getRuralName, reqVO.getRuralName())
                .likeIfPresent(InfoDO::getBaseName, reqVO.getBaseName())
                .likeIfPresent(InfoDO::getContactName, reqVO.getContactName())
                .eqIfPresent(InfoDO::getContactPhone, reqVO.getContactPhone())
                .eqIfPresent(InfoDO::getAddress, reqVO.getAddress())
                .eqIfPresent(InfoDO::getEmail, reqVO.getEmail())
                .eqIfPresent(InfoDO::getCoordinateGroup, reqVO.getCoordinateGroup())
                .eqIfPresent(InfoDO::getAreaNumber, reqVO.getAreaNumber())
                .eqIfPresent(InfoDO::getMuNumber, reqVO.getMuNumber())
                .eqIfPresent(InfoDO::getViewColor, reqVO.getViewColor())
                .eqIfPresent(InfoDO::getStaticPicture, reqVO.getStaticPicture())
                .eqIfPresent(InfoDO::getAltitude, reqVO.getAltitude())
                .eqIfPresent(InfoDO::getPersistSupply, reqVO.getPersistSupply())
                .eqIfPresent(InfoDO::getBaseCode, reqVO.getBaseCode())
                .eqIfPresent(InfoDO::getWaterSource, reqVO.getWaterSource())
                .eqIfPresent(InfoDO::getTerrain, reqVO.getTerrain())
                .eqIfPresent(InfoDO::getSoilType, reqVO.getSoilType())
                .eqIfPresent(InfoDO::getSoilPh, reqVO.getSoilPh())
                .eqIfPresent(InfoDO::getClimateType, reqVO.getClimateType())
                .eqIfPresent(InfoDO::getAnnualRainfall, reqVO.getAnnualRainfall())
                .eqIfPresent(InfoDO::getAverageTemperature, reqVO.getAverageTemperature())
                .eqIfPresent(InfoDO::getBasesContent, reqVO.getBasesContent())
                .eqIfPresent(InfoDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(InfoDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(InfoDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(InfoDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(InfoDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(InfoDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(InfoDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(InfoDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(InfoDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(InfoDO::getGapId, reqVO.getGapId())
                .eqIfPresent(InfoDO::getAffiliatedEnterprises, reqVO.getAffiliatedEnterprises())
                .eqIfPresent(InfoDO::getClassify, reqVO.getClassify())
                .eqIfPresent(InfoDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(InfoDO::getCorpName, reqVO.getCorpName())
                .eqIfPresent(InfoDO::getBorderColor, reqVO.getBorderColor())
                .eqIfPresent(InfoDO::getPanoramaUrl, reqVO.getPanoramaUrl())
                .betweenIfPresent(InfoDO::getBuildDate, reqVO.getBuildDate())
                .eqIfPresent(InfoDO::getSyncStatus, reqVO.getSyncStatus())
                .eqIfPresent(InfoDO::getPropagandaVideo, reqVO.getPropagandaVideo())
                .eqIfPresent(InfoDO::getOpacity, reqVO.getOpacity())
                .eqIfPresent(InfoDO::getOldId, reqVO.getOldId())
                .eqIfPresent(InfoDO::getBasesImage, reqVO.getBasesImage())
                .betweenIfPresent(InfoDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(InfoDO::getSource, reqVO.getSource())
                .eqIfPresent(InfoDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(InfoDO::getId));
    }

}
