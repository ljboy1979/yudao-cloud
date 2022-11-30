package cn.acsm.module.member.user.service.agentmanage;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.member.user.controller.admin.agentmanage.vo.AgentManagementCreateReqVO;
import cn.acsm.module.member.user.controller.admin.agentmanage.vo.AgentManagementExportReqVO;
import cn.acsm.module.member.user.controller.admin.agentmanage.vo.AgentManagementPageReqVO;
import cn.acsm.module.member.user.controller.admin.agentmanage.vo.AgentManagementUpdateReqVO;
import cn.acsm.module.member.user.dal.dataobject.agentmanage.AgentManagementDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 代理商管理 Service 接口
 *
 * @author lihongyan
 */
public interface AgentManagementService {

    /**
     * 创建代理商管理
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createAgentManagement(@Valid AgentManagementCreateReqVO createReqVO);

    /**
     * 更新代理商管理
     *
     * @param updateReqVO 更新信息
     */
    void updateAgentManagement(@Valid AgentManagementUpdateReqVO updateReqVO);

    /**
     * 删除代理商管理
     *
     * @param id 编号
     */
    void deleteAgentManagement(Long id);

    /**
     * 获得代理商管理
     *
     * @param id 编号
     * @return 代理商管理
     */
    AgentManagementDO getAgentManagement(Long id);

    /**
     * 获得代理商管理列表
     *
     * @param ids 编号
     * @return 代理商管理列表
     */
    List<AgentManagementDO> getAgentManagementList(Collection<Long> ids);

    /**
     * 获得代理商管理分页
     *
     * @param pageReqVO 分页查询
     * @return 代理商管理分页
     */
    PageResult<AgentManagementDO> getAgentManagementPage(AgentManagementPageReqVO pageReqVO);

    /**
     * 获得代理商管理列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 代理商管理列表
     */
    List<AgentManagementDO> getAgentManagementList(AgentManagementExportReqVO exportReqVO);

}
