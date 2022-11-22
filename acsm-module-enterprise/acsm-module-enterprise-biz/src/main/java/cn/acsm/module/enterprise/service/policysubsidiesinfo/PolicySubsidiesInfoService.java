package cn.acsm.module.enterprise.service.policysubsidiesinfo;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo.PolicySubsidiesInfoCreateReqVO;
import cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo.PolicySubsidiesInfoExportReqVO;
import cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo.PolicySubsidiesInfoPageReqVO;
import cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo.PolicySubsidiesInfoUpdateReqVO;
import cn.acsm.module.enterprise.dal.dataobject.policysubsidiesinfo.PolicySubsidiesInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 企业政策补贴信息 Service 接口
 *
 * @author 芋道源码
 */
public interface PolicySubsidiesInfoService {

    /**
     * 创建企业政策补贴信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPolicySubsidiesInfo(@Valid PolicySubsidiesInfoCreateReqVO createReqVO);

    /**
     * 更新企业政策补贴信息
     *
     * @param updateReqVO 更新信息
     */
    void updatePolicySubsidiesInfo(@Valid PolicySubsidiesInfoUpdateReqVO updateReqVO);

    /**
     * 删除企业政策补贴信息
     *
     * @param id 编号
     */
    void deletePolicySubsidiesInfo(Long id);

    /**
     * 获得企业政策补贴信息
     *
     * @param id 编号
     * @return 企业政策补贴信息
     */
    PolicySubsidiesInfoDO getPolicySubsidiesInfo(Long id);

    /**
     * 获得企业政策补贴信息列表
     *
     * @param ids 编号
     * @return 企业政策补贴信息列表
     */
    List<PolicySubsidiesInfoDO> getPolicySubsidiesInfoList(Collection<Long> ids);

    /**
     * 获得企业政策补贴信息分页
     *
     * @param pageReqVO 分页查询
     * @return 企业政策补贴信息分页
     */
    PageResult<PolicySubsidiesInfoDO> getPolicySubsidiesInfoPage(PolicySubsidiesInfoPageReqVO pageReqVO);

    /**
     * 获得企业政策补贴信息列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 企业政策补贴信息列表
     */
    List<PolicySubsidiesInfoDO> getPolicySubsidiesInfoList(PolicySubsidiesInfoExportReqVO exportReqVO);

}
