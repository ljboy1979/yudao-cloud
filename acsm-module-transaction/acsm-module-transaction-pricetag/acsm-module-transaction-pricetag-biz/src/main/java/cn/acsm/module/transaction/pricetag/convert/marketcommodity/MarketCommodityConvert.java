package cn.acsm.module.transaction.pricetag.convert.marketcommodity;

import java.util.*;

import cn.acsm.module.transaction.pricetag.api.dto.MarketPriceDto;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketcommodity.MarketPriceFeignDO;
import cn.acsm.module.transaction.shelves.api.dto.ShelvesReqDto;
import cn.acsm.module.transaction.shelves.api.dto.ShelvesRespDto;
import cn.acsm.module.transaction.shelves.api.dto.TreeSelectDto;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.pricetag.controller.admin.marketcommodity.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketcommodity.MarketCommodityDO;

/**
 * 市场商品 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface MarketCommodityConvert {

    MarketCommodityConvert INSTANCE = Mappers.getMapper(MarketCommodityConvert.class);

    MarketCommodityDO convert(MarketCommodityCreateReqVO bean);

    MarketCommodityDO convert(MarketCommodityUpdateReqVO bean);

    MarketCommodityRespVO convert(MarketCommodityDO bean);

    List<MarketCommodityRespVO> convertList(List<MarketCommodityDO> list);

    PageResult<MarketCommodityRespVO> convertPage(PageResult<MarketCommodityDO> page);

    List<MarketCommodityExcelVO> convertList02(List<MarketCommodityDO> list);


    ShelvesReqDto convertShelvesReqDto(ShelvesReqVo bean);

    List<ShelvesRespVo> convertShelvesRespList(List<ShelvesRespDto> list);

    static   List<TreeSelectVo> convertShelvesTreeRespList(List<TreeSelectDto> list) {
        if ( list == null ) {
            return null;
        }

        List<TreeSelectVo> treeSelectVos = new ArrayList<>(list.size());
        for ( TreeSelectDto treeSelectDto : list ) {
            TreeSelectVo treeSelectVo = new TreeSelectVo();
            treeSelectVo.setId(Long.valueOf(treeSelectDto.getId()));
            treeSelectVo.setChildren(treeSelectDto.getChildren());
            treeSelectVo.setLabel(treeSelectDto.getLabel());
            treeSelectVos.add(treeSelectVo) ;
        }

        return treeSelectVos;
    };

    List<MarketPriceDto> convertMarketPriceDto(List<MarketPriceFeignDO> marketPriceFeignDOS);

}
