package cn.acsm.module.transaction.sales.controller.admin.dishes;

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

import cn.acsm.module.transaction.sales.controller.admin.dishes.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.dishes.DishesDO;
import cn.acsm.module.transaction.sales.convert.dishes.DishesConvert;
import cn.acsm.module.transaction.sales.service.dishes.DishesService;

@Api(tags = "管理后台 - 菜品")
@RestController
@RequestMapping("/sales/dishes")
@Validated
public class DishesController {

    @Resource
    private DishesService dishesService;

    @PostMapping("/create")
    @ApiOperation("创建菜品")
    @PreAuthorize("@ss.hasPermission('sales:dishes:create')")
    public CommonResult<String> createDishes(@Valid @RequestBody DishesCreateReqVO createReqVO) {
        return success(dishesService.createDishes(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新菜品")
    @PreAuthorize("@ss.hasPermission('sales:dishes:update')")
    public CommonResult<Boolean> updateDishes(@Valid @RequestBody DishesUpdateReqVO updateReqVO) {
        dishesService.updateDishes(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除菜品")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:dishes:delete')")
    public CommonResult<Boolean> deleteDishes(@RequestParam("id") String id) {
        dishesService.deleteDishes(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得菜品")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:dishes:query')")
    public CommonResult<DishesRespVO> getDishes(@RequestParam("id") String id) {
        DishesDO dishes = dishesService.getDishes(id);
        return success(DishesConvert.INSTANCE.convert(dishes));
    }

    @GetMapping("/list")
    @ApiOperation("获得菜品列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('sales:dishes:query')")
    public CommonResult<List<DishesRespVO>> getDishesList(@RequestParam("ids") Collection<String> ids) {
        List<DishesDO> list = dishesService.getDishesList(ids);
        return success(DishesConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得菜品分页")
    @PreAuthorize("@ss.hasPermission('sales:dishes:query')")
    public CommonResult<PageResult<DishesRespVO>> getDishesPage(@Valid DishesPageReqVO pageVO) {
        PageResult<DishesDO> pageResult = dishesService.getDishesPage(pageVO);
        return success(DishesConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出菜品 Excel")
    @PreAuthorize("@ss.hasPermission('sales:dishes:export')")
    @OperateLog(type = EXPORT)
    public void exportDishesExcel(@Valid DishesExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<DishesDO> list = dishesService.getDishesList(exportReqVO);
        // 导出 Excel
        List<DishesExcelVO> datas = DishesConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "菜品.xls", "数据", DishesExcelVO.class, datas);
    }

}
