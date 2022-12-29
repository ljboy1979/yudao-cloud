package cn.acsm.module.production.devices.service.alarmrule;

import cn.acsm.module.production.devices.controller.admin.alarmrule.vo.AlarmRuleCreateReqVO;
import cn.acsm.module.production.devices.controller.admin.alarmrule.vo.AlarmRuleExportReqVO;
import cn.acsm.module.production.devices.controller.admin.alarmrule.vo.AlarmRulePageReqVO;
import cn.acsm.module.production.devices.controller.admin.alarmrule.vo.AlarmRuleUpdateReqVO;
import cn.acsm.module.production.devices.convert.alarmrule.AlarmRuleConvert;
import cn.acsm.module.production.devices.dal.dataobject.alarmrule.AlarmRuleDO;
import cn.acsm.module.production.devices.dal.mysql.alarmrule.AlarmRuleMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.production.devices.enums.ErrorCodeConstants.ALARM_RULE_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 告警规则 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class AlarmRuleServiceImpl implements AlarmRuleService {

    @Resource
    private AlarmRuleMapper alarmRuleMapper;

    @Override
    public Long createAlarmRule(AlarmRuleCreateReqVO createReqVO) {
        // 插入
        AlarmRuleDO alarmRule = AlarmRuleConvert.INSTANCE.convert(createReqVO);
        alarmRuleMapper.insert(alarmRule);
        // 返回
        return alarmRule.getId();
    }

    @Override
    @CacheEvict(value = "device-alarmRule", key = "#updateReqVO.id")
    public void updateAlarmRule(AlarmRuleUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateAlarmRuleExists(updateReqVO.getId());
        // 更新
        AlarmRuleDO updateObj = AlarmRuleConvert.INSTANCE.convert(updateReqVO);
        alarmRuleMapper.updateById(updateObj);
    }

    @Override
    @CacheEvict(value = "device-alarmRule", key = "#id")
    public void deleteAlarmRule(Long id) {
        // 校验存在
        this.validateAlarmRuleExists(id);
        // 删除
        alarmRuleMapper.deleteById(id);
    }

    private void validateAlarmRuleExists(Long id) {
        if (alarmRuleMapper.selectById(id) == null) {
            throw exception(ALARM_RULE_NOT_EXISTS);
        }
    }

    @Override
    @Cacheable(value = "device-alarmRule", key = "#id")
    public AlarmRuleDO getAlarmRule(Long id) {
        return alarmRuleMapper.selectById(id);
    }

    @Override
    public List<AlarmRuleDO> getAlarmRuleList(Collection<Long> ids) {
        return alarmRuleMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<AlarmRuleDO> getAlarmRulePage(AlarmRulePageReqVO pageReqVO) {
        return alarmRuleMapper.selectPage(pageReqVO);
    }

    @Override
    public List<AlarmRuleDO> getAlarmRuleList(AlarmRuleExportReqVO exportReqVO) {
        return alarmRuleMapper.selectList(exportReqVO);
    }

}
