package cn.acsm.module.production.tunnel.controller.admin.costbook;

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

import cn.acsm.module.production.tunnel.controller.admin.costbook.vo.*;
import cn.acsm.module.production.tunnel.dal.dataobject.costbook.CostBookDO;
import cn.acsm.module.production.tunnel.convert.costbook.CostBookConvert;
import cn.acsm.module.production.tunnel.service.costbook.CostBookService;

@Api(tags = "管理后台 - 地块账本")
@RestController
@RequestMapping("/tunnel/cost-book")
@Validated
public class CostBookController {

    @Resource
    private CostBookService costBookService;

    @PostMapping("/create")
    @ApiOperation("创建地块账本")
    @PreAuthorize("@ss.hasPermission('tunnel:cost-book:create')")
    public CommonResult<Long> createCostBook(@Valid @RequestBody CostBookCreateReqVO createReqVO) {
        return success(costBookService.createCostBook(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新地块账本")
    @PreAuthorize("@ss.hasPermission('tunnel:cost-book:update')")
    public CommonResult<Boolean> updateCostBook(@Valid @RequestBody CostBookUpdateReqVO updateReqVO) {
        costBookService.updateCostBook(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除地块账本")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('tunnel:cost-book:delete')")
    public CommonResult<Boolean> deleteCostBook(@RequestParam("id") Long id) {
        costBookService.deleteCostBook(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得地块账本")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('tunnel:cost-book:query')")
    public CommonResult<CostBookRespVO> getCostBook(@RequestParam("id") Long id) {
        CostBookDO costBook = costBookService.getCostBook(id);
        return success(CostBookConvert.INSTANCE.convert(costBook));
    }

    @GetMapping("/list")
    @ApiOperation("获得地块账本列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('tunnel:cost-book:query')")
    public CommonResult<List<CostBookRespVO>> getCostBookList(@RequestParam("ids") Collection<Long> ids) {
        List<CostBookDO> list = costBookService.getCostBookList(ids);
        return success(CostBookConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得地块账本分页")
    @PreAuthorize("@ss.hasPermission('tunnel:cost-book:query')")
    public CommonResult<PageResult<CostBookRespVO>> getCostBookPage(@Valid CostBookPageReqVO pageVO) {
        PageResult<CostBookDO> pageResult = costBookService.getCostBookPage(pageVO);
        return success(CostBookConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出地块账本 Excel")
    @PreAuthorize("@ss.hasPermission('tunnel:cost-book:export')")
    @OperateLog(type = EXPORT)
    public void exportCostBookExcel(@Valid CostBookExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<CostBookDO> list = costBookService.getCostBookList(exportReqVO);
        // 导出 Excel
        List<CostBookExcelVO> datas = CostBookConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "地块账本.xls", "数据", CostBookExcelVO.class, datas);
    }

}
