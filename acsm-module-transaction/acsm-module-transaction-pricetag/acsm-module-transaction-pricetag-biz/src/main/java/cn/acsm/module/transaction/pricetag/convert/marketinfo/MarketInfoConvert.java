package cn.acsm.module.transaction.pricetag.convert.marketinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.pricetag.controller.admin.marketinfo.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketinfo.MarketInfoDO;

/**
 * 市场信息 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface MarketInfoConvert {

    MarketInfoConvert INSTANCE = Mappers.getMapper(MarketInfoConvert.class);

    MarketInfoDO convert(MarketInfoCreateReqVO bean);

    MarketInfoDO convert(MarketInfoUpdateReqVO bean);

    MarketInfoRespVO convert(MarketInfoDO bean);

    List<MarketInfoRespVO> convertList(List<MarketInfoDO> list);

    PageResult<MarketInfoRespVO> convertPage(PageResult<MarketInfoDO> page);

    List<MarketInfoExcelVO> convertList02(List<MarketInfoDO> list);

}
