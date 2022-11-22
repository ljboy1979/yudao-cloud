package cn.acsm.module.enterprise.controller.admin.otheraccountinfo;

import cn.acsm.module.enterprise.controller.admin.otheraccountinfo.vo.*;
import cn.acsm.module.enterprise.convert.otheraccountinfo.OtherAccountInfoConvert;
import cn.acsm.module.enterprise.dal.dataobject.otheraccountinfo.OtherAccountInfoDO;
import cn.acsm.module.enterprise.service.otheraccountinfo.OtherAccountInfoService;
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


@Api(tags = "管理后台 - 经营主体其他账户")
@RestController
@RequestMapping("/enterprise/other-account-info")
@Validated
public class OtherAccountInfoController {

    @Resource
    private OtherAccountInfoService otherAccountInfoService;

    @PostMapping("/create")
    @ApiOperation("创建经营主体其他账户")
    @PreAuthorize("@ss.hasPermission('enterprise:other-account-info:create')")
    public CommonResult<Long> createOtherAccountInfo(@Valid @RequestBody OtherAccountInfoCreateReqVO createReqVO) {
        return success(otherAccountInfoService.createOtherAccountInfo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新经营主体其他账户")
    @PreAuthorize("@ss.hasPermission('enterprise:other-account-info:update')")
    public CommonResult<Boolean> updateOtherAccountInfo(@Valid @RequestBody OtherAccountInfoUpdateReqVO updateReqVO) {
        otherAccountInfoService.updateOtherAccountInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除经营主体其他账户")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('enterprise:other-account-info:delete')")
    public CommonResult<Boolean> deleteOtherAccountInfo(@RequestParam("id") Long id) {
        otherAccountInfoService.deleteOtherAccountInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得经营主体其他账户")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('enterprise:other-account-info:query')")
    public CommonResult< OtherAccountInfoRespVO > getOtherAccountInfo(@RequestParam("id") Long id) {
        OtherAccountInfoDO otherAccountInfo = otherAccountInfoService.getOtherAccountInfo(id);
        return success(OtherAccountInfoConvert.INSTANCE.convert(otherAccountInfo));
    }

    @GetMapping("/list")
    @ApiOperation("获得经营主体其他账户列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('enterprise:other-account-info:query')")
    public CommonResult<List<OtherAccountInfoRespVO>> getOtherAccountInfoList(@RequestParam("ids") Collection<Long> ids) {
        List< OtherAccountInfoDO > list = otherAccountInfoService.getOtherAccountInfoList(ids);
        return success(OtherAccountInfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得经营主体其他账户分页")
    @PreAuthorize("@ss.hasPermission('enterprise:other-account-info:query')")
    public CommonResult<PageResult<OtherAccountInfoRespVO>> getOtherAccountInfoPage(@Valid OtherAccountInfoPageReqVO pageVO) {
        PageResult< OtherAccountInfoDO > pageResult = otherAccountInfoService.getOtherAccountInfoPage(pageVO);
        return success(OtherAccountInfoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出经营主体其他账户 Excel")
    @PreAuthorize("@ss.hasPermission('enterprise:other-account-info:export')")
    @OperateLog(type = EXPORT)
    public void exportOtherAccountInfoExcel(@Valid OtherAccountInfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List< OtherAccountInfoDO > list = otherAccountInfoService.getOtherAccountInfoList(exportReqVO);
        // 导出 Excel
        List<OtherAccountInfoExcelVO> datas = OtherAccountInfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "经营主体其他账户.xls", "数据", OtherAccountInfoExcelVO.class, datas);
    }

}
