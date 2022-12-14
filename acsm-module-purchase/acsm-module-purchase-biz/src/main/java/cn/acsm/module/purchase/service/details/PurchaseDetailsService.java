package cn.acsm.module.purchase.service.details;

import cn.acsm.module.purchase.controller.admin.details.vo.PurchaseDetailsCreateReqVO;
import cn.acsm.module.purchase.controller.admin.details.vo.PurchaseDetailsExportReqVO;
import cn.acsm.module.purchase.controller.admin.details.vo.PurchaseDetailsPageReqVO;
import cn.acsm.module.purchase.controller.admin.details.vo.PurchaseDetailsUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.details.PurchaseDetailsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 采购单明细 Service 接口
 *
 * @author 芋道源码
 */
public interface PurchaseDetailsService {

    /**
     * 创建采购单明细
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createDetails(@Valid PurchaseDetailsCreateReqVO createReqVO);

    /**
     * 更新采购单明细
     *
     * @param updateReqVO 更新信息
     */
    void updateDetails(@Valid PurchaseDetailsUpdateReqVO updateReqVO);

    /**
     * 删除采购单明细
     *
     * @param id 编号
     */
    void deleteDetails(Long id);

    /**
     * 获得采购单明细
     *
     * @param id 编号
     * @return 采购单明细
     */
    PurchaseDetailsDO getDetails(Long id);

    /**
     * 获得采购单明细列表
     *
     * @param ids 编号
     * @return 采购单明细列表
     */
    List<PurchaseDetailsDO> getDetailsList(Collection<Long> ids);

    /**
     * 获得采购单明细分页
     *
     * @param pageReqVO 分页查询
     * @return 采购单明细分页
     */
    PageResult<PurchaseDetailsDO> getDetailsPage(PurchaseDetailsPageReqVO pageReqVO);

    /**
     * 获得采购单明细列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 采购单明细列表
     */
    List<PurchaseDetailsDO> getDetailsList(PurchaseDetailsExportReqVO exportReqVO);

}
