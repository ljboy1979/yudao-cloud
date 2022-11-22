package cn.acsm.module.member.signin.convert.config;

import java.util.*;

import cn.acsm.module.member.signin.controller.admin.config.vo.AuthConfigInfoCreateReqVO;
import cn.acsm.module.member.signin.controller.admin.config.vo.AuthConfigInfoExcelVO;
import cn.acsm.module.member.signin.controller.admin.config.vo.AuthConfigInfoRespVO;
import cn.acsm.module.member.signin.controller.admin.config.vo.AuthConfigInfoUpdateReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.member.signin.dal.dataobject.config.AuthConfigInfoDO;

/**
 * 会员登录授权配置信息 Convert
 *
 * @author lihongyan
 */
@Mapper
public interface AuthConfigInfoConvert {

    AuthConfigInfoConvert INSTANCE = Mappers.getMapper(AuthConfigInfoConvert.class);

    AuthConfigInfoDO convert(AuthConfigInfoCreateReqVO bean);

    AuthConfigInfoDO convert(AuthConfigInfoUpdateReqVO bean);

    AuthConfigInfoRespVO convert(AuthConfigInfoDO bean);

    List<AuthConfigInfoRespVO> convertList(List<AuthConfigInfoDO> list);

    PageResult<AuthConfigInfoRespVO> convertPage(PageResult<AuthConfigInfoDO> page);

    List<AuthConfigInfoExcelVO> convertList02(List<AuthConfigInfoDO> list);

}
