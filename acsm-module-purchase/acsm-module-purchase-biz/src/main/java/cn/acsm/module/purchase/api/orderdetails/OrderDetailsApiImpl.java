package cn.acsm.module.purchase.api.orderdetails;

import cn.acsm.module.purchase.api.orderdetails.vo.OrderDetailsApiVO;
import cn.acsm.module.purchase.service.details.PurchaseDetailsService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static cn.iocoder.yudao.module.system.enums.ApiConstants.VERSION;

/**
 * <pre>
 * 对象功能: OrderDetailsApiImpl.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/28
 * <pre>
 */
@RestController // 提供 RESTful API 接口，给 Feign 调用
@DubboService(version = VERSION) // 提供 Dubbo RPC 接口，给 Dubbo Consumer 调用
@Validated
@Transactional
public class OrderDetailsApiImpl implements OrderDetailsApi {

    @Resource
    private PurchaseDetailsService detailsService;

    @Override
    public List<OrderDetailsApiVO> getOrderDetails(String purchaseNumber) {
        return detailsService.getDetailsList(purchaseNumber);
    }

}
