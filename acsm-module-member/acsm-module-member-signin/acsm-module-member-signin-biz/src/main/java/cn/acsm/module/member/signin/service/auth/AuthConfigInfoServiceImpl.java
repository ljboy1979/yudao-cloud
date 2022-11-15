package cn.acsm.module.member.signin.service.auth;

import cn.acsm.module.member.signin.controller.admin.auth.vo.AuthConfigInfoCreateReqVO;
import cn.acsm.module.member.signin.controller.admin.auth.vo.AuthConfigInfoExportReqVO;
import cn.acsm.module.member.signin.controller.admin.auth.vo.AuthConfigInfoPageReqVO;
import cn.acsm.module.member.signin.controller.admin.auth.vo.AuthConfigInfoUpdateReqVO;
import cn.acsm.module.member.signin.convert.auth.AuthConfigInfoConvert;
import cn.acsm.module.member.signin.dal.dataobject.auth.AuthConfigInfoDO;
import cn.acsm.module.member.signin.dal.mysql.auth.AuthConfigInfoMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.member.signin.enums.ErrorCodeConstants.*;

/**
 * 会员登录授权配置信息 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class AuthConfigInfoServiceImpl implements AuthConfigInfoService {

    @Resource
    private AuthConfigInfoMapper authConfigInfoMapper;

    @Override
    public Long createAuthConfigInfo(AuthConfigInfoCreateReqVO createReqVO) {
        // 插入
        AuthConfigInfoDO authConfigInfo = AuthConfigInfoConvert.INSTANCE.convert(createReqVO);
        authConfigInfoMapper.insert(authConfigInfo);
        // 返回
        return authConfigInfo.getId();
    }

    @Override
    public void updateAuthConfigInfo(AuthConfigInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateAuthConfigInfoExists(updateReqVO.getId());
        // 更新
        AuthConfigInfoDO updateObj = AuthConfigInfoConvert.INSTANCE.convert(updateReqVO);
        authConfigInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteAuthConfigInfo(Long id) {
        // 校验存在
        this.validateAuthConfigInfoExists(id);
        // 删除
        authConfigInfoMapper.deleteById(id);
    }

    private void validateAuthConfigInfoExists(Long id) {
        if (authConfigInfoMapper.selectById(id) == null) {
            throw exception(AUTH_CONFIG_INFO_NOT_EXISTS);
        }
    }

    @Override
    public AuthConfigInfoDO getAuthConfigInfo(Long id) {
        return authConfigInfoMapper.selectById(id);
    }

    @Override
    public List<AuthConfigInfoDO> getAuthConfigInfoList(Collection<Long> ids) {
        return authConfigInfoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<AuthConfigInfoDO> getAuthConfigInfoPage(AuthConfigInfoPageReqVO pageReqVO) {
        return authConfigInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<AuthConfigInfoDO> getAuthConfigInfoList(AuthConfigInfoExportReqVO exportReqVO) {
        return authConfigInfoMapper.selectList(exportReqVO);
    }

}
