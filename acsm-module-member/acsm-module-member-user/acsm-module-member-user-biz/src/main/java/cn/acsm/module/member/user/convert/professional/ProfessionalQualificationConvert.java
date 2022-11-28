package cn.acsm.module.member.user.convert.professional;

import java.util.*;

import cn.acsm.module.member.user.controller.admin.professional.vo.ProfessionalQualificationCreateReqVO;
import cn.acsm.module.member.user.controller.admin.professional.vo.ProfessionalQualificationExcelVO;
import cn.acsm.module.member.user.controller.admin.professional.vo.ProfessionalQualificationRespVO;
import cn.acsm.module.member.user.controller.admin.professional.vo.ProfessionalQualificationUpdateReqVO;
import cn.acsm.module.member.user.dal.dataobject.professional.ProfessionalQualificationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 专业资质 Convert
 *
 * @author lihongyan
 */
@Mapper
public interface ProfessionalQualificationConvert {

    ProfessionalQualificationConvert INSTANCE = Mappers.getMapper(ProfessionalQualificationConvert.class);

    ProfessionalQualificationDO convert(ProfessionalQualificationCreateReqVO bean);

    ProfessionalQualificationDO convert(ProfessionalQualificationUpdateReqVO bean);

    ProfessionalQualificationRespVO convert(ProfessionalQualificationDO bean);

    List<ProfessionalQualificationRespVO> convertList(List<ProfessionalQualificationDO> list);

    PageResult<ProfessionalQualificationRespVO> convertPage(PageResult<ProfessionalQualificationDO> page);

    List<ProfessionalQualificationExcelVO> convertList02(List<ProfessionalQualificationDO> list);

}
