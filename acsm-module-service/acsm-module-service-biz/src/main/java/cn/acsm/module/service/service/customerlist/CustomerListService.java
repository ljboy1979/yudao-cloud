package cn.acsm.module.service.service.customerlist;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.service.controller.admin.customerlist.vo.*;
import cn.acsm.module.service.dal.dataobject.customerlist.CustomerListDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 服务客户名单 Service 接口
 *
 * @author smile
 */
public interface CustomerListService {

    /**
     * 创建服务客户名单
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createCustomerList(@Valid CustomerListCreateReqVO createReqVO);

    /**
     * 更新服务客户名单
     *
     * @param updateReqVO 更新信息
     */
    void updateCustomerList(@Valid CustomerListUpdateReqVO updateReqVO);

    /**
     * 删除服务客户名单
     *
     * @param id 编号
     */
    void deleteCustomerList(Long id);

    /**
     * 获得服务客户名单
     *
     * @param id 编号
     * @return 服务客户名单
     */
    CustomerListDO getCustomerList(Long id);

    /**
     * 获得服务客户名单列表
     *
     * @param ids 编号
     * @return 服务客户名单列表
     */
    List<CustomerListDO> getCustomerListList(Collection<Long> ids);

    /**
     * 获得服务客户名单分页
     *
     * @param pageReqVO 分页查询
     * @return 服务客户名单分页
     */
    PageResult<CustomerListDO> getCustomerListPage(CustomerListPageReqVO pageReqVO);

    /**
     * 获得服务客户名单列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 服务客户名单列表
     */
    List<CustomerListDO> getCustomerListList(CustomerListExportReqVO exportReqVO);

}
