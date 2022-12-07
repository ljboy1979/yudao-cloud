package cn.acsm.module.transaction.shelves.controller.feign;

import cn.acsm.module.transaction.shelves.api.dto.PriceTagShelvesReqDto;
import cn.acsm.module.transaction.shelves.api.dto.PriceTagShelvesRespDto;
import cn.acsm.module.transaction.shelves.api.dto.TreeSelectDto;
import cn.acsm.module.transaction.shelves.api.shelves.PriceTagApi;
import cn.acsm.module.transaction.shelves.controller.admin.stockclassify.vo.StockClassifyTreeVO;
import cn.acsm.module.transaction.shelves.convert.stockclassify.StockClassifyConvert;
import cn.acsm.module.transaction.shelves.service.shelves.ShelvesService;
import cn.acsm.module.transaction.shelves.service.stockclassify.StockClassifyService;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeSelect;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping(value = "sales/feign/pricetag")
@Api(value = "PriceTagApiController", description = "(价格牌)FeignController")
public class PriceTagApiController {

    @Resource
    private ShelvesService shelvesService;
    @Resource
    private StockClassifyService stockClassifyService;

    @PostMapping("/findPriceTagShelves")
    @ApiOperation("查询货架")
    public CommonResult<List<PriceTagShelvesRespDto>> findPriceTagShelves(@RequestBody PriceTagShelvesReqDto shelvesReqDto) {
       List<PriceTagShelvesRespDto> shelvesRespDtos = shelvesService.findPriceTagShelves(shelvesReqDto);
        return CommonResult.success(shelvesRespDtos);
    }

    @PostMapping("/findSpecifications")
    @ApiOperation("查询货架规格")
    public CommonResult<List<PriceTagShelvesRespDto>> findPriceTagSpecifications(@RequestBody PriceTagShelvesReqDto shelvesReqDto) {
        List<PriceTagShelvesRespDto> shelvesRespDtos = shelvesService.findPriceTagSpecifications(shelvesReqDto);
        return CommonResult.success(shelvesRespDtos);
    }

    @PostMapping("/treeList")
    @ApiOperation("树形分类列表")
    @Cacheable(value = "/shelves/stock-classify/treeList",key = "#stockClassifyTreeVO.classifyName")
    public CommonResult<List<TreeSelectDto>> treeList(@Valid PriceTagShelvesReqDto shelvesReqDto) {
        List<TreeSelect> list = stockClassifyService.findTreeList(null);
        List<TreeSelectDto > treeSelectDtos = list.stream().map(o -> StockClassifyConvert.convertListToTreeDto(o)).collect(Collectors.toList());
        return success(treeSelectDtos);
    }
}
