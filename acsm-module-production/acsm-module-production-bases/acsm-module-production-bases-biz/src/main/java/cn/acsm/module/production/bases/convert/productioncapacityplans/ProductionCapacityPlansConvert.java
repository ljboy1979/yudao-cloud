package cn.acsm.module.production.bases.convert.productioncapacityplans;

import java.util.*;

import cn.acsm.module.production.bases.controller.admin.productioncapacityplans.vo.ProductionCapacityPlansCreateReqVO;
import cn.acsm.module.production.bases.controller.admin.productioncapacityplans.vo.ProductionCapacityPlansExcelVO;
import cn.acsm.module.production.bases.controller.admin.productioncapacityplans.vo.ProductionCapacityPlansRespVO;
import cn.acsm.module.production.bases.controller.admin.productioncapacityplans.vo.ProductionCapacityPlansUpdateReqVO;
import cn.acsm.module.production.bases.dal.dataobject.productioncapacityplans.ProductionCapacityPlansDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.production.bases.controller.admin.productioncapacityplans.vo.*;

/**
 * 产能计划 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ProductionCapacityPlansConvert {

    ProductionCapacityPlansConvert INSTANCE = Mappers.getMapper(ProductionCapacityPlansConvert.class);

    ProductionCapacityPlansDO convert(ProductionCapacityPlansCreateReqVO bean);

    ProductionCapacityPlansDO convert(ProductionCapacityPlansUpdateReqVO bean);

    ProductionCapacityPlansRespVO convert(ProductionCapacityPlansDO bean);

    List<ProductionCapacityPlansRespVO> convertList(List<ProductionCapacityPlansDO> list);

    PageResult<ProductionCapacityPlansRespVO> convertPage(PageResult<ProductionCapacityPlansDO> page);

    List<ProductionCapacityPlansExcelVO> convertList02(List<ProductionCapacityPlansDO> list);

}
