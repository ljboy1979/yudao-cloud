package cn.acsm.module.member.user.service.member;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserDetailCreateReqVO;
import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserDetailExportReqVO;
import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserDetailPageReqVO;
import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserDetailUpdateReqVO;
import cn.acsm.module.member.user.dal.dataobject.member.MemberUserDetailDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 会员信息 Service 接口
 *
 * @author lihongyan
 */
public interface MemberUserDetailService {

    /**
     * 创建会员信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createUserDetail(@Valid MemberUserDetailCreateReqVO createReqVO);

    /**
     * 更新会员信息
     *
     * @param updateReqVO 更新信息
     */
    void updateUserDetail(@Valid MemberUserDetailUpdateReqVO updateReqVO);

    /**
     * 删除会员信息
     *
     * @param id 编号
     */
    void deleteUserDetail(Long id);

    /**
     * 获得会员信息
     *
     * @param id 编号
     * @return 会员信息
     */
    MemberUserDetailDO getUserDetail(Long id);

    /**
     * 获得会员信息列表
     *
     * @param ids 编号
     * @return 会员信息列表
     */
    List<MemberUserDetailDO> getUserDetailList(Collection<Long> ids);

    /**
     * 获得会员信息分页
     *
     * @param pageReqVO 分页查询
     * @return 会员信息分页
     */
    PageResult<MemberUserDetailDO> getUserDetailPage(MemberUserDetailPageReqVO pageReqVO);

    /**
     * 获得会员信息列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 会员信息列表
     */
    List<MemberUserDetailDO> getUserDetailList(MemberUserDetailExportReqVO exportReqVO);

    /**
     * @Description:根据会员ID获取数据
     * @param memberId
     * @Date: 2022/11/29
     * @author: lihongyan
     * @throws
     * @return:cn.acsm.module.member.user.dal.dataobject.member.MemberUserDetailDO
     */
    MemberUserDetailDO selectByMemberId(Long memberId);

}
