package cn.acsm.module.transaction.shelves.controller.admin.shelves;

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

import cn.acsm.module.transaction.shelves.controller.admin.shelves.vo.*;
import cn.acsm.module.transaction.shelves.dal.dataobject.shelves.ShelvesDO;
import cn.acsm.module.transaction.shelves.convert.shelves.ShelvesConvert;
import cn.acsm.module.transaction.shelves.service.shelves.ShelvesService;

@Api(tags = "管理后台 - 货架")
@RestController
@RequestMapping("/shelves/shelves")
@Validated
public class ShelvesController {

    @Resource
    private ShelvesService ShelvesService;

    @PostMapping("/create")
    @ApiOperation("创建货架")
    @PreAuthorize("@ss.hasPermission('shelves:shelves:create')")
    public CommonResult<String> createshelves(@Valid @RequestBody ShelvesCreateReqVO createReqVO) {
        return success(ShelvesService.createShelves(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新货架")
    @PreAuthorize("@ss.hasPermission('shelves:shelves:update')")
    public CommonResult<Boolean> updateshelves(@Valid @RequestBody ShelvesUpdateReqVO updateReqVO) {
        ShelvesService.updateshelves(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除货架")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('shelves:shelves:delete')")
    public CommonResult<Boolean> deleteshelves(@RequestParam("id") String id) {
        ShelvesService.deleteshelves(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得货架")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('shelves:shelves:query')")
    public CommonResult<shelvesRespVO> getshelves(@RequestParam("id") String id) {
        ShelvesDO shelves = ShelvesService.getshelves(id);
        return success(ShelvesConvert.INSTANCE.convert(shelves));
    }

    @GetMapping("/list")
    @ApiOperation("获得货架列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('shelves:shelves:query')")
    public CommonResult<List<shelvesRespVO>> getshelvesList(@RequestParam("ids") Collection<String> ids) {
        List<ShelvesDO> list = ShelvesService.getshelvesList(ids);
        return success(ShelvesConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得货架分页")
    @PreAuthorize("@ss.hasPermission('shelves:shelves:query')")
    public CommonResult<PageResult<shelvesRespVO>> getshelvesPage(@Valid shelvesPageReqVO pageVO) {
        PageResult<ShelvesDO> pageResult = ShelvesService.getshelvesPage(pageVO);
        return success(ShelvesConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出货架 Excel")
    @PreAuthorize("@ss.hasPermission('shelves:shelves:export')")
    @OperateLog(type = EXPORT)
    public void exportshelvesExcel(@Valid ShelvesExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ShelvesDO> list = ShelvesService.getshelvesList(exportReqVO);
        // 导出 Excel
        List<ShelvesExcelVO> datas = ShelvesConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "货架.xls", "数据", ShelvesExcelVO.class, datas);
    }


    @PostMapping("/findShelves")
    @ApiOperation("查询售品")
    @PreAuthorize("@ss.hasPermission('shelves:shelves:query')")
    public CommonResult<List<ShelvesSalesRespVO>> findShelves(@Valid @RequestBody ShelvesReqVO shelvesReqVO) {
        return success(ShelvesService.findShelves(shelvesReqVO));
    }

    @PostMapping("/findSpecifications")
    @ApiOperation("查询售品规格")
    @PreAuthorize("@ss.hasPermission('shelves:shelves:query')")
    public CommonResult<List<ShelvesSalesRespVO>> findSpecifications(@Valid @RequestBody ShelvesReqVO shelvesReqVO) {
        return success(ShelvesService.findSpecifications(shelvesReqVO));
    }
}
