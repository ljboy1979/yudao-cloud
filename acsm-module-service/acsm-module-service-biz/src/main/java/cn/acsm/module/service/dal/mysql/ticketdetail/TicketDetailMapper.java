package cn.acsm.module.service.dal.mysql.ticketdetail;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.service.dal.dataobject.ticketdetail.TicketDetailDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.service.controller.admin.ticketdetail.vo.*;

/**
 * 套票详情 Mapper
 *
 * @author smile
 */
@Mapper
public interface TicketDetailMapper extends BaseMapperX<TicketDetailDO> {

    default PageResult<TicketDetailDO> selectPage(TicketDetailPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TicketDetailDO>()
                .eqIfPresent(TicketDetailDO::getTicketId, reqVO.getTicketId())
                .eqIfPresent(TicketDetailDO::getSkuId, reqVO.getSkuId())
                .eqIfPresent(TicketDetailDO::getUseNumber, reqVO.getUseNumber())
                .eqIfPresent(TicketDetailDO::getUseRate, reqVO.getUseRate())
                .eqIfPresent(TicketDetailDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(TicketDetailDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(TicketDetailDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(TicketDetailDO::getSource, reqVO.getSource())
                .orderByDesc(TicketDetailDO::getId));
    }

    default List<TicketDetailDO> selectList(TicketDetailExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<TicketDetailDO>()
                .eqIfPresent(TicketDetailDO::getTicketId, reqVO.getTicketId())
                .eqIfPresent(TicketDetailDO::getSkuId, reqVO.getSkuId())
                .eqIfPresent(TicketDetailDO::getUseNumber, reqVO.getUseNumber())
                .eqIfPresent(TicketDetailDO::getUseRate, reqVO.getUseRate())
                .eqIfPresent(TicketDetailDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(TicketDetailDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(TicketDetailDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(TicketDetailDO::getSource, reqVO.getSource())
                .orderByDesc(TicketDetailDO::getId));
    }

}
