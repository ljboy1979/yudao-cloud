package cn.acsm.module.service.service.ticketpackage;

import cn.acsm.module.service.controller.admin.ticketpackage.vo.*;
import cn.acsm.module.service.dal.dataobject.ticketpackage.TicketPackageDO;
import cn.acsm.module.service.dal.mysql.ticketpackage.TicketPackageMapper;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.acsm.module.service.enums.ErrorCodeConstants.TICKET_PACKAGE_NOT_EXISTS;
import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link TicketPackageServiceImpl} 的单元测试类
*
* @author smile
*/
@Import(TicketPackageServiceImpl.class)
public class TicketPackageServiceImplTest extends BaseDbUnitTest {

    @Resource
    private TicketPackageServiceImpl ticketPackageService;

    @Resource
    private TicketPackageMapper ticketPackageMapper;

    @Test
    public void testCreateTicketPackage_success() {
        // 准备参数
        TicketPackageCreateReqVO reqVO = randomPojo(TicketPackageCreateReqVO.class);

        // 调用
        Long ticketPackageId = ticketPackageService.createTicketPackage(reqVO);
        // 断言
        assertNotNull(ticketPackageId);
        // 校验记录的属性是否正确
        TicketPackageDO ticketPackage = ticketPackageMapper.selectById(ticketPackageId);
        assertPojoEquals(reqVO, ticketPackage);
    }

    @Test
    public void testUpdateTicketPackage_success() {
        // mock 数据
        TicketPackageDO dbTicketPackage = randomPojo(TicketPackageDO.class);
        ticketPackageMapper.insert(dbTicketPackage);// @Sql: 先插入出一条存在的数据
        // 准备参数
        TicketPackageUpdateReqVO reqVO = randomPojo(TicketPackageUpdateReqVO.class, o -> {
            o.setId(dbTicketPackage.getId()); // 设置更新的 ID
        });

        // 调用
        ticketPackageService.updateTicketPackage(reqVO);
        // 校验是否更新正确
        TicketPackageDO ticketPackage = ticketPackageMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, ticketPackage);
    }

    @Test
    public void testUpdateTicketPackage_notExists() {
        // 准备参数
        TicketPackageUpdateReqVO reqVO = randomPojo(TicketPackageUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> ticketPackageService.updateTicketPackage(reqVO), TICKET_PACKAGE_NOT_EXISTS);
    }

    @Test
    public void testDeleteTicketPackage_success() {
        // mock 数据
        TicketPackageDO dbTicketPackage = randomPojo(TicketPackageDO.class);
        ticketPackageMapper.insert(dbTicketPackage);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbTicketPackage.getId();

        // 调用
        ticketPackageService.deleteTicketPackage(id);
       // 校验数据不存在了
       assertNull(ticketPackageMapper.selectById(id));
    }

    @Test
    public void testDeleteTicketPackage_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> ticketPackageService.deleteTicketPackage(id), TICKET_PACKAGE_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetTicketPackagePage() {
       // mock 数据
       TicketPackageDO dbTicketPackage = randomPojo(TicketPackageDO.class, o -> { // 等会查询到
           o.setPackageName(null);
           o.setPackageType(null);
           o.setPurchaser(null);
           o.setCarrierId(null);
           o.setNumber(null);
           o.setPackageMoney(null);
           o.setServiceLife(null);
           o.setCertigier(null);
           o.setPackageStatus(null);
           o.setRemarks(null);
           o.setCover(null);
           o.setContent(null);
           o.setRegulation(null);
           o.setServiceLifeType(null);
           o.setPackageContent(null);
           o.setPackageRule(null);
           o.setStartDate(null);
           o.setEndDate(null);
           o.setTicketStatus(null);
           o.setTimeNum(null);
           o.setTimeType(null);
           o.setTimeLimitMode(null);
           o.setTicketType(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
       });
       ticketPackageMapper.insert(dbTicketPackage);
       // 测试 packageName 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setPackageName(null)));
       // 测试 packageType 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setPackageType(null)));
       // 测试 purchaser 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setPurchaser(null)));
       // 测试 carrierId 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setCarrierId(null)));
       // 测试 number 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setNumber(null)));
       // 测试 packageMoney 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setPackageMoney(null)));
       // 测试 serviceLife 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setServiceLife(null)));
       // 测试 certigier 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setCertigier(null)));
       // 测试 packageStatus 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setPackageStatus(null)));
       // 测试 remarks 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setRemarks(null)));
       // 测试 cover 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setCover(null)));
       // 测试 content 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setContent(null)));
       // 测试 regulation 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setRegulation(null)));
       // 测试 serviceLifeType 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setServiceLifeType(null)));
       // 测试 packageContent 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setPackageContent(null)));
       // 测试 packageRule 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setPackageRule(null)));
       // 测试 startDate 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setStartDate(null)));
       // 测试 endDate 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setEndDate(null)));
       // 测试 ticketStatus 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setTicketStatus(null)));
       // 测试 timeNum 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setTimeNum(null)));
       // 测试 timeType 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setTimeType(null)));
       // 测试 timeLimitMode 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setTimeLimitMode(null)));
       // 测试 ticketType 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setTicketType(null)));
       // 测试 status 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setSource(null)));
       // 准备参数
       TicketPackagePageReqVO reqVO = new TicketPackagePageReqVO();
       reqVO.setPackageName(null);
       reqVO.setPackageType(null);
       reqVO.setPurchaser(null);
       reqVO.setCarrierId(null);
       reqVO.setNumber(null);
       reqVO.setPackageMoney(null);
       reqVO.setServiceLife(null);
       reqVO.setCertigier(null);
       reqVO.setPackageStatus(null);
       reqVO.setRemarks(null);
       reqVO.setCover(null);
       reqVO.setContent(null);
       reqVO.setRegulation(null);
       reqVO.setServiceLifeType(null);
       reqVO.setPackageContent(null);
       reqVO.setPackageRule(null);
       reqVO.setStartDate((new Date[]{}));
       reqVO.setEndDate((new Date[]{}));
       reqVO.setTicketStatus(null);
       reqVO.setTimeNum(null);
       reqVO.setTimeType(null);
       reqVO.setTimeLimitMode(null);
       reqVO.setTicketType(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);

       // 调用
       PageResult<TicketPackageRespVO> pageResult = ticketPackageService.getTicketPackagePage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbTicketPackage, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetTicketPackageList() {
       // mock 数据
       TicketPackageDO dbTicketPackage = randomPojo(TicketPackageDO.class, o -> { // 等会查询到
           o.setPackageName(null);
           o.setPackageType(null);
           o.setPurchaser(null);
           o.setCarrierId(null);
           o.setNumber(null);
           o.setPackageMoney(null);
           o.setServiceLife(null);
           o.setCertigier(null);
           o.setPackageStatus(null);
           o.setRemarks(null);
           o.setCover(null);
           o.setContent(null);
           o.setRegulation(null);
           o.setServiceLifeType(null);
           o.setPackageContent(null);
           o.setPackageRule(null);
           o.setStartDate(null);
           o.setEndDate(null);
           o.setTicketStatus(null);
           o.setTimeNum(null);
           o.setTimeType(null);
           o.setTimeLimitMode(null);
           o.setTicketType(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
       });
       ticketPackageMapper.insert(dbTicketPackage);
       // 测试 packageName 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setPackageName(null)));
       // 测试 packageType 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setPackageType(null)));
       // 测试 purchaser 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setPurchaser(null)));
       // 测试 carrierId 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setCarrierId(null)));
       // 测试 number 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setNumber(null)));
       // 测试 packageMoney 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setPackageMoney(null)));
       // 测试 serviceLife 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setServiceLife(null)));
       // 测试 certigier 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setCertigier(null)));
       // 测试 packageStatus 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setPackageStatus(null)));
       // 测试 remarks 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setRemarks(null)));
       // 测试 cover 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setCover(null)));
       // 测试 content 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setContent(null)));
       // 测试 regulation 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setRegulation(null)));
       // 测试 serviceLifeType 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setServiceLifeType(null)));
       // 测试 packageContent 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setPackageContent(null)));
       // 测试 packageRule 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setPackageRule(null)));
       // 测试 startDate 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setStartDate(null)));
       // 测试 endDate 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setEndDate(null)));
       // 测试 ticketStatus 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setTicketStatus(null)));
       // 测试 timeNum 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setTimeNum(null)));
       // 测试 timeType 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setTimeType(null)));
       // 测试 timeLimitMode 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setTimeLimitMode(null)));
       // 测试 ticketType 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setTicketType(null)));
       // 测试 status 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       ticketPackageMapper.insert(cloneIgnoreId(dbTicketPackage, o -> o.setSource(null)));
       // 准备参数
       TicketPackageExportReqVO reqVO = new TicketPackageExportReqVO();
       reqVO.setPackageName(null);
       reqVO.setPackageType(null);
       reqVO.setPurchaser(null);
       reqVO.setCarrierId(null);
       reqVO.setNumber(null);
       reqVO.setPackageMoney(null);
       reqVO.setServiceLife(null);
       reqVO.setCertigier(null);
       reqVO.setPackageStatus(null);
       reqVO.setRemarks(null);
       reqVO.setCover(null);
       reqVO.setContent(null);
       reqVO.setRegulation(null);
       reqVO.setServiceLifeType(null);
       reqVO.setPackageContent(null);
       reqVO.setPackageRule(null);
       reqVO.setStartDate((new Date[]{}));
       reqVO.setEndDate((new Date[]{}));
       reqVO.setTicketStatus(null);
       reqVO.setTimeNum(null);
       reqVO.setTimeType(null);
       reqVO.setTimeLimitMode(null);
       reqVO.setTicketType(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);

       // 调用
       List<TicketPackageDO> list = ticketPackageService.getTicketPackageList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbTicketPackage, list.get(0));
    }

}
