package cn.acsm.module.purchase.service.order;

import cn.acsm.module.purchase.controller.admin.order.vo.PurchaseOrderCreateReqVO;
import cn.acsm.module.purchase.controller.admin.order.vo.PurchaseOrderExportReqVO;
import cn.acsm.module.purchase.controller.admin.order.vo.PurchaseOrderPageReqVO;
import cn.acsm.module.purchase.controller.admin.order.vo.PurchaseOrderUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.order.PurchaseOrderDO;
import cn.acsm.module.purchase.dal.mysql.order.PurchaseOrderMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static cn.acsm.module.purchase.enums.ErrorCodeConstants.ORDER_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.cloneIgnoreId;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link PurchaseOrderServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(PurchaseOrderServiceImpl.class)
public class PurchaseOrderServiceImplTest extends BaseDbUnitTest {

    @Resource
    private PurchaseOrderServiceImpl orderService;

    @Resource
    private PurchaseOrderMapper orderMapper;

    @Test
    public void testCreateOrder_success() {
        // 准备参数
        PurchaseOrderCreateReqVO reqVO = randomPojo(PurchaseOrderCreateReqVO.class);

        // 调用
        Long orderId = orderService.createOrder(reqVO);
        // 断言
        assertNotNull(orderId);
        // 校验记录的属性是否正确
        PurchaseOrderDO order = orderMapper.selectById(orderId);
        assertPojoEquals(reqVO, order);
    }

    @Test
    public void testUpdateOrder_success() {
        // mock 数据
        PurchaseOrderDO dbOrder = randomPojo(PurchaseOrderDO.class);
        orderMapper.insert(dbOrder);// @Sql: 先插入出一条存在的数据
        // 准备参数
        PurchaseOrderUpdateReqVO reqVO = randomPojo(PurchaseOrderUpdateReqVO.class, o -> {
            o.setId(dbOrder.getId()); // 设置更新的 ID
        });

        // 调用
        orderService.updateOrder(reqVO);
        // 校验是否更新正确
        PurchaseOrderDO order = orderMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, order);
    }

    @Test
    public void testUpdateOrder_notExists() {
        // 准备参数
        PurchaseOrderUpdateReqVO reqVO = randomPojo(PurchaseOrderUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> orderService.updateOrder(reqVO), ORDER_NOT_EXISTS);
    }

    @Test
    public void testDeleteOrder_success() {
        // mock 数据
        PurchaseOrderDO dbOrder = randomPojo(PurchaseOrderDO.class);
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
       PurchaseOrderDO dbOrder = randomPojo(PurchaseOrderDO.class, o -> { // 等会查询到
           o.setPurchaseType(null);
           o.setSecondaryClassification(null);
           o.setPurchaseNumber(null);
           o.setProviderId(null);
           o.setProviderName(null);
           o.setProviderPhone(null);
           o.setPurchaseTime(null);
           o.setComplateTime(null);
           o.setPurchaseTotalAmount(null);
           o.setSettlementType(null);
           o.setBeneficiaryName(null);
           o.setBankDeposit(null);
           o.setCollectionAccount(null);
           o.setPayWay(null);
           o.setPurchaserId(null);
           o.setPurchaserName(null);
           o.setPurchaseOfficeId(null);
           o.setPurchaseOfficeName(null);
           o.setProvince(null);
           o.setCity(null);
           o.setCountry(null);
           o.setAddress(null);
           o.setLongitude(null);
           o.setLatitude(null);
           o.setBasesId(null);
           o.setTunnelId(null);
           o.setPurchaseStatus(null);
           o.setQuoteId(null);
           o.setEffectiveStage(null);
           o.setBatchCode(null);
           o.setTransactionNumber(null);
           o.setSource(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
       });
       orderMapper.insert(dbOrder);
       // 测试 purchaseType 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setPurchaseType(null)));
       // 测试 secondaryClassification 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setSecondaryClassification(null)));
       // 测试 purchaseNumber 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setPurchaseNumber(null)));
       // 测试 providerId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setProviderId(null)));
       // 测试 providerName 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setProviderName(null)));
       // 测试 providerPhone 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setProviderPhone(null)));
       // 测试 purchaseTime 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setPurchaseTime(null)));
       // 测试 complateTime 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setComplateTime(null)));
       // 测试 purchaseTotalAmount 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setPurchaseTotalAmount(null)));
       // 测试 settlementType 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setSettlementType(null)));
       // 测试 beneficiaryName 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setBeneficiaryName(null)));
       // 测试 bankDeposit 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setBankDeposit(null)));
       // 测试 collectionAccount 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setCollectionAccount(null)));
       // 测试 payWay 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setPayWay(null)));
       // 测试 purchaserId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setPurchaserId(null)));
       // 测试 purchaserName 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setPurchaserName(null)));
       // 测试 purchaseOfficeId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setPurchaseOfficeId(null)));
       // 测试 purchaseOfficeName 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setPurchaseOfficeName(null)));
       // 测试 province 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setProvince(null)));
       // 测试 city 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setCity(null)));
       // 测试 country 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setCountry(null)));
       // 测试 address 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setAddress(null)));
       // 测试 longitude 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setLongitude(null)));
       // 测试 latitude 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setLatitude(null)));
       // 测试 basesId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setBasesId(null)));
       // 测试 tunnelId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setTunnelId(null)));
       // 测试 purchaseStatus 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setPurchaseStatus(null)));
       // 测试 quoteId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setQuoteId(null)));
       // 测试 effectiveStage 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setEffectiveStage(null)));
       // 测试 batchCode 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setBatchCode(null)));
       // 测试 transactionNumber 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setTransactionNumber(null)));
       // 测试 source 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setSource(null)));
       // 测试 status 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setSubjectId(null)));
       // 准备参数
       PurchaseOrderPageReqVO reqVO = new PurchaseOrderPageReqVO();
       reqVO.setPurchaseType(null);
       reqVO.setSecondaryClassification(null);
       reqVO.setPurchaseNumber(null);
       reqVO.setProviderId(null);
       reqVO.setProviderName(null);
       reqVO.setProviderPhone(null);
       reqVO.setPurchaseTime((new Date[]{}));
       reqVO.setComplateTime((new Date[]{}));
       reqVO.setPurchaseTotalAmount(null);
       reqVO.setSettlementType(null);
       reqVO.setBeneficiaryName(null);
       reqVO.setBankDeposit(null);
       reqVO.setCollectionAccount(null);
       reqVO.setPayWay(null);
       reqVO.setPurchaserId(null);
       reqVO.setPurchaserName(null);
       reqVO.setPurchaseOfficeId(null);
       reqVO.setPurchaseOfficeName(null);
       reqVO.setProvince(null);
       reqVO.setCity(null);
       reqVO.setCountry(null);
       reqVO.setAddress(null);
       reqVO.setLongitude(null);
       reqVO.setLatitude(null);
       reqVO.setBasesId(null);
       reqVO.setTunnelId(null);
       reqVO.setPurchaseStatus(null);
       reqVO.setQuoteId(null);
       reqVO.setEffectiveStage(null);
       reqVO.setBatchCode(null);
       reqVO.setTransactionNumber(null);
       reqVO.setSource(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);

       // 调用
       PageResult<PurchaseOrderDO> pageResult = orderService.getOrderPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbOrder, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetOrderList() {
       // mock 数据
       PurchaseOrderDO dbOrder = randomPojo(PurchaseOrderDO.class, o -> { // 等会查询到
           o.setPurchaseType(null);
           o.setSecondaryClassification(null);
           o.setPurchaseNumber(null);
           o.setProviderId(null);
           o.setProviderName(null);
           o.setProviderPhone(null);
           o.setPurchaseTime(null);
           o.setComplateTime(null);
           o.setPurchaseTotalAmount(null);
           o.setSettlementType(null);
           o.setBeneficiaryName(null);
           o.setBankDeposit(null);
           o.setCollectionAccount(null);
           o.setPayWay(null);
           o.setPurchaserId(null);
           o.setPurchaserName(null);
           o.setPurchaseOfficeId(null);
           o.setPurchaseOfficeName(null);
           o.setProvince(null);
           o.setCity(null);
           o.setCountry(null);
           o.setAddress(null);
           o.setLongitude(null);
           o.setLatitude(null);
           o.setBasesId(null);
           o.setTunnelId(null);
           o.setPurchaseStatus(null);
           o.setQuoteId(null);
           o.setEffectiveStage(null);
           o.setBatchCode(null);
           o.setTransactionNumber(null);
           o.setSource(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
       });
       orderMapper.insert(dbOrder);
       // 测试 purchaseType 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setPurchaseType(null)));
       // 测试 secondaryClassification 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setSecondaryClassification(null)));
       // 测试 purchaseNumber 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setPurchaseNumber(null)));
       // 测试 providerId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setProviderId(null)));
       // 测试 providerName 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setProviderName(null)));
       // 测试 providerPhone 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setProviderPhone(null)));
       // 测试 purchaseTime 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setPurchaseTime(null)));
       // 测试 complateTime 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setComplateTime(null)));
       // 测试 purchaseTotalAmount 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setPurchaseTotalAmount(null)));
       // 测试 settlementType 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setSettlementType(null)));
       // 测试 beneficiaryName 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setBeneficiaryName(null)));
       // 测试 bankDeposit 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setBankDeposit(null)));
       // 测试 collectionAccount 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setCollectionAccount(null)));
       // 测试 payWay 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setPayWay(null)));
       // 测试 purchaserId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setPurchaserId(null)));
       // 测试 purchaserName 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setPurchaserName(null)));
       // 测试 purchaseOfficeId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setPurchaseOfficeId(null)));
       // 测试 purchaseOfficeName 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setPurchaseOfficeName(null)));
       // 测试 province 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setProvince(null)));
       // 测试 city 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setCity(null)));
       // 测试 country 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setCountry(null)));
       // 测试 address 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setAddress(null)));
       // 测试 longitude 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setLongitude(null)));
       // 测试 latitude 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setLatitude(null)));
       // 测试 basesId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setBasesId(null)));
       // 测试 tunnelId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setTunnelId(null)));
       // 测试 purchaseStatus 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setPurchaseStatus(null)));
       // 测试 quoteId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setQuoteId(null)));
       // 测试 effectiveStage 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setEffectiveStage(null)));
       // 测试 batchCode 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setBatchCode(null)));
       // 测试 transactionNumber 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setTransactionNumber(null)));
       // 测试 source 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setSource(null)));
       // 测试 status 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setSubjectId(null)));
       // 准备参数
       PurchaseOrderExportReqVO reqVO = new PurchaseOrderExportReqVO();
       reqVO.setPurchaseType(null);
       reqVO.setSecondaryClassification(null);
       reqVO.setPurchaseNumber(null);
       reqVO.setProviderId(null);
       reqVO.setProviderName(null);
       reqVO.setProviderPhone(null);
       reqVO.setPurchaseTime((new Date[]{}));
       reqVO.setComplateTime((new Date[]{}));
       reqVO.setPurchaseTotalAmount(null);
       reqVO.setSettlementType(null);
       reqVO.setBeneficiaryName(null);
       reqVO.setBankDeposit(null);
       reqVO.setCollectionAccount(null);
       reqVO.setPayWay(null);
       reqVO.setPurchaserId(null);
       reqVO.setPurchaserName(null);
       reqVO.setPurchaseOfficeId(null);
       reqVO.setPurchaseOfficeName(null);
       reqVO.setProvince(null);
       reqVO.setCity(null);
       reqVO.setCountry(null);
       reqVO.setAddress(null);
       reqVO.setLongitude(null);
       reqVO.setLatitude(null);
       reqVO.setBasesId(null);
       reqVO.setTunnelId(null);
       reqVO.setPurchaseStatus(null);
       reqVO.setQuoteId(null);
       reqVO.setEffectiveStage(null);
       reqVO.setBatchCode(null);
       reqVO.setTransactionNumber(null);
       reqVO.setSource(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);

       // 调用
       List<PurchaseOrderDO> list = orderService.getOrderList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbOrder, list.get(0));
    }

}
