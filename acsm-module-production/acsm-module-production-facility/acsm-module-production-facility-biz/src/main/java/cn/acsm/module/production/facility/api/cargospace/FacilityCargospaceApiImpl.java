package cn.acsm.module.production.facility.api.cargospace;

import cn.acsm.module.production.facility.api.cargospace.dto.CargoSpaceBaseDTO;
import cn.acsm.module.production.facility.service.cargospace.CargoSpaceServiceImpl;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@Validated
public class FacilityCargospaceApiImpl implements FacilityCargospaceApi{


    @Resource
    private CargoSpaceServiceImpl cargoSpaceService;

    public CommonResult<CargoSpaceBaseDTO> getById( Long id) {

        return CommonResult.success(cargoSpaceService.getById(id));
    }


    public CommonResult<List<CargoSpaceBaseDTO>> findListByFacilityId(Long fid) {
        return CommonResult.success(cargoSpaceService.findListByFacilityId(fid));
    }

    public CommonResult<List<CargoSpaceBaseDTO>> findListByCode( String code) {
        return CommonResult.success(cargoSpaceService.findListByCode(code));
    }
}
