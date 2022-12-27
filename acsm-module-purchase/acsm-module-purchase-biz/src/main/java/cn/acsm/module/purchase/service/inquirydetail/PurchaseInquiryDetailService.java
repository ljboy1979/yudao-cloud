package cn.acsm.module.purchase.service.inquirydetail;

import cn.acsm.module.purchase.controller.admin.inquirydetail.vo.PurchaseInquiryDetailCreateReqVO;
import cn.acsm.module.purchase.controller.admin.inquirydetail.vo.PurchaseInquiryDetailExportReqVO;
import cn.acsm.module.purchase.controller.admin.inquirydetail.vo.PurchaseInquiryDetailPageReqVO;
import cn.acsm.module.purchase.controller.admin.inquirydetail.vo.PurchaseInquiryDetailUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.inquirydetail.PurchaseInquiryDetailDO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 采购询价电子表 Service 接口
 *
 * @author 芋道源码
 */
public interface PurchaseInquiryDetailService {

    /**
     * 创建采购询价电子表
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createInquiryDetail(@Valid PurchaseInquiryDetailCreateReqVO createReqVO);

    /**
     * 更新采购询价电子表
     *
     * @param updateReqVO 更新信息
     */
    void updateInquiryDetail(@Valid PurchaseInquiryDetailUpdateReqVO updateReqVO);

    /**
     * 删除采购询价电子表
     *
     * @param id 编号
     */
    void deleteInquiryDetail(Long id);

    /**
     * 获得采购询价电子表
     *
     * @param id 编号
     * @return 采购询价电子表
     */
    PurchaseInquiryDetailDO getInquiryDetail(Long id);

    /**
     * 获得采购询价电子表列表
     *
     * @param ids 编号
     * @return 采购询价电子表列表
     */
    List<PurchaseInquiryDetailDO> getInquiryDetailList(Collection<Long> ids);

    /**
     * 获得采购询价电子表分页
     *
     * @param pageReqVO 分页查询
     * @return 采购询价电子表分页
     */
    Page<PurchaseInquiryDetailDO> getInquiryDetailPage(PurchaseInquiryDetailPageReqVO pageReqVO);

    /**
     * 获得采购询价电子表列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 采购询价电子表列表
     */
    List<PurchaseInquiryDetailDO> getInquiryDetailList(PurchaseInquiryDetailExportReqVO exportReqVO);

}
