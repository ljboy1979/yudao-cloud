package cn.acsm.module.purchase.api.loss;

import cn.acsm.module.purchase.api.loss.dto.LossReqDTO;
import cn.acsm.module.purchase.enums.ApiConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <pre>
 * 对象功能: LossApi.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/21
 * <pre>
 */
@FeignClient(value = ApiConstants.NAME,path = "purchase/feign/stock")
@Api(tags = "RPC 服务 - 创建损耗接口")
public interface LossApi {

    @PostMapping("/create/loss")
    @ApiOperation("创建损耗")
    boolean saveLossDto(@RequestBody LossReqDTO lossReqDTO);

}
