package cn.iocoder.yudao.module.transaction.sales.service.dishesspecification;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.module.transaction.sales.controller.admin.dishesspecification.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.dishesspecification.DishesSpecificationDO;
import cn.iocoder.yudao.module.transaction.sales.dal.mysql.dishesspecification.DishesSpecificationMapper;
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
* {@link DishesSpecificationServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(DishesSpecificationServiceImpl.class)
public class DishesSpecificationServiceImplTest extends BaseDbUnitTest {

    @Resource
    private DishesSpecificationServiceImpl dishesSpecificationService;

    @Resource
    private DishesSpecificationMapper dishesSpecificationMapper;

    @Test
    public void testCreateDishesSpecification_success() {
        // 准备参数
        DishesSpecificationCreateReqVO reqVO = randomPojo(DishesSpecificationCreateReqVO.class);

        // 调用
        String dishesSpecificationId = dishesSpecificationService.createDishesSpecification(reqVO);
        // 断言
        assertNotNull(dishesSpecificationId);
        // 校验记录的属性是否正确
        DishesSpecificationDO dishesSpecification = dishesSpecificationMapper.selectById(dishesSpecificationId);
        assertPojoEquals(reqVO, dishesSpecification);
    }

    @Test
    public void testUpdateDishesSpecification_success() {
        // mock 数据
        DishesSpecificationDO dbDishesSpecification = randomPojo(DishesSpecificationDO.class);
        dishesSpecificationMapper.insert(dbDishesSpecification);// @Sql: 先插入出一条存在的数据
        // 准备参数
        DishesSpecificationUpdateReqVO reqVO = randomPojo(DishesSpecificationUpdateReqVO.class, o -> {
            o.setId(dbDishesSpecification.getId()); // 设置更新的 ID
        });

        // 调用
        dishesSpecificationService.updateDishesSpecification(reqVO);
        // 校验是否更新正确
        DishesSpecificationDO dishesSpecification = dishesSpecificationMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, dishesSpecification);
    }

    @Test
    public void testUpdateDishesSpecification_notExists() {
        // 准备参数
        DishesSpecificationUpdateReqVO reqVO = randomPojo(DishesSpecificationUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> dishesSpecificationService.updateDishesSpecification(reqVO), DISHES_SPECIFICATION_NOT_EXISTS);
    }

    @Test
    public void testDeleteDishesSpecification_success() {
        // mock 数据
        DishesSpecificationDO dbDishesSpecification = randomPojo(DishesSpecificationDO.class);
        dishesSpecificationMapper.insert(dbDishesSpecification);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbDishesSpecification.getId();

        // 调用
        dishesSpecificationService.deleteDishesSpecification(id);
       // 校验数据不存在了
       assertNull(dishesSpecificationMapper.selectById(id));
    }

    @Test
    public void testDeleteDishesSpecification_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> dishesSpecificationService.deleteDishesSpecification(id), DISHES_SPECIFICATION_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetDishesSpecificationPage() {
       // mock 数据
       DishesSpecificationDO dbDishesSpecification = randomPojo(DishesSpecificationDO.class, o -> { // 等会查询到
           o.setSpecificationsName(null);
       });
       dishesSpecificationMapper.insert(dbDishesSpecification);
       // 测试 specificationsName 不匹配
       dishesSpecificationMapper.insert(cloneIgnoreId(dbDishesSpecification, o -> o.setSpecificationsName(null)));
       // 准备参数
       DishesSpecificationPageReqVO reqVO = new DishesSpecificationPageReqVO();
       reqVO.setSpecificationsName(null);

       // 调用
       PageResult<DishesSpecificationDO> pageResult = dishesSpecificationService.getDishesSpecificationPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbDishesSpecification, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetDishesSpecificationList() {
       // mock 数据
       DishesSpecificationDO dbDishesSpecification = randomPojo(DishesSpecificationDO.class, o -> { // 等会查询到
           o.setSpecificationsName(null);
       });
       dishesSpecificationMapper.insert(dbDishesSpecification);
       // 测试 specificationsName 不匹配
       dishesSpecificationMapper.insert(cloneIgnoreId(dbDishesSpecification, o -> o.setSpecificationsName(null)));
       // 准备参数
       DishesSpecificationExportReqVO reqVO = new DishesSpecificationExportReqVO();
       reqVO.setSpecificationsName(null);

       // 调用
       List<DishesSpecificationDO> list = dishesSpecificationService.getDishesSpecificationList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbDishesSpecification, list.get(0));
    }

}
