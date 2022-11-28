package cn.acsm.module.enterprise.service.baseinfo;

import cn.acsm.module.enterprise.controller.admin.baseinfo.vo.BaseInfoCreateReqVO;
import cn.acsm.module.enterprise.controller.admin.baseinfo.vo.BaseInfoExportReqVO;
import cn.acsm.module.enterprise.controller.admin.baseinfo.vo.BaseInfoPageReqVO;
import cn.acsm.module.enterprise.controller.admin.baseinfo.vo.BaseInfoUpdateReqVO;
import cn.acsm.module.enterprise.convert.baseinfo.BaseInfoConvert;
import cn.acsm.module.enterprise.dal.dataobject.baseinfo.BaseInfoDO;
import cn.acsm.module.enterprise.dal.mysql.baseinfo.BaseInfoMapper;
import cn.acsm.module.enterprise.enums.enterprisebaseinfo.EnterpriseStatusEnum;
import cn.acsm.module.enterprise.utils.generator.EnterpriseCodeGenerator;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.enterprise.enums.ErrorCodeConstants.BASE_INFO_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 经营主体 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class BaseInfoServiceImpl implements BaseInfoService {

    @Resource
    private BaseInfoMapper baseInfoMapper;
    @Resource
    private EnterpriseCodeGenerator enterpriseCodeGenerator;

    @Override
    public Long createBaseInfo(BaseInfoCreateReqVO createReqVO) {
        // 插入
        BaseInfoDO baseInfo = BaseInfoConvert.INSTANCE.convert(createReqVO);
        String code = enterpriseCodeGenerator.generate();
        baseInfo.setCode(code);
        baseInfoMapper.insert(baseInfo);
        // 返回
        return baseInfo.getId();
    }

    @Override
    public void updateBaseInfo(BaseInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateBaseInfoExists(updateReqVO.getId());
        // 更新
        BaseInfoDO updateObj = BaseInfoConvert.INSTANCE.convert(updateReqVO);
        baseInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteBaseInfo(Long id) {
        // 校验存在
        this.validateBaseInfoExists(id);
        // 删除
        baseInfoMapper.deleteById(id);
    }

    @Override
    public void changeStatus(Long id) {
        BaseInfoDO baseInfoDO = baseInfoMapper.selectById(id);
        if(EnterpriseStatusEnum.UNUSED.getStatus().equals(baseInfoDO.getStauts())){
            baseInfoDO.setStauts(EnterpriseStatusEnum.NORMAL.getStatus());
        }else if(EnterpriseStatusEnum.NORMAL.getStatus().equals(baseInfoDO.getStauts())){
            baseInfoDO.setStauts(EnterpriseStatusEnum.UNUSED.getStatus());
        }
        baseInfoMapper.updateById(baseInfoDO);
    }

    private void validateBaseInfoExists(Long id) {
        if (baseInfoMapper.selectById(id) == null) {
            throw exception(BASE_INFO_NOT_EXISTS);
        }
    }

    @Override
    public BaseInfoDO getBaseInfo(Long id) {
        return baseInfoMapper.selectById(id);
    }

    @Override
    public List<BaseInfoDO> getBaseInfoList(Collection<Long> ids) {
        return baseInfoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<BaseInfoDO> getBaseInfoPage(BaseInfoPageReqVO pageReqVO) {
        return baseInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<BaseInfoDO> getBaseInfoList(BaseInfoExportReqVO exportReqVO) {
        return baseInfoMapper.selectList(exportReqVO);
    }

}
