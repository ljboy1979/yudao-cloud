package cn.acsm.module.transaction.sales.dal.mysql.specialmedicalfood;

import java.util.*;

import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import cn.acsm.module.transaction.sales.dal.dataobject.shelves.ShelvesSalesRespDo;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.sales.dal.dataobject.specialmedicalfood.SpecialMedicalFoodDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfood.vo.*;

/**
 * 特医食品 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface SpecialMedicalFoodMapper extends BaseMapperX<SpecialMedicalFoodDO> {

    default PageResult<SpecialMedicalFoodDO> selectPage(SpecialMedicalFoodPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SpecialMedicalFoodDO>()
                .eqIfPresent(SpecialMedicalFoodDO::getNumber, reqVO.getNumber())
                .likeIfPresent(SpecialMedicalFoodDO::getName, reqVO.getName())
                .eqIfPresent(SpecialMedicalFoodDO::getClassify, reqVO.getClassify())
                .betweenIfPresent(SpecialMedicalFoodDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SpecialMedicalFoodDO::getId));
    }

    default List<SpecialMedicalFoodDO> selectList(SpecialMedicalFoodExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<SpecialMedicalFoodDO>()
                .eqIfPresent(SpecialMedicalFoodDO::getNumber, reqVO.getNumber())
                .likeIfPresent(SpecialMedicalFoodDO::getName, reqVO.getName())
                .eqIfPresent(SpecialMedicalFoodDO::getClassify, reqVO.getClassify())
                .betweenIfPresent(SpecialMedicalFoodDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SpecialMedicalFoodDO::getId));
    }
    default Long findSelectCount(SpecialMedicalFoodDO specialMedicalFoodDO) {
        return selectCount(new LambdaQueryWrapperX<SpecialMedicalFoodDO>()
                .eqIfPresent(SpecialMedicalFoodDO::getNumber, specialMedicalFoodDO.getNumber())
                .eqIfPresent(SpecialMedicalFoodDO::getName, specialMedicalFoodDO.getName())
                .eqIfPresent(SpecialMedicalFoodDO::getClassify, specialMedicalFoodDO.getClassify())
                .notIn(SpecialMedicalFoodDO::getId,specialMedicalFoodDO.getId())
                .orderByDesc(SpecialMedicalFoodDO::getId));
    }

    List<ShelvesSalesRespDo> findSales(ShelvesSalesReqDto shelvesSalesReqDto);

    List<ShelvesSalesRespDo> findSpecifications(ShelvesSalesReqDto shelvesSalesReqDto);

}
