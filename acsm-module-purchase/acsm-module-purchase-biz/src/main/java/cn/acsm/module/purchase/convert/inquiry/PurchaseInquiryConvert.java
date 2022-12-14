package cn.acsm.module.purchase.convert.inquiry;

import cn.acsm.module.purchase.controller.admin.inquiry.vo.PurchaseInquiryCreateReqVO;
import cn.acsm.module.purchase.controller.admin.inquiry.vo.PurchaseInquiryExcelVO;
import cn.acsm.module.purchase.controller.admin.inquiry.vo.PurchaseInquiryRespVO;
import cn.acsm.module.purchase.controller.admin.inquiry.vo.PurchaseInquiryUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.inquiry.PurchaseInquiryDO;
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
public interface PurchaseInquiryConvert {

    PurchaseInquiryConvert INSTANCE = Mappers.getMapper(PurchaseInquiryConvert.class);

    PurchaseInquiryDO convert(PurchaseInquiryCreateReqVO bean);

    PurchaseInquiryDO convert(PurchaseInquiryUpdateReqVO bean);

    PurchaseInquiryRespVO convert(PurchaseInquiryDO bean);

    List<PurchaseInquiryRespVO> convertList(List<PurchaseInquiryDO> list);

    PageResult<PurchaseInquiryRespVO> convertPage(PageResult<PurchaseInquiryDO> page);

    List<PurchaseInquiryExcelVO> convertList02(List<PurchaseInquiryDO> list);

}
