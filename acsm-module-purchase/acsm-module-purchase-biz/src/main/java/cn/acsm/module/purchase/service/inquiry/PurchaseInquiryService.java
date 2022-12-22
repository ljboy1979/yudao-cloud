package cn.acsm.module.purchase.service.inquiry;

import cn.acsm.module.purchase.controller.admin.inquiry.vo.*;
import cn.acsm.module.purchase.dal.dataobject.inquiry.PurchaseInquiryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 采购询价 Service 接口
 *
 * @author 芋道源码
 */
public interface PurchaseInquiryService {

    /**
     * 创建采购询价
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createInquiry(@Valid PurchaseInquiryCreateReqVO createReqVO);

    /**
     * 更新采购询价
     *
     * @param updateReqVO 更新信息
     */
    void updateInquiry(@Valid PurchaseInquiryUpdateReqVO updateReqVO);

    /**
     * 删除采购询价
     *
     * @param id 编号
     */
    void deleteInquiry(Long id);

    /**
     * 删除采购询价单
     *
     * @param delReqVO
     */
    void deleteInquiry(PurchaseInquiryDelReqVO delReqVO);

    /**
     * 获得采购询价
     *
     * @param id 编号
     * @return 采购询价
     */
    PurchaseInquiryDO getInquiry(Long id);

    /**
     * 获得采购询价列表
     *
     * @param ids 编号
     * @return 采购询价列表
     */
    List<PurchaseInquiryDO> getInquiryList(Collection<Long> ids);

    /**
     * 获得采购询价分页
     *
     * @param pageReqVO 分页查询
     * @return 采购询价分页
     */
    PageResult<PurchaseInquiryDO> getInquiryPage(PurchaseInquiryPageReqVO pageReqVO);

    /**
     * 获得采购询价列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 采购询价列表
     */
    List<PurchaseInquiryDO> getInquiryList(PurchaseInquiryExportReqVO exportReqVO);

    /**
     * 供应商获取询价单
     * @param getVO 分页查询
     * @return 获取询价单
     */
    PageResult<PurchaseInquiryDO> getInquiryByProvider(PurchaseInquiryGetVO getVO);

    /**
     * 3.6.2.29.回复询价情况 - 3.6.2.30.阅读询价单
     * @param readOrReplyVO
     */
    void replyOrReadInquiry(PurchaseInquiryReadOrReplyVO readOrReplyVO);
}
