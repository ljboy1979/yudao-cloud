package cn.acsm.module.transaction.sales.convert.packageorganization;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.sales.controller.admin.packageorganization.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.packageorganization.PackageOrganizationDO;

/**
 * 套餐组成 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface PackageOrganizationConvert {

    PackageOrganizationConvert INSTANCE = Mappers.getMapper(PackageOrganizationConvert.class);

    PackageOrganizationDO convert(PackageOrganizationCreateReqVO bean);

    PackageOrganizationDO convert(PackageOrganizationUpdateReqVO bean);

    PackageOrganizationRespVO convert(PackageOrganizationDO bean);

    List<PackageOrganizationRespVO> convertList(List<PackageOrganizationDO> list);

    PageResult<PackageOrganizationRespVO> convertPage(PageResult<PackageOrganizationDO> page);

    List<PackageOrganizationExcelVO> convertList02(List<PackageOrganizationDO> list);

}
