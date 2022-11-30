package cn.acsm.module.member.user.dal.mysql.professional;

import java.util.*;

import cn.acsm.module.member.user.controller.admin.professional.vo.ProfessionalQualificationExportReqVO;
import cn.acsm.module.member.user.controller.admin.professional.vo.ProfessionalQualificationPageReqVO;
import cn.acsm.module.member.user.dal.dataobject.professional.ProfessionalQualificationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 专业资质 Mapper
 *
 * @author lihongyan
 */
@Mapper
public interface ProfessionalQualificationMapper extends BaseMapperX<ProfessionalQualificationDO> {

    default PageResult<ProfessionalQualificationDO> selectPage(ProfessionalQualificationPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProfessionalQualificationDO>()
                .eqIfPresent(ProfessionalQualificationDO::getMemberId, reqVO.getMemberId())
                .eqIfPresent(ProfessionalQualificationDO::getRecordType, reqVO.getRecordType())
                .likeIfPresent(ProfessionalQualificationDO::getRecordName, reqVO.getRecordName())
                .eqIfPresent(ProfessionalQualificationDO::getPermitNo, reqVO.getPermitNo())
                .likeIfPresent(ProfessionalQualificationDO::getName, reqVO.getName())
                .eqIfPresent(ProfessionalQualificationDO::getPhone, reqVO.getPhone())
                .betweenIfPresent(ProfessionalQualificationDO::getRecordDate, reqVO.getRecordDate())
                .eqIfPresent(ProfessionalQualificationDO::getIdPhoto, reqVO.getIdPhoto())
                .eqIfPresent(ProfessionalQualificationDO::getAuditStatus, reqVO.getAuditStatus())
                .betweenIfPresent(ProfessionalQualificationDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ProfessionalQualificationDO::getSource, reqVO.getSource())
                .eqIfPresent(ProfessionalQualificationDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(ProfessionalQualificationDO::getId));
    }

    default List<ProfessionalQualificationDO> selectList(ProfessionalQualificationExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ProfessionalQualificationDO>()
                .eqIfPresent(ProfessionalQualificationDO::getMemberId, reqVO.getMemberId())
                .eqIfPresent(ProfessionalQualificationDO::getRecordType, reqVO.getRecordType())
                .likeIfPresent(ProfessionalQualificationDO::getRecordName, reqVO.getRecordName())
                .eqIfPresent(ProfessionalQualificationDO::getPermitNo, reqVO.getPermitNo())
                .likeIfPresent(ProfessionalQualificationDO::getName, reqVO.getName())
                .eqIfPresent(ProfessionalQualificationDO::getPhone, reqVO.getPhone())
                .betweenIfPresent(ProfessionalQualificationDO::getRecordDate, reqVO.getRecordDate())
                .eqIfPresent(ProfessionalQualificationDO::getIdPhoto, reqVO.getIdPhoto())
                .eqIfPresent(ProfessionalQualificationDO::getAuditStatus, reqVO.getAuditStatus())
                .betweenIfPresent(ProfessionalQualificationDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ProfessionalQualificationDO::getSource, reqVO.getSource())
                .eqIfPresent(ProfessionalQualificationDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(ProfessionalQualificationDO::getId));
    }

}
