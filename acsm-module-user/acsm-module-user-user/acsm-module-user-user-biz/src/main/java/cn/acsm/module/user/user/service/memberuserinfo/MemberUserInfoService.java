package cn.acsm.module.user.user.service.memberuserinfo;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.user.user.controller.admin.memberuserinfo.vo.MemberUserInfoCreateReqVO;
import cn.acsm.module.user.user.controller.admin.memberuserinfo.vo.MemberUserInfoExportReqVO;
import cn.acsm.module.user.user.controller.admin.memberuserinfo.vo.MemberUserInfoPageReqVO;
import cn.acsm.module.user.user.controller.admin.memberuserinfo.vo.MemberUserInfoUpdateReqVO;
import cn.acsm.module.user.user.controller.app.memberuserinfo.vo.AppMemberUserInfoRegisteredVO;
import cn.acsm.module.user.user.dal.dataobject.memberuserinfo.MemberUserInfoDO;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import com.alibaba.fastjson.JSONObject;

/**
 * 用户基本信息 Service 接口
 *
 * @author lihongyan
 */
public interface MemberUserInfoService {

    /**
     * 创建用户基本信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createUserInfo(@Valid MemberUserInfoCreateReqVO createReqVO);

    /**
     * 更新用户基本信息
     *
     * @param updateReqVO 更新信息
     */
    void updateUserInfo(@Valid MemberUserInfoUpdateReqVO updateReqVO);

    /**
     * 删除用户基本信息
     *
     * @param id 编号
     */
    void deleteUserInfo(Long id);

    /**
     * 获得用户基本信息
     *
     * @param id 编号
     * @return 用户基本信息
     */
    MemberUserInfoDO getUserInfo(Long id);

    /**
     * 获得用户基本信息列表
     *
     * @param ids 编号
     * @return 用户基本信息列表
     */
    List<MemberUserInfoDO> getUserInfoList(Collection<Long> ids);

    /**
     * 获得用户基本信息分页
     *
     * @param pageReqVO 分页查询
     * @return 用户基本信息分页
     */
    PageResult<MemberUserInfoDO> getUserInfoPage(MemberUserInfoPageReqVO pageReqVO);

    /**
     * 获得用户基本信息列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 用户基本信息列表
     */
    List<MemberUserInfoDO> getUserInfoList(MemberUserInfoExportReqVO exportReqVO);

    /**
     * @Description:获取用户openId微信小程序
     * @param registeredVO
     * @Date: 2022/11/8
     * @author: lihongyan
     * @throws
     * @return:cn.iocoder.yudao.framework.common.pojo.CommonResult
     */
    CommonResult getOpenIdAndlogin(AppMemberUserInfoRegisteredVO registeredVO);

}
