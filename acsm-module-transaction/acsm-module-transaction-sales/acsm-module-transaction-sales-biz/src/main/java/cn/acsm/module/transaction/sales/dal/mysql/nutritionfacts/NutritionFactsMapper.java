package cn.acsm.module.transaction.sales.dal.mysql.nutritionfacts;

import cn.acsm.module.transaction.sales.controller.admin.nutritionfacts.vo.NutritionFactsExportReqVO;
import cn.acsm.module.transaction.sales.controller.admin.nutritionfacts.vo.NutritionFactsPageReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.sales.dal.dataobject.nutritionfacts.NutritionFactsDO;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 营养成分 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface NutritionFactsMapper extends BaseMapperX<NutritionFactsDO> {
    default PageResult<NutritionFactsDO> selectPage(NutritionFactsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<NutritionFactsDO>()
                .eqIfPresent(NutritionFactsDO::getType, reqVO.getType())
                .eqIfPresent(NutritionFactsDO::getSourceId, reqVO.getSourceId())
                .eqIfPresent(NutritionFactsDO::getNumber, reqVO.getNumber())
                .eqIfPresent(NutritionFactsDO::getNutritionFacts, reqVO.getNutritionFacts())
                .likeIfPresent(NutritionFactsDO::getNutritionFactsName, reqVO.getNutritionFactsName())
                .betweenIfPresent(NutritionFactsDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(NutritionFactsDO::getId));
    }

    default List<NutritionFactsDO> selectList(NutritionFactsExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<NutritionFactsDO>()
                .eqIfPresent(NutritionFactsDO::getType, reqVO.getType())
                .eqIfPresent(NutritionFactsDO::getSourceId, reqVO.getSourceId())
                .eqIfPresent(NutritionFactsDO::getNumber, reqVO.getNumber())
                .eqIfPresent(NutritionFactsDO::getNutritionFacts, reqVO.getNutritionFacts())
                .likeIfPresent(NutritionFactsDO::getNutritionFactsName, reqVO.getNutritionFactsName())
                .eqIfPresent(NutritionFactsDO::getContent, reqVO.getContent())
                .eqIfPresent(NutritionFactsDO::getUnit, reqVO.getUnit())
                .likeIfPresent(NutritionFactsDO::getUnitName, reqVO.getUnitName())
                .eqIfPresent(NutritionFactsDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(NutritionFactsDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(NutritionFactsDO::getId));
    }

}
