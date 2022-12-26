package cn.acsm.module.transaction.shelves.controller.admin.stockclassify;

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

import cn.acsm.module.transaction.shelves.controller.admin.stockclassify.vo.*;
import cn.acsm.module.transaction.shelves.dal.dataobject.stockclassify.StockClassifyDO;
import cn.acsm.module.transaction.shelves.convert.stockclassify.StockClassifyConvert;
import cn.acsm.module.transaction.shelves.service.stockclassify.StockClassifyService;

@Api(tags = "管理后台 - 库存分类")
@RestController
@RequestMapping("/shelves/stock-classify")
@Validated
public class StockClassifyController {

    @Resource
    private StockClassifyService stockClassifyService;

    @PostMapping("/create")
    @ApiOperation("创建库存分类")
    @PreAuthorize("@ss.hasPermission('shelves:stock-classify:create')")
    public CommonResult<String> createStockClassify(@Valid @RequestBody StockClassifyCreateReqVO createReqVO) {
        return success(stockClassifyService.createStockClassify(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新库存分类")
    @PreAuthorize("@ss.hasPermission('shelves:stock-classify:update')")
    public CommonResult<Boolean> updateStockClassify(@Valid @RequestBody StockClassifyUpdateReqVO updateReqVO) {
        stockClassifyService.updateStockClassify(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除库存分类")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('shelves:stock-classify:delete')")
    public CommonResult<Boolean> deleteStockClassify(@RequestParam("id") String id) {
        stockClassifyService.deleteStockClassify(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得库存分类")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('shelves:stock-classify:query')")
    public CommonResult<StockClassifyRespVO> getStockClassify(@RequestParam("id") String id) {
        StockClassifyDO stockClassify = stockClassifyService.getStockClassify(id);
        return success(StockClassifyConvert.INSTANCE.convert(stockClassify));
    }

    @GetMapping("/list")
    @ApiOperation("获得库存分类列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('shelves:stock-classify:query')")
    public CommonResult<List<StockClassifyRespVO>> getStockClassifyList(@RequestParam("ids") Collection<String> ids) {
        List<StockClassifyDO> list = stockClassifyService.getStockClassifyList(ids);
        return success(StockClassifyConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得库存分类分页")
    @PreAuthorize("@ss.hasPermission('shelves:stock-classify:query')")
    public CommonResult<PageResult<StockClassifyRespVO>> getStockClassifyPage(@Valid StockClassifyPageReqVO pageVO) {
        PageResult<StockClassifyDO> pageResult = stockClassifyService.getStockClassifyPage(pageVO);
        return success(StockClassifyConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出库存分类 Excel")
    @PreAuthorize("@ss.hasPermission('shelves:stock-classify:export')")
    @OperateLog(type = EXPORT)
    public void exportStockClassifyExcel(@Valid StockClassifyExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<StockClassifyDO> list = stockClassifyService.getStockClassifyList(exportReqVO);
        // 导出 Excel
        List<StockClassifyExcelVO> datas = StockClassifyConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "库存分类.xls", "数据", StockClassifyExcelVO.class, datas);
    }

    @PostMapping("/treeList")
    @ApiOperation("树形分类列表")
    @PreAuthorize("@ss.hasPermission('sales:raw-material-classify:query')")
    //@Cacheable(value = "/shelves/stock-classify/treeList",key = "#stockClassifyTreeVO.classifyName")
    public CommonResult<List<TreeSelect>> treeList(@Valid StockClassifyTreeVO stockClassifyTreeVO) {
        List<TreeSelect> list = stockClassifyService.findTreeList(stockClassifyTreeVO);
        return success(list);
    }

    @PostMapping("/findClassifyList")
    @ApiOperation("树形分类列表")
    @PreAuthorize("@ss.hasPermission('sales:raw-material-classify:query')")
    //@Cacheable(value = "/shelves/stock-classify/treeList",key = "#stockClassifyTreeVO.classifyName")
    public CommonResult<List<StockClassifyRespVO>> findClassifyList(@Valid @RequestBody StockClassifyTreeVO stockClassifyTreeVO) {
        List<StockClassifyRespVO> list = stockClassifyService.findClassifyList(stockClassifyTreeVO);
        return success(list);
    }

}
