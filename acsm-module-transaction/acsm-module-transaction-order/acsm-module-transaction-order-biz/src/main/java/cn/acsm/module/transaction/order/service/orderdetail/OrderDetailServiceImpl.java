package cn.acsm.module.transaction.order.service.orderdetail;

import cn.acsm.module.transaction.order.util.ConfigNumberUtil;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.order.controller.admin.orderdetail.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.orderdetail.OrderDetailDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.order.convert.orderdetail.OrderDetailConvert;
import cn.acsm.module.transaction.order.dal.mysql.orderdetail.OrderDetailMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.order.enums.ErrorCodeConstants.*;

/**
 * 订单详情 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class OrderDetailServiceImpl implements OrderDetailService {

    @Resource
    private OrderDetailMapper detailMapper;
    @Resource
    private ConfigNumberUtil configNumberUtil;

    @Override
    public String createDetail(OrderDetailCreateReqVO createReqVO) {
        Long tenantId = SecurityFrameworkUtils.getLoginUser().getTenantId();
        String number = configNumberUtil.getNumber("order_detail"+tenantId);
        // 插入
        OrderDetailDO detail = OrderDetailConvert.INSTANCE.convert(createReqVO);
        detail.setId(UUID.randomUUID().toString());
        detail.setCode("DDMX"+number);

        detailMapper.insert(detail);
        // 返回
        return detail.getId();
    }

    @Override
    public void updateDetail(OrderDetailUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateDetailExists(updateReqVO.getId());
        // 更新
        OrderDetailDO updateObj = OrderDetailConvert.INSTANCE.convert(updateReqVO);
        detailMapper.updateById(updateObj);
    }

    @Override
    public void deleteDetail(String id) {
        // 校验存在
        this.validateDetailExists(id);
        // 删除
        detailMapper.deleteById(id);
    }

    private void validateDetailExists(String id) {
        if (detailMapper.selectById(id) == null) {
            throw exception(DETAIL_NOT_EXISTS);
        }
    }

    @Override
    public OrderDetailDO getDetail(String id) {
        return detailMapper.selectById(id);
    }

    @Override
    public List<OrderDetailDO> getDetailList(Collection<String> ids) {
        return detailMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<OrderDetailDO> getDetailPage(OrderDetailPageReqVO pageReqVO) {
        return detailMapper.selectPage(pageReqVO);
    }

    @Override
    public List<OrderDetailDO> getDetailList(OrderDetailExportReqVO exportReqVO) {
        return detailMapper.selectList(exportReqVO);
    }

}
