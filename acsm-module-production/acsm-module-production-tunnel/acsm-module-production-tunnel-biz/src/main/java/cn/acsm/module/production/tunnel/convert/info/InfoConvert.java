package cn.acsm.module.production.tunnel.convert.info;

import cn.acsm.module.production.tunnel.api.tunnel.dto.InfoBaseDTO;
import cn.acsm.module.production.tunnel.controller.admin.info.vo.InfoCreateReqVO;
import cn.acsm.module.production.tunnel.controller.admin.info.vo.InfoExcelVO;
import cn.acsm.module.production.tunnel.controller.admin.info.vo.InfoRespVO;
import cn.acsm.module.production.tunnel.controller.admin.info.vo.InfoUpdateReqVO;
import cn.acsm.module.production.tunnel.dal.dataobject.info.InfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 地块信息 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface InfoConvert {

    InfoConvert INSTANCE = Mappers.getMapper(InfoConvert.class);

    InfoDO convert(InfoCreateReqVO bean);

    InfoDO convert(InfoUpdateReqVO bean);

    InfoRespVO convert(InfoDO bean);

    List<InfoRespVO> convertList(List<InfoDO> list);

    PageResult<InfoRespVO> convertPage(PageResult<InfoDO> page);

    List<InfoExcelVO> convertList02(List<InfoDO> list);

    InfoBaseDTO convert01(InfoDO bean);

}
