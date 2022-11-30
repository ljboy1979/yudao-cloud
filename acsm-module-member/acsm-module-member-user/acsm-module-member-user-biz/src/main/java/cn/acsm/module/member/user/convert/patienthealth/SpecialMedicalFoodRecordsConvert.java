package cn.acsm.module.member.user.convert.patienthealth;

import java.util.*;

import cn.acsm.module.member.user.controller.admin.patient.vo.specialmedicalfood.SpecialMedicalFoodRecordsCreateReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.specialmedicalfood.SpecialMedicalFoodRecordsExcelVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.specialmedicalfood.SpecialMedicalFoodRecordsRespVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.specialmedicalfood.SpecialMedicalFoodRecordsUpdateReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.SpecialMedicalFoodRecordsDO;

/**
 * 特医食品使用记录表 Convert
 *
 * @author lihongyan
 */
@Mapper
public interface SpecialMedicalFoodRecordsConvert {

    SpecialMedicalFoodRecordsConvert INSTANCE = Mappers.getMapper(SpecialMedicalFoodRecordsConvert.class);

    SpecialMedicalFoodRecordsDO convert(SpecialMedicalFoodRecordsCreateReqVO bean);

    SpecialMedicalFoodRecordsDO convert(SpecialMedicalFoodRecordsUpdateReqVO bean);

    SpecialMedicalFoodRecordsRespVO convert(SpecialMedicalFoodRecordsDO bean);

    List<SpecialMedicalFoodRecordsRespVO> convertList(List<SpecialMedicalFoodRecordsDO> list);

    PageResult<SpecialMedicalFoodRecordsRespVO> convertPage(PageResult<SpecialMedicalFoodRecordsDO> page);

    List<SpecialMedicalFoodRecordsExcelVO> convertList02(List<SpecialMedicalFoodRecordsDO> list);

}
