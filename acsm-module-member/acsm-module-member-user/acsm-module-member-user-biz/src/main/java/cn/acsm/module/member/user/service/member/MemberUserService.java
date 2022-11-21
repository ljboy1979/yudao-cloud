package cn.acsm.module.member.user.service.member;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserCreateReqVO;
import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserExportReqVO;
import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserPageReqVO;
import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserUpdateReqVO;
import cn.acsm.module.member.user.dal.dataobject.member.MemberUserDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.validation.Mobile;

/**
 * 会员 Service 接口
 *
 * @author lihongyan
 */
public interface MemberUserService {

    /**
     * 创建会员
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createUser(@Valid MemberUserCreateReqVO createReqVO);

    /**
     * 更新会员
     *
     * @param updateReqVO 更新信息
     */
    void updateUser(@Valid MemberUserUpdateReqVO updateReqVO);

    /**
     * 删除会员
     *
     * @param id 编号
     */
    void deleteUser(Long id);

    /**
     * 获得会员
     *
     * @param id 编号
     * @return 会员
     */
    MemberUserDO getUser(Long id);

    /**
     * 获得会员列表
     *
     * @param ids 编号
     * @return 会员列表
     */
    List<MemberUserDO> getUserList(Collection<Long> ids);

    /**
     * 获得会员分页
     *
     * @param pageReqVO 分页查询
     * @return 会员分页
     */
    PageResult<MemberUserDO> getUserPage(MemberUserPageReqVO pageReqVO);

    /**
     * 获得会员列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 会员列表
     */
    List<MemberUserDO> getUserList(MemberUserExportReqVO exportReqVO);

    /**
     * 基于手机号创建用户。
     * 如果用户已经存在，则直接进行返回
     * @param mobile 手机号
     * @param registerIp 注册 IP
     * @return 用户对象
     */
    MemberUserDO createUserIfAbsent(@Mobile String mobile, String registerIp);

    /**
     * 更新用户的最后登陆信息
     * @param id 用户编号
     * @param loginIp 登陆 IP
     */
    void updateUserLogin(Long id, String loginIp);

}
