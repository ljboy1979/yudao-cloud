package cn.acsm.module.purchase.service.quotationelectronic;

import cn.acsm.module.purchase.controller.admin.quotationelectronic.vo.*;
import cn.acsm.module.purchase.convert.quotationelectronic.PurchaseQuotationElectronicConvert;
import cn.acsm.module.purchase.dal.dataobject.quotationelectronic.PurchaseQuotationElectronicDO;
import cn.acsm.module.purchase.dal.mysql.quotation.PurchaseQuotationMapper;
import cn.acsm.module.purchase.dal.mysql.quotationelectronic.PurchaseQuotationElectronicMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.purchase.constant.PurchaseQuotationConstant.SUBMIT_STATUS_0;
import static cn.acsm.module.purchase.enums.ErrorCodeConstants.QUOTATION_ELECTRONIC_NOT_EXISTS;
import static cn.acsm.module.purchase.enums.ErrorCodeConstants.QUOTATION_SUBMIT_STATUS_0;
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

    @Resource
    private PurchaseQuotationMapper quotationMapper;

    @Override
    public Long createQuotationElectronic(PurchaseQuotationElectronicCreateReqVO createReqVO) {
        // 插入
        PurchaseQuotationElectronicDO quotationElectronic = PurchaseQuotationElectronicConvert.INSTANCE.convert(createReqVO);
        quotationElectronicMapper.insert(quotationElectronic);
        // 返回
        return quotationElectronic.getId();
    }

    @CachePut(value = "purchaseQuotationElectronic", key = "#updateReqVO.id")
    @Override
    public void updateQuotationElectronic(PurchaseQuotationElectronicUpdateReqVO updateReqVO) {
        // 限制条件：是否提交"未提交"可修改
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("quote_id", updateReqVO.getQuoteId());
        wrapper.eq("submit_status", SUBMIT_STATUS_0);
        if(ObjectUtils.isEmpty(quotationMapper.selectOne(wrapper))) {
            throw exception(QUOTATION_SUBMIT_STATUS_0);
        }
        // 校验存在
        this.validateQuotationElectronicExists(updateReqVO.getId());
        // 更新
        PurchaseQuotationElectronicDO updateObj = PurchaseQuotationElectronicConvert.INSTANCE.convert(updateReqVO);
        quotationElectronicMapper.updateById(updateObj);
    }

    @CacheEvict(value = "purchaseQuotationElectronic", key = "#id")
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

    @Cacheable(value = "purchaseQuotationElectronic", key = "#id")
    @Override
    public PurchaseQuotationElectronicDO getQuotationElectronic(Long id) {
        return quotationElectronicMapper.selectById(id);
    }

    @Cacheable(value = "purchaseQuotationElectronic", key = "#ids")
    @Override
    public List<PurchaseQuotationElectronicDO> getQuotationElectronicList(Collection<Long> ids) {
        return quotationElectronicMapper.selectBatchIds(ids);
    }

    @Cacheable(value = "purchaseQuotationElectronic", key = "'getQuotationElectronicPage'.concat('-').concat(#pageReqVO.pageNo)" +
            ".concat('-').concat(#pageReqVO.pageSize)")
    @Override
    public PageResult<PurchaseQuotationElectronicDO> getQuotationElectronicPage(PurchaseQuotationElectronicPageReqVO pageReqVO) {
        return quotationElectronicMapper.selectPage(pageReqVO);
    }

    @Cacheable(value = "purchaseQuotationElectronic", key = "'getQuotationElectronicList'")
    @Override
    public List<PurchaseQuotationElectronicDO> getQuotationElectronicList(PurchaseQuotationElectronicExportReqVO exportReqVO) {
        return quotationElectronicMapper.selectList(exportReqVO);
    }

    /**
     * 价格牌明细
     * @param tagDetailVO
     */
    @Cacheable(value = "purchaseQuotationElectronic", key = "'getQuotationElectronicPage'.concat('-').concat(#tagDetailVO.commodityId)" +
            ".concat('-').concat(#tagDetailVO.specificationsId)")
    @Override
    public PageResult<PurchaseQuotationElectronicDO> getQuotationElectronicPage(PurchasePriceTagDetailVO tagDetailVO) {
        return quotationElectronicMapper.selectPriceTag(tagDetailVO);
    }

    /**
     * 3.6.2.45.查询采购报价明细
     * @param infoVO
     */
    @Cacheable(value = "getQuotationElectronicInfo", key = "'getQuotationElectronicInfo'.concat('-').concat(#infoVO.pageNo)" +
            ".concat('-').concat(#infoVO.pageSize)")
    @Override
    public PageResult<PurchaseQuotationElectronicDO> getQuotationElectronicInfo(PurchaseQuotationInfoVO infoVO) {
        return quotationElectronicMapper.selectPageInfo(infoVO);
    }

}
