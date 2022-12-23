package cn.acsm.module.stock.inventory;

import cn.acsm.module.stock.controller.admin.inventory.vo.StockInventoryCreateReqVO;
import cn.acsm.module.stock.controller.admin.inventory.vo.StockInventoryExportReqVO;
import cn.acsm.module.stock.controller.admin.inventory.vo.StockInventoryPageReqVO;
import cn.acsm.module.stock.controller.admin.inventory.vo.StockInventoryUpdateReqVO;
import cn.acsm.module.stock.dal.dataobject.inventory.StockInventoryDO;
import cn.acsm.module.stock.dal.mysql.inventory.StockInventoryMapper;
import cn.acsm.module.stock.service.inventory.StockInventoryServiceImpl;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static cn.acsm.module.stock.enums.ErrorCodeConstants.INVENTORY_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.cloneIgnoreId;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link StockInventoryServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(StockInventoryServiceImpl.class)
public class StockInventoryServiceImplTest extends BaseDbUnitTest {

    @Resource
    private StockInventoryServiceImpl inventoryService;

    @Resource
    private StockInventoryMapper inventoryMapper;

    @Test
    public void testCreateInventory_success() {
        // 准备参数
        StockInventoryCreateReqVO reqVO = randomPojo(StockInventoryCreateReqVO.class);

        // 调用
        String inventoryId = inventoryService.createInventory(reqVO);
        // 断言
        assertNotNull(inventoryId);
        // 校验记录的属性是否正确
        StockInventoryDO inventory = inventoryMapper.selectById(inventoryId);
        assertPojoEquals(reqVO, inventory);
    }

    @Test
    public void testUpdateInventory_success() {
        // mock 数据
        StockInventoryDO dbInventory = randomPojo(StockInventoryDO.class);
        inventoryMapper.insert(dbInventory);// @Sql: 先插入出一条存在的数据
        // 准备参数
        StockInventoryUpdateReqVO reqVO = randomPojo(StockInventoryUpdateReqVO.class, o -> {
            o.setId(dbInventory.getId()); // 设置更新的 ID
        });

        // 调用
        inventoryService.updateInventory(reqVO);
        // 校验是否更新正确
        StockInventoryDO inventory = inventoryMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, inventory);
    }

    @Test
    public void testUpdateInventory_notExists() {
        // 准备参数
        StockInventoryUpdateReqVO reqVO = randomPojo(StockInventoryUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> inventoryService.updateInventory(reqVO), INVENTORY_NOT_EXISTS);
    }

    @Test
    public void testDeleteInventory_success() {
        // mock 数据
        StockInventoryDO dbInventory = randomPojo(StockInventoryDO.class);
        inventoryMapper.insert(dbInventory);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbInventory.getId();

        // 调用
        inventoryService.deleteInventory(id);
       // 校验数据不存在了
       assertNull(inventoryMapper.selectById(id));
    }

//    @Test
//    public void testDeleteInventory_notExists() {
//        // 准备参数
//        String id = randomStringId();
//
//        // 调用, 并断言异常
//        assertServiceException(() -> inventoryService.deleteInventory(id), INVENTORY_NOT_EXISTS);
//    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInventoryPage() {
       // mock 数据
       StockInventoryDO dbInventory = randomPojo(StockInventoryDO.class, o -> { // 等会查询到
           o.setType(null);
           o.setWarehouseId(null);
           o.setWarehouseCode(null);
           o.setWarehouseName(null);
           o.setWarehouseType(null);
           o.setGoodsId(null);
           o.setGoodsNumber(null);
           o.setGoodsName(null);
           o.setGoodsType(null);
           o.setPackagingType(null);
           o.setPackagingSpecificationId(null);
           o.setPackingSpecification(null);
           o.setInventoryQuantity(null);
           o.setMeasureUnit(null);
           o.setUpperWarningLimit(null);
           o.setLowerWarningLimit(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
           o.setUserId(null);
           o.setSourceId(null);
       });
       inventoryMapper.insert(dbInventory);
       // 测试 type 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setType(null)));
       // 测试 warehouseId 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setWarehouseId(null)));
       // 测试 warehouseCode 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setWarehouseCode(null)));
       // 测试 warehouseName 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setWarehouseName(null)));
       // 测试 warehouseType 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setWarehouseType(null)));
       // 测试 goodsId 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setGoodsId(null)));
       // 测试 goodsNumber 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setGoodsNumber(null)));
       // 测试 goodsName 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setGoodsName(null)));
       // 测试 goodsType 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setGoodsType(null)));
       // 测试 packagingType 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setPackagingType(null)));
       // 测试 packagingSpecificationId 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setPackagingSpecificationId(null)));
       // 测试 packingSpecification 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setPackingSpecification(null)));
       // 测试 inventoryQuantity 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setInventoryQuantity(null)));
       // 测试 measureUnit 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setMeasureUnit(null)));
       // 测试 upperWarningLimit 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setUpperWarningLimit(null)));
       // 测试 lowerWarningLimit 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setLowerWarningLimit(null)));
       // 测试 createTime 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setSubjectId(null)));
       // 测试 userId 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setUserId(null)));
       // 测试 sourceId 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setSourceId(null)));
       // 准备参数
       StockInventoryPageReqVO reqVO = new StockInventoryPageReqVO();
       reqVO.setType(null);
       reqVO.setWarehouseId(null);
       reqVO.setWarehouseCode(null);
       reqVO.setWarehouseName(null);
       reqVO.setWarehouseType(null);
       reqVO.setGoodsId(null);
       reqVO.setGoodsNumber(null);
       reqVO.setGoodsName(null);
       reqVO.setGoodsType(null);
       reqVO.setPackagingType(null);
       reqVO.setPackagingSpecificationId(null);
       reqVO.setPackingSpecification(null);
       reqVO.setInventoryQuantity(null);
       reqVO.setMeasureUnit(null);
       reqVO.setUpperWarningLimit(null);
       reqVO.setLowerWarningLimit(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);
       reqVO.setUserId(null);
       reqVO.setSourceId(null);

       // 调用
       PageResult<StockInventoryDO> pageResult = inventoryService.getInventoryPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbInventory, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInventoryList() {
       // mock 数据
       StockInventoryDO dbInventory = randomPojo(StockInventoryDO.class, o -> { // 等会查询到
           o.setType(null);
           o.setWarehouseId(null);
           o.setWarehouseCode(null);
           o.setWarehouseName(null);
           o.setWarehouseType(null);
           o.setGoodsId(null);
           o.setGoodsNumber(null);
           o.setGoodsName(null);
           o.setGoodsType(null);
           o.setPackagingType(null);
           o.setPackagingSpecificationId(null);
           o.setPackingSpecification(null);
           o.setInventoryQuantity(null);
           o.setMeasureUnit(null);
           o.setUpperWarningLimit(null);
           o.setLowerWarningLimit(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
           o.setUserId(null);
           o.setSourceId(null);
       });
       inventoryMapper.insert(dbInventory);
       // 测试 type 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setType(null)));
       // 测试 warehouseId 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setWarehouseId(null)));
       // 测试 warehouseCode 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setWarehouseCode(null)));
       // 测试 warehouseName 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setWarehouseName(null)));
       // 测试 warehouseType 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setWarehouseType(null)));
       // 测试 goodsId 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setGoodsId(null)));
       // 测试 goodsNumber 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setGoodsNumber(null)));
       // 测试 goodsName 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setGoodsName(null)));
       // 测试 goodsType 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setGoodsType(null)));
       // 测试 packagingType 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setPackagingType(null)));
       // 测试 packagingSpecificationId 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setPackagingSpecificationId(null)));
       // 测试 packingSpecification 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setPackingSpecification(null)));
       // 测试 inventoryQuantity 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setInventoryQuantity(null)));
       // 测试 measureUnit 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setMeasureUnit(null)));
       // 测试 upperWarningLimit 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setUpperWarningLimit(null)));
       // 测试 lowerWarningLimit 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setLowerWarningLimit(null)));
       // 测试 createTime 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setSubjectId(null)));
       // 测试 userId 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setUserId(null)));
       // 测试 sourceId 不匹配
       inventoryMapper.insert(cloneIgnoreId(dbInventory, o -> o.setSourceId(null)));
       // 准备参数
       StockInventoryExportReqVO reqVO = new StockInventoryExportReqVO();
       reqVO.setType(null);
       reqVO.setWarehouseId(null);
       reqVO.setWarehouseCode(null);
       reqVO.setWarehouseName(null);
       reqVO.setWarehouseType(null);
       reqVO.setGoodsId(null);
       reqVO.setGoodsNumber(null);
       reqVO.setGoodsName(null);
       reqVO.setGoodsType(null);
       reqVO.setPackagingType(null);
       reqVO.setPackagingSpecificationId(null);
       reqVO.setPackingSpecification(null);
       reqVO.setInventoryQuantity(null);
       reqVO.setMeasureUnit(null);
       reqVO.setUpperWarningLimit(null);
       reqVO.setLowerWarningLimit(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);
       reqVO.setUserId(null);
       reqVO.setSourceId(null);

       // 调用
       List<StockInventoryDO> list = inventoryService.getInventoryList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbInventory, list.get(0));
    }

}
