package cn.acsm.module.production.facility.service.info;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.module.infra.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.production.facility.controller.admin.info.vo.*;
import cn.acsm.module.production.facility.dal.dataobject.info.InfoDO;
import cn.acsm.module.production.facility.dal.mysql.info.InfoMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.acsm.module.production.facility.enums.ErrorCodeConstants.*;
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
           o.setBaseId(null);
           o.setName(null);
           o.setFacilityCode(null);
           o.setClassify(null);
           o.setFacilityType(null);
           o.setAreaNumber(null);
           o.setMuNumber(null);
           o.setLongitude(null);
           o.setLatitude(null);
           o.setBdLongitude(null);
           o.setBdLatitude(null);
           o.setCoordinateGroup(null);
           o.setOpacity(null);
           o.setViewColor(null);
           o.setBorderColor(null);
           o.setPlantId(null);
           o.setCommoditySpec(null);
           o.setCommodityNum(null);
           o.setPlantName(null);
           o.setOfficeCode(null);
           o.setOfficeName(null);
           o.setCompanyCode(null);
           o.setCompanyName(null);
           o.setRemarks(null);
           o.setReviewStatus(null);
           o.setReviewer(null);
           o.setReviewDate(null);
           o.setReviewContent(null);
           o.setIndustryLabel(null);
           o.setAddress(null);
           o.setSecondFacilityType(null);
           o.setStorageConditions(null);
           o.setCorpCode(null);
           o.setCorpName(null);
           o.setSyncStatus(null);
           o.setTunnelInfoId(null);
           o.setAreaId(null);
           o.setRuralId(null);
           o.setVillagesAreaId(null);
           o.setAreaName(null);
           o.setRuralName(null);
           o.setVillagesAreaName(null);
           o.setRegionalManagementId(null);
           o.setInduFacilityInfoState(null);
           o.setExpirationTime(null);
           o.setIndufacilityinfoImage(null);
           o.setAreaNumberUnit(null);
           o.setBuilding(null);
           o.setFloor(null);
           o.setHouseNumber(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       infoMapper.insert(dbInfo);
       // 测试 baseId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBaseId(null)));
       // 测试 name 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setName(null)));
       // 测试 facilityCode 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setFacilityCode(null)));
       // 测试 classify 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setClassify(null)));
       // 测试 facilityType 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setFacilityType(null)));
       // 测试 areaNumber 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAreaNumber(null)));
       // 测试 muNumber 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setMuNumber(null)));
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
       // 测试 opacity 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setOpacity(null)));
       // 测试 viewColor 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setViewColor(null)));
       // 测试 borderColor 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBorderColor(null)));
       // 测试 plantId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPlantId(null)));
       // 测试 commoditySpec 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCommoditySpec(null)));
       // 测试 commodityNum 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCommodityNum(null)));
       // 测试 plantName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPlantName(null)));
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
       // 测试 industryLabel 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setIndustryLabel(null)));
       // 测试 address 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAddress(null)));
       // 测试 secondFacilityType 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSecondFacilityType(null)));
       // 测试 storageConditions 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setStorageConditions(null)));
       // 测试 corpCode 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCorpName(null)));
       // 测试 syncStatus 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSyncStatus(null)));
       // 测试 tunnelInfoId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setTunnelInfoId(null)));
       // 测试 areaId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAreaId(null)));
       // 测试 ruralId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setRuralId(null)));
       // 测试 villagesAreaId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setVillagesAreaId(null)));
       // 测试 areaName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAreaName(null)));
       // 测试 ruralName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setRuralName(null)));
       // 测试 villagesAreaName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setVillagesAreaName(null)));
       // 测试 regionalManagementId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setRegionalManagementId(null)));
       // 测试 induFacilityInfoState 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setInduFacilityInfoState(null)));
       // 测试 expirationTime 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setExpirationTime(null)));
       // 测试 indufacilityinfoImage 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setIndufacilityinfoImage(null)));
       // 测试 areaNumberUnit 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAreaNumberUnit(null)));
       // 测试 building 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBuilding(null)));
       // 测试 floor 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setFloor(null)));
       // 测试 houseNumber 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setHouseNumber(null)));
       // 测试 createTime 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSubjectId(null)));
       // 准备参数
       InfoPageReqVO reqVO = new InfoPageReqVO();
       reqVO.setBaseId(null);
       reqVO.setName(null);
       reqVO.setFacilityCode(null);
       reqVO.setClassify(null);
       reqVO.setFacilityType(null);
       reqVO.setAreaNumber(null);
       reqVO.setMuNumber(null);
       reqVO.setLongitude(null);
       reqVO.setLatitude(null);
       reqVO.setBdLongitude(null);
       reqVO.setBdLatitude(null);
       reqVO.setCoordinateGroup(null);
       reqVO.setOpacity(null);
       reqVO.setViewColor(null);
       reqVO.setBorderColor(null);
       reqVO.setPlantId(null);
       reqVO.setCommoditySpec(null);
       reqVO.setCommodityNum(null);
       reqVO.setPlantName(null);
       reqVO.setOfficeCode(null);
       reqVO.setOfficeName(null);
       reqVO.setCompanyCode(null);
       reqVO.setCompanyName(null);
       reqVO.setRemarks(null);
       reqVO.setReviewStatus(null);
       reqVO.setReviewer(null);
       reqVO.setReviewDate((new LocalDateTime[]{}));
       reqVO.setReviewContent(null);
       reqVO.setIndustryLabel(null);
       reqVO.setAddress(null);
       reqVO.setSecondFacilityType(null);
       reqVO.setStorageConditions(null);
       reqVO.setCorpCode(null);
       reqVO.setCorpName(null);
       reqVO.setSyncStatus(null);
       reqVO.setTunnelInfoId(null);
       reqVO.setAreaId(null);
       reqVO.setRuralId(null);
       reqVO.setVillagesAreaId(null);
       reqVO.setAreaName(null);
       reqVO.setRuralName(null);
       reqVO.setVillagesAreaName(null);
       reqVO.setRegionalManagementId(null);
       reqVO.setInduFacilityInfoState(null);
       reqVO.setExpirationTime((new LocalDateTime[]{}));
       reqVO.setIndufacilityinfoImage(null);
       reqVO.setAreaNumberUnit(null);
       reqVO.setBuilding(null);
       reqVO.setFloor(null);
       reqVO.setHouseNumber(null);
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
           o.setBaseId(null);
           o.setName(null);
           o.setFacilityCode(null);
           o.setClassify(null);
           o.setFacilityType(null);
           o.setAreaNumber(null);
           o.setMuNumber(null);
           o.setLongitude(null);
           o.setLatitude(null);
           o.setBdLongitude(null);
           o.setBdLatitude(null);
           o.setCoordinateGroup(null);
           o.setOpacity(null);
           o.setViewColor(null);
           o.setBorderColor(null);
           o.setPlantId(null);
           o.setCommoditySpec(null);
           o.setCommodityNum(null);
           o.setPlantName(null);
           o.setOfficeCode(null);
           o.setOfficeName(null);
           o.setCompanyCode(null);
           o.setCompanyName(null);
           o.setRemarks(null);
           o.setReviewStatus(null);
           o.setReviewer(null);
           o.setReviewDate(null);
           o.setReviewContent(null);
           o.setIndustryLabel(null);
           o.setAddress(null);
           o.setSecondFacilityType(null);
           o.setStorageConditions(null);
           o.setCorpCode(null);
           o.setCorpName(null);
           o.setSyncStatus(null);
           o.setTunnelInfoId(null);
           o.setAreaId(null);
           o.setRuralId(null);
           o.setVillagesAreaId(null);
           o.setAreaName(null);
           o.setRuralName(null);
           o.setVillagesAreaName(null);
           o.setRegionalManagementId(null);
           o.setInduFacilityInfoState(null);
           o.setExpirationTime(null);
           o.setIndufacilityinfoImage(null);
           o.setAreaNumberUnit(null);
           o.setBuilding(null);
           o.setFloor(null);
           o.setHouseNumber(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       infoMapper.insert(dbInfo);
       // 测试 baseId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBaseId(null)));
       // 测试 name 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setName(null)));
       // 测试 facilityCode 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setFacilityCode(null)));
       // 测试 classify 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setClassify(null)));
       // 测试 facilityType 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setFacilityType(null)));
       // 测试 areaNumber 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAreaNumber(null)));
       // 测试 muNumber 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setMuNumber(null)));
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
       // 测试 opacity 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setOpacity(null)));
       // 测试 viewColor 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setViewColor(null)));
       // 测试 borderColor 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBorderColor(null)));
       // 测试 plantId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPlantId(null)));
       // 测试 commoditySpec 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCommoditySpec(null)));
       // 测试 commodityNum 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCommodityNum(null)));
       // 测试 plantName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPlantName(null)));
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
       // 测试 industryLabel 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setIndustryLabel(null)));
       // 测试 address 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAddress(null)));
       // 测试 secondFacilityType 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSecondFacilityType(null)));
       // 测试 storageConditions 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setStorageConditions(null)));
       // 测试 corpCode 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCorpName(null)));
       // 测试 syncStatus 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSyncStatus(null)));
       // 测试 tunnelInfoId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setTunnelInfoId(null)));
       // 测试 areaId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAreaId(null)));
       // 测试 ruralId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setRuralId(null)));
       // 测试 villagesAreaId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setVillagesAreaId(null)));
       // 测试 areaName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAreaName(null)));
       // 测试 ruralName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setRuralName(null)));
       // 测试 villagesAreaName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setVillagesAreaName(null)));
       // 测试 regionalManagementId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setRegionalManagementId(null)));
       // 测试 induFacilityInfoState 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setInduFacilityInfoState(null)));
       // 测试 expirationTime 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setExpirationTime(null)));
       // 测试 indufacilityinfoImage 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setIndufacilityinfoImage(null)));
       // 测试 areaNumberUnit 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAreaNumberUnit(null)));
       // 测试 building 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBuilding(null)));
       // 测试 floor 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setFloor(null)));
       // 测试 houseNumber 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setHouseNumber(null)));
       // 测试 createTime 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSubjectId(null)));
       // 准备参数
       InfoExportReqVO reqVO = new InfoExportReqVO();
       reqVO.setBaseId(null);
       reqVO.setName(null);
       reqVO.setFacilityCode(null);
       reqVO.setClassify(null);
       reqVO.setFacilityType(null);
       reqVO.setAreaNumber(null);
       reqVO.setMuNumber(null);
       reqVO.setLongitude(null);
       reqVO.setLatitude(null);
       reqVO.setBdLongitude(null);
       reqVO.setBdLatitude(null);
       reqVO.setCoordinateGroup(null);
       reqVO.setOpacity(null);
       reqVO.setViewColor(null);
       reqVO.setBorderColor(null);
       reqVO.setPlantId(null);
       reqVO.setCommoditySpec(null);
       reqVO.setCommodityNum(null);
       reqVO.setPlantName(null);
       reqVO.setOfficeCode(null);
       reqVO.setOfficeName(null);
       reqVO.setCompanyCode(null);
       reqVO.setCompanyName(null);
       reqVO.setRemarks(null);
       reqVO.setReviewStatus(null);
       reqVO.setReviewer(null);
       reqVO.setReviewDate((new LocalDateTime[]{}));
       reqVO.setReviewContent(null);
       reqVO.setIndustryLabel(null);
       reqVO.setAddress(null);
       reqVO.setSecondFacilityType(null);
       reqVO.setStorageConditions(null);
       reqVO.setCorpCode(null);
       reqVO.setCorpName(null);
       reqVO.setSyncStatus(null);
       reqVO.setTunnelInfoId(null);
       reqVO.setAreaId(null);
       reqVO.setRuralId(null);
       reqVO.setVillagesAreaId(null);
       reqVO.setAreaName(null);
       reqVO.setRuralName(null);
       reqVO.setVillagesAreaName(null);
       reqVO.setRegionalManagementId(null);
       reqVO.setInduFacilityInfoState(null);
       reqVO.setExpirationTime((new LocalDateTime[]{}));
       reqVO.setIndufacilityinfoImage(null);
       reqVO.setAreaNumberUnit(null);
       reqVO.setBuilding(null);
       reqVO.setFloor(null);
       reqVO.setHouseNumber(null);
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
