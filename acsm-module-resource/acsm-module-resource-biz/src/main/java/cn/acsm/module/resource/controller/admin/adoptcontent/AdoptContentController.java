package cn.acsm.module.resource.controller.admin.adoptcontent;

import cn.acsm.module.resource.controller.admin.adoptcontent.vo.*;
import cn.acsm.module.resource.convert.adoptcontent.AdoptContentConvert;
import cn.acsm.module.resource.service.adoptcontent.AdoptContentService;
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

import cn.acsm.module.resource.dal.dataobject.adoptcontent.AdoptContentDO;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "管理后台 - 认养物/租凭物")
@RestController
@RequestMapping("/resource/adopt-content")
@Validated
public class AdoptContentController {

    @Resource
    private AdoptContentService adoptContentService;

    @PostMapping("/create")
    @ApiOperation("创建认养物/租凭物")
    @PreAuthorize("@ss.hasPermission('service:adopt-content:create')")
    public CommonResult<String> createAdoptContent(@Valid @RequestBody AdoptContentCreateReqVO createReqVO) {
        adoptContentService.createAdoptContent(createReqVO);
        return success("保存成功");
    }

    @PutMapping("/update")
    @ApiOperation("更新认养物/租凭物")
    @PreAuthorize("@ss.hasPermission('service:adopt-content:update')")
    public CommonResult<Boolean> updateAdoptContent(@Valid @RequestBody AdoptContentUpdateReqVO updateReqVO) {
        adoptContentService.updateAdoptContent(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除认养物/租凭物")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:adopt-content:delete')")
    public CommonResult<Boolean> deleteAdoptContent(@RequestParam("id") Long id) {
        adoptContentService.deleteAdoptContent(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得认养物/租凭物")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:adopt-content:query')")
    public CommonResult<AdoptContentRespVO> getAdoptContent(@RequestParam("id") Long id) {
        AdoptContentDO adoptContent = adoptContentService.getAdoptContent(id);
        return success(AdoptContentConvert.INSTANCE.convert(adoptContent));
    }

    @GetMapping("/list")
    @ApiOperation("获得认养物/租凭物列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('service:adopt-content:query')")
    public CommonResult<List<AdoptContentRespVO>> getAdoptContentList(@RequestParam("ids") Collection<Long> ids) {
        List<AdoptContentDO> list = adoptContentService.getAdoptContentList(ids);
        return success(AdoptContentConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得认养物/租凭物分页")
    @PreAuthorize("@ss.hasPermission('service:adopt-content:query')")
    public CommonResult<PageResult<AdoptContentRespVO>> getAdoptContentPage(@Valid AdoptContentPageReqVO pageVO) {
        PageResult<AdoptContentDO> pageResult = adoptContentService.getAdoptContentPage(pageVO);
        return success(AdoptContentConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出认养物/租凭物 Excel")
    @PreAuthorize("@ss.hasPermission('service:adopt-content:export')")
    @OperateLog(type = EXPORT)
    public void exportAdoptContentExcel(@Valid AdoptContentExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<AdoptContentDO> list = adoptContentService.getAdoptContentList(exportReqVO);
        // 导出 Excel
        List<AdoptContentExcelVO> datas = AdoptContentConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "认养物/租凭物.xls", "数据", AdoptContentExcelVO.class, datas);
    }

    @GetMapping("/export-excelRY")
    @ApiOperation("导出认养物模板 Excel")
    @OperateLog(type = EXPORT)
    public void exportAdoptContentExcelRY(HttpServletResponse response) throws IOException {
        // 导出认养物模板 Excel
        List<AdoptContentExcelRYVO> list = new ArrayList<>();
        ExcelUtils.write(response, "认养物导入模板.xls", "数据", AdoptContentExcelRYVO.class, list);
    }

    @GetMapping("/export-excelZP")
    @ApiOperation("导出租凭物模板 Excel")
    @OperateLog(type = EXPORT)
    public void exportAdoptContentExcelZP(HttpServletResponse response) throws IOException {
        // 导出租凭物模板 Excel
        List<AdoptContentExcelZPVO> list = new ArrayList<>();
        ExcelUtils.write(response, "租凭物导入模板.xls", "数据", AdoptContentExcelZPVO.class, list);
    }

    @GetMapping("/export-importRY")
    @ApiOperation("导入认养物 Excel")
    @OperateLog(type = IMPORT)
    public CommonResult<String> exportAdoptContentImportRY(@RequestParam("file")MultipartFile file) throws IOException {
        // 导入认养物 Excel
        List<AdoptContentExcelRYVO> list = ExcelUtils.read(file,AdoptContentExcelRYVO.class);
        String s = adoptContentService.importRY(list);
        return success(s);
    }

    @GetMapping("/export-importZP")
    @ApiOperation("导入租凭物 Excel")
    @OperateLog(type = IMPORT)
    public CommonResult<String> exportAdoptContentImportZP(@RequestParam("file")MultipartFile file) throws IOException {
        // 导出租凭物 Excel
        List<AdoptContentExcelZPVO> list = ExcelUtils.read(file,AdoptContentExcelZPVO.class);
        String s = adoptContentService.importZP(list);
        return success(s);
    }

    @GetMapping("/listAdoptService")
    @ApiOperation("获得没关联服务的认养物/租凭物列表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "type", value = "资源类型字段（1-认养物；2-租赁物）", required = true, dataTypeClass = String.class),
        @ApiImplicitParam(name = "serviceId", value = "服务id", required = false, dataTypeClass = String.class)
    })
    public CommonResult<List<AdoptContentRespVO>> listAdoptService(@RequestParam("type") String type,
                                                                   @RequestParam("serviceId")String serviceId) {
        List<AdoptContentRespVO> list = adoptContentService.listAdoptService(type,serviceId);
        return success(list);
    }

}
