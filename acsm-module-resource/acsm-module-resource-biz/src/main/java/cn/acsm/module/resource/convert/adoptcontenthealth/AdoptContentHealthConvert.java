package cn.acsm.module.resource.convert.adoptcontenthealth;

import cn.acsm.module.resource.controller.admin.adoptcontenthealth.vo.AdoptContentHealthCreateReqVO;
import cn.acsm.module.resource.controller.admin.adoptcontenthealth.vo.AdoptContentHealthExcelVO;
import cn.acsm.module.resource.controller.admin.adoptcontenthealth.vo.AdoptContentHealthRespVO;
import cn.acsm.module.resource.controller.admin.adoptcontenthealth.vo.AdoptContentHealthUpdateReqVO;
import cn.acsm.module.resource.dal.dataobject.adoptcontenthealth.AdoptContentHealthDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 服务资源-认养物/租凭物就医记录 Convert
 *
 * @author smile
 */
@Mapper
public interface AdoptContentHealthConvert {

    AdoptContentHealthConvert INSTANCE = Mappers.getMapper(AdoptContentHealthConvert.class);

    AdoptContentHealthDO convert(AdoptContentHealthCreateReqVO bean);

    AdoptContentHealthDO convert(AdoptContentHealthUpdateReqVO bean);

    AdoptContentHealthRespVO convert(AdoptContentHealthDO bean);

    List<AdoptContentHealthRespVO> convertList(List<AdoptContentHealthDO> list);

    PageResult<AdoptContentHealthRespVO> convertPage(PageResult<AdoptContentHealthDO> page);

    List<AdoptContentHealthExcelVO> convertList02(List<AdoptContentHealthDO> list);

}
