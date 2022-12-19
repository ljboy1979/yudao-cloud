package cn.acsm.module.production.tunnel.convert.infosoilenv;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.production.tunnel.controller.admin.infosoilenv.vo.*;
import cn.acsm.module.production.tunnel.dal.dataobject.infosoilenv.InfoSoilEnvDO;

/**
 * 地块土壤环境 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface InfoSoilEnvConvert {

    InfoSoilEnvConvert INSTANCE = Mappers.getMapper(InfoSoilEnvConvert.class);

    InfoSoilEnvDO convert(InfoSoilEnvCreateReqVO bean);

    InfoSoilEnvDO convert(InfoSoilEnvUpdateReqVO bean);

    InfoSoilEnvRespVO convert(InfoSoilEnvDO bean);

    List<InfoSoilEnvRespVO> convertList(List<InfoSoilEnvDO> list);

    PageResult<InfoSoilEnvRespVO> convertPage(PageResult<InfoSoilEnvDO> page);

    List<InfoSoilEnvExcelVO> convertList02(List<InfoSoilEnvDO> list);

}
