package cn.acsm.module.resource.convert.adoptcontent;

import cn.acsm.module.resource.api.adoptcontent.dto.AdoptContentReqDTO;
import cn.acsm.module.resource.controller.admin.adoptcontent.vo.AdoptContentCreateReqVO;
import cn.acsm.module.resource.controller.admin.adoptcontent.vo.AdoptContentExcelVO;
import cn.acsm.module.resource.controller.admin.adoptcontent.vo.AdoptContentRespVO;
import cn.acsm.module.resource.controller.admin.adoptcontent.vo.AdoptContentUpdateReqVO;
import cn.acsm.module.resource.dal.dataobject.adoptcontent.AdoptContentDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 认养物/租凭物 Convert
 *
 * @author smile
 */
@Mapper
public interface AdoptContentConvert {

    AdoptContentConvert INSTANCE = Mappers.getMapper(AdoptContentConvert.class);

    AdoptContentDO convert(AdoptContentCreateReqVO bean);

    AdoptContentDO convert(AdoptContentUpdateReqVO bean);

    AdoptContentRespVO convert(AdoptContentDO bean);

    List<AdoptContentRespVO> convertList(List<AdoptContentDO> list);

    PageResult<AdoptContentRespVO> convertPage(PageResult<AdoptContentDO> page);

    List<AdoptContentExcelVO> convertList02(List<AdoptContentDO> list);

    AdoptContentReqDTO convert01(AdoptContentDO bean);

    List<AdoptContentReqDTO> convertList01(List<AdoptContentDO> list);

}
