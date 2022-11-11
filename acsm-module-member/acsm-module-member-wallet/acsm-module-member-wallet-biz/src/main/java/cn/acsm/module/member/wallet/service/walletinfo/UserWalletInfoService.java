package cn.acsm.module.member.wallet.service.walletinfo;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.member.wallet.controller.admin.walletinfo.vo.UserWalletInfoCreateReqVO;
import cn.acsm.module.member.wallet.controller.admin.walletinfo.vo.UserWalletInfoExportReqVO;
import cn.acsm.module.member.wallet.controller.admin.walletinfo.vo.UserWalletInfoPageReqVO;
import cn.acsm.module.member.wallet.controller.admin.walletinfo.vo.UserWalletInfoUpdateReqVO;
import cn.acsm.module.member.wallet.dal.dataobject.walletinfo.UserWalletInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 用户钱包信息 Service 接口
 *
 * @author lihongyan
 */
public interface UserWalletInfoService {

    /**
     * 创建用户钱包信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createUserWalletInfo(@Valid UserWalletInfoCreateReqVO createReqVO);

    /**
     * 更新用户钱包信息
     *
     * @param updateReqVO 更新信息
     */
    void updateUserWalletInfo(@Valid UserWalletInfoUpdateReqVO updateReqVO);

    /**
     * 删除用户钱包信息
     *
     * @param id 编号
     */
    void deleteUserWalletInfo(Long id);

    /**
     * 获得用户钱包信息
     *
     * @param id 编号
     * @return 用户钱包信息
     */
    UserWalletInfoDO getUserWalletInfo(Long id);

    /**
     * 获得用户钱包信息列表
     *
     * @param ids 编号
     * @return 用户钱包信息列表
     */
    List<UserWalletInfoDO> getUserWalletInfoList(Collection<Long> ids);

    /**
     * 获得用户钱包信息分页
     *
     * @param pageReqVO 分页查询
     * @return 用户钱包信息分页
     */
    PageResult<UserWalletInfoDO> getUserWalletInfoPage(UserWalletInfoPageReqVO pageReqVO);

    /**
     * 获得用户钱包信息列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 用户钱包信息列表
     */
    List<UserWalletInfoDO> getUserWalletInfoList(UserWalletInfoExportReqVO exportReqVO);

}
