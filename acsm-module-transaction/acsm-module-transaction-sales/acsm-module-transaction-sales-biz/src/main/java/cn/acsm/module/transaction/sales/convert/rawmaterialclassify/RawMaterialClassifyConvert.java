package cn.acsm.module.transaction.sales.convert.rawmaterialclassify;

import java.util.*;

import cn.acsm.module.transaction.sales.controller.admin.rawmaterialclassify.vo.RawMaterialClassifyCreateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.rawmaterialclassify.vo.RawMaterialClassifyExcelVO;
import cn.acsm.module.transaction.sales.controller.admin.rawmaterialclassify.vo.RawMaterialClassifyRespVO;
import cn.acsm.module.transaction.sales.controller.admin.rawmaterialclassify.vo.RawMaterialClassifyUpdateReqVO;
import cn.acsm.module.transaction.sales.dal.dataobject.rawmaterialclassify.RawMaterialClassifyDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.sales.controller.admin.rawmaterialclassify.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.rawmaterialclassify.RawMaterialClassifyDO;

/**
 * 原料分类 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface RawMaterialClassifyConvert {

    RawMaterialClassifyConvert INSTANCE = Mappers.getMapper(RawMaterialClassifyConvert.class);

    RawMaterialClassifyDO convert(RawMaterialClassifyCreateReqVO bean);

    RawMaterialClassifyDO convert(RawMaterialClassifyUpdateReqVO bean);

    RawMaterialClassifyRespVO convert(RawMaterialClassifyDO bean);

    List<RawMaterialClassifyRespVO> convertList(List<RawMaterialClassifyDO> list);

    PageResult<RawMaterialClassifyRespVO> convertPage(PageResult<RawMaterialClassifyDO> page);

    List<RawMaterialClassifyExcelVO> convertList02(List<RawMaterialClassifyDO> list);

    RawMaterialClassifyTreeVO convertListToTree(RawMaterialClassifyDO rawMaterialClassifyDO);

}
