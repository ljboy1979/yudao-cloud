package cn.acsm.module.purchase.api.orderdetails;

import cn.acsm.module.purchase.api.orderdetails.vo.OrderDetailsApiVO;
import cn.acsm.module.purchase.enums.ApiConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <pre>
 * 对象功能: OrderDetailsApi.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/28
 * <pre>
 */
@FeignClient(value = ApiConstants.NAME,path = "stock/feign/order/details")
@Api(tags = "RPC 服务 - 根据入库来源获取来源批次")
public interface OrderDetailsApi {

    @RequestMapping("/get/details/number")
    @ApiOperation("根据入库来源获取来源批次")
    List<OrderDetailsApiVO> getOrderDetails(@RequestParam("purchaseNumber") String purchaseNumber);

}
