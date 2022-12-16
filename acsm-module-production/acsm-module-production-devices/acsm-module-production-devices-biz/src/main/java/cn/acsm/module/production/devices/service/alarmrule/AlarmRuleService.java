package cn.acsm.module.production.devices.service.alarmrule;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.production.devices.controller.admin.alarmrule.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.alarmrule.AlarmRuleDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 告警规则 Service 接口
 *
 * @author 芋道源码
 */
public interface AlarmRuleService {

    /**
     * 创建告警规则
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createAlarmRule(@Valid AlarmRuleCreateReqVO createReqVO);

    /**
     * 更新告警规则
     *
     * @param updateReqVO 更新信息
     */
    void updateAlarmRule(@Valid AlarmRuleUpdateReqVO updateReqVO);

    /**
     * 删除告警规则
     *
     * @param id 编号
     */
    void deleteAlarmRule(Long id);

    /**
     * 获得告警规则
     *
     * @param id 编号
     * @return 告警规则
     */
    AlarmRuleDO getAlarmRule(Long id);

    /**
     * 获得告警规则列表
     *
     * @param ids 编号
     * @return 告警规则列表
     */
    List<AlarmRuleDO> getAlarmRuleList(Collection<Long> ids);

    /**
     * 获得告警规则分页
     *
     * @param pageReqVO 分页查询
     * @return 告警规则分页
     */
    PageResult<AlarmRuleDO> getAlarmRulePage(AlarmRulePageReqVO pageReqVO);

    /**
     * 获得告警规则列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 告警规则列表
     */
    List<AlarmRuleDO> getAlarmRuleList(AlarmRuleExportReqVO exportReqVO);

}
