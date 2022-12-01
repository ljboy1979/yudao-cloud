package cn.acsm.module.transaction.sales.service.salespackage;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;


import cn.acsm.module.transaction.sales.controller.admin.salespackage.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.salespackage.PackageDO;
import cn.acsm.module.transaction.sales.dal.mysql.salespackage.PackageMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link PackageServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(PackageServiceImpl.class)
public class PackageServiceImplTest extends BaseDbUnitTest {

    @Resource
    private PackageServiceImpl packageService;

    @Resource
    private PackageMapper packageMapper;

    @Test
    public void testCreatePackage_success() {
        // 准备参数
        PackageCreateReqVO reqVO = randomPojo(PackageCreateReqVO.class);

        // 调用
        CommonResult<String> result = packageService.createPackage(reqVO);
        // 断言
        assertNotNull(result.getData());
        // 校验记录的属性是否正确
        PackageDO packageDO = packageMapper.selectById(result.getData());
        assertPojoEquals(reqVO, packageDO);
    }

    @Test
    public void testUpdatePackage_success() {
        // mock 数据
        PackageDO dbPackage = randomPojo(PackageDO.class);
        packageMapper.insert(dbPackage);// @Sql: 先插入出一条存在的数据
        // 准备参数
        PackageUpdateReqVO reqVO = randomPojo(PackageUpdateReqVO.class, o -> {
            o.setId(dbPackage.getId()); // 设置更新的 ID
        });

        // 调用
        packageService.updatePackage(reqVO);
        // 校验是否更新正确
        PackageDO packageDO = packageMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, packageDO);
    }

    @Test
    public void testUpdatePackage_notExists() {
        // 准备参数
        PackageUpdateReqVO reqVO = randomPojo(PackageUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> packageService.updatePackage(reqVO), PACKAGE_NOT_EXISTS);
    }

    @Test
    public void testDeletePackage_success() {
        // mock 数据
        PackageDO dbPackage = randomPojo(PackageDO.class);
        packageMapper.insert(dbPackage);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbPackage.getId();

        // 调用
        packageService.deletePackage(id);
       // 校验数据不存在了
       assertNull(packageMapper.selectById(id));
    }

    @Test
    public void testDeletePackage_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> packageService.deletePackage(id), PACKAGE_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetPackagePage() {
       // mock 数据
       PackageDO dbPackage = randomPojo(PackageDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setSort(null);
           o.setMiniClassificationIdOne(null);
           o.setMiniClassificationIdTwo(null);
           o.setCommodityName(null);
           o.setVideo(null);
           o.setProcessTag(null);
           o.setLogisticsFees(null);
           o.setOsCommodityFishingId(null);
           o.setProductSpecificationsFishingId(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
       });
       packageMapper.insert(dbPackage);
       // 测试 name 不匹配
       packageMapper.insert(cloneIgnoreId(dbPackage, o -> o.setName(null)));
       // 测试 sort 不匹配
       packageMapper.insert(cloneIgnoreId(dbPackage, o -> o.setSort(null)));
       // 测试 miniClassificationIdOne 不匹配
       packageMapper.insert(cloneIgnoreId(dbPackage, o -> o.setMiniClassificationIdOne(null)));
       // 测试 miniClassificationIdTwo 不匹配
       packageMapper.insert(cloneIgnoreId(dbPackage, o -> o.setMiniClassificationIdTwo(null)));
       // 测试 commodityName 不匹配
       packageMapper.insert(cloneIgnoreId(dbPackage, o -> o.setCommodityName(null)));
       // 测试 video 不匹配
       packageMapper.insert(cloneIgnoreId(dbPackage, o -> o.setVideo(null)));
       // 测试 processTag 不匹配
       packageMapper.insert(cloneIgnoreId(dbPackage, o -> o.setProcessTag(null)));
       // 测试 logisticsFees 不匹配
       packageMapper.insert(cloneIgnoreId(dbPackage, o -> o.setLogisticsFees(null)));
       // 测试 osCommodityFishingId 不匹配
       packageMapper.insert(cloneIgnoreId(dbPackage, o -> o.setOsCommodityFishingId(null)));
       // 测试 productSpecificationsFishingId 不匹配
       packageMapper.insert(cloneIgnoreId(dbPackage, o -> o.setProductSpecificationsFishingId(null)));
       // 测试 status 不匹配
       packageMapper.insert(cloneIgnoreId(dbPackage, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       packageMapper.insert(cloneIgnoreId(dbPackage, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       packageMapper.insert(cloneIgnoreId(dbPackage, o -> o.setSubjectId(null)));
       // 准备参数
       PackagePageReqVO reqVO = new PackagePageReqVO();
       reqVO.setName(null);
       reqVO.setSort(null);
       reqVO.setMiniClassificationIdOne(null);
       reqVO.setMiniClassificationIdTwo(null);
       reqVO.setCommodityName(null);
       reqVO.setVideo(null);
       reqVO.setProcessTag(null);
       reqVO.setLogisticsFees(null);
       reqVO.setOsCommodityFishingId(null);
       reqVO.setProductSpecificationsFishingId(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);

       // 调用
       PageResult<PackageDO> pageResult = packageService.getPackagePage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbPackage, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetPackageList() {
       // mock 数据
       PackageDO dbPackage = randomPojo(PackageDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setSort(null);
           o.setMiniClassificationIdOne(null);
           o.setMiniClassificationIdTwo(null);
           o.setCommodityName(null);
           o.setVideo(null);
           o.setProcessTag(null);
           o.setLogisticsFees(null);
           o.setOsCommodityFishingId(null);
           o.setProductSpecificationsFishingId(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
       });
       packageMapper.insert(dbPackage);
       // 测试 name 不匹配
       packageMapper.insert(cloneIgnoreId(dbPackage, o -> o.setName(null)));
       // 测试 sort 不匹配
       packageMapper.insert(cloneIgnoreId(dbPackage, o -> o.setSort(null)));
       // 测试 miniClassificationIdOne 不匹配
       packageMapper.insert(cloneIgnoreId(dbPackage, o -> o.setMiniClassificationIdOne(null)));
       // 测试 miniClassificationIdTwo 不匹配
       packageMapper.insert(cloneIgnoreId(dbPackage, o -> o.setMiniClassificationIdTwo(null)));
       // 测试 commodityName 不匹配
       packageMapper.insert(cloneIgnoreId(dbPackage, o -> o.setCommodityName(null)));
       // 测试 video 不匹配
       packageMapper.insert(cloneIgnoreId(dbPackage, o -> o.setVideo(null)));
       // 测试 processTag 不匹配
       packageMapper.insert(cloneIgnoreId(dbPackage, o -> o.setProcessTag(null)));
       // 测试 logisticsFees 不匹配
       packageMapper.insert(cloneIgnoreId(dbPackage, o -> o.setLogisticsFees(null)));
       // 测试 osCommodityFishingId 不匹配
       packageMapper.insert(cloneIgnoreId(dbPackage, o -> o.setOsCommodityFishingId(null)));
       // 测试 productSpecificationsFishingId 不匹配
       packageMapper.insert(cloneIgnoreId(dbPackage, o -> o.setProductSpecificationsFishingId(null)));
       // 测试 status 不匹配
       packageMapper.insert(cloneIgnoreId(dbPackage, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       packageMapper.insert(cloneIgnoreId(dbPackage, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       packageMapper.insert(cloneIgnoreId(dbPackage, o -> o.setSubjectId(null)));
       // 准备参数
       PackageExportReqVO reqVO = new PackageExportReqVO();
       reqVO.setName(null);
       reqVO.setSort(null);
       reqVO.setMiniClassificationIdOne(null);
       reqVO.setMiniClassificationIdTwo(null);
       reqVO.setCommodityName(null);
       reqVO.setVideo(null);
       reqVO.setProcessTag(null);
       reqVO.setLogisticsFees(null);
       reqVO.setOsCommodityFishingId(null);
       reqVO.setProductSpecificationsFishingId(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);

       // 调用
       List<PackageDO> list = packageService.getPackageList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbPackage, list.get(0));
    }

}
