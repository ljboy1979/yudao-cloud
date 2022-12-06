package cn.acsm.module.member.user.dal.mysql.patienthealth;

import cn.acsm.module.member.user.controller.admin.patient.vo.specialmedicalfood.SpecialMedicalFoodRecordsExportReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.specialmedicalfood.SpecialMedicalFoodRecordsPageReqVO;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.SpecialMedicalFoodRecordsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 特医食品使用记录表 Mapper
 *
 * @author lihongyan
 */
@Mapper
public interface SpecialMedicalFoodRecordsMapper extends BaseMapperX<SpecialMedicalFoodRecordsDO> {

    default PageResult<SpecialMedicalFoodRecordsDO> selectPage(SpecialMedicalFoodRecordsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SpecialMedicalFoodRecordsDO>()
                .eqIfPresent(SpecialMedicalFoodRecordsDO::getPatientHealthId, reqVO.getPatientHealthId())
                .eqIfPresent(SpecialMedicalFoodRecordsDO::getMemberId, reqVO.getMemberId())
                .eqIfPresent(SpecialMedicalFoodRecordsDO::getHospital, reqVO.getHospital())
                .eqIfPresent(SpecialMedicalFoodRecordsDO::getDepartment, reqVO.getDepartment())
                .eqIfPresent(SpecialMedicalFoodRecordsDO::getDoctor, reqVO.getDoctor())
                .betweenIfPresent(SpecialMedicalFoodRecordsDO::getSpecialMedicalDate, reqVO.getSpecialMedicalDate())
                .eqIfPresent(SpecialMedicalFoodRecordsDO::getSpecialMedicalCategory, reqVO.getSpecialMedicalCategory())
                .eqIfPresent(SpecialMedicalFoodRecordsDO::getSpecialMedicalContent, reqVO.getSpecialMedicalContent())
                .betweenIfPresent(SpecialMedicalFoodRecordsDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(SpecialMedicalFoodRecordsDO::getSource, reqVO.getSource())
                .eqIfPresent(SpecialMedicalFoodRecordsDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(SpecialMedicalFoodRecordsDO::getId));
    }

    default List<SpecialMedicalFoodRecordsDO> selectList(SpecialMedicalFoodRecordsExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<SpecialMedicalFoodRecordsDO>()
                .eqIfPresent(SpecialMedicalFoodRecordsDO::getPatientHealthId, reqVO.getPatientHealthId())
                .eqIfPresent(SpecialMedicalFoodRecordsDO::getMemberId, reqVO.getMemberId())
                .eqIfPresent(SpecialMedicalFoodRecordsDO::getHospital, reqVO.getHospital())
                .eqIfPresent(SpecialMedicalFoodRecordsDO::getDepartment, reqVO.getDepartment())
                .eqIfPresent(SpecialMedicalFoodRecordsDO::getDoctor, reqVO.getDoctor())
                .betweenIfPresent(SpecialMedicalFoodRecordsDO::getSpecialMedicalDate, reqVO.getSpecialMedicalDate())
                .eqIfPresent(SpecialMedicalFoodRecordsDO::getSpecialMedicalCategory, reqVO.getSpecialMedicalCategory())
                .eqIfPresent(SpecialMedicalFoodRecordsDO::getSpecialMedicalContent, reqVO.getSpecialMedicalContent())
                .betweenIfPresent(SpecialMedicalFoodRecordsDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(SpecialMedicalFoodRecordsDO::getSource, reqVO.getSource())
                .eqIfPresent(SpecialMedicalFoodRecordsDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(SpecialMedicalFoodRecordsDO::getId));
    }

}
