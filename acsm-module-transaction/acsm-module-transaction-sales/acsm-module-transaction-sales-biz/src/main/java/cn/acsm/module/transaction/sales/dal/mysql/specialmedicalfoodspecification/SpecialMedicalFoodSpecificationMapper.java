package cn.acsm.module.transaction.sales.dal.mysql.specialmedicalfoodspecification;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.sales.dal.dataobject.specialmedicalfoodspecification.SpecialMedicalFoodSpecificationDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodspecification.vo.*;

/**
 * 特医食品规格 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface SpecialMedicalFoodSpecificationMapper extends BaseMapperX<SpecialMedicalFoodSpecificationDO> {

    default PageResult<SpecialMedicalFoodSpecificationDO> selectPage(SpecialMedicalFoodSpecPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SpecialMedicalFoodSpecificationDO>()
                .eqIfPresent(SpecialMedicalFoodSpecificationDO::getFoodId, reqVO.getFoodId())
                .likeIfPresent(SpecialMedicalFoodSpecificationDO::getSpecificationsName, reqVO.getSpecificationsName())
                .betweenIfPresent(SpecialMedicalFoodSpecificationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SpecialMedicalFoodSpecificationDO::getId));
    }

    default List<SpecialMedicalFoodSpecificationDO> selectList(SpecialMedicalFoodSpecExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<SpecialMedicalFoodSpecificationDO>()
                .eqIfPresent(SpecialMedicalFoodSpecificationDO::getFoodId, reqVO.getFoodId())
                .likeIfPresent(SpecialMedicalFoodSpecificationDO::getSpecificationsName, reqVO.getSpecificationsName())
                .betweenIfPresent(SpecialMedicalFoodSpecificationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SpecialMedicalFoodSpecificationDO::getId));
    }

    default Long findSelectCount(SpecialMedicalFoodSpecificationDO specialMedicalFoodSpecificationDO) {
        return selectCount(new LambdaQueryWrapperX<SpecialMedicalFoodSpecificationDO>()
                .eqIfPresent(SpecialMedicalFoodSpecificationDO::getFoodId, specialMedicalFoodSpecificationDO.getFoodId())
                .eqIfPresent(SpecialMedicalFoodSpecificationDO::getSpecificationsName, specialMedicalFoodSpecificationDO.getSpecificationsName())
                .notIn(SpecialMedicalFoodSpecificationDO::getId, specialMedicalFoodSpecificationDO.getId())
                .orderByDesc(SpecialMedicalFoodSpecificationDO::getId));
    }

}
