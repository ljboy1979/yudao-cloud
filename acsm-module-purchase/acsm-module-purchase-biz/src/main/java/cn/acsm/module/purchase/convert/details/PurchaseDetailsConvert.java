package cn.acsm.module.purchase.convert.details;

import cn.acsm.module.purchase.controller.admin.details.vo.PurchaseDetailsCreateReqVO;
import cn.acsm.module.purchase.controller.admin.details.vo.PurchaseDetailsExcelVO;
import cn.acsm.module.purchase.controller.admin.details.vo.PurchaseDetailsRespVO;
import cn.acsm.module.purchase.controller.admin.details.vo.PurchaseDetailsUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.details.PurchaseDetailsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 采购单明细 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface PurchaseDetailsConvert {

    PurchaseDetailsConvert INSTANCE = Mappers.getMapper(PurchaseDetailsConvert.class);

    PurchaseDetailsDO convert(PurchaseDetailsCreateReqVO bean);

    PurchaseDetailsDO convert(PurchaseDetailsUpdateReqVO bean);

    PurchaseDetailsRespVO convert(PurchaseDetailsDO bean);

    List<PurchaseDetailsRespVO> convertList(List<PurchaseDetailsDO> list);

    PageResult<PurchaseDetailsRespVO> convertPage(PageResult<PurchaseDetailsDO> page);

    List<PurchaseDetailsExcelVO> convertList02(List<PurchaseDetailsDO> list);

}
