package cn.acsm.module.production.devices.service.access;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.module.infra.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.production.devices.controller.admin.access.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.access.AccessDO;
import cn.acsm.module.production.devices.dal.mysql.access.AccessMapper;
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
* {@link AccessServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(AccessServiceImpl.class)
public class AccessServiceImplTest extends BaseDbUnitTest {

    @Resource
    private AccessServiceImpl accessService;

    @Resource
    private AccessMapper accessMapper;

    @Test
    public void testCreateAccess_success() {
        // 准备参数
        AccessCreateReqVO reqVO = randomPojo(AccessCreateReqVO.class);

        // 调用
        Long accessId = accessService.createAccess(reqVO);
        // 断言
        assertNotNull(accessId);
        // 校验记录的属性是否正确
        AccessDO access = accessMapper.selectById(accessId);
        assertPojoEquals(reqVO, access);
    }

    @Test
    public void testUpdateAccess_success() {
        // mock 数据
        AccessDO dbAccess = randomPojo(AccessDO.class);
        accessMapper.insert(dbAccess);// @Sql: 先插入出一条存在的数据
        // 准备参数
        AccessUpdateReqVO reqVO = randomPojo(AccessUpdateReqVO.class, o -> {
            o.setId(dbAccess.getId()); // 设置更新的 ID
        });

        // 调用
        accessService.updateAccess(reqVO);
        // 校验是否更新正确
        AccessDO access = accessMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, access);
    }

    @Test
    public void testUpdateAccess_notExists() {
        // 准备参数
        AccessUpdateReqVO reqVO = randomPojo(AccessUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> accessService.updateAccess(reqVO), ACCESS_NOT_EXISTS);
    }

    @Test
    public void testDeleteAccess_success() {
        // mock 数据
        AccessDO dbAccess = randomPojo(AccessDO.class);
        accessMapper.insert(dbAccess);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbAccess.getId();

        // 调用
        accessService.deleteAccess(id);
       // 校验数据不存在了
       assertNull(accessMapper.selectById(id));
    }

    @Test
    public void testDeleteAccess_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> accessService.deleteAccess(id), ACCESS_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAccessPage() {
       // mock 数据
       AccessDO dbAccess = randomPojo(AccessDO.class, o -> { // 等会查询到
           o.setDeviceId(null);
           o.setAccessPhone(null);
           o.setAccessWay(null);
           o.setInsertTime(null);
           o.setRemarks(null);
           o.setReviewStatus(null);
           o.setReviewer(null);
           o.setReviewDate(null);
           o.setReviewContent(null);
           o.setOfficeCode(null);
           o.setOfficeName(null);
           o.setCompanyCode(null);
           o.setCompanyName(null);
           o.setCorpCode(null);
           o.setCorpName(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       accessMapper.insert(dbAccess);
       // 测试 deviceId 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setDeviceId(null)));
       // 测试 accessPhone 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setAccessPhone(null)));
       // 测试 accessWay 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setAccessWay(null)));
       // 测试 insertTime 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setInsertTime(null)));
       // 测试 remarks 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setRemarks(null)));
       // 测试 reviewStatus 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setReviewContent(null)));
       // 测试 officeCode 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setCompanyName(null)));
       // 测试 corpCode 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setCorpName(null)));
       // 测试 createTime 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setSubjectId(null)));
       // 准备参数
       AccessPageReqVO reqVO = new AccessPageReqVO();
       reqVO.setDeviceId(null);
       reqVO.setAccessPhone(null);
       reqVO.setAccessWay(null);
       reqVO.setInsertTime((new LocalDateTime[]{}));
       reqVO.setRemarks(null);
       reqVO.setReviewStatus(null);
       reqVO.setReviewer(null);
       reqVO.setReviewDate((new LocalDateTime[]{}));
       reqVO.setReviewContent(null);
       reqVO.setOfficeCode(null);
       reqVO.setOfficeName(null);
       reqVO.setCompanyCode(null);
       reqVO.setCompanyName(null);
       reqVO.setCorpCode(null);
       reqVO.setCorpName(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       PageResult<AccessDO> pageResult = accessService.getAccessPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbAccess, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAccessList() {
       // mock 数据
       AccessDO dbAccess = randomPojo(AccessDO.class, o -> { // 等会查询到
           o.setDeviceId(null);
           o.setAccessPhone(null);
           o.setAccessWay(null);
           o.setInsertTime(null);
           o.setRemarks(null);
           o.setReviewStatus(null);
           o.setReviewer(null);
           o.setReviewDate(null);
           o.setReviewContent(null);
           o.setOfficeCode(null);
           o.setOfficeName(null);
           o.setCompanyCode(null);
           o.setCompanyName(null);
           o.setCorpCode(null);
           o.setCorpName(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       accessMapper.insert(dbAccess);
       // 测试 deviceId 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setDeviceId(null)));
       // 测试 accessPhone 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setAccessPhone(null)));
       // 测试 accessWay 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setAccessWay(null)));
       // 测试 insertTime 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setInsertTime(null)));
       // 测试 remarks 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setRemarks(null)));
       // 测试 reviewStatus 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setReviewContent(null)));
       // 测试 officeCode 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setCompanyName(null)));
       // 测试 corpCode 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setCorpName(null)));
       // 测试 createTime 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       accessMapper.insert(cloneIgnoreId(dbAccess, o -> o.setSubjectId(null)));
       // 准备参数
       AccessExportReqVO reqVO = new AccessExportReqVO();
       reqVO.setDeviceId(null);
       reqVO.setAccessPhone(null);
       reqVO.setAccessWay(null);
       reqVO.setInsertTime((new LocalDateTime[]{}));
       reqVO.setRemarks(null);
       reqVO.setReviewStatus(null);
       reqVO.setReviewer(null);
       reqVO.setReviewDate((new LocalDateTime[]{}));
       reqVO.setReviewContent(null);
       reqVO.setOfficeCode(null);
       reqVO.setOfficeName(null);
       reqVO.setCompanyCode(null);
       reqVO.setCompanyName(null);
       reqVO.setCorpCode(null);
       reqVO.setCorpName(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       List<AccessDO> list = accessService.getAccessList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbAccess, list.get(0));
    }

}
