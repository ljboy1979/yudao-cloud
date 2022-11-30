package cn.acsm.module.member.user.dal.mysql.patienthealth;

import java.util.*;

import cn.acsm.module.member.user.controller.admin.patient.vo.medicalhistory.MedicalHistoryRecordExportReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.medicalhistory.MedicalHistoryRecordPageReqVO;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.MedicalHistoryRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 病史记录 Mapper
 *
 * @author lihongyan
 */
@Mapper
public interface MedicalHistoryRecordMapper extends BaseMapperX<MedicalHistoryRecordDO> {

    default PageResult<MedicalHistoryRecordDO> selectPage(MedicalHistoryRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MedicalHistoryRecordDO>()
                .eqIfPresent(MedicalHistoryRecordDO::getPatientHealthId, reqVO.getPatientHealthId())
                .eqIfPresent(MedicalHistoryRecordDO::getHospital, reqVO.getHospital())
                .eqIfPresent(MedicalHistoryRecordDO::getDepartment, reqVO.getDepartment())
                .eqIfPresent(MedicalHistoryRecordDO::getDoctor, reqVO.getDoctor())
                .betweenIfPresent(MedicalHistoryRecordDO::getTreatmentDate, reqVO.getTreatmentDate())
                .eqIfPresent(MedicalHistoryRecordDO::getCheckCategory, reqVO.getCheckCategory())
                .eqIfPresent(MedicalHistoryRecordDO::getCheckContent, reqVO.getCheckContent())
                .eqIfPresent(MedicalHistoryRecordDO::getTreatmentOptions, reqVO.getTreatmentOptions())
                .eqIfPresent(MedicalHistoryRecordDO::getTreatmentOutcome, reqVO.getTreatmentOutcome())
                .betweenIfPresent(MedicalHistoryRecordDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(MedicalHistoryRecordDO::getSource, reqVO.getSource())
                .eqIfPresent(MedicalHistoryRecordDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(MedicalHistoryRecordDO::getId));
    }

    default List<MedicalHistoryRecordDO> selectList(MedicalHistoryRecordExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MedicalHistoryRecordDO>()
                .eqIfPresent(MedicalHistoryRecordDO::getPatientHealthId, reqVO.getPatientHealthId())
                .eqIfPresent(MedicalHistoryRecordDO::getHospital, reqVO.getHospital())
                .eqIfPresent(MedicalHistoryRecordDO::getDepartment, reqVO.getDepartment())
                .eqIfPresent(MedicalHistoryRecordDO::getDoctor, reqVO.getDoctor())
                .betweenIfPresent(MedicalHistoryRecordDO::getTreatmentDate, reqVO.getTreatmentDate())
                .eqIfPresent(MedicalHistoryRecordDO::getCheckCategory, reqVO.getCheckCategory())
                .eqIfPresent(MedicalHistoryRecordDO::getCheckContent, reqVO.getCheckContent())
                .eqIfPresent(MedicalHistoryRecordDO::getTreatmentOptions, reqVO.getTreatmentOptions())
                .eqIfPresent(MedicalHistoryRecordDO::getTreatmentOutcome, reqVO.getTreatmentOutcome())
                .betweenIfPresent(MedicalHistoryRecordDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(MedicalHistoryRecordDO::getSource, reqVO.getSource())
                .eqIfPresent(MedicalHistoryRecordDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(MedicalHistoryRecordDO::getId));
    }

}
