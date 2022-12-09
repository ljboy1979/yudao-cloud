package cn.acsm.module.resource.service.adoptcontentadoptprice;

import cn.acsm.module.resource.controller.admin.adoptcontentadoptprice.vo.*;
import cn.acsm.module.resource.dal.dataobject.adoptcontentadoptprice.AdoptContentAdoptPriceDO;
import cn.acsm.module.resource.dal.mysql.adoptcontentadoptprice.AdoptContentAdoptPriceMapper;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.springframework.context.annotation.Import;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import static cn.acsm.module.resource.enums.ErrorCodeConstants.ADOPT_CONTENT_ADOPT_PRICE_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link AdoptContentAdoptPriceServiceImpl} 的单元测试类
*
* @author smile
*/
@Import(AdoptContentAdoptPriceServiceImpl.class)
public class AdoptContentAdoptPriceServiceImplTest extends BaseDbUnitTest {

    @Resource
    private AdoptContentAdoptPriceServiceImpl adoptContentAdoptPriceService;

    @Resource
    private AdoptContentAdoptPriceMapper adoptContentAdoptPriceMapper;

    @Test
    public void testCreateAdoptContentAdoptPrice_success() throws InvocationTargetException, IllegalAccessException {
        // 准备参数
        AdoptContentAdoptPriceCreateReqVO reqVO = randomPojo(AdoptContentAdoptPriceCreateReqVO.class);

        // 调用
        String adoptContentAdoptPriceId = adoptContentAdoptPriceService.createAdoptContentAdoptPrice(reqVO);
        // 断言
        assertNotNull(adoptContentAdoptPriceId);
        // 校验记录的属性是否正确
        AdoptContentAdoptPriceDO adoptContentAdoptPrice = adoptContentAdoptPriceMapper.selectById(adoptContentAdoptPriceId);
        assertPojoEquals(reqVO, adoptContentAdoptPrice);
    }

    @Test
    public void testUpdateAdoptContentAdoptPrice_success() {
        // mock 数据
        AdoptContentAdoptPriceDO dbAdoptContentAdoptPrice = randomPojo(AdoptContentAdoptPriceDO.class);
        adoptContentAdoptPriceMapper.insert(dbAdoptContentAdoptPrice);// @Sql: 先插入出一条存在的数据
        // 准备参数
        AdoptContentAdoptPriceUpdateReqVO reqVO = randomPojo(AdoptContentAdoptPriceUpdateReqVO.class, o -> {
            o.setId(dbAdoptContentAdoptPrice.getId()); // 设置更新的 ID
        });

        // 调用
        adoptContentAdoptPriceService.updateAdoptContentAdoptPrice(reqVO);
        // 校验是否更新正确
        AdoptContentAdoptPriceDO adoptContentAdoptPrice = adoptContentAdoptPriceMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, adoptContentAdoptPrice);
    }

    @Test
    public void testUpdateAdoptContentAdoptPrice_notExists() {
        // 准备参数
        AdoptContentAdoptPriceUpdateReqVO reqVO = randomPojo(AdoptContentAdoptPriceUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> adoptContentAdoptPriceService.updateAdoptContentAdoptPrice(reqVO), ADOPT_CONTENT_ADOPT_PRICE_NOT_EXISTS);
    }

    @Test
    public void testDeleteAdoptContentAdoptPrice_success() {
        // mock 数据
        AdoptContentAdoptPriceDO dbAdoptContentAdoptPrice = randomPojo(AdoptContentAdoptPriceDO.class);
        adoptContentAdoptPriceMapper.insert(dbAdoptContentAdoptPrice);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbAdoptContentAdoptPrice.getId();

        // 调用
        adoptContentAdoptPriceService.deleteAdoptContentAdoptPrice(id);
       // 校验数据不存在了
       assertNull(adoptContentAdoptPriceMapper.selectById(id));
    }

    @Test
    public void testDeleteAdoptContentAdoptPrice_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> adoptContentAdoptPriceService.deleteAdoptContentAdoptPrice(id), ADOPT_CONTENT_ADOPT_PRICE_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAdoptContentAdoptPricePage() {
       // mock 数据
       AdoptContentAdoptPriceDO dbAdoptContentAdoptPrice = randomPojo(AdoptContentAdoptPriceDO.class, o -> { // 等会查询到
           o.setAdoptId(null);
           o.setAdoptName(null);
           o.setStartTime(null);
           o.setEndTime(null);
           o.setAdoptPriceFee(null);
           o.setFeeType(null);
           o.setAdoptPersonFlag(null);
           o.setAdoptRightId(null);
           o.setPayNum(null);
           o.setAdoptTotal(null);
           o.setAdoptQuota(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       adoptContentAdoptPriceMapper.insert(dbAdoptContentAdoptPrice);
       // 测试 adoptId 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setAdoptId(null)));
       // 测试 adoptName 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setAdoptName(null)));
       // 测试 startTime 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setStartTime(null)));
       // 测试 endTime 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setEndTime(null)));
       // 测试 adoptPriceFee 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setAdoptPriceFee(null)));
       // 测试 feeType 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setFeeType(null)));
       // 测试 adoptPersonFlag 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setAdoptPersonFlag(null)));
       // 测试 adoptRightId 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setAdoptRightId(null)));
       // 测试 payNum 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setPayNum(null)));
       // 测试 adoptTotal 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setAdoptTotal(null)));
       // 测试 adoptQuota 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setAdoptQuota(null)));
       // 测试 status 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setSubjectId(null)));
       // 准备参数
       AdoptContentAdoptPricePageReqVO reqVO = new AdoptContentAdoptPricePageReqVO();
       reqVO.setAdoptId(null);
       reqVO.setAdoptName(null);
       reqVO.setStartTime((new Date[]{}));
       reqVO.setEndTime((new Date[]{}));
       reqVO.setAdoptPriceFee(null);
       reqVO.setFeeType(null);
       reqVO.setAdoptPersonFlag(null);
       reqVO.setAdoptRightId(null);
       reqVO.setPayNum(null);
       reqVO.setAdoptTotal(null);
       reqVO.setAdoptQuota(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       PageResult<AdoptContentAdoptPriceRespVO> pageResult = adoptContentAdoptPriceService.getAdoptContentAdoptPricePage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbAdoptContentAdoptPrice, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAdoptContentAdoptPriceList() {
       // mock 数据
       AdoptContentAdoptPriceDO dbAdoptContentAdoptPrice = randomPojo(AdoptContentAdoptPriceDO.class, o -> { // 等会查询到
           o.setAdoptId(null);
           o.setAdoptName(null);
           o.setStartTime(null);
           o.setEndTime(null);
           o.setAdoptPriceFee(null);
           o.setFeeType(null);
           o.setAdoptPersonFlag(null);
           o.setAdoptRightId(null);
           o.setPayNum(null);
           o.setAdoptTotal(null);
           o.setAdoptQuota(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       adoptContentAdoptPriceMapper.insert(dbAdoptContentAdoptPrice);
       // 测试 adoptId 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setAdoptId(null)));
       // 测试 adoptName 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setAdoptName(null)));
       // 测试 startTime 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setStartTime(null)));
       // 测试 endTime 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setEndTime(null)));
       // 测试 adoptPriceFee 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setAdoptPriceFee(null)));
       // 测试 feeType 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setFeeType(null)));
       // 测试 adoptPersonFlag 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setAdoptPersonFlag(null)));
       // 测试 adoptRightId 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setAdoptRightId(null)));
       // 测试 payNum 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setPayNum(null)));
       // 测试 adoptTotal 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setAdoptTotal(null)));
       // 测试 adoptQuota 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setAdoptQuota(null)));
       // 测试 status 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       adoptContentAdoptPriceMapper.insert(cloneIgnoreId(dbAdoptContentAdoptPrice, o -> o.setSubjectId(null)));
       // 准备参数
       AdoptContentAdoptPriceExportReqVO reqVO = new AdoptContentAdoptPriceExportReqVO();
       reqVO.setAdoptId(null);
       reqVO.setAdoptName(null);
       reqVO.setStartTime((new Date[]{}));
       reqVO.setEndTime((new Date[]{}));
       reqVO.setAdoptPriceFee(null);
       reqVO.setFeeType(null);
       reqVO.setAdoptPersonFlag(null);
       reqVO.setAdoptRightId(null);
       reqVO.setPayNum(null);
       reqVO.setAdoptTotal(null);
       reqVO.setAdoptQuota(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       List<AdoptContentAdoptPriceDO> list = adoptContentAdoptPriceService.getAdoptContentAdoptPriceList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbAdoptContentAdoptPrice, list.get(0));
    }

}
