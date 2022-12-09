package cn.acsm.module.resource.service.productionscores;

import cn.acsm.module.resource.controller.admin.productionscores.vo.ProductionScoresCreateReqVO;
import cn.acsm.module.resource.controller.admin.productionscores.vo.ProductionScoresExportReqVO;
import cn.acsm.module.resource.controller.admin.productionscores.vo.ProductionScoresPageReqVO;
import cn.acsm.module.resource.controller.admin.productionscores.vo.ProductionScoresUpdateReqVO;
import cn.acsm.module.resource.dal.dataobject.productionscores.ProductionScoresDO;
import cn.acsm.module.resource.dal.mysql.productionscores.ProductionScoresMapper;
import cn.acsm.module.resource.service.productionscores.ProductionScoresServiceImpl;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.springframework.context.annotation.Import;
import java.util.*;

import static cn.acsm.module.resource.enums.ErrorCodeConstants.PRODUCTION_SCORES_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link ProductionScoresServiceImpl} 的单元测试类
*
* @author smile
*/
@Import(ProductionScoresServiceImpl.class)
public class ProductionScoresServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ProductionScoresServiceImpl productionScoresService;

    @Resource
    private ProductionScoresMapper productionScoresMapper;

    @Test
    public void testCreateProductionScores_success() {
        // 准备参数
        ProductionScoresCreateReqVO reqVO = randomPojo(ProductionScoresCreateReqVO.class);

        // 调用
        Long productionScoresId = productionScoresService.createProductionScores(reqVO);
        // 断言
        assertNotNull(productionScoresId);
        // 校验记录的属性是否正确
        ProductionScoresDO productionScores = productionScoresMapper.selectById(productionScoresId);
        assertPojoEquals(reqVO, productionScores);
    }

    @Test
    public void testUpdateProductionScores_success() {
        // mock 数据
        ProductionScoresDO dbProductionScores = randomPojo(ProductionScoresDO.class);
        productionScoresMapper.insert(dbProductionScores);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ProductionScoresUpdateReqVO reqVO = randomPojo(ProductionScoresUpdateReqVO.class, o -> {
            o.setId(dbProductionScores.getId()); // 设置更新的 ID
        });

        // 调用
        productionScoresService.updateProductionScores(reqVO);
        // 校验是否更新正确
        ProductionScoresDO productionScores = productionScoresMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, productionScores);
    }

    @Test
    public void testUpdateProductionScores_notExists() {
        // 准备参数
        ProductionScoresUpdateReqVO reqVO = randomPojo(ProductionScoresUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> productionScoresService.updateProductionScores(reqVO), PRODUCTION_SCORES_NOT_EXISTS);
    }

    @Test
    public void testDeleteProductionScores_success() {
        // mock 数据
        ProductionScoresDO dbProductionScores = randomPojo(ProductionScoresDO.class);
        productionScoresMapper.insert(dbProductionScores);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbProductionScores.getId();

        // 调用
        productionScoresService.deleteProductionScores(id);
       // 校验数据不存在了
       assertNull(productionScoresMapper.selectById(id));
    }

    @Test
    public void testDeleteProductionScores_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> productionScoresService.deleteProductionScores(id), PRODUCTION_SCORES_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetProductionScoresPage() {
       // mock 数据
       ProductionScoresDO dbProductionScores = randomPojo(ProductionScoresDO.class, o -> { // 等会查询到
           o.setServiceAdoptContentId(null);
           o.setProductionScoresId(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       productionScoresMapper.insert(dbProductionScores);
       // 测试 serviceAdoptContentId 不匹配
       productionScoresMapper.insert(cloneIgnoreId(dbProductionScores, o -> o.setServiceAdoptContentId(null)));
       // 测试 productionScoresId 不匹配
       productionScoresMapper.insert(cloneIgnoreId(dbProductionScores, o -> o.setProductionScoresId(null)));
       // 测试 status 不匹配
       productionScoresMapper.insert(cloneIgnoreId(dbProductionScores, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       productionScoresMapper.insert(cloneIgnoreId(dbProductionScores, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       productionScoresMapper.insert(cloneIgnoreId(dbProductionScores, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       productionScoresMapper.insert(cloneIgnoreId(dbProductionScores, o -> o.setSubjectId(null)));
       // 准备参数
       ProductionScoresPageReqVO reqVO = new ProductionScoresPageReqVO();
       reqVO.setServiceAdoptContentId(null);
       reqVO.setProductionScoresId(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       PageResult<ProductionScoresDO> pageResult = productionScoresService.getProductionScoresPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbProductionScores, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetProductionScoresList() {
       // mock 数据
       ProductionScoresDO dbProductionScores = randomPojo(ProductionScoresDO.class, o -> { // 等会查询到
           o.setServiceAdoptContentId(null);
           o.setProductionScoresId(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       productionScoresMapper.insert(dbProductionScores);
       // 测试 serviceAdoptContentId 不匹配
       productionScoresMapper.insert(cloneIgnoreId(dbProductionScores, o -> o.setServiceAdoptContentId(null)));
       // 测试 productionScoresId 不匹配
       productionScoresMapper.insert(cloneIgnoreId(dbProductionScores, o -> o.setProductionScoresId(null)));
       // 测试 status 不匹配
       productionScoresMapper.insert(cloneIgnoreId(dbProductionScores, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       productionScoresMapper.insert(cloneIgnoreId(dbProductionScores, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       productionScoresMapper.insert(cloneIgnoreId(dbProductionScores, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       productionScoresMapper.insert(cloneIgnoreId(dbProductionScores, o -> o.setSubjectId(null)));
       // 准备参数
       ProductionScoresExportReqVO reqVO = new ProductionScoresExportReqVO();
       reqVO.setServiceAdoptContentId(null);
       reqVO.setProductionScoresId(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       List<ProductionScoresDO> list = productionScoresService.getProductionScoresList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbProductionScores, list.get(0));
    }

}
