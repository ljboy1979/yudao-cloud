package cn.acsm.module.production.bases.convert.info;

import java.util.*;

import cn.acsm.module.production.bases.controller.admin.info.vo.InfoCreateReqVO;
import cn.acsm.module.production.bases.controller.admin.info.vo.InfoExcelVO;
import cn.acsm.module.production.bases.controller.admin.info.vo.InfoRespVO;
import cn.acsm.module.production.bases.controller.admin.info.vo.InfoUpdateReqVO;
import cn.acsm.module.production.bases.dal.dataobject.info.InfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.production.bases.controller.admin.info.vo.*;

/**
 * 基地信息 Convert
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

}
