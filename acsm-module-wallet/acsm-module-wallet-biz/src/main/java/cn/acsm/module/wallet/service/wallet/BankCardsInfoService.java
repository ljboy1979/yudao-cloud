package cn.acsm.module.wallet.service.wallet;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.wallet.controller.admin.wallet.vo.BankCardsInfoCreateReqVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.BankCardsInfoExportReqVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.BankCardsInfoPageReqVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.BankCardsInfoUpdateReqVO;
import cn.acsm.module.wallet.dal.dataobject.wallet.BankCardsInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 关联银行卡子 Service 接口
 *
 * @author lihongyan
 */
public interface BankCardsInfoService {

    /**
     * 创建关联银行卡子
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createBankCardsInfo(@Valid BankCardsInfoCreateReqVO createReqVO);

    /**
     * 更新关联银行卡子
     *
     * @param updateReqVO 更新信息
     */
    void updateBankCardsInfo(@Valid BankCardsInfoUpdateReqVO updateReqVO);

    /**
     * 删除关联银行卡子
     *
     * @param id 编号
     */
    void deleteBankCardsInfo(Long id);

    /**
     * 获得关联银行卡子
     *
     * @param id 编号
     * @return 关联银行卡子
     */
    BankCardsInfoDO getBankCardsInfo(Long id);

    /**
     * 获得关联银行卡子列表
     *
     * @param ids 编号
     * @return 关联银行卡子列表
     */
    List<BankCardsInfoDO> getBankCardsInfoList(Collection<Long> ids);

    /**
     * 获得关联银行卡子分页
     *
     * @param pageReqVO 分页查询
     * @return 关联银行卡子分页
     */
    PageResult<BankCardsInfoDO> getBankCardsInfoPage(BankCardsInfoPageReqVO pageReqVO);

    /**
     * 获得关联银行卡子列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 关联银行卡子列表
     */
    List<BankCardsInfoDO> getBankCardsInfoList(BankCardsInfoExportReqVO exportReqVO);

}
