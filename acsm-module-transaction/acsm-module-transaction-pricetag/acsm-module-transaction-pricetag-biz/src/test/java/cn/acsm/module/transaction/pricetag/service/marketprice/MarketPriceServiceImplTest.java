package cn.acsm.module.transaction.pricetag.service.marketprice;

import cn.acsm.module.transaction.pricetag.dal.dataobject.marketprice.MarketPriceInfoDO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.transaction.pricetag.controller.admin.marketprice.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketprice.MarketPriceDO;
import cn.acsm.module.transaction.pricetag.dal.mysql.marketprice.MarketPriceMapper;
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
* {@link MarketPriceServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(MarketPriceServiceImpl.class)
public class MarketPriceServiceImplTest extends BaseDbUnitTest {

    @Resource
    private MarketPriceServiceImpl marketPriceService;

    @Resource
    private MarketPriceMapper marketPriceMapper;

    @Test
    public void testCreateMarketPrice_success() {
        // 准备参数
        MarketPriceCreateReqVO reqVO = randomPojo(MarketPriceCreateReqVO.class);

        // 调用
        String marketPriceId = marketPriceService.createMarketPrice(reqVO);
        // 断言
        assertNotNull(marketPriceId);
        // 校验记录的属性是否正确
        MarketPriceDO marketPrice = marketPriceMapper.selectById(marketPriceId);
        assertPojoEquals(reqVO, marketPrice);
    }

    @Test
    public void testUpdateMarketPrice_success() {
        // mock 数据
        MarketPriceDO dbMarketPrice = randomPojo(MarketPriceDO.class);
        marketPriceMapper.insert(dbMarketPrice);// @Sql: 先插入出一条存在的数据
        // 准备参数
        MarketPriceUpdateReqVO reqVO = randomPojo(MarketPriceUpdateReqVO.class, o -> {
            o.setId(dbMarketPrice.getId()); // 设置更新的 ID
        });

        // 调用
        marketPriceService.updateMarketPrice(reqVO);
        // 校验是否更新正确
        MarketPriceDO marketPrice = marketPriceMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, marketPrice);
    }

    @Test
    public void testUpdateMarketPrice_notExists() {
        // 准备参数
        MarketPriceUpdateReqVO reqVO = randomPojo(MarketPriceUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> marketPriceService.updateMarketPrice(reqVO), MARKET_PRICE_NOT_EXISTS);
    }

    @Test
    public void testDeleteMarketPrice_success() {
        // mock 数据
        MarketPriceDO dbMarketPrice = randomPojo(MarketPriceDO.class);
        marketPriceMapper.insert(dbMarketPrice);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbMarketPrice.getId();

        // 调用
        marketPriceService.deleteMarketPrice(id);
       // 校验数据不存在了
       assertNull(marketPriceMapper.selectById(id));
    }

    @Test
    public void testDeleteMarketPrice_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> marketPriceService.deleteMarketPrice(id), MARKET_PRICE_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMarketPricePage() {
       // mock 数据
       MarketPriceDO dbMarketPrice = randomPojo(MarketPriceDO.class, o -> { // 等会查询到
           o.setCode(null);
           o.setMarketCommodityId(null);
           o.setMaxPrice(null);
           o.setMinPrice(null);
           o.setMiddlePrice(null);
           o.setSource(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
       });
       marketPriceMapper.insert(dbMarketPrice);
       // 测试 code 不匹配
       marketPriceMapper.insert(cloneIgnoreId(dbMarketPrice, o -> o.setCode(null)));
       // 测试 marketCommodityId 不匹配
       marketPriceMapper.insert(cloneIgnoreId(dbMarketPrice, o -> o.setMarketCommodityId(null)));
       // 测试 maxPrice 不匹配
       marketPriceMapper.insert(cloneIgnoreId(dbMarketPrice, o -> o.setMaxPrice(null)));
       // 测试 minPrice 不匹配
       marketPriceMapper.insert(cloneIgnoreId(dbMarketPrice, o -> o.setMinPrice(null)));
       // 测试 middlePrice 不匹配
       marketPriceMapper.insert(cloneIgnoreId(dbMarketPrice, o -> o.setMiddlePrice(null)));
       // 测试 source 不匹配
       marketPriceMapper.insert(cloneIgnoreId(dbMarketPrice, o -> o.setSource(null)));
       // 测试 status 不匹配
       marketPriceMapper.insert(cloneIgnoreId(dbMarketPrice, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       marketPriceMapper.insert(cloneIgnoreId(dbMarketPrice, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       marketPriceMapper.insert(cloneIgnoreId(dbMarketPrice, o -> o.setSubjectId(null)));
       // 准备参数
       MarketPricePageReqVO reqVO = new MarketPricePageReqVO();
       reqVO.setMarketCommodityId(null);
       reqVO.setUpdateTime((new Date[]{}));

       // 调用
       PageResult<MarketPriceInfoDO> pageResult = marketPriceService.getMarketPricePage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbMarketPrice, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMarketPriceList() {
       // mock 数据
       MarketPriceDO dbMarketPrice = randomPojo(MarketPriceDO.class, o -> { // 等会查询到
           o.setCode(null);
           o.setMarketCommodityId(null);
           o.setMaxPrice(null);
           o.setMinPrice(null);
           o.setMiddlePrice(null);
           o.setSource(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
       });
       marketPriceMapper.insert(dbMarketPrice);
       // 测试 code 不匹配
       marketPriceMapper.insert(cloneIgnoreId(dbMarketPrice, o -> o.setCode(null)));
       // 测试 marketCommodityId 不匹配
       marketPriceMapper.insert(cloneIgnoreId(dbMarketPrice, o -> o.setMarketCommodityId(null)));
       // 测试 maxPrice 不匹配
       marketPriceMapper.insert(cloneIgnoreId(dbMarketPrice, o -> o.setMaxPrice(null)));
       // 测试 minPrice 不匹配
       marketPriceMapper.insert(cloneIgnoreId(dbMarketPrice, o -> o.setMinPrice(null)));
       // 测试 middlePrice 不匹配
       marketPriceMapper.insert(cloneIgnoreId(dbMarketPrice, o -> o.setMiddlePrice(null)));
       // 测试 source 不匹配
       marketPriceMapper.insert(cloneIgnoreId(dbMarketPrice, o -> o.setSource(null)));
       // 测试 status 不匹配
       marketPriceMapper.insert(cloneIgnoreId(dbMarketPrice, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       marketPriceMapper.insert(cloneIgnoreId(dbMarketPrice, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       marketPriceMapper.insert(cloneIgnoreId(dbMarketPrice, o -> o.setSubjectId(null)));
       // 准备参数
       MarketPriceExportReqVO reqVO = new MarketPriceExportReqVO();
       reqVO.setCode(null);
       reqVO.setMarketCommodityId(null);
       reqVO.setMaxPrice(null);
       reqVO.setMinPrice(null);
       reqVO.setMiddlePrice(null);
       reqVO.setSource(null);
       reqVO.setStatus(null);
       reqVO.setUpdateTime((new Date[]{}));
       reqVO.setSubjectId(null);

       // 调用
       List<MarketPriceDO> list = marketPriceService.getMarketPriceList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbMarketPrice, list.get(0));
    }

}
