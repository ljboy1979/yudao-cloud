package cn.acsm.module.purchase.service.loss;

import cn.acsm.module.purchase.controller.admin.loss.vo.PurchaseLossCreateReqVO;
import cn.acsm.module.purchase.controller.admin.loss.vo.PurchaseLossExportReqVO;
import cn.acsm.module.purchase.controller.admin.loss.vo.PurchaseLossPageReqVO;
import cn.acsm.module.purchase.controller.admin.loss.vo.PurchaseLossUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.loss.PurchaseLossDO;
import cn.acsm.module.purchase.dal.mysql.loss.PurchaseLossMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static cn.acsm.module.purchase.enums.ErrorCodeConstants.LOSS_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.cloneIgnoreId;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link PurchaseLossServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(PurchaseLossServiceImpl.class)
public class PurchaseLossServiceImplTest extends BaseDbUnitTest {

    @Resource
    private PurchaseLossServiceImpl lossService;

    @Resource
    private PurchaseLossMapper lossMapper;

    @Test
    public void testCreateLoss_success() {
        // 准备参数
        PurchaseLossCreateReqVO reqVO = randomPojo(PurchaseLossCreateReqVO.class);

        // 调用
        Long lossId = lossService.createLoss(reqVO);
        // 断言
        assertNotNull(lossId);
        // 校验记录的属性是否正确
        PurchaseLossDO loss = lossMapper.selectById(lossId);
        assertPojoEquals(reqVO, loss);
    }

    @Test
    public void testUpdateLoss_success() {
        // mock 数据
        PurchaseLossDO dbLoss = randomPojo(PurchaseLossDO.class);
        lossMapper.insert(dbLoss);// @Sql: 先插入出一条存在的数据
        // 准备参数
        PurchaseLossUpdateReqVO reqVO = randomPojo(PurchaseLossUpdateReqVO.class, o -> {
            o.setId(dbLoss.getId()); // 设置更新的 ID
        });

        // 调用
        lossService.updateLoss(reqVO);
        // 校验是否更新正确
        PurchaseLossDO loss = lossMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, loss);
    }

    @Test
    public void testUpdateLoss_notExists() {
        // 准备参数
        PurchaseLossUpdateReqVO reqVO = randomPojo(PurchaseLossUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> lossService.updateLoss(reqVO), LOSS_NOT_EXISTS);
    }

    @Test
    public void testDeleteLoss_success() {
        // mock 数据
        PurchaseLossDO dbLoss = randomPojo(PurchaseLossDO.class);
        lossMapper.insert(dbLoss);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbLoss.getId();

        // 调用
        lossService.deleteLoss(id);
       // 校验数据不存在了
       assertNull(lossMapper.selectById(id));
    }

    @Test
    public void testDeleteLoss_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> lossService.deleteLoss(id), LOSS_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetLossPage() {
       // mock 数据
       PurchaseLossDO dbLoss = randomPojo(PurchaseLossDO.class, o -> { // 等会查询到
           o.setPurchaseId(null);
           o.setPurchaseNumber(null);
           o.setGoodsId(null);
           o.setElectronicBillOfGoodsId(null);
           o.setGoodSkuId(null);
           o.setGoodsName(null);
           o.setPackingSpecification(null);
           o.setSpecificationUnit(null);
           o.setLossCount(null);
           o.setLossWeight(null);
           o.setAmount(null);
           o.setManagerId(null);
           o.setManager(null);
           o.setTime(null);
           o.setStockId(null);
           o.setReceiptBatchNo(null);
           o.setInventoryRecordDetailsId(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
       });
       lossMapper.insert(dbLoss);
       // 测试 purchaseId 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setPurchaseId(null)));
       // 测试 purchaseNumber 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setPurchaseNumber(null)));
       // 测试 goodsId 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setGoodsId(null)));
       // 测试 electronicBillOfGoodsId 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setElectronicBillOfGoodsId(null)));
       // 测试 goodSkuId 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setGoodSkuId(null)));
       // 测试 goodsName 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setGoodsName(null)));
       // 测试 packingSpecification 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setPackingSpecification(null)));
       // 测试 specificationUnit 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setSpecificationUnit(null)));
       // 测试 lossCount 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setLossCount(null)));
       // 测试 lossWeight 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setLossWeight(null)));
       // 测试 amount 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setAmount(null)));
       // 测试 managerId 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setManagerId(null)));
       // 测试 manager 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setManager(null)));
       // 测试 time 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setTime(null)));
       // 测试 stockId 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setStockId(null)));
       // 测试 receiptBatchNo 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setReceiptBatchNo(null)));
       // 测试 inventoryRecordDetailsId 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setInventoryRecordDetailsId(null)));
       // 测试 createTime 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setSubjectId(null)));
       // 准备参数
       PurchaseLossPageReqVO reqVO = new PurchaseLossPageReqVO();
       reqVO.setPurchaseId(null);
       reqVO.setPurchaseNumber(null);
       reqVO.setGoodsId(null);
       reqVO.setElectronicBillOfGoodsId(null);
       reqVO.setGoodSkuId(null);
       reqVO.setGoodsName(null);
       reqVO.setPackingSpecification(null);
       reqVO.setSpecificationUnit(null);
       reqVO.setLossCount(null);
       reqVO.setLossWeight(null);
       reqVO.setAmount(null);
       reqVO.setManagerId(null);
       reqVO.setManager(null);
       reqVO.setTime((new Date[]{}));
       reqVO.setStockId(null);
       reqVO.setReceiptBatchNo(null);
       reqVO.setInventoryRecordDetailsId(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);

       // 调用
       PageResult<PurchaseLossDO> pageResult = lossService.getLossPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbLoss, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetLossList() {
       // mock 数据
       PurchaseLossDO dbLoss = randomPojo(PurchaseLossDO.class, o -> { // 等会查询到
           o.setPurchaseId(null);
           o.setPurchaseNumber(null);
           o.setGoodsId(null);
           o.setElectronicBillOfGoodsId(null);
           o.setGoodSkuId(null);
           o.setGoodsName(null);
           o.setPackingSpecification(null);
           o.setSpecificationUnit(null);
           o.setLossCount(null);
           o.setLossWeight(null);
           o.setAmount(null);
           o.setManagerId(null);
           o.setManager(null);
           o.setTime(null);
           o.setStockId(null);
           o.setReceiptBatchNo(null);
           o.setInventoryRecordDetailsId(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
       });
       lossMapper.insert(dbLoss);
       // 测试 purchaseId 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setPurchaseId(null)));
       // 测试 purchaseNumber 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setPurchaseNumber(null)));
       // 测试 goodsId 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setGoodsId(null)));
       // 测试 electronicBillOfGoodsId 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setElectronicBillOfGoodsId(null)));
       // 测试 goodSkuId 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setGoodSkuId(null)));
       // 测试 goodsName 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setGoodsName(null)));
       // 测试 packingSpecification 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setPackingSpecification(null)));
       // 测试 specificationUnit 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setSpecificationUnit(null)));
       // 测试 lossCount 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setLossCount(null)));
       // 测试 lossWeight 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setLossWeight(null)));
       // 测试 amount 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setAmount(null)));
       // 测试 managerId 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setManagerId(null)));
       // 测试 manager 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setManager(null)));
       // 测试 time 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setTime(null)));
       // 测试 stockId 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setStockId(null)));
       // 测试 receiptBatchNo 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setReceiptBatchNo(null)));
       // 测试 inventoryRecordDetailsId 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setInventoryRecordDetailsId(null)));
       // 测试 createTime 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       lossMapper.insert(cloneIgnoreId(dbLoss, o -> o.setSubjectId(null)));
       // 准备参数
       PurchaseLossExportReqVO reqVO = new PurchaseLossExportReqVO();
       reqVO.setPurchaseId(null);
       reqVO.setPurchaseNumber(null);
       reqVO.setGoodsId(null);
       reqVO.setElectronicBillOfGoodsId(null);
       reqVO.setGoodSkuId(null);
       reqVO.setGoodsName(null);
       reqVO.setPackingSpecification(null);
       reqVO.setSpecificationUnit(null);
       reqVO.setLossCount(null);
       reqVO.setLossWeight(null);
       reqVO.setAmount(null);
       reqVO.setManagerId(null);
       reqVO.setManager(null);
       reqVO.setTime((new Date[]{}));
       reqVO.setStockId(null);
       reqVO.setReceiptBatchNo(null);
       reqVO.setInventoryRecordDetailsId(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);

       // 调用
       List<PurchaseLossDO> list = lossService.getLossList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbLoss, list.get(0));
    }

}
