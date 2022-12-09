package cn.acsm.module.service.controller.admin.serviceinfo;

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

import cn.acsm.module.service.controller.admin.serviceinfo.vo.*;
import cn.acsm.module.service.dal.dataobject.serviceinfo.ServiceInfoDO;
import cn.acsm.module.service.convert.serviceinfo.ServiceInfoConvert;
import cn.acsm.module.service.service.serviceinfo.ServiceInfoService;

@Api(tags = "管理后台 - 服务")
@RestController
@RequestMapping("/service/info")
@Validated
public class ServiceInfoController {

    @Resource
    private ServiceInfoService infoService;

    @PostMapping("/create")
    @ApiOperation("创建服务")
    @PreAuthorize("@ss.hasPermission('service:info:create')")
    public CommonResult<Long> createInfo(@Valid @RequestBody ServiceInfoCreateReqVO createReqVO) {
        return success(infoService.createInfo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新服务")
    @PreAuthorize("@ss.hasPermission('service:info:update')")
    public CommonResult<Boolean> updateInfo(@Valid @RequestBody ServiceInfoUpdateReqVO updateReqVO) {
        infoService.updateInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除服务")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:info:delete')")
    public CommonResult<Boolean> deleteInfo(@RequestParam("id") Long id) {
        infoService.deleteInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得服务")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:info:query')")
    public CommonResult<ServiceInfoRespVO> getInfo(@RequestParam("id") Long id) {
        ServiceInfoRespVO info = infoService.getInfo(id);
        return success(info);
    }

    @GetMapping("/list")
    @ApiOperation("获得服务列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('service:info:query')")
    public CommonResult<List<ServiceInfoRespVO>> getInfoList(@RequestParam("ids") Collection<Long> ids) {
        List<ServiceInfoDO> list = infoService.getInfoList(ids);
        return success(ServiceInfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得服务分页")
    @PreAuthorize("@ss.hasPermission('service:info:query')")
    public CommonResult<PageResult<ServiceInfoRespVO>> getInfoPage(@Valid ServiceInfoPageReqVO pageVO) {
        PageResult<ServiceInfoRespVO> pageResult = infoService.getInfoPage(pageVO);
        return success(pageResult);
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出服务 Excel")
    @PreAuthorize("@ss.hasPermission('service:info:export')")
    @OperateLog(type = EXPORT)
    public void exportInfoExcel(@Valid ServiceInfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ServiceInfoDO> list = infoService.getInfoList(exportReqVO);
        // 导出 Excel
        List<ServiceInfoExcelVO> datas = ServiceInfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "服务.xls", "数据", ServiceInfoExcelVO.class, datas);
    }

    @GetMapping("/listAdopt")
    @ApiOperation("获得服务列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    public CommonResult<List<ServiceInfoRespVO>> listAdopt(@RequestParam("ids") Collection<Long> ids) {
        List<ServiceInfoDO> list = infoService.getInfoList(ids);
        return success(ServiceInfoConvert.INSTANCE.convertList(list));
    }

}
