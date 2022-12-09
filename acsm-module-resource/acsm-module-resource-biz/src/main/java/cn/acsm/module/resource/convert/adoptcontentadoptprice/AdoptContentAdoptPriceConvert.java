package cn.acsm.module.resource.convert.adoptcontentadoptprice;

import cn.acsm.module.resource.controller.admin.adoptcontentadoptprice.vo.AdoptContentAdoptPriceCreateReqVO;
import cn.acsm.module.resource.controller.admin.adoptcontentadoptprice.vo.AdoptContentAdoptPriceExcelVO;
import cn.acsm.module.resource.controller.admin.adoptcontentadoptprice.vo.AdoptContentAdoptPriceRespVO;
import cn.acsm.module.resource.controller.admin.adoptcontentadoptprice.vo.AdoptContentAdoptPriceUpdateReqVO;
import cn.acsm.module.resource.dal.dataobject.adoptcontentadoptprice.AdoptContentAdoptPriceDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 认养/租凭价格 Convert
 *
 * @author smile
 */
@Mapper
public interface AdoptContentAdoptPriceConvert {

    AdoptContentAdoptPriceConvert INSTANCE = Mappers.getMapper(AdoptContentAdoptPriceConvert.class);

    AdoptContentAdoptPriceDO convert(AdoptContentAdoptPriceCreateReqVO bean);

    AdoptContentAdoptPriceDO convert(AdoptContentAdoptPriceUpdateReqVO bean);

    AdoptContentAdoptPriceRespVO convert(AdoptContentAdoptPriceDO bean);

    List<AdoptContentAdoptPriceRespVO> convertList(List<AdoptContentAdoptPriceDO> list);

    PageResult<AdoptContentAdoptPriceRespVO> convertPage(PageResult<AdoptContentAdoptPriceDO> page);

    List<AdoptContentAdoptPriceExcelVO> convertList02(List<AdoptContentAdoptPriceDO> list);

}
