package cn.acsm.module.wallet.service.wallet;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.wallet.controller.admin.wallet.vo.TransactionHistoryCreateReqVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.TransactionHistoryExportReqVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.TransactionHistoryPageReqVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.TransactionHistoryUpdateReqVO;
import cn.acsm.module.wallet.dal.dataobject.wallet.TransactionHistoryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 钱包交易记录子 Service 接口
 *
 * @author lihongyan
 */
public interface TransactionHistoryService {

    /**
     * 创建钱包交易记录子
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createTransactionHistory(@Valid TransactionHistoryCreateReqVO createReqVO);

    /**
     * 更新钱包交易记录子
     *
     * @param updateReqVO 更新信息
     */
    void updateTransactionHistory(@Valid TransactionHistoryUpdateReqVO updateReqVO);

    /**
     * 删除钱包交易记录子
     *
     * @param id 编号
     */
    void deleteTransactionHistory(Long id);

    /**
     * 获得钱包交易记录子
     *
     * @param id 编号
     * @return 钱包交易记录子
     */
    TransactionHistoryDO getTransactionHistory(Long id);

    /**
     * 获得钱包交易记录子列表
     *
     * @param ids 编号
     * @return 钱包交易记录子列表
     */
    List<TransactionHistoryDO> getTransactionHistoryList(Collection<Long> ids);

    /**
     * 获得钱包交易记录子分页
     *
     * @param pageReqVO 分页查询
     * @return 钱包交易记录子分页
     */
    PageResult<TransactionHistoryDO> getTransactionHistoryPage(TransactionHistoryPageReqVO pageReqVO);

    /**
     * 获得钱包交易记录子列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 钱包交易记录子列表
     */
    List<TransactionHistoryDO> getTransactionHistoryList(TransactionHistoryExportReqVO exportReqVO);

}
