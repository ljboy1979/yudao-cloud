package cn.acsm.module.user.user.convert.wechat;

import java.util.*;

import cn.acsm.module.user.user.controller.admin.wechat.vo.WeixinDeployInfoCreateReqVO;
import cn.acsm.module.user.user.controller.admin.wechat.vo.WeixinDeployInfoExcelVO;
import cn.acsm.module.user.user.controller.admin.wechat.vo.WeixinDeployInfoRespVO;
import cn.acsm.module.user.user.controller.admin.wechat.vo.WeixinDeployInfoUpdateReqVO;
import cn.acsm.module.user.user.dal.dataobject.wechat.WeixinDeployInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 微信公众号配置信息 Convert
 *
 * @author lihongyan
 */
@Mapper
public interface WeixinDeployInfoConvert {

    WeixinDeployInfoConvert INSTANCE = Mappers.getMapper(WeixinDeployInfoConvert.class);

    WeixinDeployInfoDO convert(WeixinDeployInfoCreateReqVO bean);

    WeixinDeployInfoDO convert(WeixinDeployInfoUpdateReqVO bean);

    WeixinDeployInfoRespVO convert(WeixinDeployInfoDO bean);

    List<WeixinDeployInfoRespVO> convertList(List<WeixinDeployInfoDO> list);

    PageResult<WeixinDeployInfoRespVO> convertPage(PageResult<WeixinDeployInfoDO> page);

    List<WeixinDeployInfoExcelVO> convertList02(List<WeixinDeployInfoDO> list);

}
