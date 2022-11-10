package cn.acsm.module.user.user.dal.mysql.user;

import java.util.*;

import cn.acsm.module.user.user.controller.admin.user.vo.MemberUserPageReqVO;
import cn.acsm.module.user.user.dal.dataobject.user.MemberUserDO;
import cn.acsm.module.user.user.controller.admin.user.vo.MemberUserExportReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户 Mapper
 *
 * @author lihongyan
 */
@Mapper
public interface MemberUserMapper extends BaseMapperX<MemberUserDO> {

    default PageResult<MemberUserDO> selectPage(MemberUserPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MemberUserDO>()
                .likeIfPresent(MemberUserDO::getNickname, reqVO.getNickname())
                .eqIfPresent(MemberUserDO::getAvatar, reqVO.getAvatar())
                .eqIfPresent(MemberUserDO::getStatus, reqVO.getStatus())
                .eqIfPresent(MemberUserDO::getMobile, reqVO.getMobile())
                .eqIfPresent(MemberUserDO::getPassword, reqVO.getPassword())
                .eqIfPresent(MemberUserDO::getRegisterIp, reqVO.getRegisterIp())
                .eqIfPresent(MemberUserDO::getLoginIp, reqVO.getLoginIp())
                .betweenIfPresent(MemberUserDO::getLoginDate, reqVO.getLoginDate())
                .betweenIfPresent(MemberUserDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MemberUserDO::getId));
    }

    default List<MemberUserDO> selectList(MemberUserExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MemberUserDO>()
                .likeIfPresent(MemberUserDO::getNickname, reqVO.getNickname())
                .eqIfPresent(MemberUserDO::getAvatar, reqVO.getAvatar())
                .eqIfPresent(MemberUserDO::getStatus, reqVO.getStatus())
                .eqIfPresent(MemberUserDO::getMobile, reqVO.getMobile())
                .eqIfPresent(MemberUserDO::getPassword, reqVO.getPassword())
                .eqIfPresent(MemberUserDO::getRegisterIp, reqVO.getRegisterIp())
                .eqIfPresent(MemberUserDO::getLoginIp, reqVO.getLoginIp())
                .betweenIfPresent(MemberUserDO::getLoginDate, reqVO.getLoginDate())
                .betweenIfPresent(MemberUserDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MemberUserDO::getId));
    }

    default MemberUserDO getMemberUserByPhoneAndTenantId(MemberUserExportReqVO reqVO) {
        return selectOne(new LambdaQueryWrapperX<MemberUserDO>()
                .eqIfPresent(MemberUserDO::getMobile, reqVO.getMobile())
                .eqIfPresent(MemberUserDO::getTenantId, reqVO.getTenantId()));
    }

}
