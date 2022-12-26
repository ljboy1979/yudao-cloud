package cn.acsm.module.transaction.pricetag.controller.admin.marketclassify;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeSelect;
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

import cn.acsm.module.transaction.pricetag.controller.admin.marketclassify.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketclassify.MarketClassifyDO;
import cn.acsm.module.transaction.pricetag.convert.marketclassify.MarketClassifyConvert;
import cn.acsm.module.transaction.pricetag.service.marketclassify.MarketClassifyService;

@Api(tags = "管理后台 - 市场分类")
@RestController
@RequestMapping("/pricetag/market-classify")
@Validated
public class MarketClassifyController {

    @Resource
    private MarketClassifyService marketClassifyService;

    @PostMapping("/create")
    @ApiOperation("创建市场分类")
    @PreAuthorize("@ss.hasPermission('pricetag:market-classify:create')")
    public CommonResult<String> createMarketClassify(@Valid @RequestBody MarketClassifyCreateReqVO createReqVO) {
        return success(marketClassifyService.createMarketClassify(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新市场分类")
    @PreAuthorize("@ss.hasPermission('pricetag:market-classify:update')")
    public CommonResult<Boolean> updateMarketClassify(@Valid @RequestBody MarketClassifyUpdateReqVO updateReqVO) {
        marketClassifyService.updateMarketClassify(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除市场分类")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('pricetag:market-classify:delete')")
    public CommonResult<Boolean> deleteMarketClassify(@RequestParam("id") String id) {
        marketClassifyService.deleteMarketClassify(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得市场分类")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('pricetag:market-classify:query')")
    public CommonResult<MarketClassifyRespVO> getMarketClassify(@RequestParam("id") String id) {
        MarketClassifyDO marketClassify = marketClassifyService.getMarketClassify(id);
        return success(MarketClassifyConvert.INSTANCE.convert(marketClassify));
    }

    @GetMapping("/list")
    @ApiOperation("获得市场分类列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('pricetag:market-classify:query')")
    public CommonResult<List<MarketClassifyRespVO>> getMarketClassifyList(@RequestParam("ids") Collection<String> ids) {
        List<MarketClassifyDO> list = marketClassifyService.getMarketClassifyList(ids);
        return success(MarketClassifyConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得市场分类分页")
    @PreAuthorize("@ss.hasPermission('pricetag:market-classify:query')")
    public CommonResult<PageResult<MarketClassifyRespVO>> getMarketClassifyPage(@Valid MarketClassifyPageReqVO pageVO) {
        PageResult<MarketClassifyDO> pageResult = marketClassifyService.getMarketClassifyPage(pageVO);
        return success(MarketClassifyConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出市场分类 Excel")
    @PreAuthorize("@ss.hasPermission('pricetag:market-classify:export')")
    @OperateLog(type = EXPORT)
    public void exportMarketClassifyExcel(@Valid MarketClassifyExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<MarketClassifyDO> list = marketClassifyService.getMarketClassifyList(exportReqVO);
        // 导出 Excel
        List<MarketClassifyExcelVO> datas = MarketClassifyConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "市场分类.xls", "数据", MarketClassifyExcelVO.class, datas);
    }

    @PostMapping("/treeList")
    @ApiOperation("树形分类列表")
    @PreAuthorize("@ss.hasPermission('pricetag:market-classify:query')")
    //@Cacheable(value = "/pricetag/market-classify/treeList",key = "#marketClassifyTreeVO.categoryName")
    public CommonResult<List<TreeSelect>> treeList(@Valid MarketClassifyTreeVO marketClassifyTreeVO) {
        List<TreeSelect> list = marketClassifyService.findTreeList(marketClassifyTreeVO);
        return success(list);
    }
}
