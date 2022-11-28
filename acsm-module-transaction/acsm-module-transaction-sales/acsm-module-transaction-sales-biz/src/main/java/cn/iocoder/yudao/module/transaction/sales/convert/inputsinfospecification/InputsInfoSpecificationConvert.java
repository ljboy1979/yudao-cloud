package cn.iocoder.yudao.module.transaction.sales.convert.inputsinfospecification;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.inputsinfospecification.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.inputsinfospecification.InputsInfoSpecificationDO;

/**
 * 投入品规格 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface InputsInfoSpecificationConvert {

    InputsInfoSpecificationConvert INSTANCE = Mappers.getMapper(InputsInfoSpecificationConvert.class);

    InputsInfoSpecificationDO convert(InputsInfoSpecificationCreateReqVO bean);

    InputsInfoSpecificationDO convert(InputsInfoSpecificationUpdateReqVO bean);

    InputsInfoSpecificationRespVO convert(InputsInfoSpecificationDO bean);

    List<InputsInfoSpecificationRespVO> convertList(List<InputsInfoSpecificationDO> list);

    PageResult<InputsInfoSpecificationRespVO> convertPage(PageResult<InputsInfoSpecificationDO> page);

    List<InputsInfoSpecificationExcelVO> convertList02(List<InputsInfoSpecificationDO> list);

}
