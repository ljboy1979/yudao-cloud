package cn.acsm.module.service.service.customerlist;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.service.controller.admin.customerlist.vo.*;
import cn.acsm.module.service.dal.dataobject.customerlist.CustomerListDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.service.convert.customerlist.CustomerListConvert;
import cn.acsm.module.service.dal.mysql.customerlist.CustomerListMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.service.enums.ErrorCodeConstants.*;

/**
 * 服务客户名单 Service 实现类
 *
 * @author smile
 */
@Service
@Validated
@Transactional(readOnly = false)
public class CustomerListServiceImpl implements CustomerListService {

    @Resource
    private CustomerListMapper customerListMapper;

    @Override
    public Long createCustomerList(CustomerListCreateReqVO createReqVO) {
        // 插入
        CustomerListDO customerList = CustomerListConvert.INSTANCE.convert(createReqVO);
        customerListMapper.insert(customerList);
        // 返回
        return customerList.getId();
    }

    @Override
    public void updateCustomerList(CustomerListUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateCustomerListExists(updateReqVO.getId());
        // 更新
        CustomerListDO updateObj = CustomerListConvert.INSTANCE.convert(updateReqVO);
        customerListMapper.updateById(updateObj);
    }

    @Override
    public void deleteCustomerList(Long id) {
        // 校验存在
        this.validateCustomerListExists(id);
        // 删除
        customerListMapper.deleteById(id);
    }

    private void validateCustomerListExists(Long id) {
        if (customerListMapper.selectById(id) == null) {
            throw exception(CUSTOMER_LIST_NOT_EXISTS);
        }
    }

    @Override
    public CustomerListDO getCustomerList(Long id) {
        return customerListMapper.selectById(id);
    }

    @Override
    public List<CustomerListDO> getCustomerListList(Collection<Long> ids) {
        return customerListMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<CustomerListDO> getCustomerListPage(CustomerListPageReqVO pageReqVO) {
        return customerListMapper.selectPage(pageReqVO);
    }

    @Override
    public List<CustomerListDO> getCustomerListList(CustomerListExportReqVO exportReqVO) {
        return customerListMapper.selectList(exportReqVO);
    }

}
