package cn.acsm.module.production.devices.convert.alarmrule;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.production.devices.controller.admin.alarmrule.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.alarmrule.AlarmRuleDO;

/**
 * 告警规则 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface AlarmRuleConvert {

    AlarmRuleConvert INSTANCE = Mappers.getMapper(AlarmRuleConvert.class);

    AlarmRuleDO convert(AlarmRuleCreateReqVO bean);

    AlarmRuleDO convert(AlarmRuleUpdateReqVO bean);

    AlarmRuleRespVO convert(AlarmRuleDO bean);

    List<AlarmRuleRespVO> convertList(List<AlarmRuleDO> list);

    PageResult<AlarmRuleRespVO> convertPage(PageResult<AlarmRuleDO> page);

    List<AlarmRuleExcelVO> convertList02(List<AlarmRuleDO> list);

}
