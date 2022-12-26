package cn.acsm.module.purchase.service.quotation;

import cn.acsm.module.purchase.controller.admin.inquiry.vo.PurchaseInquiryReadOrReplyVO;
import cn.acsm.module.purchase.controller.admin.quotation.vo.*;
import cn.acsm.module.purchase.convert.quotation.PurchaseQuotationConvert;
import cn.acsm.module.purchase.dal.dataobject.quotation.PurchaseQuotationDO;
import cn.acsm.module.purchase.dal.dataobject.quotationelectronic.PurchaseQuotationElectronicDO;
import cn.acsm.module.purchase.dal.mysql.quotation.PurchaseQuotationMapper;
import cn.acsm.module.purchase.dal.mysql.quotationelectronic.PurchaseQuotationElectronicMapper;
import cn.acsm.module.purchase.service.inquiry.PurchaseInquiryService;
import cn.hutool.core.date.format.FastDateFormat;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static cn.acsm.module.purchase.constant.PurchaseQuotationConstant.SUBMIT_STATUS_0;
import static cn.acsm.module.purchase.enums.ErrorCodeConstants.QUOTATION_NOT_EXISTS;
import static cn.acsm.module.purchase.enums.ErrorCodeConstants.QUOTATION_SUBMIT_STATUS_0;
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

    @Resource
    private PurchaseQuotationElectronicMapper electronicMapper;

    @Resource
    private PurchaseInquiryService purchaseInquiryService;

    @Override
    public Long createQuotation(PurchaseQuotationCreateReqVO createReqVO) {
        // 插入报价单
        PurchaseQuotationDO quotation = PurchaseQuotationConvert.INSTANCE.convert(createReqVO);
        quotation.setQuoteId(getPurchaseQuotationNumber());
        quotationMapper.insert(quotation);

        //插入报价单明细
        PurchaseQuotationElectronicDO electronicDO = new PurchaseQuotationElectronicDO();
        electronicDO.setQuoteId(getPurchaseQuotationNumber());
        electronicDO.setInquiryDetailId(createReqVO.getInquiryDetailId());
        electronicDO.setCommodityId(createReqVO.getCommodityId());
        electronicDO.setCommodityCategoryId(createReqVO.getCommodityCategoryId());
        electronicDO.setTenantId(createReqVO.getTenantId());
        electronicDO.setSourceId(createReqVO.getSourceId());
        electronicMapper.insert(electronicDO);
        // 返回
        return quotation.getId();
    }

    /**
     * 生成采购单号
     */
    private String getPurchaseQuotationNumber() {
        String prefix = "BJD";
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.orderByDesc("quote_id");
        wrapper.last(" limit 1");
        PurchaseQuotationDO aDo = quotationMapper.selectOne(wrapper);
        String now = FastDateFormat.getInstance("yyyyMMdd").format(new Date());
        if(ObjectUtils.isNotEmpty(aDo) && StringUtils.equalsIgnoreCase(
                aDo.getQuoteId().substring(3, 11), now)) {
            Integer newNumber = Integer.valueOf(aDo.getQuoteId().substring(11)) + 1;
            if(newNumber.toString().length() == 1) {
                String number = prefix.concat(now).concat("0000".concat(newNumber+""));
                return number;
            }
            if(newNumber.toString().length() == 2) {
                String number = prefix.concat(now).concat("000".concat(newNumber + ""));
                return number;
            }
            if(newNumber.toString().length() == 3) {
                String number = prefix.concat(now).concat("00".concat(newNumber + ""));
                return number;
            }
            if(newNumber.toString().length() == 4) {
                String number = prefix.concat(now).concat("0".concat(newNumber + ""));
                return number;
            }
            if(newNumber.toString().length() == 5) {
                String number = prefix.concat(now).concat(newNumber + "");
                return number;
            }
        }
        return prefix.concat(now).concat("00001");
    }

    @CachePut(value = "purchaseQuotation", key = "#updateReqVO.quoteId")
    @Override
    public void updateQuotation(PurchaseQuotationUpdateReqVO updateReqVO) {
        // 限制条件：是否提交"未提交"可修改
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("quote_id", updateReqVO.getQuoteId());
        wrapper.eq("submit_status", SUBMIT_STATUS_0);
        if(ObjectUtils.isEmpty(quotationMapper.selectOne(wrapper))) {
            throw exception(QUOTATION_SUBMIT_STATUS_0);
        }
        // 校验存在
        this.validateQuotationExists(updateReqVO.getId());
        // 更新
        PurchaseQuotationDO updateObj = PurchaseQuotationConvert.INSTANCE.convert(updateReqVO);
        quotationMapper.updateById(updateObj);
    }

    @CacheEvict(value = "purchaseQuotation", key = "#id")
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

    @Cacheable(value = "purchaseQuotation", key = "#id")
    @Override
    public PurchaseQuotationDO getQuotation(Long id) {
        return quotationMapper.selectById(id);
    }

    @Cacheable(value = "purchaseQuotation", key = "#ids")
    @Override
    public List<PurchaseQuotationDO> getQuotationList(Collection<Long> ids) {
        return quotationMapper.selectBatchIds(ids);
    }

    @Cacheable(value = "purchaseQuotation", key = "'getQuotationPage'.concat('-').concat(pageReqVO.pageNo)" +
            ".concat('-').concat(pageReqVO.pageSize)")
    @Override
    public PageResult<PurchaseQuotationDO> getQuotationPage(PurchaseQuotationPageReqVO pageReqVO) {
        return quotationMapper.selectPage(pageReqVO);
    }

    @Cacheable(value = "purchaseQuotation", key = "'getQuotationList'")
    @Override
    public List<PurchaseQuotationDO> getQuotationList(PurchaseQuotationExportReqVO exportReqVO) {
        return quotationMapper.selectList(exportReqVO);
    }

    /**
     * 删除采购报价单及报价单明细
     *
     * @param quoteId 编号
     */
    @CacheEvict(value = "purchaseQuotation", key = "#quoteId")
    public void deleteQuotation(String quoteId) {
        // 删除报价单
        UpdateWrapper wrapper = new UpdateWrapper();
        wrapper.eq("quote_id", quoteId);

        PurchaseQuotationDO quotationDO = new PurchaseQuotationDO();
        quotationDO.setDeleted(true);
        quotationMapper.update(quotationDO, wrapper);

        // 删除报价单明细
        PurchaseQuotationElectronicDO electronicDO = new PurchaseQuotationElectronicDO();
        electronicDO.setDeleted(true);
        electronicMapper.update(electronicDO, wrapper);
    }

    /**
     * 提交采购报价单
     *
     * @param quoteId 编号
     */
    public void updateQuotationSubmitStatus(String quoteId) {
        // 提交报价单
        UpdateWrapper wrapper = new UpdateWrapper();
        wrapper.eq("quote_id", quoteId);

        PurchaseQuotationDO quotationDO = new PurchaseQuotationDO();
        quotationDO.setSubmitStatus(true);
        quotationMapper.update(quotationDO, wrapper);

        // 调用 回复询价情况 方法
        // 获取询价单编号
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("quote_id", quoteId);
        PurchaseQuotationDO quotationDO1 = quotationMapper.selectOne(wrapper);

        PurchaseInquiryReadOrReplyVO readOrReplyVO = new PurchaseInquiryReadOrReplyVO();
        // 0 -> 已回复
        readOrReplyVO.setEnquiryStatus("0");
        readOrReplyVO.setEnquiryId(quotationDO1.getEnquiryId());
        purchaseInquiryService.replyOrReadInquiry(readOrReplyVO);
    }

    /**
     * 3.6.2.43.查看价格牌中的报价信息
     *
     * @param quotationVO
     */
    @Cacheable(value = "purchaseQuotation", key = "'queryPriceTagInfo'.concat('-').concat(#quotationVO.commodityId)" +
            ".concat('-').concat(#quotationVO.specificationsId)")
    @Override
    public List<PurchaseQuotationElectronicDO> queryPriceTagInfo(PurchasePurchaserQuotationVO quotationVO) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq(ObjectUtils.isNotEmpty(quotationVO.getCommodityId()), "commodity_id", quotationVO.getCommodityId());
        wrapper.eq(ObjectUtils.isNotEmpty(quotationVO.getSpecificationsId()), "specifications_id", quotationVO.getSpecificationsId());
        return electronicMapper.selectList(wrapper);
    }

}
