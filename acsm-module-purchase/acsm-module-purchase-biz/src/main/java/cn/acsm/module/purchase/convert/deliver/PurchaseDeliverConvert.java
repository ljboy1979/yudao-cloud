package cn.acsm.module.purchase.convert.deliver;

import cn.acsm.module.purchase.controller.admin.deliver.vo.PurchaseDeliverCreateReqVO;
import cn.acsm.module.purchase.controller.admin.deliver.vo.PurchaseDeliverExcelVO;
import cn.acsm.module.purchase.controller.admin.deliver.vo.PurchaseDeliverRespVO;
import cn.acsm.module.purchase.controller.admin.deliver.vo.PurchaseDeliverUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.deliver.PurchaseDeliverDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 采购交付 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface PurchaseDeliverConvert {

    PurchaseDeliverConvert INSTANCE = Mappers.getMapper(PurchaseDeliverConvert.class);

    PurchaseDeliverDO convert(PurchaseDeliverCreateReqVO bean);

    PurchaseDeliverDO convert(PurchaseDeliverUpdateReqVO bean);

    PurchaseDeliverRespVO convert(PurchaseDeliverDO bean);

    List<PurchaseDeliverRespVO> convertList(List<PurchaseDeliverDO> list);

    PageResult<PurchaseDeliverRespVO> convertPage(PageResult<PurchaseDeliverDO> page);

    List<PurchaseDeliverExcelVO> convertList02(List<PurchaseDeliverDO> list);

}
