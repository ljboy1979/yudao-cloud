package cn.acsm.module.transaction.sales.convert.commodityorganization;

import java.util.*;

import cn.acsm.module.transaction.sales.controller.admin.commodityorganization.vo.CommodityOrganizationCreateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodityorganization.vo.CommodityOrganizationExcelVO;
import cn.acsm.module.transaction.sales.controller.admin.commodityorganization.vo.CommodityOrganizationRespVO;
import cn.acsm.module.transaction.sales.controller.admin.commodityorganization.vo.CommodityOrganizationUpdateReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.sales.dal.dataobject.commodityorganization.CommodityOrganizationDO;

/**
 * 商品组成 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface CommodityOrganizationConvert {

    CommodityOrganizationConvert INSTANCE = Mappers.getMapper(CommodityOrganizationConvert.class);

    CommodityOrganizationDO convert(CommodityOrganizationCreateReqVO bean);

    CommodityOrganizationDO convert(CommodityOrganizationUpdateReqVO bean);

    CommodityOrganizationRespVO convert(CommodityOrganizationDO bean);

    List<CommodityOrganizationRespVO> convertList(List<CommodityOrganizationDO> list);

    PageResult<CommodityOrganizationRespVO> convertPage(PageResult<CommodityOrganizationDO> page);

    List<CommodityOrganizationExcelVO> convertList02(List<CommodityOrganizationDO> list);

}
