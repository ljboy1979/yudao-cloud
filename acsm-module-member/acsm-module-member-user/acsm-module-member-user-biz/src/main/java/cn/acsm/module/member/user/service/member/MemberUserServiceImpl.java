package cn.acsm.module.member.user.service.member;

import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserCreateReqVO;
import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserExportReqVO;
import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserPageReqVO;
import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserUpdateReqVO;
import cn.acsm.module.member.user.convert.member.MemberUserConvert;
import cn.acsm.module.member.user.dal.dataobject.member.MemberUserDO;
import cn.acsm.module.member.user.dal.mysql.member.MemberUserMapper;
import cn.hutool.core.util.IdUtil;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
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

    @Resource
    private PasswordEncoder passwordEncoder;

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

    @Override
    public MemberUserDO createUserIfAbsent(String mobile, String registerIp) {
        // 用户已经存在
        MemberUserDO user = userMapper.selectByMobile(mobile);
        if (user != null) {
            return user;
        }
        // 用户不存在，则进行创建
        return this.createUser(mobile, registerIp);
    }

    private MemberUserDO createUser(String mobile, String registerIp) {
        // 生成密码
        String password = IdUtil.fastSimpleUUID();
        // 插入用户
        MemberUserDO user = new MemberUserDO();
        user.setMobile(mobile);
        user.setStatus(CommonStatusEnum.ENABLE.getStatus()); // 默认开启
        user.setPassword(encodePassword(password)); // 加密密码
        user.setRegisterIp(registerIp);
        userMapper.insert(user);
        return user;
    }

    /**
     * 对密码进行加密
     *
     * @param password 密码
     * @return 加密后的密码
     */
    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }


    @Override
    public void updateUserLogin(Long id, String loginIp) {
        userMapper.updateById(new MemberUserDO().setId(id)
                .setLoginIp(loginIp).setLoginDate(LocalDateTime.now()));
    }
}
