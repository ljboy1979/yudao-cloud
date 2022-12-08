package cn.acsm.module.transaction.order.service.costinfo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.transaction.order.controller.admin.costinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.costinfo.CostInfoDO;
import cn.acsm.module.transaction.order.dal.mysql.costinfo.CostInfoMapper;
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
* {@link CostInfoServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(CostInfoServiceImpl.class)
public class CostInfoServiceImplTest extends BaseDbUnitTest {

    @Resource
    private CostInfoServiceImpl costInfoService;

    @Resource
    private CostInfoMapper costInfoMapper;

    @Test
    public void testCreateCostInfo_success() {
        // 准备参数
        CostInfoCreateReqVO reqVO = randomPojo(CostInfoCreateReqVO.class);

        // 调用
        String costInfoId = costInfoService.createCostInfo(reqVO);
        // 断言
        assertNotNull(costInfoId);
        // 校验记录的属性是否正确
        CostInfoDO costInfo = costInfoMapper.selectById(costInfoId);
        assertPojoEquals(reqVO, costInfo);
    }

    @Test
    public void testUpdateCostInfo_success() {
        // mock 数据
        CostInfoDO dbCostInfo = randomPojo(CostInfoDO.class);
        costInfoMapper.insert(dbCostInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        CostInfoUpdateReqVO reqVO = randomPojo(CostInfoUpdateReqVO.class, o -> {
            o.setId(dbCostInfo.getId()); // 设置更新的 ID
        });

        // 调用
        costInfoService.updateCostInfo(reqVO);
        // 校验是否更新正确
        CostInfoDO costInfo = costInfoMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, costInfo);
    }

    @Test
    public void testUpdateCostInfo_notExists() {
        // 准备参数
        CostInfoUpdateReqVO reqVO = randomPojo(CostInfoUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> costInfoService.updateCostInfo(reqVO), COST_INFO_NOT_EXISTS);
    }

    @Test
    public void testDeleteCostInfo_success() {
        // mock 数据
        CostInfoDO dbCostInfo = randomPojo(CostInfoDO.class);
        costInfoMapper.insert(dbCostInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbCostInfo.getId();

        // 调用
        costInfoService.deleteCostInfo(id);
       // 校验数据不存在了
       assertNull(costInfoMapper.selectById(id));
    }

    @Test
    public void testDeleteCostInfo_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> costInfoService.deleteCostInfo(id), COST_INFO_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetCostInfoPage() {
       // mock 数据
       CostInfoDO dbCostInfo = randomPojo(CostInfoDO.class, o -> { // 等会查询到
           o.setCostNumber(null);
           o.setCreateTime(null);
       });
       costInfoMapper.insert(dbCostInfo);
       // 测试 costNumber 不匹配
       costInfoMapper.insert(cloneIgnoreId(dbCostInfo, o -> o.setCostNumber(null)));
       // 测试 createTime 不匹配
       costInfoMapper.insert(cloneIgnoreId(dbCostInfo, o -> o.setCreateTime(null)));
       // 准备参数
       CostInfoPageReqVO reqVO = new CostInfoPageReqVO();
       reqVO.setCostNumber(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<CostInfoDO> pageResult = costInfoService.getCostInfoPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbCostInfo, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetCostInfoList() {
       // mock 数据
       CostInfoDO dbCostInfo = randomPojo(CostInfoDO.class, o -> { // 等会查询到
           o.setCostNumber(null);
           o.setCreateTime(null);
       });
       costInfoMapper.insert(dbCostInfo);
       // 测试 costNumber 不匹配
       costInfoMapper.insert(cloneIgnoreId(dbCostInfo, o -> o.setCostNumber(null)));
       // 测试 createTime 不匹配
       costInfoMapper.insert(cloneIgnoreId(dbCostInfo, o -> o.setCreateTime(null)));
       // 准备参数
       CostInfoExportReqVO reqVO = new CostInfoExportReqVO();
       reqVO.setCostNumber(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<CostInfoDO> list = costInfoService.getCostInfoList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbCostInfo, list.get(0));
    }

}
