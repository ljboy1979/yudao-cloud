package cn.iocoder.yudao.module.transaction.sales.controller.admin.commoditysku;

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

import cn.iocoder.yudao.module.transaction.sales.controller.admin.commoditysku.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.commoditysku.CommoditySkuDO;
import cn.iocoder.yudao.module.transaction.sales.convert.commoditysku.CommoditySkuConvert;
import cn.iocoder.yudao.module.transaction.sales.service.commoditysku.CommoditySkuService;

@Api(tags = "管理后台 - 商品sku")
@RestController
@RequestMapping("/sales/commodity-sku")
@Validated
public class CommoditySkuController {

    @Resource
    private CommoditySkuService commoditySkuService;

    @PostMapping("/create")
    @ApiOperation("创建商品sku")
    @PreAuthorize("@ss.hasPermission('sales:commodity-sku:create')")
    public CommonResult<String> createCommoditySku(@Valid @RequestBody CommoditySkuCreateReqVO createReqVO) {
        return success(commoditySkuService.createCommoditySku(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新商品sku")
    @PreAuthorize("@ss.hasPermission('sales:commodity-sku:update')")
    public CommonResult<Boolean> updateCommoditySku(@Valid @RequestBody CommoditySkuUpdateReqVO updateReqVO) {
        commoditySkuService.updateCommoditySku(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除商品sku")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:commodity-sku:delete')")
    public CommonResult<Boolean> deleteCommoditySku(@RequestParam("id") String id) {
        commoditySkuService.deleteCommoditySku(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得商品sku")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:commodity-sku:query')")
    public CommonResult<CommoditySkuRespVO> getCommoditySku(@RequestParam("id") String id) {
        CommoditySkuDO commoditySku = commoditySkuService.getCommoditySku(id);
        return success(CommoditySkuConvert.INSTANCE.convert(commoditySku));
    }

    @GetMapping("/list")
    @ApiOperation("获得商品sku列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('sales:commodity-sku:query')")
    public CommonResult<List<CommoditySkuRespVO>> getCommoditySkuList(@RequestParam("ids") Collection<String> ids) {
        List<CommoditySkuDO> list = commoditySkuService.getCommoditySkuList(ids);
        return success(CommoditySkuConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得商品sku分页")
    @PreAuthorize("@ss.hasPermission('sales:commodity-sku:query')")
    public CommonResult<PageResult<CommoditySkuRespVO>> getCommoditySkuPage(@Valid CommoditySkuPageReqVO pageVO) {
        PageResult<CommoditySkuDO> pageResult = commoditySkuService.getCommoditySkuPage(pageVO);
        return success(CommoditySkuConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出商品sku Excel")
    @PreAuthorize("@ss.hasPermission('sales:commodity-sku:export')")
    @OperateLog(type = EXPORT)
    public void exportCommoditySkuExcel(@Valid CommoditySkuExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<CommoditySkuDO> list = commoditySkuService.getCommoditySkuList(exportReqVO);
        // 导出 Excel
        List<CommoditySkuExcelVO> datas = CommoditySkuConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "商品sku.xls", "数据", CommoditySkuExcelVO.class, datas);
    }

}
