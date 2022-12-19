package cn.acsm.module.production.bases.service.info;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.module.infra.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.production.bases.controller.admin.info.vo.*;
import cn.acsm.module.production.bases.dal.dataobject.info.InfoDO;
import cn.acsm.module.production.bases.dal.mysql.info.InfoMapper;
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
* {@link InfoServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(InfoServiceImpl.class)
public class InfoServiceImplTest extends BaseDbUnitTest {

    @Resource
    private InfoServiceImpl infoService;

    @Resource
    private InfoMapper infoMapper;

    @Test
    public void testCreateInfo_success() {
        // 准备参数
        InfoCreateReqVO reqVO = randomPojo(InfoCreateReqVO.class);

        // 调用
        Long infoId = infoService.createInfo(reqVO);
        // 断言
        assertNotNull(infoId);
        // 校验记录的属性是否正确
        InfoDO info = infoMapper.selectById(infoId);
        assertPojoEquals(reqVO, info);
    }

    @Test
    public void testUpdateInfo_success() {
        // mock 数据
        InfoDO dbInfo = randomPojo(InfoDO.class);
        infoMapper.insert(dbInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        InfoUpdateReqVO reqVO = randomPojo(InfoUpdateReqVO.class, o -> {
            o.setId(dbInfo.getId()); // 设置更新的 ID
        });

        // 调用
        infoService.updateInfo(reqVO);
        // 校验是否更新正确
        InfoDO info = infoMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, info);
    }

    @Test
    public void testUpdateInfo_notExists() {
        // 准备参数
        InfoUpdateReqVO reqVO = randomPojo(InfoUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> infoService.updateInfo(reqVO), INFO_NOT_EXISTS);
    }

    @Test
    public void testDeleteInfo_success() {
        // mock 数据
        InfoDO dbInfo = randomPojo(InfoDO.class);
        infoMapper.insert(dbInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbInfo.getId();

        // 调用
        infoService.deleteInfo(id);
       // 校验数据不存在了
       assertNull(infoMapper.selectById(id));
    }

    @Test
    public void testDeleteInfo_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> infoService.deleteInfo(id), INFO_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInfoPage() {
       // mock 数据
       InfoDO dbInfo = randomPojo(InfoDO.class, o -> { // 等会查询到
           o.setAreaId(null);
           o.setAreaName(null);
           o.setVillagesAreaId(null);
           o.setVillagesAreaName(null);
           o.setRuralId(null);
           o.setRuralName(null);
           o.setBaseName(null);
           o.setContactName(null);
           o.setContactPhone(null);
           o.setAddress(null);
           o.setEmail(null);
           o.setLongitude(null);
           o.setLatitude(null);
           o.setBdLongitude(null);
           o.setBdLatitude(null);
           o.setCoordinateGroup(null);
           o.setAreaNumber(null);
           o.setMuNumber(null);
           o.setViewColor(null);
           o.setStaticPicture(null);
           o.setAltitude(null);
           o.setPersistSupply(null);
           o.setBaseCode(null);
           o.setWaterSource(null);
           o.setTerrain(null);
           o.setSoilType(null);
           o.setSoilPh(null);
           o.setClimateType(null);
           o.setAnnualRainfall(null);
           o.setAverageTemperature(null);
           o.setBasesContent(null);
           o.setOfficeCode(null);
           o.setOfficeName(null);
           o.setCompanyCode(null);
           o.setCompanyName(null);
           o.setRemarks(null);
           o.setReviewStatus(null);
           o.setReviewer(null);
           o.setReviewDate(null);
           o.setReviewContent(null);
           o.setGapId(null);
           o.setAffiliatedEnterprises(null);
           o.setClassify(null);
           o.setCorpCode(null);
           o.setCorpName(null);
           o.setBorderColor(null);
           o.setPanoramaUrl(null);
           o.setBuildDate(null);
           o.setSyncStatus(null);
           o.setPropagandaVideo(null);
           o.setOpacity(null);
           o.setOldId(null);
           o.setBasesImage(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       infoMapper.insert(dbInfo);
       // 测试 areaId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAreaId(null)));
       // 测试 areaName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAreaName(null)));
       // 测试 villagesAreaId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setVillagesAreaId(null)));
       // 测试 villagesAreaName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setVillagesAreaName(null)));
       // 测试 ruralId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setRuralId(null)));
       // 测试 ruralName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setRuralName(null)));
       // 测试 baseName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBaseName(null)));
       // 测试 contactName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setContactName(null)));
       // 测试 contactPhone 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setContactPhone(null)));
       // 测试 address 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAddress(null)));
       // 测试 email 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setEmail(null)));
       // 测试 longitude 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setLongitude(null)));
       // 测试 latitude 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setLatitude(null)));
       // 测试 bdLongitude 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBdLongitude(null)));
       // 测试 bdLatitude 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBdLatitude(null)));
       // 测试 coordinateGroup 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCoordinateGroup(null)));
       // 测试 areaNumber 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAreaNumber(null)));
       // 测试 muNumber 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setMuNumber(null)));
       // 测试 viewColor 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setViewColor(null)));
       // 测试 staticPicture 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setStaticPicture(null)));
       // 测试 altitude 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAltitude(null)));
       // 测试 persistSupply 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPersistSupply(null)));
       // 测试 baseCode 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBaseCode(null)));
       // 测试 waterSource 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setWaterSource(null)));
       // 测试 terrain 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setTerrain(null)));
       // 测试 soilType 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSoilType(null)));
       // 测试 soilPh 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSoilPh(null)));
       // 测试 climateType 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setClimateType(null)));
       // 测试 annualRainfall 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAnnualRainfall(null)));
       // 测试 averageTemperature 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAverageTemperature(null)));
       // 测试 basesContent 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBasesContent(null)));
       // 测试 officeCode 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCompanyName(null)));
       // 测试 remarks 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setRemarks(null)));
       // 测试 reviewStatus 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setReviewContent(null)));
       // 测试 gapId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setGapId(null)));
       // 测试 affiliatedEnterprises 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAffiliatedEnterprises(null)));
       // 测试 classify 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setClassify(null)));
       // 测试 corpCode 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCorpName(null)));
       // 测试 borderColor 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBorderColor(null)));
       // 测试 panoramaUrl 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPanoramaUrl(null)));
       // 测试 buildDate 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBuildDate(null)));
       // 测试 syncStatus 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSyncStatus(null)));
       // 测试 propagandaVideo 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPropagandaVideo(null)));
       // 测试 opacity 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setOpacity(null)));
       // 测试 oldId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setOldId(null)));
       // 测试 basesImage 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBasesImage(null)));
       // 测试 createTime 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSubjectId(null)));
       // 准备参数
       InfoPageReqVO reqVO = new InfoPageReqVO();
       reqVO.setAreaId(null);
       reqVO.setAreaName(null);
       reqVO.setVillagesAreaId(null);
       reqVO.setVillagesAreaName(null);
       reqVO.setRuralId(null);
       reqVO.setRuralName(null);
       reqVO.setBaseName(null);
       reqVO.setContactName(null);
       reqVO.setContactPhone(null);
       reqVO.setAddress(null);
       reqVO.setEmail(null);
       reqVO.setLongitude(null);
       reqVO.setLatitude(null);
       reqVO.setBdLongitude(null);
       reqVO.setBdLatitude(null);
       reqVO.setCoordinateGroup(null);
       reqVO.setAreaNumber(null);
       reqVO.setMuNumber(null);
       reqVO.setViewColor(null);
       reqVO.setStaticPicture(null);
       reqVO.setAltitude(null);
       reqVO.setPersistSupply(null);
       reqVO.setBaseCode(null);
       reqVO.setWaterSource(null);
       reqVO.setTerrain(null);
       reqVO.setSoilType(null);
       reqVO.setSoilPh(null);
       reqVO.setClimateType(null);
       reqVO.setAnnualRainfall(null);
       reqVO.setAverageTemperature(null);
       reqVO.setBasesContent(null);
       reqVO.setOfficeCode(null);
       reqVO.setOfficeName(null);
       reqVO.setCompanyCode(null);
       reqVO.setCompanyName(null);
       reqVO.setRemarks(null);
       reqVO.setReviewStatus(null);
       reqVO.setReviewer(null);
       reqVO.setReviewDate((new LocalDateTime[]{}));
       reqVO.setReviewContent(null);
       reqVO.setGapId(null);
       reqVO.setAffiliatedEnterprises(null);
       reqVO.setClassify(null);
       reqVO.setCorpCode(null);
       reqVO.setCorpName(null);
       reqVO.setBorderColor(null);
       reqVO.setPanoramaUrl(null);
       reqVO.setBuildDate((new LocalDateTime[]{}));
       reqVO.setSyncStatus(null);
       reqVO.setPropagandaVideo(null);
       reqVO.setOpacity(null);
       reqVO.setOldId(null);
       reqVO.setBasesImage(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       PageResult<InfoDO> pageResult = infoService.getInfoPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbInfo, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInfoList() {
       // mock 数据
       InfoDO dbInfo = randomPojo(InfoDO.class, o -> { // 等会查询到
           o.setAreaId(null);
           o.setAreaName(null);
           o.setVillagesAreaId(null);
           o.setVillagesAreaName(null);
           o.setRuralId(null);
           o.setRuralName(null);
           o.setBaseName(null);
           o.setContactName(null);
           o.setContactPhone(null);
           o.setAddress(null);
           o.setEmail(null);
           o.setLongitude(null);
           o.setLatitude(null);
           o.setBdLongitude(null);
           o.setBdLatitude(null);
           o.setCoordinateGroup(null);
           o.setAreaNumber(null);
           o.setMuNumber(null);
           o.setViewColor(null);
           o.setStaticPicture(null);
           o.setAltitude(null);
           o.setPersistSupply(null);
           o.setBaseCode(null);
           o.setWaterSource(null);
           o.setTerrain(null);
           o.setSoilType(null);
           o.setSoilPh(null);
           o.setClimateType(null);
           o.setAnnualRainfall(null);
           o.setAverageTemperature(null);
           o.setBasesContent(null);
           o.setOfficeCode(null);
           o.setOfficeName(null);
           o.setCompanyCode(null);
           o.setCompanyName(null);
           o.setRemarks(null);
           o.setReviewStatus(null);
           o.setReviewer(null);
           o.setReviewDate(null);
           o.setReviewContent(null);
           o.setGapId(null);
           o.setAffiliatedEnterprises(null);
           o.setClassify(null);
           o.setCorpCode(null);
           o.setCorpName(null);
           o.setBorderColor(null);
           o.setPanoramaUrl(null);
           o.setBuildDate(null);
           o.setSyncStatus(null);
           o.setPropagandaVideo(null);
           o.setOpacity(null);
           o.setOldId(null);
           o.setBasesImage(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       infoMapper.insert(dbInfo);
       // 测试 areaId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAreaId(null)));
       // 测试 areaName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAreaName(null)));
       // 测试 villagesAreaId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setVillagesAreaId(null)));
       // 测试 villagesAreaName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setVillagesAreaName(null)));
       // 测试 ruralId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setRuralId(null)));
       // 测试 ruralName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setRuralName(null)));
       // 测试 baseName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBaseName(null)));
       // 测试 contactName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setContactName(null)));
       // 测试 contactPhone 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setContactPhone(null)));
       // 测试 address 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAddress(null)));
       // 测试 email 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setEmail(null)));
       // 测试 longitude 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setLongitude(null)));
       // 测试 latitude 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setLatitude(null)));
       // 测试 bdLongitude 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBdLongitude(null)));
       // 测试 bdLatitude 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBdLatitude(null)));
       // 测试 coordinateGroup 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCoordinateGroup(null)));
       // 测试 areaNumber 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAreaNumber(null)));
       // 测试 muNumber 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setMuNumber(null)));
       // 测试 viewColor 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setViewColor(null)));
       // 测试 staticPicture 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setStaticPicture(null)));
       // 测试 altitude 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAltitude(null)));
       // 测试 persistSupply 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPersistSupply(null)));
       // 测试 baseCode 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBaseCode(null)));
       // 测试 waterSource 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setWaterSource(null)));
       // 测试 terrain 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setTerrain(null)));
       // 测试 soilType 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSoilType(null)));
       // 测试 soilPh 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSoilPh(null)));
       // 测试 climateType 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setClimateType(null)));
       // 测试 annualRainfall 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAnnualRainfall(null)));
       // 测试 averageTemperature 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAverageTemperature(null)));
       // 测试 basesContent 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBasesContent(null)));
       // 测试 officeCode 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCompanyName(null)));
       // 测试 remarks 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setRemarks(null)));
       // 测试 reviewStatus 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setReviewContent(null)));
       // 测试 gapId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setGapId(null)));
       // 测试 affiliatedEnterprises 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAffiliatedEnterprises(null)));
       // 测试 classify 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setClassify(null)));
       // 测试 corpCode 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCorpName(null)));
       // 测试 borderColor 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBorderColor(null)));
       // 测试 panoramaUrl 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPanoramaUrl(null)));
       // 测试 buildDate 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBuildDate(null)));
       // 测试 syncStatus 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSyncStatus(null)));
       // 测试 propagandaVideo 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPropagandaVideo(null)));
       // 测试 opacity 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setOpacity(null)));
       // 测试 oldId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setOldId(null)));
       // 测试 basesImage 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBasesImage(null)));
       // 测试 createTime 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSubjectId(null)));
       // 准备参数
       InfoExportReqVO reqVO = new InfoExportReqVO();
       reqVO.setAreaId(null);
       reqVO.setAreaName(null);
       reqVO.setVillagesAreaId(null);
       reqVO.setVillagesAreaName(null);
       reqVO.setRuralId(null);
       reqVO.setRuralName(null);
       reqVO.setBaseName(null);
       reqVO.setContactName(null);
       reqVO.setContactPhone(null);
       reqVO.setAddress(null);
       reqVO.setEmail(null);
       reqVO.setLongitude(null);
       reqVO.setLatitude(null);
       reqVO.setBdLongitude(null);
       reqVO.setBdLatitude(null);
       reqVO.setCoordinateGroup(null);
       reqVO.setAreaNumber(null);
       reqVO.setMuNumber(null);
       reqVO.setViewColor(null);
       reqVO.setStaticPicture(null);
       reqVO.setAltitude(null);
       reqVO.setPersistSupply(null);
       reqVO.setBaseCode(null);
       reqVO.setWaterSource(null);
       reqVO.setTerrain(null);
       reqVO.setSoilType(null);
       reqVO.setSoilPh(null);
       reqVO.setClimateType(null);
       reqVO.setAnnualRainfall(null);
       reqVO.setAverageTemperature(null);
       reqVO.setBasesContent(null);
       reqVO.setOfficeCode(null);
       reqVO.setOfficeName(null);
       reqVO.setCompanyCode(null);
       reqVO.setCompanyName(null);
       reqVO.setRemarks(null);
       reqVO.setReviewStatus(null);
       reqVO.setReviewer(null);
       reqVO.setReviewDate((new LocalDateTime[]{}));
       reqVO.setReviewContent(null);
       reqVO.setGapId(null);
       reqVO.setAffiliatedEnterprises(null);
       reqVO.setClassify(null);
       reqVO.setCorpCode(null);
       reqVO.setCorpName(null);
       reqVO.setBorderColor(null);
       reqVO.setPanoramaUrl(null);
       reqVO.setBuildDate((new LocalDateTime[]{}));
       reqVO.setSyncStatus(null);
       reqVO.setPropagandaVideo(null);
       reqVO.setOpacity(null);
       reqVO.setOldId(null);
       reqVO.setBasesImage(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       List<InfoDO> list = infoService.getInfoList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbInfo, list.get(0));
    }

}
