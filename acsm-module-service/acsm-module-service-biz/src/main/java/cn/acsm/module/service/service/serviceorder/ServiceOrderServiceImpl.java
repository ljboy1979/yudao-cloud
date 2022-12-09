package cn.acsm.module.service.service.serviceorder;

import cn.acsm.module.service.controller.admin.customerlist.vo.CustomerListCreateReqVO;
import cn.acsm.module.service.controller.admin.customerlist.vo.CustomerListRespVO;
import cn.acsm.module.service.convert.customerlist.CustomerListConvert;
import cn.acsm.module.service.dal.dataobject.customerlist.CustomerListDO;
import cn.acsm.module.service.dal.mysql.customerlist.CustomerListMapper;
import cn.acsm.module.service.utils.StringUtils;
import cn.iocoder.yudao.framework.security.core.LoginUser;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.*;
import cn.acsm.module.service.controller.admin.serviceorder.vo.*;
import cn.acsm.module.service.dal.dataobject.serviceorder.ServiceOrderDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.service.convert.serviceorder.ServiceOrderConvert;
import cn.acsm.module.service.dal.mysql.serviceorder.ServiceOrderMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.service.enums.ErrorCodeConstants.*;

/**
 * 服务交易单 Service 实现类
 *
 * @author smile
 */
@Service
@Validated
@Transactional(readOnly = false)
public class ServiceOrderServiceImpl implements ServiceOrderService {

    @Resource
    private ServiceOrderMapper orderMapper;
    @Resource
    private CustomerListMapper customerListMapper;

    @Override
    public Long createOrder(ServiceOrderCreateReqVO createReqVO) {
        String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        createReqVO.setTransactionNumber("DD" + format);
        // 插入
        ServiceOrderDO order = ServiceOrderConvert.INSTANCE.convert(createReqVO);
        orderMapper.insert(order);
        if(createReqVO.getCustomerLists()!=null&&createReqVO.getCustomerLists().size()>0) {
            for (CustomerListCreateReqVO customerList : createReqVO.getCustomerLists()) {
                //保存客户表
                String identityCode1 = StringUtils.getRandomString();
                customerList.setIdentityCode(identityCode1);
                customerList.setServiceOrderId(String.valueOf(order.getId()));
                CustomerListDO convert = CustomerListConvert.INSTANCE.convert(customerList);
                customerListMapper.insert(convert);
            }
        }
        // 返回
        return order.getId();
    }

    @Override
    public void updateOrder(ServiceOrderUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateOrderExists(updateReqVO.getId());
        // 更新
        ServiceOrderDO updateObj = ServiceOrderConvert.INSTANCE.convert(updateReqVO);
        orderMapper.updateById(updateObj);
    }

    @Override
    public void deleteOrder(Long id) {
        // 校验存在
        this.validateOrderExists(id);
        // 删除
        orderMapper.deleteById(id);
    }

    private void validateOrderExists(Long id) {
        if (orderMapper.selectById(id) == null) {
            throw exception(ORDER_NOT_EXISTS);
        }
    }

    @Override
    public ServiceOrderDO getOrder(Long id) {
        return orderMapper.selectById(id);
    }

    @Override
    public List<ServiceOrderDO> getOrderList(Collection<Long> ids) {
        return orderMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ServiceOrderDO> getOrderPage(ServiceOrderPageReqVO pageReqVO) {
        return orderMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ServiceOrderDO> getOrderList(ServiceOrderExportReqVO exportReqVO) {
        return orderMapper.selectList(exportReqVO);
    }

}
