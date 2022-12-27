package cn.acsm.module.transaction.pricetag.service.scheduledprice;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.transaction.pricetag.controller.admin.scheduledprice.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.scheduledprice.ScheduledPriceDO;
import cn.acsm.module.transaction.pricetag.dal.mysql.scheduledprice.ScheduledPriceMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.acsm.module.transaction.pricetag.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link ScheduledPriceServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(ScheduledPriceServiceImpl.class)
public class ScheduledPriceServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ScheduledPriceServiceImpl scheduledPriceService;

    @Resource
    private ScheduledPriceMapper scheduledPriceMapper;

    @Test
    public void testCreateScheduledPrice_success() {
        // 准备参数
        ScheduledPriceCreateReqVO reqVO = randomPojo(ScheduledPriceCreateReqVO.class);

        // 调用
        String scheduledPriceId = scheduledPriceService.createScheduledPrice(reqVO);
        // 断言
        assertNotNull(scheduledPriceId);
        // 校验记录的属性是否正确
        ScheduledPriceDO scheduledPrice = scheduledPriceMapper.selectById(scheduledPriceId);
        assertPojoEquals(reqVO, scheduledPrice);
    }

    @Test
    public void testUpdateScheduledPrice_success() {
        // mock 数据
        ScheduledPriceDO dbScheduledPrice = randomPojo(ScheduledPriceDO.class);
        scheduledPriceMapper.insert(dbScheduledPrice);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ScheduledPriceUpdateReqVO reqVO = randomPojo(ScheduledPriceUpdateReqVO.class, o -> {
            o.setId(dbScheduledPrice.getId()); // 设置更新的 ID
        });

        // 调用
        scheduledPriceService.updateScheduledPrice(reqVO);
        // 校验是否更新正确
        ScheduledPriceDO scheduledPrice = scheduledPriceMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, scheduledPrice);
    }

    @Test
    public void testUpdateScheduledPrice_notExists() {
        // 准备参数
        ScheduledPriceUpdateReqVO reqVO = randomPojo(ScheduledPriceUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> scheduledPriceService.updateScheduledPrice(reqVO), SCHEDULED_PRICE_NOT_EXISTS);
    }

    @Test
    public void testDeleteScheduledPrice_success() {
        // mock 数据
        ScheduledPriceDO dbScheduledPrice = randomPojo(ScheduledPriceDO.class);
        scheduledPriceMapper.insert(dbScheduledPrice);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbScheduledPrice.getId();

        // 调用
        scheduledPriceService.deleteScheduledPrice(id);
       // 校验数据不存在了
       assertNull(scheduledPriceMapper.selectById(id));
    }

    @Test
    public void testDeleteScheduledPrice_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> scheduledPriceService.deleteScheduledPrice(id), SCHEDULED_PRICE_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetScheduledPricePage() {
       // mock 数据
       ScheduledPriceDO dbScheduledPrice = randomPojo(ScheduledPriceDO.class, o -> { // 等会查询到
           o.setCommodityName(null);
           o.setCreateTime(null);
       });
       scheduledPriceMapper.insert(dbScheduledPrice);
       // 测试 commodityName 不匹配
       scheduledPriceMapper.insert(cloneIgnoreId(dbScheduledPrice, o -> o.setCommodityName(null)));
       // 测试 createTime 不匹配
       scheduledPriceMapper.insert(cloneIgnoreId(dbScheduledPrice, o -> o.setCreateTime(null)));
       // 准备参数
       ScheduledPricePageReqVO reqVO = new ScheduledPricePageReqVO();
       reqVO.setCommodityName(null);
       reqVO.setUpdateTime((new Date[]{}));

       // 调用
       PageResult<ScheduledPriceDO> pageResult = scheduledPriceService.getScheduledPricePage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbScheduledPrice, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetScheduledPriceList() {
       // mock 数据
       ScheduledPriceDO dbScheduledPrice = randomPojo(ScheduledPriceDO.class, o -> { // 等会查询到
           o.setCommodityName(null);
           o.setCreateTime(null);
       });
       scheduledPriceMapper.insert(dbScheduledPrice);
       // 测试 commodityName 不匹配
       scheduledPriceMapper.insert(cloneIgnoreId(dbScheduledPrice, o -> o.setCommodityName(null)));
       // 测试 createTime 不匹配
       scheduledPriceMapper.insert(cloneIgnoreId(dbScheduledPrice, o -> o.setCreateTime(null)));
       // 准备参数
       ScheduledPriceExportReqVO reqVO = new ScheduledPriceExportReqVO();
       reqVO.setCommodityName(null);
       reqVO.setUpdateTime((new Date[]{}));

       // 调用
       List<ScheduledPriceDO> list = scheduledPriceService.getScheduledPriceList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbScheduledPrice, list.get(0));
    }

}
