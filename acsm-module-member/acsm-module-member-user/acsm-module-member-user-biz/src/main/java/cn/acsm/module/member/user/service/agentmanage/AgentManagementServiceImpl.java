package cn.acsm.module.member.user.service.agentmanage;

import cn.acsm.module.member.user.controller.admin.agentmanage.vo.AgentManagementCreateReqVO;
import cn.acsm.module.member.user.controller.admin.agentmanage.vo.AgentManagementExportReqVO;
import cn.acsm.module.member.user.controller.admin.agentmanage.vo.AgentManagementPageReqVO;
import cn.acsm.module.member.user.controller.admin.agentmanage.vo.AgentManagementUpdateReqVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.member.user.dal.dataobject.agentmanage.AgentManagementDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.member.user.convert.agentmanage.AgentManagementConvert;
import cn.acsm.module.member.user.dal.mysql.agentmanage.AgentManagementMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.member.user.enums.ErrorCodeConstants.*;

/**
 * 代理商管理 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class AgentManagementServiceImpl implements AgentManagementService {

    @Resource
    private AgentManagementMapper agentManagementMapper;

    @Override
    public Long createAgentManagement(AgentManagementCreateReqVO createReqVO) {
        // 插入
        AgentManagementDO agentManagement = AgentManagementConvert.INSTANCE.convert(createReqVO);
        agentManagementMapper.insert(agentManagement);
        // 返回
        return agentManagement.getId();
    }

    @Override
    public void updateAgentManagement(AgentManagementUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateAgentManagementExists(updateReqVO.getId());
        // 更新
        AgentManagementDO updateObj = AgentManagementConvert.INSTANCE.convert(updateReqVO);
        agentManagementMapper.updateById(updateObj);
    }

    @Override
    public void deleteAgentManagement(Long id) {
        // 校验存在
        this.validateAgentManagementExists(id);
        // 删除
        agentManagementMapper.deleteById(id);
    }

    private void validateAgentManagementExists(Long id) {
        if (agentManagementMapper.selectById(id) == null) {
            throw exception(AGENT_MANAGEMENT_NOT_EXISTS);
        }
    }

    @Override
    public AgentManagementDO getAgentManagement(Long id) {
        return agentManagementMapper.selectById(id);
    }

    @Override
    public List<AgentManagementDO> getAgentManagementList(Collection<Long> ids) {
        return agentManagementMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<AgentManagementDO> getAgentManagementPage(AgentManagementPageReqVO pageReqVO) {
        return agentManagementMapper.selectPage(pageReqVO);
    }

    @Override
    public List<AgentManagementDO> getAgentManagementList(AgentManagementExportReqVO exportReqVO) {
        return agentManagementMapper.selectList(exportReqVO);
    }

}
