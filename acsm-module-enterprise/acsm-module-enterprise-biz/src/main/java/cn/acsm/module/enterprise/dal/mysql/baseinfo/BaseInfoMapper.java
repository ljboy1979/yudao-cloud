package cn.acsm.module.enterprise.dal.mysql.baseinfo;

import java.util.*;

import cn.acsm.module.enterprise.controller.admin.baseinfo.vo.BaseInfoExportReqVO;
import cn.acsm.module.enterprise.controller.admin.baseinfo.vo.BaseInfoPageReqVO;
import cn.acsm.module.enterprise.dal.dataobject.baseinfo.BaseInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 经营主体 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface BaseInfoMapper extends BaseMapperX< BaseInfoDO > {

    default PageResult<BaseInfoDO> selectPage(BaseInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BaseInfoDO>()
                .eqIfPresent(BaseInfoDO::getCode, reqVO.getCode())
                .likeIfPresent(BaseInfoDO::getName, reqVO.getName())
                .eqIfPresent(BaseInfoDO::getEnterpriseType, reqVO.getEnterpriseType())
                .likeIfPresent(BaseInfoDO::getEnterpriseTypeName, reqVO.getEnterpriseTypeName())
                .eqIfPresent(BaseInfoDO::getStauts, reqVO.getStauts())
                .eqIfPresent(BaseInfoDO::getUserTag, reqVO.getUserTag())
                .likeIfPresent(BaseInfoDO::getUserTagName, reqVO.getUserTagName())
                .eqIfPresent(BaseInfoDO::getManageStatus, reqVO.getManageStatus())
                .eqIfPresent(BaseInfoDO::getAddress, reqVO.getAddress())
                .eqIfPresent(BaseInfoDO::getDetailedAddress, reqVO.getDetailedAddress())
                .eqIfPresent(BaseInfoDO::getSocialCreditCode, reqVO.getSocialCreditCode())
                .eqIfPresent(BaseInfoDO::getBusinessCertificatePhoto, reqVO.getBusinessCertificatePhoto())
                .eqIfPresent(BaseInfoDO::getLegalPerson, reqVO.getLegalPerson())
                .eqIfPresent(BaseInfoDO::getLegalIdCard, reqVO.getLegalIdCard())
                .eqIfPresent(BaseInfoDO::getLegalIdCardPhoto, reqVO.getLegalIdCardPhoto())
                .betweenIfPresent(BaseInfoDO::getRegisterTime, reqVO.getRegisterTime())
                .eqIfPresent(BaseInfoDO::getDescription, reqVO.getDescription())
                .eqIfPresent(BaseInfoDO::getLogo, reqVO.getLogo())
                .eqIfPresent(BaseInfoDO::getBusinessLicenseNo, reqVO.getBusinessLicenseNo())
                .eqIfPresent(BaseInfoDO::getBusinessLicensePhoto, reqVO.getBusinessLicensePhoto())
                .betweenIfPresent(BaseInfoDO::getBusinessLicenseEndTime, reqVO.getBusinessLicenseEndTime())
                .likeIfPresent(BaseInfoDO::getAccountName, reqVO.getAccountName())
                .eqIfPresent(BaseInfoDO::getAccountNo, reqVO.getAccountNo())
                .eqIfPresent(BaseInfoDO::getAccountIdCard, reqVO.getAccountIdCard())
                .eqIfPresent(BaseInfoDO::getAccountBank, reqVO.getAccountBank())
                .likeIfPresent(BaseInfoDO::getContactName, reqVO.getContactName())
                .eqIfPresent(BaseInfoDO::getContactPhone, reqVO.getContactPhone())
                .eqIfPresent(BaseInfoDO::getVillagesAreaId, reqVO.getVillagesAreaId())
                .likeIfPresent(BaseInfoDO::getVillagesAreaName, reqVO.getVillagesAreaName())
                .eqIfPresent(BaseInfoDO::getAreaId, reqVO.getAreaId())
                .likeIfPresent(BaseInfoDO::getAreaName, reqVO.getAreaName())
                .eqIfPresent(BaseInfoDO::getRuralId, reqVO.getRuralId())
                .likeIfPresent(BaseInfoDO::getRuralName, reqVO.getRuralName())
                .eqIfPresent(BaseInfoDO::getEnterpriseScale, reqVO.getEnterpriseScale())
                .eqIfPresent(BaseInfoDO::getServiceRange, reqVO.getServiceRange())
                .eqIfPresent(BaseInfoDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(BaseInfoDO::getSource, reqVO.getSource())
                .eqIfPresent(BaseInfoDO::getSubjectId, reqVO.getSubjectId())
                .betweenIfPresent(BaseInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(BaseInfoDO::getId));
    }

    default List<BaseInfoDO> selectList(BaseInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<BaseInfoDO>()
                .eqIfPresent(BaseInfoDO::getCode, reqVO.getCode())
                .likeIfPresent(BaseInfoDO::getName, reqVO.getName())
                .eqIfPresent(BaseInfoDO::getEnterpriseType, reqVO.getEnterpriseType())
                .likeIfPresent(BaseInfoDO::getEnterpriseTypeName, reqVO.getEnterpriseTypeName())
                .eqIfPresent(BaseInfoDO::getStauts, reqVO.getStauts())
                .eqIfPresent(BaseInfoDO::getUserTag, reqVO.getUserTag())
                .likeIfPresent(BaseInfoDO::getUserTagName, reqVO.getUserTagName())
                .eqIfPresent(BaseInfoDO::getManageStatus, reqVO.getManageStatus())
                .eqIfPresent(BaseInfoDO::getAddress, reqVO.getAddress())
                .eqIfPresent(BaseInfoDO::getDetailedAddress, reqVO.getDetailedAddress())
                .eqIfPresent(BaseInfoDO::getSocialCreditCode, reqVO.getSocialCreditCode())
                .eqIfPresent(BaseInfoDO::getBusinessCertificatePhoto, reqVO.getBusinessCertificatePhoto())
                .eqIfPresent(BaseInfoDO::getLegalPerson, reqVO.getLegalPerson())
                .eqIfPresent(BaseInfoDO::getLegalIdCard, reqVO.getLegalIdCard())
                .eqIfPresent(BaseInfoDO::getLegalIdCardPhoto, reqVO.getLegalIdCardPhoto())
                .betweenIfPresent(BaseInfoDO::getRegisterTime, reqVO.getRegisterTime())
                .eqIfPresent(BaseInfoDO::getDescription, reqVO.getDescription())
                .eqIfPresent(BaseInfoDO::getLogo, reqVO.getLogo())
                .eqIfPresent(BaseInfoDO::getBusinessLicenseNo, reqVO.getBusinessLicenseNo())
                .eqIfPresent(BaseInfoDO::getBusinessLicensePhoto, reqVO.getBusinessLicensePhoto())
                .betweenIfPresent(BaseInfoDO::getBusinessLicenseEndTime, reqVO.getBusinessLicenseEndTime())
                .likeIfPresent(BaseInfoDO::getAccountName, reqVO.getAccountName())
                .eqIfPresent(BaseInfoDO::getAccountNo, reqVO.getAccountNo())
                .eqIfPresent(BaseInfoDO::getAccountIdCard, reqVO.getAccountIdCard())
                .eqIfPresent(BaseInfoDO::getAccountBank, reqVO.getAccountBank())
                .likeIfPresent(BaseInfoDO::getContactName, reqVO.getContactName())
                .eqIfPresent(BaseInfoDO::getContactPhone, reqVO.getContactPhone())
                .eqIfPresent(BaseInfoDO::getVillagesAreaId, reqVO.getVillagesAreaId())
                .likeIfPresent(BaseInfoDO::getVillagesAreaName, reqVO.getVillagesAreaName())
                .eqIfPresent(BaseInfoDO::getAreaId, reqVO.getAreaId())
                .likeIfPresent(BaseInfoDO::getAreaName, reqVO.getAreaName())
                .eqIfPresent(BaseInfoDO::getRuralId, reqVO.getRuralId())
                .likeIfPresent(BaseInfoDO::getRuralName, reqVO.getRuralName())
                .eqIfPresent(BaseInfoDO::getEnterpriseScale, reqVO.getEnterpriseScale())
                .eqIfPresent(BaseInfoDO::getServiceRange, reqVO.getServiceRange())
                .eqIfPresent(BaseInfoDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(BaseInfoDO::getSource, reqVO.getSource())
                .eqIfPresent(BaseInfoDO::getSubjectId, reqVO.getSubjectId())
                .betweenIfPresent(BaseInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(BaseInfoDO::getId));
    }

}
