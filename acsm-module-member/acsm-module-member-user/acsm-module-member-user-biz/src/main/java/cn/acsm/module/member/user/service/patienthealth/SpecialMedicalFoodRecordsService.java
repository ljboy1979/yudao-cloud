package cn.acsm.module.member.user.service.patienthealth;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.member.user.controller.admin.patient.vo.specialmedicalfood.SpecialMedicalFoodRecordsCreateReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.specialmedicalfood.SpecialMedicalFoodRecordsExportReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.specialmedicalfood.SpecialMedicalFoodRecordsPageReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.specialmedicalfood.SpecialMedicalFoodRecordsUpdateReqVO;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.SpecialMedicalFoodRecordsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 特医食品使用记录表 Service 接口
 *
 * @author lihongyan
 */
public interface SpecialMedicalFoodRecordsService {

    /**
     * 创建特医食品使用记录表
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createSpecialMedicalFoodRecords(@Valid SpecialMedicalFoodRecordsCreateReqVO createReqVO);

    /**
     * 更新特医食品使用记录表
     *
     * @param updateReqVO 更新信息
     */
    void updateSpecialMedicalFoodRecords(@Valid SpecialMedicalFoodRecordsUpdateReqVO updateReqVO);

    /**
     * 删除特医食品使用记录表
     *
     * @param id 编号
     */
    void deleteSpecialMedicalFoodRecords(Long id);

    /**
     * 获得特医食品使用记录表
     *
     * @param id 编号
     * @return 特医食品使用记录表
     */
    SpecialMedicalFoodRecordsDO getSpecialMedicalFoodRecords(Long id);

    /**
     * 获得特医食品使用记录表列表
     *
     * @param ids 编号
     * @return 特医食品使用记录表列表
     */
    List<SpecialMedicalFoodRecordsDO> getSpecialMedicalFoodRecordsList(Collection<Long> ids);

    /**
     * 获得特医食品使用记录表分页
     *
     * @param pageReqVO 分页查询
     * @return 特医食品使用记录表分页
     */
    PageResult<SpecialMedicalFoodRecordsDO> getSpecialMedicalFoodRecordsPage(SpecialMedicalFoodRecordsPageReqVO pageReqVO);

    /**
     * 获得特医食品使用记录表列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 特医食品使用记录表列表
     */
    List<SpecialMedicalFoodRecordsDO> getSpecialMedicalFoodRecordsList(SpecialMedicalFoodRecordsExportReqVO exportReqVO);

}
