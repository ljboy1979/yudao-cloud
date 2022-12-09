package cn.acsm.module.resource.controller.admin.adoptright;

import cn.acsm.module.resource.controller.admin.adoptright.vo.*;
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

import cn.acsm.module.resource.dal.dataobject.adoptright.AdoptRightDO;
import cn.acsm.module.resource.convert.adoptright.AdoptRightConvert;
import cn.acsm.module.resource.service.adoptright.AdoptRightService;

@Api(tags = "管理后台 - 认养/租凭权益")
@RestController
@RequestMapping("/resource/adopt-right")
@Validated
public class AdoptRightController {

    @Resource
    private AdoptRightService adoptRightService;

    @PostMapping("/create")
    @ApiOperation("创建认养/租凭权益")
    @PreAuthorize("@ss.hasPermission('service:adopt-right:create')")
    public CommonResult<Long> createAdoptRight(@Valid @RequestBody AdoptRightCreateReqVO createReqVO) {
        return success(adoptRightService.createAdoptRight(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新认养/租凭权益")
    @PreAuthorize("@ss.hasPermission('service:adopt-right:update')")
    public CommonResult<Boolean> updateAdoptRight(@Valid @RequestBody AdoptRightUpdateReqVO updateReqVO) {
        adoptRightService.updateAdoptRight(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除认养/租凭权益")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:adopt-right:delete')")
    public CommonResult<Boolean> deleteAdoptRight(@RequestParam("id") Long id) {
        adoptRightService.deleteAdoptRight(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得认养/租凭权益")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:adopt-right:query')")
    public CommonResult<AdoptRightRespVO> getAdoptRight(@RequestParam("id") Long id) {
        AdoptRightDO adoptRight = adoptRightService.getAdoptRight(id);
        return success(AdoptRightConvert.INSTANCE.convert(adoptRight));
    }

    @GetMapping("/list")
    @ApiOperation("获得认养/租凭权益列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('service:adopt-right:query')")
    public CommonResult<List<AdoptRightRespVO>> getAdoptRightList(@RequestParam("ids") Collection<Long> ids) {
        List<AdoptRightDO> list = adoptRightService.getAdoptRightList(ids);
        return success(AdoptRightConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得认养/租凭权益分页")
    @PreAuthorize("@ss.hasPermission('service:adopt-right:query')")
    public CommonResult<PageResult<AdoptRightRespVO>> getAdoptRightPage(@Valid AdoptRightPageReqVO pageVO) {
        PageResult<AdoptRightDO> pageResult = adoptRightService.getAdoptRightPage(pageVO);
        return success(AdoptRightConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出认养/租凭权益 Excel")
    @PreAuthorize("@ss.hasPermission('service:adopt-right:export')")
    @OperateLog(type = EXPORT)
    public void exportAdoptRightExcel(@Valid AdoptRightExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<AdoptRightDO> list = adoptRightService.getAdoptRightList(exportReqVO);
        // 导出 Excel
        List<AdoptRightExcelVO> datas = AdoptRightConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "认养/租凭权益.xls", "数据", AdoptRightExcelVO.class, datas);
    }

}
