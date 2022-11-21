package cn.acsm.module.member.signin.service.config;

import cn.acsm.module.member.signin.controller.admin.config.vo.AuthLoginInfoCreateReqVO;
import cn.acsm.module.member.signin.controller.admin.config.vo.AuthLoginInfoExportReqVO;
import cn.acsm.module.member.signin.controller.admin.config.vo.AuthLoginInfoPageReqVO;
import cn.acsm.module.member.signin.controller.admin.config.vo.AuthLoginInfoUpdateReqVO;
import cn.acsm.module.member.signin.convert.config.AuthLoginInfoConvert;
import cn.acsm.module.member.signin.dal.dataobject.config.AuthLoginInfoDO;
import cn.acsm.module.member.signin.dal.mysql.config.AuthLoginInfoMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.member.signin.enums.ErrorCodeConstants.*;

/**
 * 会员授权登录信息记录 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class AuthLoginInfoServiceImpl implements AuthLoginInfoService {

    @Resource
    private AuthLoginInfoMapper authLoginInfoMapper;

    @Override
    public Long createAuthLoginInfo(AuthLoginInfoCreateReqVO createReqVO) {
        // 插入
        AuthLoginInfoDO authLoginInfo = AuthLoginInfoConvert.INSTANCE.convert(createReqVO);
        authLoginInfoMapper.insert(authLoginInfo);
        // 返回
        return authLoginInfo.getId();
    }

    @Override
    public void updateAuthLoginInfo(AuthLoginInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateAuthLoginInfoExists(updateReqVO.getId());
        // 更新
        AuthLoginInfoDO updateObj = AuthLoginInfoConvert.INSTANCE.convert(updateReqVO);
        authLoginInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteAuthLoginInfo(Long id) {
        // 校验存在
        this.validateAuthLoginInfoExists(id);
        // 删除
        authLoginInfoMapper.deleteById(id);
    }

    private void validateAuthLoginInfoExists(Long id) {
        if (authLoginInfoMapper.selectById(id) == null) {
            throw exception(AUTH_LOGIN_INFO_NOT_EXISTS);
        }
    }

    @Override
    public AuthLoginInfoDO getAuthLoginInfo(Long id) {
        return authLoginInfoMapper.selectById(id);
    }

    @Override
    public List<AuthLoginInfoDO> getAuthLoginInfoList(Collection<Long> ids) {
        return authLoginInfoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<AuthLoginInfoDO> getAuthLoginInfoPage(AuthLoginInfoPageReqVO pageReqVO) {
        return authLoginInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<AuthLoginInfoDO> getAuthLoginInfoList(AuthLoginInfoExportReqVO exportReqVO) {
        return authLoginInfoMapper.selectList(exportReqVO);
    }

}
