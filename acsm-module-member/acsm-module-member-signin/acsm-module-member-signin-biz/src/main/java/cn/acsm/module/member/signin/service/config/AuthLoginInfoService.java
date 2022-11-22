package cn.acsm.module.member.signin.service.config;

import cn.acsm.module.member.signin.controller.admin.config.vo.AuthLoginInfoCreateReqVO;
import cn.acsm.module.member.signin.controller.admin.config.vo.AuthLoginInfoExportReqVO;
import cn.acsm.module.member.signin.controller.admin.config.vo.AuthLoginInfoPageReqVO;
import cn.acsm.module.member.signin.controller.admin.config.vo.AuthLoginInfoUpdateReqVO;
import cn.acsm.module.member.signin.dal.dataobject.config.AuthLoginInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 会员授权登录信息记录 Service 接口
 *
 * @author lihongyan
 */
public interface AuthLoginInfoService {

    /**
     * 创建会员授权登录信息记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createAuthLoginInfo(@Valid AuthLoginInfoCreateReqVO createReqVO);

    /**
     * 更新会员授权登录信息记录
     *
     * @param updateReqVO 更新信息
     */
    void updateAuthLoginInfo(@Valid AuthLoginInfoUpdateReqVO updateReqVO);

    /**
     * 删除会员授权登录信息记录
     *
     * @param id 编号
     */
    void deleteAuthLoginInfo(Long id);

    /**
     * 获得会员授权登录信息记录
     *
     * @param id 编号
     * @return 会员授权登录信息记录
     */
    AuthLoginInfoDO getAuthLoginInfo(Long id);

    /**
     * 获得会员授权登录信息记录列表
     *
     * @param ids 编号
     * @return 会员授权登录信息记录列表
     */
    List<AuthLoginInfoDO> getAuthLoginInfoList(Collection<Long> ids);

    /**
     * 获得会员授权登录信息记录分页
     *
     * @param pageReqVO 分页查询
     * @return 会员授权登录信息记录分页
     */
    PageResult<AuthLoginInfoDO> getAuthLoginInfoPage(AuthLoginInfoPageReqVO pageReqVO);

    /**
     * 获得会员授权登录信息记录列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 会员授权登录信息记录列表
     */
    List<AuthLoginInfoDO> getAuthLoginInfoList(AuthLoginInfoExportReqVO exportReqVO);

}
