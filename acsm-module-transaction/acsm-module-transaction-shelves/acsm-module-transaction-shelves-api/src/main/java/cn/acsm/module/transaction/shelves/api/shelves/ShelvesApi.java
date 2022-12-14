package cn.acsm.module.transaction.shelves.api.shelves;

import cn.acsm.module.transaction.shelves.api.dto.ShelvesReqDto;
import cn.acsm.module.transaction.shelves.api.dto.TreeSelectDto;
import cn.acsm.module.transaction.shelves.enums.ApiConstants;
import cn.acsm.module.transaction.shelves.api.dto.ShelvesRespDto;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = ApiConstants.NAME,path = "sales/feign/shelves")
@Api(tags = "RPC 服务 - 价格牌相关接口")
public interface ShelvesApi {

    @PostMapping("findShelves")
    @ApiOperation("查询售品")
    CommonResult<List<ShelvesRespDto>> findShelvesList(@RequestBody ShelvesReqDto shelvesReqDto);

    @PostMapping("findSpecifications")
    @ApiOperation("查询售品规格")
    CommonResult<List<ShelvesRespDto>> findSpecificationsList(@RequestBody ShelvesReqDto shelvesReqDto);

    @PostMapping("treeList")
    @ApiOperation("查询售品")
    CommonResult<List<TreeSelectDto>> treeList(@RequestBody ShelvesReqDto shelvesReqDto);

}
