package cn.acsm.module.service.service.serviceinfo;

import cn.acsm.module.service.controller.admin.serviceinfo.vo.*;
import cn.acsm.module.service.dal.dataobject.serviceinfo.ServiceInfoDO;
import cn.acsm.module.service.dal.mysql.serviceinfo.ServiceInfoMapper;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.acsm.module.service.enums.ErrorCodeConstants.INFO_NOT_EXISTS;
import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link ServiceInfoServiceImpl} 的单元测试类
*
* @author smile
*/
@Import(ServiceInfoServiceImpl.class)
public class ServiceInfoServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ServiceInfoServiceImpl infoService;

    @Resource
    private ServiceInfoMapper infoMapper;

    @Test
    public void testCreateInfo_success() {
        // 准备参数
        ServiceInfoCreateReqVO reqVO = randomPojo(ServiceInfoCreateReqVO.class);

        // 调用
        Long infoId = infoService.createInfo(reqVO);
        // 断言
        assertNotNull(infoId);
        // 校验记录的属性是否正确
        ServiceInfoDO info = infoMapper.selectById(infoId);
        assertPojoEquals(reqVO, info);
    }

    @Test
    public void testUpdateInfo_success() {
        // mock 数据
        ServiceInfoDO dbInfo = randomPojo(ServiceInfoDO.class);
        infoMapper.insert(dbInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ServiceInfoUpdateReqVO reqVO = randomPojo(ServiceInfoUpdateReqVO.class, o -> {
            o.setId(dbInfo.getId()); // 设置更新的 ID
        });

        // 调用
        infoService.updateInfo(reqVO);
        // 校验是否更新正确
        ServiceInfoDO info = infoMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, info);
    }

    @Test
    public void testUpdateInfo_notExists() {
        // 准备参数
        ServiceInfoUpdateReqVO reqVO = randomPojo(ServiceInfoUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> infoService.updateInfo(reqVO), INFO_NOT_EXISTS);
    }

    @Test
    public void testDeleteInfo_success() {
        // mock 数据
        ServiceInfoDO dbInfo = randomPojo(ServiceInfoDO.class);
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
       ServiceInfoDO dbInfo = randomPojo(ServiceInfoDO.class, o -> { // 等会查询到
           o.setServiceCode(null);
           o.setServiceName(null);
           o.setServiceType(null);
           o.setServiceProvider(null);
           o.setContent(null);
           o.setServicePayer(null);
           o.setStartTime(null);
           o.setEndTime(null);
           o.setState(null);
           o.setInduFacilityInfoId(null);
           o.setRemarks(null);
           o.setTunnelInfoId(null);
           o.setDevicesId(null);
           o.setInduSubjectInfoId(null);
           o.setCarrierId(null);
           o.setChildrenTableName(null);
           o.setServiceFee(null);
           o.setCategoryId(null);
           o.setAvailableTime(null);
           o.setFarmType(null);
           o.setIntroduce(null);
           o.setAddress(null);
           o.setRotationImgs(null);
           o.setDetailsImgs(null);
           o.setMaxAttendPeople(null);
           o.setAttendPeople(null);
           o.setBasesId(null);
           o.setBasesName(null);
           o.setPlantNum(null);
           o.setPlantCropIds(null);
           o.setLabel(null);
           o.setCollectNum(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
       });
       infoMapper.insert(dbInfo);
       // 测试 serviceCode 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setServiceCode(null)));
       // 测试 serviceName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setServiceName(null)));
       // 测试 serviceType 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setServiceType(null)));
       // 测试 serviceProvider 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setServiceProvider(null)));
       // 测试 content 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setContent(null)));
       // 测试 servicePayer 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setServicePayer(null)));
       // 测试 startTime 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setStartTime(null)));
       // 测试 endTime 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setEndTime(null)));
       // 测试 state 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setState(null)));
       // 测试 induFacilityInfoId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setInduFacilityInfoId(null)));
       // 测试 remarks 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setRemarks(null)));
       // 测试 tunnelInfoId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setTunnelInfoId(null)));
       // 测试 devicesId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setDevicesId(null)));
       // 测试 induSubjectInfoId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setInduSubjectInfoId(null)));
       // 测试 carrierId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCarrierId(null)));
       // 测试 childrenTableName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setChildrenTableName(null)));
       // 测试 serviceFee 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setServiceFee(null)));
       // 测试 categoryId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCategoryId(null)));
       // 测试 availableTime 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAvailableTime(null)));
       // 测试 farmType 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setFarmType(null)));
       // 测试 introduce 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setIntroduce(null)));
       // 测试 address 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAddress(null)));
       // 测试 rotationImgs 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setRotationImgs(null)));
       // 测试 detailsImgs 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setDetailsImgs(null)));
       // 测试 maxAttendPeople 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setMaxAttendPeople(null)));
       // 测试 attendPeople 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAttendPeople(null)));
       // 测试 basesId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBasesId(null)));
       // 测试 basesName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBasesName(null)));
       // 测试 plantNum 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPlantNum(null)));
       // 测试 plantCropIds 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPlantCropIds(null)));
       // 测试 label 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setLabel(null)));
       // 测试 collectNum 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCollectNum(null)));
       // 测试 status 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSource(null)));
       // 准备参数
       ServiceInfoPageReqVO reqVO = new ServiceInfoPageReqVO();
       reqVO.setServiceCode(null);
       reqVO.setServiceName(null);
       reqVO.setServiceType(null);
       reqVO.setServiceProvider(null);
       reqVO.setContent(null);
       reqVO.setServicePayer(null);
       reqVO.setStartTime((new Date[]{}));
       reqVO.setEndTime((new Date[]{}));
       reqVO.setState(null);
       reqVO.setInduFacilityInfoId(null);
       reqVO.setRemarks(null);
       reqVO.setTunnelInfoId(null);
       reqVO.setDevicesId(null);
       reqVO.setInduSubjectInfoId(null);
       reqVO.setCarrierId(null);
       reqVO.setChildrenTableName(null);
       reqVO.setServiceFee(null);
       reqVO.setCategoryId(null);
       reqVO.setAvailableTime((new String[]{}));
       reqVO.setFarmType(null);
       reqVO.setIntroduce(null);
       reqVO.setAddress(null);
       reqVO.setRotationImgs(null);
       reqVO.setDetailsImgs(null);
       reqVO.setMaxAttendPeople(null);
       reqVO.setAttendPeople(null);
       reqVO.setBasesId(null);
       reqVO.setBasesName(null);
       reqVO.setPlantNum(null);
       reqVO.setPlantCropIds(null);
       reqVO.setLabel(null);
       reqVO.setCollectNum(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);

       // 调用
       PageResult<ServiceInfoRespVO> pageResult = infoService.getInfoPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbInfo, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInfoList() {
       // mock 数据
       ServiceInfoDO dbInfo = randomPojo(ServiceInfoDO.class, o -> { // 等会查询到
           o.setServiceCode(null);
           o.setServiceName(null);
           o.setServiceType(null);
           o.setServiceProvider(null);
           o.setContent(null);
           o.setServicePayer(null);
           o.setStartTime(null);
           o.setEndTime(null);
           o.setState(null);
           o.setInduFacilityInfoId(null);
           o.setRemarks(null);
           o.setTunnelInfoId(null);
           o.setDevicesId(null);
           o.setInduSubjectInfoId(null);
           o.setCarrierId(null);
           o.setChildrenTableName(null);
           o.setServiceFee(null);
           o.setCategoryId(null);
           o.setAvailableTime(null);
           o.setFarmType(null);
           o.setIntroduce(null);
           o.setAddress(null);
           o.setRotationImgs(null);
           o.setDetailsImgs(null);
           o.setMaxAttendPeople(null);
           o.setAttendPeople(null);
           o.setBasesId(null);
           o.setBasesName(null);
           o.setPlantNum(null);
           o.setPlantCropIds(null);
           o.setLabel(null);
           o.setCollectNum(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
       });
       infoMapper.insert(dbInfo);
       // 测试 serviceCode 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setServiceCode(null)));
       // 测试 serviceName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setServiceName(null)));
       // 测试 serviceType 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setServiceType(null)));
       // 测试 serviceProvider 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setServiceProvider(null)));
       // 测试 content 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setContent(null)));
       // 测试 servicePayer 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setServicePayer(null)));
       // 测试 startTime 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setStartTime(null)));
       // 测试 endTime 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setEndTime(null)));
       // 测试 state 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setState(null)));
       // 测试 induFacilityInfoId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setInduFacilityInfoId(null)));
       // 测试 remarks 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setRemarks(null)));
       // 测试 tunnelInfoId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setTunnelInfoId(null)));
       // 测试 devicesId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setDevicesId(null)));
       // 测试 induSubjectInfoId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setInduSubjectInfoId(null)));
       // 测试 carrierId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCarrierId(null)));
       // 测试 childrenTableName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setChildrenTableName(null)));
       // 测试 serviceFee 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setServiceFee(null)));
       // 测试 categoryId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCategoryId(null)));
       // 测试 availableTime 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAvailableTime(null)));
       // 测试 farmType 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setFarmType(null)));
       // 测试 introduce 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setIntroduce(null)));
       // 测试 address 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAddress(null)));
       // 测试 rotationImgs 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setRotationImgs(null)));
       // 测试 detailsImgs 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setDetailsImgs(null)));
       // 测试 maxAttendPeople 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setMaxAttendPeople(null)));
       // 测试 attendPeople 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setAttendPeople(null)));
       // 测试 basesId 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBasesId(null)));
       // 测试 basesName 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setBasesName(null)));
       // 测试 plantNum 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPlantNum(null)));
       // 测试 plantCropIds 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setPlantCropIds(null)));
       // 测试 label 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setLabel(null)));
       // 测试 collectNum 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCollectNum(null)));
       // 测试 status 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setSource(null)));
       // 准备参数
       ServiceInfoExportReqVO reqVO = new ServiceInfoExportReqVO();
       reqVO.setServiceCode(null);
       reqVO.setServiceName(null);
       reqVO.setServiceType(null);
       reqVO.setServiceProvider(null);
       reqVO.setContent(null);
       reqVO.setServicePayer(null);
       reqVO.setStartTime((new Date[]{}));
       reqVO.setEndTime((new Date[]{}));
       reqVO.setState(null);
       reqVO.setInduFacilityInfoId(null);
       reqVO.setRemarks(null);
       reqVO.setTunnelInfoId(null);
       reqVO.setDevicesId(null);
       reqVO.setInduSubjectInfoId(null);
       reqVO.setCarrierId(null);
       reqVO.setChildrenTableName(null);
       reqVO.setServiceFee(null);
       reqVO.setCategoryId(null);
       reqVO.setAvailableTime((new String[]{}));
       reqVO.setFarmType(null);
       reqVO.setIntroduce(null);
       reqVO.setAddress(null);
       reqVO.setRotationImgs(null);
       reqVO.setDetailsImgs(null);
       reqVO.setMaxAttendPeople(null);
       reqVO.setAttendPeople(null);
       reqVO.setBasesId(null);
       reqVO.setBasesName(null);
       reqVO.setPlantNum(null);
       reqVO.setPlantCropIds(null);
       reqVO.setLabel(null);
       reqVO.setCollectNum(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);

       // 调用
       List<ServiceInfoDO> list = infoService.getInfoList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbInfo, list.get(0));
    }

}
