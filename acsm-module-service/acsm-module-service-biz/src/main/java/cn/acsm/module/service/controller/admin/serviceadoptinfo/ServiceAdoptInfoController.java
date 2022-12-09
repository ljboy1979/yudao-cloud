package cn.acsm.module.service.controller.admin.serviceadoptinfo;

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

import cn.acsm.module.service.controller.admin.serviceadoptinfo.vo.*;
import cn.acsm.module.service.dal.dataobject.serviceadoptinfo.ServiceAdoptInfoDO;
import cn.acsm.module.service.convert.serviceadoptinfo.ServiceAdoptInfoConvert;
import cn.acsm.module.service.service.serviceadoptinfo.ServiceAdoptInfoService;

@Api(tags = "管理后台 - 认养信息")
@RestController
@RequestMapping("/service/adopt-info")
@Validated
public class ServiceAdoptInfoController {

    @Resource
    private ServiceAdoptInfoService adoptInfoService;

    @PostMapping("/create")
    @ApiOperation("创建认养信息")
    @PreAuthorize("@ss.hasPermission('service:adopt-info:create')")
    public CommonResult<Long> createAdoptInfo(@Valid @RequestBody ServiceAdoptInfoCreateReqVO createReqVO) {
        return success(adoptInfoService.createAdoptInfo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新认养信息")
    @PreAuthorize("@ss.hasPermission('service:adopt-info:update')")
    public CommonResult<Boolean> updateAdoptInfo(@Valid @RequestBody ServiceAdoptInfoUpdateReqVO updateReqVO) {
        adoptInfoService.updateAdoptInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除认养信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:adopt-info:delete')")
    public CommonResult<Boolean> deleteAdoptInfo(@RequestParam("id") Long id) {
        adoptInfoService.deleteAdoptInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得认养信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:adopt-info:query')")
    public CommonResult<ServiceAdoptInfoRespVO> getAdoptInfo(@RequestParam("id") Long id) {
        ServiceAdoptInfoDO adoptInfo = adoptInfoService.getAdoptInfo(id);
        return success(ServiceAdoptInfoConvert.INSTANCE.convert(adoptInfo));
    }

    @GetMapping("/list")
    @ApiOperation("获得认养信息列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('service:adopt-info:query')")
    public CommonResult<List<ServiceAdoptInfoRespVO>> getAdoptInfoList(@RequestParam("ids") Collection<Long> ids) {
        List<ServiceAdoptInfoDO> list = adoptInfoService.getAdoptInfoList(ids);
        return success(ServiceAdoptInfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得认养信息分页")
    @PreAuthorize("@ss.hasPermission('service:adopt-info:query')")
    public CommonResult<PageResult<ServiceAdoptInfoRespVO>> getAdoptInfoPage(@Valid ServiceAdoptInfoPageReqVO pageVO) {
        PageResult<ServiceAdoptInfoDO> pageResult = adoptInfoService.getAdoptInfoPage(pageVO);
        return success(ServiceAdoptInfoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出认养信息 Excel")
    @PreAuthorize("@ss.hasPermission('service:adopt-info:export')")
    @OperateLog(type = EXPORT)
    public void exportAdoptInfoExcel(@Valid ServiceAdoptInfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ServiceAdoptInfoDO> list = adoptInfoService.getAdoptInfoList(exportReqVO);
        // 导出 Excel
        List<ServiceAdoptInfoExcelVO> datas = ServiceAdoptInfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "认养信息.xls", "数据", ServiceAdoptInfoExcelVO.class, datas);
    }

}
