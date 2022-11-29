package cn.acsm.module.transaction.sales.convert.dishes;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.sales.controller.admin.dishes.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.dishes.DishesDO;

/**
 * 菜品 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface DishesConvert {

    DishesConvert INSTANCE = Mappers.getMapper(DishesConvert.class);

    DishesDO convert(DishesCreateReqVO bean);

    DishesDO convert(DishesUpdateReqVO bean);

    DishesRespVO convert(DishesDO bean);

    List<DishesRespVO> convertList(List<DishesDO> list);

    PageResult<DishesRespVO> convertPage(PageResult<DishesDO> page);

    List<DishesExcelVO> convertList02(List<DishesDO> list);

}
