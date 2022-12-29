package cn.acsm.module.production.devices.service.alarminfo;

import cn.acsm.module.production.devices.controller.admin.alarminfo.vo.AlarmInfoCreateReqVO;
import cn.acsm.module.production.devices.controller.admin.alarminfo.vo.AlarmInfoExportReqVO;
import cn.acsm.module.production.devices.controller.admin.alarminfo.vo.AlarmInfoPageReqVO;
import cn.acsm.module.production.devices.controller.admin.alarminfo.vo.AlarmInfoUpdateReqVO;
import cn.acsm.module.production.devices.convert.alarminfo.AlarmInfoConvert;
import cn.acsm.module.production.devices.dal.dataobject.alarminfo.AlarmInfoDO;
import cn.acsm.module.production.devices.dal.mysql.alarminfo.AlarmInfoMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.production.devices.enums.ErrorCodeConstants.ALARM_INFO_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

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
    @CacheEvict(value = "devices-alarmInfo", key = "#updateReqVO.id")
    public void updateAlarmInfo(AlarmInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateAlarmInfoExists(updateReqVO.getId());
        // 更新
        AlarmInfoDO updateObj = AlarmInfoConvert.INSTANCE.convert(updateReqVO);
        alarmInfoMapper.updateById(updateObj);
    }

    @Override
    @CacheEvict(value = "devices-alarmInfo", key = "#id")
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
    @Cacheable(value = "devices-alarmInfo", key = "#id")
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
