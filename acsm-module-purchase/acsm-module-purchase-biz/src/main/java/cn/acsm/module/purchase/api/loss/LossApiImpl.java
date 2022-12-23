package cn.acsm.module.purchase.api.loss;

import cn.acsm.module.purchase.api.loss.dto.LossReqDTO;
import cn.acsm.module.purchase.service.loss.PurchaseLossService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static cn.iocoder.yudao.module.system.enums.ApiConstants.VERSION;

/**
 * <pre>
 * 对象功能: LossApiImpl.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/22
 * <pre>
 */
@RestController // 提供 RESTful API 接口，给 Feign 调用
@DubboService(version = VERSION) // 提供 Dubbo RPC 接口，给 Dubbo Consumer 调用
@Validated
@Transactional
public class LossApiImpl implements LossApi {

    @Resource
    private PurchaseLossService lossService;

    @Override
    public boolean saveLossDto(@RequestBody LossReqDTO lossReqDTO) {
        return lossService.createLoss(lossReqDTO);
    }

}
