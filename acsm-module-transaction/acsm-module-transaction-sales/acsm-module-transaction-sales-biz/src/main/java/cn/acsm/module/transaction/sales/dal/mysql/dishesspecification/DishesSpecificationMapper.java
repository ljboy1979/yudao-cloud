package cn.acsm.module.transaction.sales.dal.mysql.dishesspecification;

import java.util.*;

import cn.acsm.module.transaction.sales.controller.admin.dishesspecification.vo.DishesSpecificationExportReqVO;
import cn.acsm.module.transaction.sales.controller.admin.dishesspecification.vo.DishesSpecificationPageReqVO;
import cn.acsm.module.transaction.sales.dal.dataobject.dishesspecification.DishesSpecificationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.sales.dal.dataobject.dishesspecification.DishesSpecificationDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.sales.controller.admin.dishesspecification.vo.*;

/**
 * 菜品规格 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface DishesSpecificationMapper extends BaseMapperX<DishesSpecificationDO> {

    default PageResult<DishesSpecificationDO> selectPage(DishesSpecificationPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<DishesSpecificationDO>()
                .likeIfPresent(DishesSpecificationDO::getSpecificationsName, reqVO.getSpecificationsName())
                .orderByDesc(DishesSpecificationDO::getId));
    }

    default List<DishesSpecificationDO> selectList(DishesSpecificationExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<DishesSpecificationDO>()
                .likeIfPresent(DishesSpecificationDO::getSpecificationsName, reqVO.getSpecificationsName())
                .orderByDesc(DishesSpecificationDO::getId));
    }

}
