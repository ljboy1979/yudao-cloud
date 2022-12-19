package cn.acsm.module.production.bases.service.productioncapacityplans;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.module.infra.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.production.bases.dal.dataobject.productioncapacityplans.ProductionCapacityPlansDO;
import cn.acsm.module.production.bases.dal.mysql.productioncapacityplans.ProductionCapacityPlansMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.acsm.module.production.bases.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.module.infra.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.module.infra.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link ProductionCapacityPlansServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(ProductionCapacityPlansServiceImpl.class)
public class ProductionCapacityPlansServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ProductionCapacityPlansServiceImpl productionCapacityPlansService;

    @Resource
    private ProductionCapacityPlansMapper productionCapacityPlansMapper;

    @Test
    public void testCreateProductionCapacityPlans_success() {
        // 准备参数
        ProductionCapacityPlansCreateReqVO reqVO = randomPojo(ProductionCapacityPlansCreateReqVO.class);

        // 调用
        Long productionCapacityPlansId = productionCapacityPlansService.createProductionCapacityPlans(reqVO);
        // 断言
        assertNotNull(productionCapacityPlansId);
        // 校验记录的属性是否正确
        ProductionCapacityPlansDO productionCapacityPlans = productionCapacityPlansMapper.selectById(productionCapacityPlansId);
        assertPojoEquals(reqVO, productionCapacityPlans);
    }

    @Test
    public void testUpdateProductionCapacityPlans_success() {
        // mock 数据
        ProductionCapacityPlansDO dbProductionCapacityPlans = randomPojo(ProductionCapacityPlansDO.class);
        productionCapacityPlansMapper.insert(dbProductionCapacityPlans);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ProductionCapacityPlansUpdateReqVO reqVO = randomPojo(ProductionCapacityPlansUpdateReqVO.class, o -> {
            o.setId(dbProductionCapacityPlans.getId()); // 设置更新的 ID
        });

        // 调用
        productionCapacityPlansService.updateProductionCapacityPlans(reqVO);
        // 校验是否更新正确
        ProductionCapacityPlansDO productionCapacityPlans = productionCapacityPlansMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, productionCapacityPlans);
    }

    @Test
    public void testUpdateProductionCapacityPlans_notExists() {
        // 准备参数
        ProductionCapacityPlansUpdateReqVO reqVO = randomPojo(ProductionCapacityPlansUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> productionCapacityPlansService.updateProductionCapacityPlans(reqVO), PRODUCTION_CAPACITY_PLANS_NOT_EXISTS);
    }

    @Test
    public void testDeleteProductionCapacityPlans_success() {
        // mock 数据
        ProductionCapacityPlansDO dbProductionCapacityPlans = randomPojo(ProductionCapacityPlansDO.class);
        productionCapacityPlansMapper.insert(dbProductionCapacityPlans);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbProductionCapacityPlans.getId();

        // 调用
        productionCapacityPlansService.deleteProductionCapacityPlans(id);
       // 校验数据不存在了
       assertNull(productionCapacityPlansMapper.selectById(id));
    }

    @Test
    public void testDeleteProductionCapacityPlans_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> productionCapacityPlansService.deleteProductionCapacityPlans(id), PRODUCTION_CAPACITY_PLANS_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetProductionCapacityPlansPage() {
       // mock 数据
       ProductionCapacityPlansDO dbProductionCapacityPlans = randomPojo(ProductionCapacityPlansDO.class, o -> { // 等会查询到
           o.setBasesId(null);
           o.setPlanName(null);
           o.setRemarks(null);
           o.setOfficeCode(null);
           o.setOfficeName(null);
           o.setCompanyCode(null);
           o.setCompanyName(null);
           o.setCorpCode(null);
           o.setCorpName(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       productionCapacityPlansMapper.insert(dbProductionCapacityPlans);
       // 测试 basesId 不匹配
       productionCapacityPlansMapper.insert(cloneIgnoreId(dbProductionCapacityPlans, o -> o.setBasesId(null)));
       // 测试 planName 不匹配
       productionCapacityPlansMapper.insert(cloneIgnoreId(dbProductionCapacityPlans, o -> o.setPlanName(null)));
       // 测试 remarks 不匹配
       productionCapacityPlansMapper.insert(cloneIgnoreId(dbProductionCapacityPlans, o -> o.setRemarks(null)));
       // 测试 officeCode 不匹配
       productionCapacityPlansMapper.insert(cloneIgnoreId(dbProductionCapacityPlans, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       productionCapacityPlansMapper.insert(cloneIgnoreId(dbProductionCapacityPlans, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       productionCapacityPlansMapper.insert(cloneIgnoreId(dbProductionCapacityPlans, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       productionCapacityPlansMapper.insert(cloneIgnoreId(dbProductionCapacityPlans, o -> o.setCompanyName(null)));
       // 测试 corpCode 不匹配
       productionCapacityPlansMapper.insert(cloneIgnoreId(dbProductionCapacityPlans, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       productionCapacityPlansMapper.insert(cloneIgnoreId(dbProductionCapacityPlans, o -> o.setCorpName(null)));
       // 测试 createTime 不匹配
       productionCapacityPlansMapper.insert(cloneIgnoreId(dbProductionCapacityPlans, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       productionCapacityPlansMapper.insert(cloneIgnoreId(dbProductionCapacityPlans, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       productionCapacityPlansMapper.insert(cloneIgnoreId(dbProductionCapacityPlans, o -> o.setSubjectId(null)));
       // 准备参数
       ProductionCapacityPlansPageReqVO reqVO = new ProductionCapacityPlansPageReqVO();
       reqVO.setBasesId(null);
       reqVO.setPlanName(null);
       reqVO.setRemarks(null);
       reqVO.setOfficeCode(null);
       reqVO.setOfficeName(null);
       reqVO.setCompanyCode(null);
       reqVO.setCompanyName(null);
       reqVO.setCorpCode(null);
       reqVO.setCorpName(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       PageResult<ProductionCapacityPlansDO> pageResult = productionCapacityPlansService.getProductionCapacityPlansPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbProductionCapacityPlans, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetProductionCapacityPlansList() {
       // mock 数据
       ProductionCapacityPlansDO dbProductionCapacityPlans = randomPojo(ProductionCapacityPlansDO.class, o -> { // 等会查询到
           o.setBasesId(null);
           o.setPlanName(null);
           o.setRemarks(null);
           o.setOfficeCode(null);
           o.setOfficeName(null);
           o.setCompanyCode(null);
           o.setCompanyName(null);
           o.setCorpCode(null);
           o.setCorpName(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       productionCapacityPlansMapper.insert(dbProductionCapacityPlans);
       // 测试 basesId 不匹配
       productionCapacityPlansMapper.insert(cloneIgnoreId(dbProductionCapacityPlans, o -> o.setBasesId(null)));
       // 测试 planName 不匹配
       productionCapacityPlansMapper.insert(cloneIgnoreId(dbProductionCapacityPlans, o -> o.setPlanName(null)));
       // 测试 remarks 不匹配
       productionCapacityPlansMapper.insert(cloneIgnoreId(dbProductionCapacityPlans, o -> o.setRemarks(null)));
       // 测试 officeCode 不匹配
       productionCapacityPlansMapper.insert(cloneIgnoreId(dbProductionCapacityPlans, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       productionCapacityPlansMapper.insert(cloneIgnoreId(dbProductionCapacityPlans, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       productionCapacityPlansMapper.insert(cloneIgnoreId(dbProductionCapacityPlans, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       productionCapacityPlansMapper.insert(cloneIgnoreId(dbProductionCapacityPlans, o -> o.setCompanyName(null)));
       // 测试 corpCode 不匹配
       productionCapacityPlansMapper.insert(cloneIgnoreId(dbProductionCapacityPlans, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       productionCapacityPlansMapper.insert(cloneIgnoreId(dbProductionCapacityPlans, o -> o.setCorpName(null)));
       // 测试 createTime 不匹配
       productionCapacityPlansMapper.insert(cloneIgnoreId(dbProductionCapacityPlans, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       productionCapacityPlansMapper.insert(cloneIgnoreId(dbProductionCapacityPlans, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       productionCapacityPlansMapper.insert(cloneIgnoreId(dbProductionCapacityPlans, o -> o.setSubjectId(null)));
       // 准备参数
       ProductionCapacityPlansExportReqVO reqVO = new ProductionCapacityPlansExportReqVO();
       reqVO.setBasesId(null);
       reqVO.setPlanName(null);
       reqVO.setRemarks(null);
       reqVO.setOfficeCode(null);
       reqVO.setOfficeName(null);
       reqVO.setCompanyCode(null);
       reqVO.setCompanyName(null);
       reqVO.setCorpCode(null);
       reqVO.setCorpName(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       List<ProductionCapacityPlansDO> list = productionCapacityPlansService.getProductionCapacityPlansList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbProductionCapacityPlans, list.get(0));
    }

}
