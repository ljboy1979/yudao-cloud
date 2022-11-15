package cn.acsm.module.wallet.controller.admin.wallet;

import cn.acsm.module.wallet.controller.admin.wallet.vo.*;
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

import cn.acsm.module.wallet.dal.dataobject.wallet.BankCardsInfoDO;
import cn.acsm.module.wallet.convert.wallet.BankCardsInfoConvert;
import cn.acsm.module.wallet.service.wallet.BankCardsInfoService;

@Api(tags = "管理后台 - 关联银行卡子")
@RestController
@RequestMapping("/wallet/bank-cards-info")
@Validated
public class BankCardsInfoController {

    @Resource
    private BankCardsInfoService bankCardsInfoService;

    @PostMapping("/create")
    @ApiOperation("创建关联银行卡子")
    @PreAuthorize("@ss.hasPermission('wallet:bank-cards-info:create')")
    public CommonResult<Long> createBankCardsInfo(@Valid @RequestBody BankCardsInfoCreateReqVO createReqVO) {
        return success(bankCardsInfoService.createBankCardsInfo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新关联银行卡子")
    @PreAuthorize("@ss.hasPermission('wallet:bank-cards-info:update')")
    public CommonResult<Boolean> updateBankCardsInfo(@Valid @RequestBody BankCardsInfoUpdateReqVO updateReqVO) {
        bankCardsInfoService.updateBankCardsInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除关联银行卡子")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('wallet:bank-cards-info:delete')")
    public CommonResult<Boolean> deleteBankCardsInfo(@RequestParam("id") Long id) {
        bankCardsInfoService.deleteBankCardsInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得关联银行卡子")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('wallet:bank-cards-info:query')")
    public CommonResult<BankCardsInfoRespVO> getBankCardsInfo(@RequestParam("id") Long id) {
        BankCardsInfoDO bankCardsInfo = bankCardsInfoService.getBankCardsInfo(id);
        return success(BankCardsInfoConvert.INSTANCE.convert(bankCardsInfo));
    }

    @GetMapping("/list")
    @ApiOperation("获得关联银行卡子列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('wallet:bank-cards-info:query')")
    public CommonResult<List<BankCardsInfoRespVO>> getBankCardsInfoList(@RequestParam("ids") Collection<Long> ids) {
        List<BankCardsInfoDO> list = bankCardsInfoService.getBankCardsInfoList(ids);
        return success(BankCardsInfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得关联银行卡子分页")
    @PreAuthorize("@ss.hasPermission('wallet:bank-cards-info:query')")
    public CommonResult<PageResult<BankCardsInfoRespVO>> getBankCardsInfoPage(@Valid BankCardsInfoPageReqVO pageVO) {
        PageResult<BankCardsInfoDO> pageResult = bankCardsInfoService.getBankCardsInfoPage(pageVO);
        return success(BankCardsInfoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出关联银行卡子 Excel")
    @PreAuthorize("@ss.hasPermission('wallet:bank-cards-info:export')")
    @OperateLog(type = EXPORT)
    public void exportBankCardsInfoExcel(@Valid BankCardsInfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<BankCardsInfoDO> list = bankCardsInfoService.getBankCardsInfoList(exportReqVO);
        // 导出 Excel
        List<BankCardsInfoExcelVO> datas = BankCardsInfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "关联银行卡子.xls", "数据", BankCardsInfoExcelVO.class, datas);
    }

}
