package cn.acsm.module.transaction.sales.convert.packageclassify;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.sales.controller.admin.packageclassify.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.packageclassify.PackageClassifyDO;

/**
 * 套餐分类 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface PackageClassifyConvert {

    PackageClassifyConvert INSTANCE = Mappers.getMapper(PackageClassifyConvert.class);

    PackageClassifyDO convert(PackageClassifyCreateReqVO bean);

    PackageClassifyDO convert(PackageClassifyUpdateReqVO bean);

    PackageClassifyRespVO convert(PackageClassifyDO bean);

    List<PackageClassifyRespVO> convertList(List<PackageClassifyDO> list);

    PageResult<PackageClassifyRespVO> convertPage(PageResult<PackageClassifyDO> page);

    List<PackageClassifyExcelVO> convertList02(List<PackageClassifyDO> list);

    static PackageClassifyTreeVO convertListToTree(PackageClassifyDO bean) {
        PackageClassifyTreeVO packageClassifyTreeVO = new PackageClassifyTreeVO();
        packageClassifyTreeVO.setId(Long.valueOf(bean.getId()));
        packageClassifyTreeVO.setName(bean.getCategoryName());
        packageClassifyTreeVO.setParentId(Long.valueOf(bean.getParentCode()));
        packageClassifyTreeVO.setSort(bean.getTreeSort().intValue());
        return packageClassifyTreeVO;
    };
}
