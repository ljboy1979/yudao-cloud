package cn.acsm.module.enterprise.convert.othercertificateinfo;


import cn.acsm.module.enterprise.controller.admin.othercertificateinfo.vo.OtherCertificateInfoCreateReqVO;
import cn.acsm.module.enterprise.controller.admin.othercertificateinfo.vo.OtherCertificateInfoExcelVO;
import cn.acsm.module.enterprise.controller.admin.othercertificateinfo.vo.OtherCertificateInfoRespVO;
import cn.acsm.module.enterprise.controller.admin.othercertificateinfo.vo.OtherCertificateInfoUpdateReqVO;
import cn.acsm.module.enterprise.dal.dataobject.othercertificateinfo.OtherCertificateInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 经营主体其他证件 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface OtherCertificateInfoConvert {

    OtherCertificateInfoConvert INSTANCE = Mappers.getMapper(OtherCertificateInfoConvert.class);

    OtherCertificateInfoDO convert(OtherCertificateInfoCreateReqVO bean);

    OtherCertificateInfoDO convert(OtherCertificateInfoUpdateReqVO bean);

    OtherCertificateInfoRespVO convert(OtherCertificateInfoDO bean);

    List<OtherCertificateInfoRespVO> convertList(List<OtherCertificateInfoDO> list);

    PageResult<OtherCertificateInfoRespVO> convertPage(PageResult<OtherCertificateInfoDO> page);

    List< OtherCertificateInfoExcelVO > convertList02(List<OtherCertificateInfoDO> list);

}
