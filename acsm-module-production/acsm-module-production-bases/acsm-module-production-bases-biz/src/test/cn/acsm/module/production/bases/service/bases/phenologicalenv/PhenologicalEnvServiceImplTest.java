package cn.acsm.module.production.bases.service.phenologicalenv;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import cn.iocoder.yudao.module.infra.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.production.bases.dal.dataobject.phenologicalenv.PhenologicalEnvDO;
import cn.acsm.module.production.bases.dal.mysql.phenologicalenv.PhenologicalEnvMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
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
* {@link PhenologicalEnvServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(PhenologicalEnvServiceImpl.class)
public class PhenologicalEnvServiceImplTest extends BaseDbUnitTest {

    @Resource
    private PhenologicalEnvServiceImpl phenologicalEnvService;

    @Resource
    private PhenologicalEnvMapper phenologicalEnvMapper;

    @Test
    public void testCreatePhenologicalEnv_success() {
        // 准备参数
        PhenologicalEnvCreateReqVO reqVO = randomPojo(PhenologicalEnvCreateReqVO.class);

        // 调用
        Long phenologicalEnvId = phenologicalEnvService.createPhenologicalEnv(reqVO);
        // 断言
        assertNotNull(phenologicalEnvId);
        // 校验记录的属性是否正确
        PhenologicalEnvDO phenologicalEnv = phenologicalEnvMapper.selectById(phenologicalEnvId);
        assertPojoEquals(reqVO, phenologicalEnv);
    }

    @Test
    public void testUpdatePhenologicalEnv_success() {
        // mock 数据
        PhenologicalEnvDO dbPhenologicalEnv = randomPojo(PhenologicalEnvDO.class);
        phenologicalEnvMapper.insert(dbPhenologicalEnv);// @Sql: 先插入出一条存在的数据
        // 准备参数
        PhenologicalEnvUpdateReqVO reqVO = randomPojo(PhenologicalEnvUpdateReqVO.class, o -> {
            o.setId(dbPhenologicalEnv.getId()); // 设置更新的 ID
        });

        // 调用
        phenologicalEnvService.updatePhenologicalEnv(reqVO);
        // 校验是否更新正确
        PhenologicalEnvDO phenologicalEnv = phenologicalEnvMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, phenologicalEnv);
    }

    @Test
    public void testUpdatePhenologicalEnv_notExists() {
        // 准备参数
        PhenologicalEnvUpdateReqVO reqVO = randomPojo(PhenologicalEnvUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> phenologicalEnvService.updatePhenologicalEnv(reqVO), PHENOLOGICAL_ENV_NOT_EXISTS);
    }

    @Test
    public void testDeletePhenologicalEnv_success() {
        // mock 数据
        PhenologicalEnvDO dbPhenologicalEnv = randomPojo(PhenologicalEnvDO.class);
        phenologicalEnvMapper.insert(dbPhenologicalEnv);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbPhenologicalEnv.getId();

        // 调用
        phenologicalEnvService.deletePhenologicalEnv(id);
       // 校验数据不存在了
       assertNull(phenologicalEnvMapper.selectById(id));
    }

    @Test
    public void testDeletePhenologicalEnv_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> phenologicalEnvService.deletePhenologicalEnv(id), PHENOLOGICAL_ENV_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetPhenologicalEnvPage() {
       // mock 数据
       PhenologicalEnvDO dbPhenologicalEnv = randomPojo(PhenologicalEnvDO.class, o -> { // 等会查询到
           o.setBasesId(null);
           o.setDevicesId(null);
           o.setTester(null);
           o.setTestTime(null);
           o.setInsertTime(null);
           o.setLightIntensity(null);
           o.setGeomorphicType(null);
           o.setLandform(null);
           o.setGroundSlope(null);
           o.setSlopeDirection(null);
           o.setEffectiveTemperature(null);
           o.setFrostFreePeriod(null);
           o.setMinTemperatureDays(null);
           o.setMaxTemperatureDays(null);
           o.setTypicalCropSystem(null);
           o.setMaturationSystem(null);
           o.setAnnualYieldLevel(null);
           o.setFarmlandInfrastructure(null);
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
           o.setAltitude(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       phenologicalEnvMapper.insert(dbPhenologicalEnv);
       // 测试 basesId 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setBasesId(null)));
       // 测试 devicesId 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setDevicesId(null)));
       // 测试 tester 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setTester(null)));
       // 测试 testTime 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setTestTime(null)));
       // 测试 insertTime 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setInsertTime(null)));
       // 测试 lightIntensity 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setLightIntensity(null)));
       // 测试 geomorphicType 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setGeomorphicType(null)));
       // 测试 landform 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setLandform(null)));
       // 测试 groundSlope 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setGroundSlope(null)));
       // 测试 slopeDirection 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setSlopeDirection(null)));
       // 测试 effectiveTemperature 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setEffectiveTemperature(null)));
       // 测试 frostFreePeriod 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setFrostFreePeriod(null)));
       // 测试 minTemperatureDays 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setMinTemperatureDays(null)));
       // 测试 maxTemperatureDays 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setMaxTemperatureDays(null)));
       // 测试 typicalCropSystem 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setTypicalCropSystem(null)));
       // 测试 maturationSystem 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setMaturationSystem(null)));
       // 测试 annualYieldLevel 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setAnnualYieldLevel(null)));
       // 测试 farmlandInfrastructure 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setFarmlandInfrastructure(null)));
       // 测试 remarks 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setRemarks(null)));
       // 测试 officeCode 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setCompanyName(null)));
       // 测试 reviewStatus 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setCorpName(null)));
       // 测试 altitude 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setAltitude(null)));
       // 测试 createTime 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setSubjectId(null)));
       // 准备参数
       PhenologicalEnvPageReqVO reqVO = new PhenologicalEnvPageReqVO();
       reqVO.setBasesId(null);
       reqVO.setDevicesId(null);
       reqVO.setTester(null);
       reqVO.setTestTime((new LocalDateTime[]{}));
       reqVO.setInsertTime((new LocalDateTime[]{}));
       reqVO.setLightIntensity(null);
       reqVO.setGeomorphicType(null);
       reqVO.setLandform(null);
       reqVO.setGroundSlope(null);
       reqVO.setSlopeDirection(null);
       reqVO.setEffectiveTemperature(null);
       reqVO.setFrostFreePeriod(null);
       reqVO.setMinTemperatureDays(null);
       reqVO.setMaxTemperatureDays(null);
       reqVO.setTypicalCropSystem(null);
       reqVO.setMaturationSystem(null);
       reqVO.setAnnualYieldLevel(null);
       reqVO.setFarmlandInfrastructure(null);
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
       reqVO.setAltitude(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       PageResult<PhenologicalEnvDO> pageResult = phenologicalEnvService.getPhenologicalEnvPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbPhenologicalEnv, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetPhenologicalEnvList() {
       // mock 数据
       PhenologicalEnvDO dbPhenologicalEnv = randomPojo(PhenologicalEnvDO.class, o -> { // 等会查询到
           o.setBasesId(null);
           o.setDevicesId(null);
           o.setTester(null);
           o.setTestTime(null);
           o.setInsertTime(null);
           o.setLightIntensity(null);
           o.setGeomorphicType(null);
           o.setLandform(null);
           o.setGroundSlope(null);
           o.setSlopeDirection(null);
           o.setEffectiveTemperature(null);
           o.setFrostFreePeriod(null);
           o.setMinTemperatureDays(null);
           o.setMaxTemperatureDays(null);
           o.setTypicalCropSystem(null);
           o.setMaturationSystem(null);
           o.setAnnualYieldLevel(null);
           o.setFarmlandInfrastructure(null);
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
           o.setAltitude(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       phenologicalEnvMapper.insert(dbPhenologicalEnv);
       // 测试 basesId 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setBasesId(null)));
       // 测试 devicesId 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setDevicesId(null)));
       // 测试 tester 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setTester(null)));
       // 测试 testTime 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setTestTime(null)));
       // 测试 insertTime 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setInsertTime(null)));
       // 测试 lightIntensity 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setLightIntensity(null)));
       // 测试 geomorphicType 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setGeomorphicType(null)));
       // 测试 landform 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setLandform(null)));
       // 测试 groundSlope 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setGroundSlope(null)));
       // 测试 slopeDirection 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setSlopeDirection(null)));
       // 测试 effectiveTemperature 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setEffectiveTemperature(null)));
       // 测试 frostFreePeriod 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setFrostFreePeriod(null)));
       // 测试 minTemperatureDays 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setMinTemperatureDays(null)));
       // 测试 maxTemperatureDays 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setMaxTemperatureDays(null)));
       // 测试 typicalCropSystem 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setTypicalCropSystem(null)));
       // 测试 maturationSystem 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setMaturationSystem(null)));
       // 测试 annualYieldLevel 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setAnnualYieldLevel(null)));
       // 测试 farmlandInfrastructure 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setFarmlandInfrastructure(null)));
       // 测试 remarks 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setRemarks(null)));
       // 测试 officeCode 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setCompanyName(null)));
       // 测试 reviewStatus 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setCorpName(null)));
       // 测试 altitude 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setAltitude(null)));
       // 测试 createTime 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       phenologicalEnvMapper.insert(cloneIgnoreId(dbPhenologicalEnv, o -> o.setSubjectId(null)));
       // 准备参数
       PhenologicalEnvExportReqVO reqVO = new PhenologicalEnvExportReqVO();
       reqVO.setBasesId(null);
       reqVO.setDevicesId(null);
       reqVO.setTester(null);
       reqVO.setTestTime((new LocalDateTime[]{}));
       reqVO.setInsertTime((new LocalDateTime[]{}));
       reqVO.setLightIntensity(null);
       reqVO.setGeomorphicType(null);
       reqVO.setLandform(null);
       reqVO.setGroundSlope(null);
       reqVO.setSlopeDirection(null);
       reqVO.setEffectiveTemperature(null);
       reqVO.setFrostFreePeriod(null);
       reqVO.setMinTemperatureDays(null);
       reqVO.setMaxTemperatureDays(null);
       reqVO.setTypicalCropSystem(null);
       reqVO.setMaturationSystem(null);
       reqVO.setAnnualYieldLevel(null);
       reqVO.setFarmlandInfrastructure(null);
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
       reqVO.setAltitude(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       List<PhenologicalEnvDO> list = phenologicalEnvService.getPhenologicalEnvList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbPhenologicalEnv, list.get(0));
    }

}
