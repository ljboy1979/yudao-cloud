package cn.acsm.module.service.service.activitysession;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.service.controller.admin.activitysession.vo.*;
import cn.acsm.module.service.dal.dataobject.activitysession.ActivitySessionDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.service.convert.activitysession.ActivitySessionConvert;
import cn.acsm.module.service.dal.mysql.activitysession.ActivitySessionMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.service.enums.ErrorCodeConstants.*;

/**
 * 时间排期 Service 实现类
 *
 * @author smile
 */
@Service
@Validated
@Transactional(readOnly = false)
public class ActivitySessionServiceImpl implements ActivitySessionService {

    @Resource
    private ActivitySessionMapper activitySessionMapper;

    @Override
    public String createActivitySession(ActivitySessionCreateReqVO createReqVO) {
        List<ActivitySessionBaseVO> list = createReqVO.getRoleIdss();
        for (int i = 0; i < list.size(); i++) {
            createReqVO.setEndTime(list.get(i).getEndTime());
            createReqVO.setStartTime(list.get(i).getStartTime());
            createReqVO.setMaxAttendPeople(list.get(i).getMaxAttendPeople());
            // 插入
            ActivitySessionDO activitySession = ActivitySessionConvert.INSTANCE.convert(createReqVO);
            activitySessionMapper.insert(activitySession);
        }


        // 返回
        return "保存成功";
    }

    @Override
    public void updateActivitySession(ActivitySessionUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateActivitySessionExists(updateReqVO.getId());
        // 更新
        ActivitySessionDO updateObj = ActivitySessionConvert.INSTANCE.convert(updateReqVO);
        activitySessionMapper.updateById(updateObj);
    }

    @Override
    public void deleteActivitySession(Long id) {
        // 校验存在
        this.validateActivitySessionExists(id);
        // 删除
        activitySessionMapper.deleteById(id);
    }

    private void validateActivitySessionExists(Long id) {
        if (activitySessionMapper.selectById(id) == null) {
            throw exception(ACTIVITY_SESSION_NOT_EXISTS);
        }
    }

    @Override
    public ActivitySessionDO getActivitySession(Long id) {
        return activitySessionMapper.selectById(id);
    }

    @Override
    public List<ActivitySessionDO> getActivitySessionList(Collection<Long> ids) {
        return activitySessionMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ActivitySessionDO> getActivitySessionPage(ActivitySessionPageReqVO pageReqVO) {
        return activitySessionMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ActivitySessionDO> getActivitySessionList(ActivitySessionExportReqVO exportReqVO) {
        return activitySessionMapper.selectList(exportReqVO);
    }

}
