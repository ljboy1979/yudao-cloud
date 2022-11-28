package cn.iocoder.yudao.module.transaction.sales.controller.admin.inputsinfo;

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

import cn.iocoder.yudao.module.transaction.sales.controller.admin.inputsinfo.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.inputsinfo.InputsInfoDO;
import cn.iocoder.yudao.module.transaction.sales.convert.inputsinfo.InputsInfoConvert;
import cn.iocoder.yudao.module.transaction.sales.service.inputsinfo.InputsInfoService;

@Api(tags = "管理后台 - 投入品")
@RestController
@RequestMapping("/sales/inputs-info")
@Validated
public class InputsInfoController {

    @Resource
    private InputsInfoService inputsInfoService;

    @PostMapping("/create")
    @ApiOperation("创建投入品")
    @PreAuthorize("@ss.hasPermission('sales:inputs-info:create')")
    public CommonResult<String> createInputsInfo(@Valid @RequestBody InputsInfoCreateReqVO createReqVO) {
        return success(inputsInfoService.createInputsInfo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新投入品")
    @PreAuthorize("@ss.hasPermission('sales:inputs-info:update')")
    public CommonResult<Boolean> updateInputsInfo(@Valid @RequestBody InputsInfoUpdateReqVO updateReqVO) {
        inputsInfoService.updateInputsInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除投入品")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:inputs-info:delete')")
    public CommonResult<Boolean> deleteInputsInfo(@RequestParam("id") String id) {
        inputsInfoService.deleteInputsInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得投入品")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:inputs-info:query')")
    public CommonResult<InputsInfoRespVO> getInputsInfo(@RequestParam("id") String id) {
        InputsInfoDO inputsInfo = inputsInfoService.getInputsInfo(id);
        return success(InputsInfoConvert.INSTANCE.convert(inputsInfo));
    }

    @GetMapping("/list")
    @ApiOperation("获得投入品列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('sales:inputs-info:query')")
    public CommonResult<List<InputsInfoRespVO>> getInputsInfoList(@RequestParam("ids") Collection<String> ids) {
        List<InputsInfoDO> list = inputsInfoService.getInputsInfoList(ids);
        return success(InputsInfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得投入品分页")
    @PreAuthorize("@ss.hasPermission('sales:inputs-info:query')")
    public CommonResult<PageResult<InputsInfoRespVO>> getInputsInfoPage(@Valid InputsInfoPageReqVO pageVO) {
        PageResult<InputsInfoDO> pageResult = inputsInfoService.getInputsInfoPage(pageVO);
        return success(InputsInfoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出投入品 Excel")
    @PreAuthorize("@ss.hasPermission('sales:inputs-info:export')")
    @OperateLog(type = EXPORT)
    public void exportInputsInfoExcel(@Valid InputsInfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<InputsInfoDO> list = inputsInfoService.getInputsInfoList(exportReqVO);
        // 导出 Excel
        List<InputsInfoExcelVO> datas = InputsInfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "投入品.xls", "数据", InputsInfoExcelVO.class, datas);
    }

}
