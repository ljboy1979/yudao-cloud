package cn.acsm.module.user.user.service.user;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.user.user.controller.admin.user.vo.MemberUserCreateReqVO;
import cn.acsm.module.user.user.controller.admin.user.vo.MemberUserExportReqVO;
import cn.acsm.module.user.user.controller.admin.user.vo.MemberUserPageReqVO;
import cn.acsm.module.user.user.dal.dataobject.user.MemberUserDO;
import cn.acsm.module.user.user.controller.admin.user.vo.MemberUserUpdateReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 用户 Service 接口
 *
 * @author lihongyan
 */
public interface MemberUserService {

    /**
     * 创建用户
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createMemberUser(@Valid MemberUserCreateReqVO createReqVO);

    /**
     * 更新用户
     *
     * @param updateReqVO 更新信息
     */
    void updateMemberUser(@Valid MemberUserUpdateReqVO updateReqVO);

    /**
     * 删除用户
     *
     * @param id 编号
     */
    void deleteMemberUser(Long id);

    /**
     * 获得用户
     *
     * @param id 编号
     * @return 用户
     */
    MemberUserDO getMemberUser(Long id);

    /**
     * 获得用户列表
     *
     * @param ids 编号
     * @return 用户列表
     */
    List<MemberUserDO> getMemberUserList(Collection<Long> ids);

    /**
     * 获得用户分页
     *
     * @param pageReqVO 分页查询
     * @return 用户分页
     */
    PageResult<MemberUserDO> getMemberUserPage(MemberUserPageReqVO pageReqVO);

    /**
     * 获得用户列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 用户列表
     */
    List<MemberUserDO> getMemberUserList(MemberUserExportReqVO exportReqVO);


    /**
     * @Description:根据手机和租户编号查询用户
     * @param exportReqVO
     * @Date: 2022/11/9
     * @author: lihongyan
     * @throws
     * @return:cn.acsm.module.user.user.dal.dataobject.user.MemberUserDO
     */
    MemberUserDO getMemberUserByPhoneAndTenantId(MemberUserExportReqVO exportReqVO);
}
