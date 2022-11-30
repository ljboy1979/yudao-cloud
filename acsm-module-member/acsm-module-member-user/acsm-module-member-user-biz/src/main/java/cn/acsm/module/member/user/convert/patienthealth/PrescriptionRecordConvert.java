package cn.acsm.module.member.user.convert.patienthealth;

import java.util.*;

import cn.acsm.module.member.user.controller.admin.patient.vo.prescription.PrescriptionRecordCreateReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.prescription.PrescriptionRecordExcelVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.prescription.PrescriptionRecordRespVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.prescription.PrescriptionRecordUpdateReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.PrescriptionRecordDO;

/**
 * 处方记录表 Convert
 *
 * @author lihongyan
 */
@Mapper
public interface PrescriptionRecordConvert {

    PrescriptionRecordConvert INSTANCE = Mappers.getMapper(PrescriptionRecordConvert.class);

    PrescriptionRecordDO convert(PrescriptionRecordCreateReqVO bean);

    PrescriptionRecordDO convert(PrescriptionRecordUpdateReqVO bean);

    PrescriptionRecordRespVO convert(PrescriptionRecordDO bean);

    List<PrescriptionRecordRespVO> convertList(List<PrescriptionRecordDO> list);

    PageResult<PrescriptionRecordRespVO> convertPage(PageResult<PrescriptionRecordDO> page);

    List<PrescriptionRecordExcelVO> convertList02(List<PrescriptionRecordDO> list);

}
