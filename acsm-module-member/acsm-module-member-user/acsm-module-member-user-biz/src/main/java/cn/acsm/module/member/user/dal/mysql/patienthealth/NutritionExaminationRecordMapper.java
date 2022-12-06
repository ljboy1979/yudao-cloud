package cn.acsm.module.member.user.dal.mysql.patienthealth;

import cn.acsm.module.member.user.controller.admin.patient.vo.nutritionexamination.NutritionExaminationRecordExportReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.nutritionexamination.NutritionExaminationRecordPageReqVO;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.NutritionExaminationRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 营养检查记录 Mapper
 *
 * @author lihongyan
 */
@Mapper
public interface NutritionExaminationRecordMapper extends BaseMapperX<NutritionExaminationRecordDO> {

    default PageResult<NutritionExaminationRecordDO> selectPage(NutritionExaminationRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<NutritionExaminationRecordDO>()
                .eqIfPresent(NutritionExaminationRecordDO::getPatientHealthId, reqVO.getPatientHealthId())
                .eqIfPresent(NutritionExaminationRecordDO::getMemberId, reqVO.getMemberId())
                .eqIfPresent(NutritionExaminationRecordDO::getHospital, reqVO.getHospital())
                .eqIfPresent(NutritionExaminationRecordDO::getDepartment, reqVO.getDepartment())
                .eqIfPresent(NutritionExaminationRecordDO::getDoctor, reqVO.getDoctor())
                .betweenIfPresent(NutritionExaminationRecordDO::getCheckDate, reqVO.getCheckDate())
                .eqIfPresent(NutritionExaminationRecordDO::getCheckCategory, reqVO.getCheckCategory())
                .eqIfPresent(NutritionExaminationRecordDO::getCheckContent, reqVO.getCheckContent())
                .betweenIfPresent(NutritionExaminationRecordDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(NutritionExaminationRecordDO::getSource, reqVO.getSource())
                .eqIfPresent(NutritionExaminationRecordDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(NutritionExaminationRecordDO::getId));
    }

    default List<NutritionExaminationRecordDO> selectList(NutritionExaminationRecordExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<NutritionExaminationRecordDO>()
                .eqIfPresent(NutritionExaminationRecordDO::getPatientHealthId, reqVO.getPatientHealthId())
                .eqIfPresent(NutritionExaminationRecordDO::getMemberId, reqVO.getMemberId())
                .eqIfPresent(NutritionExaminationRecordDO::getHospital, reqVO.getHospital())
                .eqIfPresent(NutritionExaminationRecordDO::getDepartment, reqVO.getDepartment())
                .eqIfPresent(NutritionExaminationRecordDO::getDoctor, reqVO.getDoctor())
                .betweenIfPresent(NutritionExaminationRecordDO::getCheckDate, reqVO.getCheckDate())
                .eqIfPresent(NutritionExaminationRecordDO::getCheckCategory, reqVO.getCheckCategory())
                .eqIfPresent(NutritionExaminationRecordDO::getCheckContent, reqVO.getCheckContent())
                .betweenIfPresent(NutritionExaminationRecordDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(NutritionExaminationRecordDO::getSource, reqVO.getSource())
                .eqIfPresent(NutritionExaminationRecordDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(NutritionExaminationRecordDO::getId));
    }

}
