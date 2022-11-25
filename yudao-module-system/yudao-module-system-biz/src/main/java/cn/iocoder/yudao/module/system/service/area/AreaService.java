package cn.iocoder.yudao.module.system.service.area;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.area.vo.AreaCreateReqVO;
import cn.iocoder.yudao.module.system.controller.admin.area.vo.AreaExportReqVO;
import cn.iocoder.yudao.module.system.controller.admin.area.vo.AreaPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.area.vo.AreaUpdateReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.area.AreaDO;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 行政区划 Service 接口
 *
 * @author 芋道源码
 */
public interface AreaService {

    /**
     * 创建行政区划
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createArea(@Valid AreaCreateReqVO createReqVO);

    /**
     * 更新行政区划
     *
     * @param updateReqVO 更新信息
     */
    void updateArea(@Valid AreaUpdateReqVO updateReqVO);

    /**
     * 删除行政区划
     *
     * @param id 编号
     */
    void deleteArea(Long id);

    /**
     * 获得行政区划
     *
     * @param id 编号
     * @return 行政区划
     */
    AreaDO getArea(Long id);

    /**
     * 获得行政区划列表
     *
     * @param ids 编号
     * @return 行政区划列表
     */
    List<AreaDO> getAreaList(Collection<String> ids);

    /**
     * 获得行政区划分页
     *
     * @param pageReqVO 分页查询
     * @return 行政区划分页
     */
    PageResult<AreaDO> getAreaPage(AreaPageReqVO pageReqVO);

    /**
     * 获得行政区划列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 行政区划列表
     */
    List<AreaDO> getAreaList(AreaExportReqVO exportReqVO);

}
