package cn.acsm.module.enterprise.service.otheraccountinfo;

import cn.acsm.module.enterprise.controller.admin.otheraccountinfo.vo.OtherAccountInfoCreateReqVO;
import cn.acsm.module.enterprise.controller.admin.otheraccountinfo.vo.OtherAccountInfoExportReqVO;
import cn.acsm.module.enterprise.controller.admin.otheraccountinfo.vo.OtherAccountInfoPageReqVO;
import cn.acsm.module.enterprise.controller.admin.otheraccountinfo.vo.OtherAccountInfoUpdateReqVO;
import cn.acsm.module.enterprise.convert.otheraccountinfo.OtherAccountInfoConvert;
import cn.acsm.module.enterprise.dal.dataobject.otheraccountinfo.OtherAccountInfoDO;
import cn.acsm.module.enterprise.dal.mysql.otheraccountinfo.OtherAccountInfoMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;


import static cn.acsm.module.enterprise.enums.ErrorCodeConstants.OTHER_ACCOUNT_INFO_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 经营主体其他账户 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class OtherAccountInfoServiceImpl implements OtherAccountInfoService {

    @Resource
    private OtherAccountInfoMapper otherAccountInfoMapper;

    @Override
    public Long createOtherAccountInfo(OtherAccountInfoCreateReqVO createReqVO) {
        // 插入
        OtherAccountInfoDO otherAccountInfo = OtherAccountInfoConvert.INSTANCE.convert(createReqVO);
        otherAccountInfoMapper.insert(otherAccountInfo);
        // 返回
        return otherAccountInfo.getId();
    }

    @Override
    public void updateOtherAccountInfo(OtherAccountInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateOtherAccountInfoExists(updateReqVO.getId());
        // 更新
        OtherAccountInfoDO updateObj = OtherAccountInfoConvert.INSTANCE.convert(updateReqVO);
        otherAccountInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteOtherAccountInfo(Long id) {
        // 校验存在
        this.validateOtherAccountInfoExists(id);
        // 删除
        otherAccountInfoMapper.deleteById(id);
    }

    private void validateOtherAccountInfoExists(Long id) {
        if (otherAccountInfoMapper.selectById(id) == null) {
            throw exception(OTHER_ACCOUNT_INFO_NOT_EXISTS);
        }
    }

    @Override
    public OtherAccountInfoDO getOtherAccountInfo(Long id) {
        return otherAccountInfoMapper.selectById(id);
    }

    @Override
    public List<OtherAccountInfoDO> getOtherAccountInfoList(Collection<Long> ids) {
        return otherAccountInfoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<OtherAccountInfoDO> getOtherAccountInfoPage(OtherAccountInfoPageReqVO pageReqVO) {
        return otherAccountInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<OtherAccountInfoDO> getOtherAccountInfoList(OtherAccountInfoExportReqVO exportReqVO) {
        return otherAccountInfoMapper.selectList(exportReqVO);
    }

}
