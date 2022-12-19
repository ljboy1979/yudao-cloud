package cn.acsm.module.production.bases.service.subsidy;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.production.bases.controller.admin.subsidy.vo.SubsidyCreateReqVO;
import cn.acsm.module.production.bases.controller.admin.subsidy.vo.SubsidyExportReqVO;
import cn.acsm.module.production.bases.controller.admin.subsidy.vo.SubsidyPageReqVO;
import cn.acsm.module.production.bases.controller.admin.subsidy.vo.SubsidyUpdateReqVO;
import cn.acsm.module.production.bases.dal.dataobject.subsidy.SubsidyDO;
import cn.acsm.module.production.bases.controller.admin.subsidy.vo.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 基地补贴信息 Service 接口
 *
 * @author 芋道源码
 */
public interface SubsidyService {

    /**
     * 创建基地补贴信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createSubsidy(@Valid SubsidyCreateReqVO createReqVO);

    /**
     * 更新基地补贴信息
     *
     * @param updateReqVO 更新信息
     */
    void updateSubsidy(@Valid SubsidyUpdateReqVO updateReqVO);

    /**
     * 删除基地补贴信息
     *
     * @param id 编号
     */
    void deleteSubsidy(Long id);

    /**
     * 获得基地补贴信息
     *
     * @param id 编号
     * @return 基地补贴信息
     */
    SubsidyDO getSubsidy(Long id);

    /**
     * 获得基地补贴信息列表
     *
     * @param ids 编号
     * @return 基地补贴信息列表
     */
    List<SubsidyDO> getSubsidyList(Collection<Long> ids);

    /**
     * 获得基地补贴信息分页
     *
     * @param pageReqVO 分页查询
     * @return 基地补贴信息分页
     */
    PageResult<SubsidyDO> getSubsidyPage(SubsidyPageReqVO pageReqVO);

    /**
     * 获得基地补贴信息列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 基地补贴信息列表
     */
    List<SubsidyDO> getSubsidyList(SubsidyExportReqVO exportReqVO);

}
