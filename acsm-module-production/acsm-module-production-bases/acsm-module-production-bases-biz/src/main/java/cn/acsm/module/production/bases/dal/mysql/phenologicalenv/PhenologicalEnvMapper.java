package cn.acsm.module.production.bases.dal.mysql.phenologicalenv;

import java.util.*;

import cn.acsm.module.production.bases.controller.admin.phenologicalenv.vo.PhenologicalEnvExportReqVO;
import cn.acsm.module.production.bases.controller.admin.phenologicalenv.vo.PhenologicalEnvPageReqVO;
import cn.acsm.module.production.bases.dal.dataobject.phenologicalenv.PhenologicalEnvDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.production.bases.controller.admin.phenologicalenv.vo.*;

/**
 * 基地物候环境 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface PhenologicalEnvMapper extends BaseMapperX<PhenologicalEnvDO> {

    default PageResult<PhenologicalEnvDO> selectPage(PhenologicalEnvPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PhenologicalEnvDO>()
                .eqIfPresent(PhenologicalEnvDO::getBasesId, reqVO.getBasesId())
                .eqIfPresent(PhenologicalEnvDO::getDevicesId, reqVO.getDevicesId())
                .eqIfPresent(PhenologicalEnvDO::getTester, reqVO.getTester())
                .betweenIfPresent(PhenologicalEnvDO::getTestTime, reqVO.getTestTime())
                .betweenIfPresent(PhenologicalEnvDO::getInsertTime, reqVO.getInsertTime())
                .eqIfPresent(PhenologicalEnvDO::getLightIntensity, reqVO.getLightIntensity())
                .eqIfPresent(PhenologicalEnvDO::getGeomorphicType, reqVO.getGeomorphicType())
                .eqIfPresent(PhenologicalEnvDO::getLandform, reqVO.getLandform())
                .eqIfPresent(PhenologicalEnvDO::getGroundSlope, reqVO.getGroundSlope())
                .eqIfPresent(PhenologicalEnvDO::getSlopeDirection, reqVO.getSlopeDirection())
                .eqIfPresent(PhenologicalEnvDO::getEffectiveTemperature, reqVO.getEffectiveTemperature())
                .eqIfPresent(PhenologicalEnvDO::getFrostFreePeriod, reqVO.getFrostFreePeriod())
                .eqIfPresent(PhenologicalEnvDO::getMinTemperatureDays, reqVO.getMinTemperatureDays())
                .eqIfPresent(PhenologicalEnvDO::getMaxTemperatureDays, reqVO.getMaxTemperatureDays())
                .eqIfPresent(PhenologicalEnvDO::getTypicalCropSystem, reqVO.getTypicalCropSystem())
                .eqIfPresent(PhenologicalEnvDO::getMaturationSystem, reqVO.getMaturationSystem())
                .eqIfPresent(PhenologicalEnvDO::getAnnualYieldLevel, reqVO.getAnnualYieldLevel())
                .eqIfPresent(PhenologicalEnvDO::getFarmlandInfrastructure, reqVO.getFarmlandInfrastructure())
                .eqIfPresent(PhenologicalEnvDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(PhenologicalEnvDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(PhenologicalEnvDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(PhenologicalEnvDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(PhenologicalEnvDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(PhenologicalEnvDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(PhenologicalEnvDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(PhenologicalEnvDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(PhenologicalEnvDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(PhenologicalEnvDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(PhenologicalEnvDO::getCorpName, reqVO.getCorpName())
                .eqIfPresent(PhenologicalEnvDO::getAltitude, reqVO.getAltitude())
                .betweenIfPresent(PhenologicalEnvDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PhenologicalEnvDO::getSource, reqVO.getSource())
                .eqIfPresent(PhenologicalEnvDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(PhenologicalEnvDO::getId));
    }

    default List<PhenologicalEnvDO> selectList(PhenologicalEnvExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<PhenologicalEnvDO>()
                .eqIfPresent(PhenologicalEnvDO::getBasesId, reqVO.getBasesId())
                .eqIfPresent(PhenologicalEnvDO::getDevicesId, reqVO.getDevicesId())
                .eqIfPresent(PhenologicalEnvDO::getTester, reqVO.getTester())
                .betweenIfPresent(PhenologicalEnvDO::getTestTime, reqVO.getTestTime())
                .betweenIfPresent(PhenologicalEnvDO::getInsertTime, reqVO.getInsertTime())
                .eqIfPresent(PhenologicalEnvDO::getLightIntensity, reqVO.getLightIntensity())
                .eqIfPresent(PhenologicalEnvDO::getGeomorphicType, reqVO.getGeomorphicType())
                .eqIfPresent(PhenologicalEnvDO::getLandform, reqVO.getLandform())
                .eqIfPresent(PhenologicalEnvDO::getGroundSlope, reqVO.getGroundSlope())
                .eqIfPresent(PhenologicalEnvDO::getSlopeDirection, reqVO.getSlopeDirection())
                .eqIfPresent(PhenologicalEnvDO::getEffectiveTemperature, reqVO.getEffectiveTemperature())
                .eqIfPresent(PhenologicalEnvDO::getFrostFreePeriod, reqVO.getFrostFreePeriod())
                .eqIfPresent(PhenologicalEnvDO::getMinTemperatureDays, reqVO.getMinTemperatureDays())
                .eqIfPresent(PhenologicalEnvDO::getMaxTemperatureDays, reqVO.getMaxTemperatureDays())
                .eqIfPresent(PhenologicalEnvDO::getTypicalCropSystem, reqVO.getTypicalCropSystem())
                .eqIfPresent(PhenologicalEnvDO::getMaturationSystem, reqVO.getMaturationSystem())
                .eqIfPresent(PhenologicalEnvDO::getAnnualYieldLevel, reqVO.getAnnualYieldLevel())
                .eqIfPresent(PhenologicalEnvDO::getFarmlandInfrastructure, reqVO.getFarmlandInfrastructure())
                .eqIfPresent(PhenologicalEnvDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(PhenologicalEnvDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(PhenologicalEnvDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(PhenologicalEnvDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(PhenologicalEnvDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(PhenologicalEnvDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(PhenologicalEnvDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(PhenologicalEnvDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(PhenologicalEnvDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(PhenologicalEnvDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(PhenologicalEnvDO::getCorpName, reqVO.getCorpName())
                .eqIfPresent(PhenologicalEnvDO::getAltitude, reqVO.getAltitude())
                .betweenIfPresent(PhenologicalEnvDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PhenologicalEnvDO::getSource, reqVO.getSource())
                .eqIfPresent(PhenologicalEnvDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(PhenologicalEnvDO::getId));
    }

}
