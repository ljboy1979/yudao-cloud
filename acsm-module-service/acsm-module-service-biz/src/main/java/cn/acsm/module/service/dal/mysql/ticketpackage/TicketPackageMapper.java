package cn.acsm.module.service.dal.mysql.ticketpackage;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.service.dal.dataobject.ticketpackage.TicketPackageDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.service.controller.admin.ticketpackage.vo.*;

/**
 * 套票 Mapper
 *
 * @author smile
 */
@Mapper
public interface TicketPackageMapper extends BaseMapperX<TicketPackageDO> {

    default PageResult<TicketPackageDO> selectPage(TicketPackagePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TicketPackageDO>()
                .likeIfPresent(TicketPackageDO::getPackageName, reqVO.getPackageName())
                .eqIfPresent(TicketPackageDO::getPackageType, reqVO.getPackageType())
                .eqIfPresent(TicketPackageDO::getPurchaser, reqVO.getPurchaser())
                .eqIfPresent(TicketPackageDO::getCarrierId, reqVO.getCarrierId())
                .eqIfPresent(TicketPackageDO::getNumber, reqVO.getNumber())
                .eqIfPresent(TicketPackageDO::getPackageMoney, reqVO.getPackageMoney())
                .eqIfPresent(TicketPackageDO::getServiceLife, reqVO.getServiceLife())
                .eqIfPresent(TicketPackageDO::getCertigier, reqVO.getCertigier())
                .eqIfPresent(TicketPackageDO::getPackageStatus, reqVO.getPackageStatus())
                .eqIfPresent(TicketPackageDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(TicketPackageDO::getCover, reqVO.getCover())
                .eqIfPresent(TicketPackageDO::getContent, reqVO.getContent())
                .eqIfPresent(TicketPackageDO::getRegulation, reqVO.getRegulation())
                .eqIfPresent(TicketPackageDO::getServiceLifeType, reqVO.getServiceLifeType())
                .eqIfPresent(TicketPackageDO::getPackageContent, reqVO.getPackageContent())
                .eqIfPresent(TicketPackageDO::getPackageRule, reqVO.getPackageRule())
                .betweenIfPresent(TicketPackageDO::getStartDate, reqVO.getStartDate())
                .betweenIfPresent(TicketPackageDO::getEndDate, reqVO.getEndDate())
                .eqIfPresent(TicketPackageDO::getTicketStatus, reqVO.getTicketStatus())
                .eqIfPresent(TicketPackageDO::getTimeNum, reqVO.getTimeNum())
                .eqIfPresent(TicketPackageDO::getTimeType, reqVO.getTimeType())
                .eqIfPresent(TicketPackageDO::getTimeLimitMode, reqVO.getTimeLimitMode())
                .eqIfPresent(TicketPackageDO::getTicketType, reqVO.getTicketType())
                .eqIfPresent(TicketPackageDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(TicketPackageDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(TicketPackageDO::getSource, reqVO.getSource())
                .orderByDesc(TicketPackageDO::getId));
    }

    default List<TicketPackageDO> selectList(TicketPackageExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<TicketPackageDO>()
                .likeIfPresent(TicketPackageDO::getPackageName, reqVO.getPackageName())
                .eqIfPresent(TicketPackageDO::getPackageType, reqVO.getPackageType())
                .eqIfPresent(TicketPackageDO::getPurchaser, reqVO.getPurchaser())
                .eqIfPresent(TicketPackageDO::getCarrierId, reqVO.getCarrierId())
                .eqIfPresent(TicketPackageDO::getNumber, reqVO.getNumber())
                .eqIfPresent(TicketPackageDO::getPackageMoney, reqVO.getPackageMoney())
                .eqIfPresent(TicketPackageDO::getServiceLife, reqVO.getServiceLife())
                .eqIfPresent(TicketPackageDO::getCertigier, reqVO.getCertigier())
                .eqIfPresent(TicketPackageDO::getPackageStatus, reqVO.getPackageStatus())
                .eqIfPresent(TicketPackageDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(TicketPackageDO::getCover, reqVO.getCover())
                .eqIfPresent(TicketPackageDO::getContent, reqVO.getContent())
                .eqIfPresent(TicketPackageDO::getRegulation, reqVO.getRegulation())
                .eqIfPresent(TicketPackageDO::getServiceLifeType, reqVO.getServiceLifeType())
                .eqIfPresent(TicketPackageDO::getPackageContent, reqVO.getPackageContent())
                .eqIfPresent(TicketPackageDO::getPackageRule, reqVO.getPackageRule())
                .betweenIfPresent(TicketPackageDO::getStartDate, reqVO.getStartDate())
                .betweenIfPresent(TicketPackageDO::getEndDate, reqVO.getEndDate())
                .eqIfPresent(TicketPackageDO::getTicketStatus, reqVO.getTicketStatus())
                .eqIfPresent(TicketPackageDO::getTimeNum, reqVO.getTimeNum())
                .eqIfPresent(TicketPackageDO::getTimeType, reqVO.getTimeType())
                .eqIfPresent(TicketPackageDO::getTimeLimitMode, reqVO.getTimeLimitMode())
                .eqIfPresent(TicketPackageDO::getTicketType, reqVO.getTicketType())
                .eqIfPresent(TicketPackageDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(TicketPackageDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(TicketPackageDO::getSource, reqVO.getSource())
                .orderByDesc(TicketPackageDO::getId));
    }

    void deleteTicketPackageService(TicketPackageUpdateReqVO reqVO);

}
