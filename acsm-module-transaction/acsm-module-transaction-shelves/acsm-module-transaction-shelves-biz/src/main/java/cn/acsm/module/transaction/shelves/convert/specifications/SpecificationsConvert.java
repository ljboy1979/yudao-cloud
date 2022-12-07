package cn.acsm.module.transaction.shelves.convert.specifications;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.shelves.controller.admin.specifications.vo.*;
import cn.acsm.module.transaction.shelves.dal.dataobject.specifications.SpecificationsDO;

/**
 * 货架规格 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface SpecificationsConvert {

    SpecificationsConvert INSTANCE = Mappers.getMapper(SpecificationsConvert.class);

    SpecificationsDO convert(SpecificationsCreateReqVO bean);

    SpecificationsDO convert(SpecificationsUpdateReqVO bean);

    SpecificationsRespVO convert(SpecificationsDO bean);

    List<SpecificationsRespVO> convertList(List<SpecificationsDO> list);

    PageResult<SpecificationsRespVO> convertPage(PageResult<SpecificationsDO> page);

    List<SpecificationsExcelVO> convertList02(List<SpecificationsDO> list);

}
