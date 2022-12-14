package cn.acsm.module.transaction.sales.dal.mysql.specialmedicalfoodorganization;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.sales.dal.dataobject.specialmedicalfoodorganization.SpecialMedicalFoodOrganizationDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodorganization.vo.*;

/**
 * 特医食品组成 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface SpecialMedicalFoodOrganizationMapper extends BaseMapperX<SpecialMedicalFoodOrganizationDO> {

    default PageResult<SpecialMedicalFoodOrganizationDO> selectPage(SpecialMedicalFoodOrganizationPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SpecialMedicalFoodOrganizationDO>()
                .eqIfPresent(SpecialMedicalFoodOrganizationDO::getFoodId, reqVO.getFoodId())
                .likeIfPresent(SpecialMedicalFoodOrganizationDO::getOrganizationName, reqVO.getOrganizationName())
                .betweenIfPresent(SpecialMedicalFoodOrganizationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SpecialMedicalFoodOrganizationDO::getId));
    }

    default List<SpecialMedicalFoodOrganizationDO> selectList(SpecialMedicalFoodOrganExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<SpecialMedicalFoodOrganizationDO>()
                .eqIfPresent(SpecialMedicalFoodOrganizationDO::getFoodId, reqVO.getFoodId())
                .likeIfPresent(SpecialMedicalFoodOrganizationDO::getOrganizationName, reqVO.getOrganizationName())
                .betweenIfPresent(SpecialMedicalFoodOrganizationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SpecialMedicalFoodOrganizationDO::getId));
    }

}
