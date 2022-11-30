package cn.acsm.module.member.user.dal.mysql.patienthealth;

import java.util.*;

import cn.acsm.module.member.user.controller.admin.patient.vo.patienthealth.PatientHealthExportReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.patienthealth.PatientHealthPageReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.PatientHealthDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 健康档案 Mapper
 *
 * @author lihongyan
 */
@Mapper
public interface PatientHealthMapper extends BaseMapperX<PatientHealthDO> {

    default PageResult<PatientHealthDO> selectPage(PatientHealthPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PatientHealthDO>()
                .eqIfPresent(PatientHealthDO::getMemberId, reqVO.getMemberId())
                .eqIfPresent(PatientHealthDO::getMedicalAdviceId, reqVO.getMedicalAdviceId())
                .likeIfPresent(PatientHealthDO::getName, reqVO.getName())
                .eqIfPresent(PatientHealthDO::getAge, reqVO.getAge())
                .eqIfPresent(PatientHealthDO::getSex, reqVO.getSex())
                .eqIfPresent(PatientHealthDO::getHeight, reqVO.getHeight())
                .eqIfPresent(PatientHealthDO::getWeight, reqVO.getWeight())
                .eqIfPresent(PatientHealthDO::getInpatientNo, reqVO.getInpatientNo())
                .eqIfPresent(PatientHealthDO::getReceiptPoint, reqVO.getReceiptPoint())
                .eqIfPresent(PatientHealthDO::getTreatmentArea, reqVO.getTreatmentArea())
                .eqIfPresent(PatientHealthDO::getDepartment, reqVO.getDepartment())
                .eqIfPresent(PatientHealthDO::getBuildingNo, reqVO.getBuildingNo())
                .eqIfPresent(PatientHealthDO::getFloorNo, reqVO.getFloorNo())
                .eqIfPresent(PatientHealthDO::getRoomNo, reqVO.getRoomNo())
                .eqIfPresent(PatientHealthDO::getBedNo, reqVO.getBedNo())
                .betweenIfPresent(PatientHealthDO::getAdmissionDate, reqVO.getAdmissionDate())
                .betweenIfPresent(PatientHealthDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PatientHealthDO::getSource, reqVO.getSource())
                .eqIfPresent(PatientHealthDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(PatientHealthDO::getId));
    }

    default List<PatientHealthDO> selectList(PatientHealthExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<PatientHealthDO>()
                .eqIfPresent(PatientHealthDO::getMemberId, reqVO.getMemberId())
                .eqIfPresent(PatientHealthDO::getMedicalAdviceId, reqVO.getMedicalAdviceId())
                .likeIfPresent(PatientHealthDO::getName, reqVO.getName())
                .eqIfPresent(PatientHealthDO::getAge, reqVO.getAge())
                .eqIfPresent(PatientHealthDO::getSex, reqVO.getSex())
                .eqIfPresent(PatientHealthDO::getHeight, reqVO.getHeight())
                .eqIfPresent(PatientHealthDO::getWeight, reqVO.getWeight())
                .eqIfPresent(PatientHealthDO::getInpatientNo, reqVO.getInpatientNo())
                .eqIfPresent(PatientHealthDO::getReceiptPoint, reqVO.getReceiptPoint())
                .eqIfPresent(PatientHealthDO::getTreatmentArea, reqVO.getTreatmentArea())
                .eqIfPresent(PatientHealthDO::getDepartment, reqVO.getDepartment())
                .eqIfPresent(PatientHealthDO::getBuildingNo, reqVO.getBuildingNo())
                .eqIfPresent(PatientHealthDO::getFloorNo, reqVO.getFloorNo())
                .eqIfPresent(PatientHealthDO::getRoomNo, reqVO.getRoomNo())
                .eqIfPresent(PatientHealthDO::getBedNo, reqVO.getBedNo())
                .betweenIfPresent(PatientHealthDO::getAdmissionDate, reqVO.getAdmissionDate())
                .betweenIfPresent(PatientHealthDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PatientHealthDO::getSource, reqVO.getSource())
                .eqIfPresent(PatientHealthDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(PatientHealthDO::getId));
    }

//    default PatientHealthDO selectByMemberId(PatientHealthCreateReqVO patientHealthCreateReqVO) {
//        return selectOne(PatientHealthDO::getMemberId, patientHealthCreateReqVO.getMemberId()
//                ,PatientHealthDO::getSource,patientHealthCreateReqVO.getSource());
//    }

}
