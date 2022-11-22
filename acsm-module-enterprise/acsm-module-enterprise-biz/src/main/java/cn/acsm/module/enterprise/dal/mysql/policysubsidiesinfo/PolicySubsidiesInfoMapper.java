package cn.acsm.module.enterprise.dal.mysql.policysubsidiesinfo;

import java.util.*;

import cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo.PolicySubsidiesInfoExportReqVO;
import cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo.PolicySubsidiesInfoPageReqVO;
import cn.acsm.module.enterprise.dal.dataobject.policysubsidiesinfo.PolicySubsidiesInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 企业政策补贴信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface PolicySubsidiesInfoMapper extends BaseMapperX< PolicySubsidiesInfoDO > {

    default PageResult<PolicySubsidiesInfoDO> selectPage(PolicySubsidiesInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PolicySubsidiesInfoDO>()
                .eqIfPresent(PolicySubsidiesInfoDO::getEnterpriseId, reqVO.getEnterpriseId())
                .eqIfPresent(PolicySubsidiesInfoDO::getSubsidiesCategory, reqVO.getSubsidiesCategory())
                .likeIfPresent(PolicySubsidiesInfoDO::getSubsidiesName, reqVO.getSubsidiesName())
                .eqIfPresent(PolicySubsidiesInfoDO::getSubsidiesAmount, reqVO.getSubsidiesAmount())
                .eqIfPresent(PolicySubsidiesInfoDO::getSubsidiesType, reqVO.getSubsidiesType())
                .eqIfPresent(PolicySubsidiesInfoDO::getSubsidiesStatus, reqVO.getSubsidiesStatus())
                .eqIfPresent(PolicySubsidiesInfoDO::getApplyPerson, reqVO.getApplyPerson())
                .betweenIfPresent(PolicySubsidiesInfoDO::getApplyTime, reqVO.getApplyTime())
                .eqIfPresent(PolicySubsidiesInfoDO::getSource, reqVO.getSource())
                .eqIfPresent(PolicySubsidiesInfoDO::getSubjectId, reqVO.getSubjectId())
                .betweenIfPresent(PolicySubsidiesInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PolicySubsidiesInfoDO::getId));
    }

    default List<PolicySubsidiesInfoDO> selectList(PolicySubsidiesInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<PolicySubsidiesInfoDO>()
                .eqIfPresent(PolicySubsidiesInfoDO::getEnterpriseId, reqVO.getEnterpriseId())
                .eqIfPresent(PolicySubsidiesInfoDO::getSubsidiesCategory, reqVO.getSubsidiesCategory())
                .likeIfPresent(PolicySubsidiesInfoDO::getSubsidiesName, reqVO.getSubsidiesName())
                .eqIfPresent(PolicySubsidiesInfoDO::getSubsidiesAmount, reqVO.getSubsidiesAmount())
                .eqIfPresent(PolicySubsidiesInfoDO::getSubsidiesType, reqVO.getSubsidiesType())
                .eqIfPresent(PolicySubsidiesInfoDO::getSubsidiesStatus, reqVO.getSubsidiesStatus())
                .eqIfPresent(PolicySubsidiesInfoDO::getApplyPerson, reqVO.getApplyPerson())
                .betweenIfPresent(PolicySubsidiesInfoDO::getApplyTime, reqVO.getApplyTime())
                .eqIfPresent(PolicySubsidiesInfoDO::getSource, reqVO.getSource())
                .eqIfPresent(PolicySubsidiesInfoDO::getSubjectId, reqVO.getSubjectId())
                .betweenIfPresent(PolicySubsidiesInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PolicySubsidiesInfoDO::getId));
    }

}
