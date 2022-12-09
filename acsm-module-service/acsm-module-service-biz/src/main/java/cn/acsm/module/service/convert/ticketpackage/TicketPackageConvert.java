package cn.acsm.module.service.convert.ticketpackage;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.service.controller.admin.ticketpackage.vo.*;
import cn.acsm.module.service.dal.dataobject.ticketpackage.TicketPackageDO;

/**
 * 套票 Convert
 *
 * @author smile
 */
@Mapper
public interface TicketPackageConvert {

    TicketPackageConvert INSTANCE = Mappers.getMapper(TicketPackageConvert.class);

    TicketPackageDO convert(TicketPackageCreateReqVO bean);

    TicketPackageDO convert(TicketPackageUpdateReqVO bean);

    TicketPackageRespVO convert(TicketPackageDO bean);

    List<TicketPackageRespVO> convertList(List<TicketPackageDO> list);

    PageResult<TicketPackageRespVO> convertPage(PageResult<TicketPackageDO> page);

    List<TicketPackageExcelVO> convertList02(List<TicketPackageDO> list);

}
