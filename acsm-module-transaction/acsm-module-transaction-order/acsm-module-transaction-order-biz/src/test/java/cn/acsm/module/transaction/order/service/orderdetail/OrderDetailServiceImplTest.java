package cn.acsm.module.transaction.order.service.orderdetail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.transaction.order.controller.admin.orderdetail.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.orderdetail.OrderDetailDO;
import cn.acsm.module.transaction.order.dal.mysql.orderdetail.OrderDetailMapper;
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
* {@link OrderDetailServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(OrderDetailServiceImpl.class)
public class OrderDetailServiceImplTest extends BaseDbUnitTest {

    @Resource
    private OrderDetailServiceImpl detailService;

    @Resource
    private OrderDetailMapper detailMapper;

    @Test
    public void testCreateDetail_success() {
        // 准备参数
        OrderDetailCreateReqVO reqVO = randomPojo(OrderDetailCreateReqVO.class);

        // 调用
        String detailId = detailService.createDetail(reqVO);
        // 断言
        assertNotNull(detailId);
        // 校验记录的属性是否正确
        OrderDetailDO detail = detailMapper.selectById(detailId);
        assertPojoEquals(reqVO, detail);
    }

    @Test
    public void testUpdateDetail_success() {
        // mock 数据
        OrderDetailDO dbDetail = randomPojo(OrderDetailDO.class);
        detailMapper.insert(dbDetail);// @Sql: 先插入出一条存在的数据
        // 准备参数
        OrderDetailUpdateReqVO reqVO = randomPojo(OrderDetailUpdateReqVO.class, o -> {
            o.setId(dbDetail.getId()); // 设置更新的 ID
        });

        // 调用
        detailService.updateDetail(reqVO);
        // 校验是否更新正确
        OrderDetailDO detail = detailMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, detail);
    }

    @Test
    public void testUpdateDetail_notExists() {
        // 准备参数
        OrderDetailUpdateReqVO reqVO = randomPojo(OrderDetailUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> detailService.updateDetail(reqVO), DETAIL_NOT_EXISTS);
    }

    @Test
    public void testDeleteDetail_success() {
        // mock 数据
        OrderDetailDO dbDetail = randomPojo(OrderDetailDO.class);
        detailMapper.insert(dbDetail);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbDetail.getId();

        // 调用
        detailService.deleteDetail(id);
       // 校验数据不存在了
       assertNull(detailMapper.selectById(id));
    }

    @Test
    public void testDeleteDetail_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> detailService.deleteDetail(id), DETAIL_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetDetailPage() {
       // mock 数据
       OrderDetailDO dbDetail = randomPojo(OrderDetailDO.class, o -> { // 等会查询到
           o.setShelvesName(null);
           o.setSpecificationName(null);
           o.setDeliveryTime(null);
       });
       detailMapper.insert(dbDetail);
       // 测试 shelvesName 不匹配
       detailMapper.insert(cloneIgnoreId(dbDetail, o -> o.setShelvesName(null)));
       // 测试 specificationName 不匹配
       detailMapper.insert(cloneIgnoreId(dbDetail, o -> o.setSpecificationName(null)));
       // 测试 deliveryTime 不匹配
       detailMapper.insert(cloneIgnoreId(dbDetail, o -> o.setDeliveryTime(null)));
       // 准备参数
       OrderDetailPageReqVO reqVO = new OrderDetailPageReqVO();
       reqVO.setShelvesName(null);
       reqVO.setSpecificationName(null);
       reqVO.setDeliveryTime((new Date[]{}));

       // 调用
       PageResult<OrderDetailDO> pageResult = detailService.getDetailPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbDetail, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetDetailList() {
       // mock 数据
       OrderDetailDO dbDetail = randomPojo(OrderDetailDO.class, o -> { // 等会查询到
           o.setShelvesName(null);
           o.setSpecificationName(null);
           o.setDeliveryTime(null);
       });
       detailMapper.insert(dbDetail);
       // 测试 shelvesName 不匹配
       detailMapper.insert(cloneIgnoreId(dbDetail, o -> o.setShelvesName(null)));
       // 测试 specificationName 不匹配
       detailMapper.insert(cloneIgnoreId(dbDetail, o -> o.setSpecificationName(null)));
       // 测试 deliveryTime 不匹配
       detailMapper.insert(cloneIgnoreId(dbDetail, o -> o.setDeliveryTime(null)));
       // 准备参数
       OrderDetailExportReqVO reqVO = new OrderDetailExportReqVO();
       reqVO.setShelvesName(null);
       reqVO.setSpecificationName(null);
       reqVO.setDeliveryTime((new Date[]{}));

       // 调用
       List<OrderDetailDO> list = detailService.getDetailList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbDetail, list.get(0));
    }

}
