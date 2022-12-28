package cn.acsm.module.transaction.shelves.controller.admin.specifications;

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

import cn.acsm.module.transaction.shelves.controller.admin.specifications.vo.*;
import cn.acsm.module.transaction.shelves.dal.dataobject.specifications.SpecificationsDO;
import cn.acsm.module.transaction.shelves.convert.specifications.SpecificationsConvert;
import cn.acsm.module.transaction.shelves.service.specifications.SpecificationsService;

@Api(tags = "管理后台 - 货架规格")
@RestController
@RequestMapping("/shelves/specifications")
@Validated
public class SpecificationsController {

    @Resource
    private SpecificationsService specificationsService;

    @PostMapping("/create")
    @ApiOperation("创建货架规格")
    @PreAuthorize("@ss.hasPermission('shelves:specifications:create')")
    public CommonResult<String> createSpecifications(@Valid @RequestBody SpecificationsCreateReqVO createReqVO) {
        return success(specificationsService.createSpecifications(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新货架规格")
    @PreAuthorize("@ss.hasPermission('shelves:specifications:update')")
    public CommonResult<Boolean> updateSpecifications(@Valid @RequestBody SpecificationsUpdateReqVO updateReqVO) {
        specificationsService.updateSpecifications(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除货架规格")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('shelves:specifications:delete')")
    public CommonResult<Boolean> deleteSpecifications(@RequestParam("id") String id) {
        specificationsService.deleteSpecifications(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得货架规格")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('shelves:specifications:query')")
    public CommonResult<SpecificationsRespVO> getSpecifications(@RequestParam("id") String id) {
        SpecificationsDO specifications = specificationsService.getSpecifications(id);
        SpecificationsRespVO specificationsRespVO = SpecificationsConvert.INSTANCE.convert(specifications);
        if ("0".equals(specificationsRespVO.getPackagingType())){
            specificationsRespVO.setSpecifications(specificationsRespVO.getNumber()+specificationsRespVO.getUnitName()+"/"+specificationsRespVO.getPackagingName());
        }
        return success(specificationsRespVO);
    }

    @GetMapping("/list")
    @ApiOperation("获得货架规格列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('shelves:specifications:query')")
    public CommonResult<List<SpecificationsRespVO>> getSpecificationsList(@RequestParam("ids") Collection<String> ids) {
        List<SpecificationsDO> list = specificationsService.getSpecificationsList(ids);
        return success(SpecificationsConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得货架规格分页")
    @PreAuthorize("@ss.hasPermission('shelves:specifications:query')")
    public CommonResult<PageResult<SpecificationsRespVO>> getSpecificationsPage(@Valid SpecificationsPageReqVO pageVO) {
        PageResult<SpecificationsDO> pageResult = specificationsService.getSpecificationsPage(pageVO);
        PageResult<SpecificationsRespVO> respVOPageResult = SpecificationsConvert.INSTANCE.convertPage(pageResult);
        respVOPageResult.getList().stream().forEach(specificationsRespVO -> {
            if ("0".equals(specificationsRespVO.getPackagingType())){
                specificationsRespVO.setSpecifications(specificationsRespVO.getNumber()+specificationsRespVO.getUnitName()+"/"+specificationsRespVO.getPackagingName());
            }
        });
        return success(respVOPageResult);
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出货架规格 Excel")
    @PreAuthorize("@ss.hasPermission('shelves:specifications:export')")
    @OperateLog(type = EXPORT)
    public void exportSpecificationsExcel(@Valid SpecificationsExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<SpecificationsDO> list = specificationsService.getSpecificationsList(exportReqVO);
        // 导出 Excel
        List<SpecificationsExcelVO> datas = SpecificationsConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "货架规格.xls", "数据", SpecificationsExcelVO.class, datas);
    }

    @PutMapping("/updateSpecificationsStatus")
    @ApiOperation("修改上下架")
    @PreAuthorize("@ss.hasPermission('shelves:specifications:update')")
    public CommonResult<Boolean> updateSpecificationsStatus(@Valid @RequestBody SpecificationsUpdateReqVO updateReqVO) {
        specificationsService.updateSpecifications(updateReqVO);
        return success(true);
    }

}
