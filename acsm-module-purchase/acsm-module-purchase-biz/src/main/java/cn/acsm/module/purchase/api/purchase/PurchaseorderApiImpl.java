package cn.acsm.module.purchase.api.purchase;

import cn.acsm.module.purchase.api.purchase.dto.PurchaseOrderReqDTO;
import cn.acsm.module.purchase.controller.admin.purchase.vo.PurchaseExportReqVO;
import cn.acsm.module.purchase.convert.purchase.PurchaseConvert;
import cn.acsm.module.purchase.dal.dataobject.purchase.PurchaseDO;
import cn.acsm.module.purchase.service.purchase.PurchaseService;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static cn.acsm.module.purchase.enums.ApiConstants.VERSION;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * <pre>
 * 对象功能: PurchaseorderApiImpl.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/13
 * <pre>
 */
@RestController // 提供 RESTful API 接口，给 Feign 调用
@DubboService(version = VERSION) // 提供 Dubbo RPC 接口，给 Dubbo Consumer 调用
@Validated
public class PurchaseorderApiImpl implements PurchaseorderApi {

    @Resource
    private PurchaseService purchaseService;

    @Override
    public CommonResult<PurchaseOrderReqDTO> getPurchaseOrderById(String id) {
        PurchaseDO purchaseDO = purchaseService.getpurchase(Long.valueOf(id));
        return success(PurchaseConvert.INSTANCE.convert01(purchaseDO));
    }

    @Override
    public CommonResult<List<PurchaseOrderReqDTO>> getPurchaseOrderList(String id) {
        PurchaseExportReqVO reqVO = new PurchaseExportReqVO();
        reqVO.setIds(id);
        List<PurchaseDO> dos = purchaseService.getpurchaseList(reqVO);
        return success(PurchaseConvert.INSTANCE.convertList01(dos));
    }
}
