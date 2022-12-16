package cn.acsm.module.production.bases.convert.consume;

import java.util.*;

import cn.acsm.module.production.bases.controller.admin.consume.vo.ConsumeCreateReqVO;
import cn.acsm.module.production.bases.controller.admin.consume.vo.ConsumeExcelVO;
import cn.acsm.module.production.bases.controller.admin.consume.vo.ConsumeRespVO;
import cn.acsm.module.production.bases.controller.admin.consume.vo.ConsumeUpdateReqVO;
import cn.acsm.module.production.bases.dal.dataobject.consume.ConsumeDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.production.bases.controller.admin.consume.vo.*;

/**
 * 基地能耗信息 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ConsumeConvert {

    ConsumeConvert INSTANCE = Mappers.getMapper(ConsumeConvert.class);

    ConsumeDO convert(ConsumeCreateReqVO bean);

    ConsumeDO convert(ConsumeUpdateReqVO bean);

    ConsumeRespVO convert(ConsumeDO bean);

    List<ConsumeRespVO> convertList(List<ConsumeDO> list);

    PageResult<ConsumeRespVO> convertPage(PageResult<ConsumeDO> page);

    List<ConsumeExcelVO> convertList02(List<ConsumeDO> list);

}
