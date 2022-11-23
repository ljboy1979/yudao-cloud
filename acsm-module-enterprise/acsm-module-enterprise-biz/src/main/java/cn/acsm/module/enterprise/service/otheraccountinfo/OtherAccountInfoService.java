package cn.acsm.module.enterprise.service.otheraccountinfo;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.enterprise.controller.admin.otheraccountinfo.vo.OtherAccountInfoCreateReqVO;
import cn.acsm.module.enterprise.controller.admin.otheraccountinfo.vo.OtherAccountInfoExportReqVO;
import cn.acsm.module.enterprise.controller.admin.otheraccountinfo.vo.OtherAccountInfoPageReqVO;
import cn.acsm.module.enterprise.controller.admin.otheraccountinfo.vo.OtherAccountInfoUpdateReqVO;
import cn.acsm.module.enterprise.dal.dataobject.otheraccountinfo.OtherAccountInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 经营主体其他账户 Service 接口
 *
 * @author 芋道源码
 */
public interface OtherAccountInfoService {

    /**
     * 创建经营主体其他账户
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createOtherAccountInfo(@Valid OtherAccountInfoCreateReqVO createReqVO);

    /**
     * 更新经营主体其他账户
     *
     * @param updateReqVO 更新信息
     */
    void updateOtherAccountInfo(@Valid OtherAccountInfoUpdateReqVO updateReqVO);

    /**
     * 删除经营主体其他账户
     *
     * @param id 编号
     */
    void deleteOtherAccountInfo(Long id);

    /**
     * 获得经营主体其他账户
     *
     * @param id 编号
     * @return 经营主体其他账户
     */
    OtherAccountInfoDO getOtherAccountInfo(Long id);

    /**
     * 获得经营主体其他账户列表
     *
     * @param ids 编号
     * @return 经营主体其他账户列表
     */
    List< OtherAccountInfoDO > getOtherAccountInfoList(Collection<Long> ids);

    /**
     * 获得经营主体其他账户分页
     *
     * @param pageReqVO 分页查询
     * @return 经营主体其他账户分页
     */
    PageResult< OtherAccountInfoDO > getOtherAccountInfoPage(OtherAccountInfoPageReqVO pageReqVO);

    /**
     * 获得经营主体其他账户列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 经营主体其他账户列表
     */
    List< OtherAccountInfoDO > getOtherAccountInfoList(OtherAccountInfoExportReqVO exportReqVO);

}
