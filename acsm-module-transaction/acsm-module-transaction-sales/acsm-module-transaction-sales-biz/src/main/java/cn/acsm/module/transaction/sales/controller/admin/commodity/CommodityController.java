package cn.acsm.module.transaction.sales.controller.admin.commodity;

import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesRespDto;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.CommodityCreateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.CommodityExportReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.CommodityPageReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.CommodityUpdateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.ShelvesSalesRespVO;
import cn.acsm.module.transaction.sales.convert.commodity.CommodityConvert;
import cn.acsm.module.transaction.sales.convert.commoditycategory.CommodityCategoryConvert;
import cn.acsm.module.transaction.sales.dal.dataobject.commodity.CommodityCustomDO;
import cn.acsm.module.transaction.sales.dal.dataobject.commodity.CommodityDO;
import cn.acsm.module.transaction.sales.enums.ShelvesEnums;
import cn.acsm.module.transaction.sales.service.api.shelves.ShelvesContext;
import cn.acsm.module.transaction.sales.service.commodity.CommodityService;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeSelect;
import org.springframework.data.domain.Page;
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
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.*;

import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.*;

@Api(tags = "管理后台 - 商品")
@RestController
@RequestMapping("/sales/commodity")
@Validated
public class CommodityController {

    @Resource
    private CommodityService commodityService;


    @Resource
    private ShelvesContext shelvesContext;

    @PostMapping("/create")
    @ApiOperation("创建商品")
    @PreAuthorize("@ss.hasPermission('sales:commodity:create')")
    public CommonResult<String> createCommodity(@Valid @RequestBody CommodityCreateReqVO createReqVO) {
        return commodityService.createCommodity(createReqVO);
    }

    @PutMapping("/update")
    @ApiOperation("更新商品")
    @PreAuthorize("@ss.hasPermission('sales:commodity:update')")
    public CommonResult<String>  updateCommodity(@Valid @RequestBody CommodityUpdateReqVO updateReqVO) {

        return commodityService.updateCommodity(updateReqVO);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除商品")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:commodity:delete')")
    public CommonResult<Boolean> deleteCommodity(@RequestParam("id") String id) {
        commodityService.deleteCommodity(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得商品")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:commodity:query')")
    public CommonResult<CommodityRespVO> getCommodity(@RequestParam("id") String id) {
        CommodityCustomDO commodity = commodityService.getCommodityById(id);
        return success(CommodityConvert.INSTANCE.convertCustom(commodity));
    }

    @GetMapping("/list")
    @ApiOperation("获得商品列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('sales:commodity:query')")
    public CommonResult<List<CommodityRespVO>> getCommodityList(@RequestParam("ids") Collection<String> ids) {
        List<CommodityDO> list = commodityService.getCommodityList(ids);
        return success(CommodityConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得商品分页")
    @PreAuthorize("@ss.hasPermission('sales:commodity:query')")
    public CommonResult<PageResult<CommodityRespVO>> getCommodityPage(@Valid CommodityPageReqVO pageVO) {
        PageResult<CommodityDO> pageResult = commodityService.getCommodityPage(pageVO);
        return success(CommodityConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出商品 Excel")
    @PreAuthorize("@ss.hasPermission('sales:commodity:export')")
    @OperateLog(type = EXPORT)
    public void exportCommodityExcel(@Valid CommodityExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<CommodityDO> list = commodityService.getCommodityList(exportReqVO);
        // 导出 Excel
        List<CommodityExcelVO> datas = CommodityConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "商品.xls", "数据", CommodityExcelVO.class, datas);
    }
    @PostMapping("/findSpecifications")
    @ApiOperation("查询售品规格")
    @PreAuthorize("@ss.hasPermission('sales:commodity:query')")
    public CommonResult<PageResult<ShelvesSalesRespVO>> findSpecifications(@RequestBody ShelvesSalesReqVO shelvesSalesReqDto) {
        PageResult<ShelvesSalesRespVO> specifications = shelvesContext.getService(ShelvesEnums.getByType(shelvesSalesReqDto.getType()).getValue()).findSpecificationsVo(shelvesSalesReqDto);
        return CommonResult.success(specifications);

    }

    @PostMapping("/findSales")
    @ApiOperation("查询售品")
    public CommonResult<List<ShelvesSalesRespVO>> findSales(@RequestBody ShelvesSalesReqDto shelvesSalesReqDto) {
        List<ShelvesSalesRespDto> salesList = shelvesContext.getService(ShelvesEnums.getByType(shelvesSalesReqDto.getType()).getValue()).findSales(shelvesSalesReqDto);
        return CommonResult.success( CommodityConvert.INSTANCE.convertShelvesSalesRespVO(salesList));
    }

    @PostMapping("/findClassify")
    @ApiOperation("查询售品分类")
    @PreAuthorize("@ss.hasPermission('sales:commodity:query')")
    public CommonResult<List<TreeSelect>> findClassify(@RequestBody ShelvesSalesReqVO shelvesSalesReqDto) {
        List<TreeSelect> specifications = shelvesContext.getService(ShelvesEnums.getByType(shelvesSalesReqDto.getType()).getValue()).findClassify();
        return CommonResult.success(specifications);

    }

}
