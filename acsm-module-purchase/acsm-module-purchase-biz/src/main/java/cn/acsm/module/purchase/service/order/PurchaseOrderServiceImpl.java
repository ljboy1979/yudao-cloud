package cn.acsm.module.purchase.service.order;

import cn.acsm.module.purchase.controller.admin.order.vo.*;
import cn.acsm.module.purchase.convert.order.PurchaseOrderConvert;
import cn.acsm.module.purchase.dal.dataobject.details.PurchaseDetailsDO;
import cn.acsm.module.purchase.dal.dataobject.order.PurchaseOrderDO;
import cn.acsm.module.purchase.dal.mysql.details.PurchaseDetailsMapper;
import cn.acsm.module.purchase.dal.mysql.order.PurchaseOrderMapper;
import cn.acsm.module.stock.api.inventory.StockInventoryApi;
import cn.acsm.module.stock.api.inventory.qo.InventoryQO;
import cn.acsm.module.stock.api.inventory.vo.StockInventoryApiReqVO;
import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesRespDto;
import cn.acsm.module.transaction.sales.api.shelves.ShelvesApi;
import cn.hutool.core.date.format.FastDateFormat;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static cn.acsm.module.purchase.constant.PurchaseOrderConstant.PURCHASE_STATUS_1;
import static cn.acsm.module.purchase.constant.PurchaseOrderConstant.STATUS;
import static cn.acsm.module.purchase.enums.ErrorCodeConstants.ORDER_CREATE_ERROR;
import static cn.acsm.module.purchase.enums.ErrorCodeConstants.ORDER_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 采购单 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
@Transactional(readOnly = false)
@Slf4j
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Resource
    private PurchaseOrderMapper orderMapper;

    @Resource
    private PurchaseDetailsMapper purchaseDetailsMapper;

    @Resource
    private StockInventoryApi inventoryApi;

    @Resource
    private ShelvesApi shelvesApi;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public CommonResult<String> createOrder(PurchaseOrderCreateReqVO createReqVO) {
        String purchaseNumber = null;
        try {
            purchaseNumber = getPurchaseNumber();
            createReqVO.setPurchaseNumber(purchaseNumber);
            // 设置采购单状态为 2 【正常|有效】
            createReqVO.setStatus("2");
            // 插入
            PurchaseOrderDO order = PurchaseOrderConvert.INSTANCE.convert(createReqVO);
            int flag = orderMapper.insert(order);

            // 获取采购单id
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("purchase_number", purchaseNumber);
            PurchaseOrderDO orderDO = orderMapper.selectOne(wrapper);

            // 如果采购来源为集单采购，则需处理数据并创建采购单明细
            if(StringUtils.equalsIgnoreCase(createReqVO.getSource(),"3")) {
                Map<Long, Map<Long, List<GoodInfos>>> collect = createReqVO.getGoodInfos().stream().collect(Collectors
                        .groupingBy(t -> t.getGoodsId(), Collectors.groupingBy(t -> t.getPackagingSpecificationId())));

                collect.forEach((k,v) -> {
                    PurchaseDetailsDO detailsDO = new PurchaseDetailsDO();
                    detailsDO.setPurchaseId(orderDO.getId());
                    detailsDO.setPurchaseNumber(createReqVO.getPurchaseNumber());
                    detailsDO.setSubjectId(createReqVO.getSubjectId());
                    detailsDO.setUserId(createReqVO.getUserId());
                    detailsDO.setSourceId(createReqVO.getSourceId());
                    detailsDO.setTenantId(createReqVO.getTenantId());
                    detailsDO.setGoodsId(k);
                    // 获取不同规格的商品累加
                    v.forEach((key, val) -> {
                        detailsDO.setGoodsName(val.get(0).getGoodsName());
                        detailsDO.setPackagingSpecificationId(Long.getLong(val.get(0).getPackagingSpecificationId().toString()));
                        detailsDO.setPackagingSpecification(val.get(0).getPackagingSpecification());
                        detailsDO.setUnit(val.get(0).getUnit());
                        detailsDO.setPackagingType(val.get(0).getPackagingType());
                        // 数量累加
                        detailsDO.setBuyNumber(new BigDecimal(val.stream().map(s -> s.getBuyNumber()).mapToDouble(Double::doubleValue).sum()));
                        purchaseDetailsMapper.insert(detailsDO);
                    });
                });
                // 更新采购单汇总金额
//                QueryWrapper detailsQuery = new QueryWrapper();
//                detailsQuery.eq("purchase_number", createReqVO.getPurchaseNumber());
//                List<PurchaseDetailsDO> list = purchaseDetailsMapper.selectList(detailsQuery);
                // 获取当前采购单的采购总额
//                PurchaseOrderDO orderDO1 = new PurchaseOrderDO();
//                BigDecimal priceSum = new BigDecimal(0);
//                if(!CollectionUtils.isEmpty(list)) {
//                    for (PurchaseDetailsDO detailsDO1 : list) {
//                        priceSum = priceSum.add(detailsDO1.getTotal());
//                    }
//                    orderDO1.setPurchaseTotalAmount(priceSum);
//                }
//
//                // 变更采购单汇总金额
//                UpdateWrapper orderWrapper = new UpdateWrapper();
//                orderWrapper.eq("purchase_number", createReqVO.getPurchaseNumber());
//                orderDO1.setUpdateTime(LocalDateTime.now());
//                orderMapper.update(orderDO1, orderWrapper);
            }
        } catch (RuntimeException e) {
            log.error("采购单或采购单明细创建失败,单号：{}", purchaseNumber);
            return CommonResult.error(ORDER_CREATE_ERROR);
        }
        // 返回
        return CommonResult.success(purchaseNumber);
    }

    /**
     * 生成采购单号
     */
    private String getPurchaseNumber() {
        String prefix = "CGHT";
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.orderByDesc("purchase_number");
        wrapper.last(" limit 1");
        PurchaseOrderDO aDo = orderMapper.selectOne(wrapper);
        String now = FastDateFormat.getInstance("yyyyMMdd").format(new Date());
        if(ObjectUtils.isNotEmpty(aDo) && StringUtils.equalsIgnoreCase(
                aDo.getPurchaseNumber().substring(4, 12), now)) {
            Integer newNumber = Integer.valueOf(aDo.getPurchaseNumber().substring(12)) + 1;
            if(newNumber.toString().length() == 1) {
                String number = prefix.concat(now).concat("0000".concat(newNumber+""));
                return number;
            }
            if(newNumber.toString().length() == 2) {
                String number = prefix.concat(now).concat("000".concat(newNumber + ""));
                return number;
            }
            if(newNumber.toString().length() == 3) {
                String number = prefix.concat(now).concat("00".concat(newNumber + ""));
                return number;
            }
            if(newNumber.toString().length() == 4) {
                String number = prefix.concat(now).concat("0".concat(newNumber + ""));
                return number;
            }
            if(newNumber.toString().length() == 5) {
                String number = prefix.concat(now).concat(newNumber + "");
                return number;
            }
        }
        return prefix.concat(now).concat("00001");
    }

    @CachePut(value = "purchaseOrder", key = "#updateReqVO.id")
    @Override
    public void updateOrder(PurchaseOrderUpdateReqVO updateReqVO) {
        if(StringUtils.equalsIgnoreCase(updateReqVO.getPurchaseStatus(), PURCHASE_STATUS_1)) {
            // 校验存在
            this.validateOrderExists(updateReqVO.getId());
            // 更新
            PurchaseOrderDO updateObj = PurchaseOrderConvert.INSTANCE.convert(updateReqVO);
            orderMapper.updateById(updateObj);
        } else {
            log.info("采购状态为'采购未开始',才可修改。采购单id：{}",updateReqVO.getId());
        }
    }

    @CacheEvict(value = "purchaseOrder", key = "#purchaseOrderDelReqVO.id")
    @Override
    public void deleteOrder(PurchaseOrderDelReqVO purchaseOrderDelReqVO) {
        // 校验存在
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("purchase_status", PURCHASE_STATUS_1);
        wrapper.eq("purchase_number", purchaseOrderDelReqVO.getPurchaseNumber());
        if(ObjectUtils.isEmpty(orderMapper.selectOne(wrapper))) {
            throw exception(ORDER_NOT_EXISTS);
        }
        // 删除采购单明细
        QueryWrapper detaileWrapper = new QueryWrapper();
        detaileWrapper.eq("purchase_number", purchaseOrderDelReqVO.getPurchaseNumber());
        purchaseDetailsMapper.delete(detaileWrapper);
        // 删除采购单
        orderMapper.deleteById(purchaseOrderDelReqVO.getId());
    }

    private void validateOrderExists(Long id) {
        if (orderMapper.selectById(id) == null) {
            throw exception(ORDER_NOT_EXISTS);
        }
    }

    @Cacheable(value = "purchaseOrder", key = "#id")
    @Override
    public PurchaseOrderDO getOrder(Long id) {
        return orderMapper.selectById(id);
    }

    @Cacheable(value = "purchaseOrder", key = "#ids")
    @Override
    public List<PurchaseOrderDO> getOrderList(Collection<Long> ids) {
        return orderMapper.selectBatchIds(ids);
    }

    @Cacheable(value = "purchaseOrder", key = "#pageReqVO.pageNo.concat('-').concat(#pageReqVO.pageSize)")
    @Override
    public PageResult<PurchaseOrderDO> getOrderPage(PurchaseOrderPageReqVO pageReqVO) {
        // 状态设置为正常
        pageReqVO.setStatus(STATUS);
        return orderMapper.selectPage(pageReqVO);
    }

    @Cacheable(value = "purchaseOrder", key = "'getOrderList'")
    @Override
    public List<PurchaseOrderDO> getOrderList(PurchaseOrderExportReqVO exportReqVO) {
        return orderMapper.selectList(exportReqVO);
    }

    /**
     * 变更采购状态
     *
     * @param updateReqVO 更新信息
     */
    @CachePut(value = "purchaseOrder", key = "'updateOrderStatus'.concat(#updateReqVO.purchaseNumber)")
    @Override
    public void updateOrderStatus(PurchaseOrderUpdateStatusReqVO updateReqVO) {
        // 效验存在
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("purchase_number", updateReqVO.getPurchaseNumber());
        if(ObjectUtils.isEmpty(orderMapper.selectOne(queryWrapper))) {
            throw exception(ORDER_NOT_EXISTS);
        }
        // 变更采购单明细信息
        UpdateWrapper detailsWrapper = new UpdateWrapper();
        detailsWrapper.eq("id", updateReqVO.getId());
        detailsWrapper.eq("purchase_number", updateReqVO.getPurchaseNumber());

        PurchaseDetailsDO detailsDO = new PurchaseDetailsDO();
        detailsDO.setPrice(updateReqVO.getPrice());
        detailsDO.setDiscount(updateReqVO.getDiscount());
        detailsDO.setTotal(updateReqVO.getTotal());
        purchaseDetailsMapper.update(detailsDO, detailsWrapper);

        QueryWrapper detailsQuery = new QueryWrapper();
        detailsQuery.eq("purchase_number", updateReqVO.getPurchaseNumber());
        List<PurchaseDetailsDO> list = purchaseDetailsMapper.selectList(detailsQuery);
        // 获取当前采购单的采购总额
        BigDecimal priceSum = new BigDecimal(0);
        for (PurchaseDetailsDO detailsDO1 : list) {
            priceSum = priceSum.add(detailsDO1.getTotal());
        }

        // 变更采购单信息
        UpdateWrapper orderWrapper = new UpdateWrapper();
        orderWrapper.eq("purchase_number", updateReqVO.getPurchaseNumber());

        PurchaseOrderDO orderDO = new PurchaseOrderDO();
        orderDO.setPurchaseTotalAmount(priceSum);
        orderDO.setPayWay(updateReqVO.getPayWay());
        orderDO.setPurchaseStatus(updateReqVO.getPurchaseStatus());
        orderDO.setComplateTime(new Date());
        orderMapper.update(orderDO, orderWrapper);
    }

    /**
     * 3.6.2.5.查询采购合同单
     */
    @Cacheable(value = "purchaseOrder", key = "'getOrderPageInfo'.concat('-').concat(#pageReqVO.pageNo)" +
            ".concat('-').concat(#pageReqVO.pageSize)")
    @Override
    public PageResult<QueryPurchaseOrderPageInfoVO> getOrderPageInfo(PurchaseOrderPageInfoVO pageReqVO) {
        Page<QueryPurchaseOrderPageInfoVO> page = new Page(pageReqVO.getPageNo(), pageReqVO.getPageSize());
        PageResult<QueryPurchaseOrderPageInfoVO> result = orderMapper.selectPage(page, pageReqVO);
        return result;
    }

    /**
     * 3.6.2.3.获取采购产品列表
     */
//    @Cacheable(value = "purchaseOrder", key = "'getOrderPageInfo'.concat('-').concat(#pageReqVO.pageNo)" +
//            ".concat('-').concat(#pageReqVO.pageSize).concat('-').concat(#pageReqVO.purchaseType)")
    @Override
    public Page<QueryPurchaseOrderPageInfoVO> getOrderPageInfo(PurchaseOrderProductsVO pageReqVO) {
        Page<QueryPurchaseOrderGoodsVO> page = new Page<>(pageReqVO.getPageNo(), pageReqVO.getPageSize());
        // 商品类型
        Integer type = pageReqVO.getPurchaseType();
        ShelvesSalesReqDto reqDto = new ShelvesSalesReqDto();
        reqDto.setType(type);
        CommonResult<List<ShelvesSalesRespDto>> specifications = shelvesApi.findSpecifications(reqDto);
        List<ShelvesSalesRespDto> data = specifications.getData();

        // 获取所有产品id
        List<QueryPurchaseOrderGoodsVO> orderGoodsVOS = data.stream().map(dto -> {
            InventoryQO qo = new InventoryQO();
            qo.setGoodsId(dto.getId());
            qo.setType(Long.valueOf(type));
            qo.setPackingSpecification(dto.getName());
            StockInventoryApiReqVO inventorys = inventoryApi.getInventorys(qo);
            QueryPurchaseOrderGoodsVO infoVO = new QueryPurchaseOrderGoodsVO();
            infoVO.setGoodsName(inventorys.getGoodsName());
            infoVO.setGoodsType(inventorys.getGoodsType());
            infoVO.setPackagingSpecificationName(inventorys.getPackingSpecification());
            infoVO.setPackagingType(inventorys.getPackagingType());
            infoVO.setSpecifications(inventorys.getSpecifications());
            infoVO.setInventoryQuantity(inventorys.getInventoryQuantity());
            infoVO.setMeasureUnit(inventorys.getMeasureUnit());
            return infoVO;
        }).skip(pageReqVO.getPageNo()).limit((pageReqVO.getPageNo()-1)*pageReqVO.getPageSize()).collect(Collectors.toList());
        return null;
    }

}
