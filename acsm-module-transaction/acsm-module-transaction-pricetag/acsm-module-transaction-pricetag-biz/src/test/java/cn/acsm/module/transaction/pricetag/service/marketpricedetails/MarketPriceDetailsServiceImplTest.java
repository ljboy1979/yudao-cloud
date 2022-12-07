package cn.acsm.module.transaction.pricetag.service.marketpricedetails;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.transaction.pricetag.controller.admin.marketpricedetails.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketpricedetails.MarketPriceDetailsDO;
import cn.acsm.module.transaction.pricetag.dal.mysql.marketpricedetails.MarketPriceDetailsMapper;
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
* {@link MarketPriceDetailsServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(MarketPriceDetailsServiceImpl.class)
public class MarketPriceDetailsServiceImplTest extends BaseDbUnitTest {

    @Resource
    private MarketPriceDetailsServiceImpl marketPriceDetailsService;

    @Resource
    private MarketPriceDetailsMapper marketPriceDetailsMapper;

    @Test
    public void testCreateMarketPriceDetails_success() {
        // 准备参数
        MarketPriceDetailsCreateReqVO reqVO = randomPojo(MarketPriceDetailsCreateReqVO.class);

        // 调用
        String marketPriceDetailsId = marketPriceDetailsService.createMarketPriceDetails(reqVO);
        // 断言
        assertNotNull(marketPriceDetailsId);
        // 校验记录的属性是否正确
        MarketPriceDetailsDO marketPriceDetails = marketPriceDetailsMapper.selectById(marketPriceDetailsId);
        assertPojoEquals(reqVO, marketPriceDetails);
    }

    @Test
    public void testUpdateMarketPriceDetails_success() {
        // mock 数据
        MarketPriceDetailsDO dbMarketPriceDetails = randomPojo(MarketPriceDetailsDO.class);
        marketPriceDetailsMapper.insert(dbMarketPriceDetails);// @Sql: 先插入出一条存在的数据
        // 准备参数
        MarketPriceDetailsUpdateReqVO reqVO = randomPojo(MarketPriceDetailsUpdateReqVO.class, o -> {
            o.setId(dbMarketPriceDetails.getId()); // 设置更新的 ID
        });

        // 调用
        marketPriceDetailsService.updateMarketPriceDetails(reqVO);
        // 校验是否更新正确
        MarketPriceDetailsDO marketPriceDetails = marketPriceDetailsMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, marketPriceDetails);
    }

    @Test
    public void testUpdateMarketPriceDetails_notExists() {
        // 准备参数
        MarketPriceDetailsUpdateReqVO reqVO = randomPojo(MarketPriceDetailsUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> marketPriceDetailsService.updateMarketPriceDetails(reqVO), MARKET_PRICE_DETAILS_NOT_EXISTS);
    }

    @Test
    public void testDeleteMarketPriceDetails_success() {
        // mock 数据
        MarketPriceDetailsDO dbMarketPriceDetails = randomPojo(MarketPriceDetailsDO.class);
        marketPriceDetailsMapper.insert(dbMarketPriceDetails);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbMarketPriceDetails.getId();

        // 调用
        marketPriceDetailsService.deleteMarketPriceDetails(id);
       // 校验数据不存在了
       assertNull(marketPriceDetailsMapper.selectById(id));
    }

    @Test
    public void testDeleteMarketPriceDetails_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> marketPriceDetailsService.deleteMarketPriceDetails(id), MARKET_PRICE_DETAILS_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMarketPriceDetailsPage() {
       // mock 数据
       MarketPriceDetailsDO dbMarketPriceDetails = randomPojo(MarketPriceDetailsDO.class, o -> { // 等会查询到
           o.setMarketPriceId(null);
           o.setCreateTime(null);
       });
       marketPriceDetailsMapper.insert(dbMarketPriceDetails);
       // 测试 marketPriceId 不匹配
       marketPriceDetailsMapper.insert(cloneIgnoreId(dbMarketPriceDetails, o -> o.setMarketPriceId(null)));
       // 测试 createTime 不匹配
       marketPriceDetailsMapper.insert(cloneIgnoreId(dbMarketPriceDetails, o -> o.setCreateTime(null)));
       // 准备参数
       MarketPriceDetailsPageReqVO reqVO = new MarketPriceDetailsPageReqVO();
       reqVO.setMarketPriceId(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<MarketPriceDetailsDO> pageResult = marketPriceDetailsService.getMarketPriceDetailsPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbMarketPriceDetails, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMarketPriceDetailsList() {
       // mock 数据
       MarketPriceDetailsDO dbMarketPriceDetails = randomPojo(MarketPriceDetailsDO.class, o -> { // 等会查询到
           o.setMarketPriceId(null);
           o.setCreateTime(null);
       });
       marketPriceDetailsMapper.insert(dbMarketPriceDetails);
       // 测试 marketPriceId 不匹配
       marketPriceDetailsMapper.insert(cloneIgnoreId(dbMarketPriceDetails, o -> o.setMarketPriceId(null)));
       // 测试 createTime 不匹配
       marketPriceDetailsMapper.insert(cloneIgnoreId(dbMarketPriceDetails, o -> o.setCreateTime(null)));
       // 准备参数
       MarketPriceDetailsExportReqVO reqVO = new MarketPriceDetailsExportReqVO();
       reqVO.setMarketPriceId(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<MarketPriceDetailsDO> list = marketPriceDetailsService.getMarketPriceDetailsList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbMarketPriceDetails, list.get(0));
    }

}
