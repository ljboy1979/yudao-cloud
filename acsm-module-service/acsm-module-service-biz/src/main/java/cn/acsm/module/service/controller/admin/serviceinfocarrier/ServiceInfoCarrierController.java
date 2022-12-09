package cn.acsm.module.service.controller.admin.serviceinfocarrier;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.*;

import javax.validation.constraints.*;
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

import cn.acsm.module.service.controller.admin.serviceinfocarrier.vo.*;
import cn.acsm.module.service.dal.dataobject.serviceinfocarrier.ServiceInfoCarrierDO;
import cn.acsm.module.service.convert.serviceinfocarrier.ServiceInfoCarrierConvert;
import cn.acsm.module.service.service.serviceinfocarrier.ServiceInfoCarrierService;

@Api(tags = "管理后台 - 服务-认养物/租凭物")
@RestController
@RequestMapping("/service/info-carrier")
@Validated
public class ServiceInfoCarrierController {

    @Resource
    private ServiceInfoCarrierService infoCarrierService;

    @PostMapping("/create")
    @ApiOperation("创建服务-认养物/租凭物")
    @PreAuthorize("@ss.hasPermission('service:info-carrier:create')")
    public CommonResult<Long> createInfoCarrier(@Valid @RequestBody ServiceInfoCarrierCreateReqVO createReqVO) {
        return success(infoCarrierService.createInfoCarrier(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新服务-认养物/租凭物")
    @PreAuthorize("@ss.hasPermission('service:info-carrier:update')")
    public CommonResult<Boolean> updateInfoCarrier(@Valid @RequestBody ServiceInfoCarrierUpdateReqVO updateReqVO) {
        infoCarrierService.updateInfoCarrier(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除服务-认养物/租凭物")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:info-carrier:delete')")
    public CommonResult<Boolean> deleteInfoCarrier(@RequestParam("id") Long id) {
        infoCarrierService.deleteInfoCarrier(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得服务-认养物/租凭物")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:info-carrier:query')")
    public CommonResult<ServiceInfoCarrierRespVO> getInfoCarrier(@RequestParam("id") Long id) {
        ServiceInfoCarrierDO infoCarrier = infoCarrierService.getInfoCarrier(id);
        return success(ServiceInfoCarrierConvert.INSTANCE.convert(infoCarrier));
    }

    @GetMapping("/list")
    @ApiOperation("获得服务-认养物/租凭物列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('service:info-carrier:query')")
    public CommonResult<List<ServiceInfoCarrierRespVO>> getInfoCarrierList(@RequestParam("ids") Collection<Long> ids) {
        List<ServiceInfoCarrierDO> list = infoCarrierService.getInfoCarrierList(ids);
        return success(ServiceInfoCarrierConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得服务-认养物/租凭物分页")
    @PreAuthorize("@ss.hasPermission('service:info-carrier:query')")
    public CommonResult<PageResult<ServiceInfoCarrierRespVO>> getInfoCarrierPage(@Valid ServiceInfoCarrierPageReqVO pageVO) {
        PageResult<ServiceInfoCarrierRespVO> pageResult = infoCarrierService.getInfoCarrierPage(pageVO);
        return success(pageResult);
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出服务-认养物/租凭物 Excel")
    @PreAuthorize("@ss.hasPermission('service:info-carrier:export')")
    @OperateLog(type = EXPORT)
    public void exportInfoCarrierExcel(@Valid ServiceInfoCarrierExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ServiceInfoCarrierDO> list = infoCarrierService.getInfoCarrierList(exportReqVO);
        // 导出 Excel
        List<ServiceInfoCarrierExcelVO> datas = ServiceInfoCarrierConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "服务-认养物/租凭物.xls", "数据", ServiceInfoCarrierExcelVO.class, datas);
    }

}
