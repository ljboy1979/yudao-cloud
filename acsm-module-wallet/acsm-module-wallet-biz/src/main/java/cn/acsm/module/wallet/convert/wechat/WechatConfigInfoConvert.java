package cn.acsm.module.wallet.convert.wechat;

import java.util.*;

import cn.acsm.module.wallet.controller.admin.wechat.vo.WechatConfigInfoCreateReqVO;
import cn.acsm.module.wallet.controller.admin.wechat.vo.WechatConfigInfoExcelVO;
import cn.acsm.module.wallet.controller.admin.wechat.vo.WechatConfigInfoRespVO;
import cn.acsm.module.wallet.controller.admin.wechat.vo.WechatConfigInfoUpdateReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.wallet.dal.dataobject.wechat.WechatConfigInfoDO;

/**
 * 微信支付配置信息 Convert
 *
 * @author lihongyan
 */
@Mapper
public interface WechatConfigInfoConvert {

    WechatConfigInfoConvert INSTANCE = Mappers.getMapper(WechatConfigInfoConvert.class);

    WechatConfigInfoDO convert(WechatConfigInfoCreateReqVO bean);

    WechatConfigInfoDO convert(WechatConfigInfoUpdateReqVO bean);

    WechatConfigInfoRespVO convert(WechatConfigInfoDO bean);

    List<WechatConfigInfoRespVO> convertList(List<WechatConfigInfoDO> list);

    PageResult<WechatConfigInfoRespVO> convertPage(PageResult<WechatConfigInfoDO> page);

    List<WechatConfigInfoExcelVO> convertList02(List<WechatConfigInfoDO> list);

}
