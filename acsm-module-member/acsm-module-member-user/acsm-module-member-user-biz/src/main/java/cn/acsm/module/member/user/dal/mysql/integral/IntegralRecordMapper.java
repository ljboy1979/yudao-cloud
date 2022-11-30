package cn.acsm.module.member.user.dal.mysql.integral;

import java.util.*;

import cn.acsm.module.member.user.controller.admin.integral.vo.record.IntegralRecordExportReqVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.record.IntegralRecordPageReqVO;
import cn.acsm.module.member.user.dal.dataobject.integral.IntegralRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员积分记录 Mapper
 *
 * @author lihongyan
 */
@Mapper
public interface IntegralRecordMapper extends BaseMapperX<IntegralRecordDO> {

    default PageResult<IntegralRecordDO> selectPage(IntegralRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<IntegralRecordDO>()
                .eqIfPresent(IntegralRecordDO::getMemberId, reqVO.getMemberId())
                .eqIfPresent(IntegralRecordDO::getMemberAccount, reqVO.getMemberAccount())
                .likeIfPresent(IntegralRecordDO::getMemberName, reqVO.getMemberName())
                .eqIfPresent(IntegralRecordDO::getRatingItems, reqVO.getRatingItems())
                .eqIfPresent(IntegralRecordDO::getIntegralChange, reqVO.getIntegralChange())
                .eqIfPresent(IntegralRecordDO::getIntegralRemaining, reqVO.getIntegralRemaining())
                .eqIfPresent(IntegralRecordDO::getIntegralUseDetails, reqVO.getIntegralUseDetails())
                .betweenIfPresent(IntegralRecordDO::getIntegralChangeTime, reqVO.getIntegralChangeTime())
                .eqIfPresent(IntegralRecordDO::getPicture, reqVO.getPicture())
                .betweenIfPresent(IntegralRecordDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(IntegralRecordDO::getSource, reqVO.getSource())
                .eqIfPresent(IntegralRecordDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(IntegralRecordDO::getId));
    }

    default List<IntegralRecordDO> selectList(IntegralRecordExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<IntegralRecordDO>()
                .eqIfPresent(IntegralRecordDO::getMemberId, reqVO.getMemberId())
                .eqIfPresent(IntegralRecordDO::getMemberAccount, reqVO.getMemberAccount())
                .likeIfPresent(IntegralRecordDO::getMemberName, reqVO.getMemberName())
                .eqIfPresent(IntegralRecordDO::getRatingItems, reqVO.getRatingItems())
                .eqIfPresent(IntegralRecordDO::getIntegralChange, reqVO.getIntegralChange())
                .eqIfPresent(IntegralRecordDO::getIntegralRemaining, reqVO.getIntegralRemaining())
                .eqIfPresent(IntegralRecordDO::getIntegralUseDetails, reqVO.getIntegralUseDetails())
                .betweenIfPresent(IntegralRecordDO::getIntegralChangeTime, reqVO.getIntegralChangeTime())
                .eqIfPresent(IntegralRecordDO::getPicture, reqVO.getPicture())
                .betweenIfPresent(IntegralRecordDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(IntegralRecordDO::getSource, reqVO.getSource())
                .eqIfPresent(IntegralRecordDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(IntegralRecordDO::getId));
    }

}
