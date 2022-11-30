package cn.acsm.module.member.user.service.integral;

import cn.acsm.module.member.user.controller.admin.integral.vo.rules.IntegralRulesCreateReqVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.rules.IntegralRulesExportReqVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.rules.IntegralRulesPageReqVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.rules.IntegralRulesUpdateReqVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.member.user.dal.dataobject.integral.IntegralRulesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.member.user.convert.integral.IntegralRulesConvert;
import cn.acsm.module.member.user.dal.mysql.integral.IntegralRulesMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.member.user.enums.ErrorCodeConstants.*;

/**
 * 会员积分规则 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class IntegralRulesServiceImpl implements IntegralRulesService {

    @Resource
    private IntegralRulesMapper integralRulesMapper;

    @Override
    public Long createIntegralRules(IntegralRulesCreateReqVO createReqVO) {
        // 插入
        IntegralRulesDO integralRules = IntegralRulesConvert.INSTANCE.convert(createReqVO);
        integralRulesMapper.insert(integralRules);
        // 返回
        return integralRules.getId();
    }

    @Override
    public void updateIntegralRules(IntegralRulesUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateIntegralRulesExists(updateReqVO.getId());
        // 更新
        IntegralRulesDO updateObj = IntegralRulesConvert.INSTANCE.convert(updateReqVO);
        integralRulesMapper.updateById(updateObj);
    }

    @Override
    public void deleteIntegralRules(Long id) {
        // 校验存在
        this.validateIntegralRulesExists(id);
        // 删除
        integralRulesMapper.deleteById(id);
    }

    private void validateIntegralRulesExists(Long id) {
        if (integralRulesMapper.selectById(id) == null) {
            throw exception(INTEGRAL_RULES_NOT_EXISTS);
        }
    }

    @Override
    public IntegralRulesDO getIntegralRules(Long id) {
        return integralRulesMapper.selectById(id);
    }

    @Override
    public List<IntegralRulesDO> getIntegralRulesList(Collection<Long> ids) {
        return integralRulesMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<IntegralRulesDO> getIntegralRulesPage(IntegralRulesPageReqVO pageReqVO) {
        return integralRulesMapper.selectPage(pageReqVO);
    }

    @Override
    public List<IntegralRulesDO> getIntegralRulesList(IntegralRulesExportReqVO exportReqVO) {
        return integralRulesMapper.selectList(exportReqVO);
    }

}
