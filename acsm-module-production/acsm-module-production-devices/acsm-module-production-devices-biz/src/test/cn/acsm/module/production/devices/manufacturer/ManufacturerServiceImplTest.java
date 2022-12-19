package cn.acsm.module.production.devices.service.manufacturer;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.module.infra.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.production.devices.controller.admin.manufacturer.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.manufacturer.ManufacturerDO;
import cn.acsm.module.production.devices.dal.mysql.manufacturer.ManufacturerMapper;
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
* {@link ManufacturerServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(ManufacturerServiceImpl.class)
public class ManufacturerServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ManufacturerServiceImpl manufacturerService;

    @Resource
    private ManufacturerMapper manufacturerMapper;

    @Test
    public void testCreateManufacturer_success() {
        // 准备参数
        ManufacturerCreateReqVO reqVO = randomPojo(ManufacturerCreateReqVO.class);

        // 调用
        Long manufacturerId = manufacturerService.createManufacturer(reqVO);
        // 断言
        assertNotNull(manufacturerId);
        // 校验记录的属性是否正确
        ManufacturerDO manufacturer = manufacturerMapper.selectById(manufacturerId);
        assertPojoEquals(reqVO, manufacturer);
    }

    @Test
    public void testUpdateManufacturer_success() {
        // mock 数据
        ManufacturerDO dbManufacturer = randomPojo(ManufacturerDO.class);
        manufacturerMapper.insert(dbManufacturer);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ManufacturerUpdateReqVO reqVO = randomPojo(ManufacturerUpdateReqVO.class, o -> {
            o.setId(dbManufacturer.getId()); // 设置更新的 ID
        });

        // 调用
        manufacturerService.updateManufacturer(reqVO);
        // 校验是否更新正确
        ManufacturerDO manufacturer = manufacturerMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, manufacturer);
    }

    @Test
    public void testUpdateManufacturer_notExists() {
        // 准备参数
        ManufacturerUpdateReqVO reqVO = randomPojo(ManufacturerUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> manufacturerService.updateManufacturer(reqVO), MANUFACTURER_NOT_EXISTS);
    }

    @Test
    public void testDeleteManufacturer_success() {
        // mock 数据
        ManufacturerDO dbManufacturer = randomPojo(ManufacturerDO.class);
        manufacturerMapper.insert(dbManufacturer);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbManufacturer.getId();

        // 调用
        manufacturerService.deleteManufacturer(id);
       // 校验数据不存在了
       assertNull(manufacturerMapper.selectById(id));
    }

    @Test
    public void testDeleteManufacturer_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> manufacturerService.deleteManufacturer(id), MANUFACTURER_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetManufacturerPage() {
       // mock 数据
       ManufacturerDO dbManufacturer = randomPojo(ManufacturerDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       manufacturerMapper.insert(dbManufacturer);
       // 测试 name 不匹配
       manufacturerMapper.insert(cloneIgnoreId(dbManufacturer, o -> o.setName(null)));
       // 测试 createTime 不匹配
       manufacturerMapper.insert(cloneIgnoreId(dbManufacturer, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       manufacturerMapper.insert(cloneIgnoreId(dbManufacturer, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       manufacturerMapper.insert(cloneIgnoreId(dbManufacturer, o -> o.setSubjectId(null)));
       // 准备参数
       ManufacturerPageReqVO reqVO = new ManufacturerPageReqVO();
       reqVO.setName(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       PageResult<ManufacturerDO> pageResult = manufacturerService.getManufacturerPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbManufacturer, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetManufacturerList() {
       // mock 数据
       ManufacturerDO dbManufacturer = randomPojo(ManufacturerDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       manufacturerMapper.insert(dbManufacturer);
       // 测试 name 不匹配
       manufacturerMapper.insert(cloneIgnoreId(dbManufacturer, o -> o.setName(null)));
       // 测试 createTime 不匹配
       manufacturerMapper.insert(cloneIgnoreId(dbManufacturer, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       manufacturerMapper.insert(cloneIgnoreId(dbManufacturer, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       manufacturerMapper.insert(cloneIgnoreId(dbManufacturer, o -> o.setSubjectId(null)));
       // 准备参数
       ManufacturerExportReqVO reqVO = new ManufacturerExportReqVO();
       reqVO.setName(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       List<ManufacturerDO> list = manufacturerService.getManufacturerList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbManufacturer, list.get(0));
    }

}
