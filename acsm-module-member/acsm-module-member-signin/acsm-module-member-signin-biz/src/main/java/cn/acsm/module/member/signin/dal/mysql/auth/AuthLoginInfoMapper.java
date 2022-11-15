package cn.acsm.module.member.signin.dal.mysql.auth;

import java.util.*;

import cn.acsm.module.member.signin.controller.admin.auth.vo.AuthLoginInfoExportReqVO;
import cn.acsm.module.member.signin.controller.admin.auth.vo.AuthLoginInfoPageReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.member.signin.dal.dataobject.auth.AuthLoginInfoDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员授权登录信息记录 Mapper
 *
 * @author lihongyan
 */
@Mapper
public interface AuthLoginInfoMapper extends BaseMapperX<AuthLoginInfoDO> {

    default PageResult<AuthLoginInfoDO> selectPage(AuthLoginInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AuthLoginInfoDO>()
                .eqIfPresent(AuthLoginInfoDO::getOpenId, reqVO.getOpenId())
                .eqIfPresent(AuthLoginInfoDO::getPhone, reqVO.getPhone())
                .eqIfPresent(AuthLoginInfoDO::getMemberId, reqVO.getMemberId())
                .eqIfPresent(AuthLoginInfoDO::getSex, reqVO.getSex())
                .eqIfPresent(AuthLoginInfoDO::getType, reqVO.getType())
                .eqIfPresent(AuthLoginInfoDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(AuthLoginInfoDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(AuthLoginInfoDO::getSource, reqVO.getSource())
                .eqIfPresent(AuthLoginInfoDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(AuthLoginInfoDO::getId));
    }

    default List<AuthLoginInfoDO> selectList(AuthLoginInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<AuthLoginInfoDO>()
                .eqIfPresent(AuthLoginInfoDO::getOpenId, reqVO.getOpenId())
                .eqIfPresent(AuthLoginInfoDO::getPhone, reqVO.getPhone())
                .eqIfPresent(AuthLoginInfoDO::getMemberId, reqVO.getMemberId())
                .eqIfPresent(AuthLoginInfoDO::getSex, reqVO.getSex())
                .eqIfPresent(AuthLoginInfoDO::getType, reqVO.getType())
                .eqIfPresent(AuthLoginInfoDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(AuthLoginInfoDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(AuthLoginInfoDO::getSource, reqVO.getSource())
                .eqIfPresent(AuthLoginInfoDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(AuthLoginInfoDO::getId));
    }

}
