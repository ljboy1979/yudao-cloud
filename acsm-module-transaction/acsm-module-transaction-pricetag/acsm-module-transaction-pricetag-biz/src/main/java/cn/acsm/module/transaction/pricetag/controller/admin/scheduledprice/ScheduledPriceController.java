package cn.acsm.module.transaction.pricetag.controller.admin.scheduledprice;

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

import cn.acsm.module.transaction.pricetag.controller.admin.scheduledprice.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.scheduledprice.ScheduledPriceDO;
import cn.acsm.module.transaction.pricetag.convert.scheduledprice.ScheduledPriceConvert;
import cn.acsm.module.transaction.pricetag.service.scheduledprice.ScheduledPriceService;

@Api(tags = "管理后台 - 预定价格")
@RestController
@RequestMapping("/pricetag/scheduled-price")
@Validated
public class ScheduledPriceController {

    @Resource
    private ScheduledPriceService scheduledPriceService;

    @PostMapping("/create")
    @ApiOperation("创建预定价格")
    @PreAuthorize("@ss.hasPermission('pricetag:scheduled-price:create')")
    public CommonResult<String> createScheduledPrice(@Valid @RequestBody ScheduledPriceCreateReqVO createReqVO) {
        return success(scheduledPriceService.createScheduledPrice(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新预定价格")
    @PreAuthorize("@ss.hasPermission('pricetag:scheduled-price:update')")
    public CommonResult<Boolean> updateScheduledPrice(@Valid @RequestBody ScheduledPriceUpdateReqVO updateReqVO) {
        scheduledPriceService.updateScheduledPrice(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除预定价格")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('pricetag:scheduled-price:delete')")
    public CommonResult<Boolean> deleteScheduledPrice(@RequestParam("id") String id) {
        scheduledPriceService.deleteScheduledPrice(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得预定价格")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('pricetag:scheduled-price:query')")
    public CommonResult<ScheduledPriceRespVO> getScheduledPrice(@RequestParam("id") String id) {
        ScheduledPriceDO scheduledPrice = scheduledPriceService.getScheduledPrice(id);
        return success(ScheduledPriceConvert.INSTANCE.convert(scheduledPrice));
    }

    @GetMapping("/list")
    @ApiOperation("获得预定价格列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('pricetag:scheduled-price:query')")
    public CommonResult<List<ScheduledPriceRespVO>> getScheduledPriceList(@RequestParam("ids") Collection<String> ids) {
        List<ScheduledPriceDO> list = scheduledPriceService.getScheduledPriceList(ids);
        return success(ScheduledPriceConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得预定价格分页")
    @PreAuthorize("@ss.hasPermission('pricetag:scheduled-price:query')")
    public CommonResult<PageResult<ScheduledPriceRespVO>> getScheduledPricePage(@Valid ScheduledPricePageReqVO pageVO) {
        PageResult<ScheduledPriceDO> pageResult = scheduledPriceService.getScheduledPricePage(pageVO);
        return success(ScheduledPriceConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出预定价格 Excel")
    @PreAuthorize("@ss.hasPermission('pricetag:scheduled-price:export')")
    @OperateLog(type = EXPORT)
    public void exportScheduledPriceExcel(@Valid ScheduledPriceExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ScheduledPriceDO> list = scheduledPriceService.getScheduledPriceList(exportReqVO);
        // 导出 Excel
        List<ScheduledPriceExcelVO> datas = ScheduledPriceConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "预定价格.xls", "数据", ScheduledPriceExcelVO.class, datas);
    }

}
