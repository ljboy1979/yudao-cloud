package cn.acsm.module.wallet.controller.admin.wallet;

import cn.acsm.module.wallet.controller.admin.wallet.vo.*;
import cn.acsm.module.wallet.convert.wallet.TransactionHistoryConvert;
import cn.acsm.module.wallet.dal.dataobject.wallet.TransactionHistoryDO;
import cn.acsm.module.wallet.service.wallet.TransactionHistoryService;
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


@Api(tags = "管理后台 - 钱包交易记录子")
@RestController
@RequestMapping("/wallet/transaction-history")
@Validated
public class TransactionHistoryController {

    @Resource
    private TransactionHistoryService transactionHistoryService;

    @PostMapping("/create")
    @ApiOperation("创建钱包交易记录子")
    @PreAuthorize("@ss.hasPermission('wallet:transaction-history:create')")
    public CommonResult<Long> createTransactionHistory(@Valid @RequestBody TransactionHistoryCreateReqVO createReqVO) {
        return success(transactionHistoryService.createTransactionHistory(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新钱包交易记录子")
    @PreAuthorize("@ss.hasPermission('wallet:transaction-history:update')")
    public CommonResult<Boolean> updateTransactionHistory(@Valid @RequestBody TransactionHistoryUpdateReqVO updateReqVO) {
        transactionHistoryService.updateTransactionHistory(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除钱包交易记录子")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('wallet:transaction-history:delete')")
    public CommonResult<Boolean> deleteTransactionHistory(@RequestParam("id") Long id) {
        transactionHistoryService.deleteTransactionHistory(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得钱包交易记录子")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('wallet:transaction-history:query')")
    public CommonResult<TransactionHistoryRespVO> getTransactionHistory(@RequestParam("id") Long id) {
        TransactionHistoryDO transactionHistory = transactionHistoryService.getTransactionHistory(id);
        return success(TransactionHistoryConvert.INSTANCE.convert(transactionHistory));
    }

    @GetMapping("/list")
    @ApiOperation("获得钱包交易记录子列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('wallet:transaction-history:query')")
    public CommonResult<List<TransactionHistoryRespVO>> getTransactionHistoryList(@RequestParam("ids") Collection<Long> ids) {
        List<TransactionHistoryDO> list = transactionHistoryService.getTransactionHistoryList(ids);
        return success(TransactionHistoryConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得钱包交易记录子分页")
    @PreAuthorize("@ss.hasPermission('wallet:transaction-history:query')")
    public CommonResult<PageResult<TransactionHistoryRespVO>> getTransactionHistoryPage(@Valid TransactionHistoryPageReqVO pageVO) {
        PageResult<TransactionHistoryDO> pageResult = transactionHistoryService.getTransactionHistoryPage(pageVO);
        return success(TransactionHistoryConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出钱包交易记录子 Excel")
    @PreAuthorize("@ss.hasPermission('wallet:transaction-history:export')")
    @OperateLog(type = EXPORT)
    public void exportTransactionHistoryExcel(@Valid TransactionHistoryExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<TransactionHistoryDO> list = transactionHistoryService.getTransactionHistoryList(exportReqVO);
        // 导出 Excel
        List<TransactionHistoryExcelVO> datas = TransactionHistoryConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "钱包交易记录子.xls", "数据", TransactionHistoryExcelVO.class, datas);
    }

}
