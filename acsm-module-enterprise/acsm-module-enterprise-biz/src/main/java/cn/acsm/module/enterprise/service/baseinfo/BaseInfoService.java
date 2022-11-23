package cn.acsm.module.enterprise.service.baseinfo;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.enterprise.controller.admin.baseinfo.vo.BaseInfoCreateReqVO;
import cn.acsm.module.enterprise.controller.admin.baseinfo.vo.BaseInfoExportReqVO;
import cn.acsm.module.enterprise.controller.admin.baseinfo.vo.BaseInfoPageReqVO;
import cn.acsm.module.enterprise.controller.admin.baseinfo.vo.BaseInfoUpdateReqVO;
import cn.acsm.module.enterprise.dal.dataobject.baseinfo.BaseInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 经营主体 Service 接口
 *
 * @author 芋道源码
 */
public interface BaseInfoService {

    /**
     * 创建经营主体
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createBaseInfo(@Valid BaseInfoCreateReqVO createReqVO);

    /**
     * 更新经营主体
     *
     * @param updateReqVO 更新信息
     */
    void updateBaseInfo(@Valid BaseInfoUpdateReqVO updateReqVO);

    /**
     * 删除经营主体
     *
     * @param id 编号
     */
    void deleteBaseInfo(Long id);
    /**
     * 停用经营主体
     *
     * @param id 编号
     */
    void stopEnterprise(Long id);

    /**
     * 获得经营主体
     *
     * @param id 编号
     * @return 经营主体
     */
    BaseInfoDO getBaseInfo(Long id);

    /**
     * 获得经营主体列表
     *
     * @param ids 编号
     * @return 经营主体列表
     */
    List<BaseInfoDO> getBaseInfoList(Collection<Long> ids);

    /**
     * 获得经营主体分页
     *
     * @param pageReqVO 分页查询
     * @return 经营主体分页
     */
    PageResult<BaseInfoDO> getBaseInfoPage(BaseInfoPageReqVO pageReqVO);

    /**
     * 获得经营主体列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 经营主体列表
     */
    List<BaseInfoDO> getBaseInfoList(BaseInfoExportReqVO exportReqVO);

}
