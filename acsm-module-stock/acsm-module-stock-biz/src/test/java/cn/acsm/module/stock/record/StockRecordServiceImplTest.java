package cn.acsm.module.stock.record;

import cn.acsm.module.stock.controller.admin.record.vo.StockRecordCreateReqVO;
import cn.acsm.module.stock.controller.admin.record.vo.StockRecordExportReqVO;
import cn.acsm.module.stock.controller.admin.record.vo.StockRecordPageReqVO;
import cn.acsm.module.stock.controller.admin.record.vo.StockRecordUpdateReqVO;
import cn.acsm.module.stock.dal.dataobject.record.StockRecordDO;
import cn.acsm.module.stock.dal.mysql.record.StockRecordMapper;
import cn.acsm.module.stock.service.record.StockRecordServiceImpl;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static cn.acsm.module.stock.enums.ErrorCodeConstants.RECORD_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.cloneIgnoreId;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link StockRecordServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(StockRecordServiceImpl.class)
public class StockRecordServiceImplTest extends BaseDbUnitTest {

    @Resource
    private StockRecordServiceImpl recordService;

    @Resource
    private StockRecordMapper recordMapper;

    @Test
    public void testCreateRecord_success() {
        // 准备参数
        StockRecordCreateReqVO reqVO = randomPojo(StockRecordCreateReqVO.class);

        // 调用
        Long recordId = recordService.createRecordIssue(reqVO);
        // 断言
        assertNotNull(recordId);
        // 校验记录的属性是否正确
        StockRecordDO record = recordMapper.selectById(recordId);
        assertPojoEquals(reqVO, record);
    }

    @Test
    public void testUpdateRecord_success() {
        // mock 数据
        StockRecordDO dbRecord = randomPojo(StockRecordDO.class);
        recordMapper.insert(dbRecord);// @Sql: 先插入出一条存在的数据
        // 准备参数
        StockRecordUpdateReqVO reqVO = randomPojo(StockRecordUpdateReqVO.class, o -> {
            o.setId(dbRecord.getId()); // 设置更新的 ID
        });

        // 调用
        recordService.updateRecord(reqVO);
        // 校验是否更新正确
        StockRecordDO record = recordMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, record);
    }

    @Test
    public void testUpdateRecord_notExists() {
        // 准备参数
        StockRecordUpdateReqVO reqVO = randomPojo(StockRecordUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> recordService.updateRecord(reqVO), RECORD_NOT_EXISTS);
    }

    @Test
    public void testDeleteRecord_success() {
        // mock 数据
        StockRecordDO dbRecord = randomPojo(StockRecordDO.class);
        recordMapper.insert(dbRecord);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbRecord.getId();

        // 调用
        recordService.deleteRecord(id);
       // 校验数据不存在了
       assertNull(recordMapper.selectById(id));
    }

    @Test
    public void testDeleteRecord_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> recordService.deleteRecord(id), RECORD_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetRecordPage() {
       // mock 数据
       StockRecordDO dbRecord = randomPojo(StockRecordDO.class, o -> { // 等会查询到
           o.setType(null);
           o.setOperationType(null);
           o.setWarehouseId(null);
           o.setWarehouseCode(null);
           o.setWarehouseName(null);
           o.setBatchNo(null);
           o.setOperationTime(null);
           o.setHeadId(null);
           o.setHeadName(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
           o.setUserId(null);
           o.setSourceId(null);
       });
       recordMapper.insert(dbRecord);
       // 测试 type 不匹配
       recordMapper.insert(cloneIgnoreId(dbRecord, o -> o.setType(null)));
       // 测试 operationType 不匹配
       recordMapper.insert(cloneIgnoreId(dbRecord, o -> o.setOperationType(null)));
       // 测试 warehouseId 不匹配
       recordMapper.insert(cloneIgnoreId(dbRecord, o -> o.setWarehouseId(null)));
       // 测试 warehouseCode 不匹配
       recordMapper.insert(cloneIgnoreId(dbRecord, o -> o.setWarehouseCode(null)));
       // 测试 warehouseName 不匹配
       recordMapper.insert(cloneIgnoreId(dbRecord, o -> o.setWarehouseName(null)));
       // 测试 batchNo 不匹配
       recordMapper.insert(cloneIgnoreId(dbRecord, o -> o.setBatchNo(null)));
       // 测试 operationTime 不匹配
       recordMapper.insert(cloneIgnoreId(dbRecord, o -> o.setOperationTime(null)));
       // 测试 headId 不匹配
       recordMapper.insert(cloneIgnoreId(dbRecord, o -> o.setHeadId(null)));
       // 测试 headName 不匹配
       recordMapper.insert(cloneIgnoreId(dbRecord, o -> o.setHeadName(null)));
       // 测试 createTime 不匹配
       recordMapper.insert(cloneIgnoreId(dbRecord, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       recordMapper.insert(cloneIgnoreId(dbRecord, o -> o.setSubjectId(null)));
       // 测试 userId 不匹配
       recordMapper.insert(cloneIgnoreId(dbRecord, o -> o.setUserId(null)));
       // 测试 sourceId 不匹配
       recordMapper.insert(cloneIgnoreId(dbRecord, o -> o.setSourceId(null)));
       // 准备参数
       StockRecordPageReqVO reqVO = new StockRecordPageReqVO();
       reqVO.setType(null);
       reqVO.setOperationType(null);
       reqVO.setWarehouseId(null);
       reqVO.setWarehouseCode(null);
       reqVO.setWarehouseName(null);
       reqVO.setBatchNo(null);
       reqVO.setOperationTime((new Date[]{}));
       reqVO.setHeadId(null);
       reqVO.setHeadName(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);
       reqVO.setUserId(null);
       reqVO.setSourceId(null);

       // 调用
       PageResult<StockRecordDO> pageResult = recordService.getRecordPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbRecord, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetRecordList() {
       // mock 数据
       StockRecordDO dbRecord = randomPojo(StockRecordDO.class, o -> { // 等会查询到
           o.setType(null);
           o.setOperationType(null);
           o.setWarehouseId(null);
           o.setWarehouseCode(null);
           o.setWarehouseName(null);
           o.setBatchNo(null);
           o.setOperationTime(null);
           o.setHeadId(null);
           o.setHeadName(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
           o.setUserId(null);
           o.setSourceId(null);
       });
       recordMapper.insert(dbRecord);
       // 测试 type 不匹配
       recordMapper.insert(cloneIgnoreId(dbRecord, o -> o.setType(null)));
       // 测试 operationType 不匹配
       recordMapper.insert(cloneIgnoreId(dbRecord, o -> o.setOperationType(null)));
       // 测试 warehouseId 不匹配
       recordMapper.insert(cloneIgnoreId(dbRecord, o -> o.setWarehouseId(null)));
       // 测试 warehouseCode 不匹配
       recordMapper.insert(cloneIgnoreId(dbRecord, o -> o.setWarehouseCode(null)));
       // 测试 warehouseName 不匹配
       recordMapper.insert(cloneIgnoreId(dbRecord, o -> o.setWarehouseName(null)));
       // 测试 batchNo 不匹配
       recordMapper.insert(cloneIgnoreId(dbRecord, o -> o.setBatchNo(null)));
       // 测试 operationTime 不匹配
       recordMapper.insert(cloneIgnoreId(dbRecord, o -> o.setOperationTime(null)));
       // 测试 headId 不匹配
       recordMapper.insert(cloneIgnoreId(dbRecord, o -> o.setHeadId(null)));
       // 测试 headName 不匹配
       recordMapper.insert(cloneIgnoreId(dbRecord, o -> o.setHeadName(null)));
       // 测试 createTime 不匹配
       recordMapper.insert(cloneIgnoreId(dbRecord, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       recordMapper.insert(cloneIgnoreId(dbRecord, o -> o.setSubjectId(null)));
       // 测试 userId 不匹配
       recordMapper.insert(cloneIgnoreId(dbRecord, o -> o.setUserId(null)));
       // 测试 sourceId 不匹配
       recordMapper.insert(cloneIgnoreId(dbRecord, o -> o.setSourceId(null)));
       // 准备参数
       StockRecordExportReqVO reqVO = new StockRecordExportReqVO();
       reqVO.setType(null);
       reqVO.setOperationType(null);
       reqVO.setWarehouseId(null);
       reqVO.setWarehouseCode(null);
       reqVO.setWarehouseName(null);
       reqVO.setBatchNo(null);
       reqVO.setOperationTime((new Date[]{}));
       reqVO.setHeadId(null);
       reqVO.setHeadName(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);
       reqVO.setUserId(null);
       reqVO.setSourceId(null);

       // 调用
       List<StockRecordDO> list = recordService.getRecordList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbRecord, list.get(0));
    }

}
