package cn.acsm.module.user.user.service.wechat;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.user.user.controller.admin.wechat.vo.WeixinDeployInfoCreateReqVO;
import cn.acsm.module.user.user.controller.admin.wechat.vo.WeixinDeployInfoExportReqVO;
import cn.acsm.module.user.user.controller.admin.wechat.vo.WeixinDeployInfoPageReqVO;
import cn.acsm.module.user.user.controller.admin.wechat.vo.WeixinDeployInfoUpdateReqVO;
import cn.acsm.module.user.user.dal.dataobject.wechat.WeixinDeployInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 微信公众号配置信息 Service 接口
 *
 * @author lihongyan
 */
public interface WeixinDeployInfoService {

    /**
     * 创建微信公众号配置信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createWeixinDeployInfo(@Valid WeixinDeployInfoCreateReqVO createReqVO);

    /**
     * 更新微信公众号配置信息
     *
     * @param updateReqVO 更新信息
     */
    void updateWeixinDeployInfo(@Valid WeixinDeployInfoUpdateReqVO updateReqVO);

    /**
     * 删除微信公众号配置信息
     *
     * @param id 编号
     */
    void deleteWeixinDeployInfo(Long id);

    /**
     * 获得微信公众号配置信息
     *
     * @param id 编号
     * @return 微信公众号配置信息
     */
    WeixinDeployInfoDO getWeixinDeployInfo(Long id);

    /**
     * 获得微信公众号配置信息列表
     *
     * @param ids 编号
     * @return 微信公众号配置信息列表
     */
    List<WeixinDeployInfoDO> getWeixinDeployInfoList(Collection<Long> ids);

    /**
     * 获得微信公众号配置信息分页
     *
     * @param pageReqVO 分页查询
     * @return 微信公众号配置信息分页
     */
    PageResult<WeixinDeployInfoDO> getWeixinDeployInfoPage(WeixinDeployInfoPageReqVO pageReqVO);

    /**
     * 获得微信公众号配置信息列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 微信公众号配置信息列表
     */
    List<WeixinDeployInfoDO> getWeixinDeployInfoList(WeixinDeployInfoExportReqVO exportReqVO);

    /**
     * @Description:通过租户编号查询微信配置信息
     * @param weixinDeployInfoDO
     * @Date: 2022/11/8
     * @author: lihongyan
     * @throws
     * @return:java.util.List<cn.acsm.module.user.user.dal.dataobject.wechat.WeixinDeployInfoDO>
     */
    List<WeixinDeployInfoDO> selectListByTenantId(WeixinDeployInfoDO weixinDeployInfoDO);

}
