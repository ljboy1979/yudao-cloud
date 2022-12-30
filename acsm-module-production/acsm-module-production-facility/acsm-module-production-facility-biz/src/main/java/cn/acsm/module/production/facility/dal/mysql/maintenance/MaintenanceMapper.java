package cn.acsm.module.production.facility.dal.mysql.maintenance;

import cn.acsm.module.production.facility.controller.admin.maintenance.vo.MaintenanceExportReqVO;
import cn.acsm.module.production.facility.controller.admin.maintenance.vo.MaintenancePageReqVO;
import cn.acsm.module.production.facility.dal.dataobject.maintenance.MaintenanceDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 设施维护记录 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface MaintenanceMapper extends BaseMapperX<MaintenanceDO> {

    default PageResult<MaintenanceDO> selectPage(MaintenancePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MaintenanceDO>()
                .eqIfPresent(MaintenanceDO::getFacilitysId, reqVO.getFacilitysId())
                .likeIfPresent(MaintenanceDO::getOperateName, reqVO.getOperateName())
                .betweenIfPresent(MaintenanceDO::getOperateTime, reqVO.getOperateTime())
                .eqIfPresent(MaintenanceDO::getTimeConsuming, reqVO.getTimeConsuming())
                .eqIfPresent(MaintenanceDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(MaintenanceDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(MaintenanceDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(MaintenanceDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(MaintenanceDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(MaintenanceDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(MaintenanceDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(MaintenanceDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(MaintenanceDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(MaintenanceDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(MaintenanceDO::getCorpName, reqVO.getCorpName())
                .betweenIfPresent(MaintenanceDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(MaintenanceDO::getSource, reqVO.getSource())
                .eqIfPresent(MaintenanceDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(MaintenanceDO::getId));
    }

    default List<MaintenanceDO> selectList(MaintenanceExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MaintenanceDO>()
                .eqIfPresent(MaintenanceDO::getFacilitysId, reqVO.getFacilitysId())
                .likeIfPresent(MaintenanceDO::getOperateName, reqVO.getOperateName())
                .betweenIfPresent(MaintenanceDO::getOperateTime, reqVO.getOperateTime())
                .eqIfPresent(MaintenanceDO::getTimeConsuming, reqVO.getTimeConsuming())
                .eqIfPresent(MaintenanceDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(MaintenanceDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(MaintenanceDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(MaintenanceDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(MaintenanceDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(MaintenanceDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(MaintenanceDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(MaintenanceDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(MaintenanceDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(MaintenanceDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(MaintenanceDO::getCorpName, reqVO.getCorpName())
                .betweenIfPresent(MaintenanceDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(MaintenanceDO::getSource, reqVO.getSource())
                .eqIfPresent(MaintenanceDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(MaintenanceDO::getId));
    }

}
