package cn.acsm.module.transaction.sales.convert.commoditysku;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.sales.controller.admin.commoditysku.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.commoditysku.CommoditySkuDO;

/**
 * 商品sku Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface CommoditySkuConvert {

    CommoditySkuConvert INSTANCE = Mappers.getMapper(CommoditySkuConvert.class);

    CommoditySkuDO convert(CommoditySkuCreateReqVO bean);

    CommoditySkuDO convert(CommoditySkuUpdateReqVO bean);

    CommoditySkuRespVO convert(CommoditySkuDO bean);

    List<CommoditySkuRespVO> convertList(List<CommoditySkuDO> list);

    PageResult<CommoditySkuRespVO> convertPage(PageResult<CommoditySkuDO> page);

    List<CommoditySkuExcelVO> convertList02(List<CommoditySkuDO> list);

}
