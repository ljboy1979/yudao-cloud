package cn.acsm.module.transaction.sales.service.specialmedicalfoodorganization;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodorganization.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.specialmedicalfoodorganization.SpecialMedicalFoodOrganizationDO;
import cn.acsm.module.transaction.sales.dal.mysql.specialmedicalfoodorganization.SpecialMedicalFoodOrganizationMapper;
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
* {@link SpecialMedicalFoodOrganizationServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(SpecialMedicalFoodOrganizationServiceImpl.class)
public class SpecialMedicalFoodOrganizationServiceImplTest extends BaseDbUnitTest {

    @Resource
    private SpecialMedicalFoodOrganizationServiceImpl specialMedicalFoodOrganizationService;

    @Resource
    private SpecialMedicalFoodOrganizationMapper specialMedicalFoodOrganizationMapper;

    @Test
    public void testCreateSpecialMedicalFoodOrganization_success() {
        // 准备参数
        SpecialMedicalFoodOrganizationCreateReqVO reqVO = randomPojo(SpecialMedicalFoodOrganizationCreateReqVO.class);

        // 调用
        String specialMedicalFoodOrganizationId = specialMedicalFoodOrganizationService.createSpecialMedicalFoodOrganization(reqVO);
        // 断言
        assertNotNull(specialMedicalFoodOrganizationId);
        // 校验记录的属性是否正确
        SpecialMedicalFoodOrganizationDO specialMedicalFoodOrganization = specialMedicalFoodOrganizationMapper.selectById(specialMedicalFoodOrganizationId);
        assertPojoEquals(reqVO, specialMedicalFoodOrganization);
    }

    @Test
    public void testUpdateSpecialMedicalFoodOrganization_success() {
        // mock 数据
        SpecialMedicalFoodOrganizationDO dbSpecialMedicalFoodOrganization = randomPojo(SpecialMedicalFoodOrganizationDO.class);
        specialMedicalFoodOrganizationMapper.insert(dbSpecialMedicalFoodOrganization);// @Sql: 先插入出一条存在的数据
        // 准备参数
        SpecialMedicalFoodOrganizationUpdateReqVO reqVO = randomPojo(SpecialMedicalFoodOrganizationUpdateReqVO.class, o -> {
            o.setId(dbSpecialMedicalFoodOrganization.getId()); // 设置更新的 ID
        });

        // 调用
        specialMedicalFoodOrganizationService.updateSpecialMedicalFoodOrganization(reqVO);
        // 校验是否更新正确
        SpecialMedicalFoodOrganizationDO specialMedicalFoodOrganization = specialMedicalFoodOrganizationMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, specialMedicalFoodOrganization);
    }

    @Test
    public void testUpdateSpecialMedicalFoodOrganization_notExists() {
        // 准备参数
        SpecialMedicalFoodOrganizationUpdateReqVO reqVO = randomPojo(SpecialMedicalFoodOrganizationUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> specialMedicalFoodOrganizationService.updateSpecialMedicalFoodOrganization(reqVO), SPECIAL_MEDICAL_FOOD_ORGANIZATION_NOT_EXISTS);
    }

    @Test
    public void testDeleteSpecialMedicalFoodOrganization_success() {
        // mock 数据
        SpecialMedicalFoodOrganizationDO dbSpecialMedicalFoodOrganization = randomPojo(SpecialMedicalFoodOrganizationDO.class);
        specialMedicalFoodOrganizationMapper.insert(dbSpecialMedicalFoodOrganization);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbSpecialMedicalFoodOrganization.getId();

        // 调用
        specialMedicalFoodOrganizationService.deleteSpecialMedicalFoodOrganization(id);
       // 校验数据不存在了
       assertNull(specialMedicalFoodOrganizationMapper.selectById(id));
    }

    @Test
    public void testDeleteSpecialMedicalFoodOrganization_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> specialMedicalFoodOrganizationService.deleteSpecialMedicalFoodOrganization(id), SPECIAL_MEDICAL_FOOD_ORGANIZATION_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetSpecialMedicalFoodOrganizationPage() {
       // mock 数据
       SpecialMedicalFoodOrganizationDO dbSpecialMedicalFoodOrganization = randomPojo(SpecialMedicalFoodOrganizationDO.class, o -> { // 等会查询到
           o.setFoodId(null);
           o.setOrganizationName(null);
           o.setCreateTime(null);
       });
       specialMedicalFoodOrganizationMapper.insert(dbSpecialMedicalFoodOrganization);
       // 测试 foodId 不匹配
       specialMedicalFoodOrganizationMapper.insert(cloneIgnoreId(dbSpecialMedicalFoodOrganization, o -> o.setFoodId(null)));
       // 测试 organizationName 不匹配
       specialMedicalFoodOrganizationMapper.insert(cloneIgnoreId(dbSpecialMedicalFoodOrganization, o -> o.setOrganizationName(null)));
       // 测试 createTime 不匹配
       specialMedicalFoodOrganizationMapper.insert(cloneIgnoreId(dbSpecialMedicalFoodOrganization, o -> o.setCreateTime(null)));
       // 准备参数
       SpecialMedicalFoodOrganizationPageReqVO reqVO = new SpecialMedicalFoodOrganizationPageReqVO();
       reqVO.setFoodId(null);
       reqVO.setOrganizationName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<SpecialMedicalFoodOrganizationDO> pageResult = specialMedicalFoodOrganizationService.getSpecialMedicalFoodOrganizationPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbSpecialMedicalFoodOrganization, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetSpecialMedicalFoodOrganizationList() {
       // mock 数据
       SpecialMedicalFoodOrganizationDO dbSpecialMedicalFoodOrganization = randomPojo(SpecialMedicalFoodOrganizationDO.class, o -> { // 等会查询到
           o.setFoodId(null);
           o.setOrganizationName(null);
           o.setCreateTime(null);
       });
       specialMedicalFoodOrganizationMapper.insert(dbSpecialMedicalFoodOrganization);
       // 测试 foodId 不匹配
       specialMedicalFoodOrganizationMapper.insert(cloneIgnoreId(dbSpecialMedicalFoodOrganization, o -> o.setFoodId(null)));
       // 测试 organizationName 不匹配
       specialMedicalFoodOrganizationMapper.insert(cloneIgnoreId(dbSpecialMedicalFoodOrganization, o -> o.setOrganizationName(null)));
       // 测试 createTime 不匹配
       specialMedicalFoodOrganizationMapper.insert(cloneIgnoreId(dbSpecialMedicalFoodOrganization, o -> o.setCreateTime(null)));
       // 准备参数
       SpecialMedicalFoodOrganizationExportReqVO reqVO = new SpecialMedicalFoodOrganizationExportReqVO();
       reqVO.setFoodId(null);
       reqVO.setOrganizationName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<SpecialMedicalFoodOrganizationDO> list = specialMedicalFoodOrganizationService.getSpecialMedicalFoodOrganizationList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbSpecialMedicalFoodOrganization, list.get(0));
    }

}
