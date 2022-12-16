package cn.acsm.module.production.bases.dal.mysql.productioncapacityplans;

import java.util.*;

import cn.acsm.module.production.bases.controller.admin.productioncapacityplans.vo.ProductionCapacityPlansExportReqVO;
import cn.acsm.module.production.bases.controller.admin.productioncapacityplans.vo.ProductionCapacityPlansPageReqVO;
import cn.acsm.module.production.bases.dal.dataobject.productioncapacityplans.ProductionCapacityPlansDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.production.bases.controller.admin.productioncapacityplans.vo.*;

/**
 * 产能计划 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ProductionCapacityPlansMapper extends BaseMapperX<ProductionCapacityPlansDO> {

    default PageResult<ProductionCapacityPlansDO> selectPage(ProductionCapacityPlansPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProductionCapacityPlansDO>()
                .eqIfPresent(ProductionCapacityPlansDO::getBasesId, reqVO.getBasesId())
                .likeIfPresent(ProductionCapacityPlansDO::getPlanName, reqVO.getPlanName())
                .eqIfPresent(ProductionCapacityPlansDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(ProductionCapacityPlansDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(ProductionCapacityPlansDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(ProductionCapacityPlansDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(ProductionCapacityPlansDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(ProductionCapacityPlansDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(ProductionCapacityPlansDO::getCorpName, reqVO.getCorpName())
                .betweenIfPresent(ProductionCapacityPlansDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ProductionCapacityPlansDO::getSource, reqVO.getSource())
                .eqIfPresent(ProductionCapacityPlansDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(ProductionCapacityPlansDO::getId));
    }

    default List<ProductionCapacityPlansDO> selectList(ProductionCapacityPlansExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ProductionCapacityPlansDO>()
                .eqIfPresent(ProductionCapacityPlansDO::getBasesId, reqVO.getBasesId())
                .likeIfPresent(ProductionCapacityPlansDO::getPlanName, reqVO.getPlanName())
                .eqIfPresent(ProductionCapacityPlansDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(ProductionCapacityPlansDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(ProductionCapacityPlansDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(ProductionCapacityPlansDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(ProductionCapacityPlansDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(ProductionCapacityPlansDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(ProductionCapacityPlansDO::getCorpName, reqVO.getCorpName())
                .betweenIfPresent(ProductionCapacityPlansDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ProductionCapacityPlansDO::getSource, reqVO.getSource())
                .eqIfPresent(ProductionCapacityPlansDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(ProductionCapacityPlansDO::getId));
    }

}
