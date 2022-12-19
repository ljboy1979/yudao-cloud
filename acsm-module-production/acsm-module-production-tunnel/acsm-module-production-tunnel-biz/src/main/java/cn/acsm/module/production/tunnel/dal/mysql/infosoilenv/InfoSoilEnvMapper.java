package cn.acsm.module.production.tunnel.dal.mysql.infosoilenv;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.production.tunnel.dal.dataobject.infosoilenv.InfoSoilEnvDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.production.tunnel.controller.admin.infosoilenv.vo.*;

/**
 * 地块土壤环境 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface InfoSoilEnvMapper extends BaseMapperX<InfoSoilEnvDO> {

    default PageResult<InfoSoilEnvDO> selectPage(InfoSoilEnvPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<InfoSoilEnvDO>()
                .eqIfPresent(InfoSoilEnvDO::getTunnelId, reqVO.getTunnelId())
                .eqIfPresent(InfoSoilEnvDO::getEquipId, reqVO.getEquipId())
                .eqIfPresent(InfoSoilEnvDO::getTester, reqVO.getTester())
                .betweenIfPresent(InfoSoilEnvDO::getTestTime, reqVO.getTestTime())
                .betweenIfPresent(InfoSoilEnvDO::getInsertTime, reqVO.getInsertTime())
                .eqIfPresent(InfoSoilEnvDO::getAvgSoilWater, reqVO.getAvgSoilWater())
                .eqIfPresent(InfoSoilEnvDO::getSoilType, reqVO.getSoilType())
                .eqIfPresent(InfoSoilEnvDO::getSubType, reqVO.getSubType())
                .eqIfPresent(InfoSoilEnvDO::getSoilGenus, reqVO.getSoilGenus())
                .eqIfPresent(InfoSoilEnvDO::getSoilSpecies, reqVO.getSoilSpecies())
                .likeIfPresent(InfoSoilEnvDO::getCommonName, reqVO.getCommonName())
                .eqIfPresent(InfoSoilEnvDO::getSoilParentMaterial, reqVO.getSoilParentMaterial())
                .eqIfPresent(InfoSoilEnvDO::getProfilePattern, reqVO.getProfilePattern())
                .eqIfPresent(InfoSoilEnvDO::getTexture, reqVO.getTexture())
                .eqIfPresent(InfoSoilEnvDO::getSoilStructure, reqVO.getSoilStructure())
                .eqIfPresent(InfoSoilEnvDO::getObstacleFactors, reqVO.getObstacleFactors())
                .eqIfPresent(InfoSoilEnvDO::getErosionDegree, reqVO.getErosionDegree())
                .eqIfPresent(InfoSoilEnvDO::getTopsoilDepth, reqVO.getTopsoilDepth())
                .eqIfPresent(InfoSoilEnvDO::getSamplingDepth, reqVO.getSamplingDepth())
                .eqIfPresent(InfoSoilEnvDO::getSamplingLevelFirst, reqVO.getSamplingLevelFirst())
                .eqIfPresent(InfoSoilEnvDO::getTextureFirst, reqVO.getTextureFirst())
                .eqIfPresent(InfoSoilEnvDO::getPhFirst, reqVO.getPhFirst())
                .eqIfPresent(InfoSoilEnvDO::getOrganicMatterFirst, reqVO.getOrganicMatterFirst())
                .eqIfPresent(InfoSoilEnvDO::getAvailableNitrogenFirst, reqVO.getAvailableNitrogenFirst())
                .eqIfPresent(InfoSoilEnvDO::getEffectivePhosphorusFirst, reqVO.getEffectivePhosphorusFirst())
                .eqIfPresent(InfoSoilEnvDO::getTotalPotassiumFirst, reqVO.getTotalPotassiumFirst())
                .eqIfPresent(InfoSoilEnvDO::getSlowEffectPotassiumFirst, reqVO.getSlowEffectPotassiumFirst())
                .eqIfPresent(InfoSoilEnvDO::getAvailablePotassiumFirst, reqVO.getAvailablePotassiumFirst())
                .eqIfPresent(InfoSoilEnvDO::getTotalNitrogen, reqVO.getTotalNitrogen())
                .eqIfPresent(InfoSoilEnvDO::getSource, reqVO.getSource())
                .eqIfPresent(InfoSoilEnvDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(InfoSoilEnvDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(InfoSoilEnvDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(InfoSoilEnvDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(InfoSoilEnvDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(InfoSoilEnvDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(InfoSoilEnvDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(InfoSoilEnvDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(InfoSoilEnvDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(InfoSoilEnvDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(InfoSoilEnvDO::getCorpName, reqVO.getCorpName())
                .betweenIfPresent(InfoSoilEnvDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(InfoSoilEnvDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(InfoSoilEnvDO::getId));
    }

    default List<InfoSoilEnvDO> selectList(InfoSoilEnvExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<InfoSoilEnvDO>()
                .eqIfPresent(InfoSoilEnvDO::getTunnelId, reqVO.getTunnelId())
                .eqIfPresent(InfoSoilEnvDO::getEquipId, reqVO.getEquipId())
                .eqIfPresent(InfoSoilEnvDO::getTester, reqVO.getTester())
                .betweenIfPresent(InfoSoilEnvDO::getTestTime, reqVO.getTestTime())
                .betweenIfPresent(InfoSoilEnvDO::getInsertTime, reqVO.getInsertTime())
                .eqIfPresent(InfoSoilEnvDO::getAvgSoilWater, reqVO.getAvgSoilWater())
                .eqIfPresent(InfoSoilEnvDO::getSoilType, reqVO.getSoilType())
                .eqIfPresent(InfoSoilEnvDO::getSubType, reqVO.getSubType())
                .eqIfPresent(InfoSoilEnvDO::getSoilGenus, reqVO.getSoilGenus())
                .eqIfPresent(InfoSoilEnvDO::getSoilSpecies, reqVO.getSoilSpecies())
                .likeIfPresent(InfoSoilEnvDO::getCommonName, reqVO.getCommonName())
                .eqIfPresent(InfoSoilEnvDO::getSoilParentMaterial, reqVO.getSoilParentMaterial())
                .eqIfPresent(InfoSoilEnvDO::getProfilePattern, reqVO.getProfilePattern())
                .eqIfPresent(InfoSoilEnvDO::getTexture, reqVO.getTexture())
                .eqIfPresent(InfoSoilEnvDO::getSoilStructure, reqVO.getSoilStructure())
                .eqIfPresent(InfoSoilEnvDO::getObstacleFactors, reqVO.getObstacleFactors())
                .eqIfPresent(InfoSoilEnvDO::getErosionDegree, reqVO.getErosionDegree())
                .eqIfPresent(InfoSoilEnvDO::getTopsoilDepth, reqVO.getTopsoilDepth())
                .eqIfPresent(InfoSoilEnvDO::getSamplingDepth, reqVO.getSamplingDepth())
                .eqIfPresent(InfoSoilEnvDO::getSamplingLevelFirst, reqVO.getSamplingLevelFirst())
                .eqIfPresent(InfoSoilEnvDO::getTextureFirst, reqVO.getTextureFirst())
                .eqIfPresent(InfoSoilEnvDO::getPhFirst, reqVO.getPhFirst())
                .eqIfPresent(InfoSoilEnvDO::getOrganicMatterFirst, reqVO.getOrganicMatterFirst())
                .eqIfPresent(InfoSoilEnvDO::getAvailableNitrogenFirst, reqVO.getAvailableNitrogenFirst())
                .eqIfPresent(InfoSoilEnvDO::getEffectivePhosphorusFirst, reqVO.getEffectivePhosphorusFirst())
                .eqIfPresent(InfoSoilEnvDO::getTotalPotassiumFirst, reqVO.getTotalPotassiumFirst())
                .eqIfPresent(InfoSoilEnvDO::getSlowEffectPotassiumFirst, reqVO.getSlowEffectPotassiumFirst())
                .eqIfPresent(InfoSoilEnvDO::getAvailablePotassiumFirst, reqVO.getAvailablePotassiumFirst())
                .eqIfPresent(InfoSoilEnvDO::getTotalNitrogen, reqVO.getTotalNitrogen())
                .eqIfPresent(InfoSoilEnvDO::getSource, reqVO.getSource())
                .eqIfPresent(InfoSoilEnvDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(InfoSoilEnvDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(InfoSoilEnvDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(InfoSoilEnvDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(InfoSoilEnvDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(InfoSoilEnvDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(InfoSoilEnvDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(InfoSoilEnvDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(InfoSoilEnvDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(InfoSoilEnvDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(InfoSoilEnvDO::getCorpName, reqVO.getCorpName())
                .betweenIfPresent(InfoSoilEnvDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(InfoSoilEnvDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(InfoSoilEnvDO::getId));
    }

}
