package cn.acsm.module.transaction.sales.service.inputclassify;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.sales.controller.admin.inputclassify.vo.*;
import cn.acsm.module.transaction.sales.controller.admin.inputclassify.vo.InputClassifyCreateReqVO;
import cn.acsm.module.transaction.sales.dal.dataobject.inputclassify.InputClassifyDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeSelect;

/**
 * 投入品分类 Service 接口
 *
 * @author 芋道源码
 */
public interface InputClassifyService {

    /**
     * 创建投入品分类
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createInputClassify(@Valid InputClassifyCreateReqVO createReqVO);

    /**
     * 更新投入品分类
     *
     * @param updateReqVO 更新信息
     */
    void updateInputClassify(@Valid InputClassifyUpdateReqVO updateReqVO);

    /**
     * 删除投入品分类
     *
     * @param id 编号
     */
    void deleteInputClassify(String id);

    /**
     * 获得投入品分类
     *
     * @param id 编号
     * @return 投入品分类
     */
    InputClassifyDO getInputClassify(String id);

    /**
     * 获得投入品分类列表
     *
     * @param ids 编号
     * @return 投入品分类列表
     */
    List<InputClassifyDO> getInputClassifyList(Collection<String> ids);

    /**
     * 获得投入品分类分页
     *
     * @param pageReqVO 分页查询
     * @return 投入品分类分页
     */
    PageResult<InputClassifyDO> getInputClassifyPage(InputClassifyPageReqVO pageReqVO);

    /**
     * 获得投入品分类列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 投入品分类列表
     */
    List<InputClassifyDO> getInputClassifyList(InputClassifyExportReqVO exportReqVO);

    List<TreeSelect> findTreeList(InputClassifyTreeVO inputClassifyTreeVO);
}
