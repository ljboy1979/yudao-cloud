package cn.acsm.module.wallet.service.wallet;

import cn.acsm.module.wallet.controller.admin.wallet.vo.TransactionHistoryCreateReqVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.TransactionHistoryExportReqVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.TransactionHistoryPageReqVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.TransactionHistoryUpdateReqVO;
import cn.acsm.module.wallet.convert.wallet.TransactionHistoryConvert;
import cn.acsm.module.wallet.dal.dataobject.wallet.TransactionHistoryDO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.wallet.dal.mysql.wallet.TransactionHistoryMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.wallet.enums.ErrorCodeConstants.*;

/**
 * 钱包交易记录子 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class TransactionHistoryServiceImpl implements TransactionHistoryService {

    @Resource
    private TransactionHistoryMapper transactionHistoryMapper;

    @Override
    public Long createTransactionHistory(TransactionHistoryCreateReqVO createReqVO) {
        // 插入
        TransactionHistoryDO transactionHistory = TransactionHistoryConvert.INSTANCE.convert(createReqVO);
        transactionHistoryMapper.insert(transactionHistory);
        // 返回
        return transactionHistory.getId();
    }

    @Override
    public void updateTransactionHistory(TransactionHistoryUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateTransactionHistoryExists(updateReqVO.getId());
        // 更新
        TransactionHistoryDO updateObj = TransactionHistoryConvert.INSTANCE.convert(updateReqVO);
        transactionHistoryMapper.updateById(updateObj);
    }

    @Override
    public void deleteTransactionHistory(Long id) {
        // 校验存在
        this.validateTransactionHistoryExists(id);
        // 删除
        transactionHistoryMapper.deleteById(id);
    }

    private void validateTransactionHistoryExists(Long id) {
        if (transactionHistoryMapper.selectById(id) == null) {
            throw exception(TRANSACTION_HISTORY_NOT_EXISTS);
        }
    }

    @Override
    public TransactionHistoryDO getTransactionHistory(Long id) {
        return transactionHistoryMapper.selectById(id);
    }

    @Override
    public List<TransactionHistoryDO> getTransactionHistoryList(Collection<Long> ids) {
        return transactionHistoryMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<TransactionHistoryDO> getTransactionHistoryPage(TransactionHistoryPageReqVO pageReqVO) {
        return transactionHistoryMapper.selectPage(pageReqVO);
    }

    @Override
    public List<TransactionHistoryDO> getTransactionHistoryList(TransactionHistoryExportReqVO exportReqVO) {
        return transactionHistoryMapper.selectList(exportReqVO);
    }

}
