package cn.acsm.module.service.convert.ticketdetail;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.service.controller.admin.ticketdetail.vo.*;
import cn.acsm.module.service.dal.dataobject.ticketdetail.TicketDetailDO;

/**
 * 套票详情 Convert
 *
 * @author smile
 */
@Mapper
public interface TicketDetailConvert {

    TicketDetailConvert INSTANCE = Mappers.getMapper(TicketDetailConvert.class);

    TicketDetailDO convert(TicketDetailCreateReqVO bean);

    TicketDetailDO convert(TicketDetailUpdateReqVO bean);

    TicketDetailRespVO convert(TicketDetailDO bean);

    List<TicketDetailRespVO> convertList(List<TicketDetailDO> list);

    PageResult<TicketDetailRespVO> convertPage(PageResult<TicketDetailDO> page);

    List<TicketDetailExcelVO> convertList02(List<TicketDetailDO> list);

}
