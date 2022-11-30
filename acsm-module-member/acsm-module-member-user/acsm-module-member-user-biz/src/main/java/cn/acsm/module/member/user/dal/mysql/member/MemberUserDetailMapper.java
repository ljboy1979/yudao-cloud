package cn.acsm.module.member.user.dal.mysql.member;

import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserDetailExportReqVO;
import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserDetailPageReqVO;
import cn.acsm.module.member.user.dal.dataobject.member.MemberUserDetailDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 会员信息 Mapper
 *
 * @author lihongyan
 */
@Mapper
public interface MemberUserDetailMapper extends BaseMapperX<MemberUserDetailDO> {

    default PageResult<MemberUserDetailDO> selectPage(MemberUserDetailPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MemberUserDetailDO>()
                .eqIfPresent(MemberUserDetailDO::getMemberId, reqVO.getMemberId())
                .eqIfPresent(MemberUserDetailDO::getEnterpriseId, reqVO.getEnterpriseId())
                .likeIfPresent(MemberUserDetailDO::getEnterpriseName, reqVO.getEnterpriseName())
                .eqIfPresent(MemberUserDetailDO::getMemberType, reqVO.getMemberType())
                .eqIfPresent(MemberUserDetailDO::getMemberRole, reqVO.getMemberRole())
                .eqIfPresent(MemberUserDetailDO::getIntegralLevelId, reqVO.getIntegralLevelId())
                .eqIfPresent(MemberUserDetailDO::getAuditStatus, reqVO.getAuditStatus())
                .betweenIfPresent(MemberUserDetailDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(MemberUserDetailDO::getSource, reqVO.getSource())
                .eqIfPresent(MemberUserDetailDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(MemberUserDetailDO::getId));
    }

    default List<MemberUserDetailDO> selectList(MemberUserDetailExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MemberUserDetailDO>()
                .eqIfPresent(MemberUserDetailDO::getMemberId, reqVO.getMemberId())
                .eqIfPresent(MemberUserDetailDO::getEnterpriseId, reqVO.getEnterpriseId())
                .likeIfPresent(MemberUserDetailDO::getEnterpriseName, reqVO.getEnterpriseName())
                .eqIfPresent(MemberUserDetailDO::getMemberType, reqVO.getMemberType())
                .eqIfPresent(MemberUserDetailDO::getMemberRole, reqVO.getMemberRole())
                .eqIfPresent(MemberUserDetailDO::getIntegralLevelId, reqVO.getIntegralLevelId())
                .eqIfPresent(MemberUserDetailDO::getAuditStatus, reqVO.getAuditStatus())
                .betweenIfPresent(MemberUserDetailDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(MemberUserDetailDO::getSource, reqVO.getSource())
                .eqIfPresent(MemberUserDetailDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(MemberUserDetailDO::getId));
    }

    default MemberUserDetailDO selectByMemberId(Long memberId) {
        return selectOne(MemberUserDetailDO::getMemberId, memberId);
    }
}
