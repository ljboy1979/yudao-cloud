package cn.acsm.module.transaction.sales.convert.commoditycategory;

import java.util.*;

import cn.acsm.module.transaction.sales.controller.admin.commoditycategory.vo.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.sales.dal.dataobject.commoditycategory.CommodityCategoryDO;

/**
 * 商品分类 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface CommodityCategoryConvert {

    CommodityCategoryConvert INSTANCE = Mappers.getMapper(CommodityCategoryConvert.class);

    CommodityCategoryDO convert(CommodityCategoryCreateReqVO bean);

    CommodityCategoryDO convert(CommodityCategoryUpdateReqVO bean);

    CommodityCategoryRespVO convert(CommodityCategoryDO bean);

    List<CommodityCategoryRespVO> convertList(List<CommodityCategoryDO> list);

    PageResult<CommodityCategoryRespVO> convertPage(PageResult<CommodityCategoryDO> page);

    List<CommodityCategoryExcelVO> convertList02(List<CommodityCategoryDO> list);

    static CommodityCategoryTreeVO convertListToTree(CommodityCategoryDO bean) {
        CommodityCategoryTreeVO commodityCategoryTreeVO = new CommodityCategoryTreeVO();
        commodityCategoryTreeVO.setId(Long.valueOf(bean.getId()));
        commodityCategoryTreeVO.setName(bean.getCommodityCategoryName());
        commodityCategoryTreeVO.setParentId(Long.valueOf(bean.getParentCode()));
        commodityCategoryTreeVO.setSort(bean.getTreeSort().intValue());
        return commodityCategoryTreeVO;
    };

}
