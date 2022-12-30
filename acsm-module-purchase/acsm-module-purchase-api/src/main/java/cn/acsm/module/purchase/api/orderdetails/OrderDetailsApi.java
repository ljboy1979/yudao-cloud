package cn.acsm.module.purchase.api.orderdetails;

import cn.acsm.module.purchase.api.orderdetails.vo.OrderDetailsApiVO;
import cn.acsm.module.purchase.enums.ApiConstants;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * <pre>
 * 对象功能: OrderDetailsApi.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/28
 * <pre>
 */
@FeignClient(value = ApiConstants.NAME,path = "/purchase/deliver")
@Api(tags = "RPC 服务 - 根据入库来源获取来源批次")
public interface OrderDetailsApi {

    @GetMapping("/get/order")
    @ApiOperation("根据入库来源获取来源批次")
    CommonResult<List<OrderDetailsApiVO>> getOrderDetails();

}
