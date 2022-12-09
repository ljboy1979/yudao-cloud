package cn.acsm.module.service.service.serviceinfocarrier;

import cn.acsm.module.resource.api.adoptcontent.AdoptcontentApi;
import cn.acsm.module.resource.api.adoptcontent.dto.AdoptContentReqDTO;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.service.controller.admin.serviceinfocarrier.vo.*;
import cn.acsm.module.service.dal.dataobject.serviceinfocarrier.ServiceInfoCarrierDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.service.convert.serviceinfocarrier.ServiceInfoCarrierConvert;
import cn.acsm.module.service.dal.mysql.serviceinfocarrier.ServiceInfoCarrierMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.service.enums.ErrorCodeConstants.*;

/**
 * 服务-认养物/租凭物 Service 实现类
 *
 * @author smile
 */
@Service
@Validated
@Transactional(readOnly = false)
public class ServiceInfoCarrierServiceImpl implements ServiceInfoCarrierService {

    @Resource
    private ServiceInfoCarrierMapper infoCarrierMapper;
    @Resource
    private AdoptcontentApi adoptcontentApi;

    @Override
    public Long createInfoCarrier(ServiceInfoCarrierCreateReqVO createReqVO) {
        // 插入
        ServiceInfoCarrierDO infoCarrier = ServiceInfoCarrierConvert.INSTANCE.convert(createReqVO);
        infoCarrierMapper.insert(infoCarrier);
        // 返回
        return infoCarrier.getId();
    }

    @Override
    public void updateInfoCarrier(ServiceInfoCarrierUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateInfoCarrierExists(updateReqVO.getId());
        // 更新
        ServiceInfoCarrierDO updateObj = ServiceInfoCarrierConvert.INSTANCE.convert(updateReqVO);
        infoCarrierMapper.updateById(updateObj);
    }

    @Override
    public void deleteInfoCarrier(Long id) {
        // 校验存在
        this.validateInfoCarrierExists(id);
        // 删除
        infoCarrierMapper.deleteById(id);
    }

    private void validateInfoCarrierExists(Long id) {
        if (infoCarrierMapper.selectById(id) == null) {
            throw exception(INFO_CARRIER_NOT_EXISTS);
        }
    }

    @Override
    public ServiceInfoCarrierDO getInfoCarrier(Long id) {
        return infoCarrierMapper.selectById(id);
    }

    @Override
    public List<ServiceInfoCarrierDO> getInfoCarrierList(Collection<Long> ids) {
        return infoCarrierMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ServiceInfoCarrierRespVO> getInfoCarrierPage(ServiceInfoCarrierPageReqVO pageReqVO) {
        PageResult<ServiceInfoCarrierDO> page = infoCarrierMapper.selectPage(pageReqVO);
        PageResult<ServiceInfoCarrierRespVO> convertPage = ServiceInfoCarrierConvert.INSTANCE.convertPage(page);
        convertPage.getList().forEach((item)->{
            if(!StringUtils.isEmpty(item.getAdoptContentAdoptId())){
                CommonResult<AdoptContentReqDTO> adoptContentById = adoptcontentApi.getAdoptContentById(item.getAdoptContentAdoptId());
                item.setAdoptContent(adoptContentById.getData());
            }
        });
        return convertPage;
    }

    @Override
    public List<ServiceInfoCarrierDO> getInfoCarrierList(ServiceInfoCarrierExportReqVO exportReqVO) {
        return infoCarrierMapper.selectList(exportReqVO);
    }

}
