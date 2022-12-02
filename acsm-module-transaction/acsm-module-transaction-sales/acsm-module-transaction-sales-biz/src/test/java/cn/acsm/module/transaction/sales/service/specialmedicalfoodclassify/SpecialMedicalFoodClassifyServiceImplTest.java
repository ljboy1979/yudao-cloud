package cn.acsm.module.transaction.sales.service.specialmedicalfoodclassify;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodclassify.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.specialmedicalfoodclassify.SpecialMedicalFoodClassifyDO;
import cn.acsm.module.transaction.sales.dal.mysql.specialmedicalfoodclassify.SpecialMedicalFoodClassifyMapper;
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
* {@link SpecialMedicalFoodClassifyServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(SpecialMedicalFoodClassifyServiceImpl.class)
public class SpecialMedicalFoodClassifyServiceImplTest extends BaseDbUnitTest {

    @Resource
    private SpecialMedicalFoodClassifyServiceImpl specialMedicalFoodClassifyService;

    @Resource
    private SpecialMedicalFoodClassifyMapper specialMedicalFoodClassifyMapper;

    @Test
    public void testCreateSpecialMedicalFoodClassify_success() {
        // 准备参数
        SpecialMedicalFoodClassifyCreateReqVO reqVO = randomPojo(SpecialMedicalFoodClassifyCreateReqVO.class);

        // 调用
        String specialMedicalFoodClassifyId = specialMedicalFoodClassifyService.createSpecialMedicalFoodClassify(reqVO);
        // 断言
        assertNotNull(specialMedicalFoodClassifyId);
        // 校验记录的属性是否正确
        SpecialMedicalFoodClassifyDO specialMedicalFoodClassify = specialMedicalFoodClassifyMapper.selectById(specialMedicalFoodClassifyId);
        assertPojoEquals(reqVO, specialMedicalFoodClassify);
    }

    @Test
    public void testUpdateSpecialMedicalFoodClassify_success() {
        // mock 数据
        SpecialMedicalFoodClassifyDO dbSpecialMedicalFoodClassify = randomPojo(SpecialMedicalFoodClassifyDO.class);
        specialMedicalFoodClassifyMapper.insert(dbSpecialMedicalFoodClassify);// @Sql: 先插入出一条存在的数据
        // 准备参数
        SpecialMedicalFoodClassifyUpdateReqVO reqVO = randomPojo(SpecialMedicalFoodClassifyUpdateReqVO.class, o -> {
            o.setId(dbSpecialMedicalFoodClassify.getId()); // 设置更新的 ID
        });

        // 调用
        specialMedicalFoodClassifyService.updateSpecialMedicalFoodClassify(reqVO);
        // 校验是否更新正确
        SpecialMedicalFoodClassifyDO specialMedicalFoodClassify = specialMedicalFoodClassifyMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, specialMedicalFoodClassify);
    }

    @Test
    public void testUpdateSpecialMedicalFoodClassify_notExists() {
        // 准备参数
        SpecialMedicalFoodClassifyUpdateReqVO reqVO = randomPojo(SpecialMedicalFoodClassifyUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> specialMedicalFoodClassifyService.updateSpecialMedicalFoodClassify(reqVO), SPECIAL_MEDICAL_FOOD_CLASSIFY_NOT_EXISTS);
    }

    @Test
    public void testDeleteSpecialMedicalFoodClassify_success() {
        // mock 数据
        SpecialMedicalFoodClassifyDO dbSpecialMedicalFoodClassify = randomPojo(SpecialMedicalFoodClassifyDO.class);
        specialMedicalFoodClassifyMapper.insert(dbSpecialMedicalFoodClassify);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbSpecialMedicalFoodClassify.getId();

        // 调用
        specialMedicalFoodClassifyService.deleteSpecialMedicalFoodClassify(id);
       // 校验数据不存在了
       assertNull(specialMedicalFoodClassifyMapper.selectById(id));
    }

    @Test
    public void testDeleteSpecialMedicalFoodClassify_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> specialMedicalFoodClassifyService.deleteSpecialMedicalFoodClassify(id), SPECIAL_MEDICAL_FOOD_CLASSIFY_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetSpecialMedicalFoodClassifyPage() {
       // mock 数据
       SpecialMedicalFoodClassifyDO dbSpecialMedicalFoodClassify = randomPojo(SpecialMedicalFoodClassifyDO.class, o -> { // 等会查询到
           o.setCategoryName(null);
           o.setCreateTime(null);
       });
       specialMedicalFoodClassifyMapper.insert(dbSpecialMedicalFoodClassify);
       // 测试 categoryName 不匹配
       specialMedicalFoodClassifyMapper.insert(cloneIgnoreId(dbSpecialMedicalFoodClassify, o -> o.setCategoryName(null)));
       // 测试 createTime 不匹配
       specialMedicalFoodClassifyMapper.insert(cloneIgnoreId(dbSpecialMedicalFoodClassify, o -> o.setCreateTime(null)));
       // 准备参数
       SpecialMedicalFoodClassifyPageReqVO reqVO = new SpecialMedicalFoodClassifyPageReqVO();
       reqVO.setCategoryName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<SpecialMedicalFoodClassifyDO> pageResult = specialMedicalFoodClassifyService.getSpecialMedicalFoodClassifyPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbSpecialMedicalFoodClassify, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetSpecialMedicalFoodClassifyList() {
       // mock 数据
       SpecialMedicalFoodClassifyDO dbSpecialMedicalFoodClassify = randomPojo(SpecialMedicalFoodClassifyDO.class, o -> { // 等会查询到
           o.setCategoryName(null);
           o.setCreateTime(null);
       });
       specialMedicalFoodClassifyMapper.insert(dbSpecialMedicalFoodClassify);
       // 测试 categoryName 不匹配
       specialMedicalFoodClassifyMapper.insert(cloneIgnoreId(dbSpecialMedicalFoodClassify, o -> o.setCategoryName(null)));
       // 测试 createTime 不匹配
       specialMedicalFoodClassifyMapper.insert(cloneIgnoreId(dbSpecialMedicalFoodClassify, o -> o.setCreateTime(null)));
       // 准备参数
       SpecialMedicalFoodClassifyExportReqVO reqVO = new SpecialMedicalFoodClassifyExportReqVO();
       reqVO.setCategoryName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<SpecialMedicalFoodClassifyDO> list = specialMedicalFoodClassifyService.getSpecialMedicalFoodClassifyList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbSpecialMedicalFoodClassify, list.get(0));
    }

}
