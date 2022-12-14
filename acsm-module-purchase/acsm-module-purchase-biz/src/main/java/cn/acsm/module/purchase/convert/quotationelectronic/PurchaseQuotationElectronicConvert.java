package cn.acsm.module.purchase.convert.quotationelectronic;

import cn.acsm.module.purchase.controller.admin.quotationelectronic.vo.PurchaseQuotationElectronicCreateReqVO;
import cn.acsm.module.purchase.controller.admin.quotationelectronic.vo.PurchaseQuotationElectronicExcelVO;
import cn.acsm.module.purchase.controller.admin.quotationelectronic.vo.PurchaseQuotationElectronicRespVO;
import cn.acsm.module.purchase.controller.admin.quotationelectronic.vo.PurchaseQuotationElectronicUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.quotationelectronic.PurchaseQuotationElectronicDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 采购报价单电子 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface PurchaseQuotationElectronicConvert {

    PurchaseQuotationElectronicConvert INSTANCE = Mappers.getMapper(PurchaseQuotationElectronicConvert.class);

    PurchaseQuotationElectronicDO convert(PurchaseQuotationElectronicCreateReqVO bean);

    PurchaseQuotationElectronicDO convert(PurchaseQuotationElectronicUpdateReqVO bean);

    PurchaseQuotationElectronicRespVO convert(PurchaseQuotationElectronicDO bean);

    List<PurchaseQuotationElectronicRespVO> convertList(List<PurchaseQuotationElectronicDO> list);

    PageResult<PurchaseQuotationElectronicRespVO> convertPage(PageResult<PurchaseQuotationElectronicDO> page);

    List<PurchaseQuotationElectronicExcelVO> convertList02(List<PurchaseQuotationElectronicDO> list);

}
