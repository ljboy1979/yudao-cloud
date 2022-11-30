package cn.acsm.module.member.user.convert.patienthealth;

import java.util.*;

import cn.acsm.module.member.user.controller.admin.patient.vo.nutritionexamination.NutritionExaminationRecordCreateReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.nutritionexamination.NutritionExaminationRecordExcelVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.nutritionexamination.NutritionExaminationRecordRespVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.nutritionexamination.NutritionExaminationRecordUpdateReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.NutritionExaminationRecordDO;

/**
 * 营养检查记录 Convert
 *
 * @author lihongyan
 */
@Mapper
public interface NutritionExaminationRecordConvert {

    NutritionExaminationRecordConvert INSTANCE = Mappers.getMapper(NutritionExaminationRecordConvert.class);

    NutritionExaminationRecordDO convert(NutritionExaminationRecordCreateReqVO bean);

    NutritionExaminationRecordDO convert(NutritionExaminationRecordUpdateReqVO bean);

    NutritionExaminationRecordRespVO convert(NutritionExaminationRecordDO bean);

    List<NutritionExaminationRecordRespVO> convertList(List<NutritionExaminationRecordDO> list);

    PageResult<NutritionExaminationRecordRespVO> convertPage(PageResult<NutritionExaminationRecordDO> page);

    List<NutritionExaminationRecordExcelVO> convertList02(List<NutritionExaminationRecordDO> list);

}
