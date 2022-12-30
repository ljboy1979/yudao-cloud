package cn.acsm.module.transaction.shelves.service.specifications;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.shelves.controller.admin.specifications.vo.*;
import cn.acsm.module.transaction.shelves.dal.dataobject.specifications.SpecificationsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 货架规格 Service 接口
 *
 * @author 芋道源码
 */
public interface SpecificationsService {

    /**
     * 创建货架规格
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createSpecifications(@Valid SpecificationsCreateReqVO createReqVO);

    /**
     * 更新货架规格
     *
     * @param updateReqVO 更新信息
     */
    void updateSpecifications(@Valid SpecificationsUpdateReqVO updateReqVO);

    /**
     * 删除货架规格
     *
     * @param id 编号
     */
    void deleteSpecifications(String id);

    /**
     * 获得货架规格
     *
     * @param id 编号
     * @return 货架规格
     */
    SpecificationsDO getSpecifications(String id);

    /**
     * 获得货架规格列表
     *
     * @param ids 编号
     * @return 货架规格列表
     */
    List<SpecificationsDO> getSpecificationsList(Collection<String> ids);

    /**
     * 获得货架规格分页
     *
     * @param pageReqVO 分页查询
     * @return 货架规格分页
     */
    PageResult<SpecificationsDO> getSpecificationsPage(SpecificationsPageReqVO pageReqVO);

    /**
     * 获得货架规格列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 货架规格列表
     */
    List<SpecificationsDO> getSpecificationsList(SpecificationsExportReqVO exportReqVO);

    List<SpecificationsRespVO> findSpecifications(SpecificationsPageReqVO specificationsPageReqVO);
}
