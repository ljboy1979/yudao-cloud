package cn.acsm.module.production.devices.service.time;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.production.devices.controller.admin.time.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.time.TimeDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.production.devices.convert.time.TimeConvert;
import cn.acsm.module.production.devices.dal.mysql.time.TimeMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.production.devices.enums.ErrorCodeConstants.*;

/**
 * 设备运行时间 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class TimeServiceImpl implements TimeService {

    @Resource
    private TimeMapper timeMapper;

    @Override
    public Integer createTime(TimeCreateReqVO createReqVO) {
        // 插入
        TimeDO time = TimeConvert.INSTANCE.convert(createReqVO);
        timeMapper.insert(time);
        // 返回
        return time.getId();
    }

    @Override
    public void updateTime(TimeUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateTimeExists(updateReqVO.getId());
        // 更新
        TimeDO updateObj = TimeConvert.INSTANCE.convert(updateReqVO);
        timeMapper.updateById(updateObj);
    }

    @Override
    public void deleteTime(Integer id) {
        // 校验存在
        this.validateTimeExists(id);
        // 删除
        timeMapper.deleteById(id);
    }

    private void validateTimeExists(Integer id) {
        if (timeMapper.selectById(id) == null) {
            throw exception(TIME_NOT_EXISTS);
        }
    }

    @Override
    public TimeDO getTime(Integer id) {
        return timeMapper.selectById(id);
    }

    @Override
    public List<TimeDO> getTimeList(Collection<Integer> ids) {
        return timeMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<TimeDO> getTimePage(TimePageReqVO pageReqVO) {
        return timeMapper.selectPage(pageReqVO);
    }

    @Override
    public List<TimeDO> getTimeList(TimeExportReqVO exportReqVO) {
        return timeMapper.selectList(exportReqVO);
    }

}
