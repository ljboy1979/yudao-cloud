package cn.acsm.module.wallet.service.wechat;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.wallet.controller.admin.wechat.vo.WechatConfigInfoCreateReqVO;
import cn.acsm.module.wallet.controller.admin.wechat.vo.WechatConfigInfoExportReqVO;
import cn.acsm.module.wallet.controller.admin.wechat.vo.WechatConfigInfoPageReqVO;
import cn.acsm.module.wallet.controller.admin.wechat.vo.WechatConfigInfoUpdateReqVO;
import cn.acsm.module.wallet.dal.dataobject.wechat.WechatConfigInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 微信支付配置信息 Service 接口
 *
 * @author lihongyan
 */
public interface WechatConfigInfoService {

    /**
     * 创建微信支付配置信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createWechatConfigInfo(@Valid WechatConfigInfoCreateReqVO createReqVO);

    /**
     * 更新微信支付配置信息
     *
     * @param updateReqVO 更新信息
     */
    void updateWechatConfigInfo(@Valid WechatConfigInfoUpdateReqVO updateReqVO);

    /**
     * 删除微信支付配置信息
     *
     * @param id 编号
     */
    void deleteWechatConfigInfo(Long id);

    /**
     * 获得微信支付配置信息
     *
     * @param id 编号
     * @return 微信支付配置信息
     */
    WechatConfigInfoDO getWechatConfigInfo(Long id);

    /**
     * 获得微信支付配置信息列表
     *
     * @param ids 编号
     * @return 微信支付配置信息列表
     */
    List<WechatConfigInfoDO> getWechatConfigInfoList(Collection<Long> ids);

    /**
     * 获得微信支付配置信息分页
     *
     * @param pageReqVO 分页查询
     * @return 微信支付配置信息分页
     */
    PageResult<WechatConfigInfoDO> getWechatConfigInfoPage(WechatConfigInfoPageReqVO pageReqVO);

    /**
     * 获得微信支付配置信息列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 微信支付配置信息列表
     */
    List<WechatConfigInfoDO> getWechatConfigInfoList(WechatConfigInfoExportReqVO exportReqVO);

}
