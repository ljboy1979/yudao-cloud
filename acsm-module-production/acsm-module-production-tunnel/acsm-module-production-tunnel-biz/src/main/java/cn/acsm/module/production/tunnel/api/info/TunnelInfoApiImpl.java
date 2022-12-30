package cn.acsm.module.production.tunnel.api.info;

import cn.acsm.module.production.tunnel.api.tunnel.TunnelInfoApi;
import cn.acsm.module.production.tunnel.api.tunnel.dto.InfoBaseDTO;
import cn.acsm.module.production.tunnel.convert.info.InfoConvert;
import cn.acsm.module.production.tunnel.dal.dataobject.info.InfoDO;
import cn.acsm.module.production.tunnel.service.info.InfoServiceImpl;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;

import javax.annotation.Resource;

public class TunnelInfoApiImpl implements TunnelInfoApi {

    @Resource
    private InfoServiceImpl infoService;

    @Override
    public CommonResult<InfoBaseDTO> getInfoById(Long id) {
        InfoDO info = infoService.getInfo(id);
        return CommonResult.success(InfoConvert.INSTANCE.convert01(info));
    }
}
