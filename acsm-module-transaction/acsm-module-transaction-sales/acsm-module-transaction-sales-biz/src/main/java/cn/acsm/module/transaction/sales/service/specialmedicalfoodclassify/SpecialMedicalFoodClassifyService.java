package cn.acsm.module.transaction.sales.service.specialmedicalfoodclassify;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodclassify.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.specialmedicalfoodclassify.SpecialMedicalFoodClassifyDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeSelect;

/**
 * 特医食品分类 Service 接口
 *
 * @author 芋道源码
 */
public interface SpecialMedicalFoodClassifyService {

    /**
     * 创建特医食品分类
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createSpecialMedicalFoodClassify(@Valid SpecialMedicalFoodClassifyCreateReqVO createReqVO);

    /**
     * 更新特医食品分类
     *
     * @param updateReqVO 更新信息
     */
    void updateSpecialMedicalFoodClassify(@Valid SpecialMedicalFoodClassifyUpdateReqVO updateReqVO);

    /**
     * 删除特医食品分类
     *
     * @param id 编号
     */
    void deleteSpecialMedicalFoodClassify(String id);

    /**
     * 获得特医食品分类
     *
     * @param id 编号
     * @return 特医食品分类
     */
    SpecialMedicalFoodClassifyDO getSpecialMedicalFoodClassify(String id);

    /**
     * 获得特医食品分类列表
     *
     * @param ids 编号
     * @return 特医食品分类列表
     */
    List<SpecialMedicalFoodClassifyDO> getSpecialMedicalFoodClassifyList(Collection<String> ids);

    /**
     * 获得特医食品分类分页
     *
     * @param pageReqVO 分页查询
     * @return 特医食品分类分页
     */
    PageResult<SpecialMedicalFoodClassifyDO> getSpecialMedicalFoodClassifyPage(SpecialMedicalFoodClassifyPageReqVO pageReqVO);

    /**
     * 获得特医食品分类列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 特医食品分类列表
     */
    List<SpecialMedicalFoodClassifyDO> getSpecialMedicalFoodClassifyList(SpecialMedicalFoodClassifyExportReqVO exportReqVO);

    List<TreeSelect> findTreeList(SpecialMedicalFoodClassifyTreeVO specialMedicalFoodClassifyTreeVO);
}
