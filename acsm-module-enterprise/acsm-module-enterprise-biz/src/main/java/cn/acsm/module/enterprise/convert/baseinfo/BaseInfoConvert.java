package cn.acsm.module.enterprise.convert.baseinfo;

import java.util.*;

import cn.acsm.module.enterprise.controller.admin.baseinfo.vo.BaseInfoCreateReqVO;
import cn.acsm.module.enterprise.controller.admin.baseinfo.vo.BaseInfoExcelVO;
import cn.acsm.module.enterprise.controller.admin.baseinfo.vo.BaseInfoRespVO;
import cn.acsm.module.enterprise.controller.admin.baseinfo.vo.BaseInfoUpdateReqVO;
import cn.acsm.module.enterprise.dal.dataobject.baseinfo.BaseInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 经营主体 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface BaseInfoConvert {

    BaseInfoConvert INSTANCE = Mappers.getMapper(BaseInfoConvert.class);

    BaseInfoDO convert(BaseInfoCreateReqVO bean);

    BaseInfoDO convert(BaseInfoUpdateReqVO bean);

    BaseInfoRespVO convert(BaseInfoDO bean);

    List<BaseInfoRespVO> convertList(List<BaseInfoDO> list);

    PageResult<BaseInfoRespVO> convertPage(PageResult<BaseInfoDO> page);

    List< BaseInfoExcelVO > convertList02(List<BaseInfoDO> list);

}
