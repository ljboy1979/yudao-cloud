package cn.acsm.module.production.facility.api.info;

import cn.acsm.module.production.facility.api.info.dto.FacilityInfoDto;
import cn.acsm.module.production.facility.service.info.InfoService;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Validated
public class FacilityInfoApiImpl implements FacilityInfoApi{

    @Resource
    private InfoService infoService;

    public CommonResult<FacilityInfoDto> getFacilityInfoById(@RequestParam("id") Long id) {
        return CommonResult.success(infoService.getFacilityInfoById(id));
    }
}
