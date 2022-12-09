package cn.acsm.module.resource.service.maintenancerecord;

import cn.acsm.module.resource.controller.admin.maintenancerecord.vo.MaintenanceRecordCreateReqVO;
import cn.acsm.module.resource.controller.admin.maintenancerecord.vo.MaintenanceRecordExportReqVO;
import cn.acsm.module.resource.controller.admin.maintenancerecord.vo.MaintenanceRecordPageReqVO;
import cn.acsm.module.resource.controller.admin.maintenancerecord.vo.MaintenanceRecordUpdateReqVO;
import cn.acsm.module.resource.dal.dataobject.maintenancerecord.MaintenanceRecordDO;
import cn.acsm.module.resource.dal.mysql.maintenancerecord.MaintenanceRecordMapper;
import cn.acsm.module.resource.service.maintenancerecord.MaintenanceRecordServiceImpl;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.springframework.context.annotation.Import;
import java.util.*;

import static cn.acsm.module.resource.enums.ErrorCodeConstants.MAINTENANCE_RECORD_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link MaintenanceRecordServiceImpl} 的单元测试类
*
* @author smile
*/
@Import(MaintenanceRecordServiceImpl.class)
public class MaintenanceRecordServiceImplTest extends BaseDbUnitTest {

    @Resource
    private MaintenanceRecordServiceImpl maintenanceRecordService;

    @Resource
    private MaintenanceRecordMapper maintenanceRecordMapper;

    @Test
    public void testCreateMaintenanceRecord_success() {
        // 准备参数
        MaintenanceRecordCreateReqVO reqVO = randomPojo(MaintenanceRecordCreateReqVO.class);

        // 调用
        Long maintenanceRecordId = maintenanceRecordService.createMaintenanceRecord(reqVO);
        // 断言
        assertNotNull(maintenanceRecordId);
        // 校验记录的属性是否正确
        MaintenanceRecordDO maintenanceRecord = maintenanceRecordMapper.selectById(maintenanceRecordId);
        assertPojoEquals(reqVO, maintenanceRecord);
    }

    @Test
    public void testUpdateMaintenanceRecord_success() {
        // mock 数据
        MaintenanceRecordDO dbMaintenanceRecord = randomPojo(MaintenanceRecordDO.class);
        maintenanceRecordMapper.insert(dbMaintenanceRecord);// @Sql: 先插入出一条存在的数据
        // 准备参数
        MaintenanceRecordUpdateReqVO reqVO = randomPojo(MaintenanceRecordUpdateReqVO.class, o -> {
            o.setId(dbMaintenanceRecord.getId()); // 设置更新的 ID
        });

        // 调用
        maintenanceRecordService.updateMaintenanceRecord(reqVO);
        // 校验是否更新正确
        MaintenanceRecordDO maintenanceRecord = maintenanceRecordMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, maintenanceRecord);
    }

    @Test
    public void testUpdateMaintenanceRecord_notExists() {
        // 准备参数
        MaintenanceRecordUpdateReqVO reqVO = randomPojo(MaintenanceRecordUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> maintenanceRecordService.updateMaintenanceRecord(reqVO), MAINTENANCE_RECORD_NOT_EXISTS);
    }

    @Test
    public void testDeleteMaintenanceRecord_success() {
        // mock 数据
        MaintenanceRecordDO dbMaintenanceRecord = randomPojo(MaintenanceRecordDO.class);
        maintenanceRecordMapper.insert(dbMaintenanceRecord);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbMaintenanceRecord.getId();

        // 调用
        maintenanceRecordService.deleteMaintenanceRecord(id);
       // 校验数据不存在了
       assertNull(maintenanceRecordMapper.selectById(id));
    }

    @Test
    public void testDeleteMaintenanceRecord_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> maintenanceRecordService.deleteMaintenanceRecord(id), MAINTENANCE_RECORD_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMaintenanceRecordPage() {
       // mock 数据
       MaintenanceRecordDO dbMaintenanceRecord = randomPojo(MaintenanceRecordDO.class, o -> { // 等会查询到
           o.setServiceAdoptContentId(null);
           o.setMaintenanceName(null);
           o.setContent(null);
           o.setBeginTime(null);
           o.setEndTime(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       maintenanceRecordMapper.insert(dbMaintenanceRecord);
       // 测试 serviceAdoptContentId 不匹配
       maintenanceRecordMapper.insert(cloneIgnoreId(dbMaintenanceRecord, o -> o.setServiceAdoptContentId(null)));
       // 测试 maintenanceName 不匹配
       maintenanceRecordMapper.insert(cloneIgnoreId(dbMaintenanceRecord, o -> o.setMaintenanceName(null)));
       // 测试 content 不匹配
       maintenanceRecordMapper.insert(cloneIgnoreId(dbMaintenanceRecord, o -> o.setContent(null)));
       // 测试 beginTime 不匹配
       maintenanceRecordMapper.insert(cloneIgnoreId(dbMaintenanceRecord, o -> o.setBeginTime(null)));
       // 测试 endTime 不匹配
       maintenanceRecordMapper.insert(cloneIgnoreId(dbMaintenanceRecord, o -> o.setEndTime(null)));
       // 测试 status 不匹配
       maintenanceRecordMapper.insert(cloneIgnoreId(dbMaintenanceRecord, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       maintenanceRecordMapper.insert(cloneIgnoreId(dbMaintenanceRecord, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       maintenanceRecordMapper.insert(cloneIgnoreId(dbMaintenanceRecord, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       maintenanceRecordMapper.insert(cloneIgnoreId(dbMaintenanceRecord, o -> o.setSubjectId(null)));
       // 准备参数
       MaintenanceRecordPageReqVO reqVO = new MaintenanceRecordPageReqVO();
       reqVO.setServiceAdoptContentId(null);
       reqVO.setMaintenanceName(null);
       reqVO.setContent(null);
       reqVO.setBeginTime((new Date[]{}));
       reqVO.setEndTime((new Date[]{}));
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       PageResult<MaintenanceRecordDO> pageResult = maintenanceRecordService.getMaintenanceRecordPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbMaintenanceRecord, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMaintenanceRecordList() {
       // mock 数据
       MaintenanceRecordDO dbMaintenanceRecord = randomPojo(MaintenanceRecordDO.class, o -> { // 等会查询到
           o.setServiceAdoptContentId(null);
           o.setMaintenanceName(null);
           o.setContent(null);
           o.setBeginTime(null);
           o.setEndTime(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       maintenanceRecordMapper.insert(dbMaintenanceRecord);
       // 测试 serviceAdoptContentId 不匹配
       maintenanceRecordMapper.insert(cloneIgnoreId(dbMaintenanceRecord, o -> o.setServiceAdoptContentId(null)));
       // 测试 maintenanceName 不匹配
       maintenanceRecordMapper.insert(cloneIgnoreId(dbMaintenanceRecord, o -> o.setMaintenanceName(null)));
       // 测试 content 不匹配
       maintenanceRecordMapper.insert(cloneIgnoreId(dbMaintenanceRecord, o -> o.setContent(null)));
       // 测试 beginTime 不匹配
       maintenanceRecordMapper.insert(cloneIgnoreId(dbMaintenanceRecord, o -> o.setBeginTime(null)));
       // 测试 endTime 不匹配
       maintenanceRecordMapper.insert(cloneIgnoreId(dbMaintenanceRecord, o -> o.setEndTime(null)));
       // 测试 status 不匹配
       maintenanceRecordMapper.insert(cloneIgnoreId(dbMaintenanceRecord, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       maintenanceRecordMapper.insert(cloneIgnoreId(dbMaintenanceRecord, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       maintenanceRecordMapper.insert(cloneIgnoreId(dbMaintenanceRecord, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       maintenanceRecordMapper.insert(cloneIgnoreId(dbMaintenanceRecord, o -> o.setSubjectId(null)));
       // 准备参数
       MaintenanceRecordExportReqVO reqVO = new MaintenanceRecordExportReqVO();
       reqVO.setServiceAdoptContentId(null);
       reqVO.setMaintenanceName(null);
       reqVO.setContent(null);
       reqVO.setBeginTime((new Date[]{}));
       reqVO.setEndTime((new Date[]{}));
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       List<MaintenanceRecordDO> list = maintenanceRecordService.getMaintenanceRecordList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbMaintenanceRecord, list.get(0));
    }

}
