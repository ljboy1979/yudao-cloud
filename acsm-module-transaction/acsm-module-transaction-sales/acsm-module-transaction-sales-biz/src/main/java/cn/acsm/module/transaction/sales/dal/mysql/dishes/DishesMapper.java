package cn.acsm.module.transaction.sales.dal.mysql.dishes;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.sales.dal.dataobject.dishes.DishesDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.sales.controller.admin.dishes.vo.*;

/**
 * 菜品 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface DishesMapper extends BaseMapperX<DishesDO> {

    default PageResult<DishesDO> selectPage(DishesPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<DishesDO>()
                .eqIfPresent(DishesDO::getIngredientNumber, reqVO.getIngredientNumber())
                .likeIfPresent(DishesDO::getDishesName, reqVO.getDishesName())
                .betweenIfPresent(DishesDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(DishesDO::getId));
    }

    default List<DishesDO> selectList(DishesExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<DishesDO>()
                .eqIfPresent(DishesDO::getIngredientNumber, reqVO.getIngredientNumber())
                .likeIfPresent(DishesDO::getDishesName, reqVO.getDishesName())
                .betweenIfPresent(DishesDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(DishesDO::getId));
    }

}
