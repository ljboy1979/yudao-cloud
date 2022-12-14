package cn.acsm.module.purchase.convert.quotation;

import cn.acsm.module.purchase.controller.admin.quotation.vo.PurchaseQuotationCreateReqVO;
import cn.acsm.module.purchase.controller.admin.quotation.vo.PurchaseQuotationExcelVO;
import cn.acsm.module.purchase.controller.admin.quotation.vo.PurchaseQuotationRespVO;
import cn.acsm.module.purchase.controller.admin.quotation.vo.PurchaseQuotationUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.quotation.PurchaseQuotationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 采购询价电子 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface PurchaseQuotationConvert {

    PurchaseQuotationConvert INSTANCE = Mappers.getMapper(PurchaseQuotationConvert.class);

    PurchaseQuotationDO convert(PurchaseQuotationCreateReqVO bean);

    PurchaseQuotationDO convert(PurchaseQuotationUpdateReqVO bean);

    PurchaseQuotationRespVO convert(PurchaseQuotationDO bean);

    List<PurchaseQuotationRespVO> convertList(List<PurchaseQuotationDO> list);

    PageResult<PurchaseQuotationRespVO> convertPage(PageResult<PurchaseQuotationDO> page);

    List<PurchaseQuotationExcelVO> convertList02(List<PurchaseQuotationDO> list);

}
