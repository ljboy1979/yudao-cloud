package cn.acsm.module.wallet.dal.mysql.wallet;

import java.util.*;

import cn.acsm.module.wallet.controller.admin.wallet.vo.TransactionHistoryExportReqVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.TransactionHistoryPageReqVO;
import cn.acsm.module.wallet.dal.dataobject.wallet.TransactionHistoryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 钱包交易记录子 Mapper
 *
 * @author lihongyan
 */
@Mapper
public interface TransactionHistoryMapper extends BaseMapperX<TransactionHistoryDO> {

    default PageResult<TransactionHistoryDO> selectPage(TransactionHistoryPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TransactionHistoryDO>()
                .eqIfPresent(TransactionHistoryDO::getMemberId, reqVO.getMemberId())
                .eqIfPresent(TransactionHistoryDO::getWalletId, reqVO.getWalletId())
                .eqIfPresent(TransactionHistoryDO::getTransactionNumber, reqVO.getTransactionNumber())
                .eqIfPresent(TransactionHistoryDO::getTransactionType, reqVO.getTransactionType())
                .eqIfPresent(TransactionHistoryDO::getPayType, reqVO.getPayType())
                .eqIfPresent(TransactionHistoryDO::getAssociatedDocuments, reqVO.getAssociatedDocuments())
                .eqIfPresent(TransactionHistoryDO::getTransactionContent, reqVO.getTransactionContent())
                .eqIfPresent(TransactionHistoryDO::getAmount, reqVO.getAmount())
                .betweenIfPresent(TransactionHistoryDO::getTransactionTime, reqVO.getTransactionTime())
                .eqIfPresent(TransactionHistoryDO::getPayer, reqVO.getPayer())
                .eqIfPresent(TransactionHistoryDO::getRecipient, reqVO.getRecipient())
                .eqIfPresent(TransactionHistoryDO::getPaymentAccountNumber, reqVO.getPaymentAccountNumber())
                .eqIfPresent(TransactionHistoryDO::getPayoutAccount, reqVO.getPayoutAccount())
                .eqIfPresent(TransactionHistoryDO::getTransactionStatus, reqVO.getTransactionStatus())
                .eqIfPresent(TransactionHistoryDO::getRemark, reqVO.getRemark())
                .eqIfPresent(TransactionHistoryDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(TransactionHistoryDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(TransactionHistoryDO::getSource, reqVO.getSource())
                .eqIfPresent(TransactionHistoryDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(TransactionHistoryDO::getId));
    }

    default List<TransactionHistoryDO> selectList(TransactionHistoryExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<TransactionHistoryDO>()
                .eqIfPresent(TransactionHistoryDO::getMemberId, reqVO.getMemberId())
                .eqIfPresent(TransactionHistoryDO::getWalletId, reqVO.getWalletId())
                .eqIfPresent(TransactionHistoryDO::getTransactionNumber, reqVO.getTransactionNumber())
                .eqIfPresent(TransactionHistoryDO::getTransactionType, reqVO.getTransactionType())
                .eqIfPresent(TransactionHistoryDO::getPayType, reqVO.getPayType())
                .eqIfPresent(TransactionHistoryDO::getAssociatedDocuments, reqVO.getAssociatedDocuments())
                .eqIfPresent(TransactionHistoryDO::getTransactionContent, reqVO.getTransactionContent())
                .eqIfPresent(TransactionHistoryDO::getAmount, reqVO.getAmount())
                .betweenIfPresent(TransactionHistoryDO::getTransactionTime, reqVO.getTransactionTime())
                .eqIfPresent(TransactionHistoryDO::getPayer, reqVO.getPayer())
                .eqIfPresent(TransactionHistoryDO::getRecipient, reqVO.getRecipient())
                .eqIfPresent(TransactionHistoryDO::getPaymentAccountNumber, reqVO.getPaymentAccountNumber())
                .eqIfPresent(TransactionHistoryDO::getPayoutAccount, reqVO.getPayoutAccount())
                .eqIfPresent(TransactionHistoryDO::getTransactionStatus, reqVO.getTransactionStatus())
                .eqIfPresent(TransactionHistoryDO::getRemark, reqVO.getRemark())
                .eqIfPresent(TransactionHistoryDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(TransactionHistoryDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(TransactionHistoryDO::getSource, reqVO.getSource())
                .eqIfPresent(TransactionHistoryDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(TransactionHistoryDO::getId));
    }

}
