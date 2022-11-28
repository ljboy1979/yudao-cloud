package cn.acsm.module.member.user.convert.integral;

import java.util.*;

import cn.acsm.module.member.user.controller.admin.integral.vo.rules.IntegralRulesCreateReqVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.rules.IntegralRulesExcelVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.rules.IntegralRulesRespVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.rules.IntegralRulesUpdateReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.member.user.dal.dataobject.integral.IntegralRulesDO;

/**
 * 会员积分规则 Convert
 *
 * @author lihongyan
 */
@Mapper
public interface IntegralRulesConvert {

    IntegralRulesConvert INSTANCE = Mappers.getMapper(IntegralRulesConvert.class);

    IntegralRulesDO convert(IntegralRulesCreateReqVO bean);

    IntegralRulesDO convert(IntegralRulesUpdateReqVO bean);

    IntegralRulesRespVO convert(IntegralRulesDO bean);

    List<IntegralRulesRespVO> convertList(List<IntegralRulesDO> list);

    PageResult<IntegralRulesRespVO> convertPage(PageResult<IntegralRulesDO> page);

    List<IntegralRulesExcelVO> convertList02(List<IntegralRulesDO> list);

}
