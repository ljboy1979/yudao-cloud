package cn.acsm.module.resource.service.adoptcontent;

import cn.acsm.module.resource.controller.admin.adoptcontent.vo.*;
import cn.acsm.module.resource.dal.mysql.adoptcontent.AdoptContentMapper;
import cn.acsm.module.resource.controller.admin.adoptcontent.vo.AdoptContentCreateReqVO;
import cn.acsm.module.resource.controller.admin.adoptcontent.vo.AdoptContentExportReqVO;
import cn.acsm.module.resource.controller.admin.adoptcontent.vo.AdoptContentPageReqVO;
import cn.acsm.module.resource.controller.admin.adoptcontent.vo.AdoptContentUpdateReqVO;
import cn.acsm.module.resource.convert.adoptcontent.AdoptContentConvert;
import cn.acsm.module.service.api.serviceinfo.ServiceInfoApi;
import cn.acsm.module.service.api.serviceinfo.dto.ServiceInfoRespDTO;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.resource.dal.dataobject.adoptcontent.AdoptContentDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.resource.enums.ErrorCodeConstants.*;

/**
 * 认养物/租凭物 Service 实现类
 *
 * @author smile
 */
@Service
@Validated
@Transactional(readOnly = false)
public class AdoptContentServiceImpl implements AdoptContentService {

    @Resource
    private AdoptContentMapper adoptContentMapper;
    @Resource
    private ServiceInfoApi serviceInfoApi;

    @Override
    public Long createAdoptContent(AdoptContentCreateReqVO createReqVO) {
        // 插入
        AdoptContentDO adoptContent = AdoptContentConvert.INSTANCE.convert(createReqVO);
        adoptContentMapper.insert(adoptContent);
        // 返回
        return adoptContent.getId();
    }

    @Override
    public void updateAdoptContent(AdoptContentUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateAdoptContentExists(updateReqVO.getId());
        // 更新
        AdoptContentDO updateObj = AdoptContentConvert.INSTANCE.convert(updateReqVO);
        adoptContentMapper.updateById(updateObj);
    }

    @Override
    public void deleteAdoptContent(Long id) {
        // 校验存在
        this.validateAdoptContentExists(id);
        // 删除
        adoptContentMapper.deleteById(id);
    }

    private void validateAdoptContentExists(Long id) {
        if (adoptContentMapper.selectById(id) == null) {
            throw exception(ADOPT_CONTENT_NOT_EXISTS);
        }
    }

    @Override
    public AdoptContentDO getAdoptContent(Long id) {
        return adoptContentMapper.selectById(id);
    }

    @Override
    public List<AdoptContentDO> getAdoptContentList(Collection<Long> ids) {
        return adoptContentMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<AdoptContentDO> getAdoptContentPage(AdoptContentPageReqVO pageReqVO) {
        return adoptContentMapper.selectPage(pageReqVO);
    }

    @Override
    public List<AdoptContentDO> getAdoptContentList(AdoptContentExportReqVO exportReqVO) {
        return adoptContentMapper.selectList(exportReqVO);
    }

    @Override
    public String importRY(List<AdoptContentExcelRYVO> list) {
        for (int i = 0; i < list.size(); i++) {
            AdoptContentDO adopt = new AdoptContentDO();
            adopt.setResourceType("1");
            adopt.setAdoptContentCode(list.get(i).getAdoptContentCode());
            adopt.setName(list.get(i).getName());
            adopt.setAdoptWay(list.get(i).getAdoptWay());
            adopt.setType(list.get(i).getType());
            adopt.setAdoptState(list.get(i).getAdoptState());
            //todo 关联地块、设施、个体、群体 等相关服务完善后再做逻辑
            adopt.setTunnelInfoId(null);
            adopt.setInduFacilityInfoId(null);
            adopt.setTunnelPlanterId(null);
            adopt.setGroupId(null);
            adopt.setIntroduce(list.get(i).getIntroduce());
            adoptContentMapper.insert(adopt);
        }
        return "导入认养物成功";
    }

    @Override
    public String importZP(List<AdoptContentExcelZPVO> list) {
        for (int i = 0; i < list.size(); i++) {
            AdoptContentDO adopt = new AdoptContentDO();
            adopt.setResourceType("2");
            adopt.setAdoptContentCode(list.get(i).getAdoptContentCode());
            adopt.setName(list.get(i).getName());
            adopt.setAdoptWay(list.get(i).getAdoptWay());
            adopt.setType(list.get(i).getType());
            adopt.setAdoptState(list.get(i).getAdoptState());
            //todo 关联地块、设施、个体、群体 等相关服务完善后再做逻辑
            adopt.setTunnelInfoId(null);
            adopt.setInduFacilityInfoId(null);
            adopt.setTunnelPlanterId(null);
            adopt.setGroupId(null);
            adopt.setIntroduce(list.get(i).getIntroduce());
            adoptContentMapper.insert(adopt);
        }
        return "导入租凭物成功";
    }

    @Override
    public List<AdoptContentRespVO> listAdoptService(String type, String serviceId) {
        QueryWrapper<AdoptContentDO> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(serviceId)) {
            CommonResult<ServiceInfoRespDTO> infoById = serviceInfoApi.getServiceInfoById(serviceId);
            ServiceInfoRespDTO data = infoById.getData();
            wrapper.notInSql("id", data.getCarrierId());
        }
        wrapper.eq("resource_type",type);
        List<AdoptContentDO> list = adoptContentMapper.selectList(wrapper);
        return AdoptContentConvert.INSTANCE.convertList(list);
    }

}
