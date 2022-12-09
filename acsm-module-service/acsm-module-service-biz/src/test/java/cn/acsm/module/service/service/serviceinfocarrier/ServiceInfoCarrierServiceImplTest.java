package cn.acsm.module.service.service.serviceinfocarrier;

import cn.acsm.module.service.controller.admin.serviceinfocarrier.vo.*;
import cn.acsm.module.service.dal.dataobject.serviceinfocarrier.ServiceInfoCarrierDO;
import cn.acsm.module.service.dal.mysql.serviceinfocarrier.ServiceInfoCarrierMapper;
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

import static cn.acsm.module.service.enums.ErrorCodeConstants.INFO_CARRIER_NOT_EXISTS;
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
* {@link ServiceInfoCarrierServiceImpl} 的单元测试类
*
* @author smile
*/
@Import(ServiceInfoCarrierServiceImpl.class)
public class ServiceInfoCarrierServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ServiceInfoCarrierServiceImpl infoCarrierService;

    @Resource
    private ServiceInfoCarrierMapper infoCarrierMapper;

    @Test
    public void testCreateInfoCarrier_success() {
        // 准备参数
        ServiceInfoCarrierCreateReqVO reqVO = randomPojo(ServiceInfoCarrierCreateReqVO.class);

        // 调用
        Long infoCarrierId = infoCarrierService.createInfoCarrier(reqVO);
        // 断言
        assertNotNull(infoCarrierId);
        // 校验记录的属性是否正确
        ServiceInfoCarrierDO infoCarrier = infoCarrierMapper.selectById(infoCarrierId);
        assertPojoEquals(reqVO, infoCarrier);
    }

    @Test
    public void testUpdateInfoCarrier_success() {
        // mock 数据
        ServiceInfoCarrierDO dbInfoCarrier = randomPojo(ServiceInfoCarrierDO.class);
        infoCarrierMapper.insert(dbInfoCarrier);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ServiceInfoCarrierUpdateReqVO reqVO = randomPojo(ServiceInfoCarrierUpdateReqVO.class, o -> {
            o.setId(dbInfoCarrier.getId()); // 设置更新的 ID
        });

        // 调用
        infoCarrierService.updateInfoCarrier(reqVO);
        // 校验是否更新正确
        ServiceInfoCarrierDO infoCarrier = infoCarrierMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, infoCarrier);
    }

    @Test
    public void testUpdateInfoCarrier_notExists() {
        // 准备参数
        ServiceInfoCarrierUpdateReqVO reqVO = randomPojo(ServiceInfoCarrierUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> infoCarrierService.updateInfoCarrier(reqVO), INFO_CARRIER_NOT_EXISTS);
    }

    @Test
    public void testDeleteInfoCarrier_success() {
        // mock 数据
        ServiceInfoCarrierDO dbInfoCarrier = randomPojo(ServiceInfoCarrierDO.class);
        infoCarrierMapper.insert(dbInfoCarrier);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbInfoCarrier.getId();

        // 调用
        infoCarrierService.deleteInfoCarrier(id);
       // 校验数据不存在了
       assertNull(infoCarrierMapper.selectById(id));
    }

    @Test
    public void testDeleteInfoCarrier_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> infoCarrierService.deleteInfoCarrier(id), INFO_CARRIER_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInfoCarrierPage() {
       // mock 数据
       ServiceInfoCarrierDO dbInfoCarrier = randomPojo(ServiceInfoCarrierDO.class, o -> { // 等会查询到
           o.setAdoptContentAdoptId(null);
           o.setServiceInfoId(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
       });
       infoCarrierMapper.insert(dbInfoCarrier);
       // 测试 adoptContentAdoptId 不匹配
       infoCarrierMapper.insert(cloneIgnoreId(dbInfoCarrier, o -> o.setAdoptContentAdoptId(null)));
       // 测试 serviceInfoId 不匹配
       infoCarrierMapper.insert(cloneIgnoreId(dbInfoCarrier, o -> o.setServiceInfoId(null)));
       // 测试 status 不匹配
       infoCarrierMapper.insert(cloneIgnoreId(dbInfoCarrier, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       infoCarrierMapper.insert(cloneIgnoreId(dbInfoCarrier, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       infoCarrierMapper.insert(cloneIgnoreId(dbInfoCarrier, o -> o.setSource(null)));
       // 准备参数
       ServiceInfoCarrierPageReqVO reqVO = new ServiceInfoCarrierPageReqVO();
       reqVO.setAdoptContentAdoptId(null);
       reqVO.setServiceInfoId(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);

       // 调用
       PageResult<ServiceInfoCarrierRespVO> pageResult = infoCarrierService.getInfoCarrierPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbInfoCarrier, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInfoCarrierList() {
       // mock 数据
       ServiceInfoCarrierDO dbInfoCarrier = randomPojo(ServiceInfoCarrierDO.class, o -> { // 等会查询到
           o.setAdoptContentAdoptId(null);
           o.setServiceInfoId(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
       });
       infoCarrierMapper.insert(dbInfoCarrier);
       // 测试 adoptContentAdoptId 不匹配
       infoCarrierMapper.insert(cloneIgnoreId(dbInfoCarrier, o -> o.setAdoptContentAdoptId(null)));
       // 测试 serviceInfoId 不匹配
       infoCarrierMapper.insert(cloneIgnoreId(dbInfoCarrier, o -> o.setServiceInfoId(null)));
       // 测试 status 不匹配
       infoCarrierMapper.insert(cloneIgnoreId(dbInfoCarrier, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       infoCarrierMapper.insert(cloneIgnoreId(dbInfoCarrier, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       infoCarrierMapper.insert(cloneIgnoreId(dbInfoCarrier, o -> o.setSource(null)));
       // 准备参数
       ServiceInfoCarrierExportReqVO reqVO = new ServiceInfoCarrierExportReqVO();
       reqVO.setAdoptContentAdoptId(null);
       reqVO.setServiceInfoId(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);

       // 调用
       List<ServiceInfoCarrierDO> list = infoCarrierService.getInfoCarrierList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbInfoCarrier, list.get(0));
    }

}
