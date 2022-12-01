package cn.acsm.module.transaction.sales.controller.admin.commodityspecification;

import cn.acsm.module.transaction.sales.controller.admin.commodityspecification.vo.CommoditySpecificationCreateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodityspecification.vo.CommoditySpecificationExcelVO;
import cn.acsm.module.transaction.sales.controller.admin.commodityspecification.vo.CommoditySpecificationExportReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodityspecification.vo.CommoditySpecificationPageReqVO;
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

import cn.acsm.module.transaction.sales.controller.admin.commodityspecification.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO;
import cn.acsm.module.transaction.sales.convert.commodityspecification.CommoditySpecificationConvert;
import cn.acsm.module.transaction.sales.service.commodityspecification.CommoditySpecificationService;

@Api(tags = "管理后台 - 商品规格")
@RestController
@RequestMapping("/sales/commodity-specification")
@Validated
public class CommoditySpecificationController {

    @Resource
    private CommoditySpecificationService commoditySpecificationService;

    @PostMapping("/create")
    @ApiOperation("创建商品规格")
    @PreAuthorize("@ss.hasPermission('sales:commodity-specification:create')")
    public CommonResult<String> createCommoditySpecification(@Valid @RequestBody CommoditySpecificationCreateReqVO createReqVO) {
        return commoditySpecificationService.createCommoditySpecification(createReqVO);
    }

    @PutMapping("/update")
    @ApiOperation("更新商品规格")
    @PreAuthorize("@ss.hasPermission('sales:commodity-specification:update')")
    public CommonResult<String> updateCommoditySpecification(@Valid @RequestBody CommoditySpecificationUpdateReqVO updateReqVO) {
        return commoditySpecificationService.updateCommoditySpecification(updateReqVO);

    }

    @DeleteMapping("/delete")
    @ApiOperation("删除商品规格")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:commodity-specification:delete')")
    public CommonResult<Boolean> deleteCommoditySpecification(@RequestParam("id") String id) {
        commoditySpecificationService.deleteCommoditySpecification(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得商品规格")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:commodity-specification:query')")
    public CommonResult<CommoditySpecificationRespVO> getCommoditySpecification(@RequestParam("id") String id) {
        CommoditySpecificationDO commoditySpecification = commoditySpecificationService.getCommoditySpecification(id);
        return success(CommoditySpecificationConvert.INSTANCE.convert(commoditySpecification));
    }

    @GetMapping("/list")
    @ApiOperation("获得商品规格列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('sales:commodity-specification:query')")
    public CommonResult<List<CommoditySpecificationRespVO>> getCommoditySpecificationList(@RequestParam("ids") Collection<String> ids) {
        List<CommoditySpecificationDO> list = commoditySpecificationService.getCommoditySpecificationList(ids);
        return success(CommoditySpecificationConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得商品规格分页")
    @PreAuthorize("@ss.hasPermission('sales:commodity-specification:query')")
    public CommonResult<PageResult<CommoditySpecificationRespVO>> getCommoditySpecificationPage(@Valid CommoditySpecificationPageReqVO pageVO) {
        PageResult<CommoditySpecificationDO> pageResult = commoditySpecificationService.getCommoditySpecificationPage(pageVO);
        return success(CommoditySpecificationConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出商品规格 Excel")
    @PreAuthorize("@ss.hasPermission('sales:commodity-specification:export')")
    @OperateLog(type = EXPORT)
    public void exportCommoditySpecificationExcel(@Valid CommoditySpecificationExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<CommoditySpecificationDO> list = commoditySpecificationService.getCommoditySpecificationList(exportReqVO);
        // 导出 Excel
        List<CommoditySpecificationExcelVO> datas = CommoditySpecificationConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "商品规格.xls", "数据", CommoditySpecificationExcelVO.class, datas);
    }

}
