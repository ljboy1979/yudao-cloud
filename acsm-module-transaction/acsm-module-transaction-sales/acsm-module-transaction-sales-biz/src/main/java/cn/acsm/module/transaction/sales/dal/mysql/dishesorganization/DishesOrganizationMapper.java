package cn.acsm.module.transaction.sales.dal.mysql.dishesorganization;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.sales.dal.dataobject.dishesorganization.DishesOrganizationDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.sales.controller.admin.dishesorganization.vo.*;

/**
 * 菜品组成 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface DishesOrganizationMapper extends BaseMapperX<DishesOrganizationDO> {

    default PageResult<DishesOrganizationDO> selectPage(DishesOrganizationPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<DishesOrganizationDO>()
                .eqIfPresent(DishesOrganizationDO::getOrganizationNumber, reqVO.getOrganizationNumber())
                .likeIfPresent(DishesOrganizationDO::getOrganizationName, reqVO.getOrganizationName())
                .betweenIfPresent(DishesOrganizationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(DishesOrganizationDO::getId));
    }

    default List<DishesOrganizationDO> selectList(DishesOrganizationExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<DishesOrganizationDO>()
                .eqIfPresent(DishesOrganizationDO::getOrganizationNumber, reqVO.getOrganizationNumber())
                .likeIfPresent(DishesOrganizationDO::getOrganizationName, reqVO.getOrganizationName())
                .betweenIfPresent(DishesOrganizationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(DishesOrganizationDO::getId));
    }

}
