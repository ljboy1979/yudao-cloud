package cn.acsm.module.purchase.service.receivingstandard;

import cn.acsm.module.purchase.controller.admin.receivingstandard.vo.PurchaseReceivingStandardCreateReqVO;
import cn.acsm.module.purchase.controller.admin.receivingstandard.vo.PurchaseReceivingStandardExportReqVO;
import cn.acsm.module.purchase.controller.admin.receivingstandard.vo.PurchaseReceivingStandardPageReqVO;
import cn.acsm.module.purchase.controller.admin.receivingstandard.vo.PurchaseReceivingStandardUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.receivingstandard.PurchaseReceivingStandardDO;
import cn.acsm.module.purchase.dal.mysql.receivingstandard.PurchaseReceivingStandardMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;


import org.springframework.context.annotation.Import;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static cn.acsm.module.purchase.enums.ErrorCodeConstants.RECEIVING_STANDARD_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link PurchaseReceivingStandardServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(PurchaseReceivingStandardServiceImpl.class)
public class PurchaseReceivingStandardServiceImplTest extends BaseDbUnitTest {

    @Resource
    private PurchaseReceivingStandardServiceImpl receivingStandardService;

    @Resource
    private PurchaseReceivingStandardMapper receivingStandardMapper;

    @Test
    public void testCreateReceivingStandard_success() {
        // 准备参数
        PurchaseReceivingStandardCreateReqVO reqVO = randomPojo(PurchaseReceivingStandardCreateReqVO.class);

        // 调用
        Long receivingStandardId = receivingStandardService.createReceivingStandard(reqVO);
        // 断言
        assertNotNull(receivingStandardId);
        // 校验记录的属性是否正确
        PurchaseReceivingStandardDO receivingStandard = receivingStandardMapper.selectById(receivingStandardId);
        assertPojoEquals(reqVO, receivingStandard);
    }

    @Test
    public void testUpdateReceivingStandard_success() {
        // mock 数据
        PurchaseReceivingStandardDO dbReceivingStandard = randomPojo(PurchaseReceivingStandardDO.class);
        receivingStandardMapper.insert(dbReceivingStandard);// @Sql: 先插入出一条存在的数据
        // 准备参数
        PurchaseReceivingStandardUpdateReqVO reqVO = randomPojo(PurchaseReceivingStandardUpdateReqVO.class, o -> {
            o.setId(dbReceivingStandard.getId()); // 设置更新的 ID
        });

        // 调用
        receivingStandardService.updateReceivingStandard(reqVO);
        // 校验是否更新正确
        PurchaseReceivingStandardDO receivingStandard = receivingStandardMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, receivingStandard);
    }

    @Test
    public void testUpdateReceivingStandard_notExists() {
        // 准备参数
        PurchaseReceivingStandardUpdateReqVO reqVO = randomPojo(PurchaseReceivingStandardUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> receivingStandardService.updateReceivingStandard(reqVO), RECEIVING_STANDARD_NOT_EXISTS);
    }

    @Test
    public void testDeleteReceivingStandard_success() {
        // mock 数据
        PurchaseReceivingStandardDO dbReceivingStandard = randomPojo(PurchaseReceivingStandardDO.class);
        receivingStandardMapper.insert(dbReceivingStandard);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbReceivingStandard.getId();

        // 调用
        receivingStandardService.deleteReceivingStandard(id);
       // 校验数据不存在了
       assertNull(receivingStandardMapper.selectById(id));
    }

    @Test
    public void testDeleteReceivingStandard_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> receivingStandardService.deleteReceivingStandard(id), RECEIVING_STANDARD_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetReceivingStandardPage() {
       // mock 数据
       PurchaseReceivingStandardDO dbReceivingStandard = randomPojo(PurchaseReceivingStandardDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setUpperLimit(null);
           o.setLowerLimit(null);
           o.setUnit(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
       });
       receivingStandardMapper.insert(dbReceivingStandard);
       // 测试 name 不匹配
       receivingStandardMapper.insert(cloneIgnoreId(dbReceivingStandard, o -> o.setName(null)));
       // 测试 upperLimit 不匹配
       receivingStandardMapper.insert(cloneIgnoreId(dbReceivingStandard, o -> o.setUpperLimit(null)));
       // 测试 lowerLimit 不匹配
       receivingStandardMapper.insert(cloneIgnoreId(dbReceivingStandard, o -> o.setLowerLimit(null)));
       // 测试 unit 不匹配
       receivingStandardMapper.insert(cloneIgnoreId(dbReceivingStandard, o -> o.setUnit(null)));
       // 测试 createTime 不匹配
       receivingStandardMapper.insert(cloneIgnoreId(dbReceivingStandard, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       receivingStandardMapper.insert(cloneIgnoreId(dbReceivingStandard, o -> o.setSubjectId(null)));
       // 准备参数
       PurchaseReceivingStandardPageReqVO reqVO = new PurchaseReceivingStandardPageReqVO();
       reqVO.setName(null);
       reqVO.setUpperLimit(null);
       reqVO.setLowerLimit(null);
       reqVO.setUnit(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);

       // 调用
       PageResult<PurchaseReceivingStandardDO> pageResult = receivingStandardService.getReceivingStandardPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbReceivingStandard, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetReceivingStandardList() {
       // mock 数据
       PurchaseReceivingStandardDO dbReceivingStandard = randomPojo(PurchaseReceivingStandardDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setUpperLimit(null);
           o.setLowerLimit(null);
           o.setUnit(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
       });
       receivingStandardMapper.insert(dbReceivingStandard);
       // 测试 name 不匹配
       receivingStandardMapper.insert(cloneIgnoreId(dbReceivingStandard, o -> o.setName(null)));
       // 测试 upperLimit 不匹配
       receivingStandardMapper.insert(cloneIgnoreId(dbReceivingStandard, o -> o.setUpperLimit(null)));
       // 测试 lowerLimit 不匹配
       receivingStandardMapper.insert(cloneIgnoreId(dbReceivingStandard, o -> o.setLowerLimit(null)));
       // 测试 unit 不匹配
       receivingStandardMapper.insert(cloneIgnoreId(dbReceivingStandard, o -> o.setUnit(null)));
       // 测试 createTime 不匹配
       receivingStandardMapper.insert(cloneIgnoreId(dbReceivingStandard, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       receivingStandardMapper.insert(cloneIgnoreId(dbReceivingStandard, o -> o.setSubjectId(null)));
       // 准备参数
       PurchaseReceivingStandardExportReqVO reqVO = new PurchaseReceivingStandardExportReqVO();
       reqVO.setName(null);
       reqVO.setUpperLimit(null);
       reqVO.setLowerLimit(null);
       reqVO.setUnit(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);

       // 调用
       List<PurchaseReceivingStandardDO> list = receivingStandardService.getReceivingStandardList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbReceivingStandard, list.get(0));
    }

}
