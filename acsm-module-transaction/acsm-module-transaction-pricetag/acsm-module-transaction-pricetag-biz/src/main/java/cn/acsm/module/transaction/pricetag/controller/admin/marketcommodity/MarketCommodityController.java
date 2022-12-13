package cn.acsm.module.transaction.pricetag.controller.admin.marketcommodity;

import org.springframework.cache.annotation.Cacheable;
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

import cn.acsm.module.transaction.pricetag.controller.admin.marketcommodity.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketcommodity.MarketCommodityDO;
import cn.acsm.module.transaction.pricetag.convert.marketcommodity.MarketCommodityConvert;
import cn.acsm.module.transaction.pricetag.service.marketcommodity.MarketCommodityService;

@Api(tags = "管理后台 - 市场商品")
@RestController
@RequestMapping("/pricetag/market-commodity")
@Validated
public class MarketCommodityController {

    @Resource
    private MarketCommodityService marketCommodityService;

    @PostMapping("/create")
    @ApiOperation("创建市场商品")
    @PreAuthorize("@ss.hasPermission('pricetag:market-commodity:create')")
    public CommonResult<String> createMarketCommodity(@Valid @RequestBody MarketCommodityCreateReqVO createReqVO) {
        return success(marketCommodityService.createMarketCommodity(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新市场商品")
    @PreAuthorize("@ss.hasPermission('pricetag:market-commodity:update')")
    public CommonResult<Boolean> updateMarketCommodity(@Valid @RequestBody MarketCommodityUpdateReqVO updateReqVO) {
        marketCommodityService.updateMarketCommodity(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除市场商品")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('pricetag:market-commodity:delete')")
    public CommonResult<Boolean> deleteMarketCommodity(@RequestParam("id") String id) {
        marketCommodityService.deleteMarketCommodity(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得市场商品")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('pricetag:market-commodity:query')")
    public CommonResult<MarketCommodityRespVO> getMarketCommodity(@RequestParam("id") String id) {
        MarketCommodityDO marketCommodity = marketCommodityService.getMarketCommodity(id);
        return success(MarketCommodityConvert.INSTANCE.convert(marketCommodity));
    }

    @GetMapping("/list")
    @ApiOperation("获得市场商品列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('pricetag:market-commodity:query')")
    public CommonResult<List<MarketCommodityRespVO>> getMarketCommodityList(@RequestParam("ids") Collection<String> ids) {
        List<MarketCommodityDO> list = marketCommodityService.getMarketCommodityList(ids);
        return success(MarketCommodityConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得市场商品分页")
    @PreAuthorize("@ss.hasPermission('pricetag:market-commodity:query')")
    public CommonResult<PageResult<MarketCommodityRespVO>> getMarketCommodityPage(@Valid MarketCommodityPageReqVO pageVO) {
        PageResult<MarketCommodityDO> pageResult = marketCommodityService.getMarketCommodityPage(pageVO);
        return success(MarketCommodityConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出市场商品 Excel")
    @PreAuthorize("@ss.hasPermission('pricetag:market-commodity:export')")
    @OperateLog(type = EXPORT)
    public void exportMarketCommodityExcel(@Valid MarketCommodityExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<MarketCommodityDO> list = marketCommodityService.getMarketCommodityList(exportReqVO);
        // 导出 Excel
        List<MarketCommodityExcelVO> datas = MarketCommodityConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "市场商品.xls", "数据", MarketCommodityExcelVO.class, datas);
    }

    @PostMapping("/findShelves")
    @ApiOperation("查询售品")
    @PreAuthorize("@ss.hasPermission('shelves:shelves:query')")
    public CommonResult<List<ShelvesRespVo>> findShelves(@Valid @RequestBody ShelvesReqVo shelvesReqVO) {
        return success(marketCommodityService.findShelves(shelvesReqVO));
    }

    @PostMapping("/findSpecifications")
    @ApiOperation("查询售品规格")
    @PreAuthorize("@ss.hasPermission('shelves:shelves:query')")
    public CommonResult<List<ShelvesRespVo>> findSpecifications(@Valid @RequestBody ShelvesReqVo shelvesReqVO) {
        return success(marketCommodityService.findSpecifications(shelvesReqVO));
    }
    @PostMapping("/treeList")
    @ApiOperation("树形分类列表")
    @PreAuthorize("@ss.hasPermission('sales:raw-material-classify:query')")
    @Cacheable(value = "/shelves/stock-classify/treeList")
    public CommonResult<List<TreeSelectVo>> treeList(@Valid ShelvesReqVo shelvesReqVO) {
        List<TreeSelectVo> list = marketCommodityService.findTreeList(shelvesReqVO);
        return success(list);
    }
}
