package cn.acsm.module.enterprise.controller.admin.othercertificateinfo;

import cn.acsm.module.enterprise.convert.othercertificateinfo.OtherCertificateInfoConvert;
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

import cn.acsm.module.enterprise.controller.admin.othercertificateinfo.vo.*;
import cn.acsm.module.enterprise.dal.dataobject.othercertificateinfo.OtherCertificateInfoDO;
import cn.acsm.module.enterprise.service.othercertificateinfo.OtherCertificateInfoService;

@Api(tags = "管理后台 - 经营主体其他证件")
@RestController
@RequestMapping("/enterprise/other-certificate-info")
@Validated
public class OtherCertificateInfoController {

    @Resource
    private OtherCertificateInfoService otherCertificateInfoService;

    @PostMapping("/create")
    @ApiOperation("创建经营主体其他证件")
    @PreAuthorize("@ss.hasPermission('enterprise:other-certificate-info:create')")
    public CommonResult<Long> createOtherCertificateInfo(@Valid @RequestBody OtherCertificateInfoCreateReqVO createReqVO) {
        return success(otherCertificateInfoService.createOtherCertificateInfo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新经营主体其他证件")
    @PreAuthorize("@ss.hasPermission('enterprise:other-certificate-info:update')")
    public CommonResult<Boolean> updateOtherCertificateInfo(@Valid @RequestBody OtherCertificateInfoUpdateReqVO updateReqVO) {
        otherCertificateInfoService.updateOtherCertificateInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除经营主体其他证件")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('enterprise:other-certificate-info:delete')")
    public CommonResult<Boolean> deleteOtherCertificateInfo(@RequestParam("id") Long id) {
        otherCertificateInfoService.deleteOtherCertificateInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得经营主体其他证件")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('enterprise:other-certificate-info:query')")
    public CommonResult<OtherCertificateInfoRespVO> getOtherCertificateInfo(@RequestParam("id") Long id) {
        OtherCertificateInfoDO otherCertificateInfo = otherCertificateInfoService.getOtherCertificateInfo(id);
        return success(OtherCertificateInfoConvert.INSTANCE.convert(otherCertificateInfo));
    }

    @GetMapping("/list")
    @ApiOperation("获得经营主体其他证件列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('enterprise:other-certificate-info:query')")
    public CommonResult<List<OtherCertificateInfoRespVO>> getOtherCertificateInfoList(@RequestParam("ids") Collection<Long> ids) {
        List<OtherCertificateInfoDO> list = otherCertificateInfoService.getOtherCertificateInfoList(ids);
        return success(OtherCertificateInfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得经营主体其他证件分页")
    @PreAuthorize("@ss.hasPermission('enterprise:other-certificate-info:query')")
    public CommonResult<PageResult<OtherCertificateInfoRespVO>> getOtherCertificateInfoPage(@Valid OtherCertificateInfoPageReqVO pageVO) {
        PageResult<OtherCertificateInfoDO> pageResult = otherCertificateInfoService.getOtherCertificateInfoPage(pageVO);
        return success(OtherCertificateInfoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出经营主体其他证件 Excel")
    @PreAuthorize("@ss.hasPermission('enterprise:other-certificate-info:export')")
    @OperateLog(type = EXPORT)
    public void exportOtherCertificateInfoExcel(@Valid OtherCertificateInfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<OtherCertificateInfoDO> list = otherCertificateInfoService.getOtherCertificateInfoList(exportReqVO);
        // 导出 Excel
        List<OtherCertificateInfoExcelVO> datas = OtherCertificateInfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "经营主体其他证件.xls", "数据", OtherCertificateInfoExcelVO.class, datas);
    }

}
