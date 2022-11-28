package cn.iocoder.yudao.module.transaction.sales.convert.inputsinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.inputsinfo.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.inputsinfo.InputsInfoDO;

/**
 * 投入品 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface InputsInfoConvert {

    InputsInfoConvert INSTANCE = Mappers.getMapper(InputsInfoConvert.class);

    InputsInfoDO convert(InputsInfoCreateReqVO bean);

    InputsInfoDO convert(InputsInfoUpdateReqVO bean);

    InputsInfoRespVO convert(InputsInfoDO bean);

    List<InputsInfoRespVO> convertList(List<InputsInfoDO> list);

    PageResult<InputsInfoRespVO> convertPage(PageResult<InputsInfoDO> page);

    List<InputsInfoExcelVO> convertList02(List<InputsInfoDO> list);

}
