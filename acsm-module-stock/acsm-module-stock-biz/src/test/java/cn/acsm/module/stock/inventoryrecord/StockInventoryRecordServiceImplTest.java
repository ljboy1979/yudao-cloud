package cn.acsm.module.stock.inventoryrecord;

import cn.acsm.module.stock.controller.admin.inventoryrecord.vo.StockInventoryRecordCreateReqVO;
import cn.acsm.module.stock.controller.admin.inventoryrecord.vo.StockInventoryRecordExportReqVO;
import cn.acsm.module.stock.controller.admin.inventoryrecord.vo.StockInventoryRecordPageReqVO;
import cn.acsm.module.stock.controller.admin.inventoryrecord.vo.StockInventoryRecordUpdateReqVO;
import cn.acsm.module.stock.dal.dataobject.inventoryrecord.StockInventoryRecordDO;
import cn.acsm.module.stock.dal.mysql.inventoryrecord.StockInventoryRecordMapper;
import cn.acsm.module.stock.service.inventoryrecord.StockInventoryRecordServiceImpl;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static cn.acsm.module.stock.enums.ErrorCodeConstants.INVENTORY_RECORD_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.cloneIgnoreId;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link StockInventoryRecordServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(StockInventoryRecordServiceImpl.class)
public class StockInventoryRecordServiceImplTest extends BaseDbUnitTest {

    @Resource
    private StockInventoryRecordServiceImpl inventoryRecordService;

    @Resource
    private StockInventoryRecordMapper inventoryRecordMapper;

    @Test
    public void testCreateInventoryRecord_success() {
        // 准备参数
        StockInventoryRecordCreateReqVO reqVO = randomPojo(StockInventoryRecordCreateReqVO.class);

        // 调用
        Long inventoryRecordId = inventoryRecordService.createInventoryRecord(reqVO);
        // 断言
        assertNotNull(inventoryRecordId);
        // 校验记录的属性是否正确
        StockInventoryRecordDO inventoryRecord = inventoryRecordMapper.selectById(inventoryRecordId);
        assertPojoEquals(reqVO, inventoryRecord);
    }

    @Test
    public void testUpdateInventoryRecord_success() {
        // mock 数据
        StockInventoryRecordDO dbInventoryRecord = randomPojo(StockInventoryRecordDO.class);
        inventoryRecordMapper.insert(dbInventoryRecord);// @Sql: 先插入出一条存在的数据
        // 准备参数
        StockInventoryRecordUpdateReqVO reqVO = randomPojo(StockInventoryRecordUpdateReqVO.class, o -> {
            o.setId(dbInventoryRecord.getId()); // 设置更新的 ID
        });

        // 调用
        inventoryRecordService.updateInventoryRecord(reqVO);
        // 校验是否更新正确
        StockInventoryRecordDO inventoryRecord = inventoryRecordMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, inventoryRecord);
    }

    @Test
    public void testUpdateInventoryRecord_notExists() {
        // 准备参数
        StockInventoryRecordUpdateReqVO reqVO = randomPojo(StockInventoryRecordUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> inventoryRecordService.updateInventoryRecord(reqVO), INVENTORY_RECORD_NOT_EXISTS);
    }

    @Test
    public void testDeleteInventoryRecord_success() {
        // mock 数据
        StockInventoryRecordDO dbInventoryRecord = randomPojo(StockInventoryRecordDO.class);
        inventoryRecordMapper.insert(dbInventoryRecord);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbInventoryRecord.getId();

        // 调用
        inventoryRecordService.deleteInventoryRecord(id);
       // 校验数据不存在了
       assertNull(inventoryRecordMapper.selectById(id));
    }

    @Test
    public void testDeleteInventoryRecord_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> inventoryRecordService.deleteInventoryRecord(id), INVENTORY_RECORD_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInventoryRecordPage() {
       // mock 数据
       StockInventoryRecordDO dbInventoryRecord = randomPojo(StockInventoryRecordDO.class, o -> { // 等会查询到
           o.setType(null);
           o.setWarehouseId(null);
           o.setWarehouseCode(null);
           o.setWarehouseName(null);
           o.setInventoryCode(null);
           o.setOperationTime(null);
           o.setHeadId(null);
           o.setHeadName(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
           o.setUserId(null);
           o.setSourceId(null);
       });
       inventoryRecordMapper.insert(dbInventoryRecord);
       // 测试 type 不匹配
       inventoryRecordMapper.insert(cloneIgnoreId(dbInventoryRecord, o -> o.setType(null)));
       // 测试 warehouseId 不匹配
       inventoryRecordMapper.insert(cloneIgnoreId(dbInventoryRecord, o -> o.setWarehouseId(null)));
       // 测试 warehouseCode 不匹配
       inventoryRecordMapper.insert(cloneIgnoreId(dbInventoryRecord, o -> o.setWarehouseCode(null)));
       // 测试 warehouseName 不匹配
       inventoryRecordMapper.insert(cloneIgnoreId(dbInventoryRecord, o -> o.setWarehouseName(null)));
       // 测试 inventoryCode 不匹配
       inventoryRecordMapper.insert(cloneIgnoreId(dbInventoryRecord, o -> o.setInventoryCode(null)));
       // 测试 operationTime 不匹配
       inventoryRecordMapper.insert(cloneIgnoreId(dbInventoryRecord, o -> o.setOperationTime(null)));
       // 测试 headId 不匹配
       inventoryRecordMapper.insert(cloneIgnoreId(dbInventoryRecord, o -> o.setHeadId(null)));
       // 测试 headName 不匹配
       inventoryRecordMapper.insert(cloneIgnoreId(dbInventoryRecord, o -> o.setHeadName(null)));
       // 测试 createTime 不匹配
       inventoryRecordMapper.insert(cloneIgnoreId(dbInventoryRecord, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       inventoryRecordMapper.insert(cloneIgnoreId(dbInventoryRecord, o -> o.setSubjectId(null)));
       // 测试 userId 不匹配
       inventoryRecordMapper.insert(cloneIgnoreId(dbInventoryRecord, o -> o.setUserId(null)));
       // 测试 sourceId 不匹配
       inventoryRecordMapper.insert(cloneIgnoreId(dbInventoryRecord, o -> o.setSourceId(null)));
       // 准备参数
       StockInventoryRecordPageReqVO reqVO = new StockInventoryRecordPageReqVO();
       reqVO.setType(null);
       reqVO.setWarehouseId(null);
       reqVO.setWarehouseCode(null);
       reqVO.setWarehouseName(null);
       reqVO.setInventoryCode(null);
//       reqVO.setOperationTime((new Date[]{}));
       reqVO.setHeadId(null);
       reqVO.setHeadName(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);
       reqVO.setUserId(null);
       reqVO.setSourceId(null);

       // 调用
//       Page<StockInventoryRecordDO> pageResult = inventoryRecordService.getInventoryRecordPage(reqVO);
       // 断言
//       assertEquals(1, pageResult.getTotal());
//       assertEquals(1, pageResult.getRecords().size());
//       assertPojoEquals(dbInventoryRecord, pageResult.getRecords().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInventoryRecordList() {
       // mock 数据
       StockInventoryRecordDO dbInventoryRecord = randomPojo(StockInventoryRecordDO.class, o -> { // 等会查询到
           o.setType(null);
           o.setWarehouseId(null);
           o.setWarehouseCode(null);
           o.setWarehouseName(null);
           o.setInventoryCode(null);
           o.setOperationTime(null);
           o.setHeadId(null);
           o.setHeadName(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
           o.setUserId(null);
           o.setSourceId(null);
       });
       inventoryRecordMapper.insert(dbInventoryRecord);
       // 测试 type 不匹配
       inventoryRecordMapper.insert(cloneIgnoreId(dbInventoryRecord, o -> o.setType(null)));
       // 测试 warehouseId 不匹配
       inventoryRecordMapper.insert(cloneIgnoreId(dbInventoryRecord, o -> o.setWarehouseId(null)));
       // 测试 warehouseCode 不匹配
       inventoryRecordMapper.insert(cloneIgnoreId(dbInventoryRecord, o -> o.setWarehouseCode(null)));
       // 测试 warehouseName 不匹配
       inventoryRecordMapper.insert(cloneIgnoreId(dbInventoryRecord, o -> o.setWarehouseName(null)));
       // 测试 inventoryCode 不匹配
       inventoryRecordMapper.insert(cloneIgnoreId(dbInventoryRecord, o -> o.setInventoryCode(null)));
       // 测试 operationTime 不匹配
       inventoryRecordMapper.insert(cloneIgnoreId(dbInventoryRecord, o -> o.setOperationTime(null)));
       // 测试 headId 不匹配
       inventoryRecordMapper.insert(cloneIgnoreId(dbInventoryRecord, o -> o.setHeadId(null)));
       // 测试 headName 不匹配
       inventoryRecordMapper.insert(cloneIgnoreId(dbInventoryRecord, o -> o.setHeadName(null)));
       // 测试 createTime 不匹配
       inventoryRecordMapper.insert(cloneIgnoreId(dbInventoryRecord, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       inventoryRecordMapper.insert(cloneIgnoreId(dbInventoryRecord, o -> o.setSubjectId(null)));
       // 测试 userId 不匹配
       inventoryRecordMapper.insert(cloneIgnoreId(dbInventoryRecord, o -> o.setUserId(null)));
       // 测试 sourceId 不匹配
       inventoryRecordMapper.insert(cloneIgnoreId(dbInventoryRecord, o -> o.setSourceId(null)));
       // 准备参数
       StockInventoryRecordExportReqVO reqVO = new StockInventoryRecordExportReqVO();
       reqVO.setType(null);
       reqVO.setWarehouseId(null);
       reqVO.setWarehouseCode(null);
       reqVO.setWarehouseName(null);
       reqVO.setInventoryCode(null);
       reqVO.setOperationTime((new Date[]{}));
       reqVO.setHeadId(null);
       reqVO.setHeadName(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);
       reqVO.setUserId(null);
       reqVO.setSourceId(null);

       // 调用
       List<StockInventoryRecordDO> list = inventoryRecordService.getInventoryRecordList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbInventoryRecord, list.get(0));
    }

}
