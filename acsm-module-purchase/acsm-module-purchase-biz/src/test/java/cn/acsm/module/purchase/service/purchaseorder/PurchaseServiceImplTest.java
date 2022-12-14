package cn.acsm.module.purchase.service.purchaseorder;

import cn.acsm.module.purchase.controller.admin.purchase.vo.PurchaseCreateReqVO;
import cn.acsm.module.purchase.controller.admin.purchase.vo.PurchaseExportReqVO;
import cn.acsm.module.purchase.controller.admin.purchase.vo.PurchasePageReqVO;
import cn.acsm.module.purchase.controller.admin.purchase.vo.PurchaseUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.purchase.PurchaseDO;
import cn.acsm.module.purchase.dal.mysql.purchase.PurchaseMapper;
import cn.acsm.module.purchase.service.purchase.PurchaseServiceImpl;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static cn.acsm.module.purchase.enums.ErrorCodeConstants.PURCHASE_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.cloneIgnoreId;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link PurchaseServiceImplTest} 的单元测试类
*
* @author 芋道源码
*/
@Import(PurchaseServiceImpl.class)
public class PurchaseServiceImplTest extends BaseDbUnitTest {

    @Resource
    private PurchaseServiceImpl purchaseService;

    @Resource
    private PurchaseMapper purchaseMapper;

    @Test
    public void testCreatepurchase_success() {
        // 准备参数
        PurchaseCreateReqVO reqVO = randomPojo(PurchaseCreateReqVO.class);

        // 调用
        Long purchaseId = purchaseService.createpurchase(reqVO);
        // 断言
        assertNotNull(purchaseId);
        // 校验记录的属性是否正确
        PurchaseDO purchase = purchaseMapper.selectById(purchaseId);
        assertPojoEquals(reqVO, purchase);
    }

    @Test
    public void testUpdatepurchase_success() {
        // mock 数据
        PurchaseDO dbpurchase = randomPojo(PurchaseDO.class);
        purchaseMapper.insert(dbpurchase);// @Sql: 先插入出一条存在的数据
        // 准备参数
        PurchaseUpdateReqVO reqVO = randomPojo(PurchaseUpdateReqVO.class, o -> {
            o.setId(dbpurchase.getId()); // 设置更新的 ID
        });

        // 调用
        purchaseService.updatepurchase(reqVO);
        // 校验是否更新正确
        PurchaseDO purchase = purchaseMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, purchase);
    }

    @Test
    public void testUpdatepurchase_notExists() {
        // 准备参数
        PurchaseUpdateReqVO reqVO = randomPojo(PurchaseUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> purchaseService.updatepurchase(reqVO), PURCHASE_NOT_EXISTS);
    }

    @Test
    public void testDeletepurchase_success() {
        // mock 数据
        PurchaseDO dbpurchase = randomPojo(PurchaseDO.class);
        purchaseMapper.insert(dbpurchase);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbpurchase.getId();

        // 调用
        purchaseService.deletepurchase(id);
       // 校验数据不存在了
       assertNull(purchaseMapper.selectById(id));
    }

    @Test
    public void testDeletepurchase_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> purchaseService.deletepurchase(id), PURCHASE_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetpurchasePage() {
       // mock 数据
       PurchaseDO dbpurchase = randomPojo(PurchaseDO.class, o -> { // 等会查询到
           o.setId(null);
           o.setPurchaseType(null);
           o.setSecondaryClassification(null);
           o.setPurchaseOrderNumber(null);
           o.setProviderId(null);
           o.setProviderName(null);
           o.setProviderContactInformation(null);
           o.setPurchaseTime(null);
           o.setPurchaseCompletionTime(null);
           o.setTotalProcurement(null);
           o.setSettlementMethod(null);
           o.setBeneficiaryName(null);
           o.setBankOfDeposit(null);
           o.setCollectionAccountNo(null);
           o.setPaymentMethod(null);
           o.setPurchaserId(null);
           o.setPurchaserName(null);
           o.setProcurementDepartmentId(null);
           o.setProcurementDepartmentName(null);
           o.setProvince(null);
           o.setCity(null);
           o.setArea(null);
           o.setDetailedAddress(null);
           o.setLongitude(null);
           o.setLatitude(null);
           o.setBaseId(null);
           o.setMassifId(null);
           o.setPurchaseStatus(null);
           o.setQuotationId(null);
           o.setQuotationNo(null);
           o.setTermOfValidity(null);
           o.setCollectionBatchNo(null);
           o.setTransactionNo(null);
           o.setPurchaseOrderSource(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       purchaseMapper.insert(dbpurchase);
       // 测试 id 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setId(null)));
       // 测试 purchaseType 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setPurchaseType(null)));
       // 测试 secondaryClassification 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setSecondaryClassification(null)));
       // 测试 purchaseOrderNumber 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setPurchaseOrderNumber(null)));
       // 测试 providerId 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setProviderId(null)));
       // 测试 providerName 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setProviderName(null)));
       // 测试 providerContactInformation 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setProviderContactInformation(null)));
       // 测试 purchaseTime 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setPurchaseTime(null)));
       // 测试 purchaseCompletionTime 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setPurchaseCompletionTime(null)));
       // 测试 totalProcurement 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setTotalProcurement(null)));
       // 测试 settlementMethod 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setSettlementMethod(null)));
       // 测试 beneficiaryName 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setBeneficiaryName(null)));
       // 测试 bankOfDeposit 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setBankOfDeposit(null)));
       // 测试 collectionAccountNo 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setCollectionAccountNo(null)));
       // 测试 paymentMethod 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setPaymentMethod(null)));
       // 测试 purchaserId 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setPurchaserId(null)));
       // 测试 purchaserName 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setPurchaserName(null)));
       // 测试 procurementDepartmentId 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setProcurementDepartmentId(null)));
       // 测试 procurementDepartmentName 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setProcurementDepartmentName(null)));
       // 测试 province 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setProvince(null)));
       // 测试 city 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setCity(null)));
       // 测试 area 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setArea(null)));
       // 测试 detailedAddress 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setDetailedAddress(null)));
       // 测试 longitude 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setLongitude(null)));
       // 测试 latitude 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setLatitude(null)));
       // 测试 baseId 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setBaseId(null)));
       // 测试 massifId 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setMassifId(null)));
       // 测试 purchaseStatus 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setPurchaseStatus(null)));
       // 测试 quotationId 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setQuotationId(null)));
       // 测试 quotationNo 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setQuotationNo(null)));
       // 测试 termOfValidity 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setTermOfValidity(null)));
       // 测试 collectionBatchNo 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setCollectionBatchNo(null)));
       // 测试 transactionNo 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setTransactionNo(null)));
       // 测试 purchaseOrderSource 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setPurchaseOrderSource(null)));
       // 测试 status 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setCreateTime(null)));
       // 准备参数
       PurchasePageReqVO reqVO = new PurchasePageReqVO();
       reqVO.setId(null);
       reqVO.setPurchaseType(null);
       reqVO.setSecondaryClassification(null);
       reqVO.setPurchaseOrderNumber(null);
       reqVO.setProviderId(null);
       reqVO.setProviderName(null);
       reqVO.setProviderContactInformation(null);
       reqVO.setPurchaseTime((new Date[]{}));
       reqVO.setPurchaseCompletionTime((new Date[]{}));
       reqVO.setTotalProcurement(null);
       reqVO.setSettlementMethod(null);
       reqVO.setBeneficiaryName(null);
       reqVO.setBankOfDeposit(null);
       reqVO.setCollectionAccountNo(null);
       reqVO.setPaymentMethod(null);
       reqVO.setPurchaserId(null);
       reqVO.setPurchaserName(null);
       reqVO.setProcurementDepartmentId(null);
       reqVO.setProcurementDepartmentName(null);
       reqVO.setProvince(null);
       reqVO.setCity(null);
       reqVO.setArea(null);
       reqVO.setDetailedAddress(null);
       reqVO.setLongitude(null);
       reqVO.setLatitude(null);
       reqVO.setBaseId(null);
       reqVO.setMassifId(null);
       reqVO.setPurchaseStatus(null);
       reqVO.setQuotationId(null);
       reqVO.setQuotationNo(null);
       reqVO.setTermOfValidity(null);
       reqVO.setCollectionBatchNo(null);
       reqVO.setTransactionNo(null);
       reqVO.setPurchaseOrderSource(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<PurchaseDO> pageResult = purchaseService.getpurchasePage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbpurchase, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetpurchaseList() {
       // mock 数据
       PurchaseDO dbpurchase = randomPojo(PurchaseDO.class, o -> { // 等会查询到
           o.setId(null);
           o.setPurchaseType(null);
           o.setSecondaryClassification(null);
           o.setPurchaseOrderNumber(null);
           o.setProviderId(null);
           o.setProviderName(null);
           o.setProviderContactInformation(null);
           o.setPurchaseTime(null);
           o.setPurchaseCompletionTime(null);
           o.setTotalProcurement(null);
           o.setSettlementMethod(null);
           o.setBeneficiaryName(null);
           o.setBankOfDeposit(null);
           o.setCollectionAccountNo(null);
           o.setPaymentMethod(null);
           o.setPurchaserId(null);
           o.setPurchaserName(null);
           o.setProcurementDepartmentId(null);
           o.setProcurementDepartmentName(null);
           o.setProvince(null);
           o.setCity(null);
           o.setArea(null);
           o.setDetailedAddress(null);
           o.setLongitude(null);
           o.setLatitude(null);
           o.setBaseId(null);
           o.setMassifId(null);
           o.setPurchaseStatus(null);
           o.setQuotationId(null);
           o.setQuotationNo(null);
           o.setTermOfValidity(null);
           o.setCollectionBatchNo(null);
           o.setTransactionNo(null);
           o.setPurchaseOrderSource(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       purchaseMapper.insert(dbpurchase);
       // 测试 id 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setId(null)));
       // 测试 purchaseType 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setPurchaseType(null)));
       // 测试 secondaryClassification 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setSecondaryClassification(null)));
       // 测试 purchaseOrderNumber 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setPurchaseOrderNumber(null)));
       // 测试 providerId 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setProviderId(null)));
       // 测试 providerName 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setProviderName(null)));
       // 测试 providerContactInformation 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setProviderContactInformation(null)));
       // 测试 purchaseTime 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setPurchaseTime(null)));
       // 测试 purchaseCompletionTime 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setPurchaseCompletionTime(null)));
       // 测试 totalProcurement 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setTotalProcurement(null)));
       // 测试 settlementMethod 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setSettlementMethod(null)));
       // 测试 beneficiaryName 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setBeneficiaryName(null)));
       // 测试 bankOfDeposit 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setBankOfDeposit(null)));
       // 测试 collectionAccountNo 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setCollectionAccountNo(null)));
       // 测试 paymentMethod 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setPaymentMethod(null)));
       // 测试 purchaserId 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setPurchaserId(null)));
       // 测试 purchaserName 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setPurchaserName(null)));
       // 测试 procurementDepartmentId 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setProcurementDepartmentId(null)));
       // 测试 procurementDepartmentName 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setProcurementDepartmentName(null)));
       // 测试 province 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setProvince(null)));
       // 测试 city 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setCity(null)));
       // 测试 area 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setArea(null)));
       // 测试 detailedAddress 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setDetailedAddress(null)));
       // 测试 longitude 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setLongitude(null)));
       // 测试 latitude 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setLatitude(null)));
       // 测试 baseId 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setBaseId(null)));
       // 测试 massifId 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setMassifId(null)));
       // 测试 purchaseStatus 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setPurchaseStatus(null)));
       // 测试 quotationId 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setQuotationId(null)));
       // 测试 quotationNo 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setQuotationNo(null)));
       // 测试 termOfValidity 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setTermOfValidity(null)));
       // 测试 collectionBatchNo 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setCollectionBatchNo(null)));
       // 测试 transactionNo 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setTransactionNo(null)));
       // 测试 purchaseOrderSource 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setPurchaseOrderSource(null)));
       // 测试 status 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       purchaseMapper.insert(cloneIgnoreId(dbpurchase, o -> o.setCreateTime(null)));
       // 准备参数
       PurchaseExportReqVO reqVO = new PurchaseExportReqVO();
       reqVO.setId(null);
       reqVO.setPurchaseType(null);
       reqVO.setSecondaryClassification(null);
       reqVO.setPurchaseOrderNumber(null);
       reqVO.setProviderId(null);
       reqVO.setProviderName(null);
       reqVO.setProviderContactInformation(null);
       reqVO.setPurchaseTime((new Date[]{}));
       reqVO.setPurchaseCompletionTime((new Date[]{}));
       reqVO.setTotalProcurement(null);
       reqVO.setSettlementMethod(null);
       reqVO.setBeneficiaryName(null);
       reqVO.setBankOfDeposit(null);
       reqVO.setCollectionAccountNo(null);
       reqVO.setPaymentMethod(null);
       reqVO.setPurchaserId(null);
       reqVO.setPurchaserName(null);
       reqVO.setProcurementDepartmentId(null);
       reqVO.setProcurementDepartmentName(null);
       reqVO.setProvince(null);
       reqVO.setCity(null);
       reqVO.setArea(null);
       reqVO.setDetailedAddress(null);
       reqVO.setLongitude(null);
       reqVO.setLatitude(null);
       reqVO.setBaseId(null);
       reqVO.setMassifId(null);
       reqVO.setPurchaseStatus(null);
       reqVO.setQuotationId(null);
       reqVO.setQuotationNo(null);
       reqVO.setTermOfValidity(null);
       reqVO.setCollectionBatchNo(null);
       reqVO.setTransactionNo(null);
       reqVO.setPurchaseOrderSource(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<PurchaseDO> list = purchaseService.getpurchaseList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbpurchase, list.get(0));
    }

}
