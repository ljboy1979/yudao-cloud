package cn.iocoder.yudao.module.transaction.sales.service.rawmaterialspecification;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.rawmaterialspecification.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.rawmaterialspecification.RawMaterialSpecificationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 原料规格 Service 接口
 *
 * @author 芋道源码
 */
public interface RawMaterialSpecificationService {

    /**
     * 创建原料规格
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createRawMaterialSpecification(@Valid RawMaterialSpecificationCreateReqVO createReqVO);

    /**
     * 更新原料规格
     *
     * @param updateReqVO 更新信息
     */
    void updateRawMaterialSpecification(@Valid RawMaterialSpecificationUpdateReqVO updateReqVO);

    /**
     * 删除原料规格
     *
     * @param id 编号
     */
    void deleteRawMaterialSpecification(String id);

    /**
     * 获得原料规格
     *
     * @param id 编号
     * @return 原料规格
     */
    RawMaterialSpecificationDO getRawMaterialSpecification(String id);

    /**
     * 获得原料规格列表
     *
     * @param ids 编号
     * @return 原料规格列表
     */
    List<RawMaterialSpecificationDO> getRawMaterialSpecificationList(Collection<String> ids);

    /**
     * 获得原料规格分页
     *
     * @param pageReqVO 分页查询
     * @return 原料规格分页
     */
    PageResult<RawMaterialSpecificationDO> getRawMaterialSpecificationPage(RawMaterialSpecificationPageReqVO pageReqVO);

    /**
     * 获得原料规格列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 原料规格列表
     */
    List<RawMaterialSpecificationDO> getRawMaterialSpecificationList(RawMaterialSpecificationExportReqVO exportReqVO);

}
