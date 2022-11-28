package cn.acsm.module.member.user.convert.integral;

import java.util.*;

import cn.acsm.module.member.user.controller.admin.integral.vo.record.IntegralRecordCreateReqVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.record.IntegralRecordExcelVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.record.IntegralRecordRespVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.record.IntegralRecordUpdateReqVO;
import cn.acsm.module.member.user.dal.dataobject.integral.IntegralRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 会员积分记录 Convert
 *
 * @author lihongyan
 */
@Mapper
public interface IntegralRecordConvert {

    IntegralRecordConvert INSTANCE = Mappers.getMapper(IntegralRecordConvert.class);

    IntegralRecordDO convert(IntegralRecordCreateReqVO bean);

    IntegralRecordDO convert(IntegralRecordUpdateReqVO bean);

    IntegralRecordRespVO convert(IntegralRecordDO bean);

    List<IntegralRecordRespVO> convertList(List<IntegralRecordDO> list);

    PageResult<IntegralRecordRespVO> convertPage(PageResult<IntegralRecordDO> page);

    List<IntegralRecordExcelVO> convertList02(List<IntegralRecordDO> list);

}
