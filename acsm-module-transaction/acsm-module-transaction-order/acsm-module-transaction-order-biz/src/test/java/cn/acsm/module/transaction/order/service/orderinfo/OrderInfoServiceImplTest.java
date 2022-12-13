package cn.acsm.module.transaction.order.service.orderinfo;

import cn.acsm.module.transaction.order.enums.RedisDelayQueueEnum;
import cn.acsm.module.transaction.order.util.RedisDelayQueueUtil;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.transaction.order.controller.admin.orderinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.orderinfo.OrderInfoDO;
import cn.acsm.module.transaction.order.dal.mysql.orderinfo.OrderInfoMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.acsm.module.transaction.order.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link OrderInfoServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(OrderInfoServiceImpl.class)
public class OrderInfoServiceImplTest extends BaseDbUnitTest {

    @Resource
    private OrderInfoServiceImpl infoService;

    @Resource
    private OrderInfoMapper infoMapper;

    @Resource
    private RedisDelayQueueUtil redisDelayQueueUtil;

    @Test
    public void testCreateInfo_success() {
        redisDelayQueueUtil.addDelayQueue("1111", 60, TimeUnit.SECONDS, RedisDelayQueueEnum.COMPLETE_LOGISTICS.getQueueCode());

    }

    @Test
    public void testUpdateInfo_success() {
        // mock 数据
        OrderInfoDO dbInfo = randomPojo(OrderInfoDO.class);
        infoMapper.insert(dbInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        OrderInfoUpdateReqVO reqVO = randomPojo(OrderInfoUpdateReqVO.class, o -> {
            o.setId(dbInfo.getId()); // 设置更新的 ID
        });

        // 调用
        infoService.updateInfo(reqVO);
        // 校验是否更新正确
        OrderInfoDO info = infoMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, info);
    }

    @Test
    public void testUpdateInfo_notExists() {
        // 准备参数
        OrderInfoUpdateReqVO reqVO = randomPojo(OrderInfoUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> infoService.updateInfo(reqVO), INFO_NOT_EXISTS);
    }

    @Test
    public void testDeleteInfo_success() {
        // mock 数据
        OrderInfoDO dbInfo = randomPojo(OrderInfoDO.class);
        infoMapper.insert(dbInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbInfo.getId();

        // 调用
        infoService.deleteInfo(id);
       // 校验数据不存在了
       assertNull(infoMapper.selectById(id));
    }

    @Test
    public void testDeleteInfo_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> infoService.deleteInfo(id), INFO_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInfoPage() {
       // mock 数据
       OrderInfoDO dbInfo = randomPojo(OrderInfoDO.class, o -> { // 等会查询到
           o.setCreateTime(null);
       });
       infoMapper.insert(dbInfo);
       // 测试 createTime 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCreateTime(null)));
       // 准备参数
       OrderInfoPageReqVO reqVO = new OrderInfoPageReqVO();
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<OrderInfoDO> pageResult = infoService.getInfoPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbInfo, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInfoList() {
       // mock 数据
       OrderInfoDO dbInfo = randomPojo(OrderInfoDO.class, o -> { // 等会查询到
           o.setCreateTime(null);
       });
       infoMapper.insert(dbInfo);
       // 测试 createTime 不匹配
       infoMapper.insert(cloneIgnoreId(dbInfo, o -> o.setCreateTime(null)));
       // 准备参数
       OrderInfoExportReqVO reqVO = new OrderInfoExportReqVO();
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<OrderInfoDO> list = infoService.getInfoList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbInfo, list.get(0));
    }

}
