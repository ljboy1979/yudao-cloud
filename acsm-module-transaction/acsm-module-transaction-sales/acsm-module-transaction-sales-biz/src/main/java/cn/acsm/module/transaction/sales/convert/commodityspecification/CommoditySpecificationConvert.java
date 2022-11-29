package cn.acsm.module.transaction.sales.convert.commodityspecification;

import java.util.*;

import cn.acsm.module.transaction.sales.controller.admin.commodityspecification.vo.CommoditySpecificationCreateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodityspecification.vo.CommoditySpecificationExcelVO;
import cn.acsm.module.transaction.sales.controller.admin.commodityspecification.vo.CommoditySpecificationRespVO;
import cn.acsm.module.transaction.sales.controller.admin.commodityspecification.vo.CommoditySpecificationUpdateReqVO;
import cn.acsm.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.sales.controller.admin.commodityspecification.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO;

/**
 * 商品规格 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface CommoditySpecificationConvert {

    CommoditySpecificationConvert INSTANCE = Mappers.getMapper(CommoditySpecificationConvert.class);

    CommoditySpecificationDO convert(CommoditySpecificationCreateReqVO bean);

    CommoditySpecificationDO convert(CommoditySpecificationUpdateReqVO bean);

    CommoditySpecificationRespVO convert(CommoditySpecificationDO bean);

    List<CommoditySpecificationRespVO> convertList(List<CommoditySpecificationDO> list);

    PageResult<CommoditySpecificationRespVO> convertPage(PageResult<CommoditySpecificationDO> page);

    List<CommoditySpecificationExcelVO> convertList02(List<CommoditySpecificationDO> list);

}
