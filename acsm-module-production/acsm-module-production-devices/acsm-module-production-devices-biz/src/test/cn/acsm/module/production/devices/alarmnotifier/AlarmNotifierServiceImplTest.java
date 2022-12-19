package cn.acsm.module.production.devices.service.alarmnotifier;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.module.infra.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.production.devices.controller.admin.alarmnotifier.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.alarmnotifier.AlarmNotifierDO;
import cn.acsm.module.production.devices.dal.mysql.alarmnotifier.AlarmNotifierMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.acsm.module.production.devices.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.module.infra.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.module.infra.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link AlarmNotifierServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(AlarmNotifierServiceImpl.class)
public class AlarmNotifierServiceImplTest extends BaseDbUnitTest {

    @Resource
    private AlarmNotifierServiceImpl alarmNotifierService;

    @Resource
    private AlarmNotifierMapper alarmNotifierMapper;

    @Test
    public void testCreateAlarmNotifier_success() {
        // 准备参数
        AlarmNotifierCreateReqVO reqVO = randomPojo(AlarmNotifierCreateReqVO.class);

        // 调用
        Long alarmNotifierId = alarmNotifierService.createAlarmNotifier(reqVO);
        // 断言
        assertNotNull(alarmNotifierId);
        // 校验记录的属性是否正确
        AlarmNotifierDO alarmNotifier = alarmNotifierMapper.selectById(alarmNotifierId);
        assertPojoEquals(reqVO, alarmNotifier);
    }

    @Test
    public void testUpdateAlarmNotifier_success() {
        // mock 数据
        AlarmNotifierDO dbAlarmNotifier = randomPojo(AlarmNotifierDO.class);
        alarmNotifierMapper.insert(dbAlarmNotifier);// @Sql: 先插入出一条存在的数据
        // 准备参数
        AlarmNotifierUpdateReqVO reqVO = randomPojo(AlarmNotifierUpdateReqVO.class, o -> {
            o.setId(dbAlarmNotifier.getId()); // 设置更新的 ID
        });

        // 调用
        alarmNotifierService.updateAlarmNotifier(reqVO);
        // 校验是否更新正确
        AlarmNotifierDO alarmNotifier = alarmNotifierMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, alarmNotifier);
    }

    @Test
    public void testUpdateAlarmNotifier_notExists() {
        // 准备参数
        AlarmNotifierUpdateReqVO reqVO = randomPojo(AlarmNotifierUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> alarmNotifierService.updateAlarmNotifier(reqVO), ALARM_NOTIFIER_NOT_EXISTS);
    }

    @Test
    public void testDeleteAlarmNotifier_success() {
        // mock 数据
        AlarmNotifierDO dbAlarmNotifier = randomPojo(AlarmNotifierDO.class);
        alarmNotifierMapper.insert(dbAlarmNotifier);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbAlarmNotifier.getId();

        // 调用
        alarmNotifierService.deleteAlarmNotifier(id);
       // 校验数据不存在了
       assertNull(alarmNotifierMapper.selectById(id));
    }

    @Test
    public void testDeleteAlarmNotifier_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> alarmNotifierService.deleteAlarmNotifier(id), ALARM_NOTIFIER_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAlarmNotifierPage() {
       // mock 数据
       AlarmNotifierDO dbAlarmNotifier = randomPojo(AlarmNotifierDO.class, o -> { // 等会查询到
           o.setNumber(null);
           o.setAlarmType(null);
           o.setNotifyType(null);
           o.setNotifier(null);
           o.setMobile(null);
           o.setOfficeCode(null);
           o.setOfficeName(null);
           o.setCompanyCode(null);
           o.setCompanyName(null);
           o.setReviewStatus(null);
           o.setReviewer(null);
           o.setReviewDate(null);
           o.setReviewContent(null);
           o.setCorpCode(null);
           o.setCorpName(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       alarmNotifierMapper.insert(dbAlarmNotifier);
       // 测试 number 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setNumber(null)));
       // 测试 alarmType 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setAlarmType(null)));
       // 测试 notifyType 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setNotifyType(null)));
       // 测试 notifier 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setNotifier(null)));
       // 测试 mobile 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setMobile(null)));
       // 测试 officeCode 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setCompanyName(null)));
       // 测试 reviewStatus 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setCorpName(null)));
       // 测试 createTime 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setSubjectId(null)));
       // 准备参数
       AlarmNotifierPageReqVO reqVO = new AlarmNotifierPageReqVO();
       reqVO.setNumber(null);
       reqVO.setAlarmType(null);
       reqVO.setNotifyType(null);
       reqVO.setNotifier(null);
       reqVO.setMobile(null);
       reqVO.setOfficeCode(null);
       reqVO.setOfficeName(null);
       reqVO.setCompanyCode(null);
       reqVO.setCompanyName(null);
       reqVO.setReviewStatus(null);
       reqVO.setReviewer(null);
       reqVO.setReviewDate((new LocalDateTime[]{}));
       reqVO.setReviewContent(null);
       reqVO.setCorpCode(null);
       reqVO.setCorpName(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       PageResult<AlarmNotifierDO> pageResult = alarmNotifierService.getAlarmNotifierPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbAlarmNotifier, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAlarmNotifierList() {
       // mock 数据
       AlarmNotifierDO dbAlarmNotifier = randomPojo(AlarmNotifierDO.class, o -> { // 等会查询到
           o.setNumber(null);
           o.setAlarmType(null);
           o.setNotifyType(null);
           o.setNotifier(null);
           o.setMobile(null);
           o.setOfficeCode(null);
           o.setOfficeName(null);
           o.setCompanyCode(null);
           o.setCompanyName(null);
           o.setReviewStatus(null);
           o.setReviewer(null);
           o.setReviewDate(null);
           o.setReviewContent(null);
           o.setCorpCode(null);
           o.setCorpName(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       alarmNotifierMapper.insert(dbAlarmNotifier);
       // 测试 number 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setNumber(null)));
       // 测试 alarmType 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setAlarmType(null)));
       // 测试 notifyType 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setNotifyType(null)));
       // 测试 notifier 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setNotifier(null)));
       // 测试 mobile 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setMobile(null)));
       // 测试 officeCode 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setCompanyName(null)));
       // 测试 reviewStatus 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setCorpName(null)));
       // 测试 createTime 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       alarmNotifierMapper.insert(cloneIgnoreId(dbAlarmNotifier, o -> o.setSubjectId(null)));
       // 准备参数
       AlarmNotifierExportReqVO reqVO = new AlarmNotifierExportReqVO();
       reqVO.setNumber(null);
       reqVO.setAlarmType(null);
       reqVO.setNotifyType(null);
       reqVO.setNotifier(null);
       reqVO.setMobile(null);
       reqVO.setOfficeCode(null);
       reqVO.setOfficeName(null);
       reqVO.setCompanyCode(null);
       reqVO.setCompanyName(null);
       reqVO.setReviewStatus(null);
       reqVO.setReviewer(null);
       reqVO.setReviewDate((new LocalDateTime[]{}));
       reqVO.setReviewContent(null);
       reqVO.setCorpCode(null);
       reqVO.setCorpName(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       List<AlarmNotifierDO> list = alarmNotifierService.getAlarmNotifierList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbAlarmNotifier, list.get(0));
    }

}
