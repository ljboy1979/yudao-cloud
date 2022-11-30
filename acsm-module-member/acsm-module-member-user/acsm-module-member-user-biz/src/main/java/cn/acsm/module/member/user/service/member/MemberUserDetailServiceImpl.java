package cn.acsm.module.member.user.service.member;

import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserDetailCreateReqVO;
import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserDetailExportReqVO;
import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserDetailPageReqVO;
import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserDetailUpdateReqVO;
import cn.acsm.module.member.user.dal.dataobject.member.MemberUserDetailDO;
import cn.acsm.module.member.user.dal.mysql.member.MemberUserDetailMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.member.user.convert.member.MemberUserDetailConvert;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.member.user.enums.ErrorCodeConstants.*;

/**
 * 会员信息 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class MemberUserDetailServiceImpl implements MemberUserDetailService {

    @Resource
    private MemberUserDetailMapper userDetailMapper;

    @Override
    public Long createUserDetail(MemberUserDetailCreateReqVO createReqVO) {
        // 插入
        MemberUserDetailDO userDetail = MemberUserDetailConvert.INSTANCE.convert(createReqVO);
        userDetailMapper.insert(userDetail);
        // 返回
        return userDetail.getId();
    }

    @Override
    public void updateUserDetail(MemberUserDetailUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateUserDetailExists(updateReqVO.getId());
        // 更新
        MemberUserDetailDO updateObj = MemberUserDetailConvert.INSTANCE.convert(updateReqVO);
        userDetailMapper.updateById(updateObj);
    }

    @Override
    public void deleteUserDetail(Long id) {
        // 校验存在
        this.validateUserDetailExists(id);
        // 删除
        userDetailMapper.deleteById(id);
    }

    private void validateUserDetailExists(Long id) {
        if (userDetailMapper.selectById(id) == null) {
            throw exception(USER_DETAIL_NOT_EXISTS);
        }
    }

    @Override
    public MemberUserDetailDO getUserDetail(Long id) {
        return userDetailMapper.selectById(id);
    }

    @Override
    public List<MemberUserDetailDO> getUserDetailList(Collection<Long> ids) {
        return userDetailMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<MemberUserDetailDO> getUserDetailPage(MemberUserDetailPageReqVO pageReqVO) {
        return userDetailMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MemberUserDetailDO> getUserDetailList(MemberUserDetailExportReqVO exportReqVO) {
        return userDetailMapper.selectList(exportReqVO);
    }

    @Override
    public MemberUserDetailDO selectByMemberId(Long memberId) {
        return userDetailMapper.selectByMemberId(memberId);
    }

}
