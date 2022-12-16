package cn.acsm.module.production.bases.controller.admin.partitions;

import cn.acsm.module.production.bases.controller.admin.partitions.vo.*;
import cn.acsm.module.production.bases.convert.partitions.PartitionsConvert;
import cn.acsm.module.production.bases.dal.dataobject.partitions.PartitionsDO;
import cn.acsm.module.production.bases.service.partitions.PartitionsService;
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

@Api(tags = "管理后台 - 分区信息")
@RestController
@RequestMapping("/bases/partitions")
@Validated
public class PartitionsController {

    @Resource
    private PartitionsService partitionsService;

    @PostMapping("/create")
    @ApiOperation("创建分区信息")
    @PreAuthorize("@ss.hasPermission('bases:partitions:create')")
    public CommonResult<Long> createPartitions(@Valid @RequestBody PartitionsCreateReqVO createReqVO) {
        return success(partitionsService.createPartitions(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新分区信息")
    @PreAuthorize("@ss.hasPermission('bases:partitions:update')")
    public CommonResult<Boolean> updatePartitions(@Valid @RequestBody PartitionsUpdateReqVO updateReqVO) {
        partitionsService.updatePartitions(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除分区信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bases:partitions:delete')")
    public CommonResult<Boolean> deletePartitions(@RequestParam("id") Long id) {
        partitionsService.deletePartitions(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得分区信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bases:partitions:query')")
    public CommonResult<PartitionsRespVO> getPartitions(@RequestParam("id") Long id) {
        PartitionsDO partitions = partitionsService.getPartitions(id);
        return success(PartitionsConvert.INSTANCE.convert(partitions));
    }

    @GetMapping("/list")
    @ApiOperation("获得分区信息列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('bases:partitions:query')")
    public CommonResult<List<PartitionsRespVO>> getPartitionsList(@RequestParam("ids") Collection<Long> ids) {
        List<PartitionsDO> list = partitionsService.getPartitionsList(ids);
        return success(PartitionsConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得分区信息分页")
    @PreAuthorize("@ss.hasPermission('bases:partitions:query')")
    public CommonResult<PageResult<PartitionsRespVO>> getPartitionsPage(@Valid PartitionsPageReqVO pageVO) {
        PageResult<PartitionsDO> pageResult = partitionsService.getPartitionsPage(pageVO);
        return success(PartitionsConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出分区信息 Excel")
    @PreAuthorize("@ss.hasPermission('bases:partitions:export')")
    @OperateLog(type = EXPORT)
    public void exportPartitionsExcel(@Valid PartitionsExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<PartitionsDO> list = partitionsService.getPartitionsList(exportReqVO);
        // 导出 Excel
        List<PartitionsExcelVO> datas = PartitionsConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "分区信息.xls", "数据", PartitionsExcelVO.class, datas);
    }

}
