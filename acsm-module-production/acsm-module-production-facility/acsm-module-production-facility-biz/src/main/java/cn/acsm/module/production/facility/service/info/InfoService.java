package cn.acsm.module.production.facility.service.info;

import cn.acsm.module.production.facility.api.info.dto.FacilityInfoDto;
import cn.acsm.module.production.facility.controller.admin.info.vo.InfoCreateReqVO;
import cn.acsm.module.production.facility.controller.admin.info.vo.InfoExportReqVO;
import cn.acsm.module.production.facility.controller.admin.info.vo.InfoPageReqVO;
import cn.acsm.module.production.facility.controller.admin.info.vo.InfoUpdateReqVO;
import cn.acsm.module.production.facility.dal.dataobject.info.InfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 设施 Service 接口
 *
 * @author 芋道源码
 */
public interface InfoService {

    /**
     * 创建设施
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createInfo(@Valid InfoCreateReqVO createReqVO);

    /**
     * 更新设施
     *
     * @param updateReqVO 更新信息
     */
    void updateInfo(@Valid InfoUpdateReqVO updateReqVO);

    /**
     * 删除设施
     *
     * @param id 编号
     */
    void deleteInfo(Long id);

    /**
     * 获得设施
     *
     * @param id 编号
     * @return 设施
     */
    InfoDO getInfo(Long id);

    /**
     * 获得设施列表
     *
     * @param ids 编号
     * @return 设施列表
     */
    List<InfoDO> getInfoList(Collection<Long> ids);

    /**
     * 获得设施分页
     *
     * @param pageReqVO 分页查询
     * @return 设施分页
     */
    PageResult<InfoDO> getInfoPage(InfoPageReqVO pageReqVO);

    /**
     * 获得设施列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 设施列表
     */
    List<InfoDO> getInfoList(InfoExportReqVO exportReqVO);

    /**
     * 通过主键获取 详情
     * @param id
     * @return
     */
    public FacilityInfoDto getFacilityInfoById(Long id);

}
