package cn.acsm.module.service.service.ticketdetail;

import cn.acsm.module.service.controller.admin.ticketdetail.vo.TicketDetailCreateReqVO;
import cn.acsm.module.service.controller.admin.ticketdetail.vo.TicketDetailExportReqVO;
import cn.acsm.module.service.controller.admin.ticketdetail.vo.TicketDetailPageReqVO;
import cn.acsm.module.service.controller.admin.ticketdetail.vo.TicketDetailUpdateReqVO;
import cn.acsm.module.service.dal.dataobject.ticketdetail.TicketDetailDO;
import cn.acsm.module.service.dal.mysql.ticketdetail.TicketDetailMapper;
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

import static cn.acsm.module.service.enums.ErrorCodeConstants.TICKET_DETAIL_NOT_EXISTS;
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
* {@link TicketDetailServiceImpl} 的单元测试类
*
* @author smile
*/
@Import(TicketDetailServiceImpl.class)
public class TicketDetailServiceImplTest extends BaseDbUnitTest {

    @Resource
    private TicketDetailServiceImpl ticketDetailService;

    @Resource
    private TicketDetailMapper ticketDetailMapper;

    @Test
    public void testCreateTicketDetail_success() {
        // 准备参数
        TicketDetailCreateReqVO reqVO = randomPojo(TicketDetailCreateReqVO.class);

        // 调用
        Long ticketDetailId = ticketDetailService.createTicketDetail(reqVO);
        // 断言
        assertNotNull(ticketDetailId);
        // 校验记录的属性是否正确
        TicketDetailDO ticketDetail = ticketDetailMapper.selectById(ticketDetailId);
        assertPojoEquals(reqVO, ticketDetail);
    }

    @Test
    public void testUpdateTicketDetail_success() {
        // mock 数据
        TicketDetailDO dbTicketDetail = randomPojo(TicketDetailDO.class);
        ticketDetailMapper.insert(dbTicketDetail);// @Sql: 先插入出一条存在的数据
        // 准备参数
        TicketDetailUpdateReqVO reqVO = randomPojo(TicketDetailUpdateReqVO.class, o -> {
            o.setId(dbTicketDetail.getId()); // 设置更新的 ID
        });

        // 调用
        ticketDetailService.updateTicketDetail(reqVO);
        // 校验是否更新正确
        TicketDetailDO ticketDetail = ticketDetailMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, ticketDetail);
    }

    @Test
    public void testUpdateTicketDetail_notExists() {
        // 准备参数
        TicketDetailUpdateReqVO reqVO = randomPojo(TicketDetailUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> ticketDetailService.updateTicketDetail(reqVO), TICKET_DETAIL_NOT_EXISTS);
    }

    @Test
    public void testDeleteTicketDetail_success() {
        // mock 数据
        TicketDetailDO dbTicketDetail = randomPojo(TicketDetailDO.class);
        ticketDetailMapper.insert(dbTicketDetail);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbTicketDetail.getId();

        // 调用
        ticketDetailService.deleteTicketDetail(id);
       // 校验数据不存在了
       assertNull(ticketDetailMapper.selectById(id));
    }

    @Test
    public void testDeleteTicketDetail_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> ticketDetailService.deleteTicketDetail(id), TICKET_DETAIL_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetTicketDetailPage() {
       // mock 数据
       TicketDetailDO dbTicketDetail = randomPojo(TicketDetailDO.class, o -> { // 等会查询到
           o.setTicketId(null);
           o.setSkuId(null);
           o.setUseNumber(null);
           o.setUseRate(null);
           o.setRemarks(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
       });
       ticketDetailMapper.insert(dbTicketDetail);
       // 测试 ticketId 不匹配
       ticketDetailMapper.insert(cloneIgnoreId(dbTicketDetail, o -> o.setTicketId(null)));
       // 测试 skuId 不匹配
       ticketDetailMapper.insert(cloneIgnoreId(dbTicketDetail, o -> o.setSkuId(null)));
       // 测试 useNumber 不匹配
       ticketDetailMapper.insert(cloneIgnoreId(dbTicketDetail, o -> o.setUseNumber(null)));
       // 测试 useRate 不匹配
       ticketDetailMapper.insert(cloneIgnoreId(dbTicketDetail, o -> o.setUseRate(null)));
       // 测试 remarks 不匹配
       ticketDetailMapper.insert(cloneIgnoreId(dbTicketDetail, o -> o.setRemarks(null)));
       // 测试 status 不匹配
       ticketDetailMapper.insert(cloneIgnoreId(dbTicketDetail, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       ticketDetailMapper.insert(cloneIgnoreId(dbTicketDetail, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       ticketDetailMapper.insert(cloneIgnoreId(dbTicketDetail, o -> o.setSource(null)));
       // 准备参数
       TicketDetailPageReqVO reqVO = new TicketDetailPageReqVO();
       reqVO.setTicketId(null);
       reqVO.setSkuId(null);
       reqVO.setUseNumber(null);
       reqVO.setUseRate(null);
       reqVO.setRemarks(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);

       // 调用
       PageResult<TicketDetailDO> pageResult = ticketDetailService.getTicketDetailPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbTicketDetail, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetTicketDetailList() {
       // mock 数据
       TicketDetailDO dbTicketDetail = randomPojo(TicketDetailDO.class, o -> { // 等会查询到
           o.setTicketId(null);
           o.setSkuId(null);
           o.setUseNumber(null);
           o.setUseRate(null);
           o.setRemarks(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
       });
       ticketDetailMapper.insert(dbTicketDetail);
       // 测试 ticketId 不匹配
       ticketDetailMapper.insert(cloneIgnoreId(dbTicketDetail, o -> o.setTicketId(null)));
       // 测试 skuId 不匹配
       ticketDetailMapper.insert(cloneIgnoreId(dbTicketDetail, o -> o.setSkuId(null)));
       // 测试 useNumber 不匹配
       ticketDetailMapper.insert(cloneIgnoreId(dbTicketDetail, o -> o.setUseNumber(null)));
       // 测试 useRate 不匹配
       ticketDetailMapper.insert(cloneIgnoreId(dbTicketDetail, o -> o.setUseRate(null)));
       // 测试 remarks 不匹配
       ticketDetailMapper.insert(cloneIgnoreId(dbTicketDetail, o -> o.setRemarks(null)));
       // 测试 status 不匹配
       ticketDetailMapper.insert(cloneIgnoreId(dbTicketDetail, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       ticketDetailMapper.insert(cloneIgnoreId(dbTicketDetail, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       ticketDetailMapper.insert(cloneIgnoreId(dbTicketDetail, o -> o.setSource(null)));
       // 准备参数
       TicketDetailExportReqVO reqVO = new TicketDetailExportReqVO();
       reqVO.setTicketId(null);
       reqVO.setSkuId(null);
       reqVO.setUseNumber(null);
       reqVO.setUseRate(null);
       reqVO.setRemarks(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);

       // 调用
       List<TicketDetailDO> list = ticketDetailService.getTicketDetailList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbTicketDetail, list.get(0));
    }

}
