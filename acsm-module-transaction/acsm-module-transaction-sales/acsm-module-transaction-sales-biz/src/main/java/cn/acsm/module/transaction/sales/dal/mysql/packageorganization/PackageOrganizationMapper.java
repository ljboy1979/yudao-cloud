package cn.acsm.module.transaction.sales.dal.mysql.packageorganization;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.sales.dal.dataobject.packageorganization.PackageOrganizationDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.sales.controller.admin.packageorganization.vo.*;

/**
 * 套餐组成 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface PackageOrganizationMapper extends BaseMapperX<PackageOrganizationDO> {

    default PageResult<PackageOrganizationDO> selectPage(PackageOrganizationPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PackageOrganizationDO>()
                .eqIfPresent(PackageOrganizationDO::getPackageId, reqVO.getPackageId())
                .eqIfPresent(PackageOrganizationDO::getType, reqVO.getType())
                .eqIfPresent(PackageOrganizationDO::getOrganizationNumber, reqVO.getOrganizationNumber())
                .betweenIfPresent(PackageOrganizationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PackageOrganizationDO::getId));
    }

    default List<PackageOrganizationDO> selectList(PackageOrganizationExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<PackageOrganizationDO>()
                .eqIfPresent(PackageOrganizationDO::getPackageId, reqVO.getPackageId())
                .eqIfPresent(PackageOrganizationDO::getType, reqVO.getType())
                .betweenIfPresent(PackageOrganizationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PackageOrganizationDO::getId));
    }

    default Long findSelectCount(PackageOrganizationDO packageOrganizationDO) {
        return selectCount(new LambdaQueryWrapperX<PackageOrganizationDO>()
                .eqIfPresent(PackageOrganizationDO::getPackageId, packageOrganizationDO.getPackageId())
                .eqIfPresent(PackageOrganizationDO::getType, packageOrganizationDO.getType())
                .eqIfPresent(PackageOrganizationDO::getSourceId, packageOrganizationDO.getSourceId())
                .eqIfPresent(PackageOrganizationDO::getSpecificationId, packageOrganizationDO.getSpecificationId())
                .eqIfPresent(PackageOrganizationDO::getClassify, packageOrganizationDO.getClassify())
                .notIn(PackageOrganizationDO::getId, packageOrganizationDO.getId())
                .orderByDesc(PackageOrganizationDO::getId));
    }


}
