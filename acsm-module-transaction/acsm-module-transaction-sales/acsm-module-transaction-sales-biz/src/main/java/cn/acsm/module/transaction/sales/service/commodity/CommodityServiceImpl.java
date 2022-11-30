package cn.acsm.module.transaction.sales.service.commodity;

import cn.acsm.module.transaction.sales.enums.ErrorCodeConstants;
import cn.acsm.module.transaction.sales.service.commodity.CommodityService;
import cn.acsm.module.transaction.sales.util.ConfigNumberUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.commodity.CommodityDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.sales.convert.commodity.CommodityConvert;
import cn.acsm.module.transaction.sales.dal.mysql.commodity.CommodityMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.COMMODITY_NOT_EXISTS;

/**
 * 商品 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class CommodityServiceImpl implements CommodityService {

    @Resource
    private CommodityMapper commodityMapper;
    @Resource
    private ConfigNumberUtil configNumberUtil;
    @Override
    public CommonResult<String> createCommodity(CommodityCreateReqVO createReqVO) {
        CommodityDO reqVO = new CommodityDO();
        reqVO.setCommodityCategoryId(createReqVO.getCommodityCategoryId());
        reqVO.setCommodityName(createReqVO.getCommodityName());
        Long num = commodityMapper.findSelectCount(reqVO);
        if (num!=null && num>0){
            return CommonResult.error(ErrorCodeConstants.COMMODITY_EXISTENCE);
        }
        Long tenantId = SecurityFrameworkUtils.getLoginUser().getTenantId();
        String number = configNumberUtil.getNumber("sales_commodity"+tenantId);
        // 插入
        CommodityDO commodity = CommodityConvert.INSTANCE.convert(createReqVO);
        commodity.setCommodityCode("SP"+number);
        commodity.setId(UUID.randomUUID().toString());
        //commodity.setTenantId(tenantId);
        commodityMapper.insert(commodity);
        // 返回
        return  CommonResult.success(commodity.getId());
    }

    @Override
    public CommonResult<String> updateCommodity(CommodityUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateCommodityExists(updateReqVO.getId());

        CommodityDO commodityDO = new CommodityDO();
        commodityDO.setId(updateReqVO.getId());
        commodityDO.setCommodityCategoryId(updateReqVO.getCommodityCategoryId());
        commodityDO.setCommodityName(updateReqVO.getCommodityName());
        Long num = commodityMapper.findSelectCount(commodityDO);
        if (num!=null && num>0){
            return CommonResult.error(ErrorCodeConstants.COMMODITY_EXISTENCE);
        }
        // 更新
        CommodityDO updateObj = CommodityConvert.INSTANCE.convert(updateReqVO);
        commodityMapper.updateById(updateObj);
        return CommonResult.success("修改成功");

    }

    @Override
    public void deleteCommodity(String id) {
        // 校验存在
        this.validateCommodityExists(id);
        // 删除
        commodityMapper.deleteById(id);
    }

    private void validateCommodityExists(String id) {
        if (commodityMapper.selectById(id) == null) {
            throw exception(COMMODITY_NOT_EXISTS);
        }
    }

    @Override
    public CommodityDO getCommodity(String id) {
        return commodityMapper.selectById(id);
    }

    @Override
    public List<CommodityDO> getCommodityList(Collection<String> ids) {
        return commodityMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<CommodityDO> getCommodityPage(CommodityPageReqVO pageReqVO) {
        return commodityMapper.selectPage(pageReqVO);
    }

    @Override
    public List<CommodityDO> getCommodityList(CommodityExportReqVO exportReqVO) {
        return commodityMapper.selectList(exportReqVO);
    }

}
