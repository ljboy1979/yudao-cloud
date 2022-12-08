package cn.acsm.module.transaction.order.service.reserveinfo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.transaction.order.controller.admin.reserveinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.reserveinfo.ReserveInfoDO;
import cn.acsm.module.transaction.order.dal.mysql.reserveinfo.ReserveInfoMapper;
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
* {@link ReserveInfoServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(ReserveInfoServiceImpl.class)
public class ReserveInfoServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ReserveInfoServiceImpl reserveInfoService;

    @Resource
    private ReserveInfoMapper reserveInfoMapper;

    @Test
    public void testCreateReserveInfo_success() {
        // 准备参数
        ReserveInfoCreateReqVO reqVO = randomPojo(ReserveInfoCreateReqVO.class);

        // 调用
        String reserveInfoId = reserveInfoService.createReserveInfo(reqVO);
        // 断言
        assertNotNull(reserveInfoId);
        // 校验记录的属性是否正确
        ReserveInfoDO reserveInfo = reserveInfoMapper.selectById(reserveInfoId);
        assertPojoEquals(reqVO, reserveInfo);
    }

    @Test
    public void testUpdateReserveInfo_success() {
        // mock 数据
        ReserveInfoDO dbReserveInfo = randomPojo(ReserveInfoDO.class);
        reserveInfoMapper.insert(dbReserveInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ReserveInfoUpdateReqVO reqVO = randomPojo(ReserveInfoUpdateReqVO.class, o -> {
            o.setId(dbReserveInfo.getId()); // 设置更新的 ID
        });

        // 调用
        reserveInfoService.updateReserveInfo(reqVO);
        // 校验是否更新正确
        ReserveInfoDO reserveInfo = reserveInfoMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, reserveInfo);
    }

    @Test
    public void testUpdateReserveInfo_notExists() {
        // 准备参数
        ReserveInfoUpdateReqVO reqVO = randomPojo(ReserveInfoUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> reserveInfoService.updateReserveInfo(reqVO), RESERVE_INFO_NOT_EXISTS);
    }

    @Test
    public void testDeleteReserveInfo_success() {
        // mock 数据
        ReserveInfoDO dbReserveInfo = randomPojo(ReserveInfoDO.class);
        reserveInfoMapper.insert(dbReserveInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbReserveInfo.getId();

        // 调用
        reserveInfoService.deleteReserveInfo(id);
       // 校验数据不存在了
       assertNull(reserveInfoMapper.selectById(id));
    }

    @Test
    public void testDeleteReserveInfo_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> reserveInfoService.deleteReserveInfo(id), RESERVE_INFO_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetReserveInfoPage() {
       // mock 数据
       ReserveInfoDO dbReserveInfo = randomPojo(ReserveInfoDO.class, o -> { // 等会查询到
           o.setPayType(null);
           o.setCreateTime(null);
       });
       reserveInfoMapper.insert(dbReserveInfo);
       // 测试 payType 不匹配
       reserveInfoMapper.insert(cloneIgnoreId(dbReserveInfo, o -> o.setPayType(null)));
       // 测试 createTime 不匹配
       reserveInfoMapper.insert(cloneIgnoreId(dbReserveInfo, o -> o.setCreateTime(null)));
       // 准备参数
       ReserveInfoPageReqVO reqVO = new ReserveInfoPageReqVO();
       reqVO.setPayType(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<ReserveInfoDO> pageResult = reserveInfoService.getReserveInfoPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbReserveInfo, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetReserveInfoList() {
       // mock 数据
       ReserveInfoDO dbReserveInfo = randomPojo(ReserveInfoDO.class, o -> { // 等会查询到
           o.setPayType(null);
           o.setCreateTime(null);
       });
       reserveInfoMapper.insert(dbReserveInfo);
       // 测试 payType 不匹配
       reserveInfoMapper.insert(cloneIgnoreId(dbReserveInfo, o -> o.setPayType(null)));
       // 测试 createTime 不匹配
       reserveInfoMapper.insert(cloneIgnoreId(dbReserveInfo, o -> o.setCreateTime(null)));
       // 准备参数
       ReserveInfoExportReqVO reqVO = new ReserveInfoExportReqVO();
       reqVO.setPayType(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<ReserveInfoDO> list = reserveInfoService.getReserveInfoList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbReserveInfo, list.get(0));
    }

}
