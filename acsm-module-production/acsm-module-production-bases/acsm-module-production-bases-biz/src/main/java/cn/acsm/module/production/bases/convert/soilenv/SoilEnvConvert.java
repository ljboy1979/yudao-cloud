package cn.acsm.module.production.bases.convert.soilenv;

import java.util.*;

import cn.acsm.module.production.bases.controller.admin.soilenv.vo.SoilEnvCreateReqVO;
import cn.acsm.module.production.bases.controller.admin.soilenv.vo.SoilEnvExcelVO;
import cn.acsm.module.production.bases.controller.admin.soilenv.vo.SoilEnvRespVO;
import cn.acsm.module.production.bases.controller.admin.soilenv.vo.SoilEnvUpdateReqVO;
import cn.acsm.module.production.bases.dal.dataobject.soilenv.SoilEnvDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.production.bases.controller.admin.soilenv.vo.*;

/**
 * 基地土壤环境 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface SoilEnvConvert {

    SoilEnvConvert INSTANCE = Mappers.getMapper(SoilEnvConvert.class);

    SoilEnvDO convert(SoilEnvCreateReqVO bean);

    SoilEnvDO convert(SoilEnvUpdateReqVO bean);

    SoilEnvRespVO convert(SoilEnvDO bean);

    List<SoilEnvRespVO> convertList(List<SoilEnvDO> list);

    PageResult<SoilEnvRespVO> convertPage(PageResult<SoilEnvDO> page);

    List<SoilEnvExcelVO> convertList02(List<SoilEnvDO> list);

}
