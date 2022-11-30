package cn.acsm.module.member.user.dal.mysql.integral;

import java.util.*;

import cn.acsm.module.member.user.controller.admin.integral.vo.rules.IntegralRulesExportReqVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.rules.IntegralRulesPageReqVO;
import cn.acsm.module.member.user.dal.dataobject.integral.IntegralRulesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员积分规则 Mapper
 *
 * @author lihongyan
 */
@Mapper
public interface IntegralRulesMapper extends BaseMapperX<IntegralRulesDO> {

    default PageResult<IntegralRulesDO> selectPage(IntegralRulesPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<IntegralRulesDO>()
                .eqIfPresent(IntegralRulesDO::getEnterpriseId, reqVO.getEnterpriseId())
                .likeIfPresent(IntegralRulesDO::getEnterpriseName, reqVO.getEnterpriseName())
                .eqIfPresent(IntegralRulesDO::getParentLevelProject, reqVO.getParentLevelProject())
                .eqIfPresent(IntegralRulesDO::getRatingItems, reqVO.getRatingItems())
                .eqIfPresent(IntegralRulesDO::getRangeValues, reqVO.getRangeValues())
                .eqIfPresent(IntegralRulesDO::getIntegralMax, reqVO.getIntegralMax())
                .eqIfPresent(IntegralRulesDO::getIntegralMin, reqVO.getIntegralMin())
                .eqIfPresent(IntegralRulesDO::getIntegralValue, reqVO.getIntegralValue())
                .eqIfPresent(IntegralRulesDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(IntegralRulesDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(IntegralRulesDO::getSource, reqVO.getSource())
                .eqIfPresent(IntegralRulesDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(IntegralRulesDO::getId));
    }

    default List<IntegralRulesDO> selectList(IntegralRulesExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<IntegralRulesDO>()
                .eqIfPresent(IntegralRulesDO::getEnterpriseId, reqVO.getEnterpriseId())
                .likeIfPresent(IntegralRulesDO::getEnterpriseName, reqVO.getEnterpriseName())
                .eqIfPresent(IntegralRulesDO::getParentLevelProject, reqVO.getParentLevelProject())
                .eqIfPresent(IntegralRulesDO::getRatingItems, reqVO.getRatingItems())
                .eqIfPresent(IntegralRulesDO::getRangeValues, reqVO.getRangeValues())
                .eqIfPresent(IntegralRulesDO::getIntegralMax, reqVO.getIntegralMax())
                .eqIfPresent(IntegralRulesDO::getIntegralMin, reqVO.getIntegralMin())
                .eqIfPresent(IntegralRulesDO::getIntegralValue, reqVO.getIntegralValue())
                .eqIfPresent(IntegralRulesDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(IntegralRulesDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(IntegralRulesDO::getSource, reqVO.getSource())
                .eqIfPresent(IntegralRulesDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(IntegralRulesDO::getId));
    }

}
