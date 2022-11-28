package cn.iocoder.yudao.module.transaction.sales.convert.rawmaterial;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.rawmaterial.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.rawmaterial.RawMaterialDO;

/**
 * 原料 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface RawMaterialConvert {

    RawMaterialConvert INSTANCE = Mappers.getMapper(RawMaterialConvert.class);

    RawMaterialDO convert(RawMaterialCreateReqVO bean);

    RawMaterialDO convert(RawMaterialUpdateReqVO bean);

    RawMaterialRespVO convert(RawMaterialDO bean);

    List<RawMaterialRespVO> convertList(List<RawMaterialDO> list);

    PageResult<RawMaterialRespVO> convertPage(PageResult<RawMaterialDO> page);

    List<RawMaterialExcelVO> convertList02(List<RawMaterialDO> list);

}
