package cn.acsm.module.transaction.order.service.reservedetails;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.transaction.order.controller.admin.reservedetails.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.reservedetails.ReserveDetailsDO;
import cn.acsm.module.transaction.order.dal.mysql.reservedetails.ReserveDetailsMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.acsm.module.transaction.order.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link ReserveDetailsServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(ReserveDetailsServiceImpl.class)
public class ReserveDetailsServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ReserveDetailsServiceImpl reserveDetailsService;

    @Resource
    private ReserveDetailsMapper reserveDetailsMapper;

    @Test
    public void testCreateReserveDetails_success() {
        // 准备参数
        ReserveDetailsCreateReqVO reqVO = randomPojo(ReserveDetailsCreateReqVO.class);

        // 调用
        String reserveDetailsId = reserveDetailsService.createReserveDetails(reqVO);
        // 断言
        assertNotNull(reserveDetailsId);
        // 校验记录的属性是否正确
        ReserveDetailsDO reserveDetails = reserveDetailsMapper.selectById(reserveDetailsId);
        assertPojoEquals(reqVO, reserveDetails);
    }

    @Test
    public void testUpdateReserveDetails_success() {
        // mock 数据
        ReserveDetailsDO dbReserveDetails = randomPojo(ReserveDetailsDO.class);
        reserveDetailsMapper.insert(dbReserveDetails);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ReserveDetailsUpdateReqVO reqVO = randomPojo(ReserveDetailsUpdateReqVO.class, o -> {
            o.setId(dbReserveDetails.getId()); // 设置更新的 ID
        });

        // 调用
        reserveDetailsService.updateReserveDetails(reqVO);
        // 校验是否更新正确
        ReserveDetailsDO reserveDetails = reserveDetailsMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, reserveDetails);
    }

    @Test
    public void testUpdateReserveDetails_notExists() {
        // 准备参数
        ReserveDetailsUpdateReqVO reqVO = randomPojo(ReserveDetailsUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> reserveDetailsService.updateReserveDetails(reqVO), RESERVE_DETAILS_NOT_EXISTS);
    }

    @Test
    public void testDeleteReserveDetails_success() {
        // mock 数据
        ReserveDetailsDO dbReserveDetails = randomPojo(ReserveDetailsDO.class);
        reserveDetailsMapper.insert(dbReserveDetails);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbReserveDetails.getId();

        // 调用
        reserveDetailsService.deleteReserveDetails(id);
       // 校验数据不存在了
       assertNull(reserveDetailsMapper.selectById(id));
    }

    @Test
    public void testDeleteReserveDetails_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> reserveDetailsService.deleteReserveDetails(id), RESERVE_DETAILS_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetReserveDetailsPage() {
       // mock 数据
       ReserveDetailsDO dbReserveDetails = randomPojo(ReserveDetailsDO.class, o -> { // 等会查询到
           o.setCommodityName(null);
           o.setCreateTime(null);
       });
       reserveDetailsMapper.insert(dbReserveDetails);
       // 测试 commodityName 不匹配
       reserveDetailsMapper.insert(cloneIgnoreId(dbReserveDetails, o -> o.setCommodityName(null)));
       // 测试 createTime 不匹配
       reserveDetailsMapper.insert(cloneIgnoreId(dbReserveDetails, o -> o.setCreateTime(null)));
       // 准备参数
       ReserveDetailsPageReqVO reqVO = new ReserveDetailsPageReqVO();
       reqVO.setCommodityName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<ReserveDetailsDO> pageResult = reserveDetailsService.getReserveDetailsPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbReserveDetails, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetReserveDetailsList() {
       // mock 数据
       ReserveDetailsDO dbReserveDetails = randomPojo(ReserveDetailsDO.class, o -> { // 等会查询到
           o.setCommodityName(null);
           o.setCreateTime(null);
       });
       reserveDetailsMapper.insert(dbReserveDetails);
       // 测试 commodityName 不匹配
       reserveDetailsMapper.insert(cloneIgnoreId(dbReserveDetails, o -> o.setCommodityName(null)));
       // 测试 createTime 不匹配
       reserveDetailsMapper.insert(cloneIgnoreId(dbReserveDetails, o -> o.setCreateTime(null)));
       // 准备参数
       ReserveDetailsExportReqVO reqVO = new ReserveDetailsExportReqVO();
       reqVO.setCommodityName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<ReserveDetailsDO> list = reserveDetailsService.getReserveDetailsList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbReserveDetails, list.get(0));
    }

}
