package cn.acsm.module.member.wallet.service.walletinfo;

import cn.acsm.module.member.wallet.controller.admin.walletinfo.vo.UserWalletInfoCreateReqVO;
import cn.acsm.module.member.wallet.controller.admin.walletinfo.vo.UserWalletInfoExportReqVO;
import cn.acsm.module.member.wallet.controller.admin.walletinfo.vo.UserWalletInfoPageReqVO;
import cn.acsm.module.member.wallet.controller.admin.walletinfo.vo.UserWalletInfoUpdateReqVO;
import cn.acsm.module.member.wallet.convert.walletinfo.UserWalletInfoConvert;
import cn.acsm.module.member.wallet.dal.dataobject.walletinfo.UserWalletInfoDO;
import cn.acsm.module.member.wallet.dal.mysql.walletinfo.UserWalletInfoMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.member.wallet.enums.ErrorCodeConstants.*;

/**
 * 用户钱包信息 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class UserWalletInfoServiceImpl implements UserWalletInfoService {

    @Resource
    private UserWalletInfoMapper userWalletInfoMapper;

    @Override
    public Long createUserWalletInfo(UserWalletInfoCreateReqVO createReqVO) {
        // 插入
        UserWalletInfoDO userWalletInfo = UserWalletInfoConvert.INSTANCE.convert(createReqVO);
        userWalletInfoMapper.insert(userWalletInfo);
        // 返回
        return userWalletInfo.getId();
    }

    @Override
    public void updateUserWalletInfo(UserWalletInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateUserWalletInfoExists(updateReqVO.getId());
        // 更新
        UserWalletInfoDO updateObj = UserWalletInfoConvert.INSTANCE.convert(updateReqVO);
        userWalletInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteUserWalletInfo(Long id) {
        // 校验存在
        this.validateUserWalletInfoExists(id);
        // 删除
        userWalletInfoMapper.deleteById(id);
    }

    private void validateUserWalletInfoExists(Long id) {
        if (userWalletInfoMapper.selectById(id) == null) {
            throw exception(USER_WALLET_INFO_NOT_EXISTS);
        }
    }

    @Override
    public UserWalletInfoDO getUserWalletInfo(Long id) {
        return userWalletInfoMapper.selectById(id);
    }

    @Override
    public List<UserWalletInfoDO> getUserWalletInfoList(Collection<Long> ids) {
        return userWalletInfoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<UserWalletInfoDO> getUserWalletInfoPage(UserWalletInfoPageReqVO pageReqVO) {
        return userWalletInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<UserWalletInfoDO> getUserWalletInfoList(UserWalletInfoExportReqVO exportReqVO) {
        return userWalletInfoMapper.selectList(exportReqVO);
    }

}
