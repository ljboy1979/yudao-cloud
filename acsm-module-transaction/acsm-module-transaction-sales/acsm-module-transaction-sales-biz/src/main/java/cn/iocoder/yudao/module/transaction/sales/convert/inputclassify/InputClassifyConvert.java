package cn.iocoder.yudao.module.transaction.sales.convert.inputclassify;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.inputclassify.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.inputclassify.InputClassifyDO;

/**
 * 投入品分类 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface InputClassifyConvert {

    InputClassifyConvert INSTANCE = Mappers.getMapper(InputClassifyConvert.class);

    InputClassifyDO convert(InputClassifyCreateReqVO bean);

    InputClassifyDO convert(InputClassifyUpdateReqVO bean);

    InputClassifyRespVO convert(InputClassifyDO bean);

    List<InputClassifyRespVO> convertList(List<InputClassifyDO> list);

    PageResult<InputClassifyRespVO> convertPage(PageResult<InputClassifyDO> page);

    List<InputClassifyExcelVO> convertList02(List<InputClassifyDO> list);

}
