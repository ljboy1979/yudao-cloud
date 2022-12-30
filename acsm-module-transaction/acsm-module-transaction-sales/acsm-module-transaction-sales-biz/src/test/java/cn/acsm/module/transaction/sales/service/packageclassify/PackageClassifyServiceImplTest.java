package cn.acsm.module.transaction.sales.service.packageclassify;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.transaction.sales.controller.admin.packageclassify.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.packageclassify.PackageClassifyDO;
import cn.acsm.module.transaction.sales.dal.mysql.packageclassify.PackageClassifyMapper;
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
* {@link PackageClassifyServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(PackageClassifyServiceImpl.class)
public class PackageClassifyServiceImplTest extends BaseDbUnitTest {

    @Resource
    private PackageClassifyServiceImpl packageClassifyService;

    @Resource
    private PackageClassifyMapper packageClassifyMapper;

    @Test
    public void testCreatePackageClassify_success() {
        // 准备参数
        PackageClassifyCreateReqVO reqVO = randomPojo(PackageClassifyCreateReqVO.class);

        // 调用
        CommonResult result = packageClassifyService.createPackageClassify(reqVO);
        // 断言
        assertNotNull(result.getData());
        // 校验记录的属性是否正确
        PackageClassifyDO packageClassify = packageClassifyMapper.selectById(result.getData().toString());
        assertPojoEquals(reqVO, packageClassify);
    }

    @Test
    public void testUpdatePackageClassify_success() {
        // mock 数据
        PackageClassifyDO dbPackageClassify = randomPojo(PackageClassifyDO.class);
        packageClassifyMapper.insert(dbPackageClassify);// @Sql: 先插入出一条存在的数据
        // 准备参数
        PackageClassifyUpdateReqVO reqVO = randomPojo(PackageClassifyUpdateReqVO.class, o -> {
            o.setId(dbPackageClassify.getId()); // 设置更新的 ID
        });

        // 调用
        packageClassifyService.updatePackageClassify(reqVO);
        // 校验是否更新正确
        PackageClassifyDO packageClassify = packageClassifyMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, packageClassify);
    }

    @Test
    public void testUpdatePackageClassify_notExists() {
        // 准备参数
        PackageClassifyUpdateReqVO reqVO = randomPojo(PackageClassifyUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> packageClassifyService.updatePackageClassify(reqVO), PACKAGE_CLASSIFY_NOT_EXISTS);
    }

    @Test
    public void testDeletePackageClassify_success() {
        // mock 数据
        PackageClassifyDO dbPackageClassify = randomPojo(PackageClassifyDO.class);
        packageClassifyMapper.insert(dbPackageClassify);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbPackageClassify.getId();

        // 调用
        packageClassifyService.deletePackageClassify(id);
       // 校验数据不存在了
       assertNull(packageClassifyMapper.selectById(id));
    }

    @Test
    public void testDeletePackageClassify_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> packageClassifyService.deletePackageClassify(id), PACKAGE_CLASSIFY_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetPackageClassifyPage() {
       // mock 数据
       PackageClassifyDO dbPackageClassify = randomPojo(PackageClassifyDO.class, o -> { // 等会查询到
           o.setCategoryName(null);
           o.setCreateTime(null);
       });
       packageClassifyMapper.insert(dbPackageClassify);
       // 测试 categoryName 不匹配
       packageClassifyMapper.insert(cloneIgnoreId(dbPackageClassify, o -> o.setCategoryName(null)));
       // 测试 createTime 不匹配
       packageClassifyMapper.insert(cloneIgnoreId(dbPackageClassify, o -> o.setCreateTime(null)));
       // 准备参数
       PackageClassifyPageReqVO reqVO = new PackageClassifyPageReqVO();
       reqVO.setCategoryName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<PackageClassifyDO> pageResult = packageClassifyService.getPackageClassifyPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbPackageClassify, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetPackageClassifyList() {
       // mock 数据
       PackageClassifyDO dbPackageClassify = randomPojo(PackageClassifyDO.class, o -> { // 等会查询到
           o.setCategoryName(null);
           o.setCreateTime(null);
       });
       packageClassifyMapper.insert(dbPackageClassify);
       // 测试 categoryName 不匹配
       packageClassifyMapper.insert(cloneIgnoreId(dbPackageClassify, o -> o.setCategoryName(null)));
       // 测试 createTime 不匹配
       packageClassifyMapper.insert(cloneIgnoreId(dbPackageClassify, o -> o.setCreateTime(null)));
       // 准备参数
       PackageClassifyExportReqVO reqVO = new PackageClassifyExportReqVO();
       reqVO.setCategoryName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<PackageClassifyDO> list = packageClassifyService.getPackageClassifyList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbPackageClassify, list.get(0));
    }

}
