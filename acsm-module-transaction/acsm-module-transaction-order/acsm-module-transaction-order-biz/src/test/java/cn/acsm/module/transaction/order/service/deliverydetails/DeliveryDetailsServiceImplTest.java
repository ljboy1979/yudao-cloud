package cn.acsm.module.transaction.order.service.deliverydetails;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.transaction.order.controller.admin.deliverydetails.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.deliverydetails.DeliveryDetailsDO;
import cn.acsm.module.transaction.order.dal.mysql.deliverydetails.*;
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
* {@link DeliveryDetailsServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(DeliveryDetailsServiceImpl.class)
public class DeliveryDetailsServiceImplTest extends BaseDbUnitTest {

    @Resource
    private DeliveryDetailsServiceImpl deliveryDetailsService;

    @Resource
    private DeliveryDetailsMapper deliveryDetailsMapper;

    @Test
    public void testCreateDeliveryDetails_success() {
        // 准备参数
        DeliveryDetailsCreateReqVO reqVO = randomPojo(DeliveryDetailsCreateReqVO.class);

        // 调用
        String deliveryDetailsId = deliveryDetailsService.createDeliveryDetails(reqVO);
        // 断言
        assertNotNull(deliveryDetailsId);
        // 校验记录的属性是否正确
        DeliveryDetailsDO deliveryDetails = deliveryDetailsMapper.selectById(deliveryDetailsId);
        assertPojoEquals(reqVO, deliveryDetails);
    }

    @Test
    public void testUpdateDeliveryDetails_success() {
        // mock 数据
        DeliveryDetailsDO dbDeliveryDetails = randomPojo(DeliveryDetailsDO.class);
        deliveryDetailsMapper.insert(dbDeliveryDetails);// @Sql: 先插入出一条存在的数据
        // 准备参数
        DeliveryDetailsUpdateReqVO reqVO = randomPojo(DeliveryDetailsUpdateReqVO.class, o -> {
            o.setId(dbDeliveryDetails.getId()); // 设置更新的 ID
        });

        // 调用
        deliveryDetailsService.updateDeliveryDetails(reqVO);
        // 校验是否更新正确
        DeliveryDetailsDO deliveryDetails = deliveryDetailsMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, deliveryDetails);
    }

    @Test
    public void testUpdateDeliveryDetails_notExists() {
        // 准备参数
        DeliveryDetailsUpdateReqVO reqVO = randomPojo(DeliveryDetailsUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> deliveryDetailsService.updateDeliveryDetails(reqVO), DELIVERY_DETAILS_NOT_EXISTS);
    }

    @Test
    public void testDeleteDeliveryDetails_success() {
        // mock 数据
        DeliveryDetailsDO dbDeliveryDetails = randomPojo(DeliveryDetailsDO.class);
        deliveryDetailsMapper.insert(dbDeliveryDetails);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbDeliveryDetails.getId();

        // 调用
        deliveryDetailsService.deleteDeliveryDetails(id);
       // 校验数据不存在了
       assertNull(deliveryDetailsMapper.selectById(id));
    }

    @Test
    public void testDeleteDeliveryDetails_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> deliveryDetailsService.deleteDeliveryDetails(id), DELIVERY_DETAILS_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetDeliveryDetailsPage() {
       // mock 数据
       DeliveryDetailsDO dbDeliveryDetails = randomPojo(DeliveryDetailsDO.class, o -> { // 等会查询到
           o.setDeliveryId(null);
           o.setName(null);
       });
       deliveryDetailsMapper.insert(dbDeliveryDetails);
       // 测试 deliveryId 不匹配
       deliveryDetailsMapper.insert(cloneIgnoreId(dbDeliveryDetails, o -> o.setDeliveryId(null)));
       // 测试 name 不匹配
       deliveryDetailsMapper.insert(cloneIgnoreId(dbDeliveryDetails, o -> o.setName(null)));
       // 准备参数
       DeliveryDetailsPageReqVO reqVO = new DeliveryDetailsPageReqVO();
       reqVO.setDeliveryId(null);
       reqVO.setName(null);

       // 调用
       PageResult<DeliveryDetailsDO> pageResult = deliveryDetailsService.getDeliveryDetailsPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbDeliveryDetails, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetDeliveryDetailsList() {
       // mock 数据
       DeliveryDetailsDO dbDeliveryDetails = randomPojo(DeliveryDetailsDO.class, o -> { // 等会查询到
           o.setDeliveryId(null);
           o.setName(null);
       });
       deliveryDetailsMapper.insert(dbDeliveryDetails);
       // 测试 deliveryId 不匹配
       deliveryDetailsMapper.insert(cloneIgnoreId(dbDeliveryDetails, o -> o.setDeliveryId(null)));
       // 测试 name 不匹配
       deliveryDetailsMapper.insert(cloneIgnoreId(dbDeliveryDetails, o -> o.setName(null)));
       // 准备参数
       DeliveryDetailsExportReqVO reqVO = new DeliveryDetailsExportReqVO();
       reqVO.setDeliveryId(null);
       reqVO.setName(null);

       // 调用
       List<DeliveryDetailsDO> list = deliveryDetailsService.getDeliveryDetailsList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbDeliveryDetails, list.get(0));
    }

}
