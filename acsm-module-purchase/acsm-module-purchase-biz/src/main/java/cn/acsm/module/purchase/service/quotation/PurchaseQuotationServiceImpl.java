package cn.acsm.module.purchase.service.quotation;

import cn.acsm.module.purchase.controller.admin.quotation.vo.PurchaseQuotationCreateReqVO;
import cn.acsm.module.purchase.controller.admin.quotation.vo.PurchaseQuotationExportReqVO;
import cn.acsm.module.purchase.controller.admin.quotation.vo.PurchaseQuotationPageReqVO;
import cn.acsm.module.purchase.controller.admin.quotation.vo.PurchaseQuotationUpdateReqVO;
import cn.acsm.module.purchase.convert.quotation.PurchaseQuotationConvert;
import cn.acsm.module.purchase.dal.dataobject.quotation.PurchaseQuotationDO;
import cn.acsm.module.purchase.dal.mysql.quotation.PurchaseQuotationMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.purchase.enums.ErrorCodeConstants.QUOTATION_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 采购询价电子 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class PurchaseQuotationServiceImpl implements PurchaseQuotationService {

    @Resource
    private PurchaseQuotationMapper quotationMapper;

    @Override
    public Long createQuotation(PurchaseQuotationCreateReqVO createReqVO) {
        // 插入
        PurchaseQuotationDO quotation = PurchaseQuotationConvert.INSTANCE.convert(createReqVO);
        quotationMapper.insert(quotation);
        // 返回
        return quotation.getId();
    }

    @Override
    public void updateQuotation(PurchaseQuotationUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateQuotationExists(updateReqVO.getId());
        // 更新
        PurchaseQuotationDO updateObj = PurchaseQuotationConvert.INSTANCE.convert(updateReqVO);
        quotationMapper.updateById(updateObj);
    }

    @Override
    public void deleteQuotation(Long id) {
        // 校验存在
        this.validateQuotationExists(id);
        // 删除
        quotationMapper.deleteById(id);
    }

    private void validateQuotationExists(Long id) {
        if (quotationMapper.selectById(id) == null) {
            throw exception(QUOTATION_NOT_EXISTS);
        }
    }

    @Override
    public PurchaseQuotationDO getQuotation(Long id) {
        return quotationMapper.selectById(id);
    }

    @Override
    public List<PurchaseQuotationDO> getQuotationList(Collection<Long> ids) {
        return quotationMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<PurchaseQuotationDO> getQuotationPage(PurchaseQuotationPageReqVO pageReqVO) {
        return quotationMapper.selectPage(pageReqVO);
    }

    @Override
    public List<PurchaseQuotationDO> getQuotationList(PurchaseQuotationExportReqVO exportReqVO) {
        return quotationMapper.selectList(exportReqVO);
    }

}
