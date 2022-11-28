package cn.iocoder.yudao.module.transaction.sales.service.rawmaterial;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;


import cn.iocoder.yudao.module.transaction.sales.controller.admin.rawmaterial.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.rawmaterial.RawMaterialDO;
import cn.iocoder.yudao.module.transaction.sales.dal.mysql.rawmaterial.RawMaterialMapper;
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
* {@link RawMaterialServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(RawMaterialServiceImpl.class)
public class RawMaterialServiceImplTest extends BaseDbUnitTest {

    @Resource
    private RawMaterialServiceImpl rawMaterialService;

    @Resource
    private RawMaterialMapper rawMaterialMapper;

    @Test
    public void testCreateRawMaterial_success() {
        // 准备参数
        RawMaterialCreateReqVO reqVO = randomPojo(RawMaterialCreateReqVO.class);

        // 调用
        String rawMaterialId = rawMaterialService.createRawMaterial(reqVO);
        // 断言
        assertNotNull(rawMaterialId);
        // 校验记录的属性是否正确
        RawMaterialDO rawMaterial = rawMaterialMapper.selectById(rawMaterialId);
        assertPojoEquals(reqVO, rawMaterial);
    }

    @Test
    public void testUpdateRawMaterial_success() {
        // mock 数据
        RawMaterialDO dbRawMaterial = randomPojo(RawMaterialDO.class);
        rawMaterialMapper.insert(dbRawMaterial);// @Sql: 先插入出一条存在的数据
        // 准备参数
        RawMaterialUpdateReqVO reqVO = randomPojo(RawMaterialUpdateReqVO.class, o -> {
            o.setId(dbRawMaterial.getId()); // 设置更新的 ID
        });

        // 调用
        rawMaterialService.updateRawMaterial(reqVO);
        // 校验是否更新正确
        RawMaterialDO rawMaterial = rawMaterialMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, rawMaterial);
    }

    @Test
    public void testUpdateRawMaterial_notExists() {
        // 准备参数
        RawMaterialUpdateReqVO reqVO = randomPojo(RawMaterialUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> rawMaterialService.updateRawMaterial(reqVO), RAW_MATERIAL_NOT_EXISTS);
    }

    @Test
    public void testDeleteRawMaterial_success() {
        // mock 数据
        RawMaterialDO dbRawMaterial = randomPojo(RawMaterialDO.class);
        rawMaterialMapper.insert(dbRawMaterial);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbRawMaterial.getId();

        // 调用
        rawMaterialService.deleteRawMaterial(id);
       // 校验数据不存在了
       assertNull(rawMaterialMapper.selectById(id));
    }

    @Test
    public void testDeleteRawMaterial_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> rawMaterialService.deleteRawMaterial(id), RAW_MATERIAL_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetRawMaterialPage() {
       // mock 数据
       RawMaterialDO dbRawMaterial = randomPojo(RawMaterialDO.class, o -> { // 等会查询到
           o.setIngredientNumber(null);
           o.setClassify(null);
           o.setName(null);
           o.setCreateTime(null);
       });
       rawMaterialMapper.insert(dbRawMaterial);
       // 测试 ingredientNumber 不匹配
       rawMaterialMapper.insert(cloneIgnoreId(dbRawMaterial, o -> o.setIngredientNumber(null)));
       // 测试 classify 不匹配
       rawMaterialMapper.insert(cloneIgnoreId(dbRawMaterial, o -> o.setClassify(null)));
       // 测试 name 不匹配
       rawMaterialMapper.insert(cloneIgnoreId(dbRawMaterial, o -> o.setName(null)));
       // 测试 createTime 不匹配
       rawMaterialMapper.insert(cloneIgnoreId(dbRawMaterial, o -> o.setCreateTime(null)));
       // 准备参数
       RawMaterialPageReqVO reqVO = new RawMaterialPageReqVO();
       reqVO.setIngredientNumber(null);
       reqVO.setClassify(null);
       reqVO.setName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<RawMaterialDO> pageResult = rawMaterialService.getRawMaterialPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbRawMaterial, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetRawMaterialList() {
       // mock 数据
       RawMaterialDO dbRawMaterial = randomPojo(RawMaterialDO.class, o -> { // 等会查询到
           o.setIngredientNumber(null);
           o.setClassify(null);
           o.setName(null);
           o.setCreateTime(null);
       });
       rawMaterialMapper.insert(dbRawMaterial);
       // 测试 ingredientNumber 不匹配
       rawMaterialMapper.insert(cloneIgnoreId(dbRawMaterial, o -> o.setIngredientNumber(null)));
       // 测试 classify 不匹配
       rawMaterialMapper.insert(cloneIgnoreId(dbRawMaterial, o -> o.setClassify(null)));
       // 测试 name 不匹配
       rawMaterialMapper.insert(cloneIgnoreId(dbRawMaterial, o -> o.setName(null)));
       // 测试 createTime 不匹配
       rawMaterialMapper.insert(cloneIgnoreId(dbRawMaterial, o -> o.setCreateTime(null)));
       // 准备参数
       RawMaterialExportReqVO reqVO = new RawMaterialExportReqVO();
       reqVO.setIngredientNumber(null);
       reqVO.setClassify(null);
       reqVO.setName(null);;
       reqVO.setCreateTime((new Date[]{}));
       // 调用
       List<RawMaterialDO> list = rawMaterialService.getRawMaterialList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbRawMaterial, list.get(0));
    }

}
