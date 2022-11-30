package cn.acsm.module.member.user.service.integral;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.member.user.controller.admin.integral.vo.record.IntegralRecordCreateReqVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.record.IntegralRecordExportReqVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.record.IntegralRecordPageReqVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.record.IntegralRecordUpdateReqVO;
import cn.acsm.module.member.user.dal.dataobject.integral.IntegralRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 会员积分记录 Service 接口
 *
 * @author lihongyan
 */
public interface IntegralRecordService {

    /**
     * 创建会员积分记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createIntegralRecord(@Valid IntegralRecordCreateReqVO createReqVO);

    /**
     * 更新会员积分记录
     *
     * @param updateReqVO 更新信息
     */
    void updateIntegralRecord(@Valid IntegralRecordUpdateReqVO updateReqVO);

    /**
     * 删除会员积分记录
     *
     * @param id 编号
     */
    void deleteIntegralRecord(Long id);

    /**
     * 获得会员积分记录
     *
     * @param id 编号
     * @return 会员积分记录
     */
    IntegralRecordDO getIntegralRecord(Long id);

    /**
     * 获得会员积分记录列表
     *
     * @param ids 编号
     * @return 会员积分记录列表
     */
    List<IntegralRecordDO> getIntegralRecordList(Collection<Long> ids);

    /**
     * 获得会员积分记录分页
     *
     * @param pageReqVO 分页查询
     * @return 会员积分记录分页
     */
    PageResult<IntegralRecordDO> getIntegralRecordPage(IntegralRecordPageReqVO pageReqVO);

    /**
     * 获得会员积分记录列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 会员积分记录列表
     */
    List<IntegralRecordDO> getIntegralRecordList(IntegralRecordExportReqVO exportReqVO);

}
