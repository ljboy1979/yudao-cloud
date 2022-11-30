package cn.acsm.module.member.user.convert.patienthealth;

import java.util.*;

import cn.acsm.module.member.user.controller.admin.patient.vo.patienthealth.PatientHealthCreateReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.patienthealth.PatientHealthExcelVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.patienthealth.PatientHealthRespVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.patienthealth.PatientHealthUpdateReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.PatientHealthDO;

/**
 * 健康档案 Convert
 *
 * @author lihongyan
 */
@Mapper
public interface PatientHealthConvert {

    PatientHealthConvert INSTANCE = Mappers.getMapper(PatientHealthConvert.class);

    PatientHealthDO convert(PatientHealthCreateReqVO bean);

    PatientHealthDO convert(PatientHealthUpdateReqVO bean);

    PatientHealthRespVO convert(PatientHealthDO bean);

    List<PatientHealthRespVO> convertList(List<PatientHealthDO> list);

    PageResult<PatientHealthRespVO> convertPage(PageResult<PatientHealthDO> page);

    List<PatientHealthExcelVO> convertList02(List<PatientHealthDO> list);

}
