package cn.acsm.module.transaction.shelves.dal.mysql.specifications;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.shelves.dal.dataobject.specifications.SpecificationsDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.shelves.controller.admin.specifications.vo.*;

/**
 * 货架规格 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface SpecificationsMapper extends BaseMapperX<SpecificationsDO> {

    default PageResult<SpecificationsDO> selectPage(SpecificationsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SpecificationsDO>()
                .likeIfPresent(SpecificationsDO::getSpecificationsName, reqVO.getSpecificationsName())
                .eqIfPresent(SpecificationsDO::getPackagingType, reqVO.getPackagingType())
                .eqIfPresent(SpecificationsDO::getShelvesId, reqVO.getShelvesId())
                .betweenIfPresent(SpecificationsDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SpecificationsDO::getId));
    }

    default List<SpecificationsDO> selectList(SpecificationsExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<SpecificationsDO>()
                .likeIfPresent(SpecificationsDO::getSpecificationsName, reqVO.getSpecificationsName())
                .eqIfPresent(SpecificationsDO::getPackagingType, reqVO.getPackagingType())
                .betweenIfPresent(SpecificationsDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SpecificationsDO::getId));
    }

    default List<SpecificationsDO> findSpecifications(SpecificationsPageReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<SpecificationsDO>()
                .likeIfPresent(SpecificationsDO::getSpecificationsName, reqVO.getSpecificationsName())
                .eqIfPresent(SpecificationsDO::getPackagingType, reqVO.getPackagingType())
                .eqIfPresent(SpecificationsDO::getShelvesId, reqVO.getShelvesId())
                .betweenIfPresent(SpecificationsDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SpecificationsDO::getId));
    }
}
