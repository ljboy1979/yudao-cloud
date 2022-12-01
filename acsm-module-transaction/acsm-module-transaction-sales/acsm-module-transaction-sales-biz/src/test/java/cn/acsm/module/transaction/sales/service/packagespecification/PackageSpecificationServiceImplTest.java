package cn.acsm.module.transaction.sales.service.packagespecification;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.transaction.sales.controller.admin.packagespecification.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.packagespecification.PackageSpecificationDO;
import cn.acsm.module.transaction.sales.dal.mysql.packagespecification.PackageSpecificationMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link PackageSpecificationServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(PackageSpecificationServiceImpl.class)
public class PackageSpecificationServiceImplTest extends BaseDbUnitTest {

    @Resource
    private PackageSpecificationServiceImpl packageSpecificationService;

    @Resource
    private PackageSpecificationMapper packageSpecificationMapper;

    @Test
    public void testCreatePackageSpecification_success() {
        // 准备参数
        PackageSpecificationCreateReqVO reqVO = randomPojo(PackageSpecificationCreateReqVO.class);

        // 调用
        CommonResult<String> result = packageSpecificationService.createPackageSpecification(reqVO);
        // 断言
        assertNotNull(result.getData());
        // 校验记录的属性是否正确
        PackageSpecificationDO packageSpecification = packageSpecificationMapper.selectById(result.getData());
        assertPojoEquals(reqVO, packageSpecification);
    }

    @Test
    public void testUpdatePackageSpecification_success() {
        // mock 数据
        PackageSpecificationDO dbPackageSpecification = randomPojo(PackageSpecificationDO.class);
        packageSpecificationMapper.insert(dbPackageSpecification);// @Sql: 先插入出一条存在的数据
        // 准备参数
        PackageSpecificationUpdateReqVO reqVO = randomPojo(PackageSpecificationUpdateReqVO.class, o -> {
            o.setId(dbPackageSpecification.getId()); // 设置更新的 ID
        });

        // 调用
        packageSpecificationService.updatePackageSpecification(reqVO);
        // 校验是否更新正确
        PackageSpecificationDO packageSpecification = packageSpecificationMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, packageSpecification);
    }

    @Test
    public void testUpdatePackageSpecification_notExists() {
        // 准备参数
        PackageSpecificationUpdateReqVO reqVO = randomPojo(PackageSpecificationUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> packageSpecificationService.updatePackageSpecification(reqVO), PACKAGE_SPECIFICATION_NOT_EXISTS);
    }

    @Test
    public void testDeletePackageSpecification_success() {
        // mock 数据
        PackageSpecificationDO dbPackageSpecification = randomPojo(PackageSpecificationDO.class);
        packageSpecificationMapper.insert(dbPackageSpecification);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbPackageSpecification.getId();

        // 调用
        packageSpecificationService.deletePackageSpecification(id);
       // 校验数据不存在了
       assertNull(packageSpecificationMapper.selectById(id));
    }

    @Test
    public void testDeletePackageSpecification_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> packageSpecificationService.deletePackageSpecification(id), PACKAGE_SPECIFICATION_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetPackageSpecificationPage() {
       // mock 数据
       PackageSpecificationDO dbPackageSpecification = randomPojo(PackageSpecificationDO.class, o -> { // 等会查询到
           o.setSpecificationsName(null);
           o.setCreateTime(null);
       });
       packageSpecificationMapper.insert(dbPackageSpecification);
       // 测试 specificationsName 不匹配
       packageSpecificationMapper.insert(cloneIgnoreId(dbPackageSpecification, o -> o.setSpecificationsName(null)));
       // 测试 createTime 不匹配
       packageSpecificationMapper.insert(cloneIgnoreId(dbPackageSpecification, o -> o.setCreateTime(null)));
       // 准备参数
       PackageSpecificationPageReqVO reqVO = new PackageSpecificationPageReqVO();
       reqVO.setSpecificationsName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<PackageSpecificationDO> pageResult = packageSpecificationService.getPackageSpecificationPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbPackageSpecification, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetPackageSpecificationList() {
       // mock 数据
       PackageSpecificationDO dbPackageSpecification = randomPojo(PackageSpecificationDO.class, o -> { // 等会查询到
           o.setSpecificationsName(null);
           o.setCreateTime(null);
       });
       packageSpecificationMapper.insert(dbPackageSpecification);
       // 测试 specificationsName 不匹配
       packageSpecificationMapper.insert(cloneIgnoreId(dbPackageSpecification, o -> o.setSpecificationsName(null)));
       // 测试 createTime 不匹配
       packageSpecificationMapper.insert(cloneIgnoreId(dbPackageSpecification, o -> o.setCreateTime(null)));
       // 准备参数
       PackageSpecificationExportReqVO reqVO = new PackageSpecificationExportReqVO();
       reqVO.setSpecificationsName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<PackageSpecificationDO> list = packageSpecificationService.getPackageSpecificationList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbPackageSpecification, list.get(0));
    }

}
