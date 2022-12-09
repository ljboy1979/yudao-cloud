package cn.acsm.module.service.service.serviceadoptinfo;

import cn.acsm.module.service.controller.admin.serviceadoptinfo.vo.ServiceAdoptInfoCreateReqVO;
import cn.acsm.module.service.controller.admin.serviceadoptinfo.vo.ServiceAdoptInfoExportReqVO;
import cn.acsm.module.service.controller.admin.serviceadoptinfo.vo.ServiceAdoptInfoPageReqVO;
import cn.acsm.module.service.controller.admin.serviceadoptinfo.vo.ServiceAdoptInfoUpdateReqVO;
import cn.acsm.module.service.dal.dataobject.serviceadoptinfo.ServiceAdoptInfoDO;
import cn.acsm.module.service.dal.mysql.serviceadoptinfo.ServiceAdoptInfoMapper;
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

import static cn.acsm.module.service.enums.ErrorCodeConstants.ADOPT_INFO_NOT_EXISTS;
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
* {@link ServiceAdoptInfoServiceImpl} 的单元测试类
*
* @author smile
*/
@Import(ServiceAdoptInfoServiceImpl.class)
public class ServiceAdoptInfoServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ServiceAdoptInfoServiceImpl adoptInfoService;

    @Resource
    private ServiceAdoptInfoMapper adoptInfoMapper;

    @Test
    public void testCreateAdoptInfo_success() {
        // 准备参数
        ServiceAdoptInfoCreateReqVO reqVO = randomPojo(ServiceAdoptInfoCreateReqVO.class);

        // 调用
        Long adoptInfoId = adoptInfoService.createAdoptInfo(reqVO);
        // 断言
        assertNotNull(adoptInfoId);
        // 校验记录的属性是否正确
        ServiceAdoptInfoDO adoptInfo = adoptInfoMapper.selectById(adoptInfoId);
        assertPojoEquals(reqVO, adoptInfo);
    }

    @Test
    public void testUpdateAdoptInfo_success() {
        // mock 数据
        ServiceAdoptInfoDO dbAdoptInfo = randomPojo(ServiceAdoptInfoDO.class);
        adoptInfoMapper.insert(dbAdoptInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ServiceAdoptInfoUpdateReqVO reqVO = randomPojo(ServiceAdoptInfoUpdateReqVO.class, o -> {
            o.setId(dbAdoptInfo.getId()); // 设置更新的 ID
        });

        // 调用
        adoptInfoService.updateAdoptInfo(reqVO);
        // 校验是否更新正确
        ServiceAdoptInfoDO adoptInfo = adoptInfoMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, adoptInfo);
    }

    @Test
    public void testUpdateAdoptInfo_notExists() {
        // 准备参数
        ServiceAdoptInfoUpdateReqVO reqVO = randomPojo(ServiceAdoptInfoUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> adoptInfoService.updateAdoptInfo(reqVO), ADOPT_INFO_NOT_EXISTS);
    }

    @Test
    public void testDeleteAdoptInfo_success() {
        // mock 数据
        ServiceAdoptInfoDO dbAdoptInfo = randomPojo(ServiceAdoptInfoDO.class);
        adoptInfoMapper.insert(dbAdoptInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbAdoptInfo.getId();

        // 调用
        adoptInfoService.deleteAdoptInfo(id);
       // 校验数据不存在了
       assertNull(adoptInfoMapper.selectById(id));
    }

    @Test
    public void testDeleteAdoptInfo_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> adoptInfoService.deleteAdoptInfo(id), ADOPT_INFO_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAdoptInfoPage() {
       // mock 数据
       ServiceAdoptInfoDO dbAdoptInfo = randomPojo(ServiceAdoptInfoDO.class, o -> { // 等会查询到
           o.setServiceId(null);
           o.setTunnelId(null);
           o.setAdoptId(null);
           o.setUserId(null);
           o.setAdoptStatus(null);
           o.setFamilyId(null);
           o.setPlantCropId(null);
           o.setPlantCropNum(null);
           o.setBasesId(null);
           o.setPartitionsId(null);
           o.setCarrierId(null);
           o.setApplyNum(null);
           o.setApplySubNum(null);
           o.setAdoptType(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
       });
       adoptInfoMapper.insert(dbAdoptInfo);
       // 测试 serviceId 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setServiceId(null)));
       // 测试 tunnelId 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setTunnelId(null)));
       // 测试 adoptId 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setAdoptId(null)));
       // 测试 userId 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setUserId(null)));
       // 测试 adoptStatus 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setAdoptStatus(null)));
       // 测试 familyId 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setFamilyId(null)));
       // 测试 plantCropId 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setPlantCropId(null)));
       // 测试 plantCropNum 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setPlantCropNum(null)));
       // 测试 basesId 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setBasesId(null)));
       // 测试 partitionsId 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setPartitionsId(null)));
       // 测试 carrierId 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setCarrierId(null)));
       // 测试 applyNum 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setApplyNum(null)));
       // 测试 applySubNum 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setApplySubNum(null)));
       // 测试 adoptType 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setAdoptType(null)));
       // 测试 status 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setSource(null)));
       // 准备参数
       ServiceAdoptInfoPageReqVO reqVO = new ServiceAdoptInfoPageReqVO();
       reqVO.setServiceId(null);
       reqVO.setTunnelId(null);
       reqVO.setAdoptId(null);
       reqVO.setUserId(null);
       reqVO.setAdoptStatus(null);
       reqVO.setFamilyId(null);
       reqVO.setPlantCropId(null);
       reqVO.setPlantCropNum(null);
       reqVO.setBasesId(null);
       reqVO.setPartitionsId(null);
       reqVO.setCarrierId(null);
       reqVO.setApplyNum(null);
       reqVO.setApplySubNum(null);
       reqVO.setAdoptType(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);

       // 调用
       PageResult<ServiceAdoptInfoDO> pageResult = adoptInfoService.getAdoptInfoPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbAdoptInfo, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAdoptInfoList() {
       // mock 数据
       ServiceAdoptInfoDO dbAdoptInfo = randomPojo(ServiceAdoptInfoDO.class, o -> { // 等会查询到
           o.setServiceId(null);
           o.setTunnelId(null);
           o.setAdoptId(null);
           o.setUserId(null);
           o.setAdoptStatus(null);
           o.setFamilyId(null);
           o.setPlantCropId(null);
           o.setPlantCropNum(null);
           o.setBasesId(null);
           o.setPartitionsId(null);
           o.setCarrierId(null);
           o.setApplyNum(null);
           o.setApplySubNum(null);
           o.setAdoptType(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
       });
       adoptInfoMapper.insert(dbAdoptInfo);
       // 测试 serviceId 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setServiceId(null)));
       // 测试 tunnelId 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setTunnelId(null)));
       // 测试 adoptId 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setAdoptId(null)));
       // 测试 userId 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setUserId(null)));
       // 测试 adoptStatus 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setAdoptStatus(null)));
       // 测试 familyId 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setFamilyId(null)));
       // 测试 plantCropId 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setPlantCropId(null)));
       // 测试 plantCropNum 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setPlantCropNum(null)));
       // 测试 basesId 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setBasesId(null)));
       // 测试 partitionsId 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setPartitionsId(null)));
       // 测试 carrierId 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setCarrierId(null)));
       // 测试 applyNum 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setApplyNum(null)));
       // 测试 applySubNum 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setApplySubNum(null)));
       // 测试 adoptType 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setAdoptType(null)));
       // 测试 status 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       adoptInfoMapper.insert(cloneIgnoreId(dbAdoptInfo, o -> o.setSource(null)));
       // 准备参数
       ServiceAdoptInfoExportReqVO reqVO = new ServiceAdoptInfoExportReqVO();
       reqVO.setServiceId(null);
       reqVO.setTunnelId(null);
       reqVO.setAdoptId(null);
       reqVO.setUserId(null);
       reqVO.setAdoptStatus(null);
       reqVO.setFamilyId(null);
       reqVO.setPlantCropId(null);
       reqVO.setPlantCropNum(null);
       reqVO.setBasesId(null);
       reqVO.setPartitionsId(null);
       reqVO.setCarrierId(null);
       reqVO.setApplyNum(null);
       reqVO.setApplySubNum(null);
       reqVO.setAdoptType(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);

       // 调用
       List<ServiceAdoptInfoDO> list = adoptInfoService.getAdoptInfoList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbAdoptInfo, list.get(0));
    }

}
