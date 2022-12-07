package cn.acsm.module.transaction.shelves.stockrecord;

import cn.acsm.module.transaction.shelves.service.stockrecord.StockRecordServiceImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.transaction.shelves.controller.admin.stockrecord.vo.*;
import cn.acsm.module.transaction.shelves.dal.dataobject.stockrecord.StockRecordDO;
import cn.acsm.module.transaction.shelves.dal.mysql.stockrecord.StockRecordMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.acsm.module.transaction.shelves.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link StockRecordServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(StockRecordServiceImpl.class)
public class StockRecordServiceImplTest extends BaseDbUnitTest {

    @Resource
    private StockRecordServiceImpl stockRecordService;

    @Resource
    private StockRecordMapper stockRecordMapper;

    @Test
    public void testCreateStockRecord_success() {
        // 准备参数
        StockRecordCreateReqVO reqVO = randomPojo(StockRecordCreateReqVO.class);

        // 调用
        String stockRecordId = stockRecordService.createStockRecord(reqVO);
        // 断言
        assertNotNull(stockRecordId);
        // 校验记录的属性是否正确
        StockRecordDO stockRecord = stockRecordMapper.selectById(stockRecordId);
        assertPojoEquals(reqVO, stockRecord);
    }

    @Test
    public void testUpdateStockRecord_success() {
        // mock 数据
        StockRecordDO dbStockRecord = randomPojo(StockRecordDO.class);
        stockRecordMapper.insert(dbStockRecord);// @Sql: 先插入出一条存在的数据
        // 准备参数
        StockRecordUpdateReqVO reqVO = randomPojo(StockRecordUpdateReqVO.class, o -> {
            o.setId(dbStockRecord.getId()); // 设置更新的 ID
        });

        // 调用
        stockRecordService.updateStockRecord(reqVO);
        // 校验是否更新正确
        StockRecordDO stockRecord = stockRecordMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, stockRecord);
    }

    @Test
    public void testUpdateStockRecord_notExists() {
        // 准备参数
        StockRecordUpdateReqVO reqVO = randomPojo(StockRecordUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> stockRecordService.updateStockRecord(reqVO), STOCK_RECORD_NOT_EXISTS);
    }

    @Test
    public void testDeleteStockRecord_success() {
        // mock 数据
        StockRecordDO dbStockRecord = randomPojo(StockRecordDO.class);
        stockRecordMapper.insert(dbStockRecord);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbStockRecord.getId();

        // 调用
        stockRecordService.deleteStockRecord(id);
       // 校验数据不存在了
       assertNull(stockRecordMapper.selectById(id));
    }

    @Test
    public void testDeleteStockRecord_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> stockRecordService.deleteStockRecord(id), STOCK_RECORD_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetStockRecordPage() {
       // mock 数据
       StockRecordDO dbStockRecord = randomPojo(StockRecordDO.class, o -> { // 等会查询到
           o.setSpecificationsId(null);
           o.setType(null);
           o.setAmount(null);
           o.setRemark(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
           o.setSource(null);
       });
       stockRecordMapper.insert(dbStockRecord);
       // 测试 specificationsId 不匹配
       stockRecordMapper.insert(cloneIgnoreId(dbStockRecord, o -> o.setSpecificationsId(null)));
       // 测试 type 不匹配
       stockRecordMapper.insert(cloneIgnoreId(dbStockRecord, o -> o.setType(null)));
       // 测试 amount 不匹配
       stockRecordMapper.insert(cloneIgnoreId(dbStockRecord, o -> o.setAmount(null)));
       // 测试 remark 不匹配
       stockRecordMapper.insert(cloneIgnoreId(dbStockRecord, o -> o.setRemark(null)));
       // 测试 status 不匹配
       stockRecordMapper.insert(cloneIgnoreId(dbStockRecord, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       stockRecordMapper.insert(cloneIgnoreId(dbStockRecord, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       stockRecordMapper.insert(cloneIgnoreId(dbStockRecord, o -> o.setSubjectId(null)));
       // 测试 source 不匹配
       stockRecordMapper.insert(cloneIgnoreId(dbStockRecord, o -> o.setSource(null)));
       // 准备参数
       StockRecordPageReqVO reqVO = new StockRecordPageReqVO();
       reqVO.setSpecificationsId(null);
       reqVO.setType(null);
       reqVO.setAmount(null);
       reqVO.setRemark(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);
       reqVO.setSource(null);

       // 调用
       PageResult<StockRecordDO> pageResult = stockRecordService.getStockRecordPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbStockRecord, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetStockRecordList() {
       // mock 数据
       StockRecordDO dbStockRecord = randomPojo(StockRecordDO.class, o -> { // 等会查询到
           o.setSpecificationsId(null);
           o.setType(null);
           o.setAmount(null);
           o.setRemark(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
           o.setSource(null);
       });
       stockRecordMapper.insert(dbStockRecord);
       // 测试 specificationsId 不匹配
       stockRecordMapper.insert(cloneIgnoreId(dbStockRecord, o -> o.setSpecificationsId(null)));
       // 测试 type 不匹配
       stockRecordMapper.insert(cloneIgnoreId(dbStockRecord, o -> o.setType(null)));
       // 测试 amount 不匹配
       stockRecordMapper.insert(cloneIgnoreId(dbStockRecord, o -> o.setAmount(null)));
       // 测试 remark 不匹配
       stockRecordMapper.insert(cloneIgnoreId(dbStockRecord, o -> o.setRemark(null)));
       // 测试 status 不匹配
       stockRecordMapper.insert(cloneIgnoreId(dbStockRecord, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       stockRecordMapper.insert(cloneIgnoreId(dbStockRecord, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       stockRecordMapper.insert(cloneIgnoreId(dbStockRecord, o -> o.setSubjectId(null)));
       // 测试 source 不匹配
       stockRecordMapper.insert(cloneIgnoreId(dbStockRecord, o -> o.setSource(null)));
       // 准备参数
       StockRecordExportReqVO reqVO = new StockRecordExportReqVO();
       reqVO.setSpecificationsId(null);
       reqVO.setType(null);
       reqVO.setAmount(null);
       reqVO.setRemark(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);
       reqVO.setSource(null);

       // 调用
       List<StockRecordDO> list = stockRecordService.getStockRecordList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbStockRecord, list.get(0));
    }

}
