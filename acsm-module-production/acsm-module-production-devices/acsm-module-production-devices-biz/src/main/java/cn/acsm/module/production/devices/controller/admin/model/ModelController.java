package cn.acsm.module.production.devices.controller.admin.model;

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

import cn.acsm.module.production.devices.controller.admin.model.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.model.ModelDO;
import cn.acsm.module.production.devices.convert.model.ModelConvert;
import cn.acsm.module.production.devices.service.model.ModelService;

@Api(tags = "管理后台 - 设备型号")
@RestController
@RequestMapping("/devices/model")
@Validated
public class ModelController {

    @Resource
    private ModelService modelService;

    @PostMapping("/create")
    @ApiOperation("创建设备型号")
    @PreAuthorize("@ss.hasPermission('devices:model:create')")
    public CommonResult<Long> createModel(@Valid @RequestBody ModelCreateReqVO createReqVO) {
        return success(modelService.createModel(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新设备型号")
    @PreAuthorize("@ss.hasPermission('devices:model:update')")
    public CommonResult<Boolean> updateModel(@Valid @RequestBody ModelUpdateReqVO updateReqVO) {
        modelService.updateModel(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除设备型号")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('devices:model:delete')")
    public CommonResult<Boolean> deleteModel(@RequestParam("id") Long id) {
        modelService.deleteModel(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得设备型号")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('devices:model:query')")
    public CommonResult<ModelRespVO> getModel(@RequestParam("id") Long id) {
        ModelDO model = modelService.getModel(id);
        return success(ModelConvert.INSTANCE.convert(model));
    }

    @GetMapping("/list")
    @ApiOperation("获得设备型号列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('devices:model:query')")
    public CommonResult<List<ModelRespVO>> getModelList(@RequestParam("ids") Collection<Long> ids) {
        List<ModelDO> list = modelService.getModelList(ids);
        return success(ModelConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得设备型号分页")
    @PreAuthorize("@ss.hasPermission('devices:model:query')")
    public CommonResult<PageResult<ModelRespVO>> getModelPage(@Valid ModelPageReqVO pageVO) {
        PageResult<ModelDO> pageResult = modelService.getModelPage(pageVO);
        return success(ModelConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出设备型号 Excel")
    @PreAuthorize("@ss.hasPermission('devices:model:export')")
    @OperateLog(type = EXPORT)
    public void exportModelExcel(@Valid ModelExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ModelDO> list = modelService.getModelList(exportReqVO);
        // 导出 Excel
        List<ModelExcelVO> datas = ModelConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "设备型号.xls", "数据", ModelExcelVO.class, datas);
    }

}
