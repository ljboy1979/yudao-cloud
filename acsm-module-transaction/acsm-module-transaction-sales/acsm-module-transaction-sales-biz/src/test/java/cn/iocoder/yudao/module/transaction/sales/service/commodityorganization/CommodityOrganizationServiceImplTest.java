package cn.iocoder.yudao.module.transaction.sales.service.commodityorganization;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;


import cn.iocoder.yudao.module.transaction.sales.controller.admin.commodityorganization.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.commodityorganization.CommodityOrganizationDO;
import cn.iocoder.yudao.module.transaction.sales.dal.mysql.commodityorganization.CommodityOrganizationMapper;
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
* {@link CommodityOrganizationServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(CommodityOrganizationServiceImpl.class)
public class CommodityOrganizationServiceImplTest extends BaseDbUnitTest {

    @Resource
    private CommodityOrganizationServiceImpl commodityOrganizationService;

    @Resource
    private CommodityOrganizationMapper commodityOrganizationMapper;

    @Test
    public void testCreateCommodityOrganization_success() {
        // 准备参数
        CommodityOrganizationCreateReqVO reqVO = randomPojo(CommodityOrganizationCreateReqVO.class);

        // 调用
        String commodityOrganizationId = commodityOrganizationService.createCommodityOrganization(reqVO);
        // 断言
        assertNotNull(commodityOrganizationId);
        // 校验记录的属性是否正确
        CommodityOrganizationDO commodityOrganization = commodityOrganizationMapper.selectById(commodityOrganizationId);
        assertPojoEquals(reqVO, commodityOrganization);
    }

    @Test
    public void testUpdateCommodityOrganization_success() {
        // mock 数据
        CommodityOrganizationDO dbCommodityOrganization = randomPojo(CommodityOrganizationDO.class);
        commodityOrganizationMapper.insert(dbCommodityOrganization);// @Sql: 先插入出一条存在的数据
        // 准备参数
        CommodityOrganizationUpdateReqVO reqVO = randomPojo(CommodityOrganizationUpdateReqVO.class, o -> {
            o.setId(dbCommodityOrganization.getId()); // 设置更新的 ID
        });

        // 调用
        commodityOrganizationService.updateCommodityOrganization(reqVO);
        // 校验是否更新正确
        CommodityOrganizationDO commodityOrganization = commodityOrganizationMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, commodityOrganization);
    }

    @Test
    public void testUpdateCommodityOrganization_notExists() {
        // 准备参数
        CommodityOrganizationUpdateReqVO reqVO = randomPojo(CommodityOrganizationUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> commodityOrganizationService.updateCommodityOrganization(reqVO), COMMODITY_ORGANIZATION_NOT_EXISTS);
    }

    @Test
    public void testDeleteCommodityOrganization_success() {
        // mock 数据
        CommodityOrganizationDO dbCommodityOrganization = randomPojo(CommodityOrganizationDO.class);
        commodityOrganizationMapper.insert(dbCommodityOrganization);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbCommodityOrganization.getId();

        // 调用
        commodityOrganizationService.deleteCommodityOrganization(id);
       // 校验数据不存在了
       assertNull(commodityOrganizationMapper.selectById(id));
    }

    @Test
    public void testDeleteCommodityOrganization_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> commodityOrganizationService.deleteCommodityOrganization(id), COMMODITY_ORGANIZATION_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetCommodityOrganizationPage() {
       // mock 数据
       CommodityOrganizationDO dbCommodityOrganization = randomPojo(CommodityOrganizationDO.class, o -> { // 等会查询到
           o.setOrganizationNumber(null);
           o.setOrganizationName(null);
           o.setCreateTime(null);
       });
       commodityOrganizationMapper.insert(dbCommodityOrganization);
       // 测试 organizationNumber 不匹配
       commodityOrganizationMapper.insert(cloneIgnoreId(dbCommodityOrganization, o -> o.setOrganizationNumber(null)));
       // 测试 organizationName 不匹配
       commodityOrganizationMapper.insert(cloneIgnoreId(dbCommodityOrganization, o -> o.setOrganizationName(null)));
       // 测试 createTime 不匹配
       commodityOrganizationMapper.insert(cloneIgnoreId(dbCommodityOrganization, o -> o.setCreateTime(null)));
       // 准备参数
       CommodityOrganizationPageReqVO reqVO = new CommodityOrganizationPageReqVO();
       reqVO.setOrganizationNumber(null);
       reqVO.setOrganizationName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<CommodityOrganizationDO> pageResult = commodityOrganizationService.getCommodityOrganizationPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbCommodityOrganization, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetCommodityOrganizationList() {
       // mock 数据
       CommodityOrganizationDO dbCommodityOrganization = randomPojo(CommodityOrganizationDO.class, o -> { // 等会查询到
           o.setOrganizationNumber(null);
           o.setOrganizationName(null);
           o.setCreateTime(null);
       });
       commodityOrganizationMapper.insert(dbCommodityOrganization);
       // 测试 organizationNumber 不匹配
       commodityOrganizationMapper.insert(cloneIgnoreId(dbCommodityOrganization, o -> o.setOrganizationNumber(null)));
       // 测试 organizationName 不匹配
       commodityOrganizationMapper.insert(cloneIgnoreId(dbCommodityOrganization, o -> o.setOrganizationName(null)));
       // 测试 createTime 不匹配
       commodityOrganizationMapper.insert(cloneIgnoreId(dbCommodityOrganization, o -> o.setCreateTime(null)));
       // 准备参数
       CommodityOrganizationExportReqVO reqVO = new CommodityOrganizationExportReqVO();
       reqVO.setOrganizationNumber(null);
       reqVO.setOrganizationName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<CommodityOrganizationDO> list = commodityOrganizationService.getCommodityOrganizationList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbCommodityOrganization, list.get(0));
    }

}
