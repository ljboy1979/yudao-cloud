package cn.acsm.module.transaction.sales.convert.specialmedicalfood;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfood.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.specialmedicalfood.SpecialMedicalFoodDO;

/**
 * 特医食品 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface SpecialMedicalFoodConvert {

    SpecialMedicalFoodConvert INSTANCE = Mappers.getMapper(SpecialMedicalFoodConvert.class);

    SpecialMedicalFoodDO convert(SpecialMedicalFoodCreateReqVO bean);

    SpecialMedicalFoodDO convert(SpecialMedicalFoodUpdateReqVO bean);

    SpecialMedicalFoodRespVO convert(SpecialMedicalFoodDO bean);

    List<SpecialMedicalFoodRespVO> convertList(List<SpecialMedicalFoodDO> list);

    PageResult<SpecialMedicalFoodRespVO> convertPage(PageResult<SpecialMedicalFoodDO> page);

    List<SpecialMedicalFoodExcelVO> convertList02(List<SpecialMedicalFoodDO> list);

}
