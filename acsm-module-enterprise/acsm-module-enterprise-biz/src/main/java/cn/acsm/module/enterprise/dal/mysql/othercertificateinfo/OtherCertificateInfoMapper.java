package cn.acsm.module.enterprise.dal.mysql.othercertificateinfo;

import cn.acsm.module.enterprise.controller.admin.othercertificateinfo.vo.OtherCertificateInfoExportReqVO;
import cn.acsm.module.enterprise.controller.admin.othercertificateinfo.vo.OtherCertificateInfoPageReqVO;
import cn.acsm.module.enterprise.dal.dataobject.othercertificateinfo.OtherCertificateInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 经营主体其他证件 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface OtherCertificateInfoMapper extends BaseMapperX< OtherCertificateInfoDO > {

    default PageResult<OtherCertificateInfoDO> selectPage(OtherCertificateInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<OtherCertificateInfoDO>()
                .eqIfPresent(OtherCertificateInfoDO::getEnterpriseId, reqVO.getEnterpriseId())
                .eqIfPresent(OtherCertificateInfoDO::getCertificateType, reqVO.getCertificateType())
                .likeIfPresent(OtherCertificateInfoDO::getCertificateName, reqVO.getCertificateName())
                .eqIfPresent(OtherCertificateInfoDO::getCertificateNo, reqVO.getCertificateNo())
                .betweenIfPresent(OtherCertificateInfoDO::getCertificateEndTime, reqVO.getCertificateEndTime())
                .eqIfPresent(OtherCertificateInfoDO::getCertificatePhoto, reqVO.getCertificatePhoto())
                .eqIfPresent(OtherCertificateInfoDO::getSource, reqVO.getSource())
                .eqIfPresent(OtherCertificateInfoDO::getSubjectId, reqVO.getSubjectId())
                .betweenIfPresent(OtherCertificateInfoDO::getCreateTime, reqVO.getCreateTime())
                .betweenIfPresent(OtherCertificateInfoDO::getUpdateTime, reqVO.getUpdateTime())
                .orderByDesc(OtherCertificateInfoDO::getId));
    }

    default List<OtherCertificateInfoDO> selectList(OtherCertificateInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<OtherCertificateInfoDO>()
                .eqIfPresent(OtherCertificateInfoDO::getEnterpriseId, reqVO.getEnterpriseId())
                .eqIfPresent(OtherCertificateInfoDO::getCertificateType, reqVO.getCertificateType())
                .likeIfPresent(OtherCertificateInfoDO::getCertificateName, reqVO.getCertificateName())
                .eqIfPresent(OtherCertificateInfoDO::getCertificateNo, reqVO.getCertificateNo())
                .betweenIfPresent(OtherCertificateInfoDO::getCertificateEndTime, reqVO.getCertificateEndTime())
                .eqIfPresent(OtherCertificateInfoDO::getCertificatePhoto, reqVO.getCertificatePhoto())
                .eqIfPresent(OtherCertificateInfoDO::getSource, reqVO.getSource())
                .eqIfPresent(OtherCertificateInfoDO::getSubjectId, reqVO.getSubjectId())
                .betweenIfPresent(OtherCertificateInfoDO::getCreateTime, reqVO.getCreateTime())
                .betweenIfPresent(OtherCertificateInfoDO::getUpdateTime, reqVO.getUpdateTime())
                .orderByDesc(OtherCertificateInfoDO::getId));
    }

}
