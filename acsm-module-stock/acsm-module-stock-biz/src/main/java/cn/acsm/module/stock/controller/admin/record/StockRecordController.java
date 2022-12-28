package cn.acsm.module.stock.controller.admin.record;

import cn.acsm.module.stock.controller.admin.record.vo.*;
import cn.acsm.module.stock.convert.record.StockRecordConvert;
import cn.acsm.module.stock.dal.dataobject.record.StockRecordDO;
import cn.acsm.module.stock.service.record.StockRecordService;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;

@Api(tags = "管理后台 - 库存记录【出库-入库】")
@RestController
@RequestMapping("/stock/record")
@Validated
public class StockRecordController {

    @Resource
    private StockRecordService recordService;

    @PostMapping("/create/warehousing")
    @ApiOperation("3.7.2.9.创建入库信息")
    @PreAuthorize("@ss.hasPermission('stock:record:create')")
    public CommonResult<Long> createRecordWarehousing(@Valid @RequestBody StockRecordCreateReqVO createReqVO) {
        return success(recordService.createRecordWarehousing(createReqVO));
    }

    @PostMapping("/create/issue")
    @ApiOperation("3.7.2.10.创建出库信息")
    @PreAuthorize("@ss.hasPermission('stock:record:create')")
    public CommonResult<Long> createRecordIssue(@Valid @RequestBody StockRecordCreateReqVO createReqVO) {
        return success(recordService.createRecordIssue(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新库存信息")
    @PreAuthorize("@ss.hasPermission('stock:record:update')")
    public CommonResult<Boolean> updateRecord(@Valid @RequestBody StockRecordUpdateReqVO updateReqVO) {
        recordService.updateRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("3.7.2.18.删除入库信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('stock:record:delete')")
    public CommonResult<Boolean> deleteRecord(@RequestParam("id") Long id) {
        recordService.deleteRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得库存信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('stock:record:query')")
    public CommonResult<StockRecordRespVO> getRecord(@RequestParam("id") Long id) {
        StockRecordDO record = recordService.getRecord(id);
        return success(StockRecordConvert.INSTANCE.convert(record));
    }

    @GetMapping("/list")
    @ApiOperation("获得库存信息列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('stock:record:query')")
    public CommonResult<List<StockRecordRespVO>> getRecordList(@RequestParam("ids") Collection<Long> ids) {
        List<StockRecordDO> list = recordService.getRecordList(ids);
        return success(StockRecordConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得库存信息分页")
    @PreAuthorize("@ss.hasPermission('stock:record:query')")
    public CommonResult<Page<StockRecordFeignVO>> getRecordPage(@Valid StockRecordPageReqVO pageVO) {
        Page<StockRecordFeignVO> pageResult = recordService.getRecordPage(pageVO);
        return success(pageResult);
    }

    @GetMapping("/export-excel")
    @ApiOperation("3.7.2.19.打印入/出库信息")
    @PreAuthorize("@ss.hasPermission('stock:record:export')")
    @OperateLog(type = EXPORT)
    public void exportRecordExcel(@Valid StockRecordExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<StockRecordDO> list = recordService.getRecordList(exportReqVO);
        // 导出 Excel
        List<StockRecordExcelVO> datas = StockRecordConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "库存记录.xls", "数据", StockRecordExcelVO.class, datas);
    }

    @GetMapping("/page/outorenter/record")
    @ApiOperation("3.7.2.14.查询出/入库信息")
    @PreAuthorize("@ss.hasPermission('stock:record:query')")
    public CommonResult<Page<StockRecordDO>> getOutEnterRecordPage(@Valid StockRecordOutEnterVO pageVO) {
        return success(recordService.getRecordOutEnterPage(pageVO));
    }

}
