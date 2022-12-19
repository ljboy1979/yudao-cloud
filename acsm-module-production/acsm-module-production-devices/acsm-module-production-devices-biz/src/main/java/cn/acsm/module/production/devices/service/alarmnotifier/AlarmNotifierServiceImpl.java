package cn.acsm.module.production.devices.service.alarmnotifier;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.production.devices.controller.admin.alarmnotifier.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.alarmnotifier.AlarmNotifierDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.production.devices.convert.alarmnotifier.AlarmNotifierConvert;
import cn.acsm.module.production.devices.dal.mysql.alarmnotifier.AlarmNotifierMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.production.devices.enums.ErrorCodeConstants.*;

/**
 * 告警通知规则 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class AlarmNotifierServiceImpl implements AlarmNotifierService {

    @Resource
    private AlarmNotifierMapper alarmNotifierMapper;

    @Override
    public Long createAlarmNotifier(AlarmNotifierCreateReqVO createReqVO) {
        // 插入
        AlarmNotifierDO alarmNotifier = AlarmNotifierConvert.INSTANCE.convert(createReqVO);
        alarmNotifierMapper.insert(alarmNotifier);
        // 返回
        return alarmNotifier.getId();
    }

    @Override
    public void updateAlarmNotifier(AlarmNotifierUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateAlarmNotifierExists(updateReqVO.getId());
        // 更新
        AlarmNotifierDO updateObj = AlarmNotifierConvert.INSTANCE.convert(updateReqVO);
        alarmNotifierMapper.updateById(updateObj);
    }

    @Override
    public void deleteAlarmNotifier(Long id) {
        // 校验存在
        this.validateAlarmNotifierExists(id);
        // 删除
        alarmNotifierMapper.deleteById(id);
    }

    private void validateAlarmNotifierExists(Long id) {
        if (alarmNotifierMapper.selectById(id) == null) {
            throw exception(ALARM_NOTIFIER_NOT_EXISTS);
        }
    }

    @Override
    public AlarmNotifierDO getAlarmNotifier(Long id) {
        return alarmNotifierMapper.selectById(id);
    }

    @Override
    public List<AlarmNotifierDO> getAlarmNotifierList(Collection<Long> ids) {
        return alarmNotifierMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<AlarmNotifierDO> getAlarmNotifierPage(AlarmNotifierPageReqVO pageReqVO) {
        return alarmNotifierMapper.selectPage(pageReqVO);
    }

    @Override
    public List<AlarmNotifierDO> getAlarmNotifierList(AlarmNotifierExportReqVO exportReqVO) {
        return alarmNotifierMapper.selectList(exportReqVO);
    }

}
