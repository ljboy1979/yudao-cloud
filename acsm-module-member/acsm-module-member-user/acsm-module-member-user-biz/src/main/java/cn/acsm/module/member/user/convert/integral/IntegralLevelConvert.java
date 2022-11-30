package cn.acsm.module.member.user.convert.integral;

import cn.acsm.module.member.user.controller.admin.integral.vo.level.IntegralLevelCreateReqVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.level.IntegralLevelExcelVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.level.IntegralLevelRespVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.level.IntegralLevelUpdateReqVO;
import cn.acsm.module.member.user.dal.dataobject.integral.IntegralLevelDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 会员积分等级 Convert
 *
 * @author lihongyan
 */
@Mapper
public interface IntegralLevelConvert {

    IntegralLevelConvert INSTANCE = Mappers.getMapper(IntegralLevelConvert.class);

    IntegralLevelDO convert(IntegralLevelCreateReqVO bean);

    IntegralLevelDO convert(IntegralLevelUpdateReqVO bean);

    IntegralLevelRespVO convert(IntegralLevelDO bean);

    List<IntegralLevelRespVO> convertList(List<IntegralLevelDO> list);

    PageResult<IntegralLevelRespVO> convertPage(PageResult<IntegralLevelDO> page);

    List<IntegralLevelExcelVO> convertList02(List<IntegralLevelDO> list);

}
