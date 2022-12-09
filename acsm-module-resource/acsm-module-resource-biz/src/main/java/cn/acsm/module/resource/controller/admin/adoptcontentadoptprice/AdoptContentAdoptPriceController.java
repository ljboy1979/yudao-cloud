package cn.acsm.module.resource.controller.admin.adoptcontentadoptprice;

import cn.acsm.module.resource.controller.admin.adoptcontentadoptprice.vo.*;
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

import cn.acsm.module.resource.dal.dataobject.adoptcontentadoptprice.AdoptContentAdoptPriceDO;
import cn.acsm.module.resource.convert.adoptcontentadoptprice.AdoptContentAdoptPriceConvert;
import cn.acsm.module.resource.service.adoptcontentadoptprice.AdoptContentAdoptPriceService;

@Api(tags = "管理后台 - 认养/租凭价格")
@RestController
@RequestMapping("/resource/adopt-content-adopt-price")
@Validated
public class AdoptContentAdoptPriceController {

    @Resource
    private AdoptContentAdoptPriceService adoptContentAdoptPriceService;

    @PostMapping("/create")
    @ApiOperation("创建认养/租凭价格")
    @PreAuthorize("@ss.hasPermission('service:adopt-content-adopt-price:create')")
    public CommonResult<String> createAdoptContentAdoptPrice(@Valid @RequestBody AdoptContentAdoptPriceCreateReqVO createReqVO) {
        return success(adoptContentAdoptPriceService.createAdoptContentAdoptPrice(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新认养/租凭价格")
    @PreAuthorize("@ss.hasPermission('service:adopt-content-adopt-price:update')")
    public CommonResult<Boolean> updateAdoptContentAdoptPrice(@Valid @RequestBody AdoptContentAdoptPriceUpdateReqVO updateReqVO) {
        adoptContentAdoptPriceService.updateAdoptContentAdoptPrice(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除认养/租凭价格")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:adopt-content-adopt-price:delete')")
    public CommonResult<Boolean> deleteAdoptContentAdoptPrice(@RequestParam("id") Long id) {
        adoptContentAdoptPriceService.deleteAdoptContentAdoptPrice(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得认养/租凭价格")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:adopt-content-adopt-price:query')")
    public CommonResult<AdoptContentAdoptPriceRespVO> getAdoptContentAdoptPrice(@RequestParam("id") Long id) {
        AdoptContentAdoptPriceDO adoptContentAdoptPrice = adoptContentAdoptPriceService.getAdoptContentAdoptPrice(id);
        return success(AdoptContentAdoptPriceConvert.INSTANCE.convert(adoptContentAdoptPrice));
    }

    @GetMapping("/list")
    @ApiOperation("获得认养/租凭价格列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('service:adopt-content-adopt-price:query')")
    public CommonResult<List<AdoptContentAdoptPriceRespVO>> getAdoptContentAdoptPriceList(@RequestParam("ids") Collection<Long> ids) {
        List<AdoptContentAdoptPriceDO> list = adoptContentAdoptPriceService.getAdoptContentAdoptPriceList(ids);
        return success(AdoptContentAdoptPriceConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得认养/租凭价格分页")
    @PreAuthorize("@ss.hasPermission('service:adopt-content-adopt-price:query')")
    public CommonResult<PageResult<AdoptContentAdoptPriceRespVO>> getAdoptContentAdoptPricePage(@Valid AdoptContentAdoptPricePageReqVO pageVO) {
        PageResult<AdoptContentAdoptPriceRespVO> pageResult = adoptContentAdoptPriceService.getAdoptContentAdoptPricePage(pageVO);
        //PageResult<AdoptContentAdoptPriceRespVO> adoptContentAdoptPriceRespVOPageResult = AdoptContentAdoptPriceConvert.INSTANCE.convertPage(pageResult);
        return success(pageResult);
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出认养/租凭价格 Excel")
    @PreAuthorize("@ss.hasPermission('service:adopt-content-adopt-price:export')")
    @OperateLog(type = EXPORT)
    public void exportAdoptContentAdoptPriceExcel(@Valid AdoptContentAdoptPriceExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<AdoptContentAdoptPriceDO> list = adoptContentAdoptPriceService.getAdoptContentAdoptPriceList(exportReqVO);
        // 导出 Excel
        List<AdoptContentAdoptPriceExcelVO> datas = AdoptContentAdoptPriceConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "认养/租凭价格.xls", "数据", AdoptContentAdoptPriceExcelVO.class, datas);
    }

}
