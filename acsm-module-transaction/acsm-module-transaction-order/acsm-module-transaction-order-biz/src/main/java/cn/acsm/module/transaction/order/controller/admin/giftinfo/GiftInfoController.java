package cn.acsm.module.transaction.order.controller.admin.giftinfo;

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

import cn.acsm.module.transaction.order.controller.admin.giftinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.giftinfo.GiftInfoDO;
import cn.acsm.module.transaction.order.convert.giftinfo.GiftInfoConvert;
import cn.acsm.module.transaction.order.service.giftinfo.GiftInfoService;

@Api(tags = "管理后台 - 赠品")
@RestController
@RequestMapping("/order/gift-info")
@Validated
public class GiftInfoController {

    @Resource
    private GiftInfoService giftInfoService;

    @PostMapping("/create")
    @ApiOperation("创建赠品")
    @PreAuthorize("@ss.hasPermission('order:gift-info:create')")
    public CommonResult<Integer> createGiftInfo(@Valid @RequestBody GiftInfoCreateReqVO createReqVO) {
        return success(giftInfoService.createGiftInfo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新赠品")
    @PreAuthorize("@ss.hasPermission('order:gift-info:update')")
    public CommonResult<Boolean> updateGiftInfo(@Valid @RequestBody GiftInfoUpdateReqVO updateReqVO) {
        giftInfoService.updateGiftInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除赠品")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Integer.class)
    @PreAuthorize("@ss.hasPermission('order:gift-info:delete')")
    public CommonResult<Boolean> deleteGiftInfo(@RequestParam("id") Integer id) {
        giftInfoService.deleteGiftInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得赠品")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Integer.class)
    @PreAuthorize("@ss.hasPermission('order:gift-info:query')")
    public CommonResult<GiftInfoRespVO> getGiftInfo(@RequestParam("id") Integer id) {
        GiftInfoDO giftInfo = giftInfoService.getGiftInfo(id);
        return success(GiftInfoConvert.INSTANCE.convert(giftInfo));
    }

    @GetMapping("/list")
    @ApiOperation("获得赠品列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('order:gift-info:query')")
    public CommonResult<List<GiftInfoRespVO>> getGiftInfoList(@RequestParam("ids") Collection<Integer> ids) {
        List<GiftInfoDO> list = giftInfoService.getGiftInfoList(ids);
        return success(GiftInfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得赠品分页")
    @PreAuthorize("@ss.hasPermission('order:gift-info:query')")
    public CommonResult<PageResult<GiftInfoRespVO>> getGiftInfoPage(@Valid GiftInfoPageReqVO pageVO) {
        PageResult<GiftInfoDO> pageResult = giftInfoService.getGiftInfoPage(pageVO);
        return success(GiftInfoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出赠品 Excel")
    @PreAuthorize("@ss.hasPermission('order:gift-info:export')")
    @OperateLog(type = EXPORT)
    public void exportGiftInfoExcel(@Valid GiftInfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<GiftInfoDO> list = giftInfoService.getGiftInfoList(exportReqVO);
        // 导出 Excel
        List<GiftInfoExcelVO> datas = GiftInfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "赠品.xls", "数据", GiftInfoExcelVO.class, datas);
    }

}
