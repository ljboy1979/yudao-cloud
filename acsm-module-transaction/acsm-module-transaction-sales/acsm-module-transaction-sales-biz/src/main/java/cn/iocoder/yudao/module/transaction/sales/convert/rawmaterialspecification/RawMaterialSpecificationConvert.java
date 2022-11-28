package cn.iocoder.yudao.module.transaction.sales.convert.rawmaterialspecification;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.rawmaterialspecification.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.rawmaterialspecification.RawMaterialSpecificationDO;

/**
 * 原料规格 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface RawMaterialSpecificationConvert {

    RawMaterialSpecificationConvert INSTANCE = Mappers.getMapper(RawMaterialSpecificationConvert.class);

    RawMaterialSpecificationDO convert(RawMaterialSpecificationCreateReqVO bean);

    RawMaterialSpecificationDO convert(RawMaterialSpecificationUpdateReqVO bean);

    RawMaterialSpecificationRespVO convert(RawMaterialSpecificationDO bean);

    List<RawMaterialSpecificationRespVO> convertList(List<RawMaterialSpecificationDO> list);

    PageResult<RawMaterialSpecificationRespVO> convertPage(PageResult<RawMaterialSpecificationDO> page);

    List<RawMaterialSpecificationExcelVO> convertList02(List<RawMaterialSpecificationDO> list);

}
