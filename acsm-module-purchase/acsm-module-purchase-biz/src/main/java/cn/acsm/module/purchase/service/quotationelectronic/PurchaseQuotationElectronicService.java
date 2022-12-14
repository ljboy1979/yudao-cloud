package cn.acsm.module.purchase.service.quotationelectronic;

import cn.acsm.module.purchase.controller.admin.quotationelectronic.vo.PurchaseQuotationElectronicCreateReqVO;
import cn.acsm.module.purchase.controller.admin.quotationelectronic.vo.PurchaseQuotationElectronicExportReqVO;
import cn.acsm.module.purchase.controller.admin.quotationelectronic.vo.PurchaseQuotationElectronicPageReqVO;
import cn.acsm.module.purchase.controller.admin.quotationelectronic.vo.PurchaseQuotationElectronicUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.quotationelectronic.PurchaseQuotationElectronicDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 采购报价单电子 Service 接口
 *
 * @author 芋道源码
 */
public interface PurchaseQuotationElectronicService {

    /**
     * 创建采购报价单电子
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createQuotationElectronic(@Valid PurchaseQuotationElectronicCreateReqVO createReqVO);

    /**
     * 更新采购报价单电子
     *
     * @param updateReqVO 更新信息
     */
    void updateQuotationElectronic(@Valid PurchaseQuotationElectronicUpdateReqVO updateReqVO);

    /**
     * 删除采购报价单电子
     *
     * @param id 编号
     */
    void deleteQuotationElectronic(Long id);

    /**
     * 获得采购报价单电子
     *
     * @param id 编号
     * @return 采购报价单电子
     */
    PurchaseQuotationElectronicDO getQuotationElectronic(Long id);

    /**
     * 获得采购报价单电子列表
     *
     * @param ids 编号
     * @return 采购报价单电子列表
     */
    List<PurchaseQuotationElectronicDO> getQuotationElectronicList(Collection<Long> ids);

    /**
     * 获得采购报价单电子分页
     *
     * @param pageReqVO 分页查询
     * @return 采购报价单电子分页
     */
    PageResult<PurchaseQuotationElectronicDO> getQuotationElectronicPage(PurchaseQuotationElectronicPageReqVO pageReqVO);

    /**
     * 获得采购报价单电子列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 采购报价单电子列表
     */
    List<PurchaseQuotationElectronicDO> getQuotationElectronicList(PurchaseQuotationElectronicExportReqVO exportReqVO);

}
