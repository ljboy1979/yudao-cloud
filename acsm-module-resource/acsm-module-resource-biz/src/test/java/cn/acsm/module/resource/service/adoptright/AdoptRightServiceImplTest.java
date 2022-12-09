package cn.acsm.module.resource.service.adoptright;

import cn.acsm.module.resource.controller.admin.adoptright.vo.AdoptRightCreateReqVO;
import cn.acsm.module.resource.controller.admin.adoptright.vo.AdoptRightExportReqVO;
import cn.acsm.module.resource.controller.admin.adoptright.vo.AdoptRightPageReqVO;
import cn.acsm.module.resource.controller.admin.adoptright.vo.AdoptRightUpdateReqVO;
import cn.acsm.module.resource.dal.dataobject.adoptright.AdoptRightDO;
import cn.acsm.module.resource.dal.mysql.adoptright.AdoptRightMapper;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.springframework.context.annotation.Import;
import java.util.*;

import static cn.acsm.module.resource.enums.ErrorCodeConstants.ADOPT_RIGHT_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link AdoptRightServiceImpl} 的单元测试类
*
* @author smile
*/
@Import(AdoptRightServiceImpl.class)
public class AdoptRightServiceImplTest extends BaseDbUnitTest {

    @Resource
    private AdoptRightServiceImpl adoptRightService;

    @Resource
    private AdoptRightMapper adoptRightMapper;

    @Test
    public void testCreateAdoptRight_success() {
        // 准备参数
        AdoptRightCreateReqVO reqVO = randomPojo(AdoptRightCreateReqVO.class);

        // 调用
        Long adoptRightId = adoptRightService.createAdoptRight(reqVO);
        // 断言
        assertNotNull(adoptRightId);
        // 校验记录的属性是否正确
        AdoptRightDO adoptRight = adoptRightMapper.selectById(adoptRightId);
        assertPojoEquals(reqVO, adoptRight);
    }

    @Test
    public void testUpdateAdoptRight_success() {
        // mock 数据
        AdoptRightDO dbAdoptRight = randomPojo(AdoptRightDO.class);
        adoptRightMapper.insert(dbAdoptRight);// @Sql: 先插入出一条存在的数据
        // 准备参数
        AdoptRightUpdateReqVO reqVO = randomPojo(AdoptRightUpdateReqVO.class, o -> {
            o.setId(dbAdoptRight.getId()); // 设置更新的 ID
        });

        // 调用
        adoptRightService.updateAdoptRight(reqVO);
        // 校验是否更新正确
        AdoptRightDO adoptRight = adoptRightMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, adoptRight);
    }

    @Test
    public void testUpdateAdoptRight_notExists() {
        // 准备参数
        AdoptRightUpdateReqVO reqVO = randomPojo(AdoptRightUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> adoptRightService.updateAdoptRight(reqVO), ADOPT_RIGHT_NOT_EXISTS);
    }

    @Test
    public void testDeleteAdoptRight_success() {
        // mock 数据
        AdoptRightDO dbAdoptRight = randomPojo(AdoptRightDO.class);
        adoptRightMapper.insert(dbAdoptRight);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbAdoptRight.getId();

        // 调用
        adoptRightService.deleteAdoptRight(id);
       // 校验数据不存在了
       assertNull(adoptRightMapper.selectById(id));
    }

    @Test
    public void testDeleteAdoptRight_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> adoptRightService.deleteAdoptRight(id), ADOPT_RIGHT_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAdoptRightPage() {
       // mock 数据
       AdoptRightDO dbAdoptRight = randomPojo(AdoptRightDO.class, o -> { // 等会查询到
           o.setRightType(null);
           o.setRightDescription(null);
           o.setAdoptTime(null);
           o.setAdoptContentNum(null);
           o.setIncomeItemAmountScale(null);
           o.setIncomeEffectiveDate(null);
           o.setLeasePersonFlag(null);
           o.setAdoptRightId(null);
           o.setPrice(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       adoptRightMapper.insert(dbAdoptRight);
       // 测试 rightType 不匹配
       adoptRightMapper.insert(cloneIgnoreId(dbAdoptRight, o -> o.setRightType(null)));
       // 测试 rightDescription 不匹配
       adoptRightMapper.insert(cloneIgnoreId(dbAdoptRight, o -> o.setRightDescription(null)));
       // 测试 adoptTime 不匹配
       adoptRightMapper.insert(cloneIgnoreId(dbAdoptRight, o -> o.setAdoptTime(null)));
       // 测试 adoptContentNum 不匹配
       adoptRightMapper.insert(cloneIgnoreId(dbAdoptRight, o -> o.setAdoptContentNum(null)));
       // 测试 incomeItemAmountScale 不匹配
       adoptRightMapper.insert(cloneIgnoreId(dbAdoptRight, o -> o.setIncomeItemAmountScale(null)));
       // 测试 incomeEffectiveDate 不匹配
       adoptRightMapper.insert(cloneIgnoreId(dbAdoptRight, o -> o.setIncomeEffectiveDate(null)));
       // 测试 leasePersonFlag 不匹配
       adoptRightMapper.insert(cloneIgnoreId(dbAdoptRight, o -> o.setLeasePersonFlag(null)));
       // 测试 adoptRightId 不匹配
       adoptRightMapper.insert(cloneIgnoreId(dbAdoptRight, o -> o.setAdoptRightId(null)));
       // 测试 price 不匹配
       adoptRightMapper.insert(cloneIgnoreId(dbAdoptRight, o -> o.setPrice(null)));
       // 测试 status 不匹配
       adoptRightMapper.insert(cloneIgnoreId(dbAdoptRight, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       adoptRightMapper.insert(cloneIgnoreId(dbAdoptRight, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       adoptRightMapper.insert(cloneIgnoreId(dbAdoptRight, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       adoptRightMapper.insert(cloneIgnoreId(dbAdoptRight, o -> o.setSubjectId(null)));
       // 准备参数
       AdoptRightPageReqVO reqVO = new AdoptRightPageReqVO();
       reqVO.setRightType(null);
       reqVO.setRightDescription(null);
       reqVO.setAdoptTime((new Date[]{}));
       reqVO.setAdoptContentNum(null);
       reqVO.setIncomeItemAmountScale(null);
       reqVO.setIncomeEffectiveDate((new Date[]{}));
       reqVO.setLeasePersonFlag(null);
       reqVO.setAdoptRightId(null);
       reqVO.setPrice(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       PageResult<AdoptRightDO> pageResult = adoptRightService.getAdoptRightPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbAdoptRight, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAdoptRightList() {
       // mock 数据
       AdoptRightDO dbAdoptRight = randomPojo(AdoptRightDO.class, o -> { // 等会查询到
           o.setRightType(null);
           o.setRightDescription(null);
           o.setAdoptTime(null);
           o.setAdoptContentNum(null);
           o.setIncomeItemAmountScale(null);
           o.setIncomeEffectiveDate(null);
           o.setLeasePersonFlag(null);
           o.setAdoptRightId(null);
           o.setPrice(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       adoptRightMapper.insert(dbAdoptRight);
       // 测试 rightType 不匹配
       adoptRightMapper.insert(cloneIgnoreId(dbAdoptRight, o -> o.setRightType(null)));
       // 测试 rightDescription 不匹配
       adoptRightMapper.insert(cloneIgnoreId(dbAdoptRight, o -> o.setRightDescription(null)));
       // 测试 adoptTime 不匹配
       adoptRightMapper.insert(cloneIgnoreId(dbAdoptRight, o -> o.setAdoptTime(null)));
       // 测试 adoptContentNum 不匹配
       adoptRightMapper.insert(cloneIgnoreId(dbAdoptRight, o -> o.setAdoptContentNum(null)));
       // 测试 incomeItemAmountScale 不匹配
       adoptRightMapper.insert(cloneIgnoreId(dbAdoptRight, o -> o.setIncomeItemAmountScale(null)));
       // 测试 incomeEffectiveDate 不匹配
       adoptRightMapper.insert(cloneIgnoreId(dbAdoptRight, o -> o.setIncomeEffectiveDate(null)));
       // 测试 leasePersonFlag 不匹配
       adoptRightMapper.insert(cloneIgnoreId(dbAdoptRight, o -> o.setLeasePersonFlag(null)));
       // 测试 adoptRightId 不匹配
       adoptRightMapper.insert(cloneIgnoreId(dbAdoptRight, o -> o.setAdoptRightId(null)));
       // 测试 price 不匹配
       adoptRightMapper.insert(cloneIgnoreId(dbAdoptRight, o -> o.setPrice(null)));
       // 测试 status 不匹配
       adoptRightMapper.insert(cloneIgnoreId(dbAdoptRight, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       adoptRightMapper.insert(cloneIgnoreId(dbAdoptRight, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       adoptRightMapper.insert(cloneIgnoreId(dbAdoptRight, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       adoptRightMapper.insert(cloneIgnoreId(dbAdoptRight, o -> o.setSubjectId(null)));
       // 准备参数
       AdoptRightExportReqVO reqVO = new AdoptRightExportReqVO();
       reqVO.setRightType(null);
       reqVO.setRightDescription(null);
       reqVO.setAdoptTime((new Date[]{}));
       reqVO.setAdoptContentNum(null);
       reqVO.setIncomeItemAmountScale(null);
       reqVO.setIncomeEffectiveDate((new Date[]{}));
       reqVO.setLeasePersonFlag(null);
       reqVO.setAdoptRightId(null);
       reqVO.setPrice(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       List<AdoptRightDO> list = adoptRightService.getAdoptRightList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbAdoptRight, list.get(0));
    }

}
