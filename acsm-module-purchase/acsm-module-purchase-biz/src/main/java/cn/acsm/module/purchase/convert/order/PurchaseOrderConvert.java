package cn.acsm.module.purchase.convert.order;

import cn.acsm.module.purchase.controller.admin.order.vo.PurchaseOrderCreateReqVO;
import cn.acsm.module.purchase.controller.admin.order.vo.PurchaseOrderExcelVO;
import cn.acsm.module.purchase.controller.admin.order.vo.PurchaseOrderRespVO;
import cn.acsm.module.purchase.controller.admin.order.vo.PurchaseOrderUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.order.PurchaseOrderDO;
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
public interface PurchaseOrderConvert {

    PurchaseOrderConvert INSTANCE = Mappers.getMapper(PurchaseOrderConvert.class);

    PurchaseOrderDO convert(PurchaseOrderCreateReqVO bean);

    PurchaseOrderDO convert(PurchaseOrderUpdateReqVO bean);

    PurchaseOrderRespVO convert(PurchaseOrderDO bean);

    List<PurchaseOrderRespVO> convertList(List<PurchaseOrderDO> list);

    PageResult<PurchaseOrderRespVO> convertPage(PageResult<PurchaseOrderDO> page);

    List<PurchaseOrderExcelVO> convertList02(List<PurchaseOrderDO> list);

}
