package cn.acsm.module.resource.convert.adoptright;

import cn.acsm.module.resource.controller.admin.adoptright.vo.AdoptRightCreateReqVO;
import cn.acsm.module.resource.controller.admin.adoptright.vo.AdoptRightExcelVO;
import cn.acsm.module.resource.controller.admin.adoptright.vo.AdoptRightRespVO;
import cn.acsm.module.resource.controller.admin.adoptright.vo.AdoptRightUpdateReqVO;
import cn.acsm.module.resource.dal.dataobject.adoptright.AdoptRightDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 认养/租凭权益 Convert
 *
 * @author smile
 */
@Mapper
public interface AdoptRightConvert {

    AdoptRightConvert INSTANCE = Mappers.getMapper(AdoptRightConvert.class);

    AdoptRightDO convert(AdoptRightCreateReqVO bean);

    AdoptRightDO convert(AdoptRightUpdateReqVO bean);

    AdoptRightRespVO convert(AdoptRightDO bean);

    List<AdoptRightRespVO> convertList(List<AdoptRightDO> list);

    PageResult<AdoptRightRespVO> convertPage(PageResult<AdoptRightDO> page);

    List<AdoptRightExcelVO> convertList02(List<AdoptRightDO> list);

}
