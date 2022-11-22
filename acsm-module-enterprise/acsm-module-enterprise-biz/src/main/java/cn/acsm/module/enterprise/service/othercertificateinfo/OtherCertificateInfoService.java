package cn.acsm.module.enterprise.service.othercertificateinfo;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.enterprise.controller.admin.othercertificateinfo.vo.*;
import cn.acsm.module.enterprise.dal.dataobject.othercertificateinfo.OtherCertificateInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 经营主体其他证件 Service 接口
 *
 * @author 芋道源码
 */
public interface OtherCertificateInfoService {

    /**
     * 创建经营主体其他证件
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createOtherCertificateInfo(@Valid OtherCertificateInfoCreateReqVO createReqVO);

    /**
     * 更新经营主体其他证件
     *
     * @param updateReqVO 更新信息
     */
    void updateOtherCertificateInfo(@Valid OtherCertificateInfoUpdateReqVO updateReqVO);

    /**
     * 删除经营主体其他证件
     *
     * @param id 编号
     */
    void deleteOtherCertificateInfo(Long id);

    /**
     * 获得经营主体其他证件
     *
     * @param id 编号
     * @return 经营主体其他证件
     */
    OtherCertificateInfoDO getOtherCertificateInfo(Long id);

    /**
     * 获得经营主体其他证件列表
     *
     * @param ids 编号
     * @return 经营主体其他证件列表
     */
    List<OtherCertificateInfoDO> getOtherCertificateInfoList(Collection<Long> ids);

    /**
     * 获得经营主体其他证件分页
     *
     * @param pageReqVO 分页查询
     * @return 经营主体其他证件分页
     */
    PageResult<OtherCertificateInfoDO> getOtherCertificateInfoPage(OtherCertificateInfoPageReqVO pageReqVO);

    /**
     * 获得经营主体其他证件列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 经营主体其他证件列表
     */
    List<OtherCertificateInfoDO> getOtherCertificateInfoList(OtherCertificateInfoExportReqVO exportReqVO);

}
