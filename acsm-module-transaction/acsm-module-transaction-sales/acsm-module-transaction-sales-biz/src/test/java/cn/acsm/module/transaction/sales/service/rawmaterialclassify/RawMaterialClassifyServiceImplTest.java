package cn.acsm.module.transaction.sales.service.rawmaterialclassify;

import cn.acsm.module.transaction.sales.enums.ErrorCodeConstants;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;


import cn.acsm.module.transaction.sales.controller.admin.rawmaterialclassify.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.rawmaterialclassify.RawMaterialClassifyDO;
import cn.acsm.module.transaction.sales.dal.mysql.rawmaterialclassify.RawMaterialClassifyMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.RAW_MATERIAL_CLASSIFY_NOT_EXISTS;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link RawMaterialClassifyServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(RawMaterialClassifyServiceImpl.class)
public class RawMaterialClassifyServiceImplTest extends BaseDbUnitTest {

    @Resource
    private RawMaterialClassifyServiceImpl rawMaterialClassifyService;

    @Resource
    private RawMaterialClassifyMapper rawMaterialClassifyMapper;

    @Test
    public void testCreateRawMaterialClassify_success() {
        // 准备参数
        RawMaterialClassifyCreateReqVO reqVO = randomPojo(RawMaterialClassifyCreateReqVO.class);

        // 调用
        CommonResult result = rawMaterialClassifyService.createRawMaterialClassify(reqVO);
        // 断言
        assertNotNull(result.getData());
        // 校验记录的属性是否正确
        RawMaterialClassifyDO rawMaterialClassify = rawMaterialClassifyMapper.selectById(result.getData().toString());
        assertPojoEquals(reqVO, rawMaterialClassify);
    }

    @Test
    public void testUpdateRawMaterialClassify_success() {
        // mock 数据
        RawMaterialClassifyDO dbRawMaterialClassify = randomPojo(RawMaterialClassifyDO.class);
        rawMaterialClassifyMapper.insert(dbRawMaterialClassify);// @Sql: 先插入出一条存在的数据
        // 准备参数
        RawMaterialClassifyUpdateReqVO reqVO = randomPojo(RawMaterialClassifyUpdateReqVO.class, o -> {
            o.setId(dbRawMaterialClassify.getId()); // 设置更新的 ID
        });

        // 调用
        rawMaterialClassifyService.updateRawMaterialClassify(reqVO);
        // 校验是否更新正确
        RawMaterialClassifyDO rawMaterialClassify = rawMaterialClassifyMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, rawMaterialClassify);
    }

    @Test
    public void testUpdateRawMaterialClassify_notExists() {
        // 准备参数
        RawMaterialClassifyUpdateReqVO reqVO = randomPojo(RawMaterialClassifyUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> rawMaterialClassifyService.updateRawMaterialClassify(reqVO), ErrorCodeConstants.RAW_MATERIAL_CLASSIFY_NOT_EXISTS);
    }

    @Test
    public void testDeleteRawMaterialClassify_success() {
        // mock 数据
        RawMaterialClassifyDO dbRawMaterialClassify = randomPojo(RawMaterialClassifyDO.class);
        rawMaterialClassifyMapper.insert(dbRawMaterialClassify);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbRawMaterialClassify.getId();

        // 调用
        rawMaterialClassifyService.deleteRawMaterialClassify(id);
       // 校验数据不存在了
       assertNull(rawMaterialClassifyMapper.selectById(id));
    }

    @Test
    public void testDeleteRawMaterialClassify_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> rawMaterialClassifyService.deleteRawMaterialClassify(id), ErrorCodeConstants.RAW_MATERIAL_CLASSIFY_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetRawMaterialClassifyPage() {
       // mock 数据
       RawMaterialClassifyDO dbRawMaterialClassify = randomPojo(RawMaterialClassifyDO.class, o -> { // 等会查询到
           o.setCategoryName(null);
       });
       rawMaterialClassifyMapper.insert(dbRawMaterialClassify);
       // 测试 categoryName 不匹配
       rawMaterialClassifyMapper.insert(cloneIgnoreId(dbRawMaterialClassify, o -> o.setCategoryName(null)));
       // 准备参数
       RawMaterialClassifyPageReqVO reqVO = new RawMaterialClassifyPageReqVO();
       reqVO.setCategoryName(null);

       // 调用
       PageResult<RawMaterialClassifyDO> pageResult = rawMaterialClassifyService.getRawMaterialClassifyPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbRawMaterialClassify, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetRawMaterialClassifyList() {
       // mock 数据
       RawMaterialClassifyDO dbRawMaterialClassify = randomPojo(RawMaterialClassifyDO.class, o -> { // 等会查询到
           o.setCategoryName(null);
       });
       rawMaterialClassifyMapper.insert(dbRawMaterialClassify);
       // 测试 categoryName 不匹配
       rawMaterialClassifyMapper.insert(cloneIgnoreId(dbRawMaterialClassify, o -> o.setCategoryName(null)));
       // 准备参数
       RawMaterialClassifyExportReqVO reqVO = new RawMaterialClassifyExportReqVO();
       reqVO.setCategoryName(null);

       // 调用
       List<RawMaterialClassifyDO> list = rawMaterialClassifyService.getRawMaterialClassifyList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbRawMaterialClassify, list.get(0));
    }

}
