package cn.acsm.module.transaction.pricetag.service.marketinfo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.transaction.pricetag.controller.admin.marketinfo.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketinfo.MarketInfoDO;
import cn.acsm.module.transaction.pricetag.dal.mysql.marketinfo.MarketInfoMapper;
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
* {@link MarketInfoServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(MarketInfoServiceImpl.class)
public class MarketInfoServiceImplTest extends BaseDbUnitTest {

    @Resource
    private MarketInfoServiceImpl marketInfoService;

    @Resource
    private MarketInfoMapper marketInfoMapper;

    @Test
    public void testCreateMarketInfo_success() {
        // 准备参数
        MarketInfoCreateReqVO reqVO = randomPojo(MarketInfoCreateReqVO.class);

        // 调用
        String marketInfoId = marketInfoService.createMarketInfo(reqVO);
        // 断言
        assertNotNull(marketInfoId);
        // 校验记录的属性是否正确
        MarketInfoDO marketInfo = marketInfoMapper.selectById(marketInfoId);
        assertPojoEquals(reqVO, marketInfo);
    }

    @Test
    public void testUpdateMarketInfo_success() {
        // mock 数据
        MarketInfoDO dbMarketInfo = randomPojo(MarketInfoDO.class);
        marketInfoMapper.insert(dbMarketInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        MarketInfoUpdateReqVO reqVO = randomPojo(MarketInfoUpdateReqVO.class, o -> {
            o.setId(dbMarketInfo.getId()); // 设置更新的 ID
        });

        // 调用
        marketInfoService.updateMarketInfo(reqVO);
        // 校验是否更新正确
        MarketInfoDO marketInfo = marketInfoMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, marketInfo);
    }

    @Test
    public void testUpdateMarketInfo_notExists() {
        // 准备参数
        MarketInfoUpdateReqVO reqVO = randomPojo(MarketInfoUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> marketInfoService.updateMarketInfo(reqVO), MARKET_INFO_NOT_EXISTS);
    }

    @Test
    public void testDeleteMarketInfo_success() {
        // mock 数据
        MarketInfoDO dbMarketInfo = randomPojo(MarketInfoDO.class);
        marketInfoMapper.insert(dbMarketInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbMarketInfo.getId();

        // 调用
        marketInfoService.deleteMarketInfo(id);
       // 校验数据不存在了
       assertNull(marketInfoMapper.selectById(id));
    }

    @Test
    public void testDeleteMarketInfo_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> marketInfoService.deleteMarketInfo(id), MARKET_INFO_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMarketInfoPage() {
       // mock 数据
       MarketInfoDO dbMarketInfo = randomPojo(MarketInfoDO.class, o -> { // 等会查询到
           o.setMarketName(null);
           o.setCreateTime(null);
       });
       marketInfoMapper.insert(dbMarketInfo);
       // 测试 marketName 不匹配
       marketInfoMapper.insert(cloneIgnoreId(dbMarketInfo, o -> o.setMarketName(null)));
       // 测试 createTime 不匹配
       marketInfoMapper.insert(cloneIgnoreId(dbMarketInfo, o -> o.setCreateTime(null)));
       // 准备参数
       MarketInfoPageReqVO reqVO = new MarketInfoPageReqVO();
       reqVO.setMarketName(null);
       reqVO.setUpdateTime((new Date[]{}));

       // 调用
       PageResult<MarketInfoDO> pageResult = marketInfoService.getMarketInfoPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbMarketInfo, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMarketInfoList() {
       // mock 数据
       MarketInfoDO dbMarketInfo = randomPojo(MarketInfoDO.class, o -> { // 等会查询到
           o.setMarketName(null);
           o.setCreateTime(null);
       });
       marketInfoMapper.insert(dbMarketInfo);
       // 测试 marketName 不匹配
       marketInfoMapper.insert(cloneIgnoreId(dbMarketInfo, o -> o.setMarketName(null)));
       // 测试 createTime 不匹配
       marketInfoMapper.insert(cloneIgnoreId(dbMarketInfo, o -> o.setCreateTime(null)));
       // 准备参数
       MarketInfoExportReqVO reqVO = new MarketInfoExportReqVO();
       reqVO.setMarketName(null);
       reqVO.setUpdateTime((new Date[]{}));

       // 调用
       List<MarketInfoDO> list = marketInfoService.getMarketInfoList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbMarketInfo, list.get(0));
    }

}
