package cn.acsm.module.production.bases.convert.subsidy;

import java.util.*;

import cn.acsm.module.production.bases.controller.admin.subsidy.vo.SubsidyCreateReqVO;
import cn.acsm.module.production.bases.controller.admin.subsidy.vo.SubsidyExcelVO;
import cn.acsm.module.production.bases.controller.admin.subsidy.vo.SubsidyRespVO;
import cn.acsm.module.production.bases.controller.admin.subsidy.vo.SubsidyUpdateReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.production.bases.controller.admin.subsidy.vo.*;
import cn.acsm.module.production.bases.dal.dataobject.subsidy.SubsidyDO;

/**
 * 基地补贴信息 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface SubsidyConvert {

    SubsidyConvert INSTANCE = Mappers.getMapper(SubsidyConvert.class);

    SubsidyDO convert(SubsidyCreateReqVO bean);

    SubsidyDO convert(SubsidyUpdateReqVO bean);

    SubsidyRespVO convert(SubsidyDO bean);

    List<SubsidyRespVO> convertList(List<SubsidyDO> list);

    PageResult<SubsidyRespVO> convertPage(PageResult<SubsidyDO> page);

    List<SubsidyExcelVO> convertList02(List<SubsidyDO> list);

}
