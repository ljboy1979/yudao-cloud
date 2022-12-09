package cn.acsm.module.service.service.ticketpackage;

import cn.acsm.module.service.controller.admin.ticketdetail.vo.TicketDetailCreateReqVO;
import cn.acsm.module.service.dal.dataobject.ticketdetail.TicketDetailDO;
import cn.acsm.module.service.dal.mysql.ticketdetail.TicketDetailMapper;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.system.api.dict.DictDataApi;
import cn.iocoder.yudao.module.system.api.dict.dto.DictDataRespDTO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.service.controller.admin.ticketpackage.vo.*;
import cn.acsm.module.service.dal.dataobject.ticketpackage.TicketPackageDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.service.convert.ticketpackage.TicketPackageConvert;
import cn.acsm.module.service.dal.mysql.ticketpackage.TicketPackageMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.service.enums.ErrorCodeConstants.*;

/**
 * 套票 Service 实现类
 *
 * @author smile
 */
@Service
@Validated
@Transactional(readOnly = false)
public class TicketPackageServiceImpl implements TicketPackageService {

    @Resource
    private TicketPackageMapper ticketPackageMapper;
    @Resource
    private TicketDetailMapper ticketDetailMapper;
    @Resource
    private DictDataApi dictDataApi;

    @Override
    public Long createTicketPackage(TicketPackageCreateReqVO createReqVO) {
        // 插入
        TicketPackageDO ticketPackage = TicketPackageConvert.INSTANCE.convert(createReqVO);
        if(!StringUtils.isEmpty(ticketPackage.getCarrierId())&&ticketPackage.getCarrierId().charAt(ticketPackage.getCarrierId().length()-1) != ','){
            ticketPackage.setCarrierId(ticketPackage.getCarrierId() + ",");
        }
        ticketPackageMapper.insert(ticketPackage);

        if (createReqVO.getTicketDetailList() != null && createReqVO.getTicketDetailList().size() > 0) {
            //保存套票详情
            for(TicketDetailCreateReqVO t : createReqVO.getTicketDetailList()) {
                TicketDetailDO ticketDetail = new TicketDetailDO();
                ticketDetail.setTicketId(String.valueOf(ticketPackage.getId()));
                ticketDetail.setSkuId(t.getSkuId());
                ticketDetail.setUseNumber(t.getUseNumber());
                ticketDetail.setUseRate(t.getUseRate());
                ticketDetailMapper.insert(ticketDetail);
            }
        }
        // 返回
        return ticketPackage.getId();
    }

    @Override
    public void updateTicketPackage(TicketPackageUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateTicketPackageExists(updateReqVO.getId());
        // 更新
        TicketPackageDO updateObj = TicketPackageConvert.INSTANCE.convert(updateReqVO);
        if(!StringUtils.isEmpty(updateObj.getCarrierId())&&updateObj.getCarrierId().charAt(updateObj.getCarrierId().length()-1) != ','){
            updateObj.setCarrierId(updateObj.getCarrierId() + ",");
        }
        ticketPackageMapper.updateById(updateObj);
    }

    @Override
    public void deleteTicketPackage(Long id) {
        // 校验存在
        this.validateTicketPackageExists(id);
        // 删除
        ticketPackageMapper.deleteById(id);
    }

    private void validateTicketPackageExists(Long id) {
        if (ticketPackageMapper.selectById(id) == null) {
            throw exception(TICKET_PACKAGE_NOT_EXISTS);
        }
    }

    @Override
    public TicketPackageDO getTicketPackage(Long id) {
        return ticketPackageMapper.selectById(id);
    }

    @Override
    public List<TicketPackageDO> getTicketPackageList(Collection<Long> ids) {
        return ticketPackageMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<TicketPackageRespVO> getTicketPackagePage(TicketPackagePageReqVO pageReqVO) {
        PageResult<TicketPackageDO> page = ticketPackageMapper.selectPage(pageReqVO);
        PageResult<TicketPackageRespVO> convertPage = TicketPackageConvert.INSTANCE.convertPage(page);
        convertPage.getList().forEach(item->{
            CommonResult<DictDataRespDTO> dictDataId = null;
            if(!StringUtils.isEmpty(item.getPackageType())) {
                //调用字典查询
                dictDataId = dictDataApi.getDictDataId(Long.valueOf(item.getPackageType()));
            }
            item.setDictDataRespDTO(dictDataId!=null&&dictDataId.getData()!=null?dictDataId.getData():null);
        });
        return convertPage;
    }

    @Override
    public List<TicketPackageDO> getTicketPackageList(TicketPackageExportReqVO exportReqVO) {
        return ticketPackageMapper.selectList(exportReqVO);
    }

    @Override
    public String createTicketPackageService(TicketPackageUpdateReqVO createReqVO) {
        if(StringUtils.isEmpty(String.valueOf(createReqVO.getId()))){
            return "缺少套票id参数";
        }

        QueryWrapper<TicketPackageDO> wrapper = new QueryWrapper<>();
        wrapper.eq("id",createReqVO.getId());
        TicketPackageDO ticketPackageDO = ticketPackageMapper.selectOne(wrapper);
        //拿到关联的服务
        String serviceId=ticketPackageDO.getCarrierId();
        if(!StringUtils.isEmpty(serviceId)&&serviceId.charAt(serviceId.length()-1) != ','){
            serviceId=serviceId + ",";
        }
        String s = serviceId + createReqVO.getCarrierId()+",";

        TicketPackageDO aDo = new TicketPackageDO();
        aDo.setId(createReqVO.getId());
        aDo.setCarrierId(StringUtils.isEmpty(serviceId)?createReqVO.getCarrierId()+",":s);
        ticketPackageMapper.updateById(aDo);
        return "保存套票关联服务成功";
    }

    @Override
    public String deleteTicketPackageService(TicketPackageUpdateReqVO reqVO) {
        if(StringUtils.isEmpty(String.valueOf(reqVO.getId()))){
            return "缺少套票id参数";
        }
        if(!StringUtils.isEmpty(reqVO.getCarrierId())&&reqVO.getCarrierId().charAt(reqVO.getCarrierId().length()-1) != ','){
            reqVO.setCarrierId(reqVO.getCarrierId() + ",");
        }
        ticketPackageMapper.deleteTicketPackageService(reqVO);
        return "删除套票关联服务id:"+reqVO.getCarrierId()+"成功";
    }

}
