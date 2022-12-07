package cn.acsm.module.transaction.shelves.convert.shelves;

import java.util.*;

import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesRespDto;
import cn.acsm.module.transaction.shelves.api.dto.PriceTagShelvesRespDto;
import cn.acsm.module.transaction.shelves.dal.dataobject.pricetag.PriceTagShelvesRespDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.shelves.controller.admin.shelves.vo.*;
import cn.acsm.module.transaction.shelves.dal.dataobject.shelves.ShelvesDO;

/**
 * 货架 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ShelvesConvert {

    ShelvesConvert INSTANCE = Mappers.getMapper(ShelvesConvert.class);

    ShelvesDO convert(ShelvesCreateReqVO bean);

    ShelvesDO convert(ShelvesUpdateReqVO bean);

    shelvesRespVO convert(ShelvesDO bean);

    List<shelvesRespVO> convertList(List<ShelvesDO> list);

    PageResult<shelvesRespVO> convertPage(PageResult<ShelvesDO> page);

    List<ShelvesExcelVO> convertList02(List<ShelvesDO> list);

    ShelvesSalesReqDto convertShelvesSalesReq(ShelvesReqVO bean);

    List<ShelvesSalesRespVO> convertShelvesSalesResp(List<ShelvesSalesRespDto> bean);

    List<PriceTagShelvesRespDto> convertShelvesPriceTag(List<PriceTagShelvesRespDO> bean);

}
