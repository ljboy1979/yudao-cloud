package cn.acsm.module.service.service.serviceinfo;

import cn.acsm.module.resource.api.adoptcontent.AdoptcontentApi;
import cn.acsm.module.resource.api.adoptcontent.dto.AdoptContentReqDTO;
import cn.acsm.module.service.dal.dataobject.serviceadoptinfo.ServiceAdoptInfoDO;
import cn.acsm.module.service.dal.dataobject.serviceinfocarrier.ServiceInfoCarrierDO;
import cn.acsm.module.service.dal.mysql.serviceadoptinfo.ServiceAdoptInfoMapper;
import cn.acsm.module.service.dal.mysql.serviceinfocarrier.ServiceInfoCarrierMapper;
import cn.acsm.module.service.utils.ConfigNumberUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.dict.core.util.DictFrameworkUtils;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import cn.iocoder.yudao.module.system.api.dict.DictDataApi;
import cn.iocoder.yudao.module.system.api.dict.dto.DictDataRespDTO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.text.SimpleDateFormat;
import java.util.*;
import cn.acsm.module.service.controller.admin.serviceinfo.vo.*;
import cn.acsm.module.service.dal.dataobject.serviceinfo.ServiceInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.service.convert.serviceinfo.ServiceInfoConvert;
import cn.acsm.module.service.dal.mysql.serviceinfo.ServiceInfoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.service.enums.ErrorCodeConstants.*;

/**
 * 服务 Service 实现类
 *
 * @author smile
 */
@Service
@Validated
@Transactional(readOnly = false)
public class ServiceInfoServiceImpl implements ServiceInfoService {

    @Resource
    private ServiceInfoMapper infoMapper;
    @Resource
    private ServiceAdoptInfoMapper serviceAdoptInfoMapper;
    @Resource
    private ServiceInfoCarrierMapper serviceInfoCarrierMapper;
    @Resource
    private DictDataApi dictDataApi;
    @Resource
    private AdoptcontentApi adoptcontentApi;

    @Override
    public Long createInfo(ServiceInfoCreateReqVO createReqVO) {
        if(createReqVO.getChildrenTableName()==null) {
            createReqVO.setChildrenTableName(createReqVO.getServiceType());
        }
        if(createReqVO.getAdoptContentIds()!=null){
            createReqVO.setCarrierId(createReqVO.getAdoptContentIds());
        }
        Long tenantId = Objects.requireNonNull(SecurityFrameworkUtils.getLoginUser()).getTenantId();
        //String service_service_info = configNumberUtil.getNumber("service_service_info"+tenantId);
        String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        createReqVO.setServiceCode(format+"-"+tenantId);
        // 插入
        ServiceInfoDO info = ServiceInfoConvert.INSTANCE.convert(createReqVO);
        infoMapper.insert(info);
        // 插入新认养记录表
        //调用字典查询
        CommonResult<DictDataRespDTO> dictDataId = dictDataApi.getDictDataId(Long.valueOf(createReqVO.getServiceType()));
        DictDataRespDTO data = dictDataId.getData();
        if(!StringUtils.isEmpty(createReqVO.getCarrierId())&&data!=null&&data.getLabel().contains("认购")){
            String[] adoptIds = createReqVO.getCarrierId().split(",");
            for (String t : adoptIds) {
                // 根据认养物保存认养物认购表
                ServiceAdoptInfoDO serviceAdoptInfoDO = new ServiceAdoptInfoDO();
                //todo adoptIds拿到认养id 查询认养关联的地块 取地块id区域id
                //select
                String tunnelInfo="查询地块";
                if(tunnelInfo!=null){
                    //区域id
                    serviceAdoptInfoDO.setPartitionsId(null);
                    //地块id
                    serviceAdoptInfoDO.setTunnelId(null);
                }
                serviceAdoptInfoDO.setServiceId(String.valueOf(info.getId()));
                serviceAdoptInfoDO.setAdoptId(t);
                serviceAdoptInfoDO.setApplySubNum("0");
                serviceAdoptInfoDO.setAdoptType(data.getLabel().contains("牧场")?"1":"0");
                serviceAdoptInfoDO.setApplyNum(!StringUtils.isEmpty(createReqVO.getMaxAttendPeople())?createReqVO.getMaxAttendPeople():"1");
                serviceAdoptInfoMapper.insert(serviceAdoptInfoDO);

                //保存服务-认养物/租凭物表
                ServiceInfoCarrierDO serviceInfoCarrierDO = new ServiceInfoCarrierDO();
                serviceInfoCarrierDO.setServiceInfoId(String.valueOf(info.getId()));
                serviceInfoCarrierDO.setAdoptContentAdoptId(t);
                serviceInfoCarrierMapper.insert(serviceInfoCarrierDO);
            }
        }
        // 返回
        return info.getId();
    }

    @Override
    public void updateInfo(ServiceInfoUpdateReqVO updateReqVO) {
        if(updateReqVO.getChildrenTableName()==null) {
            updateReqVO.setChildrenTableName(updateReqVO.getServiceType());
        }
        if(updateReqVO.getAdoptContentIds()!=null){
            updateReqVO.setCarrierId(updateReqVO.getAdoptContentIds());
        }
        // 校验存在
        this.validateInfoExists(updateReqVO.getId());
        // 更新
        ServiceInfoDO updateObj = ServiceInfoConvert.INSTANCE.convert(updateReqVO);
        infoMapper.updateById(updateObj);
        //调用字典查询
        CommonResult<DictDataRespDTO> dictDataId = dictDataApi.getDictDataId(Long.valueOf(updateReqVO.getServiceType()));
        DictDataRespDTO data = dictDataId.getData();
        if(!StringUtils.isEmpty(updateReqVO.getCarrierId())&&data!=null&&data.getLabel().contains("认购")){
            String[] adoptIds = updateReqVO.getCarrierId().split(",");
            //先删除后保存
            QueryWrapper<ServiceAdoptInfoDO> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("service_id",updateObj.getId());
            serviceAdoptInfoMapper.delete(wrapper1);
            //先删除后保存
            QueryWrapper<ServiceInfoCarrierDO> wrapper = new QueryWrapper<>();
            wrapper.eq("service_info_id",updateObj.getId());
            serviceInfoCarrierMapper.delete(wrapper);
            for (String t : adoptIds) {
                // 根据认养物保存认养物认购表
                ServiceAdoptInfoDO serviceAdoptInfoDO = new ServiceAdoptInfoDO();
                //todo adoptIds拿到认养id 查询认养关联的地块 取地块id区域id
                //select
                String tunnelInfo="查询地块";
                if(tunnelInfo!=null){
                    //区域id
                    serviceAdoptInfoDO.setPartitionsId(null);
                    //地块id
                    serviceAdoptInfoDO.setTunnelId(null);
                }
                serviceAdoptInfoDO.setServiceId(String.valueOf(updateObj.getId()));
                serviceAdoptInfoDO.setAdoptId(t);
                serviceAdoptInfoDO.setApplySubNum("0");
                serviceAdoptInfoDO.setAdoptType(data.getLabel().contains("牧场")?"1":"0");
                serviceAdoptInfoDO.setApplyNum(!StringUtils.isEmpty(updateReqVO.getMaxAttendPeople())?updateReqVO.getMaxAttendPeople():"1");
                serviceAdoptInfoMapper.insert(serviceAdoptInfoDO);


                //保存服务-认养物/租凭物表
                ServiceInfoCarrierDO serviceInfoCarrierDO = new ServiceInfoCarrierDO();
                serviceInfoCarrierDO.setServiceInfoId(String.valueOf(updateObj.getId()));
                serviceInfoCarrierDO.setAdoptContentAdoptId(t);
                serviceInfoCarrierMapper.insert(serviceInfoCarrierDO);
            }
        }
    }

    @Override
    public void deleteInfo(Long id) {
        // 校验存在
        this.validateInfoExists(id);
        // 删除
        infoMapper.deleteById(id);
    }

    private void validateInfoExists(Long id) {
        if (infoMapper.selectById(id) == null) {
            throw exception(INFO_NOT_EXISTS);
        }
    }

    @Override
    public ServiceInfoRespVO getInfo(Long id) {
        ServiceInfoDO infoDO = infoMapper.selectById(id);
        ServiceInfoRespVO convert = ServiceInfoConvert.INSTANCE.convert(infoDO);
        //认养/租赁名称
        if(!StringUtils.isEmpty(convert.getCarrierId())){
            CommonResult<List<AdoptContentReqDTO>> adoptContentList = adoptcontentApi.getAdoptContentList(convert.getCarrierId());
            List<String> stringNameList = new ArrayList<>();
            if(adoptContentList.getData().size()>0) {
                for (AdoptContentReqDTO a : adoptContentList.getData()) {
                    stringNameList.add(a.getName());
                }
            }
            convert.setCarrierNames(stringNameList.size()>0?StringUtils.join(stringNameList.toArray(),","):"");
        }
        return convert;
    }

    @Override
    public List<ServiceInfoDO> getInfoList(Collection<Long> ids) {
        return infoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ServiceInfoRespVO> getInfoPage(ServiceInfoPageReqVO pageReqVO) {
        String serviceIds=pageReqVO.getServiceIds();
        //serviceIds 查询套票关联的服务
        if(!StringUtils.isEmpty(serviceIds)&&pageReqVO.getServiceIds().charAt(pageReqVO.getServiceIds().length()-1) == ','){
            serviceIds = pageReqVO.getServiceIds().substring(0, pageReqVO.getServiceIds().length()-1);
            pageReqVO.setServiceIds(serviceIds);
        }
        PageResult<ServiceInfoDO> page = infoMapper.selectPage(pageReqVO);
        PageResult<ServiceInfoRespVO> convertPage = ServiceInfoConvert.INSTANCE.convertPage(page);
        convertPage.getList().forEach((item)->{
            if(!StringUtils.isEmpty(item.getServiceType())) {
                //调用字典查询
                CommonResult<DictDataRespDTO> dictDataId = dictDataApi.getDictDataId(Long.valueOf(item.getServiceType()));
                DictDataRespDTO data = dictDataId.getData();
                item.setDictDataRespDTO(data);
            }
        });
        return convertPage;
    }

    @Override
    public List<ServiceInfoDO> getInfoList(ServiceInfoExportReqVO exportReqVO) {
        return infoMapper.selectList(exportReqVO);
    }

}
