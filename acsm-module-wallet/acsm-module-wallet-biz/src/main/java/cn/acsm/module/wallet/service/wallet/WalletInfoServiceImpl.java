package cn.acsm.module.wallet.service.wallet;

import cn.acsm.module.wallet.controller.admin.wallet.vo.WalletInfoCreateReqVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.WalletInfoExportReqVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.WalletInfoPageReqVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.WalletInfoUpdateReqVO;
import cn.acsm.module.wallet.convert.wallet.WalletInfoConvert;
import cn.acsm.module.wallet.dal.dataobject.wallet.WalletInfoDO;
import cn.acsm.module.wallet.dal.mysql.wallet.WalletInfoMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.wallet.enums.ErrorCodeConstants.*;

/**
 * 钱包信息 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class WalletInfoServiceImpl implements WalletInfoService {

    @Resource
    private WalletInfoMapper infoMapper;

    @Override
    public Long createInfo(WalletInfoCreateReqVO createReqVO) {
        // 插入
        WalletInfoDO info = WalletInfoConvert.INSTANCE.convert(createReqVO);
        infoMapper.insert(info);
        // 返回
        return info.getId();
    }

    @Override
    public void updateInfo(WalletInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateInfoExists(updateReqVO.getId());
        // 更新
        WalletInfoDO updateObj = WalletInfoConvert.INSTANCE.convert(updateReqVO);
        infoMapper.updateById(updateObj);
    }

    @Override
    public void deleteInfo(Long id) {
        // 校验存在
        this.validateInfoExists(id);
        // 删除
        infoMapper.deleteById(id);
    }

    private void validateInfoExists(Long id) {
        if (infoMapper.selectById(id) == null) {
            throw exception(INFO_NOT_EXISTS);
        }
    }

    @Override
    public WalletInfoDO getInfo(Long id) {
        return infoMapper.selectById(id);
    }

    @Override
    public List<WalletInfoDO> getInfoList(Collection<Long> ids) {
        return infoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<WalletInfoDO> getInfoPage(WalletInfoPageReqVO pageReqVO) {
        return infoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<WalletInfoDO> getInfoList(WalletInfoExportReqVO exportReqVO) {
        return infoMapper.selectList(exportReqVO);
    }

}
