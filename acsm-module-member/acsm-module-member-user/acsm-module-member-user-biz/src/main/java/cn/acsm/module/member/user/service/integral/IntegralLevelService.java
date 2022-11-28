package cn.acsm.module.member.user.service.integral;

import cn.acsm.module.member.user.controller.admin.integral.vo.level.IntegralLevelCreateReqVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.level.IntegralLevelExportReqVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.level.IntegralLevelPageReqVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.level.IntegralLevelUpdateReqVO;
import cn.acsm.module.member.user.dal.dataobject.integral.IntegralLevelDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 会员积分等级 Service 接口
 *
 * @author lihongyan
 */
public interface IntegralLevelService {

    /**
     * 创建会员积分等级
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createIntegralLevel(@Valid IntegralLevelCreateReqVO createReqVO);

    /**
     * 更新会员积分等级
     *
     * @param updateReqVO 更新信息
     */
    void updateIntegralLevel(@Valid IntegralLevelUpdateReqVO updateReqVO);

    /**
     * 删除会员积分等级
     *
     * @param id 编号
     */
    void deleteIntegralLevel(Long id);

    /**
     * 获得会员积分等级
     *
     * @param id 编号
     * @return 会员积分等级
     */
    IntegralLevelDO getIntegralLevel(Long id);

    /**
     * 获得会员积分等级列表
     *
     * @param ids 编号
     * @return 会员积分等级列表
     */
    List<IntegralLevelDO> getIntegralLevelList(Collection<Long> ids);

    /**
     * 获得会员积分等级分页
     *
     * @param pageReqVO 分页查询
     * @return 会员积分等级分页
     */
    PageResult<IntegralLevelDO> getIntegralLevelPage(IntegralLevelPageReqVO pageReqVO);

    /**
     * 获得会员积分等级列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 会员积分等级列表
     */
    List<IntegralLevelDO> getIntegralLevelList(IntegralLevelExportReqVO exportReqVO);

}
