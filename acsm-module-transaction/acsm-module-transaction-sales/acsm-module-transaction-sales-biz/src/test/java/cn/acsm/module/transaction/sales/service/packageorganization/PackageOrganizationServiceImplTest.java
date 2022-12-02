package cn.acsm.module.transaction.sales.service.packageorganization;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;

import cn.acsm.module.transaction.sales.controller.admin.packageorganization.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.packageorganization.PackageOrganizationDO;
import cn.acsm.module.transaction.sales.dal.mysql.packageorganization.PackageOrganizationMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link PackageOrganizationServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(PackageOrganizationServiceImpl.class)
public class PackageOrganizationServiceImplTest extends BaseDbUnitTest {

    @Resource
    private PackageOrganizationServiceImpl packageOrganizationService;

    @Resource
    private PackageOrganizationMapper packageOrganizationMapper;

    @Test
    public void testCreatePackageOrganization_success() {
        // 准备参数
        PackageOrganizationCreateReqVO reqVO = randomPojo(PackageOrganizationCreateReqVO.class);

        // 调用
        CommonResult<String> result = packageOrganizationService.createPackageOrganization(reqVO);
        // 断言
        assertNotNull(result.getData());
        // 校验记录的属性是否正确
        PackageOrganizationDO packageOrganization = packageOrganizationMapper.selectById(result.getData());
        assertPojoEquals(reqVO, packageOrganization);
    }

    @Test
    public void testUpdatePackageOrganization_success() {
        // mock 数据
        PackageOrganizationDO dbPackageOrganization = randomPojo(PackageOrganizationDO.class);
        packageOrganizationMapper.insert(dbPackageOrganization);// @Sql: 先插入出一条存在的数据
        // 准备参数
        PackageOrganizationUpdateReqVO reqVO = randomPojo(PackageOrganizationUpdateReqVO.class, o -> {
            o.setId(dbPackageOrganization.getId()); // 设置更新的 ID
        });

        // 调用
        packageOrganizationService.updatePackageOrganization(reqVO);
        // 校验是否更新正确
        PackageOrganizationDO packageOrganization = packageOrganizationMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, packageOrganization);
    }

    @Test
    public void testUpdatePackageOrganization_notExists() {
        // 准备参数
        PackageOrganizationUpdateReqVO reqVO = randomPojo(PackageOrganizationUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> packageOrganizationService.updatePackageOrganization(reqVO), PACKAGE_ORGANIZATION_NOT_EXISTS);
    }

    @Test
    public void testDeletePackageOrganization_success() {
        // mock 数据
        PackageOrganizationDO dbPackageOrganization = randomPojo(PackageOrganizationDO.class);
        packageOrganizationMapper.insert(dbPackageOrganization);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbPackageOrganization.getId();

        // 调用
        packageOrganizationService.deletePackageOrganization(id);
       // 校验数据不存在了
       assertNull(packageOrganizationMapper.selectById(id));
    }

    @Test
    public void testDeletePackageOrganization_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> packageOrganizationService.deletePackageOrganization(id), PACKAGE_ORGANIZATION_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetPackageOrganizationPage() {
       // mock 数据
       PackageOrganizationDO dbPackageOrganization = randomPojo(PackageOrganizationDO.class, o -> { // 等会查询到
           o.setPackageId(null);
           o.setType(null);
           o.setCreateTime(null);
       });
       packageOrganizationMapper.insert(dbPackageOrganization);
       // 测试 packageId 不匹配
       packageOrganizationMapper.insert(cloneIgnoreId(dbPackageOrganization, o -> o.setPackageId(null)));
       // 测试 type 不匹配
       packageOrganizationMapper.insert(cloneIgnoreId(dbPackageOrganization, o -> o.setType(null)));
       // 测试 createTime 不匹配
       packageOrganizationMapper.insert(cloneIgnoreId(dbPackageOrganization, o -> o.setCreateTime(null)));
       // 准备参数
       PackageOrganizationPageReqVO reqVO = new PackageOrganizationPageReqVO();
       reqVO.setPackageId(null);
       reqVO.setType(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<PackageOrganizationDO> pageResult = packageOrganizationService.getPackageOrganizationPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbPackageOrganization, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetPackageOrganizationList() {
       // mock 数据
       PackageOrganizationDO dbPackageOrganization = randomPojo(PackageOrganizationDO.class, o -> { // 等会查询到
           o.setPackageId(null);
           o.setType(null);
           o.setCreateTime(null);
       });
       packageOrganizationMapper.insert(dbPackageOrganization);
       // 测试 packageId 不匹配
       packageOrganizationMapper.insert(cloneIgnoreId(dbPackageOrganization, o -> o.setPackageId(null)));
       // 测试 type 不匹配
       packageOrganizationMapper.insert(cloneIgnoreId(dbPackageOrganization, o -> o.setType(null)));
       // 测试 createTime 不匹配
       packageOrganizationMapper.insert(cloneIgnoreId(dbPackageOrganization, o -> o.setCreateTime(null)));
       // 准备参数
       PackageOrganizationExportReqVO reqVO = new PackageOrganizationExportReqVO();
       reqVO.setPackageId(null);
       reqVO.setType(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<PackageOrganizationDO> list = packageOrganizationService.getPackageOrganizationList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbPackageOrganization, list.get(0));
    }

}
