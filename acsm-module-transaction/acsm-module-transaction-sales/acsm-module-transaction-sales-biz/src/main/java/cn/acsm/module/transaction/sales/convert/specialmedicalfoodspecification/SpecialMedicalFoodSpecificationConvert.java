package cn.acsm.module.transaction.sales.convert.specialmedicalfoodspecification;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodspecification.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.specialmedicalfoodspecification.SpecialMedicalFoodSpecificationDO;

/**
 * 特医食品规格 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface SpecialMedicalFoodSpecificationConvert {

    SpecialMedicalFoodSpecificationConvert INSTANCE = Mappers.getMapper(SpecialMedicalFoodSpecificationConvert.class);

    SpecialMedicalFoodSpecificationDO convert(SpecialMedicalFoodSpecificationCreateReqVO bean);

    SpecialMedicalFoodSpecificationDO convert(SpecialMedicalFoodSpecificationUpdateReqVO bean);

    SpecialMedicalFoodSpecificationRespVO convert(SpecialMedicalFoodSpecificationDO bean);

    List<SpecialMedicalFoodSpecificationRespVO> convertList(List<SpecialMedicalFoodSpecificationDO> list);

    PageResult<SpecialMedicalFoodSpecificationRespVO> convertPage(PageResult<SpecialMedicalFoodSpecificationDO> page);

    List<SpecialMedicalFoodSpecificationExcelVO> convertList02(List<SpecialMedicalFoodSpecificationDO> list);

}
