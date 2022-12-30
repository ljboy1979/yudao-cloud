package cn.iocoder.yudao.module.infra.module.facility.service.cargospace;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.module.infra.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.infra.module.facility.controller.admin.cargospace.vo.*;
import cn.iocoder.yudao.module.infra.module.facility.dal.dataobject.cargospace.CargoSpaceDO;
import cn.iocoder.yudao.module.infra.module.facility.dal.mysql.cargospace.CargoSpaceMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.module.infra.module.facility.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.module.infra.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.module.infra.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link CargoSpaceServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(CargoSpaceServiceImpl.class)
public class CargoSpaceServiceImplTest extends BaseDbUnitTest {

    @Resource
    private CargoSpaceServiceImpl cargoSpaceService;

    @Resource
    private CargoSpaceMapper cargoSpaceMapper;

    @Test
    public void testCreateCargoSpace_success() {
        // 准备参数
        CargoSpaceCreateReqVO reqVO = randomPojo(CargoSpaceCreateReqVO.class);

        // 调用
        Long cargoSpaceId = cargoSpaceService.createCargoSpace(reqVO);
        // 断言
        assertNotNull(cargoSpaceId);
        // 校验记录的属性是否正确
        CargoSpaceDO cargoSpace = cargoSpaceMapper.selectById(cargoSpaceId);
        assertPojoEquals(reqVO, cargoSpace);
    }

    @Test
    public void testUpdateCargoSpace_success() {
        // mock 数据
        CargoSpaceDO dbCargoSpace = randomPojo(CargoSpaceDO.class);
        cargoSpaceMapper.insert(dbCargoSpace);// @Sql: 先插入出一条存在的数据
        // 准备参数
        CargoSpaceUpdateReqVO reqVO = randomPojo(CargoSpaceUpdateReqVO.class, o -> {
            o.setId(dbCargoSpace.getId()); // 设置更新的 ID
        });

        // 调用
        cargoSpaceService.updateCargoSpace(reqVO);
        // 校验是否更新正确
        CargoSpaceDO cargoSpace = cargoSpaceMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, cargoSpace);
    }

    @Test
    public void testUpdateCargoSpace_notExists() {
        // 准备参数
        CargoSpaceUpdateReqVO reqVO = randomPojo(CargoSpaceUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> cargoSpaceService.updateCargoSpace(reqVO), CARGO_SPACE_NOT_EXISTS);
    }

    @Test
    public void testDeleteCargoSpace_success() {
        // mock 数据
        CargoSpaceDO dbCargoSpace = randomPojo(CargoSpaceDO.class);
        cargoSpaceMapper.insert(dbCargoSpace);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbCargoSpace.getId();

        // 调用
        cargoSpaceService.deleteCargoSpace(id);
       // 校验数据不存在了
       assertNull(cargoSpaceMapper.selectById(id));
    }

    @Test
    public void testDeleteCargoSpace_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> cargoSpaceService.deleteCargoSpace(id), CARGO_SPACE_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetCargoSpacePage() {
       // mock 数据
       CargoSpaceDO dbCargoSpace = randomPojo(CargoSpaceDO.class, o -> { // 等会查询到
           o.setCode(null);
           o.setRowNumber(null);
           o.setColumnNumber(null);
           o.setLayerNumber(null);
           o.setFacilityId(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       cargoSpaceMapper.insert(dbCargoSpace);
       // 测试 code 不匹配
       cargoSpaceMapper.insert(cloneIgnoreId(dbCargoSpace, o -> o.setCode(null)));
       // 测试 rowNumber 不匹配
       cargoSpaceMapper.insert(cloneIgnoreId(dbCargoSpace, o -> o.setRowNumber(null)));
       // 测试 columnNumber 不匹配
       cargoSpaceMapper.insert(cloneIgnoreId(dbCargoSpace, o -> o.setColumnNumber(null)));
       // 测试 layerNumber 不匹配
       cargoSpaceMapper.insert(cloneIgnoreId(dbCargoSpace, o -> o.setLayerNumber(null)));
       // 测试 facilityId 不匹配
       cargoSpaceMapper.insert(cloneIgnoreId(dbCargoSpace, o -> o.setFacilityId(null)));
       // 测试 createTime 不匹配
       cargoSpaceMapper.insert(cloneIgnoreId(dbCargoSpace, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       cargoSpaceMapper.insert(cloneIgnoreId(dbCargoSpace, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       cargoSpaceMapper.insert(cloneIgnoreId(dbCargoSpace, o -> o.setSubjectId(null)));
       // 准备参数
       CargoSpacePageReqVO reqVO = new CargoSpacePageReqVO();
       reqVO.setCode(null);
       reqVO.setRowNumber(null);
       reqVO.setColumnNumber(null);
       reqVO.setLayerNumber(null);
       reqVO.setFacilityId(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       PageResult<CargoSpaceDO> pageResult = cargoSpaceService.getCargoSpacePage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbCargoSpace, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetCargoSpaceList() {
       // mock 数据
       CargoSpaceDO dbCargoSpace = randomPojo(CargoSpaceDO.class, o -> { // 等会查询到
           o.setCode(null);
           o.setRowNumber(null);
           o.setColumnNumber(null);
           o.setLayerNumber(null);
           o.setFacilityId(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       cargoSpaceMapper.insert(dbCargoSpace);
       // 测试 code 不匹配
       cargoSpaceMapper.insert(cloneIgnoreId(dbCargoSpace, o -> o.setCode(null)));
       // 测试 rowNumber 不匹配
       cargoSpaceMapper.insert(cloneIgnoreId(dbCargoSpace, o -> o.setRowNumber(null)));
       // 测试 columnNumber 不匹配
       cargoSpaceMapper.insert(cloneIgnoreId(dbCargoSpace, o -> o.setColumnNumber(null)));
       // 测试 layerNumber 不匹配
       cargoSpaceMapper.insert(cloneIgnoreId(dbCargoSpace, o -> o.setLayerNumber(null)));
       // 测试 facilityId 不匹配
       cargoSpaceMapper.insert(cloneIgnoreId(dbCargoSpace, o -> o.setFacilityId(null)));
       // 测试 createTime 不匹配
       cargoSpaceMapper.insert(cloneIgnoreId(dbCargoSpace, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       cargoSpaceMapper.insert(cloneIgnoreId(dbCargoSpace, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       cargoSpaceMapper.insert(cloneIgnoreId(dbCargoSpace, o -> o.setSubjectId(null)));
       // 准备参数
       CargoSpaceExportReqVO reqVO = new CargoSpaceExportReqVO();
       reqVO.setCode(null);
       reqVO.setRowNumber(null);
       reqVO.setColumnNumber(null);
       reqVO.setLayerNumber(null);
       reqVO.setFacilityId(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       List<CargoSpaceDO> list = cargoSpaceService.getCargoSpaceList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbCargoSpace, list.get(0));
    }

}
