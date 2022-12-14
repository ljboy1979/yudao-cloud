package cn.acsm.module.purchase.convert.purchase;

import cn.acsm.module.purchase.api.purchase.dto.PurchaseOrderReqDTO;
import cn.acsm.module.purchase.controller.admin.purchase.vo.PurchaseCreateReqVO;
import cn.acsm.module.purchase.controller.admin.purchase.vo.PurchaseExcelVO;
import cn.acsm.module.purchase.controller.admin.purchase.vo.PurchaseRespVO;
import cn.acsm.module.purchase.controller.admin.purchase.vo.PurchaseUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.purchase.PurchaseDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 采购单 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface PurchaseConvert {

    PurchaseConvert INSTANCE = Mappers.getMapper(PurchaseConvert.class);

    PurchaseDO convert(PurchaseCreateReqVO bean);

    PurchaseDO convert(PurchaseUpdateReqVO bean);

    PurchaseRespVO convert(PurchaseDO bean);

    List<PurchaseRespVO> convertList(List<PurchaseDO> list);

    PageResult<PurchaseRespVO> convertPage(PageResult<PurchaseDO> page);

    List<PurchaseExcelVO> convertList02(List<PurchaseDO> list);

    PurchaseOrderReqDTO convert01(PurchaseDO bean);

    List<PurchaseOrderReqDTO> convertList01(List<PurchaseDO> list);

}
