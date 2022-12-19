package cn.acsm.module.production.tunnel.service.info;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.production.tunnel.controller.admin.info.vo.*;
import cn.acsm.module.production.tunnel.dal.dataobject.info.InfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 地块信息 Service 接口
 *
 * @author 芋道源码
 */
public interface InfoService {

    /**
     * 创建地块信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createInfo(@Valid InfoCreateReqVO createReqVO);

    /**
     * 更新地块信息
     *
     * @param updateReqVO 更新信息
     */
    void updateInfo(@Valid InfoUpdateReqVO updateReqVO);

    /**
     * 删除地块信息
     *
     * @param id 编号
     */
    void deleteInfo(Long id);

    /**
     * 获得地块信息
     *
     * @param id 编号
     * @return 地块信息
     */
    InfoDO getInfo(Long id);

    /**
     * 获得地块信息列表
     *
     * @param ids 编号
     * @return 地块信息列表
     */
    List<InfoDO> getInfoList(Collection<Long> ids);

    /**
     * 获得地块信息分页
     *
     * @param pageReqVO 分页查询
     * @return 地块信息分页
     */
    PageResult<InfoDO> getInfoPage(InfoPageReqVO pageReqVO);

    /**
     * 获得地块信息列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 地块信息列表
     */
    List<InfoDO> getInfoList(InfoExportReqVO exportReqVO);

}
