package cn.acsm.module.transaction.order.service.settleinfo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.transaction.order.controller.admin.settleinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.settleinfo.SettleInfoDO;
import cn.acsm.module.transaction.order.dal.mysql.settleinfo.SettleInfoMapper;
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
* {@link SettleInfoServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(SettleInfoServiceImpl.class)
public class SettleInfoServiceImplTest extends BaseDbUnitTest {

    @Resource
    private SettleInfoServiceImpl settleInfoService;

    @Resource
    private SettleInfoMapper settleInfoMapper;

    @Test
    public void testCreateSettleInfo_success() {
        // 准备参数
        SettleInfoCreateReqVO reqVO = randomPojo(SettleInfoCreateReqVO.class);

        // 调用
        String settleInfoId = settleInfoService.createSettleInfo(reqVO);
        // 断言
        assertNotNull(settleInfoId);
        // 校验记录的属性是否正确
        SettleInfoDO settleInfo = settleInfoMapper.selectById(settleInfoId);
        assertPojoEquals(reqVO, settleInfo);
    }

    @Test
    public void testUpdateSettleInfo_success() {
        // mock 数据
        SettleInfoDO dbSettleInfo = randomPojo(SettleInfoDO.class);
        settleInfoMapper.insert(dbSettleInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        SettleInfoUpdateReqVO reqVO = randomPojo(SettleInfoUpdateReqVO.class, o -> {
            o.setId(dbSettleInfo.getId()); // 设置更新的 ID
        });

        // 调用
        settleInfoService.updateSettleInfo(reqVO);
        // 校验是否更新正确
        SettleInfoDO settleInfo = settleInfoMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, settleInfo);
    }

    @Test
    public void testUpdateSettleInfo_notExists() {
        // 准备参数
        SettleInfoUpdateReqVO reqVO = randomPojo(SettleInfoUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> settleInfoService.updateSettleInfo(reqVO), SETTLE_INFO_NOT_EXISTS);
    }

    @Test
    public void testDeleteSettleInfo_success() {
        // mock 数据
        SettleInfoDO dbSettleInfo = randomPojo(SettleInfoDO.class);
        settleInfoMapper.insert(dbSettleInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbSettleInfo.getId();

        // 调用
        settleInfoService.deleteSettleInfo(id);
       // 校验数据不存在了
       assertNull(settleInfoMapper.selectById(id));
    }

    @Test
    public void testDeleteSettleInfo_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> settleInfoService.deleteSettleInfo(id), SETTLE_INFO_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetSettleInfoPage() {
       // mock 数据
       SettleInfoDO dbSettleInfo = randomPojo(SettleInfoDO.class, o -> { // 等会查询到
           o.setOrderId(null);
           o.setCreateTime(null);
       });
       settleInfoMapper.insert(dbSettleInfo);
       // 测试 orderId 不匹配
       settleInfoMapper.insert(cloneIgnoreId(dbSettleInfo, o -> o.setOrderId(null)));
       // 测试 createTime 不匹配
       settleInfoMapper.insert(cloneIgnoreId(dbSettleInfo, o -> o.setCreateTime(null)));
       // 准备参数
       SettleInfoPageReqVO reqVO = new SettleInfoPageReqVO();
       reqVO.setOrderId(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<SettleInfoDO> pageResult = settleInfoService.getSettleInfoPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbSettleInfo, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetSettleInfoList() {
       // mock 数据
       SettleInfoDO dbSettleInfo = randomPojo(SettleInfoDO.class, o -> { // 等会查询到
           o.setOrderId(null);
           o.setCreateTime(null);
       });
       settleInfoMapper.insert(dbSettleInfo);
       // 测试 orderId 不匹配
       settleInfoMapper.insert(cloneIgnoreId(dbSettleInfo, o -> o.setOrderId(null)));
       // 测试 createTime 不匹配
       settleInfoMapper.insert(cloneIgnoreId(dbSettleInfo, o -> o.setCreateTime(null)));
       // 准备参数
       SettleInfoExportReqVO reqVO = new SettleInfoExportReqVO();
       reqVO.setOrderId(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<SettleInfoDO> list = settleInfoService.getSettleInfoList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbSettleInfo, list.get(0));
    }

}
