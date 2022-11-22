package cn.acsm.module.wallet.dal.mysql.wallet;

import java.util.*;

import cn.acsm.module.wallet.controller.admin.wallet.vo.BankCardsInfoExportReqVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.BankCardsInfoPageReqVO;
import cn.acsm.module.wallet.dal.dataobject.wallet.BankCardsInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 关联银行卡子 Mapper
 *
 * @author lihongyan
 */
@Mapper
public interface BankCardsInfoMapper extends BaseMapperX<BankCardsInfoDO> {

    default PageResult<BankCardsInfoDO> selectPage(BankCardsInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BankCardsInfoDO>()
                .eqIfPresent(BankCardsInfoDO::getMemberId, reqVO.getMemberId())
                .eqIfPresent(BankCardsInfoDO::getWalletId, reqVO.getWalletId())
                .eqIfPresent(BankCardsInfoDO::getBankCardType, reqVO.getBankCardType())
                .eqIfPresent(BankCardsInfoDO::getCardholder, reqVO.getCardholder())
                .eqIfPresent(BankCardsInfoDO::getCardNumber, reqVO.getCardNumber())
                .eqIfPresent(BankCardsInfoDO::getPhone, reqVO.getPhone())
                .eqIfPresent(BankCardsInfoDO::getRemark, reqVO.getRemark())
                .eqIfPresent(BankCardsInfoDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(BankCardsInfoDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(BankCardsInfoDO::getSource, reqVO.getSource())
                .eqIfPresent(BankCardsInfoDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(BankCardsInfoDO::getId));
    }

    default List<BankCardsInfoDO> selectList(BankCardsInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<BankCardsInfoDO>()
                .eqIfPresent(BankCardsInfoDO::getMemberId, reqVO.getMemberId())
                .eqIfPresent(BankCardsInfoDO::getWalletId, reqVO.getWalletId())
                .eqIfPresent(BankCardsInfoDO::getBankCardType, reqVO.getBankCardType())
                .eqIfPresent(BankCardsInfoDO::getCardholder, reqVO.getCardholder())
                .eqIfPresent(BankCardsInfoDO::getCardNumber, reqVO.getCardNumber())
                .eqIfPresent(BankCardsInfoDO::getPhone, reqVO.getPhone())
                .eqIfPresent(BankCardsInfoDO::getRemark, reqVO.getRemark())
                .eqIfPresent(BankCardsInfoDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(BankCardsInfoDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(BankCardsInfoDO::getSource, reqVO.getSource())
                .eqIfPresent(BankCardsInfoDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(BankCardsInfoDO::getId));
    }

}
