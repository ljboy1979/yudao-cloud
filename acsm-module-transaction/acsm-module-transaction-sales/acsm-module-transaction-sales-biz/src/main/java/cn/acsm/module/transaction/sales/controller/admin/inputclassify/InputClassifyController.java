package cn.acsm.module.transaction.sales.controller.admin.inputclassify;

import cn.acsm.module.transaction.sales.controller.admin.inputclassify.vo.InputClassifyCreateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.inputclassify.vo.InputClassifyExcelVO;
import cn.acsm.module.transaction.sales.controller.admin.inputclassify.vo.InputClassifyPageReqVO;
import cn.acsm.module.transaction.sales.controller.admin.inputclassify.vo.InputClassifyRespVO;
import cn.acsm.module.transaction.sales.convert.inputclassify.InputClassifyConvert;
import cn.acsm.module.transaction.sales.dal.dataobject.inputclassify.InputClassifyDO;
import cn.acsm.module.transaction.sales.service.inputclassify.InputClassifyService;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeSelect;
import org.springframework.cache.annotation.Cacheable;
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

import cn.acsm.module.transaction.sales.controller.admin.inputclassify.vo.*;

@Api(tags = "管理后台 - 投入品分类")
@RestController
@RequestMapping("/sales/input-classify")
@Validated
public class InputClassifyController {

    @Resource
    private InputClassifyService inputClassifyService;

    @PostMapping("/create")
    @ApiOperation("创建投入品分类")
    @PreAuthorize("@ss.hasPermission('sales:input-classify:create')")
    public CommonResult<String> createInputClassify(@Valid @RequestBody InputClassifyCreateReqVO createReqVO) {
        return inputClassifyService.createInputClassify(createReqVO);
    }

    @PutMapping("/update")
    @ApiOperation("更新投入品分类")
    @PreAuthorize("@ss.hasPermission('sales:input-classify:update')")
    public CommonResult<Boolean> updateInputClassify(@Valid @RequestBody InputClassifyUpdateReqVO updateReqVO) {
        return inputClassifyService.updateInputClassify(updateReqVO);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除投入品分类")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:input-classify:delete')")
    public CommonResult<Boolean> deleteInputClassify(@RequestParam("id") String id) {
        inputClassifyService.deleteInputClassify(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得投入品分类")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:input-classify:query')")
    public CommonResult<InputClassifyRespVO> getInputClassify(@RequestParam("id") String id) {
        InputClassifyDO inputClassify = inputClassifyService.getInputClassify(id);
        return success(InputClassifyConvert.INSTANCE.convert(inputClassify));
    }

    @GetMapping("/list")
    @ApiOperation("获得投入品分类列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('sales:input-classify:query')")
    public CommonResult<List<InputClassifyRespVO>> getInputClassifyList(@RequestParam("ids") Collection<String> ids) {
        List<InputClassifyDO> list = inputClassifyService.getInputClassifyList(ids);
        return success(InputClassifyConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得投入品分类分页")
    @PreAuthorize("@ss.hasPermission('sales:input-classify:query')")
    public CommonResult<PageResult<InputClassifyRespVO>> getInputClassifyPage(@Valid InputClassifyPageReqVO pageVO) {
        PageResult<InputClassifyDO> pageResult = inputClassifyService.getInputClassifyPage(pageVO);
        return success(InputClassifyConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出投入品分类 Excel")
    @PreAuthorize("@ss.hasPermission('sales:input-classify:export')")
    @OperateLog(type = EXPORT)
    public void exportInputClassifyExcel(@Valid InputClassifyExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<InputClassifyDO> list = inputClassifyService.getInputClassifyList(exportReqVO);
        // 导出 Excel
        List<InputClassifyExcelVO> datas = InputClassifyConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "投入品分类.xls", "数据", InputClassifyExcelVO.class, datas);
    }

    @PostMapping("/treeList")
    @ApiOperation("树形分类列表")
    @PreAuthorize("@ss.hasPermission('sales:input-classify:query')")
    //@Cacheable(value = "/sales/input-classify/treeList",key = "#inputClassifyTreeVO.categoryName")
    public CommonResult<List<TreeSelect>> treeList(@Valid InputClassifyTreeVO inputClassifyTreeVO) {
        List<TreeSelect> list = inputClassifyService.findTreeList(inputClassifyTreeVO);
        return success(list);
    }
}
