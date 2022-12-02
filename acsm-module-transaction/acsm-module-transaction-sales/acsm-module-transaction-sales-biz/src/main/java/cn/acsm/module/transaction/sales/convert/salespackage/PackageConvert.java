package cn.acsm.module.transaction.sales.convert.salespackage;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.sales.controller.admin.salespackage.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.salespackage.PackageDO;

/**
 * 套餐 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface PackageConvert {

    PackageConvert INSTANCE = Mappers.getMapper(PackageConvert.class);

    PackageDO convert(PackageCreateReqVO bean);

    PackageDO convert(PackageUpdateReqVO bean);

    PackageRespVO convert(PackageDO bean);

    List<PackageRespVO> convertList(List<PackageDO> list);

    PageResult<PackageRespVO> convertPage(PageResult<PackageDO> page);

    List<PackageExcelVO> convertList02(List<PackageDO> list);

}
