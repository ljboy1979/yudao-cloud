package cn.acsm.module.service.service.serviceorder;

import cn.acsm.module.service.controller.admin.serviceorder.vo.ServiceOrderCreateReqVO;
import cn.acsm.module.service.controller.admin.serviceorder.vo.ServiceOrderExportReqVO;
import cn.acsm.module.service.controller.admin.serviceorder.vo.ServiceOrderPageReqVO;
import cn.acsm.module.service.controller.admin.serviceorder.vo.ServiceOrderUpdateReqVO;
import cn.acsm.module.service.dal.dataobject.serviceorder.ServiceOrderDO;
import cn.acsm.module.service.dal.mysql.serviceorder.ServiceOrderMapper;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.time.LocalDateTime;

import static cn.acsm.module.service.enums.ErrorCodeConstants.ORDER_NOT_EXISTS;
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
* {@link ServiceOrderServiceImpl} 的单元测试类
*
* @author smile
*/
@Import(ServiceOrderServiceImpl.class)
public class ServiceOrderServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ServiceOrderServiceImpl orderService;

    @Resource
    private ServiceOrderMapper orderMapper;

    @Test
    public void testCreateOrder_success() {
        // 准备参数
        ServiceOrderCreateReqVO reqVO = randomPojo(ServiceOrderCreateReqVO.class);

        // 调用
        Long orderId = orderService.createOrder(reqVO);
        // 断言
        assertNotNull(orderId);
        // 校验记录的属性是否正确
        ServiceOrderDO order = orderMapper.selectById(orderId);
        assertPojoEquals(reqVO, order);
    }

    @Test
    public void testUpdateOrder_success() {
        // mock 数据
        ServiceOrderDO dbOrder = randomPojo(ServiceOrderDO.class);
        orderMapper.insert(dbOrder);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ServiceOrderUpdateReqVO reqVO = randomPojo(ServiceOrderUpdateReqVO.class, o -> {
            o.setId(dbOrder.getId()); // 设置更新的 ID
        });

        // 调用
        orderService.updateOrder(reqVO);
        // 校验是否更新正确
        ServiceOrderDO order = orderMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, order);
    }

    @Test
    public void testUpdateOrder_notExists() {
        // 准备参数
        ServiceOrderUpdateReqVO reqVO = randomPojo(ServiceOrderUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> orderService.updateOrder(reqVO), ORDER_NOT_EXISTS);
    }

    @Test
    public void testDeleteOrder_success() {
        // mock 数据
        ServiceOrderDO dbOrder = randomPojo(ServiceOrderDO.class);
        orderMapper.insert(dbOrder);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbOrder.getId();

        // 调用
        orderService.deleteOrder(id);
       // 校验数据不存在了
       assertNull(orderMapper.selectById(id));
    }

    @Test
    public void testDeleteOrder_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> orderService.deleteOrder(id), ORDER_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetOrderPage() {
       // mock 数据
       ServiceOrderDO dbOrder = randomPojo(ServiceOrderDO.class, o -> { // 等会查询到
           o.setTransactionNumber(null);
           o.setServiceUserId(null);
           o.setCellphoneNumber(null);
           o.setOrderTime(null);
           o.setTotalAmount(null);
           o.setServiceId(null);
           o.setServiceEquitiesId(null);
           o.setParticipation(null);
           o.setServiceCharge(null);
           o.setOrderStatus(null);
           o.setServicePriceId(null);
           o.setSystemUserId(null);
           o.setCarrierId(null);
           o.setAreaCode(null);
           o.setOrderType(null);
           o.setTicketPackageId(null);
           o.setPayType(null);
           o.setActivitySessionId(null);
           o.setFarmFamilyId(null);
           o.setWeixinOrderId(null);
           o.setExchangeCode(null);
           o.setScanOperator(null);
           o.setScanDate(null);
           o.setExpiryDate(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
       });
       orderMapper.insert(dbOrder);
       // 测试 transactionNumber 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setTransactionNumber(null)));
       // 测试 serviceUserId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setServiceUserId(null)));
       // 测试 cellphoneNumber 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setCellphoneNumber(null)));
       // 测试 orderTime 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setOrderTime(null)));
       // 测试 totalAmount 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setTotalAmount(null)));
       // 测试 serviceId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setServiceId(null)));
       // 测试 serviceEquitiesId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setServiceEquitiesId(null)));
       // 测试 participation 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setParticipation(null)));
       // 测试 serviceCharge 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setServiceCharge(null)));
       // 测试 orderStatus 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setOrderStatus(null)));
       // 测试 servicePriceId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setServicePriceId(null)));
       // 测试 systemUserId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setSystemUserId(null)));
       // 测试 carrierId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setCarrierId(null)));
       // 测试 areaCode 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setAreaCode(null)));
       // 测试 orderType 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setOrderType(null)));
       // 测试 ticketPackageId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setTicketPackageId(null)));
       // 测试 payType 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setPayType(null)));
       // 测试 activitySessionId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setActivitySessionId(null)));
       // 测试 farmFamilyId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setFarmFamilyId(null)));
       // 测试 weixinOrderId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setWeixinOrderId(null)));
       // 测试 exchangeCode 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setExchangeCode(null)));
       // 测试 scanOperator 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setScanOperator(null)));
       // 测试 scanDate 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setScanDate(null)));
       // 测试 expiryDate 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setExpiryDate(null)));
       // 测试 status 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setSource(null)));
       // 准备参数
       ServiceOrderPageReqVO reqVO = new ServiceOrderPageReqVO();
       reqVO.setTransactionNumber(null);
       reqVO.setServiceUserId(null);
       reqVO.setCellphoneNumber(null);
       reqVO.setOrderTime((new Date[]{}));
       reqVO.setTotalAmount(null);
       reqVO.setServiceId(null);
       reqVO.setServiceEquitiesId(null);
       reqVO.setParticipation(null);
       reqVO.setServiceCharge(null);
       reqVO.setOrderStatus(null);
       reqVO.setServicePriceId(null);
       reqVO.setSystemUserId(null);
       reqVO.setCarrierId(null);
       reqVO.setAreaCode(null);
       reqVO.setOrderType(null);
       reqVO.setTicketPackageId(null);
       reqVO.setPayType(null);
       reqVO.setActivitySessionId(null);
       reqVO.setFarmFamilyId(null);
       reqVO.setWeixinOrderId(null);
       reqVO.setExchangeCode(null);
       reqVO.setScanOperator(null);
       reqVO.setScanDate((new Date[]{}));
       reqVO.setExpiryDate((new Date[]{}));
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);

       // 调用
       PageResult<ServiceOrderDO> pageResult = orderService.getOrderPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbOrder, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetOrderList() {
       // mock 数据
       ServiceOrderDO dbOrder = randomPojo(ServiceOrderDO.class, o -> { // 等会查询到
           o.setTransactionNumber(null);
           o.setServiceUserId(null);
           o.setCellphoneNumber(null);
           o.setOrderTime(null);
           o.setTotalAmount(null);
           o.setServiceId(null);
           o.setServiceEquitiesId(null);
           o.setParticipation(null);
           o.setServiceCharge(null);
           o.setOrderStatus(null);
           o.setServicePriceId(null);
           o.setSystemUserId(null);
           o.setCarrierId(null);
           o.setAreaCode(null);
           o.setOrderType(null);
           o.setTicketPackageId(null);
           o.setPayType(null);
           o.setActivitySessionId(null);
           o.setFarmFamilyId(null);
           o.setWeixinOrderId(null);
           o.setExchangeCode(null);
           o.setScanOperator(null);
           o.setScanDate(null);
           o.setExpiryDate(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
       });
       orderMapper.insert(dbOrder);
       // 测试 transactionNumber 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setTransactionNumber(null)));
       // 测试 serviceUserId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setServiceUserId(null)));
       // 测试 cellphoneNumber 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setCellphoneNumber(null)));
       // 测试 orderTime 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setOrderTime(null)));
       // 测试 totalAmount 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setTotalAmount(null)));
       // 测试 serviceId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setServiceId(null)));
       // 测试 serviceEquitiesId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setServiceEquitiesId(null)));
       // 测试 participation 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setParticipation(null)));
       // 测试 serviceCharge 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setServiceCharge(null)));
       // 测试 orderStatus 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setOrderStatus(null)));
       // 测试 servicePriceId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setServicePriceId(null)));
       // 测试 systemUserId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setSystemUserId(null)));
       // 测试 carrierId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setCarrierId(null)));
       // 测试 areaCode 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setAreaCode(null)));
       // 测试 orderType 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setOrderType(null)));
       // 测试 ticketPackageId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setTicketPackageId(null)));
       // 测试 payType 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setPayType(null)));
       // 测试 activitySessionId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setActivitySessionId(null)));
       // 测试 farmFamilyId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setFarmFamilyId(null)));
       // 测试 weixinOrderId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setWeixinOrderId(null)));
       // 测试 exchangeCode 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setExchangeCode(null)));
       // 测试 scanOperator 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setScanOperator(null)));
       // 测试 scanDate 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setScanDate(null)));
       // 测试 expiryDate 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setExpiryDate(null)));
       // 测试 status 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setSource(null)));
       // 准备参数
       ServiceOrderExportReqVO reqVO = new ServiceOrderExportReqVO();
       reqVO.setTransactionNumber(null);
       reqVO.setServiceUserId(null);
       reqVO.setCellphoneNumber(null);
       reqVO.setOrderTime((new Date[]{}));
       reqVO.setTotalAmount(null);
       reqVO.setServiceId(null);
       reqVO.setServiceEquitiesId(null);
       reqVO.setParticipation(null);
       reqVO.setServiceCharge(null);
       reqVO.setOrderStatus(null);
       reqVO.setServicePriceId(null);
       reqVO.setSystemUserId(null);
       reqVO.setCarrierId(null);
       reqVO.setAreaCode(null);
       reqVO.setOrderType(null);
       reqVO.setTicketPackageId(null);
       reqVO.setPayType(null);
       reqVO.setActivitySessionId(null);
       reqVO.setFarmFamilyId(null);
       reqVO.setWeixinOrderId(null);
       reqVO.setExchangeCode(null);
       reqVO.setScanOperator(null);
       reqVO.setScanDate((new Date[]{}));
       reqVO.setExpiryDate((new Date[]{}));
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);

       // 调用
       List<ServiceOrderDO> list = orderService.getOrderList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbOrder, list.get(0));
    }

}
