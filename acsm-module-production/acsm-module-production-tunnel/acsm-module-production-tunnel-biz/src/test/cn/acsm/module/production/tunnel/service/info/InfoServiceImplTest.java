package cn.acsm.module.production.tunnel.service.info;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.module.infra.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.production.tunnel.controller.admin.info.vo.*;
import cn.acsm.module.production.tunnel.dal.dataobject.info.InfoDO;
import cn.acsm.module.production.tunnel.dal.mysql.info.InfoMapper;
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
           o.setPartitionId(null);
           o.setRealPlantJson(null);
           o.setTunnelInfoId(null);
           o.setTunnelName(null);
           o.setLongitude(null);
           o.setLatitude(null);
           o.setAreaNumber(null);
           o.setMuNumber(null);
           o.setAreaId(null);
           o.setBdLongitude(null);
           o.setBdLatitude(null);
           o.setCoordinateGroup(null);
           o.setPlantEnvTypeId(null);
           o.setStaticPicture(null);
           o.setViewColor(null);
           o.setBorderColor(null);
           o.setOpacity(null);
           o.setLittleStar(null);
           o.setLittleType(null);
           o.setVillagesId(null);
           o.setVillagesCode(null);
           o.setRuralId(null);
           o.setRuralCode(null);
           o.setTunnelCode(null);
           o.setOfficeCode(null);
           o.setOfficeName(null);
           o.setCompanyCode(null);
           o.setCompanyName(null);
           o.setRemarks(null);
           o.setReviewStatus(null);
           o.setReviewer(null);
           o.setReviewDate(null);
           o.setReviewContent(null);
           o.setArchiveStatus(null);
           o.setArchiveTime(null);
           o.setCorpCode(null);
           o.setCorpName(null);
           o.setSyncStatus(null);
           o.setFarmers(null);
           o.setInstructors(null);
           o.setFarmersName(null);
           o.setInstructorsName(null);
           o.setOldId(null);
           o.setAreaName(null);
           o.setRuralName(null);
           o.setVillagesName(null);
           o.setPerformId(null);
           o.setDepartmentId(null);
           o.setMakersId(null);
           o.setMakersDepartmentId(null);
           o.setSubjectId(null);
           o.setAreaNumUnit(null);
           o.setAreaLocation(null);
           o.setLableIds(null);
           o.setPlantStatus(null);
           o.setTunnelinfoImage(null);
           o.setPlantAmount(null);
           o.setAdoption(null);
           o.setCreateTime(null);
           o.setSource(null);
       });
       infoMapper.insert(dbInfo);
       // 测试 baseId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBaseId(null)));
       // 测试 partitionId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPartitionId(null)));
       // 测试 realPlantJson 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setRealPlantJson(null)));
       // 测试 tunnelInfoId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setTunnelInfoId(null)));
       // 测试 tunnelName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setTunnelName(null)));
       // 测试 longitude 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setLongitude(null)));
       // 测试 latitude 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setLatitude(null)));
       // 测试 areaNumber 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAreaNumber(null)));
       // 测试 muNumber 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setMuNumber(null)));
       // 测试 areaId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAreaId(null)));
       // 测试 bdLongitude 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBdLongitude(null)));
       // 测试 bdLatitude 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBdLatitude(null)));
       // 测试 coordinateGroup 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCoordinateGroup(null)));
       // 测试 plantEnvTypeId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPlantEnvTypeId(null)));
       // 测试 staticPicture 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setStaticPicture(null)));
       // 测试 viewColor 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setViewColor(null)));
       // 测试 borderColor 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBorderColor(null)));
       // 测试 opacity 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setOpacity(null)));
       // 测试 littleStar 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setLittleStar(null)));
       // 测试 littleType 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setLittleType(null)));
       // 测试 villagesId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setVillagesId(null)));
       // 测试 villagesCode 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setVillagesCode(null)));
       // 测试 ruralId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setRuralId(null)));
       // 测试 ruralCode 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setRuralCode(null)));
       // 测试 tunnelCode 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setTunnelCode(null)));
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
       // 测试 archiveStatus 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setArchiveStatus(null)));
       // 测试 archiveTime 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setArchiveTime(null)));
       // 测试 corpCode 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCorpName(null)));
       // 测试 syncStatus 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSyncStatus(null)));
       // 测试 farmers 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setFarmers(null)));
       // 测试 instructors 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setInstructors(null)));
       // 测试 farmersName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setFarmersName(null)));
       // 测试 instructorsName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setInstructorsName(null)));
       // 测试 oldId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setOldId(null)));
       // 测试 areaName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAreaName(null)));
       // 测试 ruralName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setRuralName(null)));
       // 测试 villagesName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setVillagesName(null)));
       // 测试 performId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPerformId(null)));
       // 测试 departmentId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setDepartmentId(null)));
       // 测试 makersId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setMakersId(null)));
       // 测试 makersDepartmentId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setMakersDepartmentId(null)));
       // 测试 subjectId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSubjectId(null)));
       // 测试 areaNumUnit 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAreaNumUnit(null)));
       // 测试 areaLocation 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAreaLocation(null)));
       // 测试 lableIds 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setLableIds(null)));
       // 测试 plantStatus 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPlantStatus(null)));
       // 测试 tunnelinfoImage 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setTunnelinfoImage(null)));
       // 测试 plantAmount 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPlantAmount(null)));
       // 测试 adoption 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAdoption(null)));
       // 测试 createTime 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSource(null)));
       // 准备参数
       InfoPageReqVO reqVO = new InfoPageReqVO();
       reqVO.setBaseId(null);
       reqVO.setPartitionId(null);
       reqVO.setRealPlantJson(null);
       reqVO.setTunnelInfoId(null);
       reqVO.setTunnelName(null);
       reqVO.setLongitude(null);
       reqVO.setLatitude(null);
       reqVO.setAreaNumber(null);
       reqVO.setMuNumber(null);
       reqVO.setAreaId(null);
       reqVO.setBdLongitude(null);
       reqVO.setBdLatitude(null);
       reqVO.setCoordinateGroup(null);
       reqVO.setPlantEnvTypeId(null);
       reqVO.setStaticPicture(null);
       reqVO.setViewColor(null);
       reqVO.setBorderColor(null);
       reqVO.setOpacity(null);
       reqVO.setLittleStar(null);
       reqVO.setLittleType(null);
       reqVO.setVillagesId(null);
       reqVO.setVillagesCode(null);
       reqVO.setRuralId(null);
       reqVO.setRuralCode(null);
       reqVO.setTunnelCode(null);
       reqVO.setOfficeCode(null);
       reqVO.setOfficeName(null);
       reqVO.setCompanyCode(null);
       reqVO.setCompanyName(null);
       reqVO.setRemarks(null);
       reqVO.setReviewStatus(null);
       reqVO.setReviewer(null);
       reqVO.setReviewDate((new LocalDateTime[]{}));
       reqVO.setReviewContent(null);
       reqVO.setArchiveStatus(null);
       reqVO.setArchiveTime((new LocalDateTime[]{}));
       reqVO.setCorpCode(null);
       reqVO.setCorpName(null);
       reqVO.setSyncStatus(null);
       reqVO.setFarmers(null);
       reqVO.setInstructors(null);
       reqVO.setFarmersName(null);
       reqVO.setInstructorsName(null);
       reqVO.setOldId(null);
       reqVO.setAreaName(null);
       reqVO.setRuralName(null);
       reqVO.setVillagesName(null);
       reqVO.setPerformId(null);
       reqVO.setDepartmentId(null);
       reqVO.setMakersId(null);
       reqVO.setMakersDepartmentId(null);
       reqVO.setSubjectId(null);
       reqVO.setAreaNumUnit(null);
       reqVO.setAreaLocation(null);
       reqVO.setLableIds(null);
       reqVO.setPlantStatus(null);
       reqVO.setTunnelinfoImage(null);
       reqVO.setPlantAmount(null);
       reqVO.setAdoption(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);

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
           o.setPartitionId(null);
           o.setRealPlantJson(null);
           o.setTunnelInfoId(null);
           o.setTunnelName(null);
           o.setLongitude(null);
           o.setLatitude(null);
           o.setAreaNumber(null);
           o.setMuNumber(null);
           o.setAreaId(null);
           o.setBdLongitude(null);
           o.setBdLatitude(null);
           o.setCoordinateGroup(null);
           o.setPlantEnvTypeId(null);
           o.setStaticPicture(null);
           o.setViewColor(null);
           o.setBorderColor(null);
           o.setOpacity(null);
           o.setLittleStar(null);
           o.setLittleType(null);
           o.setVillagesId(null);
           o.setVillagesCode(null);
           o.setRuralId(null);
           o.setRuralCode(null);
           o.setTunnelCode(null);
           o.setOfficeCode(null);
           o.setOfficeName(null);
           o.setCompanyCode(null);
           o.setCompanyName(null);
           o.setRemarks(null);
           o.setReviewStatus(null);
           o.setReviewer(null);
           o.setReviewDate(null);
           o.setReviewContent(null);
           o.setArchiveStatus(null);
           o.setArchiveTime(null);
           o.setCorpCode(null);
           o.setCorpName(null);
           o.setSyncStatus(null);
           o.setFarmers(null);
           o.setInstructors(null);
           o.setFarmersName(null);
           o.setInstructorsName(null);
           o.setOldId(null);
           o.setAreaName(null);
           o.setRuralName(null);
           o.setVillagesName(null);
           o.setPerformId(null);
           o.setDepartmentId(null);
           o.setMakersId(null);
           o.setMakersDepartmentId(null);
           o.setSubjectId(null);
           o.setAreaNumUnit(null);
           o.setAreaLocation(null);
           o.setLableIds(null);
           o.setPlantStatus(null);
           o.setTunnelinfoImage(null);
           o.setPlantAmount(null);
           o.setAdoption(null);
           o.setCreateTime(null);
           o.setSource(null);
       });
       infoMapper.insert(dbInfo);
       // 测试 baseId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBaseId(null)));
       // 测试 partitionId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPartitionId(null)));
       // 测试 realPlantJson 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setRealPlantJson(null)));
       // 测试 tunnelInfoId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setTunnelInfoId(null)));
       // 测试 tunnelName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setTunnelName(null)));
       // 测试 longitude 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setLongitude(null)));
       // 测试 latitude 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setLatitude(null)));
       // 测试 areaNumber 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAreaNumber(null)));
       // 测试 muNumber 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setMuNumber(null)));
       // 测试 areaId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAreaId(null)));
       // 测试 bdLongitude 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBdLongitude(null)));
       // 测试 bdLatitude 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBdLatitude(null)));
       // 测试 coordinateGroup 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCoordinateGroup(null)));
       // 测试 plantEnvTypeId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPlantEnvTypeId(null)));
       // 测试 staticPicture 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setStaticPicture(null)));
       // 测试 viewColor 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setViewColor(null)));
       // 测试 borderColor 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBorderColor(null)));
       // 测试 opacity 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setOpacity(null)));
       // 测试 littleStar 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setLittleStar(null)));
       // 测试 littleType 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setLittleType(null)));
       // 测试 villagesId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setVillagesId(null)));
       // 测试 villagesCode 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setVillagesCode(null)));
       // 测试 ruralId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setRuralId(null)));
       // 测试 ruralCode 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setRuralCode(null)));
       // 测试 tunnelCode 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setTunnelCode(null)));
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
       // 测试 archiveStatus 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setArchiveStatus(null)));
       // 测试 archiveTime 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setArchiveTime(null)));
       // 测试 corpCode 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCorpName(null)));
       // 测试 syncStatus 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSyncStatus(null)));
       // 测试 farmers 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setFarmers(null)));
       // 测试 instructors 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setInstructors(null)));
       // 测试 farmersName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setFarmersName(null)));
       // 测试 instructorsName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setInstructorsName(null)));
       // 测试 oldId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setOldId(null)));
       // 测试 areaName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAreaName(null)));
       // 测试 ruralName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setRuralName(null)));
       // 测试 villagesName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setVillagesName(null)));
       // 测试 performId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPerformId(null)));
       // 测试 departmentId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setDepartmentId(null)));
       // 测试 makersId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setMakersId(null)));
       // 测试 makersDepartmentId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setMakersDepartmentId(null)));
       // 测试 subjectId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSubjectId(null)));
       // 测试 areaNumUnit 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAreaNumUnit(null)));
       // 测试 areaLocation 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAreaLocation(null)));
       // 测试 lableIds 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setLableIds(null)));
       // 测试 plantStatus 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPlantStatus(null)));
       // 测试 tunnelinfoImage 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setTunnelinfoImage(null)));
       // 测试 plantAmount 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPlantAmount(null)));
       // 测试 adoption 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAdoption(null)));
       // 测试 createTime 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSource(null)));
       // 准备参数
       InfoExportReqVO reqVO = new InfoExportReqVO();
       reqVO.setBaseId(null);
       reqVO.setPartitionId(null);
       reqVO.setRealPlantJson(null);
       reqVO.setTunnelInfoId(null);
       reqVO.setTunnelName(null);
       reqVO.setLongitude(null);
       reqVO.setLatitude(null);
       reqVO.setAreaNumber(null);
       reqVO.setMuNumber(null);
       reqVO.setAreaId(null);
       reqVO.setBdLongitude(null);
       reqVO.setBdLatitude(null);
       reqVO.setCoordinateGroup(null);
       reqVO.setPlantEnvTypeId(null);
       reqVO.setStaticPicture(null);
       reqVO.setViewColor(null);
       reqVO.setBorderColor(null);
       reqVO.setOpacity(null);
       reqVO.setLittleStar(null);
       reqVO.setLittleType(null);
       reqVO.setVillagesId(null);
       reqVO.setVillagesCode(null);
       reqVO.setRuralId(null);
       reqVO.setRuralCode(null);
       reqVO.setTunnelCode(null);
       reqVO.setOfficeCode(null);
       reqVO.setOfficeName(null);
       reqVO.setCompanyCode(null);
       reqVO.setCompanyName(null);
       reqVO.setRemarks(null);
       reqVO.setReviewStatus(null);
       reqVO.setReviewer(null);
       reqVO.setReviewDate((new LocalDateTime[]{}));
       reqVO.setReviewContent(null);
       reqVO.setArchiveStatus(null);
       reqVO.setArchiveTime((new LocalDateTime[]{}));
       reqVO.setCorpCode(null);
       reqVO.setCorpName(null);
       reqVO.setSyncStatus(null);
       reqVO.setFarmers(null);
       reqVO.setInstructors(null);
       reqVO.setFarmersName(null);
       reqVO.setInstructorsName(null);
       reqVO.setOldId(null);
       reqVO.setAreaName(null);
       reqVO.setRuralName(null);
       reqVO.setVillagesName(null);
       reqVO.setPerformId(null);
       reqVO.setDepartmentId(null);
       reqVO.setMakersId(null);
       reqVO.setMakersDepartmentId(null);
       reqVO.setSubjectId(null);
       reqVO.setAreaNumUnit(null);
       reqVO.setAreaLocation(null);
       reqVO.setLableIds(null);
       reqVO.setPlantStatus(null);
       reqVO.setTunnelinfoImage(null);
       reqVO.setPlantAmount(null);
       reqVO.setAdoption(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);

       // 调用
       List<InfoDO> list = infoService.getInfoList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbInfo, list.get(0));
    }

}
