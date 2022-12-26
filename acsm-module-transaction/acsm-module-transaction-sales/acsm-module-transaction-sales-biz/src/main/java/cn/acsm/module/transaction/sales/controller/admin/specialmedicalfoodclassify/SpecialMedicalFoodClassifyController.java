package cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodclassify;

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

import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodclassify.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.specialmedicalfoodclassify.SpecialMedicalFoodClassifyDO;
import cn.acsm.module.transaction.sales.convert.specialmedicalfoodclassify.SpecialMedicalFoodClassifyConvert;
import cn.acsm.module.transaction.sales.service.specialmedicalfoodclassify.SpecialMedicalFoodClassifyService;

@Api(tags = "管理后台 - 特医食品分类")
@RestController
@RequestMapping("/sales/special-medical-food-classify")
@Validated
public class SpecialMedicalFoodClassifyController {

    @Resource
    private SpecialMedicalFoodClassifyService specialMedicalFoodClassifyService;

    @PostMapping("/create")
    @ApiOperation("创建特医食品分类")
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food-classify:create')")
    public CommonResult<String> createSpecialMedicalFoodClassify(@Valid @RequestBody SpecialMedicalFoodClassifyCreateReqVO createReqVO) {
        return success(specialMedicalFoodClassifyService.createSpecialMedicalFoodClassify(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新特医食品分类")
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food-classify:update')")
    public CommonResult<Boolean> updateSpecialMedicalFoodClassify(@Valid @RequestBody SpecialMedicalFoodClassifyUpdateReqVO updateReqVO) {
        specialMedicalFoodClassifyService.updateSpecialMedicalFoodClassify(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除特医食品分类")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food-classify:delete')")
    public CommonResult<Boolean> deleteSpecialMedicalFoodClassify(@RequestParam("id") String id) {
        specialMedicalFoodClassifyService.deleteSpecialMedicalFoodClassify(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得特医食品分类")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food-classify:query')")
    public CommonResult<SpecialMedicalFoodClassifyRespVO> getSpecialMedicalFoodClassify(@RequestParam("id") String id) {
        SpecialMedicalFoodClassifyDO specialMedicalFoodClassify = specialMedicalFoodClassifyService.getSpecialMedicalFoodClassify(id);
        return success(SpecialMedicalFoodClassifyConvert.INSTANCE.convert(specialMedicalFoodClassify));
    }

    @GetMapping("/list")
    @ApiOperation("获得特医食品分类列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food-classify:query')")
    public CommonResult<List<SpecialMedicalFoodClassifyRespVO>> getSpecialMedicalFoodClassifyList(@RequestParam("ids") Collection<String> ids) {
        List<SpecialMedicalFoodClassifyDO> list = specialMedicalFoodClassifyService.getSpecialMedicalFoodClassifyList(ids);
        return success(SpecialMedicalFoodClassifyConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得特医食品分类分页")
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food-classify:query')")
    public CommonResult<PageResult<SpecialMedicalFoodClassifyRespVO>> getSpecialMedicalFoodClassifyPage(@Valid SpecialMedicalFoodClassifyPageReqVO pageVO) {
        PageResult<SpecialMedicalFoodClassifyDO> pageResult = specialMedicalFoodClassifyService.getSpecialMedicalFoodClassifyPage(pageVO);
        return success(SpecialMedicalFoodClassifyConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出特医食品分类 Excel")
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food-classify:export')")
    @OperateLog(type = EXPORT)
    public void exportSpecialMedicalFoodClassifyExcel(@Valid SpecialMedicalFoodClassifyExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<SpecialMedicalFoodClassifyDO> list = specialMedicalFoodClassifyService.getSpecialMedicalFoodClassifyList(exportReqVO);
        // 导出 Excel
        List<SpecialMedicalFoodClassifyExcelVO> datas = SpecialMedicalFoodClassifyConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "特医食品分类.xls", "数据", SpecialMedicalFoodClassifyExcelVO.class, datas);
    }

    @PostMapping("/treeList")
    @ApiOperation("树形分类列表")
    @PreAuthorize("@ss.hasPermission('sales:raw-material-classify:query')")
    //@Cacheable(value = "/sales/special-medical-food-classify/treeList",key = "#specialMedicalFoodClassifyTreeVO.categoryName")
    public CommonResult<List<TreeSelect>> treeList(@Valid SpecialMedicalFoodClassifyTreeVO specialMedicalFoodClassifyTreeVO) {
        List<TreeSelect> list = specialMedicalFoodClassifyService.findTreeList(specialMedicalFoodClassifyTreeVO);
        return success(list);
    }

}
