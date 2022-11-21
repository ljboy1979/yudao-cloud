package cn.acsm.module.member.signin.service.config;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.member.signin.api.wechat.wechat.dto.WeChatReqDTO;
import cn.acsm.module.member.signin.controller.admin.config.vo.AuthConfigInfoCreateReqVO;
import cn.acsm.module.member.signin.controller.admin.config.vo.AuthConfigInfoExportReqVO;
import cn.acsm.module.member.signin.controller.admin.config.vo.AuthConfigInfoPageReqVO;
import cn.acsm.module.member.signin.controller.admin.config.vo.AuthConfigInfoUpdateReqVO;
import cn.acsm.module.member.signin.dal.dataobject.config.AuthConfigInfoDO;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 会员登录授权配置信息 Service 接口
 *
 * @author lihongyan
 */
public interface AuthConfigInfoService {

    /**
     * 创建会员登录授权配置信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createAuthConfigInfo(@Valid AuthConfigInfoCreateReqVO createReqVO);

    /**
     * 更新会员登录授权配置信息
     *
     * @param updateReqVO 更新信息
     */
    void updateAuthConfigInfo(@Valid AuthConfigInfoUpdateReqVO updateReqVO);

    /**
     * 删除会员登录授权配置信息
     *
     * @param id 编号
     */
    void deleteAuthConfigInfo(Long id);

    /**
     * 获得会员登录授权配置信息
     *
     * @param id 编号
     * @return 会员登录授权配置信息
     */
    AuthConfigInfoDO getAuthConfigInfo(Long id);

    /**
     * 获得会员登录授权配置信息列表
     *
     * @param ids 编号
     * @return 会员登录授权配置信息列表
     */
    List<AuthConfigInfoDO> getAuthConfigInfoList(Collection<Long> ids);

    /**
     * 获得会员登录授权配置信息分页
     *
     * @param pageReqVO 分页查询
     * @return 会员登录授权配置信息分页
     */
    PageResult<AuthConfigInfoDO> getAuthConfigInfoPage(AuthConfigInfoPageReqVO pageReqVO);

    /**
     * 获得会员登录授权配置信息列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 会员登录授权配置信息列表
     */
    List<AuthConfigInfoDO> getAuthConfigInfoList(AuthConfigInfoExportReqVO exportReqVO);

    /**
     * @Description:获取用户openId和手机号
     * @param reqDTO
     * @Date: 2022/11/17
     * @author: lihongyan
     * @throws
     * @return:cn.iocoder.yudao.framework.common.pojo.CommonResult
     */
    CommonResult getOpenIdAndPhone(WeChatReqDTO reqDTO);

}
