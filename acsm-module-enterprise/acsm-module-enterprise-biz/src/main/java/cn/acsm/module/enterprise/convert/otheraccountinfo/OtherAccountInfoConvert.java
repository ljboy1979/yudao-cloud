package cn.acsm.module.enterprise.convert.otheraccountinfo;

import java.util.*;

import cn.acsm.module.enterprise.controller.admin.otheraccountinfo.vo.OtherAccountInfoCreateReqVO;
import cn.acsm.module.enterprise.controller.admin.otheraccountinfo.vo.OtherAccountInfoExcelVO;
import cn.acsm.module.enterprise.controller.admin.otheraccountinfo.vo.OtherAccountInfoRespVO;
import cn.acsm.module.enterprise.controller.admin.otheraccountinfo.vo.OtherAccountInfoUpdateReqVO;
import cn.acsm.module.enterprise.dal.dataobject.otheraccountinfo.OtherAccountInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 经营主体其他账户 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface OtherAccountInfoConvert {

    OtherAccountInfoConvert INSTANCE = Mappers.getMapper(OtherAccountInfoConvert.class);

    OtherAccountInfoDO convert(OtherAccountInfoCreateReqVO bean);

    OtherAccountInfoDO convert(OtherAccountInfoUpdateReqVO bean);

    OtherAccountInfoRespVO convert(OtherAccountInfoDO bean);

    List<OtherAccountInfoRespVO> convertList(List<OtherAccountInfoDO> list);

    PageResult<OtherAccountInfoRespVO> convertPage(PageResult<OtherAccountInfoDO> page);

    List< OtherAccountInfoExcelVO > convertList02(List<OtherAccountInfoDO> list);

}
