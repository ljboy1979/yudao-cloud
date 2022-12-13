package cn.acsm.module.transaction.order.service.orderinfo;

import cn.acsm.module.transaction.order.controller.admin.orderdetail.vo.OrderDetailCreateReqVO;
import cn.acsm.module.transaction.order.dal.mysql.orderdetail.OrderDetailMapper;
import cn.acsm.module.transaction.order.enums.RedisDelayQueueEnum;
import cn.acsm.module.transaction.order.service.orderdetail.OrderDetailService;
import cn.acsm.module.transaction.order.util.ConfigNumberUtil;
import cn.acsm.module.transaction.order.util.RedisDelayQueueUtil;
import cn.acsm.module.transaction.pricetag.api.dto.MarketPriceDetailsDto;
import cn.acsm.module.transaction.pricetag.api.dto.MarketPriceDto;
import cn.acsm.module.transaction.pricetag.api.pricetag.MarketPriceApi;
import cn.acsm.module.transaction.shelves.api.dto.ShelvesReqDto;
import cn.acsm.module.transaction.shelves.api.dto.ShelvesRespDto;
import cn.acsm.module.transaction.shelves.api.dto.TreeSelectDto;
import cn.acsm.module.transaction.shelves.api.shelves.ShelvesApi;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.TimeUnit;

import cn.acsm.module.transaction.order.controller.admin.orderinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.orderinfo.OrderInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.order.convert.orderinfo.OrderInfoConvert;
import cn.acsm.module.transaction.order.dal.mysql.orderinfo.OrderInfoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.doFormat;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.order.enums.ErrorCodeConstants.*;

/**
 * 订单 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class OrderInfoServiceImpl implements OrderInfoService {

    @Resource
    private OrderInfoMapper infoMapper;
    @Resource
    private ConfigNumberUtil configNumberUtil;
    @Resource
    private OrderDetailService orderDetailService;

    @Resource
    private RedisDelayQueueUtil redisDelayQueueUtil;

    @Resource
    private ShelvesApi shelvesApi;
    @Resource
    private MarketPriceApi marketPriceApi;
    @Override
    @Transactional
    public String createInfo(OrderInfoCreateReqVO createReqVO) {
        Long tenantId = SecurityFrameworkUtils.getLoginUser().getTenantId();
        String number = configNumberUtil.getNumber("order_info"+tenantId);
        BigDecimal totalPrice = new BigDecimal(0);
        for (OrderDetailCreateReqVO detailCreateReqVO : createReqVO.getOrderDetailCreateReqVOS()) {
            ShelvesReqDto shelvesReqDto = new ShelvesReqDto();
            shelvesReqDto.setSpecificationsId(detailCreateReqVO.getSpecificationId());
            shelvesReqDto.setTenantId(String.valueOf(tenantId));
            CommonResult<List<ShelvesRespDto>> result = shelvesApi.findSpecificationsList(shelvesReqDto);
            List<ShelvesRespDto> shelvesRespDtos = result.getData();
            detailCreateReqVO.setUnitPrice(shelvesRespDtos.get(0).getSellingPrice());
            BigDecimal price = detailCreateReqVO.getUnitPrice().multiply(detailCreateReqVO.getNum());
            detailCreateReqVO.setTotalPrice(price);
            totalPrice = totalPrice.add(detailCreateReqVO.getTotalPrice());
        }
        // 插入
        OrderInfoDO info = OrderInfoConvert.INSTANCE.convert(createReqVO);
        info.setId(UUID.randomUUID().toString());
        info.setCode("DD"+number);
        info.setPayStatus("1");
        info.setPrice(totalPrice);
        info.setDealPrice(totalPrice);
        infoMapper.insert(info);
        createReqVO.getOrderDetailCreateReqVOS().stream().forEach(orderDetailCreateReqVO -> {
            orderDetailCreateReqVO.setOrderId(info.getId());
            orderDetailService.createDetail(orderDetailCreateReqVO);
            this.savePriceTag(orderDetailCreateReqVO);
        });
        // 返回
        return info.getId();
    }

    private void savePriceTag(OrderDetailCreateReqVO orderDetailCreateReqVO) {
        CommonResult<List<MarketPriceDto>> result =  marketPriceApi.getIdBySpecificationId(orderDetailCreateReqVO.getSpecificationId());
        List<MarketPriceDto> priceDtos = result.getData();
        if (priceDtos!=null && priceDtos.size()!=0){
            priceDtos.stream().forEach(price->{
                MarketPriceDetailsDto marketPriceDetailsDto = new MarketPriceDetailsDto();
                marketPriceDetailsDto.setMarketPriceId(price.getPriceId());
                marketPriceDetailsDto.setPayer(String.valueOf(SecurityFrameworkUtils.getLoginUser().getTenantId()));
                marketPriceDetailsDto.setPrice(orderDetailCreateReqVO.getUnitPrice());
                marketPriceDetailsDto.setPriceSource("1");
                marketPriceApi.saveMarketPriceDetails(marketPriceDetailsDto);
            });
        }
    }

    @Override
    public void updateInfo(OrderInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateInfoExists(updateReqVO.getId());
        // 更新
        OrderInfoDO updateObj = OrderInfoConvert.INSTANCE.convert(updateReqVO);
        infoMapper.updateById(updateObj);
    }

    @Override
    public void deleteInfo(String id) {
        // 校验存在
        this.validateInfoExists(id);
        // 删除
        infoMapper.deleteById(id);
    }

    private void validateInfoExists(String id) {
        if (infoMapper.selectById(id) == null) {
            throw exception(INFO_NOT_EXISTS);
        }
    }

    @Override
    public OrderInfoDO getInfo(String id) {
        return infoMapper.selectById(id);
    }

    @Override
    public List<OrderInfoDO> getInfoList(Collection<String> ids) {
        return infoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<OrderInfoDO> getInfoPage(OrderInfoPageReqVO pageReqVO) {
        return infoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<OrderInfoDO> getInfoList(OrderInfoExportReqVO exportReqVO) {
        return infoMapper.selectList(exportReqVO);
    }

    @Override
    public void confirm(OrderConfirmVO orderConfirmVO) {
        // 校验存在
        OrderInfoDO orderInfoDO =  infoMapper.selectById(orderConfirmVO.getId());
        if (orderInfoDO==null){
            throw exception(INFO_NOT_EXISTS);
        }
        if (!"0".equals(orderInfoDO.getLogisticsStatus())){
            throw exception(ORDER_CONFIRMED);

        }
        if ("0".equals(orderInfoDO.getPayStatus())){
            throw exception(ORDER_NO_CONFIRM);
        }
        // 更新
        OrderInfoDO updateObj = new OrderInfoDO();
        updateObj.setId(orderConfirmVO.getId());
        updateObj.setEstimatedDeliveryTime(orderConfirmVO.getEstimatedDeliveryTime());
        updateObj.setLogisticsStatus("1");
        infoMapper.updateById(updateObj);
    }

    @Override
    public void cancelOrder(CancelOrderVO cancelOrderVO) {
        // 校验存在
        OrderInfoDO orderInfoDO =  infoMapper.selectById(cancelOrderVO.getId());
        if (orderInfoDO==null){
            throw exception(INFO_NOT_EXISTS);
        }
        if (!"0".equals(orderInfoDO.getLogisticsStatus())){
            throw exception(ORDER_NO_CANCEL);
        }
        if (!("1".equals(orderInfoDO.getPayStatus()) || "0".equals(orderInfoDO.getPayStatus()))){
            throw exception(ORDER_NO_CANCEL);
        }
        // 更新
        OrderInfoDO updateObj = new OrderInfoDO();
        updateObj.setId(cancelOrderVO.getId());
        updateObj.setCause(cancelOrderVO.getCause());
        updateObj.setPayStatus("2");
        infoMapper.updateById(updateObj);
    }

    @Override
    public void deliverGoods(DeliverGoodsVO deliverGoodsVO) {
        // 校验存在
        OrderInfoDO orderInfoDO =  infoMapper.selectById(deliverGoodsVO.getId());
        if (orderInfoDO==null){
            throw exception(INFO_NOT_EXISTS);
        }
        if (!"1".equals(orderInfoDO.getLogisticsStatus())){
            throw exception(ORDER_NO_DELIVER_GOODS);
        }
        // 更新
        OrderInfoDO updateObj = new OrderInfoDO();
        updateObj.setId(deliverGoodsVO.getId());
        updateObj.setLogisticsCompanies(deliverGoodsVO.getLogisticsCompanies());
        updateObj.setLogisticsStatus("2");
        updateObj.setOgisticsTicketNumber(deliverGoodsVO.getOgisticsTicketNumber());
        infoMapper.updateById(updateObj);
    }

    @Override
    public void confirmDelivery(OrderIdVO orderIdVO) {
        // 校验存在
        OrderInfoDO orderInfoDO =  infoMapper.selectById(orderIdVO.getId());
        if (orderInfoDO==null){
            throw exception(INFO_NOT_EXISTS);
        }
        if (!"2".equals(orderInfoDO.getLogisticsStatus())){
            throw exception(ORDER_NO_DELIVER_CONFIRM_DELIVERY);
        }
        // 更新
        OrderInfoDO updateObj = new OrderInfoDO();
        updateObj.setId(orderIdVO.getId());
        updateObj.setLogisticsStatus("3");
        infoMapper.updateById(updateObj);

        redisDelayQueueUtil.addDelayQueue("1111", 60, TimeUnit.SECONDS, RedisDelayQueueEnum.COMPLETE_LOGISTICS.getQueueCode());

    }

    @Override
    public void modifyPrice(ModifyPriceVO modifyPriceVO) {
        // 校验存在
        OrderInfoDO orderInfoDO =  infoMapper.selectById(modifyPriceVO.getId());
        if (orderInfoDO==null){
            throw exception(INFO_NOT_EXISTS);
        }
        if (!"0".equals(orderInfoDO.getPayStatus())){
            throw exception(ORDER_NO_DELIVER_MODIFY_PRICE);
        }
        // 更新
        OrderInfoDO updateObj = new OrderInfoDO();
        updateObj.setId(modifyPriceVO.getId());
        updateObj.setPreferentialPrice(modifyPriceVO.getPreferentialPrice());
        infoMapper.updateById(updateObj);
    }

    @Override
    public List<ShelvesRespVo> findShelves(ShelvesReqVo shelvesReqVO) {
        ShelvesReqDto shelvesReqDto = OrderInfoConvert.INSTANCE.convertShelvesReqDto(shelvesReqVO);
        CommonResult<List<ShelvesRespDto>> result =  shelvesApi.findShelvesList(shelvesReqDto);
        return  OrderInfoConvert.INSTANCE.convertShelvesRespList(result.getData());
    }

    @Override
    public List<ShelvesRespVo> findSpecifications(ShelvesReqVo shelvesReqVO) {
        ShelvesReqDto shelvesReqDto = OrderInfoConvert.INSTANCE.convertShelvesReqDto(shelvesReqVO);
        CommonResult<List<ShelvesRespDto>>  result =  shelvesApi.findSpecificationsList(shelvesReqDto);
        return  OrderInfoConvert.INSTANCE.convertShelvesRespList(result.getData());
    }

    @Override
    public List<TreeSelectVo> findTreeList(ShelvesReqVo shelvesReqVO) {
        ShelvesReqDto shelvesReqDto = OrderInfoConvert.INSTANCE.convertShelvesReqDto(shelvesReqVO);
        CommonResult<List<TreeSelectDto>>  result =  shelvesApi.treeList(shelvesReqDto);
        return  OrderInfoConvert.convertShelvesTreeRespList(result.getData());
    }



}
