package cn.acsm.module.transaction.order.service.deliveryinfo;

import cn.acsm.module.transaction.order.util.ConfigNumberUtil;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.order.controller.admin.deliveryinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.deliveryinfo.DeliveryInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.order.convert.deliveryinfo.DeliveryInfoConvert;
import cn.acsm.module.transaction.order.dal.mysql.deliveryinfo.DeliveryInfoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.order.enums.ErrorCodeConstants.*;

/**
 * 配送 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class DeliveryInfoServiceImpl implements DeliveryInfoService {

    @Resource
    private DeliveryInfoMapper deliveryInfoMapper;
    @Resource
    private ConfigNumberUtil configNumberUtil;
    @Override
    public String createDeliveryInfo(DeliveryInfoCreateReqVO createReqVO) {
        Long tenantId = SecurityFrameworkUtils.getLoginUser().getTenantId();
        String number = configNumberUtil.getNumber("order_delivery_info"+tenantId);
        // 插入
        DeliveryInfoDO deliveryInfo = DeliveryInfoConvert.INSTANCE.convert(createReqVO);
        deliveryInfo.setId(UUID.randomUUID().toString());
        deliveryInfo.setDeliveryCode("PS"+number);
        deliveryInfoMapper.insert(deliveryInfo);
        // 返回
        return deliveryInfo.getId();
    }

    @Override
    public void updateDeliveryInfo(DeliveryInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateDeliveryInfoExists(updateReqVO.getId());
        // 更新
        DeliveryInfoDO updateObj = DeliveryInfoConvert.INSTANCE.convert(updateReqVO);
        deliveryInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteDeliveryInfo(String id) {
        // 校验存在
        this.validateDeliveryInfoExists(id);
        // 删除
        deliveryInfoMapper.deleteById(id);
    }

    private void validateDeliveryInfoExists(String id) {
        if (deliveryInfoMapper.selectById(id) == null) {
            throw exception(DELIVERY_INFO_NOT_EXISTS);
        }
    }

    @Override
    public DeliveryInfoDO getDeliveryInfo(String id) {
        return deliveryInfoMapper.selectById(id);
    }

    @Override
    public List<DeliveryInfoDO> getDeliveryInfoList(Collection<String> ids) {
        return deliveryInfoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<DeliveryInfoDO> getDeliveryInfoPage(DeliveryInfoPageReqVO pageReqVO) {
        return deliveryInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<DeliveryInfoDO> getDeliveryInfoList(DeliveryInfoExportReqVO exportReqVO) {
        return deliveryInfoMapper.selectList(exportReqVO);
    }

}
