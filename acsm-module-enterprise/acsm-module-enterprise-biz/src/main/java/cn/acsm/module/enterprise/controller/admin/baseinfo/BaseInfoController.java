package cn.acsm.module.enterprise.controller.admin.baseinfo;

import cn.acsm.module.enterprise.controller.admin.baseinfo.vo.*;
import cn.acsm.module.enterprise.convert.baseinfo.BaseInfoConvert;
import cn.acsm.module.enterprise.dal.dataobject.baseinfo.BaseInfoDO;
import cn.acsm.module.enterprise.service.baseinfo.BaseInfoService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.*;

import javax.annotation.security.PermitAll;
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


@Api(tags = "管理后台 - 经营主体")
@RestController
@RequestMapping("/enterprise/base-info")
@Validated
@PermitAll
public class BaseInfoController {

    @Resource
    private BaseInfoService baseInfoService;

    @PostMapping("/create")
    @ApiOperation("创建经营主体")
    @PermitAll
//    @PreAuthorize("@ss.hasPermission('enterprise:base-info:create')")
    public CommonResult<Long> createBaseInfo(@Valid @RequestBody BaseInfoCreateReqVO createReqVO) {
        return success(baseInfoService.createBaseInfo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新经营主体")
    @PreAuthorize("@ss.hasPermission('enterprise:base-info:update')")
    public CommonResult<Boolean> updateBaseInfo(@Valid @RequestBody BaseInfoUpdateReqVO updateReqVO) {
        baseInfoService.updateBaseInfo(updateReqVO);
        return success(true);
    }
    @PutMapping("/stop")
    @ApiOperation("停用经营主体")
    @PreAuthorize("@ss.hasPermission('enterprise:base-info:update')")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<Boolean> stop(@RequestParam("id") Long id) {
        baseInfoService.stopEnterprise(id);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除经营主体")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('enterprise:base-info:delete')")
    public CommonResult<Boolean> deleteBaseInfo(@RequestParam("id") Long id) {
        baseInfoService.deleteBaseInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得经营主体")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('enterprise:base-info:query')")
    public CommonResult< BaseInfoRespVO > getBaseInfo(@RequestParam("id") Long id) {
        BaseInfoDO baseInfo = baseInfoService.getBaseInfo(id);
        return success(BaseInfoConvert.INSTANCE.convert(baseInfo));
    }

    @GetMapping("/list")
    @ApiOperation("获得经营主体列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('enterprise:base-info:query')")
    public CommonResult<List<BaseInfoRespVO>> getBaseInfoList(@RequestParam("ids") Collection<Long> ids) {
        List<BaseInfoDO> list = baseInfoService.getBaseInfoList(ids);
        return success(BaseInfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得经营主体分页")
//    @PreAuthorize("@ss.hasPermission('enterprise:base-info:query')")
    @PermitAll
    public CommonResult<PageResult<BaseInfoRespVO>> getBaseInfoPage(@Valid BaseInfoPageReqVO pageVO) {
        PageResult<BaseInfoDO> pageResult = baseInfoService.getBaseInfoPage(pageVO);
        return success(BaseInfoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出经营主体 Excel")
    @PreAuthorize("@ss.hasPermission('enterprise:base-info:export')")
    @OperateLog(type = EXPORT)
    public void exportBaseInfoExcel(@Valid BaseInfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<BaseInfoDO> list = baseInfoService.getBaseInfoList(exportReqVO);
        // 导出 Excel
        List<BaseInfoExcelVO> datas = BaseInfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "经营主体.xls", "数据", BaseInfoExcelVO.class, datas);
    }

}
