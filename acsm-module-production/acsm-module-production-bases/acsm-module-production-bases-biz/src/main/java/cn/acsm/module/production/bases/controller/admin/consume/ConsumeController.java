package cn.acsm.module.production.bases.controller.admin.consume;

import cn.acsm.module.production.bases.controller.admin.consume.vo.*;
import cn.acsm.module.production.bases.convert.consume.ConsumeConvert;
import cn.acsm.module.production.bases.dal.dataobject.consume.ConsumeDO;
import cn.acsm.module.production.bases.service.consume.ConsumeService;
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

@Api(tags = "管理后台 - 基地能耗信息")
@RestController
@RequestMapping("/bases/consume")
@Validated
public class ConsumeController {

    @Resource
    private ConsumeService consumeService;

    @PostMapping("/create")
    @ApiOperation("创建基地能耗信息")
    @PreAuthorize("@ss.hasPermission('bases:consume:create')")
    public CommonResult<Long> createConsume(@Valid @RequestBody ConsumeCreateReqVO createReqVO) {
        return success(consumeService.createConsume(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新基地能耗信息")
    @PreAuthorize("@ss.hasPermission('bases:consume:update')")
    public CommonResult<Boolean> updateConsume(@Valid @RequestBody ConsumeUpdateReqVO updateReqVO) {
        consumeService.updateConsume(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除基地能耗信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bases:consume:delete')")
    public CommonResult<Boolean> deleteConsume(@RequestParam("id") Long id) {
        consumeService.deleteConsume(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得基地能耗信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bases:consume:query')")
    public CommonResult<ConsumeRespVO> getConsume(@RequestParam("id") Long id) {
        ConsumeDO consume = consumeService.getConsume(id);
        return success(ConsumeConvert.INSTANCE.convert(consume));
    }

    @GetMapping("/list")
    @ApiOperation("获得基地能耗信息列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('bases:consume:query')")
    public CommonResult<List<ConsumeRespVO>> getConsumeList(@RequestParam("ids") Collection<Long> ids) {
        List<ConsumeDO> list = consumeService.getConsumeList(ids);
        return success(ConsumeConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得基地能耗信息分页")
    @PreAuthorize("@ss.hasPermission('bases:consume:query')")
    public CommonResult<PageResult<ConsumeRespVO>> getConsumePage(@Valid ConsumePageReqVO pageVO) {
        PageResult<ConsumeDO> pageResult = consumeService.getConsumePage(pageVO);
        return success(ConsumeConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出基地能耗信息 Excel")
    @PreAuthorize("@ss.hasPermission('bases:consume:export')")
    @OperateLog(type = EXPORT)
    public void exportConsumeExcel(@Valid ConsumeExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ConsumeDO> list = consumeService.getConsumeList(exportReqVO);
        // 导出 Excel
        List<ConsumeExcelVO> datas = ConsumeConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "基地能耗信息.xls", "数据", ConsumeExcelVO.class, datas);
    }

}
