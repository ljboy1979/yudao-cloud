package cn.acsm.module.purchase.convert.receivingstandard;

import cn.acsm.module.purchase.controller.admin.receivingstandard.vo.PurchaseReceivingStandardCreateReqVO;
import cn.acsm.module.purchase.controller.admin.receivingstandard.vo.PurchaseReceivingStandardExcelVO;
import cn.acsm.module.purchase.controller.admin.receivingstandard.vo.PurchaseReceivingStandardRespVO;
import cn.acsm.module.purchase.controller.admin.receivingstandard.vo.PurchaseReceivingStandardUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.receivingstandard.PurchaseReceivingStandardDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 收货标准 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface PurchaseReceivingStandardConvert {

    PurchaseReceivingStandardConvert INSTANCE = Mappers.getMapper(PurchaseReceivingStandardConvert.class);

    PurchaseReceivingStandardDO convert(PurchaseReceivingStandardCreateReqVO bean);

    PurchaseReceivingStandardDO convert(PurchaseReceivingStandardUpdateReqVO bean);

    PurchaseReceivingStandardRespVO convert(PurchaseReceivingStandardDO bean);

    List<PurchaseReceivingStandardRespVO> convertList(List<PurchaseReceivingStandardDO> list);

    PageResult<PurchaseReceivingStandardRespVO> convertPage(PageResult<PurchaseReceivingStandardDO> page);

    List<PurchaseReceivingStandardExcelVO> convertList02(List<PurchaseReceivingStandardDO> list);

}
