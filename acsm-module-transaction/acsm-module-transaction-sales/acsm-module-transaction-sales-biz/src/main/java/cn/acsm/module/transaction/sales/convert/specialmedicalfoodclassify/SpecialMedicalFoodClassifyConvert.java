package cn.acsm.module.transaction.sales.convert.specialmedicalfoodclassify;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodclassify.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.specialmedicalfoodclassify.SpecialMedicalFoodClassifyDO;

/**
 * 特医食品分类 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface SpecialMedicalFoodClassifyConvert {

    SpecialMedicalFoodClassifyConvert INSTANCE = Mappers.getMapper(SpecialMedicalFoodClassifyConvert.class);

    SpecialMedicalFoodClassifyDO convert(SpecialMedicalFoodClassifyCreateReqVO bean);

    SpecialMedicalFoodClassifyDO convert(SpecialMedicalFoodClassifyUpdateReqVO bean);

    SpecialMedicalFoodClassifyRespVO convert(SpecialMedicalFoodClassifyDO bean);

    List<SpecialMedicalFoodClassifyRespVO> convertList(List<SpecialMedicalFoodClassifyDO> list);

    PageResult<SpecialMedicalFoodClassifyRespVO> convertPage(PageResult<SpecialMedicalFoodClassifyDO> page);

    List<SpecialMedicalFoodClassifyExcelVO> convertList02(List<SpecialMedicalFoodClassifyDO> list);

    static SpecialMedicalFoodClassifyTreeVO convertListToTree(SpecialMedicalFoodClassifyDO bean) {
        SpecialMedicalFoodClassifyTreeVO specialMedicalFoodClassifyTreeVO = new SpecialMedicalFoodClassifyTreeVO();
        specialMedicalFoodClassifyTreeVO.setId(Long.valueOf(bean.getId()));
        specialMedicalFoodClassifyTreeVO.setName(bean.getCategoryName());
        specialMedicalFoodClassifyTreeVO.setParentId(Long.valueOf(bean.getParentCode()));
        specialMedicalFoodClassifyTreeVO.setSort(bean.getTreeSort().intValue());
        return specialMedicalFoodClassifyTreeVO;
    };
}
