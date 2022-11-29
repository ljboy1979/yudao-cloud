package cn.iocoder.yudao.module.system.controller.admin.area;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.area.TreeSelect;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.area.TreeUtils;
import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import cn.iocoder.yudao.framework.tenant.core.aop.TenantIgnore;
import cn.iocoder.yudao.module.system.controller.admin.area.vo.*;
import cn.iocoder.yudao.module.system.convert.area.AreaConvert;
import cn.iocoder.yudao.module.system.dal.dataobject.area.AreaDO;
import cn.iocoder.yudao.module.system.service.area.AreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;


@Api(tags = "管理后台 - 行政区划")
@RestController
@RequestMapping("/system/area")
@Validated
public class AreaController {

    @Resource
    private AreaService areaService;

    @PostMapping("/create")
    @ApiOperation("创建行政区划")
    @PreAuthorize("@ss.hasPermission('system:area:create')")
    public CommonResult<Long> createArea(@Valid @RequestBody AreaCreateReqVO createReqVO) {
        return success(areaService.createArea(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新行政区划")
    @PreAuthorize("@ss.hasPermission('system:area:update')")
    public CommonResult<Boolean> updateArea(@Valid @RequestBody AreaUpdateReqVO updateReqVO) {
        areaService.updateArea(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除行政区划")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('system:area:delete')")
    public CommonResult<Boolean> deleteArea(@RequestParam("id") Long id) {
        areaService.deleteArea(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得行政区划")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('system:area:query')")
    public CommonResult< AreaRespVO > getArea(@RequestParam("id") Long id) {
        AreaDO area = areaService.getArea(id);
        return success(AreaConvert.INSTANCE.convert(area));
    }

    @GetMapping("/list")
    @ApiOperation("获得行政区划列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('system:area:query')")
    public CommonResult<List<AreaRespVO>> getAreaList(@RequestParam("ids") Collection<String> ids) {
        List<AreaDO> list = areaService.getAreaList(ids);
        return success(AreaConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得行政区划分页")
    @PreAuthorize("@ss.hasPermission('system:area:query')")
    public CommonResult<PageResult<AreaRespVO>> getAreaPage(@Valid AreaPageReqVO pageVO) {
        PageResult<AreaDO> pageResult = areaService.getAreaPage(pageVO);
        return success(AreaConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出行政区划 Excel")
    @PreAuthorize("@ss.hasPermission('system:area:export')")
    @OperateLog(type = EXPORT)
    public void exportAreaExcel(@Valid AreaExportReqVO exportReqVO,
                                HttpServletResponse response) throws IOException {
        List<AreaDO> list = areaService.getAreaList(exportReqVO);
        // 导出 Excel
        List<AreaExcelVO> datas = AreaConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "行政区划.xls", "数据", AreaExcelVO.class, datas);
    }

    /**
     * 查询全部组织架构树状结构列表（仅包含名称、id、子节点）
     */
    @GetMapping("/tree/all")
    @ApiOperation("获得行政区划树表")
    @TenantIgnore
    @PermitAll
    public CommonResult<List< TreeSelect >> treeSelect() {
        List<AreaDO> areaList = areaService.getAreaTreeList();
        List< AreaTreeVO > areaTreeVos = areaList.stream().map(o -> AreaConvert.convertListToTree(o)).collect(Collectors.toList());
        List<TreeSelect> treeSelects = TreeUtils.
                buildTreeSelect(areaTreeVos);
        return success(treeSelects);
    }
}
