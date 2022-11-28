package cn.iocoder.yudao.module.transaction.sales.controller.admin.commodityorganization;

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

import cn.iocoder.yudao.module.transaction.sales.controller.admin.commodityorganization.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.commodityorganization.CommodityOrganizationDO;
import cn.iocoder.yudao.module.transaction.sales.convert.commodityorganization.CommodityOrganizationConvert;
import cn.iocoder.yudao.module.transaction.sales.service.commodityorganization.CommodityOrganizationService;

@Api(tags = "管理后台 - 商品组成")
@RestController
@RequestMapping("/sales/commodity-organization")
@Validated
public class CommodityOrganizationController {

    @Resource
    private CommodityOrganizationService commodityOrganizationService;

    @PostMapping("/create")
    @ApiOperation("创建商品组成")
    @PreAuthorize("@ss.hasPermission('sales:commodity-organization:create')")
    public CommonResult<String> createCommodityOrganization(@Valid @RequestBody CommodityOrganizationCreateReqVO createReqVO) {
        return success(commodityOrganizationService.createCommodityOrganization(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新商品组成")
    @PreAuthorize("@ss.hasPermission('sales:commodity-organization:update')")
    public CommonResult<Boolean> updateCommodityOrganization(@Valid @RequestBody CommodityOrganizationUpdateReqVO updateReqVO) {
        commodityOrganizationService.updateCommodityOrganization(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除商品组成")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:commodity-organization:delete')")
    public CommonResult<Boolean> deleteCommodityOrganization(@RequestParam("id") String id) {
        commodityOrganizationService.deleteCommodityOrganization(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得商品组成")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:commodity-organization:query')")
    public CommonResult<CommodityOrganizationRespVO> getCommodityOrganization(@RequestParam("id") String id) {
        CommodityOrganizationDO commodityOrganization = commodityOrganizationService.getCommodityOrganization(id);
        return success(CommodityOrganizationConvert.INSTANCE.convert(commodityOrganization));
    }

    @GetMapping("/list")
    @ApiOperation("获得商品组成列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('sales:commodity-organization:query')")
    public CommonResult<List<CommodityOrganizationRespVO>> getCommodityOrganizationList(@RequestParam("ids") Collection<String> ids) {
        List<CommodityOrganizationDO> list = commodityOrganizationService.getCommodityOrganizationList(ids);
        return success(CommodityOrganizationConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得商品组成分页")
    @PreAuthorize("@ss.hasPermission('sales:commodity-organization:query')")
    public CommonResult<PageResult<CommodityOrganizationRespVO>> getCommodityOrganizationPage(@Valid CommodityOrganizationPageReqVO pageVO) {
        PageResult<CommodityOrganizationDO> pageResult = commodityOrganizationService.getCommodityOrganizationPage(pageVO);
        return success(CommodityOrganizationConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出商品组成 Excel")
    @PreAuthorize("@ss.hasPermission('sales:commodity-organization:export')")
    @OperateLog(type = EXPORT)
    public void exportCommodityOrganizationExcel(@Valid CommodityOrganizationExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<CommodityOrganizationDO> list = commodityOrganizationService.getCommodityOrganizationList(exportReqVO);
        // 导出 Excel
        List<CommodityOrganizationExcelVO> datas = CommodityOrganizationConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "商品组成.xls", "数据", CommodityOrganizationExcelVO.class, datas);
    }

}
