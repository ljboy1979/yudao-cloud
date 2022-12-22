package cn.acsm.module.purchase.convert.inquirydetail;

import cn.acsm.module.purchase.controller.admin.inquirydetail.vo.PurchaseInquiryDetailCreateReqVO;
import cn.acsm.module.purchase.controller.admin.inquirydetail.vo.PurchaseInquiryDetailExcelVO;
import cn.acsm.module.purchase.controller.admin.inquirydetail.vo.PurchaseInquiryDetailRespVO;
import cn.acsm.module.purchase.controller.admin.inquirydetail.vo.PurchaseInquiryDetailUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.inquirydetail.PurchaseInquiryDetailDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 采购询价电子表 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface PurchaseInquiryDetailConvert {

    PurchaseInquiryDetailConvert INSTANCE = Mappers.getMapper(PurchaseInquiryDetailConvert.class);

    PurchaseInquiryDetailDO convert(PurchaseInquiryDetailCreateReqVO bean);

    PurchaseInquiryDetailDO convert(PurchaseInquiryDetailUpdateReqVO bean);

    PurchaseInquiryDetailRespVO convert(PurchaseInquiryDetailDO bean);

    List<PurchaseInquiryDetailRespVO> convertList(List<PurchaseInquiryDetailDO> list);

    PageResult<PurchaseInquiryDetailRespVO> convertPage(PageResult<PurchaseInquiryDetailDO> page);

    List<PurchaseInquiryDetailExcelVO> convertList02(List<PurchaseInquiryDetailDO> list);

}
