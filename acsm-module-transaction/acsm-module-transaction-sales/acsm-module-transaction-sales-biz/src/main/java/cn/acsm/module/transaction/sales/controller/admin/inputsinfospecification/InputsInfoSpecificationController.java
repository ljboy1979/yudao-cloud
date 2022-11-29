package cn.acsm.module.transaction.sales.controller.admin.inputsinfospecification;

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

import cn.acsm.module.transaction.sales.controller.admin.inputsinfospecification.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.inputsinfospecification.InputsInfoSpecificationDO;
import cn.acsm.module.transaction.sales.convert.inputsinfospecification.InputsInfoSpecificationConvert;
import cn.acsm.module.transaction.sales.service.inputsinfospecification.InputsInfoSpecificationService;

@Api(tags = "管理后台 - 投入品规格")
@RestController
@RequestMapping("/sales/inputs-info-specification")
@Validated
public class InputsInfoSpecificationController {

    @Resource
    private InputsInfoSpecificationService inputsInfoSpecificationService;

    @PostMapping("/create")
    @ApiOperation("创建投入品规格")
    @PreAuthorize("@ss.hasPermission('sales:inputs-info-specification:create')")
    public CommonResult<String> createInputsInfoSpecification(@Valid @RequestBody InputsInfoSpecificationCreateReqVO createReqVO) {
        return success(inputsInfoSpecificationService.createInputsInfoSpecification(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新投入品规格")
    @PreAuthorize("@ss.hasPermission('sales:inputs-info-specification:update')")
    public CommonResult<Boolean> updateInputsInfoSpecification(@Valid @RequestBody InputsInfoSpecificationUpdateReqVO updateReqVO) {
        inputsInfoSpecificationService.updateInputsInfoSpecification(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除投入品规格")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:inputs-info-specification:delete')")
    public CommonResult<Boolean> deleteInputsInfoSpecification(@RequestParam("id") String id) {
        inputsInfoSpecificationService.deleteInputsInfoSpecification(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得投入品规格")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:inputs-info-specification:query')")
    public CommonResult<InputsInfoSpecificationRespVO> getInputsInfoSpecification(@RequestParam("id") String id) {
        InputsInfoSpecificationDO inputsInfoSpecification = inputsInfoSpecificationService.getInputsInfoSpecification(id);
        return success(InputsInfoSpecificationConvert.INSTANCE.convert(inputsInfoSpecification));
    }

    @GetMapping("/list")
    @ApiOperation("获得投入品规格列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('sales:inputs-info-specification:query')")
    public CommonResult<List<InputsInfoSpecificationRespVO>> getInputsInfoSpecificationList(@RequestParam("ids") Collection<String> ids) {
        List<InputsInfoSpecificationDO> list = inputsInfoSpecificationService.getInputsInfoSpecificationList(ids);
        return success(InputsInfoSpecificationConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得投入品规格分页")
    @PreAuthorize("@ss.hasPermission('sales:inputs-info-specification:query')")
    public CommonResult<PageResult<InputsInfoSpecificationRespVO>> getInputsInfoSpecificationPage(@Valid InputsInfoSpecificationPageReqVO pageVO) {
        PageResult<InputsInfoSpecificationDO> pageResult = inputsInfoSpecificationService.getInputsInfoSpecificationPage(pageVO);
        return success(InputsInfoSpecificationConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出投入品规格 Excel")
    @PreAuthorize("@ss.hasPermission('sales:inputs-info-specification:export')")
    @OperateLog(type = EXPORT)
    public void exportInputsInfoSpecificationExcel(@Valid InputsInfoSpecificationExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<InputsInfoSpecificationDO> list = inputsInfoSpecificationService.getInputsInfoSpecificationList(exportReqVO);
        // 导出 Excel
        List<InputsInfoSpecificationExcelVO> datas = InputsInfoSpecificationConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "投入品规格.xls", "数据", InputsInfoSpecificationExcelVO.class, datas);
    }

}
