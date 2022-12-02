package cn.acsm.module.transaction.sales.service.specialmedicalfoodspecification;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodspecification.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.specialmedicalfoodspecification.SpecialMedicalFoodSpecificationDO;
import cn.acsm.module.transaction.sales.dal.mysql.specialmedicalfoodspecification.SpecialMedicalFoodSpecificationMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link SpecialMedicalFoodSpecificationServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(SpecialMedicalFoodSpecificationServiceImpl.class)
public class SpecialMedicalFoodSpecificationServiceImplTest extends BaseDbUnitTest {

    @Resource
    private SpecialMedicalFoodSpecificationServiceImpl specialMedicalFoodSpecificationService;

    @Resource
    private SpecialMedicalFoodSpecificationMapper specialMedicalFoodSpecificationMapper;

    @Test
    public void testCreateSpecialMedicalFoodSpecification_success() {
        // 准备参数
        SpecialMedicalFoodSpecificationCreateReqVO reqVO = randomPojo(SpecialMedicalFoodSpecificationCreateReqVO.class);

        // 调用
        CommonResult<String> result = specialMedicalFoodSpecificationService.createSpecialMedicalFoodSpecification(reqVO);
        // 断言
        assertNotNull(result.getData());
        // 校验记录的属性是否正确
        SpecialMedicalFoodSpecificationDO specialMedicalFoodSpecification = specialMedicalFoodSpecificationMapper.selectById(result.getData());
        assertPojoEquals(reqVO, specialMedicalFoodSpecification);
    }

    @Test
    public void testUpdateSpecialMedicalFoodSpecification_success() {
        // mock 数据
        SpecialMedicalFoodSpecificationDO dbSpecialMedicalFoodSpecification = randomPojo(SpecialMedicalFoodSpecificationDO.class);
        specialMedicalFoodSpecificationMapper.insert(dbSpecialMedicalFoodSpecification);// @Sql: 先插入出一条存在的数据
        // 准备参数
        SpecialMedicalFoodSpecificationUpdateReqVO reqVO = randomPojo(SpecialMedicalFoodSpecificationUpdateReqVO.class, o -> {
            o.setId(dbSpecialMedicalFoodSpecification.getId()); // 设置更新的 ID
        });

        // 调用
        specialMedicalFoodSpecificationService.updateSpecialMedicalFoodSpecification(reqVO);
        // 校验是否更新正确
        SpecialMedicalFoodSpecificationDO specialMedicalFoodSpecification = specialMedicalFoodSpecificationMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, specialMedicalFoodSpecification);
    }

    @Test
    public void testUpdateSpecialMedicalFoodSpecification_notExists() {
        // 准备参数
        SpecialMedicalFoodSpecificationUpdateReqVO reqVO = randomPojo(SpecialMedicalFoodSpecificationUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> specialMedicalFoodSpecificationService.updateSpecialMedicalFoodSpecification(reqVO), SPECIAL_MEDICAL_FOOD_SPECIFICATION_NOT_EXISTS);
    }

    @Test
    public void testDeleteSpecialMedicalFoodSpecification_success() {
        // mock 数据
        SpecialMedicalFoodSpecificationDO dbSpecialMedicalFoodSpecification = randomPojo(SpecialMedicalFoodSpecificationDO.class);
        specialMedicalFoodSpecificationMapper.insert(dbSpecialMedicalFoodSpecification);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbSpecialMedicalFoodSpecification.getId();

        // 调用
        specialMedicalFoodSpecificationService.deleteSpecialMedicalFoodSpecification(id);
       // 校验数据不存在了
       assertNull(specialMedicalFoodSpecificationMapper.selectById(id));
    }

    @Test
    public void testDeleteSpecialMedicalFoodSpecification_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> specialMedicalFoodSpecificationService.deleteSpecialMedicalFoodSpecification(id), SPECIAL_MEDICAL_FOOD_SPECIFICATION_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetSpecialMedicalFoodSpecificationPage() {
       // mock 数据
       SpecialMedicalFoodSpecificationDO dbSpecialMedicalFoodSpecification = randomPojo(SpecialMedicalFoodSpecificationDO.class, o -> { // 等会查询到
           o.setFoodId(null);
           o.setSpecificationsName(null);
           o.setCreateTime(null);
       });
       specialMedicalFoodSpecificationMapper.insert(dbSpecialMedicalFoodSpecification);
       // 测试 commodityId 不匹配
       specialMedicalFoodSpecificationMapper.insert(cloneIgnoreId(dbSpecialMedicalFoodSpecification, o -> o.setFoodId(null)));
       // 测试 specificationsName 不匹配
       specialMedicalFoodSpecificationMapper.insert(cloneIgnoreId(dbSpecialMedicalFoodSpecification, o -> o.setSpecificationsName(null)));
       // 测试 createTime 不匹配
       specialMedicalFoodSpecificationMapper.insert(cloneIgnoreId(dbSpecialMedicalFoodSpecification, o -> o.setCreateTime(null)));
       // 准备参数
       SpecialMedicalFoodSpecificationPageReqVO reqVO = new SpecialMedicalFoodSpecificationPageReqVO();
       reqVO.setFoodId(null);
       reqVO.setSpecificationsName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<SpecialMedicalFoodSpecificationDO> pageResult = specialMedicalFoodSpecificationService.getSpecialMedicalFoodSpecificationPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbSpecialMedicalFoodSpecification, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetSpecialMedicalFoodSpecificationList() {
       // mock 数据
       SpecialMedicalFoodSpecificationDO dbSpecialMedicalFoodSpecification = randomPojo(SpecialMedicalFoodSpecificationDO.class, o -> { // 等会查询到
           o.setFoodId(null);
           o.setSpecificationsName(null);
           o.setCreateTime(null);
       });
       specialMedicalFoodSpecificationMapper.insert(dbSpecialMedicalFoodSpecification);
       // 测试 commodityId 不匹配
       specialMedicalFoodSpecificationMapper.insert(cloneIgnoreId(dbSpecialMedicalFoodSpecification, o -> o.setFoodId(null)));
       // 测试 specificationsName 不匹配
       specialMedicalFoodSpecificationMapper.insert(cloneIgnoreId(dbSpecialMedicalFoodSpecification, o -> o.setSpecificationsName(null)));
       // 测试 createTime 不匹配
       specialMedicalFoodSpecificationMapper.insert(cloneIgnoreId(dbSpecialMedicalFoodSpecification, o -> o.setCreateTime(null)));
       // 准备参数
       SpecialMedicalFoodSpecificationExportReqVO reqVO = new SpecialMedicalFoodSpecificationExportReqVO();
       reqVO.setFoodId(null);
       reqVO.setSpecificationsName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<SpecialMedicalFoodSpecificationDO> list = specialMedicalFoodSpecificationService.getSpecialMedicalFoodSpecificationList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbSpecialMedicalFoodSpecification, list.get(0));
    }

}
