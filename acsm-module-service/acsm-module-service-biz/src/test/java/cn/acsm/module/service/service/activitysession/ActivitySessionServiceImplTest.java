package cn.acsm.module.service.service.activitysession;

import cn.acsm.module.service.controller.admin.activitysession.vo.ActivitySessionCreateReqVO;
import cn.acsm.module.service.controller.admin.activitysession.vo.ActivitySessionExportReqVO;
import cn.acsm.module.service.controller.admin.activitysession.vo.ActivitySessionPageReqVO;
import cn.acsm.module.service.controller.admin.activitysession.vo.ActivitySessionUpdateReqVO;
import cn.acsm.module.service.dal.dataobject.activitysession.ActivitySessionDO;
import cn.acsm.module.service.dal.mysql.activitysession.ActivitySessionMapper;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.acsm.module.service.enums.ErrorCodeConstants.ACTIVITY_SESSION_NOT_EXISTS;
import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link ActivitySessionServiceImpl} 的单元测试类
*
* @author smile
*/
@Import(ActivitySessionServiceImpl.class)
public class ActivitySessionServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ActivitySessionServiceImpl activitySessionService;

    @Resource
    private ActivitySessionMapper activitySessionMapper;

    @Test
    public void testCreateActivitySession_success() {
        // 准备参数
        ActivitySessionCreateReqVO reqVO = randomPojo(ActivitySessionCreateReqVO.class);

        // 调用
        String activitySessionId = activitySessionService.createActivitySession(reqVO);
        // 断言
        assertNotNull(activitySessionId);
        // 校验记录的属性是否正确
        ActivitySessionDO activitySession = activitySessionMapper.selectById(activitySessionId);
        assertPojoEquals(reqVO, activitySession);
    }

    @Test
    public void testUpdateActivitySession_success() {
        // mock 数据
        ActivitySessionDO dbActivitySession = randomPojo(ActivitySessionDO.class);
        activitySessionMapper.insert(dbActivitySession);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ActivitySessionUpdateReqVO reqVO = randomPojo(ActivitySessionUpdateReqVO.class, o -> {
            o.setId(dbActivitySession.getId()); // 设置更新的 ID
        });

        // 调用
        activitySessionService.updateActivitySession(reqVO);
        // 校验是否更新正确
        ActivitySessionDO activitySession = activitySessionMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, activitySession);
    }

    @Test
    public void testUpdateActivitySession_notExists() {
        // 准备参数
        ActivitySessionUpdateReqVO reqVO = randomPojo(ActivitySessionUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> activitySessionService.updateActivitySession(reqVO), ACTIVITY_SESSION_NOT_EXISTS);
    }

    @Test
    public void testDeleteActivitySession_success() {
        // mock 数据
        ActivitySessionDO dbActivitySession = randomPojo(ActivitySessionDO.class);
        activitySessionMapper.insert(dbActivitySession);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbActivitySession.getId();

        // 调用
        activitySessionService.deleteActivitySession(id);
       // 校验数据不存在了
       assertNull(activitySessionMapper.selectById(id));
    }

    @Test
    public void testDeleteActivitySession_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> activitySessionService.deleteActivitySession(id), ACTIVITY_SESSION_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetActivitySessionPage() {
       // mock 数据
       ActivitySessionDO dbActivitySession = randomPojo(ActivitySessionDO.class, o -> { // 等会查询到
           o.setMaxAttendPeople(null);
           o.setAttendPeople(null);
           o.setRegistrationFee(null);
           o.setActivityId(null);
           o.setStartTime(null);
           o.setRemarks(null);
           o.setServiceId(null);
           o.setStartDate(null);
           o.setEndDate(null);
           o.setEndTime(null);
           o.setBasesId(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
       });
       activitySessionMapper.insert(dbActivitySession);
       // 测试 maxAttendPeople 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setMaxAttendPeople(null)));
       // 测试 attendPeople 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setAttendPeople(null)));
       // 测试 registrationFee 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setRegistrationFee(null)));
       // 测试 activityId 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setActivityId(null)));
       // 测试 startTime 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setStartTime(null)));
       // 测试 remarks 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setRemarks(null)));
       // 测试 serviceId 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setServiceId(null)));
       // 测试 startDate 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setStartDate(null)));
       // 测试 endDate 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setEndDate(null)));
       // 测试 endTime 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setEndTime(null)));
       // 测试 basesId 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setBasesId(null)));
       // 测试 status 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setSource(null)));
       // 准备参数
       ActivitySessionPageReqVO reqVO = new ActivitySessionPageReqVO();
       reqVO.setMaxAttendPeople(null);
       reqVO.setAttendPeople(null);
       reqVO.setRegistrationFee(null);
       reqVO.setActivityId(null);
       reqVO.setStartTime((new String[]{}));
       reqVO.setRemarks(null);
       reqVO.setServiceId(null);
       reqVO.setStartDate((new String[]{}));
       reqVO.setEndDate((new Date[]{}));
       reqVO.setEndTime((new String[]{}));
       reqVO.setBasesId(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);

       // 调用
       PageResult<ActivitySessionDO> pageResult = activitySessionService.getActivitySessionPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbActivitySession, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetActivitySessionList() {
       // mock 数据
       ActivitySessionDO dbActivitySession = randomPojo(ActivitySessionDO.class, o -> { // 等会查询到
           o.setMaxAttendPeople(null);
           o.setAttendPeople(null);
           o.setRegistrationFee(null);
           o.setActivityId(null);
           o.setStartTime(null);
           o.setRemarks(null);
           o.setServiceId(null);
           o.setStartDate(null);
           o.setEndDate(null);
           o.setEndTime(null);
           o.setBasesId(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
       });
       activitySessionMapper.insert(dbActivitySession);
       // 测试 maxAttendPeople 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setMaxAttendPeople(null)));
       // 测试 attendPeople 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setAttendPeople(null)));
       // 测试 registrationFee 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setRegistrationFee(null)));
       // 测试 activityId 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setActivityId(null)));
       // 测试 startTime 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setStartTime(null)));
       // 测试 remarks 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setRemarks(null)));
       // 测试 serviceId 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setServiceId(null)));
       // 测试 startDate 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setStartDate(null)));
       // 测试 endDate 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setEndDate(null)));
       // 测试 endTime 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setEndTime(null)));
       // 测试 basesId 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setBasesId(null)));
       // 测试 status 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       activitySessionMapper.insert(cloneIgnoreId(dbActivitySession, o -> o.setSource(null)));
       // 准备参数
       ActivitySessionExportReqVO reqVO = new ActivitySessionExportReqVO();
       reqVO.setMaxAttendPeople(null);
       reqVO.setAttendPeople(null);
       reqVO.setRegistrationFee(null);
       reqVO.setActivityId(null);
        reqVO.setStartTime((new String[]{}));
        reqVO.setRemarks(null);
        reqVO.setServiceId(null);
        reqVO.setStartDate((new String[]{}));
        reqVO.setEndDate((new Date[]{}));
        reqVO.setEndTime((new String[]{}));
        reqVO.setBasesId(null);
        reqVO.setStatus(null);
        reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);

       // 调用
       List<ActivitySessionDO> list = activitySessionService.getActivitySessionList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbActivitySession, list.get(0));
    }

}
