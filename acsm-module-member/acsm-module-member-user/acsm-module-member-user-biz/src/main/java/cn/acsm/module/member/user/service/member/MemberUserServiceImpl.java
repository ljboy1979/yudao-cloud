package cn.acsm.module.member.user.service.member;

import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserCreateReqVO;
import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserExportReqVO;
import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserPageReqVO;
import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserUpdateReqVO;
import cn.acsm.module.member.user.convert.member.MemberUserConvert;
import cn.acsm.module.member.user.dal.dataobject.member.MemberUserDO;
import cn.acsm.module.member.user.dal.mysql.member.MemberUserMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.member.user.enums.ErrorCodeConstants.*;

/**
 * 会员 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class MemberUserServiceImpl implements MemberUserService {

    @Resource
    private MemberUserMapper userMapper;

    @Override
    public Long createUser(MemberUserCreateReqVO createReqVO) {
        // 插入
        MemberUserDO user = MemberUserConvert.INSTANCE.convert(createReqVO);
        userMapper.insert(user);
        // 返回
        return user.getId();
    }

    @Override
    public void updateUser(MemberUserUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateUserExists(updateReqVO.getId());
        // 更新
        MemberUserDO updateObj = MemberUserConvert.INSTANCE.convert(updateReqVO);
        userMapper.updateById(updateObj);
    }

    @Override
    public void deleteUser(Long id) {
        // 校验存在
        this.validateUserExists(id);
        // 删除
        userMapper.deleteById(id);
    }

    private void validateUserExists(Long id) {
        if (userMapper.selectById(id) == null) {
            throw exception(USER_NOT_EXISTS);
        }
    }

    @Override
    public MemberUserDO getUser(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<MemberUserDO> getUserList(Collection<Long> ids) {
        return userMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<MemberUserDO> getUserPage(MemberUserPageReqVO pageReqVO) {
        return userMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MemberUserDO> getUserList(MemberUserExportReqVO exportReqVO) {
        return userMapper.selectList(exportReqVO);
    }

}
