package cn.acsm.module.member.wallet.convert.walletinfo;

import java.util.*;

import cn.acsm.module.member.wallet.controller.admin.walletinfo.vo.UserWalletInfoCreateReqVO;
import cn.acsm.module.member.wallet.controller.admin.walletinfo.vo.UserWalletInfoExcelVO;
import cn.acsm.module.member.wallet.controller.admin.walletinfo.vo.UserWalletInfoRespVO;
import cn.acsm.module.member.wallet.controller.admin.walletinfo.vo.UserWalletInfoUpdateReqVO;
import cn.acsm.module.member.wallet.dal.dataobject.walletinfo.UserWalletInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 用户钱包信息 Convert
 *
 * @author lihongyan
 */
@Mapper
public interface UserWalletInfoConvert {

    UserWalletInfoConvert INSTANCE = Mappers.getMapper(UserWalletInfoConvert.class);

    UserWalletInfoDO convert(UserWalletInfoCreateReqVO bean);

    UserWalletInfoDO convert(UserWalletInfoUpdateReqVO bean);

    UserWalletInfoRespVO convert(UserWalletInfoDO bean);

    List<UserWalletInfoRespVO> convertList(List<UserWalletInfoDO> list);

    PageResult<UserWalletInfoRespVO> convertPage(PageResult<UserWalletInfoDO> page);

    List<UserWalletInfoExcelVO> convertList02(List<UserWalletInfoDO> list);

}
