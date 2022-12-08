package cn.acsm.module.transaction.order.service.deliveryinfo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.transaction.order.controller.admin.deliveryinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.deliveryinfo.DeliveryInfoDO;
import cn.acsm.module.transaction.order.dal.mysql.deliveryinfo.DeliveryInfoMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.acsm.module.transaction.order.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link DeliveryInfoServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(DeliveryInfoServiceImpl.class)
public class DeliveryInfoServiceImplTest extends BaseDbUnitTest {

    @Resource
    private DeliveryInfoServiceImpl deliveryInfoService;

    @Resource
    private DeliveryInfoMapper deliveryInfoMapper;

    @Test
    public void testCreateDeliveryInfo_success() {
        // 准备参数
        DeliveryInfoCreateReqVO reqVO = randomPojo(DeliveryInfoCreateReqVO.class);

        // 调用
        String deliveryInfoId = deliveryInfoService.createDeliveryInfo(reqVO);
        // 断言
        assertNotNull(deliveryInfoId);
        // 校验记录的属性是否正确
        DeliveryInfoDO deliveryInfo = deliveryInfoMapper.selectById(deliveryInfoId);
        assertPojoEquals(reqVO, deliveryInfo);
    }

    @Test
    public void testUpdateDeliveryInfo_success() {
        // mock 数据
        DeliveryInfoDO dbDeliveryInfo = randomPojo(DeliveryInfoDO.class);
        deliveryInfoMapper.insert(dbDeliveryInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        DeliveryInfoUpdateReqVO reqVO = randomPojo(DeliveryInfoUpdateReqVO.class, o -> {
            o.setId(dbDeliveryInfo.getId()); // 设置更新的 ID
        });

        // 调用
        deliveryInfoService.updateDeliveryInfo(reqVO);
        // 校验是否更新正确
        DeliveryInfoDO deliveryInfo = deliveryInfoMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, deliveryInfo);
    }

    @Test
    public void testUpdateDeliveryInfo_notExists() {
        // 准备参数
        DeliveryInfoUpdateReqVO reqVO = randomPojo(DeliveryInfoUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> deliveryInfoService.updateDeliveryInfo(reqVO), DELIVERY_INFO_NOT_EXISTS);
    }

    @Test
    public void testDeleteDeliveryInfo_success() {
        // mock 数据
        DeliveryInfoDO dbDeliveryInfo = randomPojo(DeliveryInfoDO.class);
        deliveryInfoMapper.insert(dbDeliveryInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbDeliveryInfo.getId();

        // 调用
        deliveryInfoService.deleteDeliveryInfo(id);
       // 校验数据不存在了
       assertNull(deliveryInfoMapper.selectById(id));
    }

    @Test
    public void testDeleteDeliveryInfo_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> deliveryInfoService.deleteDeliveryInfo(id), DELIVERY_INFO_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetDeliveryInfoPage() {
       // mock 数据
       DeliveryInfoDO dbDeliveryInfo = randomPojo(DeliveryInfoDO.class, o -> { // 等会查询到
           o.setCreateTime(null);
       });
       deliveryInfoMapper.insert(dbDeliveryInfo);
       // 测试 createTime 不匹配
       deliveryInfoMapper.insert(cloneIgnoreId(dbDeliveryInfo, o -> o.setCreateTime(null)));
       // 准备参数
       DeliveryInfoPageReqVO reqVO = new DeliveryInfoPageReqVO();
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<DeliveryInfoDO> pageResult = deliveryInfoService.getDeliveryInfoPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbDeliveryInfo, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetDeliveryInfoList() {
       // mock 数据
       DeliveryInfoDO dbDeliveryInfo = randomPojo(DeliveryInfoDO.class, o -> { // 等会查询到
           o.setCreateTime(null);
       });
       deliveryInfoMapper.insert(dbDeliveryInfo);
       // 测试 createTime 不匹配
       deliveryInfoMapper.insert(cloneIgnoreId(dbDeliveryInfo, o -> o.setCreateTime(null)));
       // 准备参数
       DeliveryInfoExportReqVO reqVO = new DeliveryInfoExportReqVO();
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<DeliveryInfoDO> list = deliveryInfoService.getDeliveryInfoList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbDeliveryInfo, list.get(0));
    }

}
