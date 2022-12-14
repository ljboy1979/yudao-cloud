package cn.acsm.module.purchase.api.purchase;

import cn.acsm.module.purchase.api.purchase.dto.PurchaseOrderReqDTO;
import cn.acsm.module.purchase.enums.ApiConstants;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <pre>
 * 对象功能: PurchaseorderApi.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/13
 * <pre>
 */
@FeignClient(name = ApiConstants.NAME) // TODO 芋艿：fallbackFactory =
@Api(tags = "RPC 服务 - 采购数据")
public interface PurchaseorderApi {

    String PREFIX = ApiConstants.PREFIX + "/purchase";

    @GetMapping(PREFIX + "/get")
    @ApiOperation("获得指定的采购数据")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataTypeClass = String.class)
    CommonResult<PurchaseOrderReqDTO> getPurchaseOrderById(@RequestParam("id") String id);

    @GetMapping(PREFIX + "/listNotIn")
    @ApiOperation("获得指定的采购数据List")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataTypeClass = String.class)
    CommonResult<List<PurchaseOrderReqDTO>> getPurchaseOrderList(@RequestParam("id") String id);

}
