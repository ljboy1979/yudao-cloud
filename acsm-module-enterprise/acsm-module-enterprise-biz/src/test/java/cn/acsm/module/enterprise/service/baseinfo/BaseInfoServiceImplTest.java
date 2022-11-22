package cn.acsm.module.enterprise.service.baseinfo;

import cn.acsm.module.enterprise.controller.admin.baseinfo.vo.BaseInfoCreateReqVO;
import cn.acsm.module.enterprise.controller.admin.baseinfo.vo.BaseInfoExportReqVO;
import cn.acsm.module.enterprise.controller.admin.baseinfo.vo.BaseInfoPageReqVO;
import cn.acsm.module.enterprise.controller.admin.baseinfo.vo.BaseInfoUpdateReqVO;
import cn.acsm.module.enterprise.dal.dataobject.baseinfo.BaseInfoDO;
import cn.acsm.module.enterprise.dal.mysql.baseinfo.BaseInfoMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static cn.acsm.module.enterprise.enums.ErrorCodeConstants.BASE_INFO_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link BaseInfoServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(BaseInfoServiceImpl.class)
public class BaseInfoServiceImplTest extends BaseDbUnitTest {

    @Resource
    private BaseInfoServiceImpl baseInfoService;

    @Resource
    private BaseInfoMapper baseInfoMapper;

    @Test
    public void testCreateBaseInfo_success() {
        // 准备参数
        BaseInfoCreateReqVO reqVO = randomPojo(BaseInfoCreateReqVO.class);

        // 调用
        Long baseInfoId = baseInfoService.createBaseInfo(reqVO);
        // 断言
        assertNotNull(baseInfoId);
        // 校验记录的属性是否正确
        BaseInfoDO baseInfo = baseInfoMapper.selectById(baseInfoId);
        assertPojoEquals(reqVO, baseInfo);
    }

    @Test
    public void testUpdateBaseInfo_success() {
        // mock 数据
        BaseInfoDO dbBaseInfo = randomPojo(BaseInfoDO.class);
        baseInfoMapper.insert(dbBaseInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        BaseInfoUpdateReqVO reqVO = randomPojo(BaseInfoUpdateReqVO.class, o -> {
            o.setId(dbBaseInfo.getId()); // 设置更新的 ID
        });

        // 调用
        baseInfoService.updateBaseInfo(reqVO);
        // 校验是否更新正确
        BaseInfoDO baseInfo = baseInfoMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, baseInfo);
    }

    @Test
    public void testUpdateBaseInfo_notExists() {
        // 准备参数
        BaseInfoUpdateReqVO reqVO = randomPojo(BaseInfoUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> baseInfoService.updateBaseInfo(reqVO), BASE_INFO_NOT_EXISTS);
    }

    @Test
    public void testDeleteBaseInfo_success() {
        // mock 数据
        BaseInfoDO dbBaseInfo = randomPojo(BaseInfoDO.class);
        baseInfoMapper.insert(dbBaseInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbBaseInfo.getId();

        // 调用
        baseInfoService.deleteBaseInfo(id);
       // 校验数据不存在了
       assertNull(baseInfoMapper.selectById(id));
    }

    @Test
    public void testDeleteBaseInfo_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> baseInfoService.deleteBaseInfo(id), BASE_INFO_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetBaseInfoPage() {
       // mock 数据
       BaseInfoDO dbBaseInfo = randomPojo(BaseInfoDO.class, o -> { // 等会查询到
           o.setCode(null);
           o.setName(null);
           o.setEnterpriseType(null);
           o.setStauts(null);
           o.setUserTag(null);
           o.setManageStatus(null);
           o.setRegisterTime(null);
       });
       baseInfoMapper.insert(dbBaseInfo);
       // 测试 code 不匹配
       baseInfoMapper.insert(cloneIgnoreId(dbBaseInfo, o -> o.setCode(null)));
       // 测试 name 不匹配
       baseInfoMapper.insert(cloneIgnoreId(dbBaseInfo, o -> o.setName(null)));
       // 测试 enterpriseType 不匹配
       baseInfoMapper.insert(cloneIgnoreId(dbBaseInfo, o -> o.setEnterpriseType(null)));
       // 测试 stauts 不匹配
       baseInfoMapper.insert(cloneIgnoreId(dbBaseInfo, o -> o.setStauts(null)));
       // 测试 userTag 不匹配
       baseInfoMapper.insert(cloneIgnoreId(dbBaseInfo, o -> o.setUserTag(null)));
       // 测试 manageStatus 不匹配
       baseInfoMapper.insert(cloneIgnoreId(dbBaseInfo, o -> o.setManageStatus(null)));
       // 测试 registerTime 不匹配
       baseInfoMapper.insert(cloneIgnoreId(dbBaseInfo, o -> o.setRegisterTime(null)));
       // 准备参数
       BaseInfoPageReqVO reqVO = new BaseInfoPageReqVO();
       reqVO.setCode(null);
       reqVO.setName(null);
       reqVO.setEnterpriseType(null);
       reqVO.setStauts(null);
       reqVO.setUserTag(null);
       reqVO.setManageStatus(null);
       reqVO.setRegisterTime((new Date[]{}));

       // 调用
       PageResult<BaseInfoDO> pageResult = baseInfoService.getBaseInfoPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbBaseInfo, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetBaseInfoList() {
       // mock 数据
       BaseInfoDO dbBaseInfo = randomPojo(BaseInfoDO.class, o -> { // 等会查询到
           o.setCode(null);
           o.setName(null);
           o.setEnterpriseType(null);
           o.setStauts(null);
           o.setUserTag(null);
           o.setManageStatus(null);
           o.setRegisterTime(null);
       });
       baseInfoMapper.insert(dbBaseInfo);
       // 测试 code 不匹配
       baseInfoMapper.insert(cloneIgnoreId(dbBaseInfo, o -> o.setCode(null)));
       // 测试 name 不匹配
       baseInfoMapper.insert(cloneIgnoreId(dbBaseInfo, o -> o.setName(null)));
       // 测试 enterpriseType 不匹配
       baseInfoMapper.insert(cloneIgnoreId(dbBaseInfo, o -> o.setEnterpriseType(null)));
       // 测试 stauts 不匹配
       baseInfoMapper.insert(cloneIgnoreId(dbBaseInfo, o -> o.setStauts(null)));
       // 测试 userTag 不匹配
       baseInfoMapper.insert(cloneIgnoreId(dbBaseInfo, o -> o.setUserTag(null)));
       // 测试 manageStatus 不匹配
       baseInfoMapper.insert(cloneIgnoreId(dbBaseInfo, o -> o.setManageStatus(null)));
       // 测试 registerTime 不匹配
       baseInfoMapper.insert(cloneIgnoreId(dbBaseInfo, o -> o.setRegisterTime(null)));
       // 准备参数
       BaseInfoExportReqVO reqVO = new BaseInfoExportReqVO();
       reqVO.setCode(null);
       reqVO.setName(null);
       reqVO.setEnterpriseType(null);
       reqVO.setStauts(null);
       reqVO.setUserTag(null);
       reqVO.setManageStatus(null);
       reqVO.setRegisterTime((new Date[]{}));

       // 调用
       List<BaseInfoDO> list = baseInfoService.getBaseInfoList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbBaseInfo, list.get(0));
    }

}
