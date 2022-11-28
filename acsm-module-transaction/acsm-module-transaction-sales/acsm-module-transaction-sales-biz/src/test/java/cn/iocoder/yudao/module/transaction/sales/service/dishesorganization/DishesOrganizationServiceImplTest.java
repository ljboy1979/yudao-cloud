package cn.iocoder.yudao.module.transaction.sales.service.dishesorganization;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;


import cn.iocoder.yudao.module.transaction.sales.controller.admin.dishesorganization.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.dishesorganization.DishesOrganizationDO;
import cn.iocoder.yudao.module.transaction.sales.dal.mysql.dishesorganization.DishesOrganizationMapper;
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
* {@link DishesOrganizationServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(DishesOrganizationServiceImpl.class)
public class DishesOrganizationServiceImplTest extends BaseDbUnitTest {

    @Resource
    private DishesOrganizationServiceImpl dishesOrganizationService;

    @Resource
    private DishesOrganizationMapper dishesOrganizationMapper;

    @Test
    public void testCreateDishesOrganization_success() {
        // 准备参数
        DishesOrganizationCreateReqVO reqVO = randomPojo(DishesOrganizationCreateReqVO.class);

        // 调用
        String dishesOrganizationId = dishesOrganizationService.createDishesOrganization(reqVO);
        // 断言
        assertNotNull(dishesOrganizationId);
        // 校验记录的属性是否正确
        DishesOrganizationDO dishesOrganization = dishesOrganizationMapper.selectById(dishesOrganizationId);
        assertPojoEquals(reqVO, dishesOrganization);
    }

    @Test
    public void testUpdateDishesOrganization_success() {
        // mock 数据
        DishesOrganizationDO dbDishesOrganization = randomPojo(DishesOrganizationDO.class);
        dishesOrganizationMapper.insert(dbDishesOrganization);// @Sql: 先插入出一条存在的数据
        // 准备参数
        DishesOrganizationUpdateReqVO reqVO = randomPojo(DishesOrganizationUpdateReqVO.class, o -> {
            o.setId(dbDishesOrganization.getId()); // 设置更新的 ID
        });

        // 调用
        dishesOrganizationService.updateDishesOrganization(reqVO);
        // 校验是否更新正确
        DishesOrganizationDO dishesOrganization = dishesOrganizationMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, dishesOrganization);
    }

    @Test
    public void testUpdateDishesOrganization_notExists() {
        // 准备参数
        DishesOrganizationUpdateReqVO reqVO = randomPojo(DishesOrganizationUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> dishesOrganizationService.updateDishesOrganization(reqVO), DISHES_ORGANIZATION_NOT_EXISTS);
    }

    @Test
    public void testDeleteDishesOrganization_success() {
        // mock 数据
        DishesOrganizationDO dbDishesOrganization = randomPojo(DishesOrganizationDO.class);
        dishesOrganizationMapper.insert(dbDishesOrganization);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbDishesOrganization.getId();

        // 调用
        dishesOrganizationService.deleteDishesOrganization(id);
       // 校验数据不存在了
       assertNull(dishesOrganizationMapper.selectById(id));
    }

    @Test
    public void testDeleteDishesOrganization_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> dishesOrganizationService.deleteDishesOrganization(id), DISHES_ORGANIZATION_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetDishesOrganizationPage() {
       // mock 数据
       DishesOrganizationDO dbDishesOrganization = randomPojo(DishesOrganizationDO.class, o -> { // 等会查询到
           o.setOrganizationNumber(null);
           o.setOrganizationName(null);
           o.setCreateTime(null);
       });
       dishesOrganizationMapper.insert(dbDishesOrganization);
       // 测试 organizationNumber 不匹配
       dishesOrganizationMapper.insert(cloneIgnoreId(dbDishesOrganization, o -> o.setOrganizationNumber(null)));
       // 测试 organizationName 不匹配
       dishesOrganizationMapper.insert(cloneIgnoreId(dbDishesOrganization, o -> o.setOrganizationName(null)));
       // 测试 createTime 不匹配
       dishesOrganizationMapper.insert(cloneIgnoreId(dbDishesOrganization, o -> o.setCreateTime(null)));
       // 准备参数
       DishesOrganizationPageReqVO reqVO = new DishesOrganizationPageReqVO();
       reqVO.setOrganizationNumber(null);
       reqVO.setOrganizationName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<DishesOrganizationDO> pageResult = dishesOrganizationService.getDishesOrganizationPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbDishesOrganization, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetDishesOrganizationList() {
       // mock 数据
       DishesOrganizationDO dbDishesOrganization = randomPojo(DishesOrganizationDO.class, o -> { // 等会查询到
           o.setOrganizationNumber(null);
           o.setOrganizationName(null);
           o.setCreateTime(null);
       });
       dishesOrganizationMapper.insert(dbDishesOrganization);
       // 测试 organizationNumber 不匹配
       dishesOrganizationMapper.insert(cloneIgnoreId(dbDishesOrganization, o -> o.setOrganizationNumber(null)));
       // 测试 organizationName 不匹配
       dishesOrganizationMapper.insert(cloneIgnoreId(dbDishesOrganization, o -> o.setOrganizationName(null)));
       // 测试 createTime 不匹配
       dishesOrganizationMapper.insert(cloneIgnoreId(dbDishesOrganization, o -> o.setCreateTime(null)));
       // 准备参数
       DishesOrganizationExportReqVO reqVO = new DishesOrganizationExportReqVO();
       reqVO.setOrganizationNumber(null);
       reqVO.setOrganizationName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<DishesOrganizationDO> list = dishesOrganizationService.getDishesOrganizationList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbDishesOrganization, list.get(0));
    }

}
