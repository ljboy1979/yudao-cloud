package cn.acsm.module.purchase.service.quotation;

import cn.acsm.module.purchase.controller.admin.quotation.vo.PurchaseQuotationCreateReqVO;
import cn.acsm.module.purchase.controller.admin.quotation.vo.PurchaseQuotationExportReqVO;
import cn.acsm.module.purchase.controller.admin.quotation.vo.PurchaseQuotationPageReqVO;
import cn.acsm.module.purchase.controller.admin.quotation.vo.PurchaseQuotationUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.quotation.PurchaseQuotationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 采购询价电子 Service 接口
 *
 * @author 芋道源码
 */
public interface PurchaseQuotationService {

    /**
     * 创建采购询价电子
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createQuotation(@Valid PurchaseQuotationCreateReqVO createReqVO);

    /**
     * 更新采购询价电子
     *
     * @param updateReqVO 更新信息
     */
    void updateQuotation(@Valid PurchaseQuotationUpdateReqVO updateReqVO);

    /**
     * 删除采购询价电子
     *
     * @param id 编号
     */
    void deleteQuotation(Long id);

    /**
     * 获得采购询价电子
     *
     * @param id 编号
     * @return 采购询价电子
     */
    PurchaseQuotationDO getQuotation(Long id);

    /**
     * 获得采购询价电子列表
     *
     * @param ids 编号
     * @return 采购询价电子列表
     */
    List<PurchaseQuotationDO> getQuotationList(Collection<Long> ids);

    /**
     * 获得采购询价电子分页
     *
     * @param pageReqVO 分页查询
     * @return 采购询价电子分页
     */
    PageResult<PurchaseQuotationDO> getQuotationPage(PurchaseQuotationPageReqVO pageReqVO);

    /**
     * 获得采购询价电子列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 采购询价电子列表
     */
    List<PurchaseQuotationDO> getQuotationList(PurchaseQuotationExportReqVO exportReqVO);

}
