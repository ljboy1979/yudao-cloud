package cn.acsm.module.transaction.shelves.service.specifications;

import cn.acsm.module.transaction.pricetag.api.dto.MarketPriceDetailsDto;
import cn.acsm.module.transaction.pricetag.api.dto.MarketPriceDto;
import cn.acsm.module.transaction.pricetag.api.pricetag.MarketPriceApi;
import cn.acsm.module.transaction.shelves.controller.admin.shelves.vo.ShelvesUpdateReqVO;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.shelves.controller.admin.specifications.vo.*;
import cn.acsm.module.transaction.shelves.dal.dataobject.specifications.SpecificationsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.shelves.convert.specifications.SpecificationsConvert;
import cn.acsm.module.transaction.shelves.dal.mysql.specifications.SpecificationsMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.shelves.enums.ErrorCodeConstants.*;

/**
 * 货架规格 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class SpecificationsServiceImpl implements SpecificationsService {

    @Resource
    private SpecificationsMapper specificationsMapper;
    @Resource
    private MarketPriceApi marketPriceApi;


    @Override
    public String createSpecifications(SpecificationsCreateReqVO createReqVO) {
        // 插入
        SpecificationsDO specifications = SpecificationsConvert.INSTANCE.convert(createReqVO);
        specifications.setId(UUID.randomUUID().toString());

        specificationsMapper.insert(specifications);
        // 返回
        return specifications.getId();
    }

    @Override
    @Transactional
    public void updateSpecifications(SpecificationsUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateSpecificationsExists(updateReqVO.getId());
        // 更新
        SpecificationsDO updateObj = SpecificationsConvert.INSTANCE.convert(updateReqVO);
        specificationsMapper.updateById(updateObj);
        this.savePriceTag(updateReqVO);
    }

    private void savePriceTag(SpecificationsUpdateReqVO specificationsUpdateReqVO) {
        CommonResult<List<MarketPriceDto>> result =  marketPriceApi.getIdBySpecificationId(specificationsUpdateReqVO.getId());
        List<MarketPriceDto> priceDtos = result.getData();
        if (priceDtos!=null && priceDtos.size()!=0){
            priceDtos.stream().forEach(price->{
                MarketPriceDetailsDto marketPriceDetailsDto = new MarketPriceDetailsDto();
                marketPriceDetailsDto.setMarketPriceId(price.getPriceId());
                marketPriceDetailsDto.setPayer(String.valueOf(SecurityFrameworkUtils.getLoginUser().getTenantId()));
                marketPriceDetailsDto.setPrice(specificationsUpdateReqVO.getUnitPrice());
                marketPriceDetailsDto.setPriceSource("0");
                marketPriceApi.saveMarketPriceDetails(marketPriceDetailsDto);
            });
        }
    }

    @Override
    public void deleteSpecifications(String id) {
        // 校验存在
        this.validateSpecificationsExists(id);
        // 删除
        specificationsMapper.deleteById(id);
    }

    private void validateSpecificationsExists(String id) {
        if (specificationsMapper.selectById(id) == null) {
            throw exception(SPECIFICATIONS_NOT_EXISTS);
        }
    }

    @Override
    public SpecificationsDO getSpecifications(String id) {
        return specificationsMapper.selectById(id);
    }

    @Override
    public List<SpecificationsDO> getSpecificationsList(Collection<String> ids) {
        return specificationsMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<SpecificationsDO> getSpecificationsPage(SpecificationsPageReqVO pageReqVO) {
        return specificationsMapper.selectPage(pageReqVO);
    }

    @Override
    public List<SpecificationsDO> getSpecificationsList(SpecificationsExportReqVO exportReqVO) {
        return specificationsMapper.selectList(exportReqVO);
    }

}
