package cn.acsm.module.member.user.service.user;

import cn.acsm.module.member.user.controller.admin.user.vo.MemberUserCreateReqVO;
import cn.acsm.module.member.user.controller.admin.user.vo.MemberUserExportReqVO;
import cn.acsm.module.member.user.controller.admin.user.vo.MemberUserPageReqVO;
import cn.acsm.module.member.user.controller.admin.user.vo.MemberUserUpdateReqVO;
import cn.acsm.module.member.user.convert.user.MemberUserConvert;
import cn.acsm.module.member.user.dal.dataobject.user.MemberUserDO;
import cn.acsm.module.member.user.dal.mysql.user.MemberUserMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.member.user.enums.ErrorCodeConstants.*;

/**
 * 用户 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class MemberUserServiceImpl implements MemberUserService {

    @Resource
    private MemberUserMapper memberUserMapper;

    @Override
    public Long createMemberUser(MemberUserCreateReqVO createReqVO) {
        // 插入
        MemberUserDO memberUser = MemberUserConvert.INSTANCE.convert(createReqVO);
        memberUserMapper.insert(memberUser);
        // 返回
        return memberUser.getId();
    }

    @Override
    public void updateMemberUser(MemberUserUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateMemberUserExists(updateReqVO.getId());
        // 更新
        MemberUserDO updateObj = MemberUserConvert.INSTANCE.convert(updateReqVO);
        memberUserMapper.updateById(updateObj);
    }

    @Override
    public void deleteMemberUser(Long id) {
        // 校验存在
        this.validateMemberUserExists(id);
        // 删除
        memberUserMapper.deleteById(id);
    }

    private void validateMemberUserExists(Long id) {
        if (memberUserMapper.selectById(id) == null) {
            throw exception(MEMBER_USER_NOT_EXISTS);
        }
    }

    @Override
    public MemberUserDO getMemberUser(Long id) {
        return memberUserMapper.selectById(id);
    }

    @Override
    public List<MemberUserDO> getMemberUserList(Collection<Long> ids) {
        return memberUserMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<MemberUserDO> getMemberUserPage(MemberUserPageReqVO pageReqVO) {
        return memberUserMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MemberUserDO> getMemberUserList(MemberUserExportReqVO exportReqVO) {
        return memberUserMapper.selectList(exportReqVO);
    }

    @Override
    public MemberUserDO getMemberUserByPhoneAndTenantId(MemberUserExportReqVO reqVO) {
        return memberUserMapper.getMemberUserByPhoneAndTenantId(reqVO);
    }
}
