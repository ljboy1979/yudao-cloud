package cn.acsm.module.stock.service.record;

import cn.acsm.module.purchase.api.orderdetails.OrderDetailsApi;
import cn.acsm.module.purchase.api.orderdetails.vo.OrderDetailsApiVO;
import cn.acsm.module.stock.controller.admin.inventory.vo.StockInventoryUpdateCountVO;
import cn.acsm.module.stock.controller.admin.record.vo.*;
import cn.acsm.module.stock.convert.record.StockRecordConvert;
import cn.acsm.module.stock.dal.dataobject.inventory.StockInventoryDO;
import cn.acsm.module.stock.dal.dataobject.record.StockRecordDO;
import cn.acsm.module.stock.dal.dataobject.recorddetail.StockRecordDetailDO;
import cn.acsm.module.stock.dal.mysql.inventory.StockInventoryMapper;
import cn.acsm.module.stock.dal.mysql.record.StockRecordMapper;
import cn.acsm.module.stock.dal.mysql.recorddetail.StockRecordDetailMapper;
import cn.acsm.module.stock.service.inventory.StockInventoryService;
import cn.hutool.core.date.format.FastDateFormat;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.system.api.dept.DeptApi;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import cn.iocoder.yudao.module.system.api.user.dto.AdminUserRespDTO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static cn.acsm.module.stock.enums.ErrorCodeConstants.RECORD_DETAIL_EXISTS;
import static cn.acsm.module.stock.enums.ErrorCodeConstants.RECORD_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 库存记录 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
@Transactional(rollbackFor = Exception.class)
public class StockRecordServiceImpl implements StockRecordService {

    @Resource
    private StockRecordMapper recordMapper;

    @Resource
    private StockRecordDetailMapper detailMapper;

    @Resource
    private StockInventoryService inventoryService;

    @Resource
    private StockInventoryMapper inventoryMapper;

    @Resource
    private AdminUserApi userApi;

    @Resource
    private DeptApi deptApi;

    @Resource
    private OrderDetailsApi detailsApi;

    @Override
    public Long createRecordWarehousing(StockRecordCreateReqVO createReqVO) {
        // 插入库存记录信息
        // 生成入库批次号
        String batchNo = getBatchNo();
        StockRecordDO record = StockRecordConvert.INSTANCE.convert(createReqVO);
        record.setType(createReqVO.getType());
        record.setOperationType(false);
        record.setBatchNo(batchNo);
        recordMapper.insert(record);

        // 获取新增入库数据的id
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("batch_no", batchNo);
        StockRecordDO stockRecordDO = recordMapper.selectOne(wrapper);
        // 插入子表-库存记录明细表
        createReqVO.getStockRecordDetailDOList().forEach(detail -> {
            StockRecordDetailDO detailDO = new StockRecordDetailDO();
            detailDO.setOperationType(false);
            detailDO.setRecordId(stockRecordDO.getId());
            detailDO.setStockBatchNo(batchNo);
            detailDO.setGoodsId(detail.getGoodsId());
            detailDO.setGoodsName(detail.getGoodsName());
            detailDO.setPackingSpecification(detail.getPackingSpecification());
            detailDO.setReceiptQuantity(ObjectUtils.isNotEmpty(detail.getReceiptQuantity()) ? detail.getReceiptQuantity() : null);
            detailDO.setExistingInventory(ObjectUtils.isNotEmpty(detail.getReceiptQuantity()) ? detail.getReceiptQuantity() : null);
            detailDO.setUnitPrice(ObjectUtils.isNotEmpty(detail.getUnitPrice()) ? detail.getUnitPrice() : null);
            detailDO.setDiscountPrice(ObjectUtils.isNotEmpty(detail.getDiscountPrice()) ? detail.getDiscountPrice() : null);
            detailDO.setTotalPrice(ObjectUtils.isNotEmpty(detail.getTotalPrice()) ? detail.getTotalPrice() : null);
            detailDO.setTreasurySource(ObjectUtils.isNotEmpty(detail.getTreasurySource()) ? detail.getTreasurySource() : null);
            detailMapper.insert(detailDO);

            // 更新库存清单
            if(ObjectUtils.isNotEmpty(detail.getReceiptQuantity())) {
                StockInventoryUpdateCountVO updateCountVO = new StockInventoryUpdateCountVO();
                updateCountVO.setGoodsId(detail.getGoodsId());
                updateCountVO.setPackingSpecification(detail.getPackingSpecification());
                updateCountVO.setWarehouseId(createReqVO.getWarehouseId());
                updateCountVO.setInventoryQuantity(detail.getReceiptQuantity());
                inventoryService.updateInventoryCount(updateCountVO);
            }
        });
        // 返回
        return record.getId();
    }

    @Override
    public Long createRecordIssue(StockRecordCreateReqVO createReqVO) {
        // 插入库存记录信息
        // 生成出库批次号
        String batchNo = getBatchNo();
        StockRecordDO record = StockRecordConvert.INSTANCE.convert(createReqVO);
        record.setOperationType(true);
        record.setBatchNo(batchNo);
        recordMapper.insert(record);

        // 获取新增出库数据的id
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("batch_no", batchNo);
        StockRecordDO stockRecordDO = recordMapper.selectOne(wrapper);
        // 插入子表-库存记录明细表
        createReqVO.getStockRecordDetailDOList().forEach(detail -> {
            // 根据货位名称获取货位id


                StockRecordDetailDO detailDO = new StockRecordDetailDO();
                // 如果传参中，“关联库存记录明细id”没有传值，按传参的类型以及货品id和规格id在
                // 【库存出入库记录子表-明细表】中“临期时间”和“入库时间”正序优先出库
                if(ObjectUtils.isNotEmpty(detail.getId())) {
                    detailDO.setRecordDetailId(Long.valueOf(detail.getId()));
                } else {
                    QueryWrapper queryWrapper = new QueryWrapper();
                    queryWrapper.eq("goods_id", detail.getGoodsId());
                    queryWrapper.eq("packing_specification", detail.getPackingSpecification());
                    queryWrapper.orderByAsc("temporary_time");
                    queryWrapper.orderByAsc("create_time");
                    List<StockRecordDetailDO> list = detailMapper.selectList(queryWrapper);
                    Integer deliveryQuantity = detail.getDeliveryQuantity();
                    for (StockRecordDetailDO ck : list) {
                        // 将商品批量出库
                        if(deliveryQuantity > 0) {
                            deliveryQuantity = deliveryQuantity - ck.getExistingInventory();
                            // 若当前库存详情现有库存量小于出库量则将当前详情的现有库存量归零
                            if(deliveryQuantity > 0) {
                                UpdateWrapper wrapper1 = new UpdateWrapper();
                                wrapper1.eq("id", ck.getId());
                                StockRecordDetailDO recordDetailDO = new StockRecordDetailDO();
                                recordDetailDO.setExistingInventory(0);
                                detailMapper.update(recordDetailDO, wrapper1);
                            } else { // 若当前库存详情现有库存量大于出库量则将当前详情的 现有库存量 - 出库量 得出最终现有库存量
                                Integer existingInventory = ck.getExistingInventory() - deliveryQuantity;
                                UpdateWrapper wrapper1 = new UpdateWrapper();
                                wrapper1.eq("id", ck.getId());
                                StockRecordDetailDO recordDetailDO = new StockRecordDetailDO();
                                recordDetailDO.setExistingInventory(existingInventory);
                                detailMapper.update(recordDetailDO, wrapper1);
                            }
                            // 更新库存清单
                            StockInventoryUpdateCountVO updateCountVO = new StockInventoryUpdateCountVO();
                            updateCountVO.setGoodsId(ck.getGoodsId());
                            updateCountVO.setPackingSpecification(ck.getPackingSpecification());
                            updateCountVO.setWarehouseId(createReqVO.getWarehouseId());
                            // 减去当前出库数量 - “虚拟库存量”=“虚拟库存量”-出库数量；
                            updateCountVO.setInventoryQuantity(-detail.getDeliveryQuantity());
                            inventoryService.updateInventoryCount(updateCountVO);
                        } else {
                            break;
                        }
                    }
                    return;
                }
                detailDO.setOperationType(true);
                detailDO.setRecordId(stockRecordDO.getId());
                detailDO.setStockBatchNo(batchNo);
                detailDO.setGoodsId(detail.getGoodsId());
                detailDO.setGoodsName(detail.getGoodsName());
                detailDO.setPackingSpecification(detail.getPackingSpecification());
                detailDO.setDeliveryQuantity(detail.getDeliveryQuantity());
                detailDO.setUnitPrice(detail.getUnitPrice());
                detailDO.setTotalPrice(detail.getTotalPrice());
                detailDO.setTreasurySource(detail.getTreasurySource());
                detailMapper.insert(detailDO);

            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("id", detail.getId());
//            queryWrapper.eq("warehouse_id", createReqVO.getWarehouseId());
//            queryWrapper.eq("goods_id", detail.getGoodsId());
//            queryWrapper.eq("packing_specification", detail.getPackingSpecification());
            StockRecordDetailDO detailDO2 = detailMapper.selectOne(queryWrapper);

            // 根据库存明细id更新入库数据的现有库存数量
            UpdateWrapper updateWrapper = new UpdateWrapper();
            updateWrapper.eq("id", detail.getId());
//            updateWrapper.eq("warehouse_id", createReqVO.getWarehouseId());
//            updateWrapper.eq("goods_id", detail.getGoodsId());
//            updateWrapper.eq(StringUtils.isNotBlank(detail.getPackingSpecification()), "packing_specification", createReqVO.getPackingSpecification());

            StockRecordDetailDO detailDO1 = new StockRecordDetailDO();
            detailDO1.setExistingInventory(detailDO2.getExistingInventory() - detail.getDeliveryQuantity());
            detailMapper.update(detailDO1, updateWrapper);

            // 更新库存清单
            StockInventoryUpdateCountVO updateCountVO = new StockInventoryUpdateCountVO();
            updateCountVO.setGoodsId(detail.getGoodsId());
            updateCountVO.setPackingSpecification(detail.getPackingSpecification());
            updateCountVO.setWarehouseId(createReqVO.getWarehouseId());
            // 减去当前出库数量 - “虚拟库存量”=“虚拟库存量”-出库数量；
            updateCountVO.setInventoryQuantity(-detail.getDeliveryQuantity());
            inventoryService.updateInventoryCount(updateCountVO);
        });
        // 返回
        return record.getId();
    }

    //            StockRecordDetailDO detailDO = new StockRecordDetailDO();
//            detailDO.setRecordDetailId(createReqVO.getRecordDetailId());
//            detailDO.setOperationType(true);
//            detailDO.setRecordId(stockRecordDO.getId());
//            detailDO.setStockBatchNo(batchNo);
//            detailDO.setGoodsId(createReqVO.getGoodsId());
//            detailDO.setGoodsName(createReqVO.getGoodsName());
//            detailDO.setPackingSpecification(createReqVO.getPackingSpecification());
//            detailDO.setDeliveryQuantity(createReqVO.getDeliveryQuantity());
//            detailDO.setUnitPrice(createReqVO.getUnitPrice());
//            detailDO.setUnit(createReqVO.getUnit());
//            detailDO.setTotalPrice(createReqVO.getTotalPrice());
//            detailDO.setProductionBatchNo(createReqVO.getProductionBatchNo());
//            detailDO.setPurchaseId(createReqVO.getPurchaseId());
//            detailDO.setPurchaseNumber(createReqVO.getPurchaseNumber());
//            detailMapper.insert(detailDO);

    // 根据库存明细id获取入库数据的现有库存数量


    /**
     * 生成入库批次号
     */
    private String getBatchNo() {
        String prefix = "RKPC";
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.orderByDesc("batch_no");
        wrapper.last(" limit 1");
        StockRecordDO aDo = recordMapper.selectOne(wrapper);
        String now = FastDateFormat.getInstance("yyyyMMdd").format(new Date());
        if(ObjectUtils.isNotEmpty(aDo) && StringUtils.equalsIgnoreCase(
                aDo.getBatchNo().substring(4, 12), now)) {
            Integer newNumber = Integer.valueOf(aDo.getBatchNo().substring(12)) + 1;
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

    @CachePut(value = "stockRecord", key = "#updateReqVO.id")
    @Override
    public void updateRecord(StockRecordUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateRecordExists(updateReqVO.getId());
        // 更新
        StockRecordDO updateObj = StockRecordConvert.INSTANCE.convert(updateReqVO);
        recordMapper.updateById(updateObj);
    }

    /**
     * 3.7.2.18.删除入库记录单
     * @param id 编号
     */
    @CacheEvict(value = "stockRecord", key = "#id")
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void deleteRecord(Long id) {
        // 校验存在
        this.validateRecordExists(id);
        // 先判断要删除的记录是否有出库记录，如果有，提示”已有出库记录，不可删除“；如果没有执行2、3、4
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("record_id", id);
        List<StockRecordDetailDO> list = detailMapper.selectList(wrapper);
        // 查看是否有对应出库记录
        List<StockRecordDetailDO> collect = list.stream().filter(detil -> detil.getOperationType() == true).collect(Collectors.toList());
        if(!CollectionUtils.isEmpty(collect)) {
            exception(RECORD_DETAIL_EXISTS);
        }

        // 获取所有要删除的详情id【用于批量删除】
        List<Long> detailIds = list.stream().map(de -> {
            return de.getId();
        }).collect(Collectors.toList());

        // 获取仓库id
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", id);
        StockRecordDO stockRecordDO = recordMapper.selectOne(queryWrapper);

        // 逻辑删除明细数据
        detailMapper.deleteBatchIds(detailIds);

        // 逻辑删除库存
        recordMapper.deleteById(id);

        // 调用更新库存量方法（货品id、规格id、仓库id、-数量）
        list.stream().forEach(ls -> {
            QueryWrapper inventoryQueryWrapper = new QueryWrapper();
            inventoryQueryWrapper.eq("goods_id", ls.getGoodsId());
            inventoryQueryWrapper.eq("packing_specification", ls.getPackingSpecification());
            inventoryQueryWrapper.eq("warehouse_id", stockRecordDO.getWarehouseId());
            StockInventoryDO inventoryDO1 = inventoryMapper.selectOne(inventoryQueryWrapper);
            UpdateWrapper inventoryWrapper = new UpdateWrapper();
            inventoryWrapper.eq("goods_id", ls.getGoodsId());
            inventoryWrapper.eq("packing_specification", ls.getPackingSpecification());
            inventoryWrapper.eq("warehouse_id", stockRecordDO.getWarehouseId());

            StockInventoryDO inventoryDO = new StockInventoryDO();
            // 获取入库的总数量
            Integer sum = list.stream().filter(sd -> sd.getGoodsId() == ls.getGoodsId())
                    .map(s -> s.getReceiptQuantity()).mapToInt(Integer::intValue).sum();
            inventoryDO.setInventoryQuantity(inventoryDO1.getInventoryQuantity() - sum);
            inventoryMapper.update(inventoryDO, inventoryWrapper);
        });
    }

    /**
     * 删除出库记录单
     *
     * @param id 编号
     */
    public void deleteOutRecord(Long id) {
        // 获取出库记录
        QueryWrapper recordWrapper = new QueryWrapper();
        recordWrapper.eq("id", id);
        recordWrapper.eq("deleted", 0);
        StockRecordDO stockRecordDO = recordMapper.selectOne(recordWrapper);

        // 获取出库记录详情
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("record_id", id);
        queryWrapper.eq("operation_type", 1);
        List<StockRecordDetailDO> list = detailMapper.selectList(queryWrapper);
        if(!CollectionUtils.isEmpty(list)) {
            // 更新清单库存量
            list.stream().forEach(ls -> {
                // 获取对应入库记录详情的现有库存量
                Long recordDetailId = ls.getRecordDetailId();
                QueryWrapper detailQueryWrapper = new QueryWrapper();
                detailQueryWrapper.eq("id", recordDetailId);

                StockRecordDetailDO detailDO1 = detailMapper.selectOne(detailQueryWrapper);


                // 更新对应入库记录详情的现有库存量
                UpdateWrapper detailUpdateWrapper = new UpdateWrapper();
                detailUpdateWrapper.eq("id", recordDetailId);

                StockRecordDetailDO detailDO = new StockRecordDetailDO();
                // 现有库存量 = 现有库存量 + 出库量
                detailDO.setExistingInventory(detailDO1.getExistingInventory() + ls.getDeliveryQuantity());

                detailMapper.update(detailDO, detailUpdateWrapper);

                // 查询清单库存量
                QueryWrapper inventoryQueryWrapper = new QueryWrapper();
                inventoryQueryWrapper.eq("goods_id", ls.getGoodsId());
                inventoryQueryWrapper.eq("packing_specification", ls.getPackingSpecification());
                inventoryQueryWrapper.eq("warehouse_id", stockRecordDO.getWarehouseId());
                StockInventoryDO inventoryDO1 = inventoryMapper.selectOne(inventoryQueryWrapper);

                UpdateWrapper inventoryWrapper = new UpdateWrapper();
                inventoryWrapper.eq("goods_id", ls.getGoodsId());
                inventoryWrapper.eq("packing_specification", ls.getPackingSpecification());
                inventoryWrapper.eq("warehouse_id", stockRecordDO.getWarehouseId());

                StockInventoryDO inventoryDO = new StockInventoryDO();
                // 获取出库的总数量
                Integer sum = list.stream().filter(sd -> (sd.getGoodsId() == ls.getGoodsId()
                        && sd.getPackingSpecification().equalsIgnoreCase(ls.getPackingSpecification())))
                        .map(s -> s.getDeliveryQuantity()).mapToInt(Integer::intValue).sum();
                inventoryDO.setInventoryQuantity(inventoryDO1.getInventoryQuantity() + sum);
                inventoryMapper.update(inventoryDO, inventoryWrapper);

                // 删除出库记录详情
                detailMapper.deleteById(ls.getId());
            });
        }

        // 删除出库记录
        recordMapper.deleteById(id);
    }

    private void validateRecordExists(Long id) {
        if (recordMapper.selectById(id) == null) {
            throw exception(RECORD_NOT_EXISTS);
        }
    }

    @Cacheable(value = "stockRecord", key = "#id")
    @Override
    public StockRecordDO getRecord(Long id) {
        return recordMapper.selectById(id);
    }

    @Cacheable(value = "stockRecord", key = "#ids")
    @Override
    public List<StockRecordDO> getRecordList(Collection<Long> ids) {
        return recordMapper.selectBatchIds(ids);
    }

//    @Cacheable(value = "stockRecord", key = "'getRecordPage'")
    @Override
    public Page<StockRecordFeignVO> getRecordPage(StockRecordPageReqVO pageReqVO) {
        Page<StockRecordDO> page = new Page<>(pageReqVO.getPageNo(), pageReqVO.getPageSize());
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq(ObjectUtils.isNotEmpty(pageReqVO.getType()), "type", pageReqVO.getType());
        wrapper.eq(ObjectUtils.isNotEmpty(pageReqVO.getOperationType()), "operation_type", pageReqVO.getOperationType());
        wrapper.eq(ObjectUtils.isNotEmpty(pageReqVO.getWarehouseId()), "warehouse_id", pageReqVO.getWarehouseId());
        wrapper.eq(ObjectUtils.isNotEmpty(pageReqVO.getWarehouseCode()), "warehouse_code", pageReqVO.getWarehouseCode());
        wrapper.like(ObjectUtils.isNotEmpty(pageReqVO.getWarehouseName()), "warehouse_name", pageReqVO.getWarehouseName());
        wrapper.eq(ObjectUtils.isNotEmpty(pageReqVO.getBatchNo()), "batch_no", pageReqVO.getBatchNo());
        wrapper.gt(ObjectUtils.isNotEmpty(pageReqVO.getOperationStartTime()), "operation_time", pageReqVO.getOperationStartTime());
        wrapper.lt(ObjectUtils.isNotEmpty(pageReqVO.getOperationEndTime()), "operation_time", pageReqVO.getOperationEndTime());
        wrapper.eq(ObjectUtils.isNotEmpty(pageReqVO.getHeadId()), "head_id", pageReqVO.getHeadId());
        wrapper.like(ObjectUtils.isNotEmpty(pageReqVO.getHeadName()), "head_name", pageReqVO.getHeadName());
        wrapper.eq(ObjectUtils.isNotEmpty(pageReqVO.getCreateTime()), "create_time", pageReqVO.getCreateTime());
        Page<StockRecordDO> selectPage = recordMapper.selectPage(page, wrapper);

        List<StockRecordFeignVO> feignVOS = selectPage.getRecords().stream().map(sp -> {
            StockRecordFeignVO feignVO = new StockRecordFeignVO();
            BeanUtils.copyProperties(sp, feignVO);
            // 获取负责人名称
            CommonResult<AdminUserRespDTO> user = userApi.getUser(sp.getHeadId());
            feignVO.setHeadName(user.getData().getNickname());

            // 获取仓库名称-【暂无对外API接口】


            // 获取部门名称
            feignVO.setDepartmentName(deptApi.getDept(sp.getDepartmentId()).getData().getName());
            return feignVO;
        }).collect(Collectors.toList());
        Page<StockRecordFeignVO> feignVOPage = new Page<>(pageReqVO.getPageNo(), pageReqVO.getPageSize());
        feignVOPage.setTotal(selectPage.getTotal());
        feignVOPage.setRecords(feignVOS);
        return feignVOPage;
    }

    @Cacheable(value = "stockRecord", key = "'getRecordList'.concat('-')" +
            ".concat(#exportReqVO.type).concat('-').concat(#exportReqVO.operationType)" +
            ".concat('-').concat(#exportReqVO.batchNo)")
    @Override
    public List<StockRecordDO> getRecordList(StockRecordExportReqVO exportReqVO) {
        return recordMapper.selectList(exportReqVO);
    }

    /**
     * 3.7.2.14.查询出/入库记录
     *
     * @param pageReqVO 分页查询
     * @return 库存记录分页
     */
    @Cacheable(value = "stockRecord", key = "'getRecordOutEnterPage'.concat('-')" +
            ".concat(#pageReqVO.type).concat('-').concat(#pageReqVO.batchNo)")
    @Override
    public Page<StockRecordDO> getRecordOutEnterPage(StockRecordOutEnterVO pageReqVO) {
        Page<StockRecordDO> page = new Page<>(pageReqVO.getPageNo(), pageReqVO.getPageSize());

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("operation_type", pageReqVO.getOperationType());
        wrapper.like(StringUtils.isNotBlank(pageReqVO.getHeadName()), "head_name", pageReqVO.getHeadName());
        wrapper.eq(ObjectUtils.isNotEmpty(pageReqVO.getType()), "type", pageReqVO.getType());
        wrapper.like(StringUtils.isNotBlank(pageReqVO.getWarehouseName()), "warehouse_name", pageReqVO.getWarehouseName());
        wrapper.eq(StringUtils.isNotBlank(pageReqVO.getBatchNo()), "batch_no", pageReqVO.getBatchNo());
        wrapper.gt(ObjectUtils.isNotEmpty(pageReqVO.getOperationStartTime()), "operation_time", pageReqVO.getOperationStartTime());
        wrapper.lt(ObjectUtils.isNotEmpty(pageReqVO.getOperationEndTime()), "operation_time", pageReqVO.getOperationEndTime());
        wrapper.orderByDesc("create_time");
        return recordMapper.selectPage(page, wrapper);
    }

//    @Cacheable(value = "stockRecord", key = "#treasurySource")
    @Override
    public List<OrderDetailsApiVO> getRecord(String treasurySource, String id) {
        if(StringUtils.equalsIgnoreCase(treasurySource,"1")) {
            // 获取采收记录信息
//            String harvestBatchId = detailDO.getHarvestBatchId();
            // 此处需远程调用获取采收记录信息
        } else if(StringUtils.equalsIgnoreCase(treasurySource,"2")) {
            // 获取采购记录信息
//            String purchaseNumber = detailDO.getPurchaseNumber();
            CommonResult<List<OrderDetailsApiVO>> orderDetails = detailsApi.getOrderDetails();
            return orderDetails.getData();
        }
        return null;
    }

}
