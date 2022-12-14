package cn.acsm.module.purchase.convert.loss;

import cn.acsm.module.purchase.controller.admin.loss.vo.PurchaseLossCreateReqVO;
import cn.acsm.module.purchase.controller.admin.loss.vo.PurchaseLossExcelVO;
import cn.acsm.module.purchase.controller.admin.loss.vo.PurchaseLossRespVO;
import cn.acsm.module.purchase.controller.admin.loss.vo.PurchaseLossUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.loss.PurchaseLossDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 损耗 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface PurchaseLossConvert {

    PurchaseLossConvert INSTANCE = Mappers.getMapper(PurchaseLossConvert.class);

    PurchaseLossDO convert(PurchaseLossCreateReqVO bean);

    PurchaseLossDO convert(PurchaseLossUpdateReqVO bean);

    PurchaseLossRespVO convert(PurchaseLossDO bean);

    List<PurchaseLossRespVO> convertList(List<PurchaseLossDO> list);

    PageResult<PurchaseLossRespVO> convertPage(PageResult<PurchaseLossDO> page);

    List<PurchaseLossExcelVO> convertList02(List<PurchaseLossDO> list);

}
