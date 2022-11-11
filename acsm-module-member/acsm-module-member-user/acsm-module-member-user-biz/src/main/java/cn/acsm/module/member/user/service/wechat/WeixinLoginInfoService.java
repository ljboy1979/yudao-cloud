package cn.acsm.module.member.user.service.wechat;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.member.user.controller.admin.wechat.vo.WeixinLoginInfoCreateReqVO;
import cn.acsm.module.member.user.controller.admin.wechat.vo.WeixinLoginInfoExportReqVO;
import cn.acsm.module.member.user.controller.admin.wechat.vo.WeixinLoginInfoPageReqVO;
import cn.acsm.module.member.user.controller.admin.wechat.vo.WeixinLoginInfoUpdateReqVO;
import cn.acsm.module.member.user.dal.dataobject.wechat.WeixinLoginInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 微信登录信息记录 Service 接口
 *
 * @author lihongyan
 */
public interface WeixinLoginInfoService {

    /**
     * 创建微信登录信息记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createWeixinLoginInfo(@Valid WeixinLoginInfoCreateReqVO createReqVO);

    /**
     * 更新微信登录信息记录
     *
     * @param updateReqVO 更新信息
     */
    void updateWeixinLoginInfo(@Valid WeixinLoginInfoUpdateReqVO updateReqVO);

    /**
     * 删除微信登录信息记录
     *
     * @param id 编号
     */
    void deleteWeixinLoginInfo(Long id);

    /**
     * 获得微信登录信息记录
     *
     * @param id 编号
     * @return 微信登录信息记录
     */
    WeixinLoginInfoDO getWeixinLoginInfo(Long id);

    /**
     * 获得微信登录信息记录列表
     *
     * @param ids 编号
     * @return 微信登录信息记录列表
     */
    List<WeixinLoginInfoDO> getWeixinLoginInfoList(Collection<Long> ids);

    /**
     * 获得微信登录信息记录分页
     *
     * @param pageReqVO 分页查询
     * @return 微信登录信息记录分页
     */
    PageResult<WeixinLoginInfoDO> getWeixinLoginInfoPage(WeixinLoginInfoPageReqVO pageReqVO);

    /**
     * 获得微信登录信息记录列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 微信登录信息记录列表
     */
    List<WeixinLoginInfoDO> getWeixinLoginInfoList(WeixinLoginInfoExportReqVO exportReqVO);

}
