package cn.iocoder.yudao.module.system.api.area;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.area.AreaTreeSelect;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.area.AreaTreeUtils;
import cn.iocoder.yudao.module.system.controller.admin.area.vo.AreaTreeVO;
import cn.iocoder.yudao.module.system.convert.area.AreaConvert;
import cn.iocoder.yudao.module.system.dal.dataobject.area.AreaDO;
import cn.iocoder.yudao.module.system.service.area.AreaService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.module.system.enums.ApiConstants.VERSION;

@RestController // 提供 RESTful API 接口，给 Feign 调用
@DubboService(version = VERSION) // 提供 Dubbo RPC 接口，给 Dubbo Consumer 调用
@Validated
public class AreaApiImpl implements AreaApi {

    @Resource
    private AreaService areaService;

    @Override
    public CommonResult< List< AreaTreeSelect > > tree() {
        List< AreaDO > areaList = areaService.getAreaTreeList();
        List< AreaTreeVO > areaTreeVos = areaList.stream().map(o -> AreaConvert.convertListToTree(o)).collect(Collectors.toList());
        List<AreaTreeSelect> treeSelects = AreaTreeUtils.
                buildTreeSelect(areaTreeVos);
        return success(treeSelects);
    }
}
