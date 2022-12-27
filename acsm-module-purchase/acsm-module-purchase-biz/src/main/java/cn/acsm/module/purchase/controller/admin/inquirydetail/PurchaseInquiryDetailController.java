package cn.acsm.module.purchase.controller.admin.inquirydetail;

import cn.acsm.module.purchase.controller.admin.inquirydetail.vo.*;
import cn.acsm.module.purchase.convert.inquirydetail.PurchaseInquiryDetailConvert;
import cn.acsm.module.purchase.dal.dataobject.inquirydetail.PurchaseInquiryDetailDO;
import cn.acsm.module.purchase.service.inquirydetail.PurchaseInquiryDetailService;
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

@Api(tags = "管理后台 - 采购询价电子表")
@RestController
@RequestMapping("/purchase/inquiry-detail")
@Validated
public class PurchaseInquiryDetailController {

    @Resource
    private PurchaseInquiryDetailService inquiryDetailService;

    @PostMapping("/create")
    @ApiOperation("创建采购询价电子表")
    @PreAuthorize("@ss.hasPermission('purchase:inquiry-detail:create')")
    public CommonResult<Long> createInquiryDetail(@Valid @RequestBody PurchaseInquiryDetailCreateReqVO createReqVO) {
        return success(inquiryDetailService.createInquiryDetail(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新采购询价电子表")
    @PreAuthorize("@ss.hasPermission('purchase:inquiry-detail:update')")
    public CommonResult<Boolean> updateInquiryDetail(@Valid @RequestBody PurchaseInquiryDetailUpdateReqVO updateReqVO) {
        inquiryDetailService.updateInquiryDetail(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除采购询价电子表")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('purchase:inquiry-detail:delete')")
    public CommonResult<Boolean> deleteInquiryDetail(@RequestParam("id") Long id) {
        inquiryDetailService.deleteInquiryDetail(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得采购询价电子表")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('purchase:inquiry-detail:query')")
    public CommonResult<PurchaseInquiryDetailRespVO> getInquiryDetail(@RequestParam("id") Long id) {
        PurchaseInquiryDetailDO inquiryDetail = inquiryDetailService.getInquiryDetail(id);
        return success(PurchaseInquiryDetailConvert.INSTANCE.convert(inquiryDetail));
    }

    @GetMapping("/list")
    @ApiOperation("获得采购询价电子表列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('purchase:inquiry-detail:query')")
    public CommonResult<List<PurchaseInquiryDetailRespVO>> getInquiryDetailList(@RequestParam("ids") Collection<Long> ids) {
        List<PurchaseInquiryDetailDO> list = inquiryDetailService.getInquiryDetailList(ids);
        return success(PurchaseInquiryDetailConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("3.6.2.35.查询采购询价明细（基础方法）")
    @PreAuthorize("@ss.hasPermission('purchase:inquiry-detail:query')")
    public CommonResult<Page<PurchaseInquiryDetailDO>> getInquiryDetailPage(@Valid @RequestBody PurchaseInquiryDetailPageReqVO pageVO) {
        Page<PurchaseInquiryDetailDO> pageResult = inquiryDetailService.getInquiryDetailPage(pageVO);
        return success(pageResult);
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出采购询价电子表 Excel")
    @PreAuthorize("@ss.hasPermission('purchase:inquiry-detail:export')")
    @OperateLog(type = EXPORT)
    public void exportInquiryDetailExcel(@Valid PurchaseInquiryDetailExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<PurchaseInquiryDetailDO> list = inquiryDetailService.getInquiryDetailList(exportReqVO);
        // 导出 Excel
        List<PurchaseInquiryDetailExcelVO> datas = PurchaseInquiryDetailConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "采购询价电子表.xls", "数据", PurchaseInquiryDetailExcelVO.class, datas);
    }

}
