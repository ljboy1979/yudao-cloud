package cn.acsm.module.transaction.sales.dal.mysql.specialmedicalfoodclassify;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.sales.dal.dataobject.specialmedicalfoodclassify.SpecialMedicalFoodClassifyDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodclassify.vo.*;

/**
 * 特医食品分类 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface SpecialMedicalFoodClassifyMapper extends BaseMapperX<SpecialMedicalFoodClassifyDO> {

    default PageResult<SpecialMedicalFoodClassifyDO> selectPage(SpecialMedicalFoodClassifyPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SpecialMedicalFoodClassifyDO>()
                .likeIfPresent(SpecialMedicalFoodClassifyDO::getCategoryName, reqVO.getCategoryName())
                .betweenIfPresent(SpecialMedicalFoodClassifyDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SpecialMedicalFoodClassifyDO::getId));
    }

    default List<SpecialMedicalFoodClassifyDO> selectList(SpecialMedicalFoodClassifyExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<SpecialMedicalFoodClassifyDO>()
                .likeIfPresent(SpecialMedicalFoodClassifyDO::getCategoryName, reqVO.getCategoryName())
                .betweenIfPresent(SpecialMedicalFoodClassifyDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SpecialMedicalFoodClassifyDO::getId));
    }

    default List<SpecialMedicalFoodClassifyDO> selectListToTree(SpecialMedicalFoodClassifyTreeVO reqVO) {
        return selectList(new LambdaQueryWrapperX<SpecialMedicalFoodClassifyDO>()
                .likeIfPresent(SpecialMedicalFoodClassifyDO::getCategoryName, reqVO.getCategoryName())
                .orderByDesc(SpecialMedicalFoodClassifyDO::getId));
    }

}
