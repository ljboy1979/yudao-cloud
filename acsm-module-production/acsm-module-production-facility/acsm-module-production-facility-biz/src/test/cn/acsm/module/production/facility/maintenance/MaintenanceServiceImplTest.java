package cn.iocoder.yudao.module.infra.module.facility.service.maintenance;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.module.infra.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.infra.module.facility.controller.admin.maintenance.vo.*;
import cn.iocoder.yudao.module.infra.module.facility.dal.dataobject.maintenance.MaintenanceDO;
import cn.iocoder.yudao.module.infra.module.facility.dal.mysql.maintenance.MaintenanceMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.module.infra.module.facility.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.module.infra.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.module.infra.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link MaintenanceServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(MaintenanceServiceImpl.class)
public class MaintenanceServiceImplTest extends BaseDbUnitTest {

    @Resource
    private MaintenanceServiceImpl maintenanceService;

    @Resource
    private MaintenanceMapper maintenanceMapper;

    @Test
    public void testCreateMaintenance_success() {
        // 准备参数
        MaintenanceCreateReqVO reqVO = randomPojo(MaintenanceCreateReqVO.class);

        // 调用
        Long maintenanceId = maintenanceService.createMaintenance(reqVO);
        // 断言
        assertNotNull(maintenanceId);
        // 校验记录的属性是否正确
        MaintenanceDO maintenance = maintenanceMapper.selectById(maintenanceId);
        assertPojoEquals(reqVO, maintenance);
    }

    @Test
    public void testUpdateMaintenance_success() {
        // mock 数据
        MaintenanceDO dbMaintenance = randomPojo(MaintenanceDO.class);
        maintenanceMapper.insert(dbMaintenance);// @Sql: 先插入出一条存在的数据
        // 准备参数
        MaintenanceUpdateReqVO reqVO = randomPojo(MaintenanceUpdateReqVO.class, o -> {
            o.setId(dbMaintenance.getId()); // 设置更新的 ID
        });

        // 调用
        maintenanceService.updateMaintenance(reqVO);
        // 校验是否更新正确
        MaintenanceDO maintenance = maintenanceMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, maintenance);
    }

    @Test
    public void testUpdateMaintenance_notExists() {
        // 准备参数
        MaintenanceUpdateReqVO reqVO = randomPojo(MaintenanceUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> maintenanceService.updateMaintenance(reqVO), MAINTENANCE_NOT_EXISTS);
    }

    @Test
    public void testDeleteMaintenance_success() {
        // mock 数据
        MaintenanceDO dbMaintenance = randomPojo(MaintenanceDO.class);
        maintenanceMapper.insert(dbMaintenance);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbMaintenance.getId();

        // 调用
        maintenanceService.deleteMaintenance(id);
       // 校验数据不存在了
       assertNull(maintenanceMapper.selectById(id));
    }

    @Test
    public void testDeleteMaintenance_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> maintenanceService.deleteMaintenance(id), MAINTENANCE_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMaintenancePage() {
       // mock 数据
       MaintenanceDO dbMaintenance = randomPojo(MaintenanceDO.class, o -> { // 等会查询到
           o.setFacilitysId(null);
           o.setOperateName(null);
           o.setOperateTime(null);
           o.setTimeConsuming(null);
           o.setOfficeCode(null);
           o.setOfficeName(null);
           o.setCompanyCode(null);
           o.setCompanyName(null);
           o.setRemarks(null);
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
       maintenanceMapper.insert(dbMaintenance);
       // 测试 facilitysId 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setFacilitysId(null)));
       // 测试 operateName 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setOperateName(null)));
       // 测试 operateTime 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setOperateTime(null)));
       // 测试 timeConsuming 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setTimeConsuming(null)));
       // 测试 officeCode 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setCompanyName(null)));
       // 测试 remarks 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setRemarks(null)));
       // 测试 reviewStatus 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setCorpName(null)));
       // 测试 createTime 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setSubjectId(null)));
       // 准备参数
       MaintenancePageReqVO reqVO = new MaintenancePageReqVO();
       reqVO.setFacilitysId(null);
       reqVO.setOperateName(null);
       reqVO.setOperateTime((new LocalDateTime[]{}));
       reqVO.setTimeConsuming(null);
       reqVO.setOfficeCode(null);
       reqVO.setOfficeName(null);
       reqVO.setCompanyCode(null);
       reqVO.setCompanyName(null);
       reqVO.setRemarks(null);
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
       PageResult<MaintenanceDO> pageResult = maintenanceService.getMaintenancePage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbMaintenance, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMaintenanceList() {
       // mock 数据
       MaintenanceDO dbMaintenance = randomPojo(MaintenanceDO.class, o -> { // 等会查询到
           o.setFacilitysId(null);
           o.setOperateName(null);
           o.setOperateTime(null);
           o.setTimeConsuming(null);
           o.setOfficeCode(null);
           o.setOfficeName(null);
           o.setCompanyCode(null);
           o.setCompanyName(null);
           o.setRemarks(null);
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
       maintenanceMapper.insert(dbMaintenance);
       // 测试 facilitysId 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setFacilitysId(null)));
       // 测试 operateName 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setOperateName(null)));
       // 测试 operateTime 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setOperateTime(null)));
       // 测试 timeConsuming 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setTimeConsuming(null)));
       // 测试 officeCode 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setCompanyName(null)));
       // 测试 remarks 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setRemarks(null)));
       // 测试 reviewStatus 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setCorpName(null)));
       // 测试 createTime 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       maintenanceMapper.insert(cloneIgnoreId(dbMaintenance, o -> o.setSubjectId(null)));
       // 准备参数
       MaintenanceExportReqVO reqVO = new MaintenanceExportReqVO();
       reqVO.setFacilitysId(null);
       reqVO.setOperateName(null);
       reqVO.setOperateTime((new LocalDateTime[]{}));
       reqVO.setTimeConsuming(null);
       reqVO.setOfficeCode(null);
       reqVO.setOfficeName(null);
       reqVO.setCompanyCode(null);
       reqVO.setCompanyName(null);
       reqVO.setRemarks(null);
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
       List<MaintenanceDO> list = maintenanceService.getMaintenanceList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbMaintenance, list.get(0));
    }

}
