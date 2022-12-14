package cn.acsm.module.purchase.service.receivingstandard;

import cn.acsm.module.purchase.controller.admin.receivingstandard.vo.PurchaseReceivingStandardCreateReqVO;
import cn.acsm.module.purchase.controller.admin.receivingstandard.vo.PurchaseReceivingStandardExportReqVO;
import cn.acsm.module.purchase.controller.admin.receivingstandard.vo.PurchaseReceivingStandardPageReqVO;
import cn.acsm.module.purchase.controller.admin.receivingstandard.vo.PurchaseReceivingStandardUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.receivingstandard.PurchaseReceivingStandardDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 收货标准 Service 接口
 *
 * @author 芋道源码
 */
public interface PurchaseReceivingStandardService {

    /**
     * 创建收货标准
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createReceivingStandard(@Valid PurchaseReceivingStandardCreateReqVO createReqVO);

    /**
     * 更新收货标准
     *
     * @param updateReqVO 更新信息
     */
    void updateReceivingStandard(@Valid PurchaseReceivingStandardUpdateReqVO updateReqVO);

    /**
     * 删除收货标准
     *
     * @param id 编号
     */
    void deleteReceivingStandard(Long id);

    /**
     * 获得收货标准
     *
     * @param id 编号
     * @return 收货标准
     */
    PurchaseReceivingStandardDO getReceivingStandard(Long id);

    /**
     * 获得收货标准列表
     *
     * @param ids 编号
     * @return 收货标准列表
     */
    List<PurchaseReceivingStandardDO> getReceivingStandardList(Collection<Long> ids);

    /**
     * 获得收货标准分页
     *
     * @param pageReqVO 分页查询
     * @return 收货标准分页
     */
    PageResult<PurchaseReceivingStandardDO> getReceivingStandardPage(PurchaseReceivingStandardPageReqVO pageReqVO);

    /**
     * 获得收货标准列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 收货标准列表
     */
    List<PurchaseReceivingStandardDO> getReceivingStandardList(PurchaseReceivingStandardExportReqVO exportReqVO);

}
