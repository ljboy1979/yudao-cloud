package cn.acsm.module.purchase.feign;

import cn.acsm.module.transaction.sales.api.shelves.ShelvesApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <pre>
 * 对象功能: ShelvesApiFeignClient.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/23
 * <pre>
 */
@FeignClient(name="sales-server")
public interface ShelvesApiFeignClient extends ShelvesApi {
}
