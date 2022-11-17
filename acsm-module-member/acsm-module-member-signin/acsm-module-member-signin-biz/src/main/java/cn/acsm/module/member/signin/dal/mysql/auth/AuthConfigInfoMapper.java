package cn.acsm.module.member.signin.dal.mysql.auth;

import java.util.*;

import cn.acsm.module.member.signin.controller.admin.auth.vo.AuthConfigInfoExportReqVO;
import cn.acsm.module.member.signin.controller.admin.auth.vo.AuthConfigInfoPageReqVO;
import cn.acsm.module.member.signin.controller.app.auth.vo.AppAuthConfigInfoExportReqVO;
import cn.acsm.module.member.signin.controller.app.auth.vo.AppAuthConfigInfoPageReqVO;
import cn.acsm.module.member.signin.dal.dataobject.auth.AuthConfigInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员登录授权配置信息 Mapper
 *
 * @author lihongyan
 */
@Mapper
public interface AuthConfigInfoMapper extends BaseMapperX<AuthConfigInfoDO> {

    default PageResult<AuthConfigInfoDO> selectPage(AuthConfigInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AuthConfigInfoDO>()
                .eqIfPresent(AuthConfigInfoDO::getAppId, reqVO.getAppId())
                .eqIfPresent(AuthConfigInfoDO::getAppSecret, reqVO.getAppSecret())
                .eqIfPresent(AuthConfigInfoDO::getAppletFlag, reqVO.getAppletFlag())
                .eqIfPresent(AuthConfigInfoDO::getRemark, reqVO.getRemark())
                .eqIfPresent(AuthConfigInfoDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(AuthConfigInfoDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(AuthConfigInfoDO::getSource, reqVO.getSource())
                .eqIfPresent(AuthConfigInfoDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(AuthConfigInfoDO::getId));
    }

    default List<AuthConfigInfoDO> selectList(AuthConfigInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<AuthConfigInfoDO>()
                .eqIfPresent(AuthConfigInfoDO::getAppId, reqVO.getAppId())
                .eqIfPresent(AuthConfigInfoDO::getAppSecret, reqVO.getAppSecret())
                .eqIfPresent(AuthConfigInfoDO::getAppletFlag, reqVO.getAppletFlag())
                .eqIfPresent(AuthConfigInfoDO::getRemark, reqVO.getRemark())
                .eqIfPresent(AuthConfigInfoDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(AuthConfigInfoDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(AuthConfigInfoDO::getSource, reqVO.getSource())
                .eqIfPresent(AuthConfigInfoDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(AuthConfigInfoDO::getId));
    }

    default PageResult<AuthConfigInfoDO> selectPage(AppAuthConfigInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AuthConfigInfoDO>()
                .eqIfPresent(AuthConfigInfoDO::getAppId, reqVO.getAppId())
                .eqIfPresent(AuthConfigInfoDO::getAppSecret, reqVO.getAppSecret())
                .eqIfPresent(AuthConfigInfoDO::getAppletFlag, reqVO.getAppletFlag())
                .eqIfPresent(AuthConfigInfoDO::getRemark, reqVO.getRemark())
                .eqIfPresent(AuthConfigInfoDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(AuthConfigInfoDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(AuthConfigInfoDO::getSource, reqVO.getSource())
                .eqIfPresent(AuthConfigInfoDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(AuthConfigInfoDO::getId));
    }

    default List<AuthConfigInfoDO> selectList(AppAuthConfigInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<AuthConfigInfoDO>()
                .eqIfPresent(AuthConfigInfoDO::getAppId, reqVO.getAppId())
                .eqIfPresent(AuthConfigInfoDO::getAppSecret, reqVO.getAppSecret())
                .eqIfPresent(AuthConfigInfoDO::getAppletFlag, reqVO.getAppletFlag())
                .eqIfPresent(AuthConfigInfoDO::getRemark, reqVO.getRemark())
                .eqIfPresent(AuthConfigInfoDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(AuthConfigInfoDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(AuthConfigInfoDO::getSource, reqVO.getSource())
                .eqIfPresent(AuthConfigInfoDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(AuthConfigInfoDO::getId));
    }

}
