package cn.acsm.module.production.facility.dal.mysql.contract;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.production.facility.dal.dataobject.contract.ContractDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.production.facility.controller.admin.contract.vo.*;

/**
 * 租赁合同 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ContractMapper extends BaseMapperX<ContractDO> {

    default PageResult<ContractDO> selectPage(ContractPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ContractDO>()
                .eqIfPresent(ContractDO::getInduSubjectId, reqVO.getInduSubjectId())
                .likeIfPresent(ContractDO::getContractName, reqVO.getContractName())
                .eqIfPresent(ContractDO::getContractNum, reqVO.getContractNum())
                .eqIfPresent(ContractDO::getContractContent, reqVO.getContractContent())
                .betweenIfPresent(ContractDO::getSignTime, reqVO.getSignTime())
                .eqIfPresent(ContractDO::getSignatory, reqVO.getSignatory())
                .eqIfPresent(ContractDO::getAmount, reqVO.getAmount())
                .eqIfPresent(ContractDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(ContractDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(ContractDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(ContractDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(ContractDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(ContractDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(ContractDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(ContractDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(ContractDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(ContractDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(ContractDO::getCorpName, reqVO.getCorpName())
                .betweenIfPresent(ContractDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ContractDO::getSource, reqVO.getSource())
                .eqIfPresent(ContractDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(ContractDO::getId));
    }

    default List<ContractDO> selectList(ContractExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ContractDO>()
                .eqIfPresent(ContractDO::getInduSubjectId, reqVO.getInduSubjectId())
                .likeIfPresent(ContractDO::getContractName, reqVO.getContractName())
                .eqIfPresent(ContractDO::getContractNum, reqVO.getContractNum())
                .eqIfPresent(ContractDO::getContractContent, reqVO.getContractContent())
                .betweenIfPresent(ContractDO::getSignTime, reqVO.getSignTime())
                .eqIfPresent(ContractDO::getSignatory, reqVO.getSignatory())
                .eqIfPresent(ContractDO::getAmount, reqVO.getAmount())
                .eqIfPresent(ContractDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(ContractDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(ContractDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(ContractDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(ContractDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(ContractDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(ContractDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(ContractDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(ContractDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(ContractDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(ContractDO::getCorpName, reqVO.getCorpName())
                .betweenIfPresent(ContractDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ContractDO::getSource, reqVO.getSource())
                .eqIfPresent(ContractDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(ContractDO::getId));
    }

}
