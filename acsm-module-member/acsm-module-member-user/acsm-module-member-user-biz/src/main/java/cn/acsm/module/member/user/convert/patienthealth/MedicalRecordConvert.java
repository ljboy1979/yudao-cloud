package cn.acsm.module.member.user.convert.patienthealth;

import java.util.*;

import cn.acsm.module.member.user.controller.admin.patient.vo.medical.MedicalRecordCreateReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.medical.MedicalRecordExcelVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.medical.MedicalRecordRespVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.medical.MedicalRecordUpdateReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.MedicalRecordDO;

/**
 * 医嘱记录 Convert
 *
 * @author lihongyan
 */
@Mapper
public interface MedicalRecordConvert {

    MedicalRecordConvert INSTANCE = Mappers.getMapper(MedicalRecordConvert.class);

    MedicalRecordDO convert(MedicalRecordCreateReqVO bean);

    MedicalRecordDO convert(MedicalRecordUpdateReqVO bean);

    MedicalRecordRespVO convert(MedicalRecordDO bean);

    List<MedicalRecordRespVO> convertList(List<MedicalRecordDO> list);

    PageResult<MedicalRecordRespVO> convertPage(PageResult<MedicalRecordDO> page);

    List<MedicalRecordExcelVO> convertList02(List<MedicalRecordDO> list);

}
