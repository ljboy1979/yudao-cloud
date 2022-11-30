package cn.acsm.module.transaction.sales.convert.inputclassify;

import java.util.*;

import cn.acsm.module.transaction.sales.controller.admin.inputclassify.vo.InputClassifyCreateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.inputclassify.vo.InputClassifyExcelVO;
import cn.acsm.module.transaction.sales.controller.admin.inputclassify.vo.InputClassifyRespVO;
import cn.acsm.module.transaction.sales.dal.dataobject.inputclassify.InputClassifyDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.sales.controller.admin.inputclassify.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.inputclassify.InputClassifyDO;

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

    InputClassifyTreeVO convertListToTree(InputClassifyDO inputClassifyDO);
}
