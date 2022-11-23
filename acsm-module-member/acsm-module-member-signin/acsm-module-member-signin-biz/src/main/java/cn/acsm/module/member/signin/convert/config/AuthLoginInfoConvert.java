package cn.acsm.module.member.signin.convert.config;

import cn.acsm.module.member.signin.controller.admin.config.vo.AuthLoginInfoCreateReqVO;
import cn.acsm.module.member.signin.controller.admin.config.vo.AuthLoginInfoExcelVO;
import cn.acsm.module.member.signin.controller.admin.config.vo.AuthLoginInfoRespVO;
import cn.acsm.module.member.signin.controller.admin.config.vo.AuthLoginInfoUpdateReqVO;
import cn.acsm.module.member.signin.dal.dataobject.config.AuthLoginInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

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
