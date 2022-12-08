package cn.acsm.module.transaction.order.service.sartinfo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.transaction.order.controller.admin.sartinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.sartinfo.SartInfoDO;
import cn.acsm.module.transaction.order.dal.mysql.sartinfo.SartInfoMapper;
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
* {@link SartInfoServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(SartInfoServiceImpl.class)
public class SartInfoServiceImplTest extends BaseDbUnitTest {

    @Resource
    private SartInfoServiceImpl sartInfoService;

    @Resource
    private SartInfoMapper sartInfoMapper;

    @Test
    public void testCreateSartInfo_success() {
        // 准备参数
        SartInfoCreateReqVO reqVO = randomPojo(SartInfoCreateReqVO.class);

        // 调用
        String sartInfoId = sartInfoService.createSartInfo(reqVO);
        // 断言
        assertNotNull(sartInfoId);
        // 校验记录的属性是否正确
        SartInfoDO sartInfo = sartInfoMapper.selectById(sartInfoId);
        assertPojoEquals(reqVO, sartInfo);
    }

    @Test
    public void testUpdateSartInfo_success() {
        // mock 数据
        SartInfoDO dbSartInfo = randomPojo(SartInfoDO.class);
        sartInfoMapper.insert(dbSartInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        SartInfoUpdateReqVO reqVO = randomPojo(SartInfoUpdateReqVO.class, o -> {
            o.setId(dbSartInfo.getId()); // 设置更新的 ID
        });

        // 调用
        sartInfoService.updateSartInfo(reqVO);
        // 校验是否更新正确
        SartInfoDO sartInfo = sartInfoMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, sartInfo);
    }

    @Test
    public void testUpdateSartInfo_notExists() {
        // 准备参数
        SartInfoUpdateReqVO reqVO = randomPojo(SartInfoUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> sartInfoService.updateSartInfo(reqVO), SART_INFO_NOT_EXISTS);
    }

    @Test
    public void testDeleteSartInfo_success() {
        // mock 数据
        SartInfoDO dbSartInfo = randomPojo(SartInfoDO.class);
        sartInfoMapper.insert(dbSartInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbSartInfo.getId();

        // 调用
        sartInfoService.deleteSartInfo(id);
       // 校验数据不存在了
       assertNull(sartInfoMapper.selectById(id));
    }

    @Test
    public void testDeleteSartInfo_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> sartInfoService.deleteSartInfo(id), SART_INFO_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetSartInfoPage() {
       // mock 数据
       SartInfoDO dbSartInfo = randomPojo(SartInfoDO.class, o -> { // 等会查询到
           o.setShelvesId(null);
           o.setShelvesName(null);
           o.setPayStatus(null);
           o.setCreateTime(null);
       });
       sartInfoMapper.insert(dbSartInfo);
       // 测试 shelvesId 不匹配
       sartInfoMapper.insert(cloneIgnoreId(dbSartInfo, o -> o.setShelvesId(null)));
       // 测试 shelvesName 不匹配
       sartInfoMapper.insert(cloneIgnoreId(dbSartInfo, o -> o.setShelvesName(null)));
       // 测试 payStatus 不匹配
       sartInfoMapper.insert(cloneIgnoreId(dbSartInfo, o -> o.setPayStatus(null)));
       // 测试 createTime 不匹配
       sartInfoMapper.insert(cloneIgnoreId(dbSartInfo, o -> o.setCreateTime(null)));
       // 准备参数
       SartInfoPageReqVO reqVO = new SartInfoPageReqVO();
       reqVO.setShelvesId(null);
       reqVO.setShelvesName(null);
       reqVO.setPayStatus(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<SartInfoDO> pageResult = sartInfoService.getSartInfoPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbSartInfo, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetSartInfoList() {
       // mock 数据
       SartInfoDO dbSartInfo = randomPojo(SartInfoDO.class, o -> { // 等会查询到
           o.setShelvesId(null);
           o.setShelvesName(null);
           o.setPayStatus(null);
           o.setCreateTime(null);
       });
       sartInfoMapper.insert(dbSartInfo);
       // 测试 shelvesId 不匹配
       sartInfoMapper.insert(cloneIgnoreId(dbSartInfo, o -> o.setShelvesId(null)));
       // 测试 shelvesName 不匹配
       sartInfoMapper.insert(cloneIgnoreId(dbSartInfo, o -> o.setShelvesName(null)));
       // 测试 payStatus 不匹配
       sartInfoMapper.insert(cloneIgnoreId(dbSartInfo, o -> o.setPayStatus(null)));
       // 测试 createTime 不匹配
       sartInfoMapper.insert(cloneIgnoreId(dbSartInfo, o -> o.setCreateTime(null)));
       // 准备参数
       SartInfoExportReqVO reqVO = new SartInfoExportReqVO();
       reqVO.setShelvesId(null);
       reqVO.setShelvesName(null);
       reqVO.setPayStatus(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<SartInfoDO> list = sartInfoService.getSartInfoList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbSartInfo, list.get(0));
    }

}
