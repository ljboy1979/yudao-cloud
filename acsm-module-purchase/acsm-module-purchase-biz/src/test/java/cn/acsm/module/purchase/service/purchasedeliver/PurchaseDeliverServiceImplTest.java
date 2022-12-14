package cn.acsm.module.purchase.service.purchasedeliver;

import cn.acsm.module.purchase.controller.admin.deliver.vo.PurchaseDeliverCreateReqVO;
import cn.acsm.module.purchase.controller.admin.deliver.vo.PurchaseDeliverExportReqVO;
import cn.acsm.module.purchase.controller.admin.deliver.vo.PurchaseDeliverPageReqVO;
import cn.acsm.module.purchase.controller.admin.deliver.vo.PurchaseDeliverUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.deliver.PurchaseDeliverDO;
import cn.acsm.module.purchase.dal.mysql.deliver.PurchaseDeliverMapper;
import cn.acsm.module.purchase.service.deliver.PurchaseDeliverServiceImpl;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static cn.acsm.module.purchase.enums.ErrorCodeConstants.DELIVER_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.cloneIgnoreId;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link PurchaseDeliverServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(PurchaseDeliverServiceImpl.class)
public class PurchaseDeliverServiceImplTest extends BaseDbUnitTest {

    @Resource
    private PurchaseDeliverServiceImpl deliverService;

    @Resource
    private PurchaseDeliverMapper deliverMapper;

    @Test
    public void testCreateDeliver_success() {
        // 准备参数
        PurchaseDeliverCreateReqVO reqVO = randomPojo(PurchaseDeliverCreateReqVO.class);

        // 调用
        Long deliverId = deliverService.createDeliver(reqVO);
        // 断言
        assertNotNull(deliverId);
        // 校验记录的属性是否正确
        PurchaseDeliverDO deliver = deliverMapper.selectById(deliverId);
        assertPojoEquals(reqVO, deliver);
    }

    @Test
    public void testUpdateDeliver_success() {
        // mock 数据
        PurchaseDeliverDO dbDeliver = randomPojo(PurchaseDeliverDO.class);
        deliverMapper.insert(dbDeliver);// @Sql: 先插入出一条存在的数据
        // 准备参数
        PurchaseDeliverUpdateReqVO reqVO = randomPojo(PurchaseDeliverUpdateReqVO.class, o -> {
            o.setId(dbDeliver.getId()); // 设置更新的 ID
        });

        // 调用
        deliverService.updateDeliver(reqVO);
        // 校验是否更新正确
        PurchaseDeliverDO deliver = deliverMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, deliver);
    }

    @Test
    public void testUpdateDeliver_notExists() {
        // 准备参数
        PurchaseDeliverUpdateReqVO reqVO = randomPojo(PurchaseDeliverUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> deliverService.updateDeliver(reqVO), DELIVER_NOT_EXISTS);
    }

    @Test
    public void testDeleteDeliver_success() {
        // mock 数据
        PurchaseDeliverDO dbDeliver = randomPojo(PurchaseDeliverDO.class);
        deliverMapper.insert(dbDeliver);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbDeliver.getId();

        // 调用
        deliverService.deleteDeliver(id);
       // 校验数据不存在了
       assertNull(deliverMapper.selectById(id));
    }

    @Test
    public void testDeleteDeliver_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> deliverService.deleteDeliver(id), DELIVER_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetDeliverPage() {
       // mock 数据
       PurchaseDeliverDO dbDeliver = randomPojo(PurchaseDeliverDO.class, o -> { // 等会查询到
           o.setOrderId(null);
           o.setOrderDetailsId(null);
           o.setPurchaseOrderNumber(null);
           o.setDeliveryBatch(null);
           o.setExpectedDeliveryTime(null);
           o.setActualDelivery(null);
           o.setExpectedDeliveryCount(null);
           o.setActualDeliveryCount(null);
           o.setCompanyId(null);
           o.setSettlementTime(null);
           o.setSettlementAmount(null);
           o.setDeliveryStatus(null);
           o.setShipmentNo(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
       });
       deliverMapper.insert(dbDeliver);
       // 测试 orderId 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setOrderId(null)));
       // 测试 orderDetailsId 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setOrderDetailsId(null)));
       // 测试 purchaseOrderNumber 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setPurchaseOrderNumber(null)));
       // 测试 deliveryBatch 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setDeliveryBatch(null)));
       // 测试 expectedDeliveryTime 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setExpectedDeliveryTime(null)));
       // 测试 actualDelivery 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setActualDelivery(null)));
       // 测试 expectedDeliveryCount 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setExpectedDeliveryCount(null)));
       // 测试 actualDeliveryCount 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setActualDeliveryCount(null)));
       // 测试 companyId 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setCompanyId(null)));
       // 测试 settlementTime 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setSettlementTime(null)));
       // 测试 settlementAmount 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setSettlementAmount(null)));
       // 测试 deliveryStatus 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setDeliveryStatus(null)));
       // 测试 shipmentNo 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setShipmentNo(null)));
       // 测试 createTime 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setSubjectId(null)));
       // 准备参数
       PurchaseDeliverPageReqVO reqVO = new PurchaseDeliverPageReqVO();
       reqVO.setOrderId(null);
       reqVO.setOrderDetailsId(null);
       reqVO.setPurchaseOrderNumber(null);
       reqVO.setDeliveryBatch(null);
       reqVO.setExpectedDeliveryTime((new Date[]{}));
       reqVO.setActualDelivery(null);
       reqVO.setExpectedDeliveryCount(null);
       reqVO.setActualDeliveryCount(null);
       reqVO.setCompanyId(null);
       reqVO.setSettlementTime((new Date[]{}));
       reqVO.setSettlementAmount(null);
       reqVO.setDeliveryStatus(null);
       reqVO.setShipmentNo(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);

       // 调用
       PageResult<PurchaseDeliverDO> pageResult = deliverService.getDeliverPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbDeliver, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetDeliverList() {
       // mock 数据
       PurchaseDeliverDO dbDeliver = randomPojo(PurchaseDeliverDO.class, o -> { // 等会查询到
           o.setOrderId(null);
           o.setOrderDetailsId(null);
           o.setPurchaseOrderNumber(null);
           o.setDeliveryBatch(null);
           o.setExpectedDeliveryTime(null);
           o.setActualDelivery(null);
           o.setExpectedDeliveryCount(null);
           o.setActualDeliveryCount(null);
           o.setCompanyId(null);
           o.setSettlementTime(null);
           o.setSettlementAmount(null);
           o.setDeliveryStatus(null);
           o.setShipmentNo(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
       });
       deliverMapper.insert(dbDeliver);
       // 测试 orderId 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setOrderId(null)));
       // 测试 orderDetailsId 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setOrderDetailsId(null)));
       // 测试 purchaseOrderNumber 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setPurchaseOrderNumber(null)));
       // 测试 deliveryBatch 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setDeliveryBatch(null)));
       // 测试 expectedDeliveryTime 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setExpectedDeliveryTime(null)));
       // 测试 actualDelivery 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setActualDelivery(null)));
       // 测试 expectedDeliveryCount 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setExpectedDeliveryCount(null)));
       // 测试 actualDeliveryCount 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setActualDeliveryCount(null)));
       // 测试 companyId 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setCompanyId(null)));
       // 测试 settlementTime 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setSettlementTime(null)));
       // 测试 settlementAmount 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setSettlementAmount(null)));
       // 测试 deliveryStatus 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setDeliveryStatus(null)));
       // 测试 shipmentNo 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setShipmentNo(null)));
       // 测试 createTime 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       deliverMapper.insert(cloneIgnoreId(dbDeliver, o -> o.setSubjectId(null)));
       // 准备参数
       PurchaseDeliverExportReqVO reqVO = new PurchaseDeliverExportReqVO();
       reqVO.setOrderId(null);
       reqVO.setOrderDetailsId(null);
       reqVO.setPurchaseOrderNumber(null);
       reqVO.setDeliveryBatch(null);
       reqVO.setExpectedDeliveryTime((new Date[]{}));
       reqVO.setActualDelivery(null);
       reqVO.setExpectedDeliveryCount(null);
       reqVO.setActualDeliveryCount(null);
       reqVO.setCompanyId(null);
       reqVO.setSettlementTime((new Date[]{}));
       reqVO.setSettlementAmount(null);
       reqVO.setDeliveryStatus(null);
       reqVO.setShipmentNo(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);

       // 调用
       List<PurchaseDeliverDO> list = deliverService.getDeliverList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbDeliver, list.get(0));
    }

}
