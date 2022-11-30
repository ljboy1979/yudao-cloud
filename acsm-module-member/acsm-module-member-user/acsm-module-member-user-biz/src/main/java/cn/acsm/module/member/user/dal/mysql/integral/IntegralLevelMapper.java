package cn.acsm.module.member.user.dal.mysql.integral;

import cn.acsm.module.member.user.controller.admin.integral.vo.level.IntegralLevelExportReqVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.level.IntegralLevelPageReqVO;
import cn.acsm.module.member.user.dal.dataobject.integral.IntegralLevelDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 会员积分等级 Mapper
 *
 * @author lihongyan
 */
@Mapper
public interface IntegralLevelMapper extends BaseMapperX<IntegralLevelDO> {

    default PageResult<IntegralLevelDO> selectPage(IntegralLevelPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<IntegralLevelDO>()
                .eqIfPresent(IntegralLevelDO::getEnterpriseId, reqVO.getEnterpriseId())
                .likeIfPresent(IntegralLevelDO::getEnterpriseName, reqVO.getEnterpriseName())
                .eqIfPresent(IntegralLevelDO::getMemberLevel, reqVO.getMemberLevel())
                .eqIfPresent(IntegralLevelDO::getIntegralThreshold, reqVO.getIntegralThreshold())
                .eqIfPresent(IntegralLevelDO::getLevelDiscount, reqVO.getLevelDiscount())
                .eqIfPresent(IntegralLevelDO::getLevelDescription, reqVO.getLevelDescription())
                .betweenIfPresent(IntegralLevelDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(IntegralLevelDO::getSource, reqVO.getSource())
                .eqIfPresent(IntegralLevelDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(IntegralLevelDO::getId));
    }

    default List<IntegralLevelDO> selectList(IntegralLevelExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<IntegralLevelDO>()
                .eqIfPresent(IntegralLevelDO::getEnterpriseId, reqVO.getEnterpriseId())
                .likeIfPresent(IntegralLevelDO::getEnterpriseName, reqVO.getEnterpriseName())
                .eqIfPresent(IntegralLevelDO::getMemberLevel, reqVO.getMemberLevel())
                .eqIfPresent(IntegralLevelDO::getIntegralThreshold, reqVO.getIntegralThreshold())
                .eqIfPresent(IntegralLevelDO::getLevelDiscount, reqVO.getLevelDiscount())
                .eqIfPresent(IntegralLevelDO::getLevelDescription, reqVO.getLevelDescription())
                .betweenIfPresent(IntegralLevelDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(IntegralLevelDO::getSource, reqVO.getSource())
                .eqIfPresent(IntegralLevelDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(IntegralLevelDO::getId));
    }

}
