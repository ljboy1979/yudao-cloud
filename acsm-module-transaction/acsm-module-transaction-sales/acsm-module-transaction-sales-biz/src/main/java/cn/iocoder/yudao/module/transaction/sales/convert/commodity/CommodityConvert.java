package cn.iocoder.yudao.module.transaction.sales.convert.commodity;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.commodity.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.commodity.CommodityDO;

/**
 * 商品 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface CommodityConvert {

    CommodityConvert INSTANCE = Mappers.getMapper(CommodityConvert.class);

    CommodityDO convert(CommodityCreateReqVO bean);

    CommodityDO convert(CommodityUpdateReqVO bean);

    CommodityRespVO convert(CommodityDO bean);

    List<CommodityRespVO> convertList(List<CommodityDO> list);

    PageResult<CommodityRespVO> convertPage(PageResult<CommodityDO> page);

    List<CommodityExcelVO> convertList02(List<CommodityDO> list);

}
