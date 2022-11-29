package cn.acsm.module.transaction.sales.convert.dishesorganization;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.sales.controller.admin.dishesorganization.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.dishesorganization.DishesOrganizationDO;

/**
 * 菜品组成 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface DishesOrganizationConvert {

    DishesOrganizationConvert INSTANCE = Mappers.getMapper(DishesOrganizationConvert.class);

    DishesOrganizationDO convert(DishesOrganizationCreateReqVO bean);

    DishesOrganizationDO convert(DishesOrganizationUpdateReqVO bean);

    DishesOrganizationRespVO convert(DishesOrganizationDO bean);

    List<DishesOrganizationRespVO> convertList(List<DishesOrganizationDO> list);

    PageResult<DishesOrganizationRespVO> convertPage(PageResult<DishesOrganizationDO> page);

    List<DishesOrganizationExcelVO> convertList02(List<DishesOrganizationDO> list);

}
