package cn.acsm.module.transaction.pricetag.service.marketclassify;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.transaction.pricetag.controller.admin.marketclassify.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketclassify.MarketClassifyDO;
import cn.acsm.module.transaction.pricetag.dal.mysql.marketclassify.MarketClassifyMapper;
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
* {@link MarketClassifyServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(MarketClassifyServiceImpl.class)
public class MarketClassifyServiceImplTest extends BaseDbUnitTest {

    @Resource
    private MarketClassifyServiceImpl marketClassifyService;

    @Resource
    private MarketClassifyMapper marketClassifyMapper;

    @Test
    public void testCreateMarketClassify_success() {
        // 准备参数
        MarketClassifyCreateReqVO reqVO = randomPojo(MarketClassifyCreateReqVO.class);

        // 调用
        String marketClassifyId = marketClassifyService.createMarketClassify(reqVO);
        // 断言
        assertNotNull(marketClassifyId);
        // 校验记录的属性是否正确
        MarketClassifyDO marketClassify = marketClassifyMapper.selectById(marketClassifyId);
        assertPojoEquals(reqVO, marketClassify);
    }

    @Test
    public void testUpdateMarketClassify_success() {
        // mock 数据
        MarketClassifyDO dbMarketClassify = randomPojo(MarketClassifyDO.class);
        marketClassifyMapper.insert(dbMarketClassify);// @Sql: 先插入出一条存在的数据
        // 准备参数
        MarketClassifyUpdateReqVO reqVO = randomPojo(MarketClassifyUpdateReqVO.class, o -> {
            o.setId(dbMarketClassify.getId()); // 设置更新的 ID
        });

        // 调用
        marketClassifyService.updateMarketClassify(reqVO);
        // 校验是否更新正确
        MarketClassifyDO marketClassify = marketClassifyMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, marketClassify);
    }

    @Test
    public void testUpdateMarketClassify_notExists() {
        // 准备参数
        MarketClassifyUpdateReqVO reqVO = randomPojo(MarketClassifyUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> marketClassifyService.updateMarketClassify(reqVO), MARKET_CLASSIFY_NOT_EXISTS);
    }

    @Test
    public void testDeleteMarketClassify_success() {
        // mock 数据
        MarketClassifyDO dbMarketClassify = randomPojo(MarketClassifyDO.class);
        marketClassifyMapper.insert(dbMarketClassify);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbMarketClassify.getId();

        // 调用
        marketClassifyService.deleteMarketClassify(id);
       // 校验数据不存在了
       assertNull(marketClassifyMapper.selectById(id));
    }

    @Test
    public void testDeleteMarketClassify_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> marketClassifyService.deleteMarketClassify(id), MARKET_CLASSIFY_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMarketClassifyPage() {
       // mock 数据
       MarketClassifyDO dbMarketClassify = randomPojo(MarketClassifyDO.class, o -> { // 等会查询到
           o.setCategoryName(null);
           o.setCreateTime(null);
       });
       marketClassifyMapper.insert(dbMarketClassify);
       // 测试 categoryName 不匹配
       marketClassifyMapper.insert(cloneIgnoreId(dbMarketClassify, o -> o.setCategoryName(null)));
       // 测试 createTime 不匹配
       marketClassifyMapper.insert(cloneIgnoreId(dbMarketClassify, o -> o.setCreateTime(null)));
       // 准备参数
       MarketClassifyPageReqVO reqVO = new MarketClassifyPageReqVO();
       reqVO.setCategoryName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<MarketClassifyDO> pageResult = marketClassifyService.getMarketClassifyPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbMarketClassify, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMarketClassifyList() {
       // mock 数据
       MarketClassifyDO dbMarketClassify = randomPojo(MarketClassifyDO.class, o -> { // 等会查询到
           o.setCategoryName(null);
           o.setCreateTime(null);
       });
       marketClassifyMapper.insert(dbMarketClassify);
       // 测试 categoryName 不匹配
       marketClassifyMapper.insert(cloneIgnoreId(dbMarketClassify, o -> o.setCategoryName(null)));
       // 测试 createTime 不匹配
       marketClassifyMapper.insert(cloneIgnoreId(dbMarketClassify, o -> o.setCreateTime(null)));
       // 准备参数
       MarketClassifyExportReqVO reqVO = new MarketClassifyExportReqVO();
       reqVO.setCategoryName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<MarketClassifyDO> list = marketClassifyService.getMarketClassifyList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbMarketClassify, list.get(0));
    }

}
