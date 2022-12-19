package cn.acsm.module.production.tunnel.service.infosoilenv;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.module.infra.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.production.tunnel.controller.admin.infosoilenv.vo.*;
import cn.acsm.module.production.tunnel.dal.dataobject.infosoilenv.InfoSoilEnvDO;
import cn.acsm.module.production.tunnel.dal.mysql.infosoilenv.InfoSoilEnvMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.acsm.module.production.tunnel.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.module.infra.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.module.infra.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link InfoSoilEnvServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(InfoSoilEnvServiceImpl.class)
public class InfoSoilEnvServiceImplTest extends BaseDbUnitTest {

    @Resource
    private InfoSoilEnvServiceImpl infoSoilEnvService;

    @Resource
    private InfoSoilEnvMapper infoSoilEnvMapper;

    @Test
    public void testCreateInfoSoilEnv_success() {
        // 准备参数
        InfoSoilEnvCreateReqVO reqVO = randomPojo(InfoSoilEnvCreateReqVO.class);

        // 调用
        Long infoSoilEnvId = infoSoilEnvService.createInfoSoilEnv(reqVO);
        // 断言
        assertNotNull(infoSoilEnvId);
        // 校验记录的属性是否正确
        InfoSoilEnvDO infoSoilEnv = infoSoilEnvMapper.selectById(infoSoilEnvId);
        assertPojoEquals(reqVO, infoSoilEnv);
    }

    @Test
    public void testUpdateInfoSoilEnv_success() {
        // mock 数据
        InfoSoilEnvDO dbInfoSoilEnv = randomPojo(InfoSoilEnvDO.class);
        infoSoilEnvMapper.insert(dbInfoSoilEnv);// @Sql: 先插入出一条存在的数据
        // 准备参数
        InfoSoilEnvUpdateReqVO reqVO = randomPojo(InfoSoilEnvUpdateReqVO.class, o -> {
            o.setId(dbInfoSoilEnv.getId()); // 设置更新的 ID
        });

        // 调用
        infoSoilEnvService.updateInfoSoilEnv(reqVO);
        // 校验是否更新正确
        InfoSoilEnvDO infoSoilEnv = infoSoilEnvMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, infoSoilEnv);
    }

    @Test
    public void testUpdateInfoSoilEnv_notExists() {
        // 准备参数
        InfoSoilEnvUpdateReqVO reqVO = randomPojo(InfoSoilEnvUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> infoSoilEnvService.updateInfoSoilEnv(reqVO), INFO_SOIL_ENV_NOT_EXISTS);
    }

    @Test
    public void testDeleteInfoSoilEnv_success() {
        // mock 数据
        InfoSoilEnvDO dbInfoSoilEnv = randomPojo(InfoSoilEnvDO.class);
        infoSoilEnvMapper.insert(dbInfoSoilEnv);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbInfoSoilEnv.getId();

        // 调用
        infoSoilEnvService.deleteInfoSoilEnv(id);
       // 校验数据不存在了
       assertNull(infoSoilEnvMapper.selectById(id));
    }

    @Test
    public void testDeleteInfoSoilEnv_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> infoSoilEnvService.deleteInfoSoilEnv(id), INFO_SOIL_ENV_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInfoSoilEnvPage() {
       // mock 数据
       InfoSoilEnvDO dbInfoSoilEnv = randomPojo(InfoSoilEnvDO.class, o -> { // 等会查询到
           o.setTunnelId(null);
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
       infoSoilEnvMapper.insert(dbInfoSoilEnv);
       // 测试 tunnelId 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setTunnelId(null)));
       // 测试 equipId 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setEquipId(null)));
       // 测试 tester 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setTester(null)));
       // 测试 testTime 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setTestTime(null)));
       // 测试 insertTime 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setInsertTime(null)));
       // 测试 avgSoilWater 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setAvgSoilWater(null)));
       // 测试 soilType 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setSoilType(null)));
       // 测试 subType 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setSubType(null)));
       // 测试 soilGenus 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setSoilGenus(null)));
       // 测试 soilSpecies 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setSoilSpecies(null)));
       // 测试 commonName 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setCommonName(null)));
       // 测试 soilParentMaterial 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setSoilParentMaterial(null)));
       // 测试 profilePattern 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setProfilePattern(null)));
       // 测试 texture 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setTexture(null)));
       // 测试 soilStructure 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setSoilStructure(null)));
       // 测试 obstacleFactors 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setObstacleFactors(null)));
       // 测试 erosionDegree 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setErosionDegree(null)));
       // 测试 topsoilDepth 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setTopsoilDepth(null)));
       // 测试 samplingDepth 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setSamplingDepth(null)));
       // 测试 samplingLevelFirst 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setSamplingLevelFirst(null)));
       // 测试 textureFirst 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setTextureFirst(null)));
       // 测试 phFirst 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setPhFirst(null)));
       // 测试 organicMatterFirst 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setOrganicMatterFirst(null)));
       // 测试 availableNitrogenFirst 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setAvailableNitrogenFirst(null)));
       // 测试 effectivePhosphorusFirst 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setEffectivePhosphorusFirst(null)));
       // 测试 totalPotassiumFirst 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setTotalPotassiumFirst(null)));
       // 测试 slowEffectPotassiumFirst 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setSlowEffectPotassiumFirst(null)));
       // 测试 availablePotassiumFirst 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setAvailablePotassiumFirst(null)));
       // 测试 totalNitrogen 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setTotalNitrogen(null)));
       // 测试 source 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setSource(null)));
       // 测试 remarks 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setRemarks(null)));
       // 测试 officeCode 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setCompanyName(null)));
       // 测试 reviewStatus 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setCorpName(null)));
       // 测试 createTime 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setSubjectId(null)));
       // 准备参数
       InfoSoilEnvPageReqVO reqVO = new InfoSoilEnvPageReqVO();
       reqVO.setTunnelId(null);
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
       PageResult<InfoSoilEnvDO> pageResult = infoSoilEnvService.getInfoSoilEnvPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbInfoSoilEnv, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInfoSoilEnvList() {
       // mock 数据
       InfoSoilEnvDO dbInfoSoilEnv = randomPojo(InfoSoilEnvDO.class, o -> { // 等会查询到
           o.setTunnelId(null);
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
       infoSoilEnvMapper.insert(dbInfoSoilEnv);
       // 测试 tunnelId 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setTunnelId(null)));
       // 测试 equipId 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setEquipId(null)));
       // 测试 tester 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setTester(null)));
       // 测试 testTime 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setTestTime(null)));
       // 测试 insertTime 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setInsertTime(null)));
       // 测试 avgSoilWater 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setAvgSoilWater(null)));
       // 测试 soilType 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setSoilType(null)));
       // 测试 subType 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setSubType(null)));
       // 测试 soilGenus 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setSoilGenus(null)));
       // 测试 soilSpecies 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setSoilSpecies(null)));
       // 测试 commonName 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setCommonName(null)));
       // 测试 soilParentMaterial 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setSoilParentMaterial(null)));
       // 测试 profilePattern 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setProfilePattern(null)));
       // 测试 texture 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setTexture(null)));
       // 测试 soilStructure 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setSoilStructure(null)));
       // 测试 obstacleFactors 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setObstacleFactors(null)));
       // 测试 erosionDegree 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setErosionDegree(null)));
       // 测试 topsoilDepth 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setTopsoilDepth(null)));
       // 测试 samplingDepth 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setSamplingDepth(null)));
       // 测试 samplingLevelFirst 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setSamplingLevelFirst(null)));
       // 测试 textureFirst 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setTextureFirst(null)));
       // 测试 phFirst 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setPhFirst(null)));
       // 测试 organicMatterFirst 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setOrganicMatterFirst(null)));
       // 测试 availableNitrogenFirst 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setAvailableNitrogenFirst(null)));
       // 测试 effectivePhosphorusFirst 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setEffectivePhosphorusFirst(null)));
       // 测试 totalPotassiumFirst 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setTotalPotassiumFirst(null)));
       // 测试 slowEffectPotassiumFirst 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setSlowEffectPotassiumFirst(null)));
       // 测试 availablePotassiumFirst 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setAvailablePotassiumFirst(null)));
       // 测试 totalNitrogen 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setTotalNitrogen(null)));
       // 测试 source 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setSource(null)));
       // 测试 remarks 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setRemarks(null)));
       // 测试 officeCode 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setCompanyName(null)));
       // 测试 reviewStatus 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setCorpName(null)));
       // 测试 createTime 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       infoSoilEnvMapper.insert(cloneIgnoreId(dbInfoSoilEnv, o -> o.setSubjectId(null)));
       // 准备参数
       InfoSoilEnvExportReqVO reqVO = new InfoSoilEnvExportReqVO();
       reqVO.setTunnelId(null);
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
       List<InfoSoilEnvDO> list = infoSoilEnvService.getInfoSoilEnvList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbInfoSoilEnv, list.get(0));
    }

}
