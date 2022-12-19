package cn.acsm.module.production.devices.service.alarminfo;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.production.devices.controller.admin.alarminfo.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.alarminfo.AlarmInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.production.devices.convert.alarminfo.AlarmInfoConvert;
import cn.acsm.module.production.devices.dal.mysql.alarminfo.AlarmInfoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.production.devices.enums.ErrorCodeConstants.*;

/**
 * 告警信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class AlarmInfoServiceImpl implements AlarmInfoService {

    @Resource
    private AlarmInfoMapper alarmInfoMapper;

    @Override
    public Long createAlarmInfo(AlarmInfoCreateReqVO createReqVO) {
        // 插入
        AlarmInfoDO alarmInfo = AlarmInfoConvert.INSTANCE.convert(createReqVO);
        alarmInfoMapper.insert(alarmInfo);
        // 返回
        return alarmInfo.getId();
    }

    @Override
    public void updateAlarmInfo(AlarmInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateAlarmInfoExists(updateReqVO.getId());
        // 更新
        AlarmInfoDO updateObj = AlarmInfoConvert.INSTANCE.convert(updateReqVO);
        alarmInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteAlarmInfo(Long id) {
        // 校验存在
        this.validateAlarmInfoExists(id);
        // 删除
        alarmInfoMapper.deleteById(id);
    }

    private void validateAlarmInfoExists(Long id) {
        if (alarmInfoMapper.selectById(id) == null) {
            throw exception(ALARM_INFO_NOT_EXISTS);
        }
    }

    @Override
    public AlarmInfoDO getAlarmInfo(Long id) {
        return alarmInfoMapper.selectById(id);
    }

    @Override
    public List<AlarmInfoDO> getAlarmInfoList(Collection<Long> ids) {
        return alarmInfoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<AlarmInfoDO> getAlarmInfoPage(AlarmInfoPageReqVO pageReqVO) {
        return alarmInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<AlarmInfoDO> getAlarmInfoList(AlarmInfoExportReqVO exportReqVO) {
        return alarmInfoMapper.selectList(exportReqVO);
    }

}
