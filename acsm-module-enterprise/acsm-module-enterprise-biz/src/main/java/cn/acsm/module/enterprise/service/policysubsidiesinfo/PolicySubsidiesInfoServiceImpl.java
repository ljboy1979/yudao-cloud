package cn.acsm.module.enterprise.service.policysubsidiesinfo;

import cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo.PolicySubsidiesInfoCreateReqVO;
import cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo.PolicySubsidiesInfoExportReqVO;
import cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo.PolicySubsidiesInfoPageReqVO;
import cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo.PolicySubsidiesInfoUpdateReqVO;
import cn.acsm.module.enterprise.convert.policysubsidiesinfo.PolicySubsidiesInfoConvert;
import cn.acsm.module.enterprise.dal.dataobject.policysubsidiesinfo.PolicySubsidiesInfoDO;
import cn.acsm.module.enterprise.dal.mysql.policysubsidiesinfo.PolicySubsidiesInfoMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;


import static cn.acsm.module.enterprise.enums.ErrorCodeConstants.POLICY_SUBSIDIES_INFO_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 企业政策补贴信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class PolicySubsidiesInfoServiceImpl implements PolicySubsidiesInfoService {

    @Resource
    private PolicySubsidiesInfoMapper policySubsidiesInfoMapper;

    @Override
    public Long createPolicySubsidiesInfo(PolicySubsidiesInfoCreateReqVO createReqVO) {
        // 插入
        PolicySubsidiesInfoDO policySubsidiesInfo = PolicySubsidiesInfoConvert.INSTANCE.convert(createReqVO);
        policySubsidiesInfoMapper.insert(policySubsidiesInfo);
        // 返回
        return policySubsidiesInfo.getId();
    }

    @Override
    public void updatePolicySubsidiesInfo(PolicySubsidiesInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validatePolicySubsidiesInfoExists(updateReqVO.getId());
        // 更新
        PolicySubsidiesInfoDO updateObj = PolicySubsidiesInfoConvert.INSTANCE.convert(updateReqVO);
        policySubsidiesInfoMapper.updateById(updateObj);
    }

    @Override
    public void deletePolicySubsidiesInfo(Long id) {
        // 校验存在
        this.validatePolicySubsidiesInfoExists(id);
        // 删除
        policySubsidiesInfoMapper.deleteById(id);
    }

    private void validatePolicySubsidiesInfoExists(Long id) {
        if (policySubsidiesInfoMapper.selectById(id) == null) {
            throw exception(POLICY_SUBSIDIES_INFO_NOT_EXISTS);
        }
    }

    @Override
    public PolicySubsidiesInfoDO getPolicySubsidiesInfo(Long id) {
        return policySubsidiesInfoMapper.selectById(id);
    }

    @Override
    public List<PolicySubsidiesInfoDO> getPolicySubsidiesInfoList(Collection<Long> ids) {
        return policySubsidiesInfoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<PolicySubsidiesInfoDO> getPolicySubsidiesInfoPage(PolicySubsidiesInfoPageReqVO pageReqVO) {
        return policySubsidiesInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<PolicySubsidiesInfoDO> getPolicySubsidiesInfoList(PolicySubsidiesInfoExportReqVO exportReqVO) {
        return policySubsidiesInfoMapper.selectList(exportReqVO);
    }

}
