package cn.acsm.module.production.bases.service.soilenv;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.module.infra.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.production.bases.dal.dataobject.soilenv.SoilEnvDO;
import cn.acsm.module.production.bases.dal.mysql.soilenv.SoilEnvMapper;
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
* {@link SoilEnvServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(SoilEnvServiceImpl.class)
public class SoilEnvServiceImplTest extends BaseDbUnitTest {

    @Resource
    private SoilEnvServiceImpl soilEnvService;

    @Resource
    private SoilEnvMapper soilEnvMapper;

    @Test
    public void testCreateSoilEnv_success() {
        // 准备参数
        SoilEnvCreateReqVO reqVO = randomPojo(SoilEnvCreateReqVO.class);

        // 调用
        Long soilEnvId = soilEnvService.createSoilEnv(reqVO);
        // 断言
        assertNotNull(soilEnvId);
        // 校验记录的属性是否正确
        SoilEnvDO soilEnv = soilEnvMapper.selectById(soilEnvId);
        assertPojoEquals(reqVO, soilEnv);
    }

    @Test
    public void testUpdateSoilEnv_success() {
        // mock 数据
        SoilEnvDO dbSoilEnv = randomPojo(SoilEnvDO.class);
        soilEnvMapper.insert(dbSoilEnv);// @Sql: 先插入出一条存在的数据
        // 准备参数
        SoilEnvUpdateReqVO reqVO = randomPojo(SoilEnvUpdateReqVO.class, o -> {
            o.setId(dbSoilEnv.getId()); // 设置更新的 ID
        });

        // 调用
        soilEnvService.updateSoilEnv(reqVO);
        // 校验是否更新正确
        SoilEnvDO soilEnv = soilEnvMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, soilEnv);
    }

    @Test
    public void testUpdateSoilEnv_notExists() {
        // 准备参数
        SoilEnvUpdateReqVO reqVO = randomPojo(SoilEnvUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> soilEnvService.updateSoilEnv(reqVO), SOIL_ENV_NOT_EXISTS);
    }

    @Test
    public void testDeleteSoilEnv_success() {
        // mock 数据
        SoilEnvDO dbSoilEnv = randomPojo(SoilEnvDO.class);
        soilEnvMapper.insert(dbSoilEnv);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbSoilEnv.getId();

        // 调用
        soilEnvService.deleteSoilEnv(id);
       // 校验数据不存在了
       assertNull(soilEnvMapper.selectById(id));
    }

    @Test
    public void testDeleteSoilEnv_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> soilEnvService.deleteSoilEnv(id), SOIL_ENV_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetSoilEnvPage() {
       // mock 数据
       SoilEnvDO dbSoilEnv = randomPojo(SoilEnvDO.class, o -> { // 等会查询到
           o.setBasesId(null);
           o.setEquipId(null);
           o.setTester(null);
           o.setTestTime(null);
           o.setInsertTime(null);
           o.setAvgSoilWater(null);
           o.setSoilType(null);
           o.setSubType(null);
           o.setSoilGenus(null);
           o.setSoilSpecies(null);
           o.setCommonName(null);
           o.setSoilParentMaterial(null);
           o.setProfilePattern(null);
           o.setTexture(null);
           o.setSoilStructure(null);
           o.setObstacleFactors(null);
           o.setErosionDegree(null);
           o.setTopsoilDepth(null);
           o.setSamplingDepth(null);
           o.setSamplingLevelFirst(null);
           o.setTextureFirst(null);
           o.setPhFirst(null);
           o.setOrganicMatterFirst(null);
           o.setAvailableNitrogenFirst(null);
           o.setEffectivePhosphorusFirst(null);
           o.setTotalPotassiumFirst(null);
           o.setSlowEffectPotassiumFirst(null);
           o.setAvailablePotassiumFirst(null);
           o.setTotalNitrogen(null);
           o.setSource(null);
           o.setRemarks(null);
           o.setOfficeCode(null);
           o.setOfficeName(null);
           o.setCompanyCode(null);
           o.setCompanyName(null);
           o.setReviewStatus(null);
           o.setReviewer(null);
           o.setReviewDate(null);
           o.setReviewContent(null);
           o.setCorpCode(null);
           o.setCorpName(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
       });
       soilEnvMapper.insert(dbSoilEnv);
       // 测试 basesId 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setBasesId(null)));
       // 测试 equipId 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setEquipId(null)));
       // 测试 tester 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setTester(null)));
       // 测试 testTime 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setTestTime(null)));
       // 测试 insertTime 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setInsertTime(null)));
       // 测试 avgSoilWater 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setAvgSoilWater(null)));
       // 测试 soilType 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setSoilType(null)));
       // 测试 subType 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setSubType(null)));
       // 测试 soilGenus 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setSoilGenus(null)));
       // 测试 soilSpecies 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setSoilSpecies(null)));
       // 测试 commonName 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setCommonName(null)));
       // 测试 soilParentMaterial 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setSoilParentMaterial(null)));
       // 测试 profilePattern 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setProfilePattern(null)));
       // 测试 texture 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setTexture(null)));
       // 测试 soilStructure 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setSoilStructure(null)));
       // 测试 obstacleFactors 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setObstacleFactors(null)));
       // 测试 erosionDegree 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setErosionDegree(null)));
       // 测试 topsoilDepth 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setTopsoilDepth(null)));
       // 测试 samplingDepth 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setSamplingDepth(null)));
       // 测试 samplingLevelFirst 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setSamplingLevelFirst(null)));
       // 测试 textureFirst 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setTextureFirst(null)));
       // 测试 phFirst 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setPhFirst(null)));
       // 测试 organicMatterFirst 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setOrganicMatterFirst(null)));
       // 测试 availableNitrogenFirst 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setAvailableNitrogenFirst(null)));
       // 测试 effectivePhosphorusFirst 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setEffectivePhosphorusFirst(null)));
       // 测试 totalPotassiumFirst 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setTotalPotassiumFirst(null)));
       // 测试 slowEffectPotassiumFirst 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setSlowEffectPotassiumFirst(null)));
       // 测试 availablePotassiumFirst 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setAvailablePotassiumFirst(null)));
       // 测试 totalNitrogen 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setTotalNitrogen(null)));
       // 测试 source 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setSource(null)));
       // 测试 remarks 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setRemarks(null)));
       // 测试 officeCode 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setCompanyName(null)));
       // 测试 reviewStatus 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setCorpName(null)));
       // 测试 createTime 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setSubjectId(null)));
       // 准备参数
       SoilEnvPageReqVO reqVO = new SoilEnvPageReqVO();
       reqVO.setBasesId(null);
       reqVO.setEquipId(null);
       reqVO.setTester(null);
       reqVO.setTestTime((new LocalDateTime[]{}));
       reqVO.setInsertTime((new LocalDateTime[]{}));
       reqVO.setAvgSoilWater(null);
       reqVO.setSoilType(null);
       reqVO.setSubType(null);
       reqVO.setSoilGenus(null);
       reqVO.setSoilSpecies(null);
       reqVO.setCommonName(null);
       reqVO.setSoilParentMaterial(null);
       reqVO.setProfilePattern(null);
       reqVO.setTexture(null);
       reqVO.setSoilStructure(null);
       reqVO.setObstacleFactors(null);
       reqVO.setErosionDegree(null);
       reqVO.setTopsoilDepth(null);
       reqVO.setSamplingDepth(null);
       reqVO.setSamplingLevelFirst(null);
       reqVO.setTextureFirst(null);
       reqVO.setPhFirst(null);
       reqVO.setOrganicMatterFirst(null);
       reqVO.setAvailableNitrogenFirst(null);
       reqVO.setEffectivePhosphorusFirst(null);
       reqVO.setTotalPotassiumFirst(null);
       reqVO.setSlowEffectPotassiumFirst(null);
       reqVO.setAvailablePotassiumFirst(null);
       reqVO.setTotalNitrogen(null);
       reqVO.setSource(null);
       reqVO.setRemarks(null);
       reqVO.setOfficeCode(null);
       reqVO.setOfficeName(null);
       reqVO.setCompanyCode(null);
       reqVO.setCompanyName(null);
       reqVO.setReviewStatus(null);
       reqVO.setReviewer(null);
       reqVO.setReviewDate((new LocalDateTime[]{}));
       reqVO.setReviewContent(null);
       reqVO.setCorpCode(null);
       reqVO.setCorpName(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSubjectId(null);

       // 调用
       PageResult<SoilEnvDO> pageResult = soilEnvService.getSoilEnvPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbSoilEnv, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetSoilEnvList() {
       // mock 数据
       SoilEnvDO dbSoilEnv = randomPojo(SoilEnvDO.class, o -> { // 等会查询到
           o.setBasesId(null);
           o.setEquipId(null);
           o.setTester(null);
           o.setTestTime(null);
           o.setInsertTime(null);
           o.setAvgSoilWater(null);
           o.setSoilType(null);
           o.setSubType(null);
           o.setSoilGenus(null);
           o.setSoilSpecies(null);
           o.setCommonName(null);
           o.setSoilParentMaterial(null);
           o.setProfilePattern(null);
           o.setTexture(null);
           o.setSoilStructure(null);
           o.setObstacleFactors(null);
           o.setErosionDegree(null);
           o.setTopsoilDepth(null);
           o.setSamplingDepth(null);
           o.setSamplingLevelFirst(null);
           o.setTextureFirst(null);
           o.setPhFirst(null);
           o.setOrganicMatterFirst(null);
           o.setAvailableNitrogenFirst(null);
           o.setEffectivePhosphorusFirst(null);
           o.setTotalPotassiumFirst(null);
           o.setSlowEffectPotassiumFirst(null);
           o.setAvailablePotassiumFirst(null);
           o.setTotalNitrogen(null);
           o.setSource(null);
           o.setRemarks(null);
           o.setOfficeCode(null);
           o.setOfficeName(null);
           o.setCompanyCode(null);
           o.setCompanyName(null);
           o.setReviewStatus(null);
           o.setReviewer(null);
           o.setReviewDate(null);
           o.setReviewContent(null);
           o.setCorpCode(null);
           o.setCorpName(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
       });
       soilEnvMapper.insert(dbSoilEnv);
       // 测试 basesId 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setBasesId(null)));
       // 测试 equipId 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setEquipId(null)));
       // 测试 tester 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setTester(null)));
       // 测试 testTime 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setTestTime(null)));
       // 测试 insertTime 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setInsertTime(null)));
       // 测试 avgSoilWater 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setAvgSoilWater(null)));
       // 测试 soilType 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setSoilType(null)));
       // 测试 subType 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setSubType(null)));
       // 测试 soilGenus 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setSoilGenus(null)));
       // 测试 soilSpecies 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setSoilSpecies(null)));
       // 测试 commonName 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setCommonName(null)));
       // 测试 soilParentMaterial 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setSoilParentMaterial(null)));
       // 测试 profilePattern 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setProfilePattern(null)));
       // 测试 texture 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setTexture(null)));
       // 测试 soilStructure 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setSoilStructure(null)));
       // 测试 obstacleFactors 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setObstacleFactors(null)));
       // 测试 erosionDegree 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setErosionDegree(null)));
       // 测试 topsoilDepth 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setTopsoilDepth(null)));
       // 测试 samplingDepth 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setSamplingDepth(null)));
       // 测试 samplingLevelFirst 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setSamplingLevelFirst(null)));
       // 测试 textureFirst 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setTextureFirst(null)));
       // 测试 phFirst 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setPhFirst(null)));
       // 测试 organicMatterFirst 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setOrganicMatterFirst(null)));
       // 测试 availableNitrogenFirst 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setAvailableNitrogenFirst(null)));
       // 测试 effectivePhosphorusFirst 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setEffectivePhosphorusFirst(null)));
       // 测试 totalPotassiumFirst 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setTotalPotassiumFirst(null)));
       // 测试 slowEffectPotassiumFirst 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setSlowEffectPotassiumFirst(null)));
       // 测试 availablePotassiumFirst 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setAvailablePotassiumFirst(null)));
       // 测试 totalNitrogen 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setTotalNitrogen(null)));
       // 测试 source 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setSource(null)));
       // 测试 remarks 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setRemarks(null)));
       // 测试 officeCode 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setCompanyName(null)));
       // 测试 reviewStatus 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setCorpName(null)));
       // 测试 createTime 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       soilEnvMapper.insert(cloneIgnoreId(dbSoilEnv, o -> o.setSubjectId(null)));
       // 准备参数
       SoilEnvExportReqVO reqVO = new SoilEnvExportReqVO();
       reqVO.setBasesId(null);
       reqVO.setEquipId(null);
       reqVO.setTester(null);
       reqVO.setTestTime((new LocalDateTime[]{}));
       reqVO.setInsertTime((new LocalDateTime[]{}));
       reqVO.setAvgSoilWater(null);
       reqVO.setSoilType(null);
       reqVO.setSubType(null);
       reqVO.setSoilGenus(null);
       reqVO.setSoilSpecies(null);
       reqVO.setCommonName(null);
       reqVO.setSoilParentMaterial(null);
       reqVO.setProfilePattern(null);
       reqVO.setTexture(null);
       reqVO.setSoilStructure(null);
       reqVO.setObstacleFactors(null);
       reqVO.setErosionDegree(null);
       reqVO.setTopsoilDepth(null);
       reqVO.setSamplingDepth(null);
       reqVO.setSamplingLevelFirst(null);
       reqVO.setTextureFirst(null);
       reqVO.setPhFirst(null);
       reqVO.setOrganicMatterFirst(null);
       reqVO.setAvailableNitrogenFirst(null);
       reqVO.setEffectivePhosphorusFirst(null);
       reqVO.setTotalPotassiumFirst(null);
       reqVO.setSlowEffectPotassiumFirst(null);
       reqVO.setAvailablePotassiumFirst(null);
       reqVO.setTotalNitrogen(null);
       reqVO.setSource(null);
       reqVO.setRemarks(null);
       reqVO.setOfficeCode(null);
       reqVO.setOfficeName(null);
       reqVO.setCompanyCode(null);
       reqVO.setCompanyName(null);
       reqVO.setReviewStatus(null);
       reqVO.setReviewer(null);
       reqVO.setReviewDate((new LocalDateTime[]{}));
       reqVO.setReviewContent(null);
       reqVO.setCorpCode(null);
       reqVO.setCorpName(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSubjectId(null);

       // 调用
       List<SoilEnvDO> list = soilEnvService.getSoilEnvList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbSoilEnv, list.get(0));
    }

}
