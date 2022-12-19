package cn.acsm.module.production.devices.service.info;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.module.infra.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.production.devices.controller.admin.info.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.info.InfoDO;
import cn.acsm.module.production.devices.dal.mysql.info.InfoMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.acsm.module.production.devices.enums.ErrorCodeConstants.*;
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
           o.setTunnelId(null);
           o.setFacilitysId(null);
           o.setDeviceName(null);
           o.setDeviceSn(null);
           o.setClassify(null);
           o.setDeviceType(null);
           o.setDeviceTypeName(null);
           o.setBuyer(null);
           o.setBuyTime(null);
           o.setProductBy(null);
           o.setProductModel(null);
           o.setPower(null);
           o.setWorkStatus(null);
           o.setLongitude(null);
           o.setLatitude(null);
           o.setParamDeviceIp(null);
           o.setParamHttpPort(null);
           o.setParamDevicePort(null);
           o.setParamRtspPort(null);
           o.setParamDeviceUsername(null);
           o.setParamDevicePassword(null);
           o.setParamChanelNum(null);
           o.setParamYsyUrl(null);
           o.setParamYsyUrlHd(null);
           o.setParamStreamType(null);
           o.setOfficeCode(null);
           o.setOfficeName(null);
           o.setCompanyCode(null);
           o.setCompanyName(null);
           o.setRemarks(null);
           o.setReviewStatus(null);
           o.setReviewer(null);
           o.setReviewDate(null);
           o.setReviewContent(null);
           o.setIsopen(null);
           o.setKingViewUrl(null);
           o.setIsMobile(null);
           o.setCorpCode(null);
           o.setCorpName(null);
           o.setServiceDate(null);
           o.setSyncStatus(null);
           o.setIsbeta(null);
           o.setOldId(null);
           o.setIotProductKey(null);
           o.setIotDeviceName(null);
           o.setIotProductName(null);
           o.setIotIotId(null);
           o.setIsAlarm(null);
           o.setOnline(null);
           o.setDeviceModelId(null);
           o.setDeviceClassify(null);
           o.setManufacturer(null);
           o.setDeviceModelName(null);
           o.setInduFacilityInfoId(null);
           o.setDevicesSource(null);
           o.setAreaId(null);
           o.setRuralId(null);
           o.setVillagesAreaId(null);
           o.setAreaName(null);
           o.setRuralName(null);
           o.setVillagesAreaName(null);
           o.setCameraType(null);
           o.setCameraId(null);
           o.setAccount(null);
           o.setPassWord(null);
           o.setPersonnelInfoId(null);
           o.setDevicesTag(null);
           o.setDevicesOnline(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       infoMapper.insert(dbInfo);
       // 测试 baseId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBaseId(null)));
       // 测试 tunnelId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setTunnelId(null)));
       // 测试 facilitysId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setFacilitysId(null)));
       // 测试 deviceName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setDeviceName(null)));
       // 测试 deviceSn 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setDeviceSn(null)));
       // 测试 classify 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setClassify(null)));
       // 测试 deviceType 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setDeviceType(null)));
       // 测试 deviceTypeName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setDeviceTypeName(null)));
       // 测试 buyer 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBuyer(null)));
       // 测试 buyTime 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBuyTime(null)));
       // 测试 productBy 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setProductBy(null)));
       // 测试 productModel 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setProductModel(null)));
       // 测试 power 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPower(null)));
       // 测试 workStatus 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setWorkStatus(null)));
       // 测试 longitude 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setLongitude(null)));
       // 测试 latitude 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setLatitude(null)));
       // 测试 paramDeviceIp 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setParamDeviceIp(null)));
       // 测试 paramHttpPort 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setParamHttpPort(null)));
       // 测试 paramDevicePort 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setParamDevicePort(null)));
       // 测试 paramRtspPort 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setParamRtspPort(null)));
       // 测试 paramDeviceUsername 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setParamDeviceUsername(null)));
       // 测试 paramDevicePassword 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setParamDevicePassword(null)));
       // 测试 paramChanelNum 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setParamChanelNum(null)));
       // 测试 paramYsyUrl 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setParamYsyUrl(null)));
       // 测试 paramYsyUrlHd 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setParamYsyUrlHd(null)));
       // 测试 paramStreamType 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setParamStreamType(null)));
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
       // 测试 isopen 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setIsopen(null)));
       // 测试 kingViewUrl 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setKingViewUrl(null)));
       // 测试 isMobile 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setIsMobile(null)));
       // 测试 corpCode 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCorpName(null)));
       // 测试 serviceDate 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setServiceDate(null)));
       // 测试 syncStatus 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSyncStatus(null)));
       // 测试 isbeta 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setIsbeta(null)));
       // 测试 oldId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setOldId(null)));
       // 测试 iotProductKey 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setIotProductKey(null)));
       // 测试 iotDeviceName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setIotDeviceName(null)));
       // 测试 iotProductName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setIotProductName(null)));
       // 测试 iotIotId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setIotIotId(null)));
       // 测试 isAlarm 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setIsAlarm(null)));
       // 测试 online 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setOnline(null)));
       // 测试 deviceModelId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setDeviceModelId(null)));
       // 测试 deviceClassify 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setDeviceClassify(null)));
       // 测试 manufacturer 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setManufacturer(null)));
       // 测试 deviceModelName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setDeviceModelName(null)));
       // 测试 induFacilityInfoId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setInduFacilityInfoId(null)));
       // 测试 devicesSource 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setDevicesSource(null)));
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
       // 测试 cameraType 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCameraType(null)));
       // 测试 cameraId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCameraId(null)));
       // 测试 account 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAccount(null)));
       // 测试 passWord 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPassWord(null)));
       // 测试 personnelInfoId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPersonnelInfoId(null)));
       // 测试 devicesTag 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setDevicesTag(null)));
       // 测试 devicesOnline 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setDevicesOnline(null)));
       // 测试 createTime 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSubjectId(null)));
       // 准备参数
       InfoPageReqVO reqVO = new InfoPageReqVO();
       reqVO.setBaseId(null);
       reqVO.setTunnelId(null);
       reqVO.setFacilitysId(null);
       reqVO.setDeviceName(null);
       reqVO.setDeviceSn(null);
       reqVO.setClassify(null);
       reqVO.setDeviceType(null);
       reqVO.setDeviceTypeName(null);
       reqVO.setBuyer(null);
       reqVO.setBuyTime((new LocalDateTime[]{}));
       reqVO.setProductBy(null);
       reqVO.setProductModel(null);
       reqVO.setPower(null);
       reqVO.setWorkStatus(null);
       reqVO.setLongitude(null);
       reqVO.setLatitude(null);
       reqVO.setParamDeviceIp(null);
       reqVO.setParamHttpPort(null);
       reqVO.setParamDevicePort(null);
       reqVO.setParamRtspPort(null);
       reqVO.setParamDeviceUsername(null);
       reqVO.setParamDevicePassword(null);
       reqVO.setParamChanelNum(null);
       reqVO.setParamYsyUrl(null);
       reqVO.setParamYsyUrlHd(null);
       reqVO.setParamStreamType(null);
       reqVO.setOfficeCode(null);
       reqVO.setOfficeName(null);
       reqVO.setCompanyCode(null);
       reqVO.setCompanyName(null);
       reqVO.setRemarks(null);
       reqVO.setReviewStatus(null);
       reqVO.setReviewer(null);
       reqVO.setReviewDate((new LocalDateTime[]{}));
       reqVO.setReviewContent(null);
       reqVO.setIsopen(null);
       reqVO.setKingViewUrl(null);
       reqVO.setIsMobile(null);
       reqVO.setCorpCode(null);
       reqVO.setCorpName(null);
       reqVO.setServiceDate((new LocalDateTime[]{}));
       reqVO.setSyncStatus(null);
       reqVO.setIsbeta(null);
       reqVO.setOldId(null);
       reqVO.setIotProductKey(null);
       reqVO.setIotDeviceName(null);
       reqVO.setIotProductName(null);
       reqVO.setIotIotId(null);
       reqVO.setIsAlarm(null);
       reqVO.setOnline(null);
       reqVO.setDeviceModelId(null);
       reqVO.setDeviceClassify(null);
       reqVO.setManufacturer(null);
       reqVO.setDeviceModelName(null);
       reqVO.setInduFacilityInfoId(null);
       reqVO.setDevicesSource(null);
       reqVO.setAreaId(null);
       reqVO.setRuralId(null);
       reqVO.setVillagesAreaId(null);
       reqVO.setAreaName(null);
       reqVO.setRuralName(null);
       reqVO.setVillagesAreaName(null);
       reqVO.setCameraType(null);
       reqVO.setCameraId(null);
       reqVO.setAccount(null);
       reqVO.setPassWord(null);
       reqVO.setPersonnelInfoId(null);
       reqVO.setDevicesTag(null);
       reqVO.setDevicesOnline(null);
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
           o.setTunnelId(null);
           o.setFacilitysId(null);
           o.setDeviceName(null);
           o.setDeviceSn(null);
           o.setClassify(null);
           o.setDeviceType(null);
           o.setDeviceTypeName(null);
           o.setBuyer(null);
           o.setBuyTime(null);
           o.setProductBy(null);
           o.setProductModel(null);
           o.setPower(null);
           o.setWorkStatus(null);
           o.setLongitude(null);
           o.setLatitude(null);
           o.setParamDeviceIp(null);
           o.setParamHttpPort(null);
           o.setParamDevicePort(null);
           o.setParamRtspPort(null);
           o.setParamDeviceUsername(null);
           o.setParamDevicePassword(null);
           o.setParamChanelNum(null);
           o.setParamYsyUrl(null);
           o.setParamYsyUrlHd(null);
           o.setParamStreamType(null);
           o.setOfficeCode(null);
           o.setOfficeName(null);
           o.setCompanyCode(null);
           o.setCompanyName(null);
           o.setRemarks(null);
           o.setReviewStatus(null);
           o.setReviewer(null);
           o.setReviewDate(null);
           o.setReviewContent(null);
           o.setIsopen(null);
           o.setKingViewUrl(null);
           o.setIsMobile(null);
           o.setCorpCode(null);
           o.setCorpName(null);
           o.setServiceDate(null);
           o.setSyncStatus(null);
           o.setIsbeta(null);
           o.setOldId(null);
           o.setIotProductKey(null);
           o.setIotDeviceName(null);
           o.setIotProductName(null);
           o.setIotIotId(null);
           o.setIsAlarm(null);
           o.setOnline(null);
           o.setDeviceModelId(null);
           o.setDeviceClassify(null);
           o.setManufacturer(null);
           o.setDeviceModelName(null);
           o.setInduFacilityInfoId(null);
           o.setDevicesSource(null);
           o.setAreaId(null);
           o.setRuralId(null);
           o.setVillagesAreaId(null);
           o.setAreaName(null);
           o.setRuralName(null);
           o.setVillagesAreaName(null);
           o.setCameraType(null);
           o.setCameraId(null);
           o.setAccount(null);
           o.setPassWord(null);
           o.setPersonnelInfoId(null);
           o.setDevicesTag(null);
           o.setDevicesOnline(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       infoMapper.insert(dbInfo);
       // 测试 baseId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBaseId(null)));
       // 测试 tunnelId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setTunnelId(null)));
       // 测试 facilitysId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setFacilitysId(null)));
       // 测试 deviceName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setDeviceName(null)));
       // 测试 deviceSn 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setDeviceSn(null)));
       // 测试 classify 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setClassify(null)));
       // 测试 deviceType 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setDeviceType(null)));
       // 测试 deviceTypeName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setDeviceTypeName(null)));
       // 测试 buyer 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBuyer(null)));
       // 测试 buyTime 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBuyTime(null)));
       // 测试 productBy 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setProductBy(null)));
       // 测试 productModel 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setProductModel(null)));
       // 测试 power 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPower(null)));
       // 测试 workStatus 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setWorkStatus(null)));
       // 测试 longitude 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setLongitude(null)));
       // 测试 latitude 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setLatitude(null)));
       // 测试 paramDeviceIp 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setParamDeviceIp(null)));
       // 测试 paramHttpPort 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setParamHttpPort(null)));
       // 测试 paramDevicePort 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setParamDevicePort(null)));
       // 测试 paramRtspPort 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setParamRtspPort(null)));
       // 测试 paramDeviceUsername 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setParamDeviceUsername(null)));
       // 测试 paramDevicePassword 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setParamDevicePassword(null)));
       // 测试 paramChanelNum 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setParamChanelNum(null)));
       // 测试 paramYsyUrl 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setParamYsyUrl(null)));
       // 测试 paramYsyUrlHd 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setParamYsyUrlHd(null)));
       // 测试 paramStreamType 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setParamStreamType(null)));
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
       // 测试 isopen 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setIsopen(null)));
       // 测试 kingViewUrl 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setKingViewUrl(null)));
       // 测试 isMobile 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setIsMobile(null)));
       // 测试 corpCode 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCorpName(null)));
       // 测试 serviceDate 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setServiceDate(null)));
       // 测试 syncStatus 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSyncStatus(null)));
       // 测试 isbeta 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setIsbeta(null)));
       // 测试 oldId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setOldId(null)));
       // 测试 iotProductKey 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setIotProductKey(null)));
       // 测试 iotDeviceName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setIotDeviceName(null)));
       // 测试 iotProductName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setIotProductName(null)));
       // 测试 iotIotId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setIotIotId(null)));
       // 测试 isAlarm 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setIsAlarm(null)));
       // 测试 online 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setOnline(null)));
       // 测试 deviceModelId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setDeviceModelId(null)));
       // 测试 deviceClassify 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setDeviceClassify(null)));
       // 测试 manufacturer 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setManufacturer(null)));
       // 测试 deviceModelName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setDeviceModelName(null)));
       // 测试 induFacilityInfoId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setInduFacilityInfoId(null)));
       // 测试 devicesSource 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setDevicesSource(null)));
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
       // 测试 cameraType 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCameraType(null)));
       // 测试 cameraId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCameraId(null)));
       // 测试 account 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAccount(null)));
       // 测试 passWord 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPassWord(null)));
       // 测试 personnelInfoId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPersonnelInfoId(null)));
       // 测试 devicesTag 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setDevicesTag(null)));
       // 测试 devicesOnline 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setDevicesOnline(null)));
       // 测试 createTime 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSubjectId(null)));
       // 准备参数
       InfoExportReqVO reqVO = new InfoExportReqVO();
       reqVO.setBaseId(null);
       reqVO.setTunnelId(null);
       reqVO.setFacilitysId(null);
       reqVO.setDeviceName(null);
       reqVO.setDeviceSn(null);
       reqVO.setClassify(null);
       reqVO.setDeviceType(null);
       reqVO.setDeviceTypeName(null);
       reqVO.setBuyer(null);
       reqVO.setBuyTime((new LocalDateTime[]{}));
       reqVO.setProductBy(null);
       reqVO.setProductModel(null);
       reqVO.setPower(null);
       reqVO.setWorkStatus(null);
       reqVO.setLongitude(null);
       reqVO.setLatitude(null);
       reqVO.setParamDeviceIp(null);
       reqVO.setParamHttpPort(null);
       reqVO.setParamDevicePort(null);
       reqVO.setParamRtspPort(null);
       reqVO.setParamDeviceUsername(null);
       reqVO.setParamDevicePassword(null);
       reqVO.setParamChanelNum(null);
       reqVO.setParamYsyUrl(null);
       reqVO.setParamYsyUrlHd(null);
       reqVO.setParamStreamType(null);
       reqVO.setOfficeCode(null);
       reqVO.setOfficeName(null);
       reqVO.setCompanyCode(null);
       reqVO.setCompanyName(null);
       reqVO.setRemarks(null);
       reqVO.setReviewStatus(null);
       reqVO.setReviewer(null);
       reqVO.setReviewDate((new LocalDateTime[]{}));
       reqVO.setReviewContent(null);
       reqVO.setIsopen(null);
       reqVO.setKingViewUrl(null);
       reqVO.setIsMobile(null);
       reqVO.setCorpCode(null);
       reqVO.setCorpName(null);
       reqVO.setServiceDate((new LocalDateTime[]{}));
       reqVO.setSyncStatus(null);
       reqVO.setIsbeta(null);
       reqVO.setOldId(null);
       reqVO.setIotProductKey(null);
       reqVO.setIotDeviceName(null);
       reqVO.setIotProductName(null);
       reqVO.setIotIotId(null);
       reqVO.setIsAlarm(null);
       reqVO.setOnline(null);
       reqVO.setDeviceModelId(null);
       reqVO.setDeviceClassify(null);
       reqVO.setManufacturer(null);
       reqVO.setDeviceModelName(null);
       reqVO.setInduFacilityInfoId(null);
       reqVO.setDevicesSource(null);
       reqVO.setAreaId(null);
       reqVO.setRuralId(null);
       reqVO.setVillagesAreaId(null);
       reqVO.setAreaName(null);
       reqVO.setRuralName(null);
       reqVO.setVillagesAreaName(null);
       reqVO.setCameraType(null);
       reqVO.setCameraId(null);
       reqVO.setAccount(null);
       reqVO.setPassWord(null);
       reqVO.setPersonnelInfoId(null);
       reqVO.setDevicesTag(null);
       reqVO.setDevicesOnline(null);
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
