package cn.acsm.module.transaction.sales.service.dishes;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;


import cn.acsm.module.transaction.sales.controller.admin.dishes.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.dishes.DishesDO;
import cn.acsm.module.transaction.sales.dal.mysql.dishes.DishesMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link DishesServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(DishesServiceImpl.class)
public class DishesServiceImplTest extends BaseDbUnitTest {

    @Resource
    private DishesServiceImpl dishesService;

    @Resource
    private DishesMapper dishesMapper;

    @Test
    public void testCreateDishes_success() {
        // 准备参数
        DishesCreateReqVO reqVO = randomPojo(DishesCreateReqVO.class);

        // 调用
        String dishesId = dishesService.createDishes(reqVO);
        // 断言
        assertNotNull(dishesId);
        // 校验记录的属性是否正确
        DishesDO dishes = dishesMapper.selectById(dishesId);
        assertPojoEquals(reqVO, dishes);
    }

    @Test
    public void testUpdateDishes_success() {
        // mock 数据
        DishesDO dbDishes = randomPojo(DishesDO.class);
        dishesMapper.insert(dbDishes);// @Sql: 先插入出一条存在的数据
        // 准备参数
        DishesUpdateReqVO reqVO = randomPojo(DishesUpdateReqVO.class, o -> {
            o.setId(dbDishes.getId()); // 设置更新的 ID
        });

        // 调用
        dishesService.updateDishes(reqVO);
        // 校验是否更新正确
        DishesDO dishes = dishesMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, dishes);
    }

    @Test
    public void testUpdateDishes_notExists() {
        // 准备参数
        DishesUpdateReqVO reqVO = randomPojo(DishesUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> dishesService.updateDishes(reqVO), DISHES_NOT_EXISTS);
    }

    @Test
    public void testDeleteDishes_success() {
        // mock 数据
        DishesDO dbDishes = randomPojo(DishesDO.class);
        dishesMapper.insert(dbDishes);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbDishes.getId();

        // 调用
        dishesService.deleteDishes(id);
       // 校验数据不存在了
       assertNull(dishesMapper.selectById(id));
    }

    @Test
    public void testDeleteDishes_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> dishesService.deleteDishes(id), DISHES_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetDishesPage() {
       // mock 数据
       DishesDO dbDishes = randomPojo(DishesDO.class, o -> { // 等会查询到
           o.setIngredientNumber(null);
           o.setDishesName(null);
           o.setCreateTime(null);
       });
       dishesMapper.insert(dbDishes);
       // 测试 ingredientNumber 不匹配
       dishesMapper.insert(cloneIgnoreId(dbDishes, o -> o.setIngredientNumber(null)));
       // 测试 dishesName 不匹配
       dishesMapper.insert(cloneIgnoreId(dbDishes, o -> o.setDishesName(null)));
       // 测试 createTime 不匹配
       dishesMapper.insert(cloneIgnoreId(dbDishes, o -> o.setCreateTime(null)));
       // 准备参数
       DishesPageReqVO reqVO = new DishesPageReqVO();
       reqVO.setIngredientNumber(null);
       reqVO.setDishesName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<DishesDO> pageResult = dishesService.getDishesPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbDishes, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetDishesList() {
       // mock 数据
       DishesDO dbDishes = randomPojo(DishesDO.class, o -> { // 等会查询到
           o.setIngredientNumber(null);
           o.setDishesName(null);
           o.setCreateTime(null);
       });
       dishesMapper.insert(dbDishes);
       // 测试 ingredientNumber 不匹配
       dishesMapper.insert(cloneIgnoreId(dbDishes, o -> o.setIngredientNumber(null)));
       // 测试 dishesName 不匹配
       dishesMapper.insert(cloneIgnoreId(dbDishes, o -> o.setDishesName(null)));
       // 测试 createTime 不匹配
       dishesMapper.insert(cloneIgnoreId(dbDishes, o -> o.setCreateTime(null)));
       // 准备参数
       DishesExportReqVO reqVO = new DishesExportReqVO();
       reqVO.setIngredientNumber(null);
       reqVO.setDishesName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<DishesDO> list = dishesService.getDishesList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbDishes, list.get(0));
    }

}
