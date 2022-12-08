package cn.acsm.module.transaction.order.service.costinfo;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.order.controller.admin.costinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.costinfo.CostInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 费用 Service 接口
 *
 * @author 芋道源码
 */
public interface CostInfoService {

    /**
     * 创建费用
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createCostInfo(@Valid CostInfoCreateReqVO createReqVO);

    /**
     * 更新费用
     *
     * @param updateReqVO 更新信息
     */
    void updateCostInfo(@Valid CostInfoUpdateReqVO updateReqVO);

    /**
     * 删除费用
     *
     * @param id 编号
     */
    void deleteCostInfo(String id);

    /**
     * 获得费用
     *
     * @param id 编号
     * @return 费用
     */
    CostInfoDO getCostInfo(String id);

    /**
     * 获得费用列表
     *
     * @param ids 编号
     * @return 费用列表
     */
    List<CostInfoDO> getCostInfoList(Collection<String> ids);

    /**
     * 获得费用分页
     *
     * @param pageReqVO 分页查询
     * @return 费用分页
     */
    PageResult<CostInfoDO> getCostInfoPage(CostInfoPageReqVO pageReqVO);

    /**
     * 获得费用列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 费用列表
     */
    List<CostInfoDO> getCostInfoList(CostInfoExportReqVO exportReqVO);

}
