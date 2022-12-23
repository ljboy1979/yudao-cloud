package cn.acsm.module.transaction.sales.convert.commodity;

import java.util.*;

import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesRespDto;
import cn.acsm.module.transaction.sales.dal.dataobject.commodity.CommodityCustomDO;
import cn.acsm.module.transaction.sales.dal.dataobject.commodity.CommodityDO;
import cn.acsm.module.transaction.sales.dal.dataobject.shelves.ShelvesSalesRespDo;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.*;

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

    List<ShelvesSalesRespDto> convertShelvesSales(List<ShelvesSalesRespDo> bean);
    CommodityRespVO convertCustom(CommodityCustomDO bean);
}
