package cn.acsm.module.production.devices.controller.admin.info;

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

import cn.acsm.module.production.devices.controller.admin.info.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.info.InfoDO;
import cn.acsm.module.production.devices.convert.info.InfoConvert;
import cn.acsm.module.production.devices.service.info.InfoService;

@Api(tags = "管理后台 - 设备")
@RestController
@RequestMapping("/devices/info")
@Validated
public class InfoController {

    @Resource
    private InfoService infoService;

    @PostMapping("/create")
    @ApiOperation("创建设备")
    @PreAuthorize("@ss.hasPermission('devices:info:create')")
    public CommonResult<Long> createInfo(@Valid @RequestBody InfoCreateReqVO createReqVO) {
        return success(infoService.createInfo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新设备")
    @PreAuthorize("@ss.hasPermission('devices:info:update')")
    public CommonResult<Boolean> updateInfo(@Valid @RequestBody InfoUpdateReqVO updateReqVO) {
        infoService.updateInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除设备")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('devices:info:delete')")
    public CommonResult<Boolean> deleteInfo(@RequestParam("id") Long id) {
        infoService.deleteInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得设备")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('devices:info:query')")
    public CommonResult<InfoRespVO> getInfo(@RequestParam("id") Long id) {
        InfoDO info = infoService.getInfo(id);
        return success(InfoConvert.INSTANCE.convert(info));
    }

    @GetMapping("/list")
    @ApiOperation("获得设备列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('devices:info:query')")
    public CommonResult<List<InfoRespVO>> getInfoList(@RequestParam("ids") Collection<Long> ids) {
        List<InfoDO> list = infoService.getInfoList(ids);
        return success(InfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得设备分页")
    @PreAuthorize("@ss.hasPermission('devices:info:query')")
    public CommonResult<PageResult<InfoRespVO>> getInfoPage(@Valid InfoPageReqVO pageVO) {
        PageResult<InfoDO> pageResult = infoService.getInfoPage(pageVO);
        return success(InfoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出设备 Excel")
    @PreAuthorize("@ss.hasPermission('devices:info:export')")
    @OperateLog(type = EXPORT)
    public void exportInfoExcel(@Valid InfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<InfoDO> list = infoService.getInfoList(exportReqVO);
        // 导出 Excel
        List<InfoExcelVO> datas = InfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "设备.xls", "数据", InfoExcelVO.class, datas);
    }

}
