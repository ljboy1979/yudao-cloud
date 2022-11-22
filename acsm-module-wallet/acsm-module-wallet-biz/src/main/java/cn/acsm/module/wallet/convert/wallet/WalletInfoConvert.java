package cn.acsm.module.wallet.convert.wallet;

import java.util.*;

import cn.acsm.module.wallet.controller.admin.wallet.vo.WalletInfoCreateReqVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.WalletInfoExcelVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.WalletInfoRespVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.WalletInfoUpdateReqVO;
import cn.acsm.module.wallet.dal.dataobject.wallet.WalletInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 钱包信息 Convert
 *
 * @author lihongyan
 */
@Mapper
public interface WalletInfoConvert {

    WalletInfoConvert INSTANCE = Mappers.getMapper(WalletInfoConvert.class);

    WalletInfoDO convert(WalletInfoCreateReqVO bean);

    WalletInfoDO convert(WalletInfoUpdateReqVO bean);

    WalletInfoRespVO convert(WalletInfoDO bean);

    List<WalletInfoRespVO> convertList(List<WalletInfoDO> list);

    PageResult<WalletInfoRespVO> convertPage(PageResult<WalletInfoDO> page);

    List<WalletInfoExcelVO> convertList02(List<WalletInfoDO> list);

}
