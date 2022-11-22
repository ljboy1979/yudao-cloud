package cn.acsm.module.enterprise.service.otheraccountinfo;

import cn.acsm.module.enterprise.controller.admin.otheraccountinfo.vo.OtherAccountInfoCreateReqVO;
import cn.acsm.module.enterprise.controller.admin.otheraccountinfo.vo.OtherAccountInfoExportReqVO;
import cn.acsm.module.enterprise.controller.admin.otheraccountinfo.vo.OtherAccountInfoPageReqVO;
import cn.acsm.module.enterprise.controller.admin.otheraccountinfo.vo.OtherAccountInfoUpdateReqVO;
import cn.acsm.module.enterprise.dal.dataobject.otheraccountinfo.OtherAccountInfoDO;
import cn.acsm.module.enterprise.dal.mysql.otheraccountinfo.OtherAccountInfoMapper;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;


import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.acsm.module.enterprise.enums.ErrorCodeConstants.OTHER_ACCOUNT_INFO_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link OtherAccountInfoServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(OtherAccountInfoServiceImpl.class)
public class OtherAccountInfoServiceImplTest extends BaseDbUnitTest {

    @Resource
    private OtherAccountInfoServiceImpl otherAccountInfoService;

    @Resource
    private OtherAccountInfoMapper otherAccountInfoMapper;

    @Test
    public void testCreateOtherAccountInfo_success() {
        // 准备参数
        OtherAccountInfoCreateReqVO reqVO = randomPojo(OtherAccountInfoCreateReqVO.class);

        // 调用
        Long otherAccountInfoId = otherAccountInfoService.createOtherAccountInfo(reqVO);
        // 断言
        assertNotNull(otherAccountInfoId);
        // 校验记录的属性是否正确
        OtherAccountInfoDO otherAccountInfo = otherAccountInfoMapper.selectById(otherAccountInfoId);
        assertPojoEquals(reqVO, otherAccountInfo);
    }

    @Test
    public void testUpdateOtherAccountInfo_success() {
        // mock 数据
        OtherAccountInfoDO dbOtherAccountInfo = randomPojo(OtherAccountInfoDO.class);
        otherAccountInfoMapper.insert(dbOtherAccountInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        OtherAccountInfoUpdateReqVO reqVO = randomPojo(OtherAccountInfoUpdateReqVO.class, o -> {
            o.setId(dbOtherAccountInfo.getId()); // 设置更新的 ID
        });

        // 调用
        otherAccountInfoService.updateOtherAccountInfo(reqVO);
        // 校验是否更新正确
        OtherAccountInfoDO otherAccountInfo = otherAccountInfoMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, otherAccountInfo);
    }

    @Test
    public void testUpdateOtherAccountInfo_notExists() {
        // 准备参数
        OtherAccountInfoUpdateReqVO reqVO = randomPojo(OtherAccountInfoUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> otherAccountInfoService.updateOtherAccountInfo(reqVO), OTHER_ACCOUNT_INFO_NOT_EXISTS);
    }

    @Test
    public void testDeleteOtherAccountInfo_success() {
        // mock 数据
        OtherAccountInfoDO dbOtherAccountInfo = randomPojo(OtherAccountInfoDO.class);
        otherAccountInfoMapper.insert(dbOtherAccountInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbOtherAccountInfo.getId();

        // 调用
        otherAccountInfoService.deleteOtherAccountInfo(id);
       // 校验数据不存在了
       assertNull(otherAccountInfoMapper.selectById(id));
    }

    @Test
    public void testDeleteOtherAccountInfo_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> otherAccountInfoService.deleteOtherAccountInfo(id), OTHER_ACCOUNT_INFO_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetOtherAccountInfoPage() {
       // mock 数据
       OtherAccountInfoDO dbOtherAccountInfo = randomPojo(OtherAccountInfoDO.class, o -> { // 等会查询到
           o.setEnterpriseId(null);
           o.setAccountName(null);
           o.setAccountNo(null);
           o.setAccountIdCard(null);
           o.setAccountBank(null);
           o.setSource(null);
           o.setSubjectId(null);
           o.setCreateTime(null);
       });
       otherAccountInfoMapper.insert(dbOtherAccountInfo);
       // 测试 enterpriseId 不匹配
       otherAccountInfoMapper.insert(cloneIgnoreId(dbOtherAccountInfo, o -> o.setEnterpriseId(null)));
       // 测试 accountName 不匹配
       otherAccountInfoMapper.insert(cloneIgnoreId(dbOtherAccountInfo, o -> o.setAccountName(null)));
       // 测试 accountNo 不匹配
       otherAccountInfoMapper.insert(cloneIgnoreId(dbOtherAccountInfo, o -> o.setAccountNo(null)));
       // 测试 accountIdCard 不匹配
       otherAccountInfoMapper.insert(cloneIgnoreId(dbOtherAccountInfo, o -> o.setAccountIdCard(null)));
       // 测试 accountBank 不匹配
       otherAccountInfoMapper.insert(cloneIgnoreId(dbOtherAccountInfo, o -> o.setAccountBank(null)));
       // 测试 source 不匹配
       otherAccountInfoMapper.insert(cloneIgnoreId(dbOtherAccountInfo, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       otherAccountInfoMapper.insert(cloneIgnoreId(dbOtherAccountInfo, o -> o.setSubjectId(null)));
       // 测试 createTime 不匹配
       otherAccountInfoMapper.insert(cloneIgnoreId(dbOtherAccountInfo, o -> o.setCreateTime(null)));
       // 准备参数
       OtherAccountInfoPageReqVO reqVO = new OtherAccountInfoPageReqVO();
       reqVO.setEnterpriseId(null);
       reqVO.setAccountName(null);
       reqVO.setAccountNo(null);
       reqVO.setAccountIdCard(null);
       reqVO.setAccountBank(null);
       reqVO.setSource(null);
       reqVO.setSubjectId(null);
       reqVO.setCreateTime(new Date[]{});

       // 调用
       PageResult<OtherAccountInfoDO> pageResult = otherAccountInfoService.getOtherAccountInfoPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbOtherAccountInfo, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetOtherAccountInfoList() {
       // mock 数据
       OtherAccountInfoDO dbOtherAccountInfo = randomPojo(OtherAccountInfoDO.class, o -> { // 等会查询到
           o.setEnterpriseId(null);
           o.setAccountName(null);
           o.setAccountNo(null);
           o.setAccountIdCard(null);
           o.setAccountBank(null);
           o.setSource(null);
           o.setSubjectId(null);
           o.setCreateTime(null);
       });
       otherAccountInfoMapper.insert(dbOtherAccountInfo);
       // 测试 enterpriseId 不匹配
       otherAccountInfoMapper.insert(cloneIgnoreId(dbOtherAccountInfo, o -> o.setEnterpriseId(null)));
       // 测试 accountName 不匹配
       otherAccountInfoMapper.insert(cloneIgnoreId(dbOtherAccountInfo, o -> o.setAccountName(null)));
       // 测试 accountNo 不匹配
       otherAccountInfoMapper.insert(cloneIgnoreId(dbOtherAccountInfo, o -> o.setAccountNo(null)));
       // 测试 accountIdCard 不匹配
       otherAccountInfoMapper.insert(cloneIgnoreId(dbOtherAccountInfo, o -> o.setAccountIdCard(null)));
       // 测试 accountBank 不匹配
       otherAccountInfoMapper.insert(cloneIgnoreId(dbOtherAccountInfo, o -> o.setAccountBank(null)));
       // 测试 source 不匹配
       otherAccountInfoMapper.insert(cloneIgnoreId(dbOtherAccountInfo, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       otherAccountInfoMapper.insert(cloneIgnoreId(dbOtherAccountInfo, o -> o.setSubjectId(null)));
       // 测试 createTime 不匹配
       otherAccountInfoMapper.insert(cloneIgnoreId(dbOtherAccountInfo, o -> o.setCreateTime(null)));
       // 准备参数
       OtherAccountInfoExportReqVO reqVO = new OtherAccountInfoExportReqVO();
       reqVO.setEnterpriseId(null);
       reqVO.setAccountName(null);
       reqVO.setAccountNo(null);
       reqVO.setAccountIdCard(null);
       reqVO.setAccountBank(null);
       reqVO.setSource(null);
       reqVO.setSubjectId(null);
       reqVO.setCreateTime(new Date[]{});

       // 调用
       List<OtherAccountInfoDO> list = otherAccountInfoService.getOtherAccountInfoList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbOtherAccountInfo, list.get(0));
    }

}
