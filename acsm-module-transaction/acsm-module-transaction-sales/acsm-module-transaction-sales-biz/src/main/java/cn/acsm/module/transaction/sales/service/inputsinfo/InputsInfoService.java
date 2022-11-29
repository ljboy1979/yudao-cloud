package cn.acsm.module.transaction.sales.service.inputsinfo;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.sales.controller.admin.inputsinfo.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.inputsinfo.InputsInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 投入品 Service 接口
 *
 * @author 芋道源码
 */
public interface InputsInfoService {

    /**
     * 创建投入品
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createInputsInfo(@Valid InputsInfoCreateReqVO createReqVO);

    /**
     * 更新投入品
     *
     * @param updateReqVO 更新信息
     */
    void updateInputsInfo(@Valid InputsInfoUpdateReqVO updateReqVO);

    /**
     * 删除投入品
     *
     * @param id 编号
     */
    void deleteInputsInfo(String id);

    /**
     * 获得投入品
     *
     * @param id 编号
     * @return 投入品
     */
    InputsInfoDO getInputsInfo(String id);

    /**
     * 获得投入品列表
     *
     * @param ids 编号
     * @return 投入品列表
     */
    List<InputsInfoDO> getInputsInfoList(Collection<String> ids);

    /**
     * 获得投入品分页
     *
     * @param pageReqVO 分页查询
     * @return 投入品分页
     */
    PageResult<InputsInfoDO> getInputsInfoPage(InputsInfoPageReqVO pageReqVO);

    /**
     * 获得投入品列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 投入品列表
     */
    List<InputsInfoDO> getInputsInfoList(InputsInfoExportReqVO exportReqVO);

}
