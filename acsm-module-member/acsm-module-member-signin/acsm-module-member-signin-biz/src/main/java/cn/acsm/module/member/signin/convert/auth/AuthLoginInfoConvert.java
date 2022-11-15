package cn.acsm.module.member.signin.convert.auth;

import java.util.*;

import cn.acsm.module.member.signin.controller.admin.auth.vo.AuthLoginInfoCreateReqVO;
import cn.acsm.module.member.signin.controller.admin.auth.vo.AuthLoginInfoExcelVO;
import cn.acsm.module.member.signin.controller.admin.auth.vo.AuthLoginInfoRespVO;
import cn.acsm.module.member.signin.controller.admin.auth.vo.AuthLoginInfoUpdateReqVO;
import cn.acsm.module.member.signin.dal.dataobject.auth.AuthLoginInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 会员授权登录信息记录 Convert
 *
 * @author lihongyan
 */
@Mapper
public interface AuthLoginInfoConvert {

    AuthLoginInfoConvert INSTANCE = Mappers.getMapper(AuthLoginInfoConvert.class);

    AuthLoginInfoDO convert(AuthLoginInfoCreateReqVO bean);

    AuthLoginInfoDO convert(AuthLoginInfoUpdateReqVO bean);

    AuthLoginInfoRespVO convert(AuthLoginInfoDO bean);

    List<AuthLoginInfoRespVO> convertList(List<AuthLoginInfoDO> list);

    PageResult<AuthLoginInfoRespVO> convertPage(PageResult<AuthLoginInfoDO> page);

    List<AuthLoginInfoExcelVO> convertList02(List<AuthLoginInfoDO> list);

}
