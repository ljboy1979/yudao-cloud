package cn.acsm.module.transaction.sales.service.rawmaterialclassify;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.transaction.sales.dal.dataobject.rawmaterialclassify.RawMaterialClassifyDO;
import cn.acsm.module.transaction.sales.controller.admin.rawmaterialclassify.vo.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeSelect;
/**
 * 原料分类 Service 接口
 *
 * @author 芋道源码
 */
public interface RawMaterialClassifyService {

    /**
     * 创建原料分类
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createRawMaterialClassify(@Valid RawMaterialClassifyCreateReqVO createReqVO);

    /**
     * 更新原料分类
     *
     * @param updateReqVO 更新信息
     */
    void updateRawMaterialClassify(@Valid RawMaterialClassifyUpdateReqVO updateReqVO);

    /**
     * 删除原料分类
     *
     * @param id 编号
     */
    void deleteRawMaterialClassify(String id);

    /**
     * 获得原料分类
     *
     * @param id 编号
     * @return 原料分类
     */
    RawMaterialClassifyDO getRawMaterialClassify(String id);

    /**
     * 获得原料分类列表
     *
     * @param ids 编号
     * @return 原料分类列表
     */
    List<RawMaterialClassifyDO> getRawMaterialClassifyList(Collection<String> ids);

    /**
     * 获得原料分类分页
     *
     * @param pageReqVO 分页查询
     * @return 原料分类分页
     */
    PageResult<RawMaterialClassifyDO> getRawMaterialClassifyPage(RawMaterialClassifyPageReqVO pageReqVO);

    /**
     * 获得原料分类列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 原料分类列表
     */
    List<RawMaterialClassifyDO> getRawMaterialClassifyList(RawMaterialClassifyExportReqVO exportReqVO);

    List<TreeSelect> findTreeList(RawMaterialClassifyTreeVO rawMaterialClassifyTreeVO);
}
