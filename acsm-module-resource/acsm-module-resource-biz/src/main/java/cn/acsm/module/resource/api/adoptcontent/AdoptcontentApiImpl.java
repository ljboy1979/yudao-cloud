package cn.acsm.module.resource.api.adoptcontent;

import cn.acsm.module.resource.api.adoptcontent.dto.AdoptContentReqDTO;
import cn.acsm.module.resource.controller.admin.adoptcontent.vo.AdoptContentExportReqVO;
import cn.acsm.module.resource.controller.admin.adoptcontent.vo.AdoptContentRespVO;
import cn.acsm.module.resource.convert.adoptcontent.AdoptContentConvert;
import cn.acsm.module.resource.dal.dataobject.adoptcontent.AdoptContentDO;
import cn.acsm.module.resource.dal.mysql.adoptcontent.AdoptContentMapper;
import cn.acsm.module.resource.service.adoptcontent.AdoptContentService;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static cn.acsm.module.resource.enums.ApiConstants.VERSION;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * chenkun 2022/12/9
 */
@RestController // 提供 RESTful API 接口，给 Feign 调用
@DubboService(version = VERSION) // 提供 Dubbo RPC 接口，给 Dubbo Consumer 调用
@Validated
public class AdoptcontentApiImpl implements AdoptcontentApi{

    @Resource
    private AdoptContentService adoptContentService;

    @Override
    public CommonResult<AdoptContentReqDTO> getAdoptContentById(String id) {
        AdoptContentDO adoptContentDO = adoptContentService.getAdoptContent(Long.valueOf(id));
        return success(AdoptContentConvert.INSTANCE.convert01(adoptContentDO));
    }

    @Override
    public CommonResult<List<AdoptContentReqDTO>> getAdoptContentList(String id) {
        AdoptContentExportReqVO reqVO = new AdoptContentExportReqVO();
        reqVO.setAdoptIds(id);
        List<AdoptContentDO> dos = adoptContentService.getAdoptContentList(reqVO);
        return success(AdoptContentConvert.INSTANCE.convertList01(dos));
    }
}
