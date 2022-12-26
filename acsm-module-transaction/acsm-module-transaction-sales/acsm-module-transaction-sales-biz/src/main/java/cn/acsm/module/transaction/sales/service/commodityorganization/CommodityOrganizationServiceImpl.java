package cn.acsm.module.transaction.sales.service.commodityorganization;

import cn.acsm.module.transaction.sales.controller.admin.commodityorganization.vo.CommodityOrganizationCreateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodityorganization.vo.CommodityOrganizationExportReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodityorganization.vo.CommodityOrganizationPageReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodityorganization.vo.CommodityOrganizationUpdateReqVO;
import cn.acsm.module.transaction.sales.convert.commodityorganization.CommodityOrganizationConvert;
import cn.acsm.module.transaction.sales.dal.dataobject.commodityorganization.CommodityOrganizationDO;
import cn.acsm.module.transaction.sales.dal.dataobject.rawmaterial.RawMaterialDO;
import cn.acsm.module.transaction.sales.dal.mysql.commodityorganization.CommodityOrganizationMapper;
import cn.acsm.module.transaction.sales.dal.mysql.rawmaterial.RawMaterialMapper;
import cn.acsm.module.transaction.sales.enums.ErrorCodeConstants;
import cn.acsm.module.transaction.sales.util.ConfigNumberUtil;
import cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.acsm.module.transaction.sales.dal.dataobject.rawmaterial.RawMaterialDO;
import cn.acsm.module.transaction.sales.dal.mysql.rawmaterial.RawMaterialMapper;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.sales.controller.admin.commodityorganization.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.commodityorganization.CommodityOrganizationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.sales.convert.commodityorganization.CommodityOrganizationConvert;
import cn.acsm.module.transaction.sales.dal.mysql.commodityorganization.CommodityOrganizationMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.*;

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
    @Resource
    private ConfigNumberUtil configNumberUtil;

    /**
     * 新增商品组成
     * @param createReqVO 创建信息
     * @return
     */
    @Override
    public CommonResult<String> createCommodityOrganization(CommodityOrganizationCreateReqVO createReqVO) {

        //商品组成验重
        CommodityOrganizationDO commodityOrganizationDO = new CommodityOrganizationDO();
        commodityOrganizationDO.setCommodityId(createReqVO.getCommodityId());
        if ("0".equals(createReqVO.getTag())) {
            commodityOrganizationDO.setRawMaterialId(createReqVO.getRawMaterialId());
        }
        if ("1".equals(createReqVO.getTag())) {
            commodityOrganizationDO.setOrganizationName(createReqVO.getOrganizationName());
        }
        Long num =  commodityOrganizationMapper.findSelectCount(commodityOrganizationDO);
        if (num!=null && num>0){
            return CommonResult.error(ErrorCodeConstants.COMMODITY_ORGANIZATION_EXISTENCE);
        }

        if ("0".equals(createReqVO.getTag())){//原料新增
            //判断原料是否存在
            RawMaterialDO rawMaterialDO = rawMaterialMapper.selectById(createReqVO.getRawMaterialId());
            if (rawMaterialDO==null){
                return CommonResult.error(ErrorCodeConstants.RAW_MATERIAL_NOT_EXISTS);
            }
            createReqVO.setOrigin(rawMaterialDO.getOrigin());
            createReqVO.setClassify(rawMaterialDO.getClassify());
            createReqVO.setOrganizationName(rawMaterialDO.getName());
        }

        Long tenantId = SecurityFrameworkUtils.getLoginUser().getTenantId();

        String number = configNumberUtil.getNumber("sales_commodity_organization"+tenantId);
        // 插入
        CommodityOrganizationDO commodityOrganization = CommodityOrganizationConvert.INSTANCE.convert(createReqVO);
        commodityOrganization.setOrganizationNumber("ZC"+number);
        commodityOrganization.setId(UUID.randomUUID().toString());
        commodityOrganizationMapper.insert(commodityOrganization);
        // 返回
        return CommonResult.success(commodityOrganization.getId());
    }

    @Override
    public CommonResult<String> updateCommodityOrganization(CommodityOrganizationUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateCommodityOrganizationExists(updateReqVO.getId());

        //商品组成验重
        CommodityOrganizationDO commodityOrganizationDO = new CommodityOrganizationDO();
        commodityOrganizationDO.setId(updateReqVO.getId());
        commodityOrganizationDO.setCommodityId(updateReqVO.getCommodityId());
        if (StringUtils.isNotEmpty(updateReqVO.getRawMaterialId())) {
            commodityOrganizationDO.setRawMaterialId(updateReqVO.getRawMaterialId());
        }
        if (StringUtils.isEmpty(updateReqVO.getRawMaterialId())) {
            commodityOrganizationDO.setOrganizationName(updateReqVO.getOrganizationName());
        }
        Long num =  commodityOrganizationMapper.findSelectCount(commodityOrganizationDO);
        if (num!=null && num>0){
            return CommonResult.error(ErrorCodeConstants.COMMODITY_ORGANIZATION_EXISTENCE);
        }

        // 更新
        CommodityOrganizationDO updateObj = CommodityOrganizationConvert.INSTANCE.convert(updateReqVO);
        commodityOrganizationMapper.updateById(updateObj);
        return CommonResult.success("修改成功");

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
            throw ServiceExceptionUtil.exception(ErrorCodeConstants.COMMODITY_ORGANIZATION_NOT_EXISTS);
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
