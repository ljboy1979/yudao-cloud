package cn.acsm.module.transaction.sales.service.commodityspecification;

import cn.acsm.module.transaction.sales.controller.admin.commodityspecification.vo.CommoditySpecificationCreateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodityspecification.vo.CommoditySpecificationExportReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodityspecification.vo.CommoditySpecificationPageReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodityspecification.vo.CommoditySpecificationUpdateReqVO;
import cn.acsm.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO;
import cn.acsm.module.transaction.sales.dal.mysql.commodityspecification.CommoditySpecificationMapper;
import cn.acsm.module.transaction.sales.enums.ErrorCodeConstants;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import cn.acsm.module.transaction.sales.controller.admin.commodityspecification.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO;
import cn.acsm.module.transaction.sales.dal.mysql.commodityspecification.CommoditySpecificationMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.springframework.context.annotation.Import;
import java.util.*;

import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link CommoditySpecificationServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(CommoditySpecificationServiceImpl.class)
public class CommoditySpecificationServiceImplTest extends BaseDbUnitTest {

    @Resource
    private CommoditySpecificationServiceImpl commoditySpecificationService;

    @Resource
    private CommoditySpecificationMapper commoditySpecificationMapper;

    @Test
    public void testCreateCommoditySpecification_success() {
        // 准备参数
        CommoditySpecificationCreateReqVO reqVO = randomPojo(CommoditySpecificationCreateReqVO.class);

        // 调用
        CommonResult<String> result = commoditySpecificationService.createCommoditySpecification(reqVO);
        // 断言
        assertNotNull(result.getData());
        // 校验记录的属性是否正确
        CommoditySpecificationDO commoditySpecification = commoditySpecificationMapper.selectById(result.getData());
        assertPojoEquals(reqVO, commoditySpecification);
    }

    @Test
    public void testUpdateCommoditySpecification_success() {
        // mock 数据
        CommoditySpecificationDO dbCommoditySpecification = randomPojo(CommoditySpecificationDO.class);
        commoditySpecificationMapper.insert(dbCommoditySpecification);// @Sql: 先插入出一条存在的数据
        // 准备参数
        CommoditySpecificationUpdateReqVO reqVO = randomPojo(CommoditySpecificationUpdateReqVO.class, o -> {
            o.setId(dbCommoditySpecification.getId()); // 设置更新的 ID
        });

        // 调用
        commoditySpecificationService.updateCommoditySpecification(reqVO);
        // 校验是否更新正确
        CommoditySpecificationDO commoditySpecification = commoditySpecificationMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, commoditySpecification);
    }

    @Test
    public void testUpdateCommoditySpecification_notExists() {
        // 准备参数
        CommoditySpecificationUpdateReqVO reqVO = randomPojo(CommoditySpecificationUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> commoditySpecificationService.updateCommoditySpecification(reqVO), ErrorCodeConstants.COMMODITY_SPECIFICATION_NOT_EXISTS);
    }

    @Test
    public void testDeleteCommoditySpecification_success() {
        // mock 数据
        CommoditySpecificationDO dbCommoditySpecification = randomPojo(CommoditySpecificationDO.class);
        commoditySpecificationMapper.insert(dbCommoditySpecification);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbCommoditySpecification.getId();

        // 调用
        commoditySpecificationService.deleteCommoditySpecification(id);
       // 校验数据不存在了
       assertNull(commoditySpecificationMapper.selectById(id));
    }

    @Test
    public void testDeleteCommoditySpecification_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> commoditySpecificationService.deleteCommoditySpecification(id), ErrorCodeConstants.COMMODITY_SPECIFICATION_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetCommoditySpecificationPage() {
       // mock 数据
       CommoditySpecificationDO dbCommoditySpecification = randomPojo(CommoditySpecificationDO.class, o -> { // 等会查询到
           o.setCommodityId(null);
           o.setSpecificationsName(null);
           o.setPackagingType(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
           o.setSource(null);
       });
       commoditySpecificationMapper.insert(dbCommoditySpecification);
       // 测试 commodityId 不匹配
       commoditySpecificationMapper.insert(cloneIgnoreId(dbCommoditySpecification, o -> o.setCommodityId(null)));
       // 测试 specificationsName 不匹配
       commoditySpecificationMapper.insert(cloneIgnoreId(dbCommoditySpecification, o -> o.setSpecificationsName(null)));
       // 测试 packagingType 不匹配
       commoditySpecificationMapper.insert(cloneIgnoreId(dbCommoditySpecification, o -> o.setPackagingType(null)));
       // 测试 createTime 不匹配
       commoditySpecificationMapper.insert(cloneIgnoreId(dbCommoditySpecification, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       commoditySpecificationMapper.insert(cloneIgnoreId(dbCommoditySpecification, o -> o.setSubjectId(null)));
       // 测试 source 不匹配
       commoditySpecificationMapper.insert(cloneIgnoreId(dbCommoditySpecification, o -> o.setSource(null)));
       // 准备参数
       CommoditySpecificationPageReqVO reqVO = new CommoditySpecificationPageReqVO();
       reqVO.setCommodityId(null);
       reqVO.setSpecificationsName(null);
       reqVO.setPackagingType(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);
       reqVO.setSource(null);

       // 调用
       PageResult<CommoditySpecificationDO> pageResult = commoditySpecificationService.getCommoditySpecificationPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbCommoditySpecification, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetCommoditySpecificationList() {
       // mock 数据
       CommoditySpecificationDO dbCommoditySpecification = randomPojo(CommoditySpecificationDO.class, o -> { // 等会查询到
           o.setCommodityId(null);
           o.setSpecificationsName(null);
           o.setPackagingType(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
           o.setSource(null);
       });
       commoditySpecificationMapper.insert(dbCommoditySpecification);
       // 测试 commodityId 不匹配
       commoditySpecificationMapper.insert(cloneIgnoreId(dbCommoditySpecification, o -> o.setCommodityId(null)));
       // 测试 specificationsName 不匹配
       commoditySpecificationMapper.insert(cloneIgnoreId(dbCommoditySpecification, o -> o.setSpecificationsName(null)));
       // 测试 packagingType 不匹配
       commoditySpecificationMapper.insert(cloneIgnoreId(dbCommoditySpecification, o -> o.setPackagingType(null)));
       // 测试 createTime 不匹配
       commoditySpecificationMapper.insert(cloneIgnoreId(dbCommoditySpecification, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       commoditySpecificationMapper.insert(cloneIgnoreId(dbCommoditySpecification, o -> o.setSubjectId(null)));
       // 测试 source 不匹配
       commoditySpecificationMapper.insert(cloneIgnoreId(dbCommoditySpecification, o -> o.setSource(null)));
       // 准备参数
       CommoditySpecificationExportReqVO reqVO = new CommoditySpecificationExportReqVO();
       reqVO.setCommodityId(null);
       reqVO.setSpecificationsName(null);
       reqVO.setPackagingType(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);
       reqVO.setSource(null);

       // 调用
       List<CommoditySpecificationDO> list = commoditySpecificationService.getCommoditySpecificationList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbCommoditySpecification, list.get(0));
    }

}
