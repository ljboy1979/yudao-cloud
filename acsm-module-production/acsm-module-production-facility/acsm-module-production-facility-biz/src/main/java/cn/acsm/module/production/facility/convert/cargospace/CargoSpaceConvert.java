package cn.acsm.module.production.facility.convert.cargospace;

import cn.acsm.module.production.facility.api.cargospace.dto.CargoSpaceBaseDTO;
import cn.acsm.module.production.facility.controller.admin.cargospace.vo.CargoSpaceCreateReqVO;
import cn.acsm.module.production.facility.controller.admin.cargospace.vo.CargoSpaceExcelVO;
import cn.acsm.module.production.facility.controller.admin.cargospace.vo.CargoSpaceRespVO;
import cn.acsm.module.production.facility.controller.admin.cargospace.vo.CargoSpaceUpdateReqVO;
import cn.acsm.module.production.facility.dal.dataobject.cargospace.CargoSpaceDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 设施货位 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface CargoSpaceConvert {

    CargoSpaceConvert INSTANCE = Mappers.getMapper(CargoSpaceConvert.class);

    CargoSpaceDO convert(CargoSpaceCreateReqVO bean);

    CargoSpaceDO convert(CargoSpaceUpdateReqVO bean);

    CargoSpaceRespVO convert(CargoSpaceDO bean);

    List<CargoSpaceRespVO> convertList(List<CargoSpaceDO> list);

    PageResult<CargoSpaceRespVO> convertPage(PageResult<CargoSpaceDO> page);

    List<CargoSpaceExcelVO> convertList02(List<CargoSpaceDO> list);

    CargoSpaceBaseDTO convert01(CargoSpaceDO bean);

    List<CargoSpaceBaseDTO> convertList03(List<CargoSpaceDO> list);

}
