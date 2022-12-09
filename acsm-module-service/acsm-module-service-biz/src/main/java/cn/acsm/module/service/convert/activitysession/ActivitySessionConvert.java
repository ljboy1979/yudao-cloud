package cn.acsm.module.service.convert.activitysession;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.service.controller.admin.activitysession.vo.*;
import cn.acsm.module.service.dal.dataobject.activitysession.ActivitySessionDO;

/**
 * 时间排期 Convert
 *
 * @author smile
 */
@Mapper
public interface ActivitySessionConvert {

    ActivitySessionConvert INSTANCE = Mappers.getMapper(ActivitySessionConvert.class);

    ActivitySessionDO convert(ActivitySessionCreateReqVO bean);

    ActivitySessionDO convert(ActivitySessionUpdateReqVO bean);

    ActivitySessionRespVO convert(ActivitySessionDO bean);

    List<ActivitySessionRespVO> convertList(List<ActivitySessionDO> list);

    PageResult<ActivitySessionRespVO> convertPage(PageResult<ActivitySessionDO> page);

    List<ActivitySessionExcelVO> convertList02(List<ActivitySessionDO> list);

}
