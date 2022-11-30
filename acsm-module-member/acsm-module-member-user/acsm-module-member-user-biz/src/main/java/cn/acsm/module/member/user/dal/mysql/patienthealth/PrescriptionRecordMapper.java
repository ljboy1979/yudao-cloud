package cn.acsm.module.member.user.dal.mysql.patienthealth;

import java.util.*;

import cn.acsm.module.member.user.controller.admin.patient.vo.prescription.PrescriptionRecordExportReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.prescription.PrescriptionRecordPageReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.PrescriptionRecordDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 处方记录表 Mapper
 *
 * @author lihongyan
 */
@Mapper
public interface PrescriptionRecordMapper extends BaseMapperX<PrescriptionRecordDO> {

    default PageResult<PrescriptionRecordDO> selectPage(PrescriptionRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PrescriptionRecordDO>()
                .eqIfPresent(PrescriptionRecordDO::getPatientHealthId, reqVO.getPatientHealthId())
                .eqIfPresent(PrescriptionRecordDO::getHospital, reqVO.getHospital())
                .eqIfPresent(PrescriptionRecordDO::getDepartment, reqVO.getDepartment())
                .eqIfPresent(PrescriptionRecordDO::getDoctor, reqVO.getDoctor())
                .betweenIfPresent(PrescriptionRecordDO::getPrescriptionDate, reqVO.getPrescriptionDate())
                .eqIfPresent(PrescriptionRecordDO::getPrescriptionCategory, reqVO.getPrescriptionCategory())
                .eqIfPresent(PrescriptionRecordDO::getPrescriptionContent, reqVO.getPrescriptionContent())
                .betweenIfPresent(PrescriptionRecordDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PrescriptionRecordDO::getSource, reqVO.getSource())
                .eqIfPresent(PrescriptionRecordDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(PrescriptionRecordDO::getId));
    }

    default List<PrescriptionRecordDO> selectList(PrescriptionRecordExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<PrescriptionRecordDO>()
                .eqIfPresent(PrescriptionRecordDO::getPatientHealthId, reqVO.getPatientHealthId())
                .eqIfPresent(PrescriptionRecordDO::getHospital, reqVO.getHospital())
                .eqIfPresent(PrescriptionRecordDO::getDepartment, reqVO.getDepartment())
                .eqIfPresent(PrescriptionRecordDO::getDoctor, reqVO.getDoctor())
                .betweenIfPresent(PrescriptionRecordDO::getPrescriptionDate, reqVO.getPrescriptionDate())
                .eqIfPresent(PrescriptionRecordDO::getPrescriptionCategory, reqVO.getPrescriptionCategory())
                .eqIfPresent(PrescriptionRecordDO::getPrescriptionContent, reqVO.getPrescriptionContent())
                .betweenIfPresent(PrescriptionRecordDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PrescriptionRecordDO::getSource, reqVO.getSource())
                .eqIfPresent(PrescriptionRecordDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(PrescriptionRecordDO::getId));
    }

}
