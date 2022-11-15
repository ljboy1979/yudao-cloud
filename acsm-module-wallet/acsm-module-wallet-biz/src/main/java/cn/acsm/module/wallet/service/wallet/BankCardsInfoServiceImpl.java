package cn.acsm.module.wallet.service.wallet;

import cn.acsm.module.wallet.controller.admin.wallet.vo.BankCardsInfoCreateReqVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.BankCardsInfoExportReqVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.BankCardsInfoPageReqVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.BankCardsInfoUpdateReqVO;
import cn.acsm.module.wallet.convert.wallet.BankCardsInfoConvert;
import cn.acsm.module.wallet.dal.dataobject.wallet.BankCardsInfoDO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.wallet.dal.mysql.wallet.BankCardsInfoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.wallet.enums.ErrorCodeConstants.*;

/**
 * 关联银行卡子 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class BankCardsInfoServiceImpl implements BankCardsInfoService {

    @Resource
    private BankCardsInfoMapper bankCardsInfoMapper;

    @Override
    public Long createBankCardsInfo(BankCardsInfoCreateReqVO createReqVO) {
        // 插入
        BankCardsInfoDO bankCardsInfo = BankCardsInfoConvert.INSTANCE.convert(createReqVO);
        bankCardsInfoMapper.insert(bankCardsInfo);
        // 返回
        return bankCardsInfo.getId();
    }

    @Override
    public void updateBankCardsInfo(BankCardsInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateBankCardsInfoExists(updateReqVO.getId());
        // 更新
        BankCardsInfoDO updateObj = BankCardsInfoConvert.INSTANCE.convert(updateReqVO);
        bankCardsInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteBankCardsInfo(Long id) {
        // 校验存在
        this.validateBankCardsInfoExists(id);
        // 删除
        bankCardsInfoMapper.deleteById(id);
    }

    private void validateBankCardsInfoExists(Long id) {
        if (bankCardsInfoMapper.selectById(id) == null) {
            throw exception(BANK_CARDS_INFO_NOT_EXISTS);
        }
    }

    @Override
    public BankCardsInfoDO getBankCardsInfo(Long id) {
        return bankCardsInfoMapper.selectById(id);
    }

    @Override
    public List<BankCardsInfoDO> getBankCardsInfoList(Collection<Long> ids) {
        return bankCardsInfoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<BankCardsInfoDO> getBankCardsInfoPage(BankCardsInfoPageReqVO pageReqVO) {
        return bankCardsInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<BankCardsInfoDO> getBankCardsInfoList(BankCardsInfoExportReqVO exportReqVO) {
        return bankCardsInfoMapper.selectList(exportReqVO);
    }

}
