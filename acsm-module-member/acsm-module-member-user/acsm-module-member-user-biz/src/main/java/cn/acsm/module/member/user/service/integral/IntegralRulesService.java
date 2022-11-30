package cn.acsm.module.member.user.service.integral;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.member.user.controller.admin.integral.vo.rules.IntegralRulesCreateReqVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.rules.IntegralRulesExportReqVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.rules.IntegralRulesPageReqVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.rules.IntegralRulesUpdateReqVO;
import cn.acsm.module.member.user.dal.dataobject.integral.IntegralRulesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 会员积分规则 Service 接口
 *
 * @author lihongyan
 */
public interface IntegralRulesService {

    /**
     * 创建会员积分规则
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createIntegralRules(@Valid IntegralRulesCreateReqVO createReqVO);

    /**
     * 更新会员积分规则
     *
     * @param updateReqVO 更新信息
     */
    void updateIntegralRules(@Valid IntegralRulesUpdateReqVO updateReqVO);

    /**
     * 删除会员积分规则
     *
     * @param id 编号
     */
    void deleteIntegralRules(Long id);

    /**
     * 获得会员积分规则
     *
     * @param id 编号
     * @return 会员积分规则
     */
    IntegralRulesDO getIntegralRules(Long id);

    /**
     * 获得会员积分规则列表
     *
     * @param ids 编号
     * @return 会员积分规则列表
     */
    List<IntegralRulesDO> getIntegralRulesList(Collection<Long> ids);

    /**
     * 获得会员积分规则分页
     *
     * @param pageReqVO 分页查询
     * @return 会员积分规则分页
     */
    PageResult<IntegralRulesDO> getIntegralRulesPage(IntegralRulesPageReqVO pageReqVO);

    /**
     * 获得会员积分规则列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 会员积分规则列表
     */
    List<IntegralRulesDO> getIntegralRulesList(IntegralRulesExportReqVO exportReqVO);

}
