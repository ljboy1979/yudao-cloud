package cn.acsm.module.production.bases.dal.mysql.partitions;

import java.util.*;

import cn.acsm.module.production.bases.controller.admin.partitions.vo.PartitionsExportReqVO;
import cn.acsm.module.production.bases.controller.admin.partitions.vo.PartitionsPageReqVO;
import cn.acsm.module.production.bases.dal.dataobject.partitions.PartitionsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.production.bases.controller.admin.partitions.vo.*;

/**
 * 分区信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface PartitionsMapper extends BaseMapperX<PartitionsDO> {

    default PageResult<PartitionsDO> selectPage(PartitionsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PartitionsDO>()
                .eqIfPresent(PartitionsDO::getBaseId, reqVO.getBaseId())
                .likeIfPresent(PartitionsDO::getName, reqVO.getName())
                .eqIfPresent(PartitionsDO::getMuNumber, reqVO.getMuNumber())
                .eqIfPresent(PartitionsDO::getViewColor, reqVO.getViewColor())
                .eqIfPresent(PartitionsDO::getBorderColor, reqVO.getBorderColor())
                .eqIfPresent(PartitionsDO::getOpacity, reqVO.getOpacity())
                .eqIfPresent(PartitionsDO::getLongitude, reqVO.getLongitude())
                .eqIfPresent(PartitionsDO::getLatitude, reqVO.getLatitude())
                .eqIfPresent(PartitionsDO::getCoordinateGroup, reqVO.getCoordinateGroup())
                .eqIfPresent(PartitionsDO::getBdLatitude, reqVO.getBdLatitude())
                .eqIfPresent(PartitionsDO::getBdLongitude, reqVO.getBdLongitude())
                .eqIfPresent(PartitionsDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(PartitionsDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(PartitionsDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(PartitionsDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(PartitionsDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(PartitionsDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(PartitionsDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(PartitionsDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(PartitionsDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(PartitionsDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(PartitionsDO::getCorpName, reqVO.getCorpName())
                .eqIfPresent(PartitionsDO::getSyncStatus, reqVO.getSyncStatus())
                .eqIfPresent(PartitionsDO::getOldId, reqVO.getOldId())
                .betweenIfPresent(PartitionsDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PartitionsDO::getSource, reqVO.getSource())
                .eqIfPresent(PartitionsDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(PartitionsDO::getId));
    }

    default List<PartitionsDO> selectList(PartitionsExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<PartitionsDO>()
                .eqIfPresent(PartitionsDO::getBaseId, reqVO.getBaseId())
                .likeIfPresent(PartitionsDO::getName, reqVO.getName())
                .eqIfPresent(PartitionsDO::getMuNumber, reqVO.getMuNumber())
                .eqIfPresent(PartitionsDO::getViewColor, reqVO.getViewColor())
                .eqIfPresent(PartitionsDO::getBorderColor, reqVO.getBorderColor())
                .eqIfPresent(PartitionsDO::getOpacity, reqVO.getOpacity())
                .eqIfPresent(PartitionsDO::getLongitude, reqVO.getLongitude())
                .eqIfPresent(PartitionsDO::getLatitude, reqVO.getLatitude())
                .eqIfPresent(PartitionsDO::getCoordinateGroup, reqVO.getCoordinateGroup())
                .eqIfPresent(PartitionsDO::getBdLatitude, reqVO.getBdLatitude())
                .eqIfPresent(PartitionsDO::getBdLongitude, reqVO.getBdLongitude())
                .eqIfPresent(PartitionsDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(PartitionsDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(PartitionsDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(PartitionsDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(PartitionsDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(PartitionsDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(PartitionsDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(PartitionsDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(PartitionsDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(PartitionsDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(PartitionsDO::getCorpName, reqVO.getCorpName())
                .eqIfPresent(PartitionsDO::getSyncStatus, reqVO.getSyncStatus())
                .eqIfPresent(PartitionsDO::getOldId, reqVO.getOldId())
                .betweenIfPresent(PartitionsDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PartitionsDO::getSource, reqVO.getSource())
                .eqIfPresent(PartitionsDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(PartitionsDO::getId));
    }

}
