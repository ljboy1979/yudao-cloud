package cn.acsm.module.wallet.service.wallet;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.wallet.controller.admin.wallet.vo.WalletInfoCreateReqVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.WalletInfoExportReqVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.WalletInfoPageReqVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.WalletInfoUpdateReqVO;
import cn.acsm.module.wallet.dal.dataobject.wallet.WalletInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 钱包信息 Service 接口
 *
 * @author lihongyan
 */
public interface WalletInfoService {

    /**
     * 创建钱包信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createInfo(@Valid WalletInfoCreateReqVO createReqVO);

    /**
     * 更新钱包信息
     *
     * @param updateReqVO 更新信息
     */
    void updateInfo(@Valid WalletInfoUpdateReqVO updateReqVO);

    /**
     * 删除钱包信息
     *
     * @param id 编号
     */
    void deleteInfo(Long id);

    /**
     * 获得钱包信息
     *
     * @param id 编号
     * @return 钱包信息
     */
    WalletInfoDO getInfo(Long id);

    /**
     * 获得钱包信息列表
     *
     * @param ids 编号
     * @return 钱包信息列表
     */
    List<WalletInfoDO> getInfoList(Collection<Long> ids);

    /**
     * 获得钱包信息分页
     *
     * @param pageReqVO 分页查询
     * @return 钱包信息分页
     */
    PageResult<WalletInfoDO> getInfoPage(WalletInfoPageReqVO pageReqVO);

    /**
     * 获得钱包信息列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 钱包信息列表
     */
    List<WalletInfoDO> getInfoList(WalletInfoExportReqVO exportReqVO);

}
