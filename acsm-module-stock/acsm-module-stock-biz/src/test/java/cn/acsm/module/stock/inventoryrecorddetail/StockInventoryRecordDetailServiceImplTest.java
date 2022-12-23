package cn.acsm.module.stock.inventoryrecorddetail;

import cn.acsm.module.stock.controller.admin.inventoryrecorddetail.vo.StockInventoryRecordDetailCreateReqVO;
import cn.acsm.module.stock.controller.admin.inventoryrecorddetail.vo.StockInventoryRecordDetailExportReqVO;
import cn.acsm.module.stock.controller.admin.inventoryrecorddetail.vo.StockInventoryRecordDetailPageReqVO;
import cn.acsm.module.stock.controller.admin.inventoryrecorddetail.vo.StockInventoryRecordDetailUpdateReqVO;
import cn.acsm.module.stock.dal.dataobject.inventoryrecorddetail.StockInventoryRecordDetailDO;
import cn.acsm.module.stock.dal.mysql.inventoryrecorddetail.StockInventoryRecordDetailMapper;
import cn.acsm.module.stock.service.inventoryrecorddetail.StockInventoryRecordDetailServiceImpl;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static cn.acsm.module.stock.enums.ErrorCodeConstants.INVENTORY_RECORD_DETAIL_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.cloneIgnoreId;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link StockInventoryRecordDetailServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(StockInventoryRecordDetailServiceImpl.class)
public class StockInventoryRecordDetailServiceImplTest extends BaseDbUnitTest {

    @Resource
    private StockInventoryRecordDetailServiceImpl inventoryRecordDetailService;

    @Resource
    private StockInventoryRecordDetailMapper inventoryRecordDetailMapper;

    @Test
    public void testCreateInventoryRecordDetail_success() {
        // 准备参数
        StockInventoryRecordDetailCreateReqVO reqVO = randomPojo(StockInventoryRecordDetailCreateReqVO.class);

        // 调用
        Long inventoryRecordDetailId = inventoryRecordDetailService.createInventoryRecordDetail(reqVO);
        // 断言
        assertNotNull(inventoryRecordDetailId);
        // 校验记录的属性是否正确
        StockInventoryRecordDetailDO inventoryRecordDetail = inventoryRecordDetailMapper.selectById(inventoryRecordDetailId);
        assertPojoEquals(reqVO, inventoryRecordDetail);
    }

    @Test
    public void testUpdateInventoryRecordDetail_success() {
        // mock 数据
        StockInventoryRecordDetailDO dbInventoryRecordDetail = randomPojo(StockInventoryRecordDetailDO.class);
        inventoryRecordDetailMapper.insert(dbInventoryRecordDetail);// @Sql: 先插入出一条存在的数据
        // 准备参数
        StockInventoryRecordDetailUpdateReqVO reqVO = randomPojo(StockInventoryRecordDetailUpdateReqVO.class, o -> {
            o.setId(dbInventoryRecordDetail.getId()); // 设置更新的 ID
        });

        // 调用
        inventoryRecordDetailService.updateInventoryRecordDetail(reqVO);
        // 校验是否更新正确
        StockInventoryRecordDetailDO inventoryRecordDetail = inventoryRecordDetailMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, inventoryRecordDetail);
    }

    @Test
    public void testUpdateInventoryRecordDetail_notExists() {
        // 准备参数
        StockInventoryRecordDetailUpdateReqVO reqVO = randomPojo(StockInventoryRecordDetailUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> inventoryRecordDetailService.updateInventoryRecordDetail(reqVO), INVENTORY_RECORD_DETAIL_NOT_EXISTS);
    }

    @Test
    public void testDeleteInventoryRecordDetail_success() {
        // mock 数据
        StockInventoryRecordDetailDO dbInventoryRecordDetail = randomPojo(StockInventoryRecordDetailDO.class);
        inventoryRecordDetailMapper.insert(dbInventoryRecordDetail);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbInventoryRecordDetail.getId();

        // 调用
        inventoryRecordDetailService.deleteInventoryRecordDetail(id);
       // 校验数据不存在了
       assertNull(inventoryRecordDetailMapper.selectById(id));
    }

    @Test
    public void testDeleteInventoryRecordDetail_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> inventoryRecordDetailService.deleteInventoryRecordDetail(id), INVENTORY_RECORD_DETAIL_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInventoryRecordDetailPage() {
       // mock 数据
       StockInventoryRecordDetailDO dbInventoryRecordDetail = randomPojo(StockInventoryRecordDetailDO.class, o -> { // 等会查询到
           o.setStockRecordId(null);
           o.setStockBatchNo(null);
           o.setStockRecordDetailId(null);
           o.setType(null);
           o.setSecondaryClassification(null);
           o.setGoodsId(null);
           o.setGoodsNumber(null);
           o.setGoodsName(null);
           o.setGoodsType(null);
           o.setPackagingSpecificationId(null);
           o.setPackagingSpecification(null);
           o.setPackagingSpecificationName(null);
           o.setPackagingType(null);
           o.setInventoryFrontQuantity(null);
           o.setInventoryAfterQuantity(null);
           o.setGoodsAllocationId(null);
           o.setGoodsAllocationNo(null);
           o.setSourceTo(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
           o.setUserId(null);
           o.setSourceId(null);
       });
       inventoryRecordDetailMapper.insert(dbInventoryRecordDetail);
       // 测试 stockRecordId 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setStockRecordId(null)));
       // 测试 stockBatchNo 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setStockBatchNo(null)));
       // 测试 stockRecordDetailId 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setStockRecordDetailId(null)));
       // 测试 type 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setType(null)));
       // 测试 secondaryClassification 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setSecondaryClassification(null)));
       // 测试 goodsId 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setGoodsId(null)));
       // 测试 goodsNumber 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setGoodsNumber(null)));
       // 测试 goodsName 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setGoodsName(null)));
       // 测试 goodsType 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setGoodsType(null)));
       // 测试 packagingSpecificationId 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setPackagingSpecificationId(null)));
       // 测试 packagingSpecification 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setPackagingSpecification(null)));
       // 测试 packagingSpecificationName 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setPackagingSpecificationName(null)));
       // 测试 packagingType 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setPackagingType(null)));
       // 测试 inventoryFrontQuantity 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setInventoryFrontQuantity(null)));
       // 测试 inventoryAfterQuantity 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setInventoryAfterQuantity(null)));
       // 测试 goodsAllocationId 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setGoodsAllocationId(null)));
       // 测试 goodsAllocationNo 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setGoodsAllocationNo(null)));
       // 测试 sourceTo 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setSourceTo(null)));
       // 测试 createTime 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setSubjectId(null)));
       // 测试 userId 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setUserId(null)));
       // 测试 sourceId 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setSourceId(null)));
       // 准备参数
       StockInventoryRecordDetailPageReqVO reqVO = new StockInventoryRecordDetailPageReqVO();
       reqVO.setStockRecordId(null);
       reqVO.setStockBatchNo(null);
       reqVO.setStockRecordDetailId(null);
       reqVO.setType(null);
       reqVO.setSecondaryClassification(null);
       reqVO.setGoodsId(null);
       reqVO.setGoodsNumber(null);
       reqVO.setGoodsName(null);
       reqVO.setGoodsType(null);
       reqVO.setPackagingSpecificationId(null);
       reqVO.setPackagingSpecification(null);
       reqVO.setPackagingSpecificationName(null);
       reqVO.setPackagingType(null);
       reqVO.setInventoryFrontQuantity(null);
       reqVO.setInventoryAfterQuantity(null);
       reqVO.setGoodsAllocationId(null);
       reqVO.setGoodsAllocationNo(null);
       reqVO.setSourceTo(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);
       reqVO.setUserId(null);
       reqVO.setSourceId(null);

       // 调用
       PageResult<StockInventoryRecordDetailDO> pageResult = inventoryRecordDetailService.getInventoryRecordDetailPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbInventoryRecordDetail, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInventoryRecordDetailList() {
       // mock 数据
       StockInventoryRecordDetailDO dbInventoryRecordDetail = randomPojo(StockInventoryRecordDetailDO.class, o -> { // 等会查询到
           o.setStockRecordId(null);
           o.setStockBatchNo(null);
           o.setStockRecordDetailId(null);
           o.setType(null);
           o.setSecondaryClassification(null);
           o.setGoodsId(null);
           o.setGoodsNumber(null);
           o.setGoodsName(null);
           o.setGoodsType(null);
           o.setPackagingSpecificationId(null);
           o.setPackagingSpecification(null);
           o.setPackagingSpecificationName(null);
           o.setPackagingType(null);
           o.setInventoryFrontQuantity(null);
           o.setInventoryAfterQuantity(null);
           o.setGoodsAllocationId(null);
           o.setGoodsAllocationNo(null);
           o.setSourceTo(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
           o.setUserId(null);
           o.setSourceId(null);
       });
       inventoryRecordDetailMapper.insert(dbInventoryRecordDetail);
       // 测试 stockRecordId 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setStockRecordId(null)));
       // 测试 stockBatchNo 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setStockBatchNo(null)));
       // 测试 stockRecordDetailId 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setStockRecordDetailId(null)));
       // 测试 type 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setType(null)));
       // 测试 secondaryClassification 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setSecondaryClassification(null)));
       // 测试 goodsId 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setGoodsId(null)));
       // 测试 goodsNumber 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setGoodsNumber(null)));
       // 测试 goodsName 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setGoodsName(null)));
       // 测试 goodsType 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setGoodsType(null)));
       // 测试 packagingSpecificationId 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setPackagingSpecificationId(null)));
       // 测试 packagingSpecification 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setPackagingSpecification(null)));
       // 测试 packagingSpecificationName 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setPackagingSpecificationName(null)));
       // 测试 packagingType 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setPackagingType(null)));
       // 测试 inventoryFrontQuantity 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setInventoryFrontQuantity(null)));
       // 测试 inventoryAfterQuantity 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setInventoryAfterQuantity(null)));
       // 测试 goodsAllocationId 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setGoodsAllocationId(null)));
       // 测试 goodsAllocationNo 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setGoodsAllocationNo(null)));
       // 测试 sourceTo 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setSourceTo(null)));
       // 测试 createTime 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setSubjectId(null)));
       // 测试 userId 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setUserId(null)));
       // 测试 sourceId 不匹配
       inventoryRecordDetailMapper.insert(cloneIgnoreId(dbInventoryRecordDetail, o -> o.setSourceId(null)));
       // 准备参数
       StockInventoryRecordDetailExportReqVO reqVO = new StockInventoryRecordDetailExportReqVO();
       reqVO.setStockRecordId(null);
       reqVO.setStockBatchNo(null);
       reqVO.setStockRecordDetailId(null);
       reqVO.setType(null);
       reqVO.setSecondaryClassification(null);
       reqVO.setGoodsId(null);
       reqVO.setGoodsNumber(null);
       reqVO.setGoodsName(null);
       reqVO.setGoodsType(null);
       reqVO.setPackagingSpecificationId(null);
       reqVO.setPackagingSpecification(null);
       reqVO.setPackagingSpecificationName(null);
       reqVO.setPackagingType(null);
       reqVO.setInventoryFrontQuantity(null);
       reqVO.setInventoryAfterQuantity(null);
       reqVO.setGoodsAllocationId(null);
       reqVO.setGoodsAllocationNo(null);
       reqVO.setSourceTo(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);
       reqVO.setUserId(null);
       reqVO.setSourceId(null);

       // 调用
       List<StockInventoryRecordDetailDO> list = inventoryRecordDetailService.getInventoryRecordDetailList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbInventoryRecordDetail, list.get(0));
    }

}
