package cn.acsm.module.transaction.sales.convert.packagespecification;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.sales.controller.admin.packagespecification.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.packagespecification.PackageSpecificationDO;

/**
 * 套餐规格 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface PackageSpecificationConvert {

    PackageSpecificationConvert INSTANCE = Mappers.getMapper(PackageSpecificationConvert.class);

    PackageSpecificationDO convert(PackageSpecificationCreateReqVO bean);

    PackageSpecificationDO convert(PackageSpecificationUpdateReqVO bean);

    PackageSpecificationRespVO convert(PackageSpecificationDO bean);

    List<PackageSpecificationRespVO> convertList(List<PackageSpecificationDO> list);

    PageResult<PackageSpecificationRespVO> convertPage(PageResult<PackageSpecificationDO> page);

    List<PackageSpecificationExcelVO> convertList02(List<PackageSpecificationDO> list);

}
