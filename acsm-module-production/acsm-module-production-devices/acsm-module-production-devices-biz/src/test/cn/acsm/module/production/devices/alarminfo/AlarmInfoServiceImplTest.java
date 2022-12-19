package cn.acsm.module.production.devices.service.alarminfo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.module.infra.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.production.devices.controller.admin.alarminfo.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.alarminfo.AlarmInfoDO;
import cn.acsm.module.production.devices.dal.mysql.alarminfo.AlarmInfoMapper;
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
* {@link AlarmInfoServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(AlarmInfoServiceImpl.class)
public class AlarmInfoServiceImplTest extends BaseDbUnitTest {

    @Resource
    private AlarmInfoServiceImpl alarmInfoService;

    @Resource
    private AlarmInfoMapper alarmInfoMapper;

    @Test
    public void testCreateAlarmInfo_success() {
        // 准备参数
        AlarmInfoCreateReqVO reqVO = randomPojo(AlarmInfoCreateReqVO.class);

        // 调用
        Long alarmInfoId = alarmInfoService.createAlarmInfo(reqVO);
        // 断言
        assertNotNull(alarmInfoId);
        // 校验记录的属性是否正确
        AlarmInfoDO alarmInfo = alarmInfoMapper.selectById(alarmInfoId);
        assertPojoEquals(reqVO, alarmInfo);
    }

    @Test
    public void testUpdateAlarmInfo_success() {
        // mock 数据
        AlarmInfoDO dbAlarmInfo = randomPojo(AlarmInfoDO.class);
        alarmInfoMapper.insert(dbAlarmInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        AlarmInfoUpdateReqVO reqVO = randomPojo(AlarmInfoUpdateReqVO.class, o -> {
            o.setId(dbAlarmInfo.getId()); // 设置更新的 ID
        });

        // 调用
        alarmInfoService.updateAlarmInfo(reqVO);
        // 校验是否更新正确
        AlarmInfoDO alarmInfo = alarmInfoMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, alarmInfo);
    }

    @Test
    public void testUpdateAlarmInfo_notExists() {
        // 准备参数
        AlarmInfoUpdateReqVO reqVO = randomPojo(AlarmInfoUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> alarmInfoService.updateAlarmInfo(reqVO), ALARM_INFO_NOT_EXISTS);
    }

    @Test
    public void testDeleteAlarmInfo_success() {
        // mock 数据
        AlarmInfoDO dbAlarmInfo = randomPojo(AlarmInfoDO.class);
        alarmInfoMapper.insert(dbAlarmInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbAlarmInfo.getId();

        // 调用
        alarmInfoService.deleteAlarmInfo(id);
       // 校验数据不存在了
       assertNull(alarmInfoMapper.selectById(id));
    }

    @Test
    public void testDeleteAlarmInfo_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> alarmInfoService.deleteAlarmInfo(id), ALARM_INFO_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAlarmInfoPage() {
       // mock 数据
       AlarmInfoDO dbAlarmInfo = randomPojo(AlarmInfoDO.class, o -> { // 等会查询到
           o.setNumber(null);
           o.setAlarmType(null);
           o.setAlarmSource(null);
           o.setAlarmContent(null);
           o.setHappenDate(null);
           o.setHappenPlace(null);
           o.setNotifiers(null);
           o.setHandleStatus(null);
           o.setHandleContent(null);
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
           o.setDevicesId(null);
           o.setDeviceName(null);
           o.setDeviceSn(null);
           o.setSubjectName(null);
           o.setSilenceHour(null);
           o.setSilenceExpiry(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       alarmInfoMapper.insert(dbAlarmInfo);
       // 测试 number 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setNumber(null)));
       // 测试 alarmType 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setAlarmType(null)));
       // 测试 alarmSource 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setAlarmSource(null)));
       // 测试 alarmContent 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setAlarmContent(null)));
       // 测试 happenDate 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setHappenDate(null)));
       // 测试 happenPlace 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setHappenPlace(null)));
       // 测试 notifiers 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setNotifiers(null)));
       // 测试 handleStatus 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setHandleStatus(null)));
       // 测试 handleContent 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setHandleContent(null)));
       // 测试 officeCode 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setCompanyName(null)));
       // 测试 reviewStatus 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setCorpName(null)));
       // 测试 devicesId 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setDevicesId(null)));
       // 测试 deviceName 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setDeviceName(null)));
       // 测试 deviceSn 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setDeviceSn(null)));
       // 测试 subjectName 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setSubjectName(null)));
       // 测试 silenceHour 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setSilenceHour(null)));
       // 测试 silenceExpiry 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setSilenceExpiry(null)));
       // 测试 createTime 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setSubjectId(null)));
       // 准备参数
       AlarmInfoPageReqVO reqVO = new AlarmInfoPageReqVO();
       reqVO.setNumber(null);
       reqVO.setAlarmType(null);
       reqVO.setAlarmSource(null);
       reqVO.setAlarmContent(null);
       reqVO.setHappenDate((new LocalDateTime[]{}));
       reqVO.setHappenPlace(null);
       reqVO.setNotifiers(null);
       reqVO.setHandleStatus(null);
       reqVO.setHandleContent(null);
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
       reqVO.setDevicesId(null);
       reqVO.setDeviceName(null);
       reqVO.setDeviceSn(null);
       reqVO.setSubjectName(null);
       reqVO.setSilenceHour(null);
       reqVO.setSilenceExpiry(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       PageResult<AlarmInfoDO> pageResult = alarmInfoService.getAlarmInfoPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbAlarmInfo, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAlarmInfoList() {
       // mock 数据
       AlarmInfoDO dbAlarmInfo = randomPojo(AlarmInfoDO.class, o -> { // 等会查询到
           o.setNumber(null);
           o.setAlarmType(null);
           o.setAlarmSource(null);
           o.setAlarmContent(null);
           o.setHappenDate(null);
           o.setHappenPlace(null);
           o.setNotifiers(null);
           o.setHandleStatus(null);
           o.setHandleContent(null);
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
           o.setDevicesId(null);
           o.setDeviceName(null);
           o.setDeviceSn(null);
           o.setSubjectName(null);
           o.setSilenceHour(null);
           o.setSilenceExpiry(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       alarmInfoMapper.insert(dbAlarmInfo);
       // 测试 number 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setNumber(null)));
       // 测试 alarmType 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setAlarmType(null)));
       // 测试 alarmSource 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setAlarmSource(null)));
       // 测试 alarmContent 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setAlarmContent(null)));
       // 测试 happenDate 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setHappenDate(null)));
       // 测试 happenPlace 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setHappenPlace(null)));
       // 测试 notifiers 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setNotifiers(null)));
       // 测试 handleStatus 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setHandleStatus(null)));
       // 测试 handleContent 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setHandleContent(null)));
       // 测试 officeCode 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setCompanyName(null)));
       // 测试 reviewStatus 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setCorpName(null)));
       // 测试 devicesId 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setDevicesId(null)));
       // 测试 deviceName 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setDeviceName(null)));
       // 测试 deviceSn 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setDeviceSn(null)));
       // 测试 subjectName 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setSubjectName(null)));
       // 测试 silenceHour 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setSilenceHour(null)));
       // 测试 silenceExpiry 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setSilenceExpiry(null)));
       // 测试 createTime 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       alarmInfoMapper.insert(cloneIgnoreId(dbAlarmInfo, o -> o.setSubjectId(null)));
       // 准备参数
       AlarmInfoExportReqVO reqVO = new AlarmInfoExportReqVO();
       reqVO.setNumber(null);
       reqVO.setAlarmType(null);
       reqVO.setAlarmSource(null);
       reqVO.setAlarmContent(null);
       reqVO.setHappenDate((new LocalDateTime[]{}));
       reqVO.setHappenPlace(null);
       reqVO.setNotifiers(null);
       reqVO.setHandleStatus(null);
       reqVO.setHandleContent(null);
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
       reqVO.setDevicesId(null);
       reqVO.setDeviceName(null);
       reqVO.setDeviceSn(null);
       reqVO.setSubjectName(null);
       reqVO.setSilenceHour(null);
       reqVO.setSilenceExpiry(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       List<AlarmInfoDO> list = alarmInfoService.getAlarmInfoList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbAlarmInfo, list.get(0));
    }

}
