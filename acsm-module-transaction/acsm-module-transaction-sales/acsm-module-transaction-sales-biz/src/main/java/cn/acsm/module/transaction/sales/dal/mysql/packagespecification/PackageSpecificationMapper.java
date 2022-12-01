package cn.acsm.module.transaction.sales.dal.mysql.packagespecification;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.sales.dal.dataobject.packagespecification.PackageSpecificationDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.sales.controller.admin.packagespecification.vo.*;

/**
 * 套餐规格 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface PackageSpecificationMapper extends BaseMapperX<PackageSpecificationDO> {

    default PageResult<PackageSpecificationDO> selectPage(PackageSpecificationPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PackageSpecificationDO>()
                .likeIfPresent(PackageSpecificationDO::getSpecificationsName, reqVO.getSpecificationsName())
                .betweenIfPresent(PackageSpecificationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PackageSpecificationDO::getId));
    }

    default List<PackageSpecificationDO> selectList(PackageSpecificationExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<PackageSpecificationDO>()
                .likeIfPresent(PackageSpecificationDO::getSpecificationsName, reqVO.getSpecificationsName())
                .betweenIfPresent(PackageSpecificationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PackageSpecificationDO::getId));
    }

    default Long findSelectCount(PackageSpecificationDO packageSpecificationDO) {
        return selectCount(new LambdaQueryWrapperX<PackageSpecificationDO>()
                .eqIfPresent(PackageSpecificationDO::getSpecificationsName, packageSpecificationDO.getSpecificationsName())
                .eqIfPresent(PackageSpecificationDO::getPackageId, packageSpecificationDO.getPackageId())
                .notIn(PackageSpecificationDO::getId, packageSpecificationDO.getId())
                .orderByDesc(PackageSpecificationDO::getId));
    }

}
