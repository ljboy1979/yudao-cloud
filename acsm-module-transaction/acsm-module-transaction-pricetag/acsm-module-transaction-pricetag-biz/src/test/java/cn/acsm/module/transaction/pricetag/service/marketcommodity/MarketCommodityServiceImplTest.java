package cn.acsm.module.transaction.pricetag.service.marketcommodity;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.transaction.pricetag.controller.admin.marketcommodity.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketcommodity.MarketCommodityDO;
import cn.acsm.module.transaction.pricetag.dal.mysql.marketcommodity.*;
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
* {@link MarketCommodityServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(MarketCommodityServiceImpl.class)
public class MarketCommodityServiceImplTest extends BaseDbUnitTest {

    @Resource
    private MarketCommodityServiceImpl marketCommodityService;

    @Resource
    private MarketCommodityMapper marketCommodityMapper;

    @Test
    public void testCreateMarketCommodity_success() {
        // 准备参数
        MarketCommodityCreateReqVO reqVO = randomPojo(MarketCommodityCreateReqVO.class);

        // 调用
        String marketCommodityId = marketCommodityService.createMarketCommodity(reqVO);
        // 断言
        assertNotNull(marketCommodityId);
        // 校验记录的属性是否正确
        MarketCommodityDO marketCommodity = marketCommodityMapper.selectById(marketCommodityId);
        assertPojoEquals(reqVO, marketCommodity);
    }

    @Test
    public void testUpdateMarketCommodity_success() {
        // mock 数据
        MarketCommodityDO dbMarketCommodity = randomPojo(MarketCommodityDO.class);
        marketCommodityMapper.insert(dbMarketCommodity);// @Sql: 先插入出一条存在的数据
        // 准备参数
        MarketCommodityUpdateReqVO reqVO = randomPojo(MarketCommodityUpdateReqVO.class, o -> {
            o.setId(dbMarketCommodity.getId()); // 设置更新的 ID
        });

        // 调用
        marketCommodityService.updateMarketCommodity(reqVO);
        // 校验是否更新正确
        MarketCommodityDO marketCommodity = marketCommodityMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, marketCommodity);
    }

    @Test
    public void testUpdateMarketCommodity_notExists() {
        // 准备参数
        MarketCommodityUpdateReqVO reqVO = randomPojo(MarketCommodityUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> marketCommodityService.updateMarketCommodity(reqVO), MARKET_COMMODITY_NOT_EXISTS);
    }

    @Test
    public void testDeleteMarketCommodity_success() {
        // mock 数据
        MarketCommodityDO dbMarketCommodity = randomPojo(MarketCommodityDO.class);
        marketCommodityMapper.insert(dbMarketCommodity);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbMarketCommodity.getId();

        // 调用
        marketCommodityService.deleteMarketCommodity(id);
       // 校验数据不存在了
       assertNull(marketCommodityMapper.selectById(id));
    }

    @Test
    public void testDeleteMarketCommodity_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> marketCommodityService.deleteMarketCommodity(id), MARKET_COMMODITY_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMarketCommodityPage() {
       // mock 数据
       MarketCommodityDO dbMarketCommodity = randomPojo(MarketCommodityDO.class, o -> { // 等会查询到
           o.setShelvesId(null);
           o.setSpecificationId(null);
           o.setCommodityName(null);
           o.setSpecificationsName(null);
           o.setCreateTime(null);
       });
       marketCommodityMapper.insert(dbMarketCommodity);
       // 测试 shelvesId 不匹配
       marketCommodityMapper.insert(cloneIgnoreId(dbMarketCommodity, o -> o.setShelvesId(null)));
       // 测试 specificationId 不匹配
       marketCommodityMapper.insert(cloneIgnoreId(dbMarketCommodity, o -> o.setSpecificationId(null)));
       // 测试 commodityName 不匹配
       marketCommodityMapper.insert(cloneIgnoreId(dbMarketCommodity, o -> o.setCommodityName(null)));
       // 测试 specificationsName 不匹配
       marketCommodityMapper.insert(cloneIgnoreId(dbMarketCommodity, o -> o.setSpecificationsName(null)));
       // 测试 createTime 不匹配
       marketCommodityMapper.insert(cloneIgnoreId(dbMarketCommodity, o -> o.setCreateTime(null)));
       // 准备参数
       MarketCommodityPageReqVO reqVO = new MarketCommodityPageReqVO();
       reqVO.setShelvesId(null);
       reqVO.setSpecificationId(null);
       reqVO.setCommodityName(null);
       reqVO.setSpecificationsName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<MarketCommodityDO> pageResult = marketCommodityService.getMarketCommodityPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbMarketCommodity, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMarketCommodityList() {
       // mock 数据
       MarketCommodityDO dbMarketCommodity = randomPojo(MarketCommodityDO.class, o -> { // 等会查询到
           o.setShelvesId(null);
           o.setSpecificationId(null);
           o.setCommodityName(null);
           o.setSpecificationsName(null);
           o.setCreateTime(null);
       });
       marketCommodityMapper.insert(dbMarketCommodity);
       // 测试 shelvesId 不匹配
       marketCommodityMapper.insert(cloneIgnoreId(dbMarketCommodity, o -> o.setShelvesId(null)));
       // 测试 specificationId 不匹配
       marketCommodityMapper.insert(cloneIgnoreId(dbMarketCommodity, o -> o.setSpecificationId(null)));
       // 测试 commodityName 不匹配
       marketCommodityMapper.insert(cloneIgnoreId(dbMarketCommodity, o -> o.setCommodityName(null)));
       // 测试 specificationsName 不匹配
       marketCommodityMapper.insert(cloneIgnoreId(dbMarketCommodity, o -> o.setSpecificationsName(null)));
       // 测试 createTime 不匹配
       marketCommodityMapper.insert(cloneIgnoreId(dbMarketCommodity, o -> o.setCreateTime(null)));
       // 准备参数
       MarketCommodityExportReqVO reqVO = new MarketCommodityExportReqVO();
       reqVO.setShelvesId(null);
       reqVO.setSpecificationId(null);
       reqVO.setCommodityName(null);
       reqVO.setSpecificationsName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<MarketCommodityDO> list = marketCommodityService.getMarketCommodityList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbMarketCommodity, list.get(0));
    }

}
