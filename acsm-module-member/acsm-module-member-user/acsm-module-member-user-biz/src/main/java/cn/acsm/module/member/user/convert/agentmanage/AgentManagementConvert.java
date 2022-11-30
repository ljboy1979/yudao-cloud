package cn.acsm.module.member.user.convert.agentmanage;

import java.util.*;

import cn.acsm.module.member.user.controller.admin.agentmanage.vo.AgentManagementCreateReqVO;
import cn.acsm.module.member.user.controller.admin.agentmanage.vo.AgentManagementExcelVO;
import cn.acsm.module.member.user.controller.admin.agentmanage.vo.AgentManagementRespVO;
import cn.acsm.module.member.user.controller.admin.agentmanage.vo.AgentManagementUpdateReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.member.user.dal.dataobject.agentmanage.AgentManagementDO;

/**
 * 代理商管理 Convert
 *
 * @author lihongyan
 */
@Mapper
public interface AgentManagementConvert {

    AgentManagementConvert INSTANCE = Mappers.getMapper(AgentManagementConvert.class);

    AgentManagementDO convert(AgentManagementCreateReqVO bean);

    AgentManagementDO convert(AgentManagementUpdateReqVO bean);

    AgentManagementRespVO convert(AgentManagementDO bean);

    List<AgentManagementRespVO> convertList(List<AgentManagementDO> list);

    PageResult<AgentManagementRespVO> convertPage(PageResult<AgentManagementDO> page);

    List<AgentManagementExcelVO> convertList02(List<AgentManagementDO> list);

}
