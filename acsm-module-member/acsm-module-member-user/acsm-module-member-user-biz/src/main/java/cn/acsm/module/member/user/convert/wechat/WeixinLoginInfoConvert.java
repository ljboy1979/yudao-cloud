package cn.acsm.module.member.user.convert.wechat;

import java.util.*;

import cn.acsm.module.member.user.controller.admin.wechat.vo.WeixinLoginInfoCreateReqVO;
import cn.acsm.module.member.user.controller.admin.wechat.vo.WeixinLoginInfoExcelVO;
import cn.acsm.module.member.user.controller.admin.wechat.vo.WeixinLoginInfoRespVO;
import cn.acsm.module.member.user.controller.admin.wechat.vo.WeixinLoginInfoUpdateReqVO;
import cn.acsm.module.member.user.dal.dataobject.wechat.WeixinLoginInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 微信登录信息记录 Convert
 *
 * @author lihongyan
 */
@Mapper
public interface WeixinLoginInfoConvert {

    WeixinLoginInfoConvert INSTANCE = Mappers.getMapper(WeixinLoginInfoConvert.class);

    WeixinLoginInfoDO convert(WeixinLoginInfoCreateReqVO bean);

    WeixinLoginInfoDO convert(WeixinLoginInfoUpdateReqVO bean);

    WeixinLoginInfoRespVO convert(WeixinLoginInfoDO bean);

    List<WeixinLoginInfoRespVO> convertList(List<WeixinLoginInfoDO> list);

    PageResult<WeixinLoginInfoRespVO> convertPage(PageResult<WeixinLoginInfoDO> page);

    List<WeixinLoginInfoExcelVO> convertList02(List<WeixinLoginInfoDO> list);

}
