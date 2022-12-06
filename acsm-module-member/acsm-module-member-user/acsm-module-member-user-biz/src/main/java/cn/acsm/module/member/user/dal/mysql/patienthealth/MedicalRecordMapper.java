package cn.acsm.module.member.user.dal.mysql.patienthealth;

import java.util.*;

import cn.acsm.module.member.user.controller.admin.patient.vo.medical.MedicalRecordExportReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.medical.MedicalRecordPageReqVO;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.MedicalRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 医嘱记录 Mapper
 *
 * @author lihongyan
 */
@Mapper
public interface MedicalRecordMapper extends BaseMapperX<MedicalRecordDO> {

    default PageResult<MedicalRecordDO> selectPage(MedicalRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MedicalRecordDO>()
                .eqIfPresent(MedicalRecordDO::getPatientHealthId, reqVO.getPatientHealthId())
                .eqIfPresent(MedicalRecordDO::getMemberId, reqVO.getMemberId())
                .eqIfPresent(MedicalRecordDO::getHospital, reqVO.getHospital())
                .eqIfPresent(MedicalRecordDO::getDepartment, reqVO.getDepartment())
                .eqIfPresent(MedicalRecordDO::getDoctor, reqVO.getDoctor())
                .betweenIfPresent(MedicalRecordDO::getMedicalDate, reqVO.getMedicalDate())
                .eqIfPresent(MedicalRecordDO::getMedicalCategory, reqVO.getMedicalCategory())
                .eqIfPresent(MedicalRecordDO::getMedicalContent, reqVO.getMedicalContent())
                .betweenIfPresent(MedicalRecordDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(MedicalRecordDO::getSource, reqVO.getSource())
                .eqIfPresent(MedicalRecordDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(MedicalRecordDO::getId));
    }

    default List<MedicalRecordDO> selectList(MedicalRecordExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MedicalRecordDO>()
                .eqIfPresent(MedicalRecordDO::getPatientHealthId, reqVO.getPatientHealthId())
                .eqIfPresent(MedicalRecordDO::getMemberId, reqVO.getMemberId())
                .eqIfPresent(MedicalRecordDO::getHospital, reqVO.getHospital())
                .eqIfPresent(MedicalRecordDO::getDepartment, reqVO.getDepartment())
                .eqIfPresent(MedicalRecordDO::getDoctor, reqVO.getDoctor())
                .betweenIfPresent(MedicalRecordDO::getMedicalDate, reqVO.getMedicalDate())
                .eqIfPresent(MedicalRecordDO::getMedicalCategory, reqVO.getMedicalCategory())
                .eqIfPresent(MedicalRecordDO::getMedicalContent, reqVO.getMedicalContent())
                .betweenIfPresent(MedicalRecordDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(MedicalRecordDO::getSource, reqVO.getSource())
                .eqIfPresent(MedicalRecordDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(MedicalRecordDO::getId));
    }

}
