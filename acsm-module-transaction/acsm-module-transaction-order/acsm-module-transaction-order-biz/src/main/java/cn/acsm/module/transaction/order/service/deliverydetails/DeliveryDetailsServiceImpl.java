package cn.acsm.module.transaction.order.service.deliverydetails;

import cn.acsm.module.transaction.order.util.ConfigNumberUtil;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.order.controller.admin.deliverydetails.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.deliverydetails.DeliveryDetailsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.order.convert.deliverydetails.DeliveryDetailsConvert;
import cn.acsm.module.transaction.order.dal.mysql.deliverydetails.*;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.order.enums.ErrorCodeConstants.*;

/**
 * 配送详情 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class DeliveryDetailsServiceImpl implements DeliveryDetailsService {

    @Resource
    private DeliveryDetailsMapper deliveryDetailsMapper;
    @Resource
    private ConfigNumberUtil configNumberUtil;
    @Override
    public String createDeliveryDetails(DeliveryDetailsCreateReqVO createReqVO) {
        Long tenantId = SecurityFrameworkUtils.getLoginUser().getTenantId();
        String number = configNumberUtil.getNumber("order_delivery_details"+tenantId);
        // 插入
        DeliveryDetailsDO deliveryDetails = DeliveryDetailsConvert.INSTANCE.convert(createReqVO);
        deliveryDetails.setId(UUID.randomUUID().toString());
        deliveryDetails.setCode("PSXQ"+number);
        deliveryDetailsMapper.insert(deliveryDetails);
        // 返回
        return deliveryDetails.getId();
    }

    @Override
    public void updateDeliveryDetails(DeliveryDetailsUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateDeliveryDetailsExists(updateReqVO.getId());
        // 更新
        DeliveryDetailsDO updateObj = DeliveryDetailsConvert.INSTANCE.convert(updateReqVO);
        deliveryDetailsMapper.updateById(updateObj);
    }

    @Override
    public void deleteDeliveryDetails(String id) {
        // 校验存在
        this.validateDeliveryDetailsExists(id);
        // 删除
        deliveryDetailsMapper.deleteById(id);
    }

    private void validateDeliveryDetailsExists(String id) {
        if (deliveryDetailsMapper.selectById(id) == null) {
            throw exception(DELIVERY_DETAILS_NOT_EXISTS);
        }
    }

    @Override
    public DeliveryDetailsDO getDeliveryDetails(String id) {
        return deliveryDetailsMapper.selectById(id);
    }

    @Override
    public List<DeliveryDetailsDO> getDeliveryDetailsList(Collection<String> ids) {
        return deliveryDetailsMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<DeliveryDetailsDO> getDeliveryDetailsPage(DeliveryDetailsPageReqVO pageReqVO) {
        return deliveryDetailsMapper.selectPage(pageReqVO);
    }

    @Override
    public List<DeliveryDetailsDO> getDeliveryDetailsList(DeliveryDetailsExportReqVO exportReqVO) {
        return deliveryDetailsMapper.selectList(exportReqVO);
    }

}
