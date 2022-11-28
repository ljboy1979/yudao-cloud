package cn.iocoder.yudao.module.transaction.sales.convert.dishescategory;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.dishescategory.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.dishescategory.DishesCategoryDO;

/**
 * 菜品分类 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface DishesCategoryConvert {

    DishesCategoryConvert INSTANCE = Mappers.getMapper(DishesCategoryConvert.class);

    DishesCategoryDO convert(DishesCategoryCreateReqVO bean);

    DishesCategoryDO convert(DishesCategoryUpdateReqVO bean);

    DishesCategoryRespVO convert(DishesCategoryDO bean);

    List<DishesCategoryRespVO> convertList(List<DishesCategoryDO> list);

    PageResult<DishesCategoryRespVO> convertPage(PageResult<DishesCategoryDO> page);

    List<DishesCategoryExcelVO> convertList02(List<DishesCategoryDO> list);

}
