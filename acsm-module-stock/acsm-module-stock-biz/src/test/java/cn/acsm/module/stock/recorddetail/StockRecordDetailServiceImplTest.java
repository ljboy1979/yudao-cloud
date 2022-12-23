package cn.acsm.module.stock.recorddetail;

import cn.acsm.module.stock.controller.admin.recorddetail.vo.StockRecordDetailCreateReqVO;
import cn.acsm.module.stock.controller.admin.recorddetail.vo.StockRecordDetailExportReqVO;
import cn.acsm.module.stock.controller.admin.recorddetail.vo.StockRecordDetailPageReqVO;
import cn.acsm.module.stock.controller.admin.recorddetail.vo.StockRecordDetailUpdateReqVO;
import cn.acsm.module.stock.dal.dataobject.recorddetail.StockRecordDetailDO;
import cn.acsm.module.stock.dal.mysql.recorddetail.StockRecordDetailMapper;
import cn.acsm.module.stock.service.recorddetail.StockRecordDetailServiceImpl;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static cn.acsm.module.stock.enums.ErrorCodeConstants.RECORD_DETAIL_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.cloneIgnoreId;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link StockRecordDetailServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(StockRecordDetailServiceImpl.class)
public class StockRecordDetailServiceImplTest extends BaseDbUnitTest {

    @Resource
    private StockRecordDetailServiceImpl recordDetailService;

    @Resource
    private StockRecordDetailMapper recordDetailMapper;

    @Test
    public void testCreateRecordDetail_success() {
        // 准备参数
        StockRecordDetailCreateReqVO reqVO = randomPojo(StockRecordDetailCreateReqVO.class);

        // 调用
        Long recordDetailId = recordDetailService.createRecordDetail(reqVO);
        // 断言
        assertNotNull(recordDetailId);
        // 校验记录的属性是否正确
        StockRecordDetailDO recordDetail = recordDetailMapper.selectById(recordDetailId);
        assertPojoEquals(reqVO, recordDetail);
    }

    @Test
    public void testUpdateRecordDetail_success() {
        // mock 数据
        StockRecordDetailDO dbRecordDetail = randomPojo(StockRecordDetailDO.class);
        recordDetailMapper.insert(dbRecordDetail);// @Sql: 先插入出一条存在的数据
        // 准备参数
        StockRecordDetailUpdateReqVO reqVO = randomPojo(StockRecordDetailUpdateReqVO.class, o -> {
            o.setId(dbRecordDetail.getId()); // 设置更新的 ID
        });

        // 调用
        recordDetailService.updateRecordDetail(reqVO);
        // 校验是否更新正确
        StockRecordDetailDO recordDetail = recordDetailMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, recordDetail);
    }

    @Test
    public void testUpdateRecordDetail_notExists() {
        // 准备参数
        StockRecordDetailUpdateReqVO reqVO = randomPojo(StockRecordDetailUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> recordDetailService.updateRecordDetail(reqVO), RECORD_DETAIL_NOT_EXISTS);
    }

    @Test
    public void testDeleteRecordDetail_success() {
        // mock 数据
        StockRecordDetailDO dbRecordDetail = randomPojo(StockRecordDetailDO.class);
        recordDetailMapper.insert(dbRecordDetail);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbRecordDetail.getId();

        // 调用
        recordDetailService.deleteRecordDetail(id);
       // 校验数据不存在了
       assertNull(recordDetailMapper.selectById(id));
    }

    @Test
    public void testDeleteRecordDetail_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> recordDetailService.deleteRecordDetail(id), RECORD_DETAIL_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetRecordDetailPage() {
       // mock 数据
       StockRecordDetailDO dbRecordDetail = randomPojo(StockRecordDetailDO.class, o -> { // 等会查询到
           o.setRecordId(null);
           o.setStockBatchNo(null);
           o.setOperationType(null);
           o.setSecondaryClassification(null);
           o.setGoodsId(null);
           o.setGoodsNumber(null);
           o.setGoodsName(null);
           o.setGoodsType(null);
           o.setPackagingType(null);
           o.setPackingSpecification(null);
           o.setReceiptQuantity(null);
           o.setExistingInventory(null);
           o.setDeliveryQuantity(null);
           o.setRecordDetailId(null);
           o.setGoodsAllocationId(null);
           o.setGoodsAllocationNo(null);
           o.setSourceTo(null);
           o.setUnitPrice(null);
           o.setUnit(null);
           o.setTotalPrice(null);
           o.setPayMethod(null);
           o.setProductionBatchNo(null);
           o.setBases(null);
           o.setTunnel(null);
           o.setTreasurySource(null);
           o.setHarvestBatchId(null);
           o.setPurchaseId(null);
           o.setPurchaseNumber(null);
           o.setProcessingOrderId(null);
           o.setWeighingRecordId(null);
           o.setPackingListId(null);
           o.setTemporaryTime(null);
           o.setEnvironmentalRequirements(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
           o.setUserId(null);
           o.setSourceId(null);
       });
       recordDetailMapper.insert(dbRecordDetail);
       // 测试 recordId 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setRecordId(null)));
       // 测试 stockBatchNo 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setStockBatchNo(null)));
       // 测试 operationType 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setOperationType(null)));
       // 测试 secondaryClassification 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setSecondaryClassification(null)));
       // 测试 goodsId 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setGoodsId(null)));
       // 测试 goodsNumber 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setGoodsNumber(null)));
       // 测试 goodsName 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setGoodsName(null)));
       // 测试 goodsType 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setGoodsType(null)));
       // 测试 packagingType 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setPackagingType(null)));
       // 测试 packingSpecification 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setPackingSpecification(null)));
       // 测试 receiptQuantity 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setReceiptQuantity(null)));
       // 测试 existingInventory 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setExistingInventory(null)));
       // 测试 deliveryQuantity 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setDeliveryQuantity(null)));
       // 测试 recordDetailId 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setRecordDetailId(null)));
       // 测试 goodsAllocationId 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setGoodsAllocationId(null)));
       // 测试 goodsAllocationNo 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setGoodsAllocationNo(null)));
       // 测试 sourceTo 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setSourceTo(null)));
       // 测试 unitPrice 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setUnitPrice(null)));
       // 测试 unit 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setUnit(null)));
       // 测试 totalPrice 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setTotalPrice(null)));
       // 测试 payMethod 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setPayMethod(null)));
       // 测试 productionBatchNo 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setProductionBatchNo(null)));
       // 测试 bases 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setBases(null)));
       // 测试 tunnel 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setTunnel(null)));
       // 测试 treasurySource 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setTreasurySource(null)));
       // 测试 harvestBatchId 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setHarvestBatchId(null)));
       // 测试 purchaseId 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setPurchaseId(null)));
       // 测试 purchaseNumber 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setPurchaseNumber(null)));
       // 测试 processingOrderId 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setProcessingOrderId(null)));
       // 测试 weighingRecordId 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setWeighingRecordId(null)));
       // 测试 packingListId 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setPackingListId(null)));
       // 测试 temporaryTime 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setTemporaryTime(null)));
       // 测试 environmentalRequirements 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setEnvironmentalRequirements(null)));
       // 测试 createTime 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setSubjectId(null)));
       // 测试 userId 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setUserId(null)));
       // 测试 sourceId 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setSourceId(null)));
       // 准备参数
       StockRecordDetailPageReqVO reqVO = new StockRecordDetailPageReqVO();
       reqVO.setRecordId(null);
       reqVO.setStockBatchNo(null);
       reqVO.setOperationType(null);
       reqVO.setSecondaryClassification(null);
       reqVO.setGoodsId(null);
       reqVO.setGoodsNumber(null);
       reqVO.setGoodsName(null);
       reqVO.setGoodsType(null);
       reqVO.setPackagingType(null);
       reqVO.setPackingSpecification(null);
       reqVO.setReceiptQuantity(null);
       reqVO.setExistingInventory(null);
       reqVO.setDeliveryQuantity(null);
       reqVO.setRecordDetailId(null);
       reqVO.setGoodsAllocationId(null);
       reqVO.setGoodsAllocationNo(null);
       reqVO.setSourceTo(null);
       reqVO.setUnitPrice(null);
       reqVO.setUnit(null);
       reqVO.setTotalPrice(null);
       reqVO.setPayMethod(null);
       reqVO.setProductionBatchNo(null);
       reqVO.setBases(null);
       reqVO.setTunnel(null);
       reqVO.setTreasurySource(null);
       reqVO.setHarvestBatchId(null);
       reqVO.setPurchaseId(null);
       reqVO.setPurchaseNumber(null);
       reqVO.setProcessingOrderId(null);
       reqVO.setWeighingRecordId(null);
       reqVO.setPackingListId(null);
       reqVO.setTemporaryTime((new Date[]{}));
       reqVO.setEnvironmentalRequirements(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);
       reqVO.setUserId(null);
       reqVO.setSourceId(null);

       // 调用
        Page<StockRecordDetailDO> recordDetailPage = recordDetailService.getRecordDetailPage(reqVO);
        // 断言
       assertEquals(1, recordDetailPage.getTotal());
//       assertEquals(1, recordDetailPage.getList().size());
//       assertPojoEquals(dbRecordDetail, recordDetailPage.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetRecordDetailList() {
       // mock 数据
       StockRecordDetailDO dbRecordDetail = randomPojo(StockRecordDetailDO.class, o -> { // 等会查询到
           o.setRecordId(null);
           o.setStockBatchNo(null);
           o.setOperationType(null);
           o.setSecondaryClassification(null);
           o.setGoodsId(null);
           o.setGoodsNumber(null);
           o.setGoodsName(null);
           o.setGoodsType(null);
           o.setPackagingType(null);
           o.setPackingSpecification(null);
           o.setReceiptQuantity(null);
           o.setExistingInventory(null);
           o.setDeliveryQuantity(null);
           o.setRecordDetailId(null);
           o.setGoodsAllocationId(null);
           o.setGoodsAllocationNo(null);
           o.setSourceTo(null);
           o.setUnitPrice(null);
           o.setUnit(null);
           o.setTotalPrice(null);
           o.setPayMethod(null);
           o.setProductionBatchNo(null);
           o.setBases(null);
           o.setTunnel(null);
           o.setTreasurySource(null);
           o.setHarvestBatchId(null);
           o.setPurchaseId(null);
           o.setPurchaseNumber(null);
           o.setProcessingOrderId(null);
           o.setWeighingRecordId(null);
           o.setPackingListId(null);
           o.setTemporaryTime(null);
           o.setEnvironmentalRequirements(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
           o.setUserId(null);
           o.setSourceId(null);
       });
       recordDetailMapper.insert(dbRecordDetail);
       // 测试 recordId 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setRecordId(null)));
       // 测试 stockBatchNo 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setStockBatchNo(null)));
       // 测试 operationType 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setOperationType(null)));
       // 测试 secondaryClassification 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setSecondaryClassification(null)));
       // 测试 goodsId 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setGoodsId(null)));
       // 测试 goodsNumber 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setGoodsNumber(null)));
       // 测试 goodsName 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setGoodsName(null)));
       // 测试 goodsType 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setGoodsType(null)));
       // 测试 packagingType 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setPackagingType(null)));
       // 测试 packingSpecification 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setPackingSpecification(null)));
       // 测试 receiptQuantity 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setReceiptQuantity(null)));
       // 测试 existingInventory 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setExistingInventory(null)));
       // 测试 deliveryQuantity 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setDeliveryQuantity(null)));
       // 测试 recordDetailId 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setRecordDetailId(null)));
       // 测试 goodsAllocationId 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setGoodsAllocationId(null)));
       // 测试 goodsAllocationNo 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setGoodsAllocationNo(null)));
       // 测试 sourceTo 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setSourceTo(null)));
       // 测试 unitPrice 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setUnitPrice(null)));
       // 测试 unit 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setUnit(null)));
       // 测试 totalPrice 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setTotalPrice(null)));
       // 测试 payMethod 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setPayMethod(null)));
       // 测试 productionBatchNo 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setProductionBatchNo(null)));
       // 测试 bases 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setBases(null)));
       // 测试 tunnel 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setTunnel(null)));
       // 测试 treasurySource 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setTreasurySource(null)));
       // 测试 harvestBatchId 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setHarvestBatchId(null)));
       // 测试 purchaseId 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setPurchaseId(null)));
       // 测试 purchaseNumber 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setPurchaseNumber(null)));
       // 测试 processingOrderId 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setProcessingOrderId(null)));
       // 测试 weighingRecordId 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setWeighingRecordId(null)));
       // 测试 packingListId 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setPackingListId(null)));
       // 测试 temporaryTime 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setTemporaryTime(null)));
       // 测试 environmentalRequirements 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setEnvironmentalRequirements(null)));
       // 测试 createTime 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setSubjectId(null)));
       // 测试 userId 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setUserId(null)));
       // 测试 sourceId 不匹配
       recordDetailMapper.insert(cloneIgnoreId(dbRecordDetail, o -> o.setSourceId(null)));
       // 准备参数
       StockRecordDetailExportReqVO reqVO = new StockRecordDetailExportReqVO();
       reqVO.setRecordId(null);
       reqVO.setStockBatchNo(null);
       reqVO.setOperationType(null);
       reqVO.setSecondaryClassification(null);
       reqVO.setGoodsId(null);
       reqVO.setGoodsNumber(null);
       reqVO.setGoodsName(null);
       reqVO.setGoodsType(null);
       reqVO.setPackagingType(null);
       reqVO.setPackingSpecification(null);
       reqVO.setReceiptQuantity(null);
       reqVO.setExistingInventory(null);
       reqVO.setDeliveryQuantity(null);
       reqVO.setRecordDetailId(null);
       reqVO.setGoodsAllocationId(null);
       reqVO.setGoodsAllocationNo(null);
       reqVO.setSourceTo(null);
       reqVO.setUnitPrice(null);
       reqVO.setUnit(null);
       reqVO.setTotalPrice(null);
       reqVO.setPayMethod(null);
       reqVO.setProductionBatchNo(null);
       reqVO.setBases(null);
       reqVO.setTunnel(null);
       reqVO.setTreasurySource(null);
       reqVO.setHarvestBatchId(null);
       reqVO.setPurchaseId(null);
       reqVO.setPurchaseNumber(null);
       reqVO.setProcessingOrderId(null);
       reqVO.setWeighingRecordId(null);
       reqVO.setPackingListId(null);
       reqVO.setTemporaryTime((new Date[]{}));
       reqVO.setEnvironmentalRequirements(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);
       reqVO.setUserId(null);
       reqVO.setSourceId(null);

       // 调用
       List<StockRecordDetailDO> list = recordDetailService.getRecordDetailList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbRecordDetail, list.get(0));
    }

}
