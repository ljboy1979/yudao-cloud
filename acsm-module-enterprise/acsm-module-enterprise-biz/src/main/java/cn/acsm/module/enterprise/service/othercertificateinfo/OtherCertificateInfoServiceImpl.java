package cn.acsm.module.enterprise.service.othercertificateinfo;

import cn.acsm.module.enterprise.controller.admin.othercertificateinfo.vo.OtherCertificateInfoCreateReqVO;
import cn.acsm.module.enterprise.controller.admin.othercertificateinfo.vo.OtherCertificateInfoExportReqVO;
import cn.acsm.module.enterprise.controller.admin.othercertificateinfo.vo.OtherCertificateInfoPageReqVO;
import cn.acsm.module.enterprise.controller.admin.othercertificateinfo.vo.OtherCertificateInfoUpdateReqVO;
import cn.acsm.module.enterprise.dal.dataobject.othercertificateinfo.OtherCertificateInfoDO;
import cn.acsm.module.enterprise.dal.mysql.othercertificateinfo.OtherCertificateInfoMapper;
import cn.acsm.module.enterprise.convert.othercertificateinfo.OtherCertificateInfoConvert;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;


import static cn.acsm.module.enterprise.enums.ErrorCodeConstants.OTHER_CERTIFICATE_INFO_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 经营主体其他证件 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class OtherCertificateInfoServiceImpl implements OtherCertificateInfoService {

    @Resource
    private OtherCertificateInfoMapper otherCertificateInfoMapper;

    @Override
    public Long createOtherCertificateInfo(OtherCertificateInfoCreateReqVO createReqVO) {
        // 插入
        OtherCertificateInfoDO otherCertificateInfo = OtherCertificateInfoConvert.INSTANCE.convert(createReqVO);
        otherCertificateInfoMapper.insert(otherCertificateInfo);
        // 返回
        return otherCertificateInfo.getId();
    }

    @Override
    public void updateOtherCertificateInfo(OtherCertificateInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateOtherCertificateInfoExists(updateReqVO.getId());
        // 更新
        OtherCertificateInfoDO updateObj = OtherCertificateInfoConvert.INSTANCE.convert(updateReqVO);
        otherCertificateInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteOtherCertificateInfo(Long id) {
        // 校验存在
        this.validateOtherCertificateInfoExists(id);
        // 删除
        otherCertificateInfoMapper.deleteById(id);
    }

    private void validateOtherCertificateInfoExists(Long id) {
        if (otherCertificateInfoMapper.selectById(id) == null) {
            throw exception(OTHER_CERTIFICATE_INFO_NOT_EXISTS);
        }
    }

    @Override
    public OtherCertificateInfoDO getOtherCertificateInfo(Long id) {
        return otherCertificateInfoMapper.selectById(id);
    }

    @Override
    public List<OtherCertificateInfoDO> getOtherCertificateInfoList(Collection<Long> ids) {
        return otherCertificateInfoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<OtherCertificateInfoDO> getOtherCertificateInfoPage(OtherCertificateInfoPageReqVO pageReqVO) {
        return otherCertificateInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<OtherCertificateInfoDO> getOtherCertificateInfoList(OtherCertificateInfoExportReqVO exportReqVO) {
        return otherCertificateInfoMapper.selectList(exportReqVO);
    }

}
