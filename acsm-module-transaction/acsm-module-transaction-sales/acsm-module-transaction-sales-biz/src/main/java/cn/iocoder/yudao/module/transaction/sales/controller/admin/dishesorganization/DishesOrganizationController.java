package cn.iocoder.yudao.module.transaction.sales.controller.admin.dishesorganization;

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

import cn.iocoder.yudao.module.transaction.sales.controller.admin.dishesorganization.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.dishesorganization.DishesOrganizationDO;
import cn.iocoder.yudao.module.transaction.sales.convert.dishesorganization.DishesOrganizationConvert;
import cn.iocoder.yudao.module.transaction.sales.service.dishesorganization.DishesOrganizationService;

@Api(tags = "管理后台 - 菜品组成")
@RestController
@RequestMapping("/sales/dishes-organization")
@Validated
public class DishesOrganizationController {

    @Resource
    private DishesOrganizationService dishesOrganizationService;

    @PostMapping("/create")
    @ApiOperation("创建菜品组成")
    @PreAuthorize("@ss.hasPermission('sales:dishes-organization:create')")
    public CommonResult<String> createDishesOrganization(@Valid @RequestBody DishesOrganizationCreateReqVO createReqVO) {
        return success(dishesOrganizationService.createDishesOrganization(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新菜品组成")
    @PreAuthorize("@ss.hasPermission('sales:dishes-organization:update')")
    public CommonResult<Boolean> updateDishesOrganization(@Valid @RequestBody DishesOrganizationUpdateReqVO updateReqVO) {
        dishesOrganizationService.updateDishesOrganization(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除菜品组成")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:dishes-organization:delete')")
    public CommonResult<Boolean> deleteDishesOrganization(@RequestParam("id") String id) {
        dishesOrganizationService.deleteDishesOrganization(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得菜品组成")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:dishes-organization:query')")
    public CommonResult<DishesOrganizationRespVO> getDishesOrganization(@RequestParam("id") String id) {
        DishesOrganizationDO dishesOrganization = dishesOrganizationService.getDishesOrganization(id);
        return success(DishesOrganizationConvert.INSTANCE.convert(dishesOrganization));
    }

    @GetMapping("/list")
    @ApiOperation("获得菜品组成列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('sales:dishes-organization:query')")
    public CommonResult<List<DishesOrganizationRespVO>> getDishesOrganizationList(@RequestParam("ids") Collection<String> ids) {
        List<DishesOrganizationDO> list = dishesOrganizationService.getDishesOrganizationList(ids);
        return success(DishesOrganizationConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得菜品组成分页")
    @PreAuthorize("@ss.hasPermission('sales:dishes-organization:query')")
    public CommonResult<PageResult<DishesOrganizationRespVO>> getDishesOrganizationPage(@Valid DishesOrganizationPageReqVO pageVO) {
        PageResult<DishesOrganizationDO> pageResult = dishesOrganizationService.getDishesOrganizationPage(pageVO);
        return success(DishesOrganizationConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出菜品组成 Excel")
    @PreAuthorize("@ss.hasPermission('sales:dishes-organization:export')")
    @OperateLog(type = EXPORT)
    public void exportDishesOrganizationExcel(@Valid DishesOrganizationExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<DishesOrganizationDO> list = dishesOrganizationService.getDishesOrganizationList(exportReqVO);
        // 导出 Excel
        List<DishesOrganizationExcelVO> datas = DishesOrganizationConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "菜品组成.xls", "数据", DishesOrganizationExcelVO.class, datas);
    }

}
