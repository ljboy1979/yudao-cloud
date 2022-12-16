package cn.acsm.module.production.facility.service.contract;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.production.facility.controller.admin.contract.vo.*;
import cn.acsm.module.production.facility.dal.dataobject.contract.ContractDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 租赁合同 Service 接口
 *
 * @author 芋道源码
 */
public interface ContractService {

    /**
     * 创建租赁合同
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createContract(@Valid ContractCreateReqVO createReqVO);

    /**
     * 更新租赁合同
     *
     * @param updateReqVO 更新信息
     */
    void updateContract(@Valid ContractUpdateReqVO updateReqVO);

    /**
     * 删除租赁合同
     *
     * @param id 编号
     */
    void deleteContract(Long id);

    /**
     * 获得租赁合同
     *
     * @param id 编号
     * @return 租赁合同
     */
    ContractDO getContract(Long id);

    /**
     * 获得租赁合同列表
     *
     * @param ids 编号
     * @return 租赁合同列表
     */
    List<ContractDO> getContractList(Collection<Long> ids);

    /**
     * 获得租赁合同分页
     *
     * @param pageReqVO 分页查询
     * @return 租赁合同分页
     */
    PageResult<ContractDO> getContractPage(ContractPageReqVO pageReqVO);

    /**
     * 获得租赁合同列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 租赁合同列表
     */
    List<ContractDO> getContractList(ContractExportReqVO exportReqVO);

}
