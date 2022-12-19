package cn.acsm.module.production.devices.service.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.module.infra.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.production.devices.controller.admin.model.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.model.ModelDO;
import cn.acsm.module.production.devices.dal.mysql.model.ModelMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.acsm.module.production.devices.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.module.infra.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.module.infra.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link ModelServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(ModelServiceImpl.class)
public class ModelServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ModelServiceImpl modelService;

    @Resource
    private ModelMapper modelMapper;

    @Test
    public void testCreateModel_success() {
        // 准备参数
        ModelCreateReqVO reqVO = randomPojo(ModelCreateReqVO.class);

        // 调用
        Long modelId = modelService.createModel(reqVO);
        // 断言
        assertNotNull(modelId);
        // 校验记录的属性是否正确
        ModelDO model = modelMapper.selectById(modelId);
        assertPojoEquals(reqVO, model);
    }

    @Test
    public void testUpdateModel_success() {
        // mock 数据
        ModelDO dbModel = randomPojo(ModelDO.class);
        modelMapper.insert(dbModel);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ModelUpdateReqVO reqVO = randomPojo(ModelUpdateReqVO.class, o -> {
            o.setId(dbModel.getId()); // 设置更新的 ID
        });

        // 调用
        modelService.updateModel(reqVO);
        // 校验是否更新正确
        ModelDO model = modelMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, model);
    }

    @Test
    public void testUpdateModel_notExists() {
        // 准备参数
        ModelUpdateReqVO reqVO = randomPojo(ModelUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> modelService.updateModel(reqVO), MODEL_NOT_EXISTS);
    }

    @Test
    public void testDeleteModel_success() {
        // mock 数据
        ModelDO dbModel = randomPojo(ModelDO.class);
        modelMapper.insert(dbModel);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbModel.getId();

        // 调用
        modelService.deleteModel(id);
       // 校验数据不存在了
       assertNull(modelMapper.selectById(id));
    }

    @Test
    public void testDeleteModel_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> modelService.deleteModel(id), MODEL_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetModelPage() {
       // mock 数据
       ModelDO dbModel = randomPojo(ModelDO.class, o -> { // 等会查询到
           o.setManufacturerId(null);
           o.setName(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       modelMapper.insert(dbModel);
       // 测试 manufacturerId 不匹配
       modelMapper.insert(cloneIgnoreId(dbModel, o -> o.setManufacturerId(null)));
       // 测试 name 不匹配
       modelMapper.insert(cloneIgnoreId(dbModel, o -> o.setName(null)));
       // 测试 createTime 不匹配
       modelMapper.insert(cloneIgnoreId(dbModel, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       modelMapper.insert(cloneIgnoreId(dbModel, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       modelMapper.insert(cloneIgnoreId(dbModel, o -> o.setSubjectId(null)));
       // 准备参数
       ModelPageReqVO reqVO = new ModelPageReqVO();
       reqVO.setManufacturerId(null);
       reqVO.setName(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       PageResult<ModelDO> pageResult = modelService.getModelPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbModel, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetModelList() {
       // mock 数据
       ModelDO dbModel = randomPojo(ModelDO.class, o -> { // 等会查询到
           o.setManufacturerId(null);
           o.setName(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       modelMapper.insert(dbModel);
       // 测试 manufacturerId 不匹配
       modelMapper.insert(cloneIgnoreId(dbModel, o -> o.setManufacturerId(null)));
       // 测试 name 不匹配
       modelMapper.insert(cloneIgnoreId(dbModel, o -> o.setName(null)));
       // 测试 createTime 不匹配
       modelMapper.insert(cloneIgnoreId(dbModel, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       modelMapper.insert(cloneIgnoreId(dbModel, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       modelMapper.insert(cloneIgnoreId(dbModel, o -> o.setSubjectId(null)));
       // 准备参数
       ModelExportReqVO reqVO = new ModelExportReqVO();
       reqVO.setManufacturerId(null);
       reqVO.setName(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       List<ModelDO> list = modelService.getModelList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbModel, list.get(0));
    }

}
