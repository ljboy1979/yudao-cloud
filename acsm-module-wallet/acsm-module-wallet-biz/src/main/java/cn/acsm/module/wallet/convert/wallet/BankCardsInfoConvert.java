package cn.acsm.module.wallet.convert.wallet;

import java.util.*;

import cn.acsm.module.wallet.controller.admin.wallet.vo.BankCardsInfoCreateReqVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.BankCardsInfoExcelVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.BankCardsInfoRespVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.BankCardsInfoUpdateReqVO;
import cn.acsm.module.wallet.dal.dataobject.wallet.BankCardsInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 关联银行卡子 Convert
 *
 * @author lihongyan
 */
@Mapper
public interface BankCardsInfoConvert {

    BankCardsInfoConvert INSTANCE = Mappers.getMapper(BankCardsInfoConvert.class);

    BankCardsInfoDO convert(BankCardsInfoCreateReqVO bean);

    BankCardsInfoDO convert(BankCardsInfoUpdateReqVO bean);

    BankCardsInfoRespVO convert(BankCardsInfoDO bean);

    List<BankCardsInfoRespVO> convertList(List<BankCardsInfoDO> list);

    PageResult<BankCardsInfoRespVO> convertPage(PageResult<BankCardsInfoDO> page);

    List<BankCardsInfoExcelVO> convertList02(List<BankCardsInfoDO> list);

}
