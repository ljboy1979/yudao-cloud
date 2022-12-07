package cn.acsm.module.transaction.shelves.specifications;

import cn.acsm.module.transaction.shelves.service.specifications.SpecificationsServiceImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.transaction.shelves.controller.admin.specifications.vo.*;
import cn.acsm.module.transaction.shelves.dal.dataobject.specifications.SpecificationsDO;
import cn.acsm.module.transaction.shelves.dal.mysql.specifications.SpecificationsMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.acsm.module.transaction.shelves.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link SpecificationsServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(SpecificationsServiceImpl.class)
public class SpecificationsServiceImplTest extends BaseDbUnitTest {

    @Resource
    private SpecificationsServiceImpl specificationsService;

    @Resource
    private SpecificationsMapper specificationsMapper;

    @Test
    public void testCreateSpecifications_success() {
        // 准备参数
        SpecificationsCreateReqVO reqVO = randomPojo(SpecificationsCreateReqVO.class);

        // 调用
        String specificationsId = specificationsService.createSpecifications(reqVO);
        // 断言
        assertNotNull(specificationsId);
        // 校验记录的属性是否正确
        SpecificationsDO specifications = specificationsMapper.selectById(specificationsId);
        assertPojoEquals(reqVO, specifications);
    }

    @Test
    public void testUpdateSpecifications_success() {
        // mock 数据
        SpecificationsDO dbSpecifications = randomPojo(SpecificationsDO.class);
        specificationsMapper.insert(dbSpecifications);// @Sql: 先插入出一条存在的数据
        // 准备参数
        SpecificationsUpdateReqVO reqVO = randomPojo(SpecificationsUpdateReqVO.class, o -> {
            o.setId(dbSpecifications.getId()); // 设置更新的 ID
        });

        // 调用
        specificationsService.updateSpecifications(reqVO);
        // 校验是否更新正确
        SpecificationsDO specifications = specificationsMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, specifications);
    }

    @Test
    public void testUpdateSpecifications_notExists() {
        // 准备参数
        SpecificationsUpdateReqVO reqVO = randomPojo(SpecificationsUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> specificationsService.updateSpecifications(reqVO), SPECIFICATIONS_NOT_EXISTS);
    }

    @Test
    public void testDeleteSpecifications_success() {
        // mock 数据
        SpecificationsDO dbSpecifications = randomPojo(SpecificationsDO.class);
        specificationsMapper.insert(dbSpecifications);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbSpecifications.getId();

        // 调用
        specificationsService.deleteSpecifications(id);
       // 校验数据不存在了
       assertNull(specificationsMapper.selectById(id));
    }

    @Test
    public void testDeleteSpecifications_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> specificationsService.deleteSpecifications(id), SPECIFICATIONS_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetSpecificationsPage() {
       // mock 数据
       SpecificationsDO dbSpecifications = randomPojo(SpecificationsDO.class, o -> { // 等会查询到
           o.setSpecificationsName(null);
           o.setPackagingType(null);
           o.setCreateTime(null);
       });
       specificationsMapper.insert(dbSpecifications);
       // 测试 specificationsName 不匹配
       specificationsMapper.insert(cloneIgnoreId(dbSpecifications, o -> o.setSpecificationsName(null)));
       // 测试 packagingType 不匹配
       specificationsMapper.insert(cloneIgnoreId(dbSpecifications, o -> o.setPackagingType(null)));
       // 测试 createTime 不匹配
       specificationsMapper.insert(cloneIgnoreId(dbSpecifications, o -> o.setCreateTime(null)));
       // 准备参数
       SpecificationsPageReqVO reqVO = new SpecificationsPageReqVO();
       reqVO.setSpecificationsName(null);
       reqVO.setPackagingType(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<SpecificationsDO> pageResult = specificationsService.getSpecificationsPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbSpecifications, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetSpecificationsList() {
       // mock 数据
       SpecificationsDO dbSpecifications = randomPojo(SpecificationsDO.class, o -> { // 等会查询到
           o.setSpecificationsName(null);
           o.setPackagingType(null);
           o.setCreateTime(null);
       });
       specificationsMapper.insert(dbSpecifications);
       // 测试 specificationsName 不匹配
       specificationsMapper.insert(cloneIgnoreId(dbSpecifications, o -> o.setSpecificationsName(null)));
       // 测试 packagingType 不匹配
       specificationsMapper.insert(cloneIgnoreId(dbSpecifications, o -> o.setPackagingType(null)));
       // 测试 createTime 不匹配
       specificationsMapper.insert(cloneIgnoreId(dbSpecifications, o -> o.setCreateTime(null)));
       // 准备参数
       SpecificationsExportReqVO reqVO = new SpecificationsExportReqVO();
       reqVO.setSpecificationsName(null);
       reqVO.setPackagingType(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<SpecificationsDO> list = specificationsService.getSpecificationsList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbSpecifications, list.get(0));
    }

}
