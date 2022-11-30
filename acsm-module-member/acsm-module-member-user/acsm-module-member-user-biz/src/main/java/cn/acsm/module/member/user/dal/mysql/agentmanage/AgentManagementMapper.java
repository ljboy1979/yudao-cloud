package cn.acsm.module.member.user.dal.mysql.agentmanage;

import java.util.*;

import cn.acsm.module.member.user.controller.admin.agentmanage.vo.AgentManagementExportReqVO;
import cn.acsm.module.member.user.controller.admin.agentmanage.vo.AgentManagementPageReqVO;
import cn.acsm.module.member.user.dal.dataobject.agentmanage.AgentManagementDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 代理商管理 Mapper
 *
 * @author lihongyan
 */
@Mapper
public interface AgentManagementMapper extends BaseMapperX<AgentManagementDO> {

    default PageResult<AgentManagementDO> selectPage(AgentManagementPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AgentManagementDO>()
                .likeIfPresent(AgentManagementDO::getAgentName, reqVO.getAgentName())
                .eqIfPresent(AgentManagementDO::getAgentAera, reqVO.getAgentAera())
                .eqIfPresent(AgentManagementDO::getAddress, reqVO.getAddress())
                .eqIfPresent(AgentManagementDO::getPhone, reqVO.getPhone())
                .betweenIfPresent(AgentManagementDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(AgentManagementDO::getSource, reqVO.getSource())
                .eqIfPresent(AgentManagementDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(AgentManagementDO::getId));
    }

    default List<AgentManagementDO> selectList(AgentManagementExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<AgentManagementDO>()
                .likeIfPresent(AgentManagementDO::getAgentName, reqVO.getAgentName())
                .eqIfPresent(AgentManagementDO::getAgentAera, reqVO.getAgentAera())
                .eqIfPresent(AgentManagementDO::getAddress, reqVO.getAddress())
                .eqIfPresent(AgentManagementDO::getPhone, reqVO.getPhone())
                .betweenIfPresent(AgentManagementDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(AgentManagementDO::getSource, reqVO.getSource())
                .eqIfPresent(AgentManagementDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(AgentManagementDO::getId));
    }

}
