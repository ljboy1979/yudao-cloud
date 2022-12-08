package cn.acsm.module.transaction.order.convert.giftinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.order.controller.admin.giftinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.giftinfo.GiftInfoDO;

/**
 * 赠品 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface GiftInfoConvert {

    GiftInfoConvert INSTANCE = Mappers.getMapper(GiftInfoConvert.class);

    GiftInfoDO convert(GiftInfoCreateReqVO bean);

    GiftInfoDO convert(GiftInfoUpdateReqVO bean);

    GiftInfoRespVO convert(GiftInfoDO bean);

    List<GiftInfoRespVO> convertList(List<GiftInfoDO> list);

    PageResult<GiftInfoRespVO> convertPage(PageResult<GiftInfoDO> page);

    List<GiftInfoExcelVO> convertList02(List<GiftInfoDO> list);

}
