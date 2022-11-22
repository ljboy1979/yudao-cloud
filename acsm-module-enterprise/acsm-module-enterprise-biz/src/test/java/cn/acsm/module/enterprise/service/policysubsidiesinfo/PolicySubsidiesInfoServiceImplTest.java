package cn.acsm.module.enterprise.service.policysubsidiesinfo;

import cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo.PolicySubsidiesInfoCreateReqVO;
import cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo.PolicySubsidiesInfoExportReqVO;
import cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo.PolicySubsidiesInfoPageReqVO;
import cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo.PolicySubsidiesInfoUpdateReqVO;
import cn.acsm.module.enterprise.dal.dataobject.policysubsidiesinfo.PolicySubsidiesInfoDO;
import cn.acsm.module.enterprise.dal.mysql.policysubsidiesinfo.PolicySubsidiesInfoMapper;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.acsm.module.enterprise.enums.ErrorCodeConstants.POLICY_SUBSIDIES_INFO_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link PolicySubsidiesInfoServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(PolicySubsidiesInfoServiceImpl.class)
public class PolicySubsidiesInfoServiceImplTest extends BaseDbUnitTest {

    @Resource
    private PolicySubsidiesInfoServiceImpl policySubsidiesInfoService;

    @Resource
    private PolicySubsidiesInfoMapper policySubsidiesInfoMapper;

    @Test
    public void testCreatePolicySubsidiesInfo_success() {
        // 准备参数
        PolicySubsidiesInfoCreateReqVO reqVO = randomPojo(PolicySubsidiesInfoCreateReqVO.class);

        // 调用
        Long policySubsidiesInfoId = policySubsidiesInfoService.createPolicySubsidiesInfo(reqVO);
        // 断言
        assertNotNull(policySubsidiesInfoId);
        // 校验记录的属性是否正确
        PolicySubsidiesInfoDO policySubsidiesInfo = policySubsidiesInfoMapper.selectById(policySubsidiesInfoId);
        assertPojoEquals(reqVO, policySubsidiesInfo);
    }

    @Test
    public void testUpdatePolicySubsidiesInfo_success() {
        // mock 数据
        PolicySubsidiesInfoDO dbPolicySubsidiesInfo = randomPojo(PolicySubsidiesInfoDO.class);
        policySubsidiesInfoMapper.insert(dbPolicySubsidiesInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        PolicySubsidiesInfoUpdateReqVO reqVO = randomPojo(PolicySubsidiesInfoUpdateReqVO.class, o -> {
            o.setId(dbPolicySubsidiesInfo.getId()); // 设置更新的 ID
        });

        // 调用
        policySubsidiesInfoService.updatePolicySubsidiesInfo(reqVO);
        // 校验是否更新正确
        PolicySubsidiesInfoDO policySubsidiesInfo = policySubsidiesInfoMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, policySubsidiesInfo);
    }

    @Test
    public void testUpdatePolicySubsidiesInfo_notExists() {
        // 准备参数
        PolicySubsidiesInfoUpdateReqVO reqVO = randomPojo(PolicySubsidiesInfoUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> policySubsidiesInfoService.updatePolicySubsidiesInfo(reqVO), POLICY_SUBSIDIES_INFO_NOT_EXISTS);
    }

    @Test
    public void testDeletePolicySubsidiesInfo_success() {
        // mock 数据
        PolicySubsidiesInfoDO dbPolicySubsidiesInfo = randomPojo(PolicySubsidiesInfoDO.class);
        policySubsidiesInfoMapper.insert(dbPolicySubsidiesInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbPolicySubsidiesInfo.getId();

        // 调用
        policySubsidiesInfoService.deletePolicySubsidiesInfo(id);
       // 校验数据不存在了
       assertNull(policySubsidiesInfoMapper.selectById(id));
    }

    @Test
    public void testDeletePolicySubsidiesInfo_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> policySubsidiesInfoService.deletePolicySubsidiesInfo(id), POLICY_SUBSIDIES_INFO_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetPolicySubsidiesInfoPage() {
       // mock 数据
       PolicySubsidiesInfoDO dbPolicySubsidiesInfo = randomPojo(PolicySubsidiesInfoDO.class, o -> { // 等会查询到
           o.setEnterpriseId(null);
           o.setSubsidiesCategory(null);
           o.setSubsidiesName(null);
           o.setSubsidiesAmount(null);
           o.setSubsidiesType(null);
           o.setSubsidiesStatus(null);
           o.setApplyPerson(null);
           o.setApplyTime(null);
           o.setSource(null);
           o.setSubjectId(null);
           o.setCreateTime(null);
       });
       policySubsidiesInfoMapper.insert(dbPolicySubsidiesInfo);
       // 测试 enterpriseId 不匹配
       policySubsidiesInfoMapper.insert(cloneIgnoreId(dbPolicySubsidiesInfo, o -> o.setEnterpriseId(null)));
       // 测试 subsidiesCategory 不匹配
       policySubsidiesInfoMapper.insert(cloneIgnoreId(dbPolicySubsidiesInfo, o -> o.setSubsidiesCategory(null)));
       // 测试 subsidiesName 不匹配
       policySubsidiesInfoMapper.insert(cloneIgnoreId(dbPolicySubsidiesInfo, o -> o.setSubsidiesName(null)));
       // 测试 subsidiesAmount 不匹配
       policySubsidiesInfoMapper.insert(cloneIgnoreId(dbPolicySubsidiesInfo, o -> o.setSubsidiesAmount(null)));
       // 测试 subsidiesType 不匹配
       policySubsidiesInfoMapper.insert(cloneIgnoreId(dbPolicySubsidiesInfo, o -> o.setSubsidiesType(null)));
       // 测试 subsidiesStatus 不匹配
       policySubsidiesInfoMapper.insert(cloneIgnoreId(dbPolicySubsidiesInfo, o -> o.setSubsidiesStatus(null)));
       // 测试 applyPerson 不匹配
       policySubsidiesInfoMapper.insert(cloneIgnoreId(dbPolicySubsidiesInfo, o -> o.setApplyPerson(null)));
       // 测试 applyTime 不匹配
       policySubsidiesInfoMapper.insert(cloneIgnoreId(dbPolicySubsidiesInfo, o -> o.setApplyTime(null)));
       // 测试 source 不匹配
       policySubsidiesInfoMapper.insert(cloneIgnoreId(dbPolicySubsidiesInfo, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       policySubsidiesInfoMapper.insert(cloneIgnoreId(dbPolicySubsidiesInfo, o -> o.setSubjectId(null)));
       // 测试 createTime 不匹配
       policySubsidiesInfoMapper.insert(cloneIgnoreId(dbPolicySubsidiesInfo, o -> o.setCreateTime(null)));
       // 准备参数
       PolicySubsidiesInfoPageReqVO reqVO = new PolicySubsidiesInfoPageReqVO();
       reqVO.setEnterpriseId(null);
       reqVO.setSubsidiesCategory(null);
       reqVO.setSubsidiesName(null);
       reqVO.setSubsidiesAmount(null);
       reqVO.setSubsidiesType(null);
       reqVO.setSubsidiesStatus(null);
       reqVO.setApplyPerson(null);
       reqVO.setApplyTime(new Date[]{});
       reqVO.setSource(null);
       reqVO.setSubjectId(null);
       reqVO.setCreateTime(new Date[]{});

       // 调用
       PageResult<PolicySubsidiesInfoDO> pageResult = policySubsidiesInfoService.getPolicySubsidiesInfoPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbPolicySubsidiesInfo, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetPolicySubsidiesInfoList() {
       // mock 数据
       PolicySubsidiesInfoDO dbPolicySubsidiesInfo = randomPojo(PolicySubsidiesInfoDO.class, o -> { // 等会查询到
           o.setEnterpriseId(null);
           o.setSubsidiesCategory(null);
           o.setSubsidiesName(null);
           o.setSubsidiesAmount(null);
           o.setSubsidiesType(null);
           o.setSubsidiesStatus(null);
           o.setApplyPerson(null);
           o.setApplyTime(null);
           o.setSource(null);
           o.setSubjectId(null);
           o.setCreateTime(null);
       });
       policySubsidiesInfoMapper.insert(dbPolicySubsidiesInfo);
       // 测试 enterpriseId 不匹配
       policySubsidiesInfoMapper.insert(cloneIgnoreId(dbPolicySubsidiesInfo, o -> o.setEnterpriseId(null)));
       // 测试 subsidiesCategory 不匹配
       policySubsidiesInfoMapper.insert(cloneIgnoreId(dbPolicySubsidiesInfo, o -> o.setSubsidiesCategory(null)));
       // 测试 subsidiesName 不匹配
       policySubsidiesInfoMapper.insert(cloneIgnoreId(dbPolicySubsidiesInfo, o -> o.setSubsidiesName(null)));
       // 测试 subsidiesAmount 不匹配
       policySubsidiesInfoMapper.insert(cloneIgnoreId(dbPolicySubsidiesInfo, o -> o.setSubsidiesAmount(null)));
       // 测试 subsidiesType 不匹配
       policySubsidiesInfoMapper.insert(cloneIgnoreId(dbPolicySubsidiesInfo, o -> o.setSubsidiesType(null)));
       // 测试 subsidiesStatus 不匹配
       policySubsidiesInfoMapper.insert(cloneIgnoreId(dbPolicySubsidiesInfo, o -> o.setSubsidiesStatus(null)));
       // 测试 applyPerson 不匹配
       policySubsidiesInfoMapper.insert(cloneIgnoreId(dbPolicySubsidiesInfo, o -> o.setApplyPerson(null)));
       // 测试 applyTime 不匹配
       policySubsidiesInfoMapper.insert(cloneIgnoreId(dbPolicySubsidiesInfo, o -> o.setApplyTime(null)));
       // 测试 source 不匹配
       policySubsidiesInfoMapper.insert(cloneIgnoreId(dbPolicySubsidiesInfo, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       policySubsidiesInfoMapper.insert(cloneIgnoreId(dbPolicySubsidiesInfo, o -> o.setSubjectId(null)));
       // 测试 createTime 不匹配
       policySubsidiesInfoMapper.insert(cloneIgnoreId(dbPolicySubsidiesInfo, o -> o.setCreateTime(null)));
       // 准备参数
       PolicySubsidiesInfoExportReqVO reqVO = new PolicySubsidiesInfoExportReqVO();
       reqVO.setEnterpriseId(null);
       reqVO.setSubsidiesCategory(null);
       reqVO.setSubsidiesName(null);
       reqVO.setSubsidiesAmount(null);
       reqVO.setSubsidiesType(null);
       reqVO.setSubsidiesStatus(null);
       reqVO.setApplyPerson(null);
       reqVO.setApplyTime(new Date[]{});
       reqVO.setSource(null);
       reqVO.setSubjectId(null);
       reqVO.setCreateTime(new Date[]{});

       // 调用
       List<PolicySubsidiesInfoDO> list = policySubsidiesInfoService.getPolicySubsidiesInfoList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbPolicySubsidiesInfo, list.get(0));
    }

}
