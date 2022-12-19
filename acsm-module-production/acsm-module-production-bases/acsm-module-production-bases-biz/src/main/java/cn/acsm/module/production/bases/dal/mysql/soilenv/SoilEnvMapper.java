package cn.acsm.module.production.bases.dal.mysql.soilenv;

import java.util.*;

import cn.acsm.module.production.bases.controller.admin.soilenv.vo.SoilEnvExportReqVO;
import cn.acsm.module.production.bases.controller.admin.soilenv.vo.SoilEnvPageReqVO;
import cn.acsm.module.production.bases.dal.dataobject.soilenv.SoilEnvDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.production.bases.controller.admin.soilenv.vo.*;

/**
 * 基地土壤环境 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface SoilEnvMapper extends BaseMapperX<SoilEnvDO> {

    default PageResult<SoilEnvDO> selectPage(SoilEnvPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SoilEnvDO>()
                .eqIfPresent(SoilEnvDO::getBasesId, reqVO.getBasesId())
                .eqIfPresent(SoilEnvDO::getEquipId, reqVO.getEquipId())
                .eqIfPresent(SoilEnvDO::getTester, reqVO.getTester())
                .betweenIfPresent(SoilEnvDO::getTestTime, reqVO.getTestTime())
                .betweenIfPresent(SoilEnvDO::getInsertTime, reqVO.getInsertTime())
                .eqIfPresent(SoilEnvDO::getAvgSoilWater, reqVO.getAvgSoilWater())
                .eqIfPresent(SoilEnvDO::getSoilType, reqVO.getSoilType())
                .eqIfPresent(SoilEnvDO::getSubType, reqVO.getSubType())
                .eqIfPresent(SoilEnvDO::getSoilGenus, reqVO.getSoilGenus())
                .eqIfPresent(SoilEnvDO::getSoilSpecies, reqVO.getSoilSpecies())
                .likeIfPresent(SoilEnvDO::getCommonName, reqVO.getCommonName())
                .eqIfPresent(SoilEnvDO::getSoilParentMaterial, reqVO.getSoilParentMaterial())
                .eqIfPresent(SoilEnvDO::getProfilePattern, reqVO.getProfilePattern())
                .eqIfPresent(SoilEnvDO::getTexture, reqVO.getTexture())
                .eqIfPresent(SoilEnvDO::getSoilStructure, reqVO.getSoilStructure())
                .eqIfPresent(SoilEnvDO::getObstacleFactors, reqVO.getObstacleFactors())
                .eqIfPresent(SoilEnvDO::getErosionDegree, reqVO.getErosionDegree())
                .eqIfPresent(SoilEnvDO::getTopsoilDepth, reqVO.getTopsoilDepth())
                .eqIfPresent(SoilEnvDO::getSamplingDepth, reqVO.getSamplingDepth())
                .eqIfPresent(SoilEnvDO::getSamplingLevelFirst, reqVO.getSamplingLevelFirst())
                .eqIfPresent(SoilEnvDO::getTextureFirst, reqVO.getTextureFirst())
                .eqIfPresent(SoilEnvDO::getPhFirst, reqVO.getPhFirst())
                .eqIfPresent(SoilEnvDO::getOrganicMatterFirst, reqVO.getOrganicMatterFirst())
                .eqIfPresent(SoilEnvDO::getAvailableNitrogenFirst, reqVO.getAvailableNitrogenFirst())
                .eqIfPresent(SoilEnvDO::getEffectivePhosphorusFirst, reqVO.getEffectivePhosphorusFirst())
                .eqIfPresent(SoilEnvDO::getTotalPotassiumFirst, reqVO.getTotalPotassiumFirst())
                .eqIfPresent(SoilEnvDO::getSlowEffectPotassiumFirst, reqVO.getSlowEffectPotassiumFirst())
                .eqIfPresent(SoilEnvDO::getAvailablePotassiumFirst, reqVO.getAvailablePotassiumFirst())
                .eqIfPresent(SoilEnvDO::getTotalNitrogen, reqVO.getTotalNitrogen())
                .eqIfPresent(SoilEnvDO::getSource, reqVO.getSource())
                .eqIfPresent(SoilEnvDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(SoilEnvDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(SoilEnvDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(SoilEnvDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(SoilEnvDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(SoilEnvDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(SoilEnvDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(SoilEnvDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(SoilEnvDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(SoilEnvDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(SoilEnvDO::getCorpName, reqVO.getCorpName())
                .betweenIfPresent(SoilEnvDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(SoilEnvDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(SoilEnvDO::getId));
    }

    default List<SoilEnvDO> selectList(SoilEnvExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<SoilEnvDO>()
                .eqIfPresent(SoilEnvDO::getBasesId, reqVO.getBasesId())
                .eqIfPresent(SoilEnvDO::getEquipId, reqVO.getEquipId())
                .eqIfPresent(SoilEnvDO::getTester, reqVO.getTester())
                .betweenIfPresent(SoilEnvDO::getTestTime, reqVO.getTestTime())
                .betweenIfPresent(SoilEnvDO::getInsertTime, reqVO.getInsertTime())
                .eqIfPresent(SoilEnvDO::getAvgSoilWater, reqVO.getAvgSoilWater())
                .eqIfPresent(SoilEnvDO::getSoilType, reqVO.getSoilType())
                .eqIfPresent(SoilEnvDO::getSubType, reqVO.getSubType())
                .eqIfPresent(SoilEnvDO::getSoilGenus, reqVO.getSoilGenus())
                .eqIfPresent(SoilEnvDO::getSoilSpecies, reqVO.getSoilSpecies())
                .likeIfPresent(SoilEnvDO::getCommonName, reqVO.getCommonName())
                .eqIfPresent(SoilEnvDO::getSoilParentMaterial, reqVO.getSoilParentMaterial())
                .eqIfPresent(SoilEnvDO::getProfilePattern, reqVO.getProfilePattern())
                .eqIfPresent(SoilEnvDO::getTexture, reqVO.getTexture())
                .eqIfPresent(SoilEnvDO::getSoilStructure, reqVO.getSoilStructure())
                .eqIfPresent(SoilEnvDO::getObstacleFactors, reqVO.getObstacleFactors())
                .eqIfPresent(SoilEnvDO::getErosionDegree, reqVO.getErosionDegree())
                .eqIfPresent(SoilEnvDO::getTopsoilDepth, reqVO.getTopsoilDepth())
                .eqIfPresent(SoilEnvDO::getSamplingDepth, reqVO.getSamplingDepth())
                .eqIfPresent(SoilEnvDO::getSamplingLevelFirst, reqVO.getSamplingLevelFirst())
                .eqIfPresent(SoilEnvDO::getTextureFirst, reqVO.getTextureFirst())
                .eqIfPresent(SoilEnvDO::getPhFirst, reqVO.getPhFirst())
                .eqIfPresent(SoilEnvDO::getOrganicMatterFirst, reqVO.getOrganicMatterFirst())
                .eqIfPresent(SoilEnvDO::getAvailableNitrogenFirst, reqVO.getAvailableNitrogenFirst())
                .eqIfPresent(SoilEnvDO::getEffectivePhosphorusFirst, reqVO.getEffectivePhosphorusFirst())
                .eqIfPresent(SoilEnvDO::getTotalPotassiumFirst, reqVO.getTotalPotassiumFirst())
                .eqIfPresent(SoilEnvDO::getSlowEffectPotassiumFirst, reqVO.getSlowEffectPotassiumFirst())
                .eqIfPresent(SoilEnvDO::getAvailablePotassiumFirst, reqVO.getAvailablePotassiumFirst())
                .eqIfPresent(SoilEnvDO::getTotalNitrogen, reqVO.getTotalNitrogen())
                .eqIfPresent(SoilEnvDO::getSource, reqVO.getSource())
                .eqIfPresent(SoilEnvDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(SoilEnvDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(SoilEnvDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(SoilEnvDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(SoilEnvDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(SoilEnvDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(SoilEnvDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(SoilEnvDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(SoilEnvDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(SoilEnvDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(SoilEnvDO::getCorpName, reqVO.getCorpName())
                .betweenIfPresent(SoilEnvDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(SoilEnvDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(SoilEnvDO::getId));
    }

}
