package cn.acsm.module.purchase.service.quotationelectronic;

import cn.acsm.module.purchase.controller.admin.quotationelectronic.vo.PurchaseQuotationElectronicCreateReqVO;
import cn.acsm.module.purchase.controller.admin.quotationelectronic.vo.PurchaseQuotationElectronicExportReqVO;
import cn.acsm.module.purchase.controller.admin.quotationelectronic.vo.PurchaseQuotationElectronicPageReqVO;
import cn.acsm.module.purchase.controller.admin.quotationelectronic.vo.PurchaseQuotationElectronicUpdateReqVO;
import cn.acsm.module.purchase.convert.quotationelectronic.PurchaseQuotationElectronicConvert;
import cn.acsm.module.purchase.dal.dataobject.quotationelectronic.PurchaseQuotationElectronicDO;
import cn.acsm.module.purchase.dal.mysql.quotationelectronic.PurchaseQuotationElectronicMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.purchase.enums.ErrorCodeConstants.QUOTATION_ELECTRONIC_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 采购报价单电子 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class PurchaseQuotationElectronicServiceImpl implements PurchaseQuotationElectronicService {

    @Resource
    private PurchaseQuotationElectronicMapper quotationElectronicMapper;

    @Override
    public Long createQuotationElectronic(PurchaseQuotationElectronicCreateReqVO createReqVO) {
        // 插入
        PurchaseQuotationElectronicDO quotationElectronic = PurchaseQuotationElectronicConvert.INSTANCE.convert(createReqVO);
        quotationElectronicMapper.insert(quotationElectronic);
        // 返回
        return quotationElectronic.getId();
    }

    @Override
    public void updateQuotationElectronic(PurchaseQuotationElectronicUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateQuotationElectronicExists(updateReqVO.getId());
        // 更新
        PurchaseQuotationElectronicDO updateObj = PurchaseQuotationElectronicConvert.INSTANCE.convert(updateReqVO);
        quotationElectronicMapper.updateById(updateObj);
    }

    @Override
    public void deleteQuotationElectronic(Long id) {
        // 校验存在
        this.validateQuotationElectronicExists(id);
        // 删除
        quotationElectronicMapper.deleteById(id);
    }

    private void validateQuotationElectronicExists(Long id) {
        if (quotationElectronicMapper.selectById(id) == null) {
            throw exception(QUOTATION_ELECTRONIC_NOT_EXISTS);
        }
    }

    @Override
    public PurchaseQuotationElectronicDO getQuotationElectronic(Long id) {
        return quotationElectronicMapper.selectById(id);
    }

    @Override
    public List<PurchaseQuotationElectronicDO> getQuotationElectronicList(Collection<Long> ids) {
        return quotationElectronicMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<PurchaseQuotationElectronicDO> getQuotationElectronicPage(PurchaseQuotationElectronicPageReqVO pageReqVO) {
        return quotationElectronicMapper.selectPage(pageReqVO);
    }

    @Override
    public List<PurchaseQuotationElectronicDO> getQuotationElectronicList(PurchaseQuotationElectronicExportReqVO exportReqVO) {
        return quotationElectronicMapper.selectList(exportReqVO);
    }

}
