package cn.acsm.module.transaction.sales.convert.specialmedicalfoodorganization;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodorganization.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.specialmedicalfoodorganization.SpecialMedicalFoodOrganizationDO;

/**
 * 特医食品组成 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface SpecialMedicalFoodOrganizationConvert {

    SpecialMedicalFoodOrganizationConvert INSTANCE = Mappers.getMapper(SpecialMedicalFoodOrganizationConvert.class);

    SpecialMedicalFoodOrganizationDO convert(SpecialMedicalFoodOrganCreateReqVO bean);

    SpecialMedicalFoodOrganizationDO convert(SpecialMedicalFoodOrganUpdateReqVO bean);

    SpecialMedicalFoodOrganizationRespVO convert(SpecialMedicalFoodOrganizationDO bean);

    List<SpecialMedicalFoodOrganizationRespVO> convertList(List<SpecialMedicalFoodOrganizationDO> list);

    PageResult<SpecialMedicalFoodOrganizationRespVO> convertPage(PageResult<SpecialMedicalFoodOrganizationDO> page);

    List<SpecialMedicalFoodOrganizationExcelVO> convertList02(List<SpecialMedicalFoodOrganizationDO> list);

}
