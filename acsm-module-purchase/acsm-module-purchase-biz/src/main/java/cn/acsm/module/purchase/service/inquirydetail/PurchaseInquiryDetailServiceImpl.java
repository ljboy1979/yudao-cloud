package cn.acsm.module.purchase.service.inquirydetail;

import cn.acsm.module.purchase.controller.admin.inquirydetail.vo.PurchaseInquiryDetailCreateReqVO;
import cn.acsm.module.purchase.controller.admin.inquirydetail.vo.PurchaseInquiryDetailExportReqVO;
import cn.acsm.module.purchase.controller.admin.inquirydetail.vo.PurchaseInquiryDetailPageReqVO;
import cn.acsm.module.purchase.controller.admin.inquirydetail.vo.PurchaseInquiryDetailUpdateReqVO;
import cn.acsm.module.purchase.convert.inquirydetail.PurchaseInquiryDetailConvert;
import cn.acsm.module.purchase.dal.dataobject.inquirydetail.PurchaseInquiryDetailDO;
import cn.acsm.module.purchase.dal.mysql.inquiry.PurchaseInquiryMapper;
import cn.acsm.module.purchase.dal.mysql.inquirydetail.PurchaseInquiryDetailMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

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

    @Override
    public PurchaseInquiryDetailDO getInquiryDetail(Long id) {
        return inquiryDetailMapper.selectById(id);
    }

    @Override
    public List<PurchaseInquiryDetailDO> getInquiryDetailList(Collection<Long> ids) {
        return inquiryDetailMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<PurchaseInquiryDetailDO> getInquiryDetailPage(PurchaseInquiryDetailPageReqVO pageReqVO) {

        return inquiryDetailMapper.selectPage(pageReqVO);
    }

    @Override
    public List<PurchaseInquiryDetailDO> getInquiryDetailList(PurchaseInquiryDetailExportReqVO exportReqVO) {
        return inquiryDetailMapper.selectList(exportReqVO);
    }

}
