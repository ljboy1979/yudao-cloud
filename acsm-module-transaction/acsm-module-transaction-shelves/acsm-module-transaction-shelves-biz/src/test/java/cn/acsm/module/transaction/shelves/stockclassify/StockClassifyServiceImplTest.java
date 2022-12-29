package cn.acsm.module.transaction.shelves.stockclassify;

import cn.acsm.module.transaction.shelves.service.stockclassify.StockClassifyServiceImpl;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.transaction.shelves.controller.admin.stockclassify.vo.*;
import cn.acsm.module.transaction.shelves.dal.dataobject.stockclassify.StockClassifyDO;
import cn.acsm.module.transaction.shelves.dal.mysql.stockclassify.StockClassifyMapper;
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
* {@link StockClassifyServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(StockClassifyServiceImpl.class)
public class StockClassifyServiceImplTest extends BaseDbUnitTest {

    @Resource
    private StockClassifyServiceImpl stockClassifyService;

    @Resource
    private StockClassifyMapper stockClassifyMapper;

    @Test
    public void testCreateStockClassify_success() {
        // 准备参数
        StockClassifyCreateReqVO reqVO = randomPojo(StockClassifyCreateReqVO.class);

        // 调用
        CommonResult result = stockClassifyService.createStockClassify(reqVO);
        // 断言
        assertNotNull(result.getData());
        // 校验记录的属性是否正确
        StockClassifyDO stockClassify = stockClassifyMapper.selectById(result.getData().toString());
        assertPojoEquals(reqVO, stockClassify);
    }

    @Test
    public void testUpdateStockClassify_success() {
        // mock 数据
        StockClassifyDO dbStockClassify = randomPojo(StockClassifyDO.class);
        stockClassifyMapper.insert(dbStockClassify);// @Sql: 先插入出一条存在的数据
        // 准备参数
        StockClassifyUpdateReqVO reqVO = randomPojo(StockClassifyUpdateReqVO.class, o -> {
            o.setId(dbStockClassify.getId()); // 设置更新的 ID
        });

        // 调用
        stockClassifyService.updateStockClassify(reqVO);
        // 校验是否更新正确
        StockClassifyDO stockClassify = stockClassifyMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, stockClassify);
    }

    @Test
    public void testUpdateStockClassify_notExists() {
        // 准备参数
        StockClassifyUpdateReqVO reqVO = randomPojo(StockClassifyUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> stockClassifyService.updateStockClassify(reqVO), STOCK_CLASSIFY_NOT_EXISTS);
    }

    @Test
    public void testDeleteStockClassify_success() {
        // mock 数据
        StockClassifyDO dbStockClassify = randomPojo(StockClassifyDO.class);
        stockClassifyMapper.insert(dbStockClassify);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbStockClassify.getId();

        // 调用
        stockClassifyService.deleteStockClassify(id);
       // 校验数据不存在了
       assertNull(stockClassifyMapper.selectById(id));
    }

    @Test
    public void testDeleteStockClassify_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> stockClassifyService.deleteStockClassify(id), STOCK_CLASSIFY_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetStockClassifyPage() {
       // mock 数据
       StockClassifyDO dbStockClassify = randomPojo(StockClassifyDO.class, o -> { // 等会查询到
           o.setClassifyName(null);
           o.setCreateTime(null);
       });
       stockClassifyMapper.insert(dbStockClassify);
       // 测试 classifyName 不匹配
       stockClassifyMapper.insert(cloneIgnoreId(dbStockClassify, o -> o.setClassifyName(null)));
       // 测试 createTime 不匹配
       stockClassifyMapper.insert(cloneIgnoreId(dbStockClassify, o -> o.setCreateTime(null)));
       // 准备参数
       StockClassifyPageReqVO reqVO = new StockClassifyPageReqVO();
       reqVO.setClassifyName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<StockClassifyDO> pageResult = stockClassifyService.getStockClassifyPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbStockClassify, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetStockClassifyList() {
       // mock 数据
       StockClassifyDO dbStockClassify = randomPojo(StockClassifyDO.class, o -> { // 等会查询到
           o.setClassifyName(null);
           o.setCreateTime(null);
       });
       stockClassifyMapper.insert(dbStockClassify);
       // 测试 classifyName 不匹配
       stockClassifyMapper.insert(cloneIgnoreId(dbStockClassify, o -> o.setClassifyName(null)));
       // 测试 createTime 不匹配
       stockClassifyMapper.insert(cloneIgnoreId(dbStockClassify, o -> o.setCreateTime(null)));
       // 准备参数
       StockClassifyExportReqVO reqVO = new StockClassifyExportReqVO();
       reqVO.setClassifyName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<StockClassifyDO> list = stockClassifyService.getStockClassifyList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbStockClassify, list.get(0));
    }

}
