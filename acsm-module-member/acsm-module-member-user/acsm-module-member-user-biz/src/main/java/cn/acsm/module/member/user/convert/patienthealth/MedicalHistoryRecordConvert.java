package cn.acsm.module.member.user.convert.patienthealth;

import java.util.*;

import cn.acsm.module.member.user.controller.admin.patient.vo.medicalhistory.MedicalHistoryRecordCreateReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.medicalhistory.MedicalHistoryRecordExcelVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.medicalhistory.MedicalHistoryRecordRespVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.medicalhistory.MedicalHistoryRecordUpdateReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.MedicalHistoryRecordDO;

/**
 * 病史记录 Convert
 *
 * @author lihongyan
 */
@Mapper
public interface MedicalHistoryRecordConvert {

    MedicalHistoryRecordConvert INSTANCE = Mappers.getMapper(MedicalHistoryRecordConvert.class);

    MedicalHistoryRecordDO convert(MedicalHistoryRecordCreateReqVO bean);

    MedicalHistoryRecordDO convert(MedicalHistoryRecordUpdateReqVO bean);

    MedicalHistoryRecordRespVO convert(MedicalHistoryRecordDO bean);

    List<MedicalHistoryRecordRespVO> convertList(List<MedicalHistoryRecordDO> list);

    PageResult<MedicalHistoryRecordRespVO> convertPage(PageResult<MedicalHistoryRecordDO> page);

    List<MedicalHistoryRecordExcelVO> convertList02(List<MedicalHistoryRecordDO> list);

}
