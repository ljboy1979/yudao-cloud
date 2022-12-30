package cn.acsm.module.transaction.sales.service.dishescategory;

import cn.acsm.module.transaction.sales.controller.admin.dishescategory.vo.DishesCategoryCreateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.dishescategory.vo.DishesCategoryExportReqVO;
import cn.acsm.module.transaction.sales.controller.admin.dishescategory.vo.DishesCategoryPageReqVO;
import cn.acsm.module.transaction.sales.controller.admin.dishescategory.vo.DishesCategoryUpdateReqVO;
import cn.acsm.module.transaction.sales.dal.dataobject.dishescategory.DishesCategoryDO;
import cn.acsm.module.transaction.sales.dal.mysql.dishescategory.DishesCategoryMapper;
import cn.acsm.module.transaction.sales.enums.ErrorCodeConstants;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;


import cn.acsm.module.transaction.sales.controller.admin.dishescategory.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.dishescategory.DishesCategoryDO;
import cn.acsm.module.transaction.sales.dal.mysql.dishescategory.DishesCategoryMapper;
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
* {@link DishesCategoryServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(DishesCategoryServiceImpl.class)
public class DishesCategoryServiceImplTest extends BaseDbUnitTest {

    @Resource
    private DishesCategoryServiceImpl dishesCategoryService;

    @Resource
    private DishesCategoryMapper dishesCategoryMapper;

    @Test
    public void testCreateDishesCategory_success() {
        // 准备参数
        DishesCategoryCreateReqVO reqVO = randomPojo(DishesCategoryCreateReqVO.class);

        // 调用
        CommonResult result = dishesCategoryService.createDishesCategory(reqVO);
        // 断言
        assertNotNull(result.getData());
        // 校验记录的属性是否正确
        DishesCategoryDO dishesCategory = dishesCategoryMapper.selectById(result.getData().toString());
        assertPojoEquals(reqVO, dishesCategory);
    }

    @Test
    public void testUpdateDishesCategory_success() {
        // mock 数据
        DishesCategoryDO dbDishesCategory = randomPojo(DishesCategoryDO.class);
        dishesCategoryMapper.insert(dbDishesCategory);// @Sql: 先插入出一条存在的数据
        // 准备参数
        DishesCategoryUpdateReqVO reqVO = randomPojo(DishesCategoryUpdateReqVO.class, o -> {
            o.setId(dbDishesCategory.getId()); // 设置更新的 ID
        });

        // 调用
        dishesCategoryService.updateDishesCategory(reqVO);
        // 校验是否更新正确
        DishesCategoryDO dishesCategory = dishesCategoryMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, dishesCategory);
    }

    @Test
    public void testUpdateDishesCategory_notExists() {
        // 准备参数
        DishesCategoryUpdateReqVO reqVO = randomPojo(DishesCategoryUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> dishesCategoryService.updateDishesCategory(reqVO), ErrorCodeConstants.DISHES_CATEGORY_NOT_EXISTS);
    }

    @Test
    public void testDeleteDishesCategory_success() {
        // mock 数据
        DishesCategoryDO dbDishesCategory = randomPojo(DishesCategoryDO.class);
        dishesCategoryMapper.insert(dbDishesCategory);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbDishesCategory.getId();

        // 调用
        dishesCategoryService.deleteDishesCategory(id);
       // 校验数据不存在了
       assertNull(dishesCategoryMapper.selectById(id));
    }

    @Test
    public void testDeleteDishesCategory_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> dishesCategoryService.deleteDishesCategory(id), ErrorCodeConstants.DISHES_CATEGORY_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetDishesCategoryPage() {
       // mock 数据
       DishesCategoryDO dbDishesCategory = randomPojo(DishesCategoryDO.class, o -> { // 等会查询到
           o.setCategoryName(null);
           o.setCreateTime(null);
       });
       dishesCategoryMapper.insert(dbDishesCategory);
       // 测试 categoryName 不匹配
       dishesCategoryMapper.insert(cloneIgnoreId(dbDishesCategory, o -> o.setCategoryName(null)));
       // 测试 createTime 不匹配
       dishesCategoryMapper.insert(cloneIgnoreId(dbDishesCategory, o -> o.setCreateTime(null)));
       // 准备参数
       DishesCategoryPageReqVO reqVO = new DishesCategoryPageReqVO();
       reqVO.setCategoryName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<DishesCategoryDO> pageResult = dishesCategoryService.getDishesCategoryPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbDishesCategory, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetDishesCategoryList() {
       // mock 数据
       DishesCategoryDO dbDishesCategory = randomPojo(DishesCategoryDO.class, o -> { // 等会查询到
           o.setCategoryName(null);
           o.setCreateTime(null);
       });
       dishesCategoryMapper.insert(dbDishesCategory);
       // 测试 categoryName 不匹配
       dishesCategoryMapper.insert(cloneIgnoreId(dbDishesCategory, o -> o.setCategoryName(null)));
       // 测试 createTime 不匹配
       dishesCategoryMapper.insert(cloneIgnoreId(dbDishesCategory, o -> o.setCreateTime(null)));
       // 准备参数
       DishesCategoryExportReqVO reqVO = new DishesCategoryExportReqVO();
       reqVO.setCategoryName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<DishesCategoryDO> list = dishesCategoryService.getDishesCategoryList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbDishesCategory, list.get(0));
    }

}
