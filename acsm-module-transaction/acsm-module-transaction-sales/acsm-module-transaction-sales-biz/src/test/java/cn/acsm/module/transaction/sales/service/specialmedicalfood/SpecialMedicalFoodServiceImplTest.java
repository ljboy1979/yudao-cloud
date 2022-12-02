package cn.acsm.module.transaction.sales.service.specialmedicalfood;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfood.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.specialmedicalfood.SpecialMedicalFoodDO;
import cn.acsm.module.transaction.sales.dal.mysql.specialmedicalfood.SpecialMedicalFoodMapper;
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
* {@link SpecialMedicalFoodServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(SpecialMedicalFoodServiceImpl.class)
public class SpecialMedicalFoodServiceImplTest extends BaseDbUnitTest {

    @Resource
    private SpecialMedicalFoodServiceImpl specialMedicalFoodService;

    @Resource
    private SpecialMedicalFoodMapper specialMedicalFoodMapper;

    @Test
    public void testCreateSpecialMedicalFood_success() {
        // 准备参数
        SpecialMedicalFoodCreateReqVO reqVO = randomPojo(SpecialMedicalFoodCreateReqVO.class);

        // 调用
        CommonResult<String> result = specialMedicalFoodService.createSpecialMedicalFood(reqVO);
        // 断言
        assertNotNull(result.getData());
        // 校验记录的属性是否正确
        SpecialMedicalFoodDO specialMedicalFood = specialMedicalFoodMapper.selectById(result.getData());
        assertPojoEquals(reqVO, specialMedicalFood);
    }

    @Test
    public void testUpdateSpecialMedicalFood_success() {
        // mock 数据
        SpecialMedicalFoodDO dbSpecialMedicalFood = randomPojo(SpecialMedicalFoodDO.class);
        specialMedicalFoodMapper.insert(dbSpecialMedicalFood);// @Sql: 先插入出一条存在的数据
        // 准备参数
        SpecialMedicalFoodUpdateReqVO reqVO = randomPojo(SpecialMedicalFoodUpdateReqVO.class, o -> {
            o.setId(dbSpecialMedicalFood.getId()); // 设置更新的 ID
        });

        // 调用
        specialMedicalFoodService.updateSpecialMedicalFood(reqVO);
        // 校验是否更新正确
        SpecialMedicalFoodDO specialMedicalFood = specialMedicalFoodMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, specialMedicalFood);
    }

    @Test
    public void testUpdateSpecialMedicalFood_notExists() {
        // 准备参数
        SpecialMedicalFoodUpdateReqVO reqVO = randomPojo(SpecialMedicalFoodUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> specialMedicalFoodService.updateSpecialMedicalFood(reqVO), SPECIAL_MEDICAL_FOOD_NOT_EXISTS);
    }

    @Test
    public void testDeleteSpecialMedicalFood_success() {
        // mock 数据
        SpecialMedicalFoodDO dbSpecialMedicalFood = randomPojo(SpecialMedicalFoodDO.class);
        specialMedicalFoodMapper.insert(dbSpecialMedicalFood);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbSpecialMedicalFood.getId();

        // 调用
        specialMedicalFoodService.deleteSpecialMedicalFood(id);
       // 校验数据不存在了
       assertNull(specialMedicalFoodMapper.selectById(id));
    }

    @Test
    public void testDeleteSpecialMedicalFood_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> specialMedicalFoodService.deleteSpecialMedicalFood(id), SPECIAL_MEDICAL_FOOD_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetSpecialMedicalFoodPage() {
       // mock 数据
       SpecialMedicalFoodDO dbSpecialMedicalFood = randomPojo(SpecialMedicalFoodDO.class, o -> { // 等会查询到
           o.setNumber(null);
           o.setName(null);
           o.setClassify(null);
           o.setCreateTime(null);
       });
       specialMedicalFoodMapper.insert(dbSpecialMedicalFood);
       // 测试 number 不匹配
       specialMedicalFoodMapper.insert(cloneIgnoreId(dbSpecialMedicalFood, o -> o.setNumber(null)));
       // 测试 name 不匹配
       specialMedicalFoodMapper.insert(cloneIgnoreId(dbSpecialMedicalFood, o -> o.setName(null)));
       // 测试 classify 不匹配
       specialMedicalFoodMapper.insert(cloneIgnoreId(dbSpecialMedicalFood, o -> o.setClassify(null)));
       // 测试 createTime 不匹配
       specialMedicalFoodMapper.insert(cloneIgnoreId(dbSpecialMedicalFood, o -> o.setCreateTime(null)));
       // 准备参数
       SpecialMedicalFoodPageReqVO reqVO = new SpecialMedicalFoodPageReqVO();
       reqVO.setNumber(null);
       reqVO.setName(null);
       reqVO.setClassify(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<SpecialMedicalFoodDO> pageResult = specialMedicalFoodService.getSpecialMedicalFoodPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbSpecialMedicalFood, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetSpecialMedicalFoodList() {
       // mock 数据
       SpecialMedicalFoodDO dbSpecialMedicalFood = randomPojo(SpecialMedicalFoodDO.class, o -> { // 等会查询到
           o.setNumber(null);
           o.setName(null);
           o.setClassify(null);
           o.setCreateTime(null);
       });
       specialMedicalFoodMapper.insert(dbSpecialMedicalFood);
       // 测试 number 不匹配
       specialMedicalFoodMapper.insert(cloneIgnoreId(dbSpecialMedicalFood, o -> o.setNumber(null)));
       // 测试 name 不匹配
       specialMedicalFoodMapper.insert(cloneIgnoreId(dbSpecialMedicalFood, o -> o.setName(null)));
       // 测试 classify 不匹配
       specialMedicalFoodMapper.insert(cloneIgnoreId(dbSpecialMedicalFood, o -> o.setClassify(null)));
       // 测试 createTime 不匹配
       specialMedicalFoodMapper.insert(cloneIgnoreId(dbSpecialMedicalFood, o -> o.setCreateTime(null)));
       // 准备参数
       SpecialMedicalFoodExportReqVO reqVO = new SpecialMedicalFoodExportReqVO();
       reqVO.setNumber(null);
       reqVO.setName(null);
       reqVO.setClassify(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<SpecialMedicalFoodDO> list = specialMedicalFoodService.getSpecialMedicalFoodList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbSpecialMedicalFood, list.get(0));
    }

}
