package cn.acsm.module.member.user.convert.patienthealth;

import java.util.*;

import cn.acsm.module.member.user.controller.admin.patient.vo.hospitaladmission.HospitalAdmissionRecordCreateReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.hospitaladmission.HospitalAdmissionRecordExcelVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.hospitaladmission.HospitalAdmissionRecordRespVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.hospitaladmission.HospitalAdmissionRecordUpdateReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.HospitalAdmissionRecordDO;

/**
 * 住院记录 Convert
 *
 * @author lihongyan
 */
@Mapper
public interface HospitalAdmissionRecordConvert {

    HospitalAdmissionRecordConvert INSTANCE = Mappers.getMapper(HospitalAdmissionRecordConvert.class);

    HospitalAdmissionRecordDO convert(HospitalAdmissionRecordCreateReqVO bean);

    HospitalAdmissionRecordDO convert(HospitalAdmissionRecordUpdateReqVO bean);

    HospitalAdmissionRecordRespVO convert(HospitalAdmissionRecordDO bean);

    List<HospitalAdmissionRecordRespVO> convertList(List<HospitalAdmissionRecordDO> list);

    PageResult<HospitalAdmissionRecordRespVO> convertPage(PageResult<HospitalAdmissionRecordDO> page);

    List<HospitalAdmissionRecordExcelVO> convertList02(List<HospitalAdmissionRecordDO> list);

}
