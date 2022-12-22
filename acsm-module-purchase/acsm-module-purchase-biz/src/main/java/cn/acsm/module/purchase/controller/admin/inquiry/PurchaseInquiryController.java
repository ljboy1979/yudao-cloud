package cn.acsm.module.purchase.controller.admin.inquiry;

import cn.acsm.module.purchase.controller.admin.inquiry.vo.*;
import cn.acsm.module.purchase.convert.inquiry.PurchaseInquiryConvert;
import cn.acsm.module.purchase.dal.dataobject.inquiry.PurchaseInquiryDO;
import cn.acsm.module.purchase.service.inquiry.PurchaseInquiryService;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
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

@Api(tags = "管理后台 - 采购询价单")
@RestController
@RequestMapping("/purchase/inquiry")
@Validated
public class PurchaseInquiryController {

    @Resource
    private PurchaseInquiryService inquiryService;

    @PostMapping("/create")
    @ApiOperation("创建采购询价单")
    @PreAuthorize("@ss.hasPermission('purchase:inquiry:create')")
    public CommonResult<Long> createInquiry(@Valid @RequestBody PurchaseInquiryCreateReqVO createReqVO) {
        return success(inquiryService.createInquiry(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新采购询价单")
    @PreAuthorize("@ss.hasPermission('purchase:inquiry:update')")
    public CommonResult<Boolean> updateInquiry(@Valid @RequestBody PurchaseInquiryUpdateReqVO updateReqVO) {
        inquiryService.updateInquiry(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除采购询价单")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('purchase:inquiry:delete')")
    public CommonResult<Boolean> deleteInquiry(@RequestParam("id") Long id) {
        inquiryService.deleteInquiry(id);
        return success(true);
    }

    @DeleteMapping("/delete/inquiry")
    @ApiOperation("删除询价单")
    @PreAuthorize("@ss.hasPermission('purchase:inquiry:delete')")
    public CommonResult<Boolean> deleteInquiry(@Valid @RequestBody PurchaseInquiryDelReqVO delReqVO) {
        inquiryService.deleteInquiry(delReqVO);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得采购询价单")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('purchase:inquiry:query')")
    public CommonResult<PurchaseInquiryRespVO> getInquiry(@RequestParam("id") Long id) {
        PurchaseInquiryDO inquiry = inquiryService.getInquiry(id);
        return success(PurchaseInquiryConvert.INSTANCE.convert(inquiry));
    }

    @GetMapping("/list")
    @ApiOperation("获得采购询价单列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('purchase:inquiry:query')")
    public CommonResult<List<PurchaseInquiryRespVO>> getInquiryList(@RequestParam("ids") Collection<Long> ids) {
        List<PurchaseInquiryDO> list = inquiryService.getInquiryList(ids);
        return success(PurchaseInquiryConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得采购询价单分页")
    @PreAuthorize("@ss.hasPermission('purchase:inquiry:query')")
    public CommonResult<PageResult<PurchaseInquiryRespVO>> getInquiryPage(@Valid PurchaseInquiryPageReqVO pageVO) {
        PageResult<PurchaseInquiryDO> pageResult = inquiryService.getInquiryPage(pageVO);
        return success(PurchaseInquiryConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出采购询价单 Excel")
    @PreAuthorize("@ss.hasPermission('purchase:inquiry:export')")
    @OperateLog(type = EXPORT)
    public void exportInquiryExcel(@Valid PurchaseInquiryExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<PurchaseInquiryDO> list = inquiryService.getInquiryList(exportReqVO);
        // 导出 Excel
        List<PurchaseInquiryExcelVO> datas = PurchaseInquiryConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "采购询价单.xls", "数据", PurchaseInquiryExcelVO.class, datas);
    }

    @GetMapping("/getInquiry")
    @ApiOperation("供应商获取询价单")
    @PreAuthorize("@ss.hasPermission('purchase:inquiry:byprovider')")
    public CommonResult<PageResult<PurchaseInquiryRespVO>> getInquiryByProvider(@Valid PurchaseInquiryGetVO getVO) {
        return success(PurchaseInquiryConvert.INSTANCE.convertPage(inquiryService.getInquiryByProvider(getVO)));
    }

    @GetMapping("/replyOrReadInquiry")
    @ApiOperation("回复询价情况 | 阅读询价单")
    @PreAuthorize("@ss.hasPermission('purchase:inquiry:readorreply')")
    public CommonResult<Boolean> replyOrReadInquiry(@Valid PurchaseInquiryReadOrReplyVO getVO) {
        inquiryService.replyOrReadInquiry(getVO);
        return success(true);
    }

}
