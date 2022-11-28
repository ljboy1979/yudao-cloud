package cn.acsm.module.member.user.controller.admin.integral;

import cn.acsm.module.member.user.controller.admin.integral.vo.level.*;
import cn.acsm.module.member.user.convert.integral.IntegralLevelConvert;
import cn.acsm.module.member.user.dal.dataobject.integral.IntegralLevelDO;
import cn.acsm.module.member.user.service.integral.IntegralLevelService;
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

@Api(tags = "管理后台 - 会员积分等级")
@RestController
@RequestMapping("/member/integral-level")
@Validated
public class IntegralLevelController {

    @Resource
    private IntegralLevelService integralLevelService;

    @PostMapping("/create")
    @ApiOperation("创建会员积分等级")
    @PreAuthorize("@ss.hasPermission('member:integral-level:create')")
    public CommonResult<Long> createIntegralLevel(@Valid @RequestBody IntegralLevelCreateReqVO createReqVO) {
        return success(integralLevelService.createIntegralLevel(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新会员积分等级")
    @PreAuthorize("@ss.hasPermission('member:integral-level:update')")
    public CommonResult<Boolean> updateIntegralLevel(@Valid @RequestBody IntegralLevelUpdateReqVO updateReqVO) {
        integralLevelService.updateIntegralLevel(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除会员积分等级")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:integral-level:delete')")
    public CommonResult<Boolean> deleteIntegralLevel(@RequestParam("id") Long id) {
        integralLevelService.deleteIntegralLevel(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得会员积分等级")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:integral-level:query')")
    public CommonResult<IntegralLevelRespVO> getIntegralLevel(@RequestParam("id") Long id) {
        IntegralLevelDO integralLevel = integralLevelService.getIntegralLevel(id);
        return success(IntegralLevelConvert.INSTANCE.convert(integralLevel));
    }

    @GetMapping("/list")
    @ApiOperation("获得会员积分等级列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('member:integral-level:query')")
    public CommonResult<List<IntegralLevelRespVO>> getIntegralLevelList(@RequestParam("ids") Collection<Long> ids) {
        List<IntegralLevelDO> list = integralLevelService.getIntegralLevelList(ids);
        return success(IntegralLevelConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得会员积分等级分页")
    @PreAuthorize("@ss.hasPermission('member:integral-level:query')")
    public CommonResult<PageResult<IntegralLevelRespVO>> getIntegralLevelPage(@Valid IntegralLevelPageReqVO pageVO) {
        PageResult<IntegralLevelDO> pageResult = integralLevelService.getIntegralLevelPage(pageVO);
        return success(IntegralLevelConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出会员积分等级 Excel")
    @PreAuthorize("@ss.hasPermission('member:integral-level:export')")
    @OperateLog(type = EXPORT)
    public void exportIntegralLevelExcel(@Valid IntegralLevelExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<IntegralLevelDO> list = integralLevelService.getIntegralLevelList(exportReqVO);
        // 导出 Excel
        List<IntegralLevelExcelVO> datas = IntegralLevelConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "会员积分等级.xls", "数据", IntegralLevelExcelVO.class, datas);
    }

}
