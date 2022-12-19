package cn.acsm.module.production.devices.dal.mysql.access;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.production.devices.dal.dataobject.access.AccessDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.production.devices.controller.admin.access.vo.*;

/**
 * 设备允许访问名单信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface AccessMapper extends BaseMapperX<AccessDO> {

    default PageResult<AccessDO> selectPage(AccessPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AccessDO>()
                .eqIfPresent(AccessDO::getDeviceId, reqVO.getDeviceId())
                .eqIfPresent(AccessDO::getAccessPhone, reqVO.getAccessPhone())
                .eqIfPresent(AccessDO::getAccessWay, reqVO.getAccessWay())
                .betweenIfPresent(AccessDO::getInsertTime, reqVO.getInsertTime())
                .eqIfPresent(AccessDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(AccessDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(AccessDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(AccessDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(AccessDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(AccessDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(AccessDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(AccessDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(AccessDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(AccessDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(AccessDO::getCorpName, reqVO.getCorpName())
                .betweenIfPresent(AccessDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(AccessDO::getSource, reqVO.getSource())
                .eqIfPresent(AccessDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(AccessDO::getId));
    }

    default List<AccessDO> selectList(AccessExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<AccessDO>()
                .eqIfPresent(AccessDO::getDeviceId, reqVO.getDeviceId())
                .eqIfPresent(AccessDO::getAccessPhone, reqVO.getAccessPhone())
                .eqIfPresent(AccessDO::getAccessWay, reqVO.getAccessWay())
                .betweenIfPresent(AccessDO::getInsertTime, reqVO.getInsertTime())
                .eqIfPresent(AccessDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(AccessDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(AccessDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(AccessDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(AccessDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(AccessDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(AccessDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(AccessDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(AccessDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(AccessDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(AccessDO::getCorpName, reqVO.getCorpName())
                .betweenIfPresent(AccessDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(AccessDO::getSource, reqVO.getSource())
                .eqIfPresent(AccessDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(AccessDO::getId));
    }

}
