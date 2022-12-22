package cn.acsm.module.purchase.service.quotation;

import cn.acsm.module.purchase.controller.admin.quotation.vo.*;
import cn.acsm.module.purchase.dal.dataobject.quotation.PurchaseQuotationDO;
import cn.acsm.module.purchase.dal.dataobject.quotationelectronic.PurchaseQuotationElectronicDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 采购报价单 Service 接口
 *
 * @author 芋道源码
 */
public interface PurchaseQuotationService {

    /**
     * 创建采购报价单
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createQuotation(@Valid PurchaseQuotationCreateReqVO createReqVO);

    /**
     * 更新采购报价单
     *
     * @param updateReqVO 更新信息
     */
    void updateQuotation(@Valid PurchaseQuotationUpdateReqVO updateReqVO);

    /**
     * 删除采购报价单
     *
     * @param id 编号
     */
    void deleteQuotation(Long id);

    /**
     * 删除采购报价单及报价单明细
     *
     * @param quoteId 编号
     */
    void deleteQuotation(String quoteId);

    /**
     * 获得采购报价单
     *
     * @param id 编号
     * @return 采购报价单
     */
    PurchaseQuotationDO getQuotation(Long id);

    /**
     * 获得采购报价单列表
     *
     * @param ids 编号
     * @return 采购报价单列表
     */
    List<PurchaseQuotationDO> getQuotationList(Collection<Long> ids);

    /**
     * 获得采购报价单分页
     *
     * @param pageReqVO 分页查询
     * @return 采购报价单分页
     */
    PageResult<PurchaseQuotationDO> getQuotationPage(PurchaseQuotationPageReqVO pageReqVO);

    /**
     * 获得采购报价单列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 采购报价单列表
     */
    List<PurchaseQuotationDO> getQuotationList(PurchaseQuotationExportReqVO exportReqVO);


    /**
     * 提交采购报价单
     *
     * @param quoteId 编号
     */
    void updateQuotationSubmitStatus(String quoteId);

    /**
     * 3.6.2.43.查看价格牌中的报价信息
     *
     * @param quotationVO
     */
    List<PurchaseQuotationElectronicDO> queryPriceTagInfo(PurchasePurchaserQuotationVO quotationVO);
}
