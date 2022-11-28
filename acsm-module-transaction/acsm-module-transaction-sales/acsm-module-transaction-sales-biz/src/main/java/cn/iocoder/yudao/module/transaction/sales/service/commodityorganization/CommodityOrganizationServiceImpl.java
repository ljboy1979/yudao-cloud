package cn.iocoder.yudao.module.transaction.sales.service.commodityorganization;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.rawmaterial.RawMaterialDO;
import cn.iocoder.yudao.module.transaction.sales.dal.mysql.rawmaterial.RawMaterialMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.commodityorganization.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.commodityorganization.CommodityOrganizationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.transaction.sales.convert.commodityorganization.CommodityOrganizationConvert;
import cn.iocoder.yudao.module.transaction.sales.dal.mysql.commodityorganization.CommodityOrganizationMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.transaction.sales.enums.ErrorCodeConstants.*;

/**
 * 商品组成 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class CommodityOrganizationServiceImpl implements CommodityOrganizationService {

    @Resource
    private CommodityOrganizationMapper commodityOrganizationMapper;
    @Resource
    private RawMaterialMapper rawMaterialMapper;

    @Override
    public CommonResult<String> createCommodityOrganization(CommodityOrganizationCreateReqVO createReqVO) {
        RawMaterialDO rawMaterialDO = rawMaterialMapper.selectById(createReqVO.getRawMaterialId());
        if (rawMaterialDO!=null){
            return CommonResult.error(RAW_MATERIAL_NOT_EXISTS);
        }
        // 插入
        CommodityOrganizationDO commodityOrganization = CommodityOrganizationConvert.INSTANCE.convert(createReqVO);
        commodityOrganizationMapper.insert(commodityOrganization);
        // 返回
        return CommonResult.success(commodityOrganization.getId());
    }

    @Override
    public void updateCommodityOrganization(CommodityOrganizationUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateCommodityOrganizationExists(updateReqVO.getId());
        // 更新
        CommodityOrganizationDO updateObj = CommodityOrganizationConvert.INSTANCE.convert(updateReqVO);
        commodityOrganizationMapper.updateById(updateObj);
    }

    @Override
    public void deleteCommodityOrganization(String id) {
        // 校验存在
        this.validateCommodityOrganizationExists(id);
        // 删除
        commodityOrganizationMapper.deleteById(id);
    }

    private void validateCommodityOrganizationExists(String id) {
        if (commodityOrganizationMapper.selectById(id) == null) {
            throw exception(COMMODITY_ORGANIZATION_NOT_EXISTS);
        }
    }

    @Override
    public CommodityOrganizationDO getCommodityOrganization(String id) {
        return commodityOrganizationMapper.selectById(id);
    }

    @Override
    public List<CommodityOrganizationDO> getCommodityOrganizationList(Collection<String> ids) {
        return commodityOrganizationMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<CommodityOrganizationDO> getCommodityOrganizationPage(CommodityOrganizationPageReqVO pageReqVO) {
        return commodityOrganizationMapper.selectPage(pageReqVO);
    }

    @Override
    public List<CommodityOrganizationDO> getCommodityOrganizationList(CommodityOrganizationExportReqVO exportReqVO) {
        return commodityOrganizationMapper.selectList(exportReqVO);
    }

}
