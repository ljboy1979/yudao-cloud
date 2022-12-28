package cn.acsm.module.transaction.pricetag.service.scheduledprice;

import cn.acsm.module.transaction.pricetag.dal.dataobject.marketclassify.MarketClassifyDO;
import cn.acsm.module.transaction.pricetag.dal.mysql.marketclassify.MarketClassifyMapper;
import cn.acsm.module.transaction.pricetag.util.ConfigNumberUtil;
import cn.acsm.module.transaction.shelves.api.dto.ShelvesReqDto;
import cn.acsm.module.transaction.shelves.api.dto.ShelvesRespDto;
import cn.acsm.module.transaction.shelves.api.shelves.ShelvesApi;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.pricetag.controller.admin.scheduledprice.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.scheduledprice.ScheduledPriceDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.pricetag.convert.scheduledprice.ScheduledPriceConvert;
import cn.acsm.module.transaction.pricetag.dal.mysql.scheduledprice.ScheduledPriceMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.pricetag.enums.ErrorCodeConstants.*;

/**
 * 预定价格 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ScheduledPriceServiceImpl implements ScheduledPriceService {

    @Resource
    private ScheduledPriceMapper scheduledPriceMapper;
    @Resource
    private ConfigNumberUtil configNumberUtil;
    @Resource
    private ShelvesApi shelvesApi;
    @Resource
    private MarketClassifyMapper marketClassifyMapper;
    @Override
    public String createScheduledPrice(ScheduledPriceCreateReqVO createReqVO) {
        Long tenantId = SecurityFrameworkUtils.getLoginUser().getTenantId();
        String number = configNumberUtil.getNumber("pricetag_scheduled_price"+tenantId);
        MarketClassifyDO marketClassifyDO = marketClassifyMapper.selectById(createReqVO.getClassifyId());
        ShelvesReqDto shelvesReqDto = new ShelvesReqDto();
        shelvesReqDto.setSpecificationsId(createReqVO.getSpecificationId());
        CommonResult<List<ShelvesRespDto>> result =  shelvesApi.findSpecificationsList(shelvesReqDto);
        List<ShelvesRespDto> shelvesRespDtos = result.getData();
        ShelvesRespDto shelvesRespDto =  shelvesRespDtos.get(0);

        // 插入
        ScheduledPriceDO scheduledPrice = ScheduledPriceConvert.INSTANCE.convert(createReqVO);
        scheduledPrice.setId(UUID.randomUUID().toString());
        scheduledPrice.setCommodityCode("YD"+number);
        scheduledPrice.setCategoryName(marketClassifyDO.getTreeNames());
        scheduledPrice.setPackagingType(shelvesRespDto.getPackagingType());
        scheduledPrice.setPackagingTypeName(shelvesRespDto.getPackagingTypeName());
        scheduledPrice.setNumber(shelvesRespDto.getNumber());
        scheduledPrice.setUnit(shelvesRespDto.getUnit());
        scheduledPrice.setUnitName(shelvesRespDto.getUnitName());
        scheduledPrice.setPackaging(shelvesRespDto.getPackaging());
        scheduledPrice.setPackagingName(shelvesRespDto.getPackagingName());
        scheduledPrice.setMeasurementUnit(shelvesRespDto.getMeasurementUnit());
        scheduledPrice.setMeasurementUnitName(shelvesRespDto.getMeasurementUnitName());
        scheduledPriceMapper.insert(scheduledPrice);
        // 返回
        return scheduledPrice.getId();
    }

    @Override
    public void updateScheduledPrice(ScheduledPriceUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateScheduledPriceExists(updateReqVO.getId());
        // 更新
        ScheduledPriceDO updateObj = ScheduledPriceConvert.INSTANCE.convert(updateReqVO);
        scheduledPriceMapper.updateById(updateObj);
    }

    @Override
    public void deleteScheduledPrice(String id) {
        // 校验存在
        this.validateScheduledPriceExists(id);
        // 删除
        scheduledPriceMapper.deleteById(id);
    }

    private void validateScheduledPriceExists(String id) {
        if (scheduledPriceMapper.selectById(id) == null) {
            throw exception(SCHEDULED_PRICE_NOT_EXISTS);
        }
    }

    @Override
    public ScheduledPriceDO getScheduledPrice(String id) {
        return scheduledPriceMapper.selectById(id);
    }

    @Override
    public List<ScheduledPriceDO> getScheduledPriceList(Collection<String> ids) {
        return scheduledPriceMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ScheduledPriceDO> getScheduledPricePage(ScheduledPricePageReqVO pageReqVO) {
        return scheduledPriceMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ScheduledPriceDO> getScheduledPriceList(ScheduledPriceExportReqVO exportReqVO) {
        return scheduledPriceMapper.selectList(exportReqVO);
    }

}
