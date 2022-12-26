package cn.acsm.module.purchase.service.inquiry;

import cn.acsm.module.purchase.controller.admin.inquiry.vo.*;
import cn.acsm.module.purchase.convert.inquiry.PurchaseInquiryConvert;
import cn.acsm.module.purchase.dal.dataobject.inquiry.PurchaseInquiryDO;
import cn.acsm.module.purchase.dal.dataobject.inquirydetail.PurchaseInquiryDetailDO;
import cn.acsm.module.purchase.dal.mysql.inquiry.PurchaseInquiryMapper;
import cn.acsm.module.purchase.dal.mysql.inquirydetail.PurchaseInquiryDetailMapper;
import cn.acsm.module.purchase.utils.SnowFlakeUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static cn.acsm.module.purchase.constant.PurchaseInquiryConstant.POST_STATUS_0;
import static cn.acsm.module.purchase.constant.PurchaseInquiryConstant.POST_STATUS_1;
import static cn.acsm.module.purchase.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 采购询价 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class PurchaseInquiryServiceImpl implements PurchaseInquiryService {

    @Resource
    private PurchaseInquiryMapper inquiryMapper;

    @Resource
    private PurchaseInquiryDetailMapper inquiryDetailMapper;

    @Override
    public Long createInquiry(PurchaseInquiryCreateReqVO createReqVO) {
        createReqVO.setEnquiryId(getInquiryNo());
        // 插入采购询价表
        PurchaseInquiryDO inquiry = PurchaseInquiryConvert.INSTANCE.convert(createReqVO);
        inquiryMapper.insert(inquiry);

        // 插入采购询价明细表
        PurchaseInquiryDetailDO detailDO = new PurchaseInquiryDetailDO();
        detailDO.setEnquiryId(getInquiryNo());
        detailDO.setCommodityId(createReqVO.getCommodityId());
        detailDO.setCommodityCategoryId(createReqVO.getCommodityCategoryId());
        detailDO.setProductSpecificationsId(createReqVO.getProductSpecificationsId());
        detailDO.setPlannedQuantityMin(createReqVO.getPlannedQuantityMin());
        detailDO.setSubjectId(createReqVO.getSubjectId());
        detailDO.setUserId(createReqVO.getUserId());
        detailDO.setSourceId(createReqVO.getSourceId());
        detailDO.setTenantId(createReqVO.getTenantId());
        inquiryDetailMapper.insert(detailDO);

        // 返回
        return inquiry.getId();
    }

    /**
     * 生成询价单编号
     * @return
     */
    private String getInquiryNo() {
        return SnowFlakeUtil.getId().toString();
    }

    @Override
    public void updateInquiry(PurchaseInquiryUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateInquiryExists(updateReqVO.getId());

        // 限制条件：发布状态"未发布"可修改
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id", updateReqVO.getId());
        wrapper.eq("post_status", POST_STATUS_0);
        if(ObjectUtils.isEmpty(inquiryMapper.selectOne(wrapper))) {
            throw exception(INQUIRY_STATUS_0);
        }
        if(StringUtils.equalsIgnoreCase(updateReqVO.getPostStatus(), POST_STATUS_1)) {
            updateReqVO.setReleaseTime(new Date());
        }
        // 更新
        PurchaseInquiryDO updateObj = PurchaseInquiryConvert.INSTANCE.convert(updateReqVO);
        inquiryMapper.updateById(updateObj);
    }

    @Override
    public void deleteInquiry(Long id) {
        // 校验存在
        this.validateInquiryExists(id);

        // 删除
        inquiryMapper.deleteById(id);
    }

    /**
     * 删除采购询价单
     *
     * @param delReqVO
     */
    public void deleteInquiry(PurchaseInquiryDelReqVO delReqVO) {
        // 校验存在
        this.validateInquiryExists(delReqVO.getId());

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id", delReqVO.getId());
        wrapper.eq("post_status", POST_STATUS_0);
        if(ObjectUtils.isEmpty(inquiryMapper.selectOne(wrapper))) {
            throw exception(INQUIRY_DELETE_WHERE);
        }
        inquiryMapper.deleteById(delReqVO.getId());

        QueryWrapper detailWrapper = new QueryWrapper();
        detailWrapper.eq("enquiry_id", delReqVO.getEnquiryId());
        inquiryDetailMapper.delete(detailWrapper);
    }

    private void validateInquiryExists(Long id) {
        if (inquiryMapper.selectById(id) == null) {
            throw exception(INQUIRY_NOT_EXISTS);
        }
    }

    @Override
    public PurchaseInquiryDO getInquiry(Long id) {
        return inquiryMapper.selectById(id);
    }

    @Override
    public List<PurchaseInquiryDO> getInquiryList(Collection<Long> ids) {
        return inquiryMapper.selectBatchIds(ids);
    }

    @Override
    public Page<PurchaseInquiryDO> getInquiryPage(PurchaseInquiryPageReqVO pageReqVO) {
        Page<PurchaseInquiryDO> page = new Page<>(pageReqVO.getPageNo(), pageReqVO.getPageSize());
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq(StringUtils.isNotBlank(pageReqVO.getEnquiryId()), "enquiry_id", pageReqVO.getEnquiryId());
        wrapper.like(StringUtils.isNotBlank(pageReqVO.getEnquiryName()), "enquiry_name", pageReqVO.getEnquiryName());
        wrapper.eq(ObjectUtils.isNotEmpty(pageReqVO.getProviderId()), "provider_id", pageReqVO.getProviderId());
        wrapper.eq(ObjectUtils.isNotEmpty(pageReqVO.getReleaseTime()), "release_time", pageReqVO.getReleaseTime());
        wrapper.eq(ObjectUtils.isNotEmpty(pageReqVO.getPostStatus()), "post_status", pageReqVO.getPostStatus());
        wrapper.eq(ObjectUtils.isNotEmpty(pageReqVO.getEnquiryStatus()), "enquiry_status", pageReqVO.getEnquiryStatus());
        return inquiryMapper.selectPage(page, wrapper);
    }

    @Override
    public List<PurchaseInquiryDO> getInquiryList(PurchaseInquiryExportReqVO exportReqVO) {
        return inquiryMapper.selectList(exportReqVO);
    }

    /**
     * 供应商获取询价单
     * @param getVO 分页查询
     * @return 获取询价单
     */
    public PageResult<PurchaseInquiryDO> getInquiryByProvider(PurchaseInquiryGetVO getVO) {
        return inquiryMapper.selectPageByProivder(getVO);
    }

    /**
     * 3.6.2.29.回复询价情况 - 3.6.2.30.阅读询价单
     * @param readOrReplyVO
     */
    public void replyOrReadInquiry(PurchaseInquiryReadOrReplyVO readOrReplyVO) {
        // 阅读
        if(StringUtils.isNotBlank(readOrReplyVO.getReadStatus())) {
            UpdateWrapper wrapper = new UpdateWrapper();
            wrapper.eq("enquiry_id", readOrReplyVO.getEnquiryId());

            PurchaseInquiryDO inquiryDO = new PurchaseInquiryDO();
            inquiryDO.setReadStatus(readOrReplyVO.getReadStatus());
            inquiryMapper.update(inquiryDO, wrapper);
        } else if(StringUtils.isNotBlank(readOrReplyVO.getEnquiryStatus())) { // 回复
            UpdateWrapper wrapper = new UpdateWrapper();
            wrapper.eq("enquiry_id", readOrReplyVO.getEnquiryId());

            PurchaseInquiryDO inquiryDO = new PurchaseInquiryDO();
            inquiryDO.setEnquiryStatus(readOrReplyVO.getEnquiryStatus());
            inquiryMapper.update(inquiryDO, wrapper);
        }
    }

}
