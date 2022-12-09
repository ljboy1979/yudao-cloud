package cn.acsm.module.service.controller.admin.customerlist;

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

import cn.acsm.module.service.controller.admin.customerlist.vo.*;
import cn.acsm.module.service.dal.dataobject.customerlist.CustomerListDO;
import cn.acsm.module.service.convert.customerlist.CustomerListConvert;
import cn.acsm.module.service.service.customerlist.CustomerListService;

@Api(tags = "管理后台 - 服务客户名单")
@RestController
@RequestMapping("/service/customer-list")
@Validated
public class CustomerListController {

    @Resource
    private CustomerListService customerListService;

    @PostMapping("/create")
    @ApiOperation("创建服务客户名单")
    @PreAuthorize("@ss.hasPermission('service:customer-list:create')")
    public CommonResult<Long> createCustomerList(@Valid @RequestBody CustomerListCreateReqVO createReqVO) {
        return success(customerListService.createCustomerList(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新服务客户名单")
    @PreAuthorize("@ss.hasPermission('service:customer-list:update')")
    public CommonResult<Boolean> updateCustomerList(@Valid @RequestBody CustomerListUpdateReqVO updateReqVO) {
        customerListService.updateCustomerList(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除服务客户名单")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:customer-list:delete')")
    public CommonResult<Boolean> deleteCustomerList(@RequestParam("id") Long id) {
        customerListService.deleteCustomerList(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得服务客户名单")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:customer-list:query')")
    public CommonResult<CustomerListRespVO> getCustomerList(@RequestParam("id") Long id) {
        CustomerListDO customerList = customerListService.getCustomerList(id);
        return success(CustomerListConvert.INSTANCE.convert(customerList));
    }

    @GetMapping("/list")
    @ApiOperation("获得服务客户名单列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('service:customer-list:query')")
    public CommonResult<List<CustomerListRespVO>> getCustomerListList(@RequestParam("ids") Collection<Long> ids) {
        List<CustomerListDO> list = customerListService.getCustomerListList(ids);
        return success(CustomerListConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得服务客户名单分页")
    @PreAuthorize("@ss.hasPermission('service:customer-list:query')")
    public CommonResult<PageResult<CustomerListRespVO>> getCustomerListPage(@Valid CustomerListPageReqVO pageVO) {
        PageResult<CustomerListDO> pageResult = customerListService.getCustomerListPage(pageVO);
        return success(CustomerListConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出服务客户名单 Excel")
    @PreAuthorize("@ss.hasPermission('service:customer-list:export')")
    @OperateLog(type = EXPORT)
    public void exportCustomerListExcel(@Valid CustomerListExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<CustomerListDO> list = customerListService.getCustomerListList(exportReqVO);
        // 导出 Excel
        List<CustomerListExcelVO> datas = CustomerListConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "服务客户名单.xls", "数据", CustomerListExcelVO.class, datas);
    }

}
