package cn.acsm.module.production.devices.service.time;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.module.infra.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.production.devices.controller.admin.time.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.time.TimeDO;
import cn.acsm.module.production.devices.dal.mysql.time.TimeMapper;
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
* {@link TimeServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(TimeServiceImpl.class)
public class TimeServiceImplTest extends BaseDbUnitTest {

    @Resource
    private TimeServiceImpl timeService;

    @Resource
    private TimeMapper timeMapper;

    @Test
    public void testCreateTime_success() {
        // 准备参数
        TimeCreateReqVO reqVO = randomPojo(TimeCreateReqVO.class);

        // 调用
        Integer timeId = timeService.createTime(reqVO);
        // 断言
        assertNotNull(timeId);
        // 校验记录的属性是否正确
        TimeDO time = timeMapper.selectById(timeId);
        assertPojoEquals(reqVO, time);
    }

    @Test
    public void testUpdateTime_success() {
        // mock 数据
        TimeDO dbTime = randomPojo(TimeDO.class);
        timeMapper.insert(dbTime);// @Sql: 先插入出一条存在的数据
        // 准备参数
        TimeUpdateReqVO reqVO = randomPojo(TimeUpdateReqVO.class, o -> {
            o.setId(dbTime.getId()); // 设置更新的 ID
        });

        // 调用
        timeService.updateTime(reqVO);
        // 校验是否更新正确
        TimeDO time = timeMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, time);
    }

    @Test
    public void testUpdateTime_notExists() {
        // 准备参数
        TimeUpdateReqVO reqVO = randomPojo(TimeUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> timeService.updateTime(reqVO), TIME_NOT_EXISTS);
    }

    @Test
    public void testDeleteTime_success() {
        // mock 数据
        TimeDO dbTime = randomPojo(TimeDO.class);
        timeMapper.insert(dbTime);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Integer id = dbTime.getId();

        // 调用
        timeService.deleteTime(id);
       // 校验数据不存在了
       assertNull(timeMapper.selectById(id));
    }

    @Test
    public void testDeleteTime_notExists() {
        // 准备参数
        Integer id = randomIntegerId();

        // 调用, 并断言异常
        assertServiceException(() -> timeService.deleteTime(id), TIME_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetTimePage() {
       // mock 数据
       TimeDO dbTime = randomPojo(TimeDO.class, o -> { // 等会查询到
           o.setDeviceSn(null);
           o.setOnline(null);
           o.setDevicesDate(null);
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
       timeMapper.insert(dbTime);
       // 测试 deviceSn 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setDeviceSn(null)));
       // 测试 online 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setOnline(null)));
       // 测试 devicesDate 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setDevicesDate(null)));
       // 测试 officeCode 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setCompanyName(null)));
       // 测试 reviewStatus 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setCorpName(null)));
       // 测试 createTime 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setSubjectId(null)));
       // 准备参数
       TimePageReqVO reqVO = new TimePageReqVO();
       reqVO.setDeviceSn(null);
       reqVO.setOnline(null);
       reqVO.setDevicesDate((new LocalDateTime[]{}));
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
       PageResult<TimeDO> pageResult = timeService.getTimePage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbTime, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetTimeList() {
       // mock 数据
       TimeDO dbTime = randomPojo(TimeDO.class, o -> { // 等会查询到
           o.setDeviceSn(null);
           o.setOnline(null);
           o.setDevicesDate(null);
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
       timeMapper.insert(dbTime);
       // 测试 deviceSn 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setDeviceSn(null)));
       // 测试 online 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setOnline(null)));
       // 测试 devicesDate 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setDevicesDate(null)));
       // 测试 officeCode 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setCompanyName(null)));
       // 测试 reviewStatus 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setCorpName(null)));
       // 测试 createTime 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       timeMapper.insert(cloneIgnoreId(dbTime, o -> o.setSubjectId(null)));
       // 准备参数
       TimeExportReqVO reqVO = new TimeExportReqVO();
       reqVO.setDeviceSn(null);
       reqVO.setOnline(null);
       reqVO.setDevicesDate((new LocalDateTime[]{}));
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
       List<TimeDO> list = timeService.getTimeList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbTime, list.get(0));
    }

}
