package cn.acsm.module.member.user.service.patienthealth;

import cn.acsm.module.member.user.controller.admin.patient.vo.specialmedicalfood.SpecialMedicalFoodRecordsCreateReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.specialmedicalfood.SpecialMedicalFoodRecordsExportReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.specialmedicalfood.SpecialMedicalFoodRecordsPageReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.specialmedicalfood.SpecialMedicalFoodRecordsUpdateReqVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.SpecialMedicalFoodRecordsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.member.user.convert.patienthealth.SpecialMedicalFoodRecordsConvert;
import cn.acsm.module.member.user.dal.mysql.patienthealth.SpecialMedicalFoodRecordsMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.member.user.enums.ErrorCodeConstants.*;

/**
 * 特医食品使用记录表 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class SpecialMedicalFoodRecordsServiceImpl implements SpecialMedicalFoodRecordsService {

    @Resource
    private SpecialMedicalFoodRecordsMapper specialMedicalFoodRecordsMapper;

    @Override
    public Long createSpecialMedicalFoodRecords(SpecialMedicalFoodRecordsCreateReqVO createReqVO) {
        // 插入
        SpecialMedicalFoodRecordsDO specialMedicalFoodRecords = SpecialMedicalFoodRecordsConvert.INSTANCE.convert(createReqVO);
        specialMedicalFoodRecordsMapper.insert(specialMedicalFoodRecords);
        // 返回
        return specialMedicalFoodRecords.getId();
    }

    @Override
    public void updateSpecialMedicalFoodRecords(SpecialMedicalFoodRecordsUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateSpecialMedicalFoodRecordsExists(updateReqVO.getId());
        // 更新
        SpecialMedicalFoodRecordsDO updateObj = SpecialMedicalFoodRecordsConvert.INSTANCE.convert(updateReqVO);
        specialMedicalFoodRecordsMapper.updateById(updateObj);
    }

    @Override
    public void deleteSpecialMedicalFoodRecords(Long id) {
        // 校验存在
        this.validateSpecialMedicalFoodRecordsExists(id);
        // 删除
        specialMedicalFoodRecordsMapper.deleteById(id);
    }

    private void validateSpecialMedicalFoodRecordsExists(Long id) {
        if (specialMedicalFoodRecordsMapper.selectById(id) == null) {
            throw exception(SPECIAL_MEDICAL_FOOD_RECORDS_NOT_EXISTS);
        }
    }

    @Override
    public SpecialMedicalFoodRecordsDO getSpecialMedicalFoodRecords(Long id) {
        return specialMedicalFoodRecordsMapper.selectById(id);
    }

    @Override
    public List<SpecialMedicalFoodRecordsDO> getSpecialMedicalFoodRecordsList(Collection<Long> ids) {
        return specialMedicalFoodRecordsMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<SpecialMedicalFoodRecordsDO> getSpecialMedicalFoodRecordsPage(SpecialMedicalFoodRecordsPageReqVO pageReqVO) {
        return specialMedicalFoodRecordsMapper.selectPage(pageReqVO);
    }

    @Override
    public List<SpecialMedicalFoodRecordsDO> getSpecialMedicalFoodRecordsList(SpecialMedicalFoodRecordsExportReqVO exportReqVO) {
        return specialMedicalFoodRecordsMapper.selectList(exportReqVO);
    }

}
