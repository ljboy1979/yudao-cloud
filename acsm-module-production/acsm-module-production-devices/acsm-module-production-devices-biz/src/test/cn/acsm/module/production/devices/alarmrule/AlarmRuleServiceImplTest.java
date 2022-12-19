package cn.acsm.module.production.devices.service.alarmrule;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.module.infra.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.production.devices.controller.admin.alarmrule.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.alarmrule.AlarmRuleDO;
import cn.acsm.module.production.devices.dal.mysql.alarmrule.AlarmRuleMapper;
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
* {@link AlarmRuleServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(AlarmRuleServiceImpl.class)
public class AlarmRuleServiceImplTest extends BaseDbUnitTest {

    @Resource
    private AlarmRuleServiceImpl alarmRuleService;

    @Resource
    private AlarmRuleMapper alarmRuleMapper;

    @Test
    public void testCreateAlarmRule_success() {
        // 准备参数
        AlarmRuleCreateReqVO reqVO = randomPojo(AlarmRuleCreateReqVO.class);

        // 调用
        Long alarmRuleId = alarmRuleService.createAlarmRule(reqVO);
        // 断言
        assertNotNull(alarmRuleId);
        // 校验记录的属性是否正确
        AlarmRuleDO alarmRule = alarmRuleMapper.selectById(alarmRuleId);
        assertPojoEquals(reqVO, alarmRule);
    }

    @Test
    public void testUpdateAlarmRule_success() {
        // mock 数据
        AlarmRuleDO dbAlarmRule = randomPojo(AlarmRuleDO.class);
        alarmRuleMapper.insert(dbAlarmRule);// @Sql: 先插入出一条存在的数据
        // 准备参数
        AlarmRuleUpdateReqVO reqVO = randomPojo(AlarmRuleUpdateReqVO.class, o -> {
            o.setId(dbAlarmRule.getId()); // 设置更新的 ID
        });

        // 调用
        alarmRuleService.updateAlarmRule(reqVO);
        // 校验是否更新正确
        AlarmRuleDO alarmRule = alarmRuleMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, alarmRule);
    }

    @Test
    public void testUpdateAlarmRule_notExists() {
        // 准备参数
        AlarmRuleUpdateReqVO reqVO = randomPojo(AlarmRuleUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> alarmRuleService.updateAlarmRule(reqVO), ALARM_RULE_NOT_EXISTS);
    }

    @Test
    public void testDeleteAlarmRule_success() {
        // mock 数据
        AlarmRuleDO dbAlarmRule = randomPojo(AlarmRuleDO.class);
        alarmRuleMapper.insert(dbAlarmRule);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbAlarmRule.getId();

        // 调用
        alarmRuleService.deleteAlarmRule(id);
       // 校验数据不存在了
       assertNull(alarmRuleMapper.selectById(id));
    }

    @Test
    public void testDeleteAlarmRule_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> alarmRuleService.deleteAlarmRule(id), ALARM_RULE_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAlarmRulePage() {
       // mock 数据
       AlarmRuleDO dbAlarmRule = randomPojo(AlarmRuleDO.class, o -> { // 等会查询到
           o.setDeviceId(null);
           o.setParamId(null);
           o.setAlarmType(null);
           o.setAlarmUp(null);
           o.setAlarmDown(null);
           o.setAlarmContent(null);
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
           o.setParamName(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       alarmRuleMapper.insert(dbAlarmRule);
       // 测试 deviceId 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setDeviceId(null)));
       // 测试 paramId 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setParamId(null)));
       // 测试 alarmType 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setAlarmType(null)));
       // 测试 alarmUp 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setAlarmUp(null)));
       // 测试 alarmDown 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setAlarmDown(null)));
       // 测试 alarmContent 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setAlarmContent(null)));
       // 测试 officeCode 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setCompanyName(null)));
       // 测试 reviewStatus 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setCorpName(null)));
       // 测试 paramName 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setParamName(null)));
       // 测试 createTime 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setSubjectId(null)));
       // 准备参数
       AlarmRulePageReqVO reqVO = new AlarmRulePageReqVO();
       reqVO.setDeviceId(null);
       reqVO.setParamId(null);
       reqVO.setAlarmType(null);
       reqVO.setAlarmUp(null);
       reqVO.setAlarmDown(null);
       reqVO.setAlarmContent(null);
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
       reqVO.setParamName(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       PageResult<AlarmRuleDO> pageResult = alarmRuleService.getAlarmRulePage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbAlarmRule, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAlarmRuleList() {
       // mock 数据
       AlarmRuleDO dbAlarmRule = randomPojo(AlarmRuleDO.class, o -> { // 等会查询到
           o.setDeviceId(null);
           o.setParamId(null);
           o.setAlarmType(null);
           o.setAlarmUp(null);
           o.setAlarmDown(null);
           o.setAlarmContent(null);
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
           o.setParamName(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       alarmRuleMapper.insert(dbAlarmRule);
       // 测试 deviceId 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setDeviceId(null)));
       // 测试 paramId 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setParamId(null)));
       // 测试 alarmType 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setAlarmType(null)));
       // 测试 alarmUp 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setAlarmUp(null)));
       // 测试 alarmDown 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setAlarmDown(null)));
       // 测试 alarmContent 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setAlarmContent(null)));
       // 测试 officeCode 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setCompanyName(null)));
       // 测试 reviewStatus 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setCorpName(null)));
       // 测试 paramName 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setParamName(null)));
       // 测试 createTime 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       alarmRuleMapper.insert(cloneIgnoreId(dbAlarmRule, o -> o.setSubjectId(null)));
       // 准备参数
       AlarmRuleExportReqVO reqVO = new AlarmRuleExportReqVO();
       reqVO.setDeviceId(null);
       reqVO.setParamId(null);
       reqVO.setAlarmType(null);
       reqVO.setAlarmUp(null);
       reqVO.setAlarmDown(null);
       reqVO.setAlarmContent(null);
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
       reqVO.setParamName(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       List<AlarmRuleDO> list = alarmRuleService.getAlarmRuleList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbAlarmRule, list.get(0));
    }

}
