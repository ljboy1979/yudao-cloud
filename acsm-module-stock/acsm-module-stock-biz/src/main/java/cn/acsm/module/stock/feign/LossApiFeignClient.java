package cn.acsm.module.stock.feign;

import cn.acsm.module.purchase.api.loss.LossApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <pre>
 * 对象功能: LossApiFeignClient.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/22
 * <pre>
 */
@FeignClient(name="purchase-server")
public interface LossApiFeignClient extends LossApi {

}
