package cn.iocoder.yudao.module.transaction.sales.controller.admin.dishesspecification;

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

import cn.iocoder.yudao.module.transaction.sales.controller.admin.dishesspecification.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.dishesspecification.DishesSpecificationDO;
import cn.iocoder.yudao.module.transaction.sales.convert.dishesspecification.DishesSpecificationConvert;
import cn.iocoder.yudao.module.transaction.sales.service.dishesspecification.DishesSpecificationService;

@Api(tags = "管理后台 - 菜品规格")
@RestController
@RequestMapping("/sales/dishes-specification")
@Validated
public class DishesSpecificationController {

    @Resource
    private DishesSpecificationService dishesSpecificationService;

    @PostMapping("/create")
    @ApiOperation("创建菜品规格")
    @PreAuthorize("@ss.hasPermission('sales:dishes-specification:create')")
    public CommonResult<String> createDishesSpecification(@Valid @RequestBody DishesSpecificationCreateReqVO createReqVO) {
        return success(dishesSpecificationService.createDishesSpecification(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新菜品规格")
    @PreAuthorize("@ss.hasPermission('sales:dishes-specification:update')")
    public CommonResult<Boolean> updateDishesSpecification(@Valid @RequestBody DishesSpecificationUpdateReqVO updateReqVO) {
        dishesSpecificationService.updateDishesSpecification(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除菜品规格")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:dishes-specification:delete')")
    public CommonResult<Boolean> deleteDishesSpecification(@RequestParam("id") String id) {
        dishesSpecificationService.deleteDishesSpecification(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得菜品规格")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:dishes-specification:query')")
    public CommonResult<DishesSpecificationRespVO> getDishesSpecification(@RequestParam("id") String id) {
        DishesSpecificationDO dishesSpecification = dishesSpecificationService.getDishesSpecification(id);
        return success(DishesSpecificationConvert.INSTANCE.convert(dishesSpecification));
    }

    @GetMapping("/list")
    @ApiOperation("获得菜品规格列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('sales:dishes-specification:query')")
    public CommonResult<List<DishesSpecificationRespVO>> getDishesSpecificationList(@RequestParam("ids") Collection<String> ids) {
        List<DishesSpecificationDO> list = dishesSpecificationService.getDishesSpecificationList(ids);
        return success(DishesSpecificationConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得菜品规格分页")
    @PreAuthorize("@ss.hasPermission('sales:dishes-specification:query')")
    public CommonResult<PageResult<DishesSpecificationRespVO>> getDishesSpecificationPage(@Valid DishesSpecificationPageReqVO pageVO) {
        PageResult<DishesSpecificationDO> pageResult = dishesSpecificationService.getDishesSpecificationPage(pageVO);
        return success(DishesSpecificationConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出菜品规格 Excel")
    @PreAuthorize("@ss.hasPermission('sales:dishes-specification:export')")
    @OperateLog(type = EXPORT)
    public void exportDishesSpecificationExcel(@Valid DishesSpecificationExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<DishesSpecificationDO> list = dishesSpecificationService.getDishesSpecificationList(exportReqVO);
        // 导出 Excel
        List<DishesSpecificationExcelVO> datas = DishesSpecificationConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "菜品规格.xls", "数据", DishesSpecificationExcelVO.class, datas);
    }

}
