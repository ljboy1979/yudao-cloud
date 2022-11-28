package cn.iocoder.yudao.module.transaction.sales.service.inputsinfospecification;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.inputsinfospecification.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.inputsinfospecification.InputsInfoSpecificationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 投入品规格 Service 接口
 *
 * @author 芋道源码
 */
public interface InputsInfoSpecificationService {

    /**
     * 创建投入品规格
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createInputsInfoSpecification(@Valid InputsInfoSpecificationCreateReqVO createReqVO);

    /**
     * 更新投入品规格
     *
     * @param updateReqVO 更新信息
     */
    void updateInputsInfoSpecification(@Valid InputsInfoSpecificationUpdateReqVO updateReqVO);

    /**
     * 删除投入品规格
     *
     * @param id 编号
     */
    void deleteInputsInfoSpecification(String id);

    /**
     * 获得投入品规格
     *
     * @param id 编号
     * @return 投入品规格
     */
    InputsInfoSpecificationDO getInputsInfoSpecification(String id);

    /**
     * 获得投入品规格列表
     *
     * @param ids 编号
     * @return 投入品规格列表
     */
    List<InputsInfoSpecificationDO> getInputsInfoSpecificationList(Collection<String> ids);

    /**
     * 获得投入品规格分页
     *
     * @param pageReqVO 分页查询
     * @return 投入品规格分页
     */
    PageResult<InputsInfoSpecificationDO> getInputsInfoSpecificationPage(InputsInfoSpecificationPageReqVO pageReqVO);

    /**
     * 获得投入品规格列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 投入品规格列表
     */
    List<InputsInfoSpecificationDO> getInputsInfoSpecificationList(InputsInfoSpecificationExportReqVO exportReqVO);

}
