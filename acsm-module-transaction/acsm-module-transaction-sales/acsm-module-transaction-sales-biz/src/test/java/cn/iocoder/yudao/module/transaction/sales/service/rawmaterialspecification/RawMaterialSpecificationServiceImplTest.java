package cn.iocoder.yudao.module.transaction.sales.service.rawmaterialspecification;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;


import cn.iocoder.yudao.module.transaction.sales.controller.admin.rawmaterialspecification.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.rawmaterialspecification.RawMaterialSpecificationDO;
import cn.iocoder.yudao.module.transaction.sales.dal.mysql.rawmaterialspecification.RawMaterialSpecificationMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static cn.iocoder.yudao.module.transaction.sales.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link RawMaterialSpecificationServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(RawMaterialSpecificationServiceImpl.class)
public class RawMaterialSpecificationServiceImplTest extends BaseDbUnitTest {

    @Resource
    private RawMaterialSpecificationServiceImpl rawMaterialSpecificationService;

    @Resource
    private RawMaterialSpecificationMapper rawMaterialSpecificationMapper;

    @Test
    public void testCreateRawMaterialSpecification_success() {
        // 准备参数
        RawMaterialSpecificationCreateReqVO reqVO = randomPojo(RawMaterialSpecificationCreateReqVO.class);

        // 调用
        String rawMaterialSpecificationId = rawMaterialSpecificationService.createRawMaterialSpecification(reqVO);
        // 断言
        assertNotNull(rawMaterialSpecificationId);
        // 校验记录的属性是否正确
        RawMaterialSpecificationDO rawMaterialSpecification = rawMaterialSpecificationMapper.selectById(rawMaterialSpecificationId);
        assertPojoEquals(reqVO, rawMaterialSpecification);
    }

    @Test
    public void testUpdateRawMaterialSpecification_success() {
        // mock 数据
        RawMaterialSpecificationDO dbRawMaterialSpecification = randomPojo(RawMaterialSpecificationDO.class);
        rawMaterialSpecificationMapper.insert(dbRawMaterialSpecification);// @Sql: 先插入出一条存在的数据
        // 准备参数
        RawMaterialSpecificationUpdateReqVO reqVO = randomPojo(RawMaterialSpecificationUpdateReqVO.class, o -> {
            o.setId(dbRawMaterialSpecification.getId()); // 设置更新的 ID
        });

        // 调用
        rawMaterialSpecificationService.updateRawMaterialSpecification(reqVO);
        // 校验是否更新正确
        RawMaterialSpecificationDO rawMaterialSpecification = rawMaterialSpecificationMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, rawMaterialSpecification);
    }

    @Test
    public void testUpdateRawMaterialSpecification_notExists() {
        // 准备参数
        RawMaterialSpecificationUpdateReqVO reqVO = randomPojo(RawMaterialSpecificationUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> rawMaterialSpecificationService.updateRawMaterialSpecification(reqVO), RAW_MATERIAL_SPECIFICATION_NOT_EXISTS);
    }

    @Test
    public void testDeleteRawMaterialSpecification_success() {
        // mock 数据
        RawMaterialSpecificationDO dbRawMaterialSpecification = randomPojo(RawMaterialSpecificationDO.class);
        rawMaterialSpecificationMapper.insert(dbRawMaterialSpecification);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbRawMaterialSpecification.getId();

        // 调用
        rawMaterialSpecificationService.deleteRawMaterialSpecification(id);
       // 校验数据不存在了
       assertNull(rawMaterialSpecificationMapper.selectById(id));
    }

    @Test
    public void testDeleteRawMaterialSpecification_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> rawMaterialSpecificationService.deleteRawMaterialSpecification(id), RAW_MATERIAL_SPECIFICATION_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetRawMaterialSpecificationPage() {
       // mock 数据
       RawMaterialSpecificationDO dbRawMaterialSpecification = randomPojo(RawMaterialSpecificationDO.class, o -> { // 等会查询到
           o.setSpecificationsName(null);
           o.setCreateTime(null);
       });
       rawMaterialSpecificationMapper.insert(dbRawMaterialSpecification);
       // 测试 specificationsName 不匹配
       rawMaterialSpecificationMapper.insert(cloneIgnoreId(dbRawMaterialSpecification, o -> o.setSpecificationsName(null)));
       // 测试 createTime 不匹配
       rawMaterialSpecificationMapper.insert(cloneIgnoreId(dbRawMaterialSpecification, o -> o.setCreateTime(null)));
       // 准备参数
       RawMaterialSpecificationPageReqVO reqVO = new RawMaterialSpecificationPageReqVO();
       reqVO.setSpecificationsName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<RawMaterialSpecificationDO> pageResult = rawMaterialSpecificationService.getRawMaterialSpecificationPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbRawMaterialSpecification, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetRawMaterialSpecificationList() {
       // mock 数据
       RawMaterialSpecificationDO dbRawMaterialSpecification = randomPojo(RawMaterialSpecificationDO.class, o -> { // 等会查询到
           o.setSpecificationsName(null);
           o.setCreateTime(null);
       });
       rawMaterialSpecificationMapper.insert(dbRawMaterialSpecification);
       // 测试 specificationsName 不匹配
       rawMaterialSpecificationMapper.insert(cloneIgnoreId(dbRawMaterialSpecification, o -> o.setSpecificationsName(null)));
       // 测试 createTime 不匹配
       rawMaterialSpecificationMapper.insert(cloneIgnoreId(dbRawMaterialSpecification, o -> o.setCreateTime(null)));
       // 准备参数
       RawMaterialSpecificationExportReqVO reqVO = new RawMaterialSpecificationExportReqVO();
       reqVO.setSpecificationsName(null);
        reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<RawMaterialSpecificationDO> list = rawMaterialSpecificationService.getRawMaterialSpecificationList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbRawMaterialSpecification, list.get(0));
    }

}
