package cn.acsm.module.transaction.sales.service.specialmedicalfoodorganization;

import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodorganization.vo.SpecialMedicalFoodOrganUpdateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodorganization.vo.SpecialMedicalFoodOrganCreateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodorganization.vo.SpecialMedicalFoodOrganExportReqVO;
import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodorganization.vo.SpecialMedicalFoodOrganizationPageReqVO;
import cn.acsm.module.transaction.sales.dal.dataobject.specialmedicalfoodorganization.SpecialMedicalFoodOrganizationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 特医食品组成 Service 接口
 *
 * @author 芋道源码
 */
public interface SpecialMedicalFoodOrganizationService {

    /**
     * 创建特医食品组成
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createSpecialMedicalFoodOrganization(@Valid SpecialMedicalFoodOrganCreateReqVO createReqVO);

    /**
     * 更新特医食品组成
     *
     * @param updateReqVO 更新信息
     */
    void updateSpecialMedicalFoodOrganization(@Valid SpecialMedicalFoodOrganUpdateReqVO updateReqVO);

    /**
     * 删除特医食品组成
     *
     * @param id 编号
     */
    void deleteSpecialMedicalFoodOrganization(String id);

    /**
     * 获得特医食品组成
     *
     * @param id 编号
     * @return 特医食品组成
     */
    SpecialMedicalFoodOrganizationDO getSpecialMedicalFoodOrganization(String id);

    /**
     * 获得特医食品组成列表
     *
     * @param ids 编号
     * @return 特医食品组成列表
     */
    List<SpecialMedicalFoodOrganizationDO> getSpecialMedicalFoodOrganizationList(Collection<String> ids);

    /**
     * 获得特医食品组成分页
     *
     * @param pageReqVO 分页查询
     * @return 特医食品组成分页
     */
    PageResult<SpecialMedicalFoodOrganizationDO> getSpecialMedicalFoodOrganizationPage(SpecialMedicalFoodOrganizationPageReqVO pageReqVO);

    /**
     * 获得特医食品组成列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 特医食品组成列表
     */
    List<SpecialMedicalFoodOrganizationDO> getSpecialMedicalFoodOrganizationList(SpecialMedicalFoodOrganExportReqVO exportReqVO);

}
