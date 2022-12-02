package cn.acsm.module.transaction.sales.convert.nutritionfacts;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.sales.controller.admin.nutritionfacts.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.nutritionfacts.NutritionFactsDO;

/**
 * 营养成分 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface NutritionFactsConvert {

    NutritionFactsConvert INSTANCE = Mappers.getMapper(NutritionFactsConvert.class);

    NutritionFactsDO convert(NutritionFactsCreateReqVO bean);

    NutritionFactsDO convert(NutritionFactsUpdateReqVO bean);

    NutritionFactsRespVO convert(NutritionFactsDO bean);

    List<NutritionFactsRespVO> convertList(List<NutritionFactsDO> list);

    PageResult<NutritionFactsRespVO> convertPage(PageResult<NutritionFactsDO> page);

    List<NutritionFactsExcelVO> convertList02(List<NutritionFactsDO> list);

}
