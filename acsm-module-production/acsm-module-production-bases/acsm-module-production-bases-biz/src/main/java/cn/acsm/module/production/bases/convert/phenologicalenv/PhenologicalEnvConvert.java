package cn.acsm.module.production.bases.convert.phenologicalenv;

import java.util.*;

import cn.acsm.module.production.bases.controller.admin.phenologicalenv.vo.PhenologicalEnvCreateReqVO;
import cn.acsm.module.production.bases.controller.admin.phenologicalenv.vo.PhenologicalEnvExcelVO;
import cn.acsm.module.production.bases.controller.admin.phenologicalenv.vo.PhenologicalEnvRespVO;
import cn.acsm.module.production.bases.controller.admin.phenologicalenv.vo.PhenologicalEnvUpdateReqVO;
import cn.acsm.module.production.bases.dal.dataobject.phenologicalenv.PhenologicalEnvDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.production.bases.controller.admin.phenologicalenv.vo.*;

/**
 * 基地物候环境 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface PhenologicalEnvConvert {

    PhenologicalEnvConvert INSTANCE = Mappers.getMapper(PhenologicalEnvConvert.class);

    PhenologicalEnvDO convert(PhenologicalEnvCreateReqVO bean);

    PhenologicalEnvDO convert(PhenologicalEnvUpdateReqVO bean);

    PhenologicalEnvRespVO convert(PhenologicalEnvDO bean);

    List<PhenologicalEnvRespVO> convertList(List<PhenologicalEnvDO> list);

    PageResult<PhenologicalEnvRespVO> convertPage(PageResult<PhenologicalEnvDO> page);

    List<PhenologicalEnvExcelVO> convertList02(List<PhenologicalEnvDO> list);

}
