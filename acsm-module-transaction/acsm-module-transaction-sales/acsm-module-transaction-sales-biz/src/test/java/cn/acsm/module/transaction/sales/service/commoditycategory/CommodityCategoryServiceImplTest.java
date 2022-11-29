package cn.acsm.module.transaction.sales.service.commoditycategory;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;


import cn.acsm.module.transaction.sales.controller.admin.commoditycategory.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.commoditycategory.CommodityCategoryDO;
import cn.acsm.module.transaction.sales.dal.mysql.commoditycategory.CommodityCategoryMapper;
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
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.COMMODITY_CATEGORY_NOT_EXISTS;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link CommodityCategoryServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(CommodityCategoryServiceImpl.class)
public class CommodityCategoryServiceImplTest extends BaseDbUnitTest {

    @Resource
    private CommodityCategoryServiceImpl commodityCategoryService;

    @Resource
    private CommodityCategoryMapper commodityCategoryMapper;

    @Test
    public void testCreateCommodityCategory_success() {
        // 准备参数
        CommodityCategoryCreateReqVO reqVO = randomPojo(CommodityCategoryCreateReqVO.class);

        // 调用
        String commodityCategoryId = commodityCategoryService.createCommodityCategory(reqVO);
        // 断言
        assertNotNull(commodityCategoryId);
        // 校验记录的属性是否正确
        CommodityCategoryDO commodityCategory = commodityCategoryMapper.selectById(commodityCategoryId);
        assertPojoEquals(reqVO, commodityCategory);
    }

    @Test
    public void testUpdateCommodityCategory_success() {
        // mock 数据
        CommodityCategoryDO dbCommodityCategory = randomPojo(CommodityCategoryDO.class);
        commodityCategoryMapper.insert(dbCommodityCategory);// @Sql: 先插入出一条存在的数据
        // 准备参数
        CommodityCategoryUpdateReqVO reqVO = randomPojo(CommodityCategoryUpdateReqVO.class, o -> {
            o.setId(dbCommodityCategory.getId()); // 设置更新的 ID
        });

        // 调用
        commodityCategoryService.updateCommodityCategory(reqVO);
        // 校验是否更新正确
        CommodityCategoryDO commodityCategory = commodityCategoryMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, commodityCategory);
    }

    @Test
    public void testUpdateCommodityCategory_notExists() {
        // 准备参数
        CommodityCategoryUpdateReqVO reqVO = randomPojo(CommodityCategoryUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> commodityCategoryService.updateCommodityCategory(reqVO), COMMODITY_CATEGORY_NOT_EXISTS);
    }

    @Test
    public void testDeleteCommodityCategory_success() {
        // mock 数据
        CommodityCategoryDO dbCommodityCategory = randomPojo(CommodityCategoryDO.class);
        commodityCategoryMapper.insert(dbCommodityCategory);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbCommodityCategory.getId();

        // 调用
        commodityCategoryService.deleteCommodityCategory(id);
       // 校验数据不存在了
       assertNull(commodityCategoryMapper.selectById(id));
    }

    @Test
    public void testDeleteCommodityCategory_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> commodityCategoryService.deleteCommodityCategory(id), COMMODITY_CATEGORY_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetCommodityCategoryPage() {
       // mock 数据
       CommodityCategoryDO dbCommodityCategory = randomPojo(CommodityCategoryDO.class, o -> { // 等会查询到
           o.setCommodityCategoryName(null);
           o.setParentCode(null);
           o.setParentCodes(null);
           o.setTreeSort(null);
           o.setTreeSorts(null);
           o.setTreeLeaf(null);
           o.setTreeLevel(null);
           o.setTreeNames(null);
           o.setType(null);
           o.setState(null);
           o.setImgUrl(null);
           o.setOrder(null);
           o.setCommodityType(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       commodityCategoryMapper.insert(dbCommodityCategory);
       // 测试 commodityCategoryName 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setCommodityCategoryName(null)));
       // 测试 parentCode 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setParentCode(null)));
       // 测试 parentCodes 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setParentCodes(null)));
       // 测试 treeSort 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setTreeSort(null)));
       // 测试 treeSorts 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setTreeSorts(null)));
       // 测试 treeLeaf 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setTreeLeaf(null)));
       // 测试 treeLevel 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setTreeLevel(null)));
       // 测试 treeNames 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setTreeNames(null)));
       // 测试 type 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setType(null)));
       // 测试 state 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setState(null)));
       // 测试 imgUrl 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setImgUrl(null)));
       // 测试 order 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setOrder(null)));
       // 测试 commodityType 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setCommodityType(null)));
       // 测试 status 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setCreateTime(null)));
       // 准备参数
       CommodityCategoryPageReqVO reqVO = new CommodityCategoryPageReqVO();
       reqVO.setCommodityCategoryName(null);
       reqVO.setParentCode(null);
       reqVO.setParentCodes(null);
       reqVO.setTreeSort(null);
       reqVO.setTreeSorts(null);
       reqVO.setTreeLeaf(null);
       reqVO.setTreeLevel(null);
       reqVO.setTreeNames(null);
       reqVO.setType(null);
       reqVO.setState(null);
       reqVO.setImgUrl(null);
       reqVO.setOrder(null);
       reqVO.setCommodityType(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<CommodityCategoryDO> pageResult = commodityCategoryService.getCommodityCategoryPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbCommodityCategory, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetCommodityCategoryList() {
       // mock 数据
       CommodityCategoryDO dbCommodityCategory = randomPojo(CommodityCategoryDO.class, o -> { // 等会查询到
           o.setCommodityCategoryName(null);
           o.setParentCode(null);
           o.setParentCodes(null);
           o.setTreeSort(null);
           o.setTreeSorts(null);
           o.setTreeLeaf(null);
           o.setTreeLevel(null);
           o.setTreeNames(null);
           o.setType(null);
           o.setState(null);
           o.setImgUrl(null);
           o.setOrder(null);
           o.setCommodityType(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       commodityCategoryMapper.insert(dbCommodityCategory);
       // 测试 commodityCategoryName 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setCommodityCategoryName(null)));
       // 测试 parentCode 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setParentCode(null)));
       // 测试 parentCodes 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setParentCodes(null)));
       // 测试 treeSort 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setTreeSort(null)));
       // 测试 treeSorts 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setTreeSorts(null)));
       // 测试 treeLeaf 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setTreeLeaf(null)));
       // 测试 treeLevel 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setTreeLevel(null)));
       // 测试 treeNames 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setTreeNames(null)));
       // 测试 type 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setType(null)));
       // 测试 state 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setState(null)));
       // 测试 imgUrl 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setImgUrl(null)));
       // 测试 order 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setOrder(null)));
       // 测试 commodityType 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setCommodityType(null)));
       // 测试 status 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       commodityCategoryMapper.insert(cloneIgnoreId(dbCommodityCategory, o -> o.setCreateTime(null)));
       // 准备参数
       CommodityCategoryExportReqVO reqVO = new CommodityCategoryExportReqVO();
       reqVO.setCommodityCategoryName(null);
       reqVO.setParentCode(null);
       reqVO.setParentCodes(null);
       reqVO.setTreeSort(null);
       reqVO.setTreeSorts(null);
       reqVO.setTreeLeaf(null);
       reqVO.setTreeLevel(null);
       reqVO.setTreeNames(null);
       reqVO.setType(null);
       reqVO.setState(null);
       reqVO.setImgUrl(null);
       reqVO.setOrder(null);
       reqVO.setCommodityType(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<CommodityCategoryDO> list = commodityCategoryService.getCommodityCategoryList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbCommodityCategory, list.get(0));
    }

}
