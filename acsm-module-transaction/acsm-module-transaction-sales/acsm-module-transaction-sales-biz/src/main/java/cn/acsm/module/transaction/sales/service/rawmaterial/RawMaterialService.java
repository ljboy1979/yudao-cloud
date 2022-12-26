package cn.acsm.module.transaction.sales.service.rawmaterial;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.sales.controller.admin.rawmaterial.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.rawmaterial.RawMaterialDO;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 原料 Service 接口
 *
 * @author 芋道源码
 */
public interface RawMaterialService {

    /**
     * 创建原料
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    CommonResult<String> createRawMaterial(@Valid RawMaterialCreateReqVO createReqVO);

    /**
     * 更新原料
     *
     * @param updateReqVO 更新信息
     */
    CommonResult<String> updateRawMaterial(@Valid RawMaterialUpdateReqVO updateReqVO);

    /**
     * 删除原料
     *
     * @param id 编号
     */
    void deleteRawMaterial(String id);

    /**
     * 获得原料
     *
     * @param id 编号
     * @return 原料
     */
    RawMaterialDO getRawMaterial(String id);

    /**
     * 获得原料列表
     *
     * @param ids 编号
     * @return 原料列表
     */
    List<RawMaterialDO> getRawMaterialList(Collection<String> ids);

    /**
     * 获得原料分页
     *
     * @param pageReqVO 分页查询
     * @return 原料分页
     */
    PageResult<RawMaterialDO> getRawMaterialPage(RawMaterialPageReqVO pageReqVO);

    /**
     * 获得原料列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 原料列表
     */
    List<RawMaterialDO> getRawMaterialList(RawMaterialExportReqVO exportReqVO);

    List<RawMaterialDO> findList(RawMaterialReqVO rawMaterialReqVO);
}
