package cn.acsm.module.transaction.shelves.controller.feign;

import cn.acsm.module.transaction.shelves.api.dto.ShelvesReqDto;
import cn.acsm.module.transaction.shelves.api.dto.ShelvesRespDto;
import cn.acsm.module.transaction.shelves.api.dto.TreeSelectDto;
import cn.acsm.module.transaction.shelves.convert.stockclassify.StockClassifyConvert;
import cn.acsm.module.transaction.shelves.service.shelves.ShelvesService;
import cn.acsm.module.transaction.shelves.service.stockclassify.StockClassifyService;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeSelect;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;


@RestController
@RequestMapping(value = "sales/feign/shelves")
@Api(value = "ShelvesApiController", description = "(货架)FeignController")
public class ShelvesApiController {

    @Resource
    private ShelvesService shelvesService;
    @Resource
    private StockClassifyService stockClassifyService;

    @PostMapping("/findShelves")
    @ApiOperation("查询货架")
    public CommonResult<List<ShelvesRespDto>> findShelvesList(@RequestBody ShelvesReqDto shelvesReqDto) {
       List<ShelvesRespDto> shelvesRespDtos = shelvesService.findShelvesList(shelvesReqDto);
        return CommonResult.success(shelvesRespDtos);
    }

    @PostMapping("/findSpecifications")
    @ApiOperation("查询货架规格")
    public CommonResult<List<ShelvesRespDto>> findSpecificationsList(@RequestBody ShelvesReqDto shelvesReqDto) {
        List<ShelvesRespDto> shelvesRespDtos = shelvesService.findSpecificationsList(shelvesReqDto);
        return CommonResult.success(shelvesRespDtos);
    }

    @PostMapping("/treeList")
    @ApiOperation("树形分类列表")
    @Cacheable(value = "/shelves/stock-classify/treeList",key = "#stockClassifyTreeVO.classifyName")
    public CommonResult<List<TreeSelectDto>> treeList(@Valid ShelvesReqDto shelvesReqDto) {
        List<TreeSelect> list = stockClassifyService.findTreeList(null);
        List<TreeSelectDto > treeSelectDtos = list.stream().map(o -> StockClassifyConvert.convertListToTreeDto(o)).collect(Collectors.toList());
        return success(treeSelectDtos);
    }
}
