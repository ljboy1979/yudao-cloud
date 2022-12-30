package cn.acsm.module.production.facility.controller.admin.cargospace;

import cn.acsm.module.production.facility.controller.admin.cargospace.vo.*;
import cn.acsm.module.production.facility.convert.cargospace.CargoSpaceConvert;
import cn.acsm.module.production.facility.dal.dataobject.cargospace.CargoSpaceDO;
import cn.acsm.module.production.facility.service.cargospace.CargoSpaceService;
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


@Api(tags = "管理后台 - 设施货位")
@RestController
@RequestMapping("/facility/cargo-space")
@Validated
public class CargoSpaceController {

    @Resource
    private CargoSpaceService cargoSpaceService;

    @PostMapping("/create")
    @ApiOperation("创建设施货位")
    @PreAuthorize("@ss.hasPermission('facility:cargo-space:create')")
    public CommonResult<Long> createCargoSpace(@Valid @RequestBody CargoSpaceCreateReqVO createReqVO) {
        return success(cargoSpaceService.createCargoSpace(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新设施货位")
    @PreAuthorize("@ss.hasPermission('facility:cargo-space:update')")
    public CommonResult<Boolean> updateCargoSpace(@Valid @RequestBody CargoSpaceUpdateReqVO updateReqVO) {
        cargoSpaceService.updateCargoSpace(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除设施货位")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('facility:cargo-space:delete')")
    public CommonResult<Boolean> deleteCargoSpace(@RequestParam("id") Long id) {
        cargoSpaceService.deleteCargoSpace(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得设施货位")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('facility:cargo-space:query')")
    public CommonResult<CargoSpaceRespVO> getCargoSpace(@RequestParam("id") Long id) {
        CargoSpaceDO cargoSpace = cargoSpaceService.getCargoSpace(id);
        return success(CargoSpaceConvert.INSTANCE.convert(cargoSpace));
    }

    @GetMapping("/list")
    @ApiOperation("获得设施货位列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('facility:cargo-space:query')")
    public CommonResult<List<CargoSpaceRespVO>> getCargoSpaceList(@RequestParam("ids") Collection<Long> ids) {
        List<CargoSpaceDO> list = cargoSpaceService.getCargoSpaceList(ids);
        return success(CargoSpaceConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得设施货位分页")
    @PreAuthorize("@ss.hasPermission('facility:cargo-space:query')")
    public CommonResult<PageResult<CargoSpaceRespVO>> getCargoSpacePage(@Valid CargoSpacePageReqVO pageVO) {
        PageResult<CargoSpaceDO> pageResult = cargoSpaceService.getCargoSpacePage(pageVO);
        return success(CargoSpaceConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出设施货位 Excel")
    @PreAuthorize("@ss.hasPermission('facility:cargo-space:export')")
    @OperateLog(type = EXPORT)
    public void exportCargoSpaceExcel(@Valid CargoSpaceExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<CargoSpaceDO> list = cargoSpaceService.getCargoSpaceList(exportReqVO);
        // 导出 Excel
        List<CargoSpaceExcelVO> datas = CargoSpaceConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "设施货位.xls", "数据", CargoSpaceExcelVO.class, datas);
    }

}
