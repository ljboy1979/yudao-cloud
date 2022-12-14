package cn.acsm.module.purchase.service.inquiry;

import cn.acsm.module.purchase.controller.admin.inquiry.vo.PurchaseInquiryCreateReqVO;
import cn.acsm.module.purchase.controller.admin.inquiry.vo.PurchaseInquiryExportReqVO;
import cn.acsm.module.purchase.controller.admin.inquiry.vo.PurchaseInquiryPageReqVO;
import cn.acsm.module.purchase.controller.admin.inquiry.vo.PurchaseInquiryUpdateReqVO;
import cn.acsm.module.purchase.convert.inquiry.PurchaseInquiryConvert;
import cn.acsm.module.purchase.dal.dataobject.inquiry.PurchaseInquiryDO;
import cn.acsm.module.purchase.dal.mysql.inquiry.PurchaseInquiryMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.purchase.enums.ErrorCodeConstants.INQUIRY_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 采购询价电子 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class PurchaseInquiryServiceImpl implements PurchaseInquiryService {

    @Resource
    private PurchaseInquiryMapper inquiryMapper;

    @Override
    public Long createInquiry(PurchaseInquiryCreateReqVO createReqVO) {
        // 插入
        PurchaseInquiryDO inquiry = PurchaseInquiryConvert.INSTANCE.convert(createReqVO);
        inquiryMapper.insert(inquiry);
        // 返回
        return inquiry.getId();
    }

    @Override
    public void updateInquiry(PurchaseInquiryUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateInquiryExists(updateReqVO.getId());
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
    public PageResult<PurchaseInquiryDO> getInquiryPage(PurchaseInquiryPageReqVO pageReqVO) {
        return inquiryMapper.selectPage(pageReqVO);
    }

    @Override
    public List<PurchaseInquiryDO> getInquiryList(PurchaseInquiryExportReqVO exportReqVO) {
        return inquiryMapper.selectList(exportReqVO);
    }

}
