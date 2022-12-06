package cn.acsm.module.member.user.dal.mysql.patienthealth;

import java.util.*;

import cn.acsm.module.member.user.controller.admin.patient.vo.hospitaladmission.HospitalAdmissionRecordExportReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.hospitaladmission.HospitalAdmissionRecordPageReqVO;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.HospitalAdmissionRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 住院记录 Mapper
 *
 * @author lihongyan
 */
@Mapper
public interface HospitalAdmissionRecordMapper extends BaseMapperX<HospitalAdmissionRecordDO> {

    default PageResult<HospitalAdmissionRecordDO> selectPage(HospitalAdmissionRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<HospitalAdmissionRecordDO>()
                .eqIfPresent(HospitalAdmissionRecordDO::getPatientHealthId, reqVO.getPatientHealthId())
                .eqIfPresent(HospitalAdmissionRecordDO::getMemberId, reqVO.getMemberId())
                .eqIfPresent(HospitalAdmissionRecordDO::getHospital, reqVO.getHospital())
                .eqIfPresent(HospitalAdmissionRecordDO::getDepartment, reqVO.getDepartment())
                .eqIfPresent(HospitalAdmissionRecordDO::getDoctor, reqVO.getDoctor())
                .betweenIfPresent(HospitalAdmissionRecordDO::getHospitalizationDate, reqVO.getHospitalizationDate())
                .betweenIfPresent(HospitalAdmissionRecordDO::getDischargeDate, reqVO.getDischargeDate())
                .eqIfPresent(HospitalAdmissionRecordDO::getHospitalizationCategories, reqVO.getHospitalizationCategories())
                .eqIfPresent(HospitalAdmissionRecordDO::getTreatmentContent, reqVO.getTreatmentContent())
                .betweenIfPresent(HospitalAdmissionRecordDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(HospitalAdmissionRecordDO::getSource, reqVO.getSource())
                .eqIfPresent(HospitalAdmissionRecordDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(HospitalAdmissionRecordDO::getId));
    }

    default List<HospitalAdmissionRecordDO> selectList(HospitalAdmissionRecordExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<HospitalAdmissionRecordDO>()
                .eqIfPresent(HospitalAdmissionRecordDO::getPatientHealthId, reqVO.getPatientHealthId())
                .eqIfPresent(HospitalAdmissionRecordDO::getMemberId, reqVO.getMemberId())
                .eqIfPresent(HospitalAdmissionRecordDO::getHospital, reqVO.getHospital())
                .eqIfPresent(HospitalAdmissionRecordDO::getDepartment, reqVO.getDepartment())
                .eqIfPresent(HospitalAdmissionRecordDO::getDoctor, reqVO.getDoctor())
                .betweenIfPresent(HospitalAdmissionRecordDO::getHospitalizationDate, reqVO.getHospitalizationDate())
                .betweenIfPresent(HospitalAdmissionRecordDO::getDischargeDate, reqVO.getDischargeDate())
                .eqIfPresent(HospitalAdmissionRecordDO::getHospitalizationCategories, reqVO.getHospitalizationCategories())
                .eqIfPresent(HospitalAdmissionRecordDO::getTreatmentContent, reqVO.getTreatmentContent())
                .betweenIfPresent(HospitalAdmissionRecordDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(HospitalAdmissionRecordDO::getSource, reqVO.getSource())
                .eqIfPresent(HospitalAdmissionRecordDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(HospitalAdmissionRecordDO::getId));
    }

}
