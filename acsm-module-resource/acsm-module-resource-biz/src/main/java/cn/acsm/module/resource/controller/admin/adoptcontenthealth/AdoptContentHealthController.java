package cn.acsm.module.resource.controller.admin.adoptcontenthealth;

import cn.acsm.module.resource.controller.admin.adoptcontenthealth.vo.*;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.*;

import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.*;

import cn.acsm.module.resource.dal.dataobject.adoptcontenthealth.AdoptContentHealthDO;
import cn.acsm.module.resource.convert.adoptcontenthealth.AdoptContentHealthConvert;
import cn.acsm.module.resource.service.adoptcontenthealth.AdoptContentHealthService;

@Api(tags = "管理后台 - 服务资源-认养物/租凭物就医记录")
@RestController
@RequestMapping("/resource/adopt-content-health")
@Validated
public class AdoptContentHealthController {

    @Resource
    private AdoptContentHealthService adoptContentHealthService;

    @PostMapping("/create")
    @ApiOperation("创建服务资源-认养物/租凭物就医记录")
    @PreAuthorize("@ss.hasPermission('service:adopt-content-health:create')")
    public CommonResult<Long> createAdoptContentHealth(@Valid @RequestBody AdoptContentHealthCreateReqVO createReqVO) {
        return success(adoptContentHealthService.createAdoptContentHealth(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新服务资源-认养物/租凭物就医记录")
    @PreAuthorize("@ss.hasPermission('service:adopt-content-health:update')")
    public CommonResult<Boolean> updateAdoptContentHealth(@Valid @RequestBody AdoptContentHealthUpdateReqVO updateReqVO) {
        adoptContentHealthService.updateAdoptContentHealth(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除服务资源-认养物/租凭物就医记录")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:adopt-content-health:delete')")
    public CommonResult<Boolean> deleteAdoptContentHealth(@RequestParam("id") Long id) {
        adoptContentHealthService.deleteAdoptContentHealth(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得服务资源-认养物/租凭物就医记录")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:adopt-content-health:query')")
    public CommonResult<AdoptContentHealthRespVO> getAdoptContentHealth(@RequestParam("id") Long id) {
        AdoptContentHealthDO adoptContentHealth = adoptContentHealthService.getAdoptContentHealth(id);
        return success(AdoptContentHealthConvert.INSTANCE.convert(adoptContentHealth));
    }

    @GetMapping("/list")
    @ApiOperation("获得服务资源-认养物/租凭物就医记录列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('service:adopt-content-health:query')")
    public CommonResult<List<AdoptContentHealthRespVO>> getAdoptContentHealthList(@RequestParam("ids") Collection<Long> ids) {
        List<AdoptContentHealthDO> list = adoptContentHealthService.getAdoptContentHealthList(ids);
        return success(AdoptContentHealthConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得服务资源-认养物/租凭物就医记录分页")
    @PreAuthorize("@ss.hasPermission('service:adopt-content-health:query')")
    public CommonResult<PageResult<AdoptContentHealthRespVO>> getAdoptContentHealthPage(@Valid AdoptContentHealthPageReqVO pageVO) {
        PageResult<AdoptContentHealthDO> pageResult = adoptContentHealthService.getAdoptContentHealthPage(pageVO);
        return success(AdoptContentHealthConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出服务资源-认养物/租凭物就医记录 Excel")
    @PreAuthorize("@ss.hasPermission('service:adopt-content-health:export')")
    @OperateLog(type = EXPORT)
    public void exportAdoptContentHealthExcel(@Valid AdoptContentHealthExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<AdoptContentHealthDO> list = adoptContentHealthService.getAdoptContentHealthList(exportReqVO);
        // 导出 Excel
        List<AdoptContentHealthExcelVO> datas = AdoptContentHealthConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "服务资源-认养物/租凭物就医记录.xls", "数据", AdoptContentHealthExcelVO.class, datas);
    }

}
