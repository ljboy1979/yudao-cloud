package cn.acsm.module.production.devices.dal.mysql.paramscfg;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.production.devices.dal.dataobject.paramscfg.ParamsCfgDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.production.devices.controller.admin.paramscfg.vo.*;

/**
 * 设备参数配置 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ParamsCfgMapper extends BaseMapperX<ParamsCfgDO> {

    default PageResult<ParamsCfgDO> selectPage(ParamsCfgPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ParamsCfgDO>()
                .eqIfPresent(ParamsCfgDO::getParamColumn, reqVO.getParamColumn())
                .likeIfPresent(ParamsCfgDO::getParamName, reqVO.getParamName())
                .eqIfPresent(ParamsCfgDO::getParamUnit, reqVO.getParamUnit())
                .eqIfPresent(ParamsCfgDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(ParamsCfgDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(ParamsCfgDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(ParamsCfgDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(ParamsCfgDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(ParamsCfgDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(ParamsCfgDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(ParamsCfgDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(ParamsCfgDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(ParamsCfgDO::getCorpName, reqVO.getCorpName())
                .eqIfPresent(ParamsCfgDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(ParamsCfgDO::getCfgId, reqVO.getCfgId())
                .betweenIfPresent(ParamsCfgDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ParamsCfgDO::getSource, reqVO.getSource())
                .eqIfPresent(ParamsCfgDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(ParamsCfgDO::getId));
    }

    default List<ParamsCfgDO> selectList(ParamsCfgExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ParamsCfgDO>()
                .eqIfPresent(ParamsCfgDO::getParamColumn, reqVO.getParamColumn())
                .likeIfPresent(ParamsCfgDO::getParamName, reqVO.getParamName())
                .eqIfPresent(ParamsCfgDO::getParamUnit, reqVO.getParamUnit())
                .eqIfPresent(ParamsCfgDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(ParamsCfgDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(ParamsCfgDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(ParamsCfgDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(ParamsCfgDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(ParamsCfgDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(ParamsCfgDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(ParamsCfgDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(ParamsCfgDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(ParamsCfgDO::getCorpName, reqVO.getCorpName())
                .eqIfPresent(ParamsCfgDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(ParamsCfgDO::getCfgId, reqVO.getCfgId())
                .betweenIfPresent(ParamsCfgDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ParamsCfgDO::getSource, reqVO.getSource())
                .eqIfPresent(ParamsCfgDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(ParamsCfgDO::getId));
    }

}
