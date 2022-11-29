package cn.acsm.module.transaction.sales.convert.dishesspecification;

import java.util.*;

import cn.acsm.module.transaction.sales.controller.admin.dishesspecification.vo.DishesSpecificationCreateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.dishesspecification.vo.DishesSpecificationExcelVO;
import cn.acsm.module.transaction.sales.controller.admin.dishesspecification.vo.DishesSpecificationRespVO;
import cn.acsm.module.transaction.sales.controller.admin.dishesspecification.vo.DishesSpecificationUpdateReqVO;
import cn.acsm.module.transaction.sales.dal.dataobject.dishesspecification.DishesSpecificationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 菜品规格 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface DishesSpecificationConvert {

    DishesSpecificationConvert INSTANCE = Mappers.getMapper(DishesSpecificationConvert.class);

    DishesSpecificationDO convert(DishesSpecificationCreateReqVO bean);

    DishesSpecificationDO convert(DishesSpecificationUpdateReqVO bean);

    DishesSpecificationRespVO convert(DishesSpecificationDO bean);

    List<DishesSpecificationRespVO> convertList(List<DishesSpecificationDO> list);

    PageResult<DishesSpecificationRespVO> convertPage(PageResult<DishesSpecificationDO> page);

    List<DishesSpecificationExcelVO> convertList02(List<DishesSpecificationDO> list);

}
