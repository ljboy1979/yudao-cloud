package cn.acsm.module.production.facility.service.contract;

import cn.acsm.module.production.facility.controller.admin.contract.vo.ContractCreateReqVO;
import cn.acsm.module.production.facility.controller.admin.contract.vo.ContractExportReqVO;
import cn.acsm.module.production.facility.controller.admin.contract.vo.ContractPageReqVO;
import cn.acsm.module.production.facility.controller.admin.contract.vo.ContractUpdateReqVO;
import cn.acsm.module.production.facility.convert.contract.ContractConvert;
import cn.acsm.module.production.facility.dal.dataobject.contract.ContractDO;
import cn.acsm.module.production.facility.dal.mysql.contract.ContractMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.production.facility.enums.ErrorCodeConstants.CONTRACT_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 租赁合同 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ContractServiceImpl implements ContractService {

    @Resource
    private ContractMapper contractMapper;

    @Override
    public Long createContract(ContractCreateReqVO createReqVO) {
        // 插入
        ContractDO contract = ContractConvert.INSTANCE.convert(createReqVO);
        contractMapper.insert(contract);
        // 返回
        return contract.getId();
    }

    @Override
    @CacheEvict(value = "facility-contract", key = "#updateReqVO.id")
    public void updateContract(ContractUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateContractExists(updateReqVO.getId());
        // 更新
        ContractDO updateObj = ContractConvert.INSTANCE.convert(updateReqVO);
        contractMapper.updateById(updateObj);
    }

    @Override
    @CacheEvict(value = "facility-contract", key = "#id")
    public void deleteContract(Long id) {
        // 校验存在
        this.validateContractExists(id);
        // 删除
        contractMapper.deleteById(id);
    }

    private void validateContractExists(Long id) {
        if (contractMapper.selectById(id) == null) {
            throw exception(CONTRACT_NOT_EXISTS);
        }
    }

    @Override
    @Cacheable(value = "facility-contract", key = "#id")
    public ContractDO getContract(Long id) {
        return contractMapper.selectById(id);
    }

    @Override
    public List<ContractDO> getContractList(Collection<Long> ids) {
        return contractMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ContractDO> getContractPage(ContractPageReqVO pageReqVO) {
        return contractMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ContractDO> getContractList(ContractExportReqVO exportReqVO) {
        return contractMapper.selectList(exportReqVO);
    }

}
