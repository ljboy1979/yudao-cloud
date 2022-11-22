package cn.acsm.module.enterprise.convert.policysubsidiesinfo;
import cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo.PolicySubsidiesInfoCreateReqVO;
import cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo.PolicySubsidiesInfoExcelVO;
import cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo.PolicySubsidiesInfoRespVO;
import cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo.PolicySubsidiesInfoUpdateReqVO;
import cn.acsm.module.enterprise.dal.dataobject.policysubsidiesinfo.PolicySubsidiesInfoDO;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 企业政策补贴信息 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface PolicySubsidiesInfoConvert {

    PolicySubsidiesInfoConvert INSTANCE = Mappers.getMapper(PolicySubsidiesInfoConvert.class);

    PolicySubsidiesInfoDO convert(PolicySubsidiesInfoCreateReqVO bean);

    PolicySubsidiesInfoDO convert(PolicySubsidiesInfoUpdateReqVO bean);

    PolicySubsidiesInfoRespVO convert(PolicySubsidiesInfoDO bean);

    List<PolicySubsidiesInfoRespVO> convertList(List<PolicySubsidiesInfoDO> list);

    PageResult<PolicySubsidiesInfoRespVO> convertPage(PageResult<PolicySubsidiesInfoDO> page);

    List< PolicySubsidiesInfoExcelVO > convertList02(List<PolicySubsidiesInfoDO> list);

}
