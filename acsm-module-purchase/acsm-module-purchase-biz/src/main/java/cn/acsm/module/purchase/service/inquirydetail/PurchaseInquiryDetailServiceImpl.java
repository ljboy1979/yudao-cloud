package cn.acsm.module.purchase.service.inquirydetail;

import cn.acsm.module.purchase.controller.admin.inquirydetail.vo.PurchaseInquiryDetailCreateReqVO;
import cn.acsm.module.purchase.controller.admin.inquirydetail.vo.PurchaseInquiryDetailExportReqVO;
import cn.acsm.module.purchase.controller.admin.inquirydetail.vo.PurchaseInquiryDetailPageReqVO;
import cn.acsm.module.purchase.controller.admin.inquirydetail.vo.PurchaseInquiryDetailUpdateReqVO;
import cn.acsm.module.purchase.convert.inquirydetail.PurchaseInquiryDetailConvert;
import cn.acsm.module.purchase.dal.dataobject.inquirydetail.PurchaseInquiryDetailDO;
import cn.acsm.module.purchase.dal.mysql.inquiry.PurchaseInquiryMapper;
import cn.acsm.module.purchase.dal.mysql.inquirydetail.PurchaseInquiryDetailMapper;
import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesRespDto;
import cn.acsm.module.transaction.sales.api.shelves.ShelvesApi;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static cn.acsm.module.purchase.constant.PurchaseInquiryConstant.POST_STATUS_0;
import static cn.acsm.module.purchase.enums.ErrorCodeConstants.INQUIRY_DETAIL_NOT_EXISTS;
import static cn.acsm.module.purchase.enums.ErrorCodeConstants.INQUIRY_DETAIL_STATUS_0;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 采购询价电子表 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class PurchaseInquiryDetailServiceImpl implements PurchaseInquiryDetailService {

    @Resource
    private ShelvesApi shelvesApi;

    @Resource
    private PurchaseInquiryDetailMapper inquiryDetailMapper;

    @Resource
    private PurchaseInquiryMapper inquiryMapper;

    @Override
    public Long createInquiryDetail(PurchaseInquiryDetailCreateReqVO createReqVO) {
        // 插入
        PurchaseInquiryDetailDO inquiryDetail = PurchaseInquiryDetailConvert.INSTANCE.convert(createReqVO);
        inquiryDetailMapper.insert(inquiryDetail);
        // 返回
        return inquiryDetail.getId();
    }

    @CachePut(value = "purchaseInquiryDetail", key = "#updateReqVO.id")
    @Override
    public void updateInquiryDetail(PurchaseInquiryDetailUpdateReqVO updateReqVO) {
        // 限制条件：【询价单表】中发布状态"未发布"可修改
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("enquiry_id", updateReqVO.getEnquiryId());
        wrapper.eq("post_status", POST_STATUS_0);
        if(ObjectUtils.isEmpty(inquiryMapper.selectOne(wrapper))) {
            throw exception(INQUIRY_DETAIL_STATUS_0);
        }
        // 校验存在
        this.validateInquiryDetailExists(updateReqVO.getId());
        // 更新
        PurchaseInquiryDetailDO updateObj = PurchaseInquiryDetailConvert.INSTANCE.convert(updateReqVO);
        inquiryDetailMapper.updateById(updateObj);
    }

    @CacheEvict(value = "purchaseInquiryDetail", key = "#id")
    @Override
    public void deleteInquiryDetail(Long id) {
        // 校验存在
        this.validateInquiryDetailExists(id);
        // 删除
        inquiryDetailMapper.deleteById(id);
    }

    private void validateInquiryDetailExists(Long id) {
        if (inquiryDetailMapper.selectById(id) == null) {
            throw exception(INQUIRY_DETAIL_NOT_EXISTS);
        }
    }

    @Cacheable(value = "purchaseInquiryDetail", key = "#id")
    @Override
    public PurchaseInquiryDetailDO getInquiryDetail(Long id) {
        return inquiryDetailMapper.selectById(id);
    }

    @Cacheable(value = "purchaseInquiryDetail", key = "#ids")
    @Override
    public List<PurchaseInquiryDetailDO> getInquiryDetailList(Collection<Long> ids) {
        return inquiryDetailMapper.selectBatchIds(ids);
    }

    /**
     * 3.6.2.35.查询采购询价明细（基础方法）
     * @param pageReqVO 分页查询
     * @return
     */
    @Cacheable(value = "purchaseInquiryDetail", key = "'getInquiryDetailPage'.concat('-').concat(#pageReqVO.pageNo)" +
            ".concat('-').concat(#pageReqVO.pageSize)")
    @Override
    public Page<PurchaseInquiryDetailDO> getInquiryDetailPage(PurchaseInquiryDetailPageReqVO pageReqVO) {
        Page<PurchaseInquiryDetailDO> page = new Page(pageReqVO.getPageNo(), pageReqVO.getPageSize());

        ShelvesSalesReqDto reqDto = new ShelvesSalesReqDto();
        reqDto.setType(pageReqVO.getType());
        reqDto.setSalesName(pageReqVO.getCommodityName());
        CommonResult<List<ShelvesSalesRespDto>> sales = shelvesApi.findSales(reqDto);
        List<String> commodityIds = new ArrayList<>();
        if(!CollectionUtils.isEmpty(sales.getData())) {
            commodityIds = sales.getData().stream().map(sa -> {
                return sa.getId();
            }).collect(Collectors.toList());
        }
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.in(!CollectionUtils.isEmpty(commodityIds), "commodity_id", commodityIds);
        return inquiryDetailMapper.selectPage(page, wrapper);
    }

    @Cacheable(value = "purchaseInquiryDetail", key = "'getInquiryDetailList'.concat('-').concat(#exportReqVO.enquiryId)")
    @Override
    public List<PurchaseInquiryDetailDO> getInquiryDetailList(PurchaseInquiryDetailExportReqVO exportReqVO) {
        return inquiryDetailMapper.selectList(exportReqVO);
    }

}
