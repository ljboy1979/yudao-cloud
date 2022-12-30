package cn.acsm.module.stock.service.recorddetail;

import cn.acsm.module.stock.controller.admin.recorddetail.vo.*;
import cn.acsm.module.stock.convert.recorddetail.StockRecordDetailConvert;
import cn.acsm.module.stock.dal.dataobject.record.StockRecordDO;
import cn.acsm.module.stock.dal.dataobject.recorddetail.StockRecordDetailDO;
import cn.acsm.module.stock.dal.mysql.record.StockRecordMapper;
import cn.acsm.module.stock.dal.mysql.recorddetail.StockRecordDetailMapper;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.system.api.dept.DeptApi;
import cn.iocoder.yudao.module.system.api.dept.dto.DeptRespDTO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static cn.acsm.module.stock.enums.ErrorCodeConstants.RECORD_DETAIL_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 库存记录字表-明细 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class StockRecordDetailServiceImpl implements StockRecordDetailService {

    @Resource
    private StockRecordDetailMapper recordDetailMapper;

    @Resource
    private StockRecordMapper recordMapper;

    @Resource
    private DeptApi deptApi;

    @Override
    public Long createRecordDetail(StockRecordDetailCreateReqVO createReqVO) {
        // 插入
        StockRecordDetailDO recordDetail = StockRecordDetailConvert.INSTANCE.convert(createReqVO);
        recordDetailMapper.insert(recordDetail);
        // 返回
        return recordDetail.getId();
    }

    @CachePut(value = "stockRecordDetail", key = "#updateReqVO.id")
    @Override
    public void updateRecordDetail(StockRecordDetailUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateRecordDetailExists(updateReqVO.getId());
        // 更新
        StockRecordDetailDO updateObj = StockRecordDetailConvert.INSTANCE.convert(updateReqVO);
        recordDetailMapper.updateById(updateObj);
    }

    @CacheEvict(value = "stockRecordDetail", key = "#id")
    @Override
    public void deleteRecordDetail(Long id) {
        // 校验存在
        this.validateRecordDetailExists(id);
        // 删除
        recordDetailMapper.deleteById(id);
    }

    private void validateRecordDetailExists(Long id) {
        if (recordDetailMapper.selectById(id) == null) {
            throw exception(RECORD_DETAIL_NOT_EXISTS);
        }
    }

    @Cacheable(value = "stockRecord", key = "#id")
    @Override
    public StockRecordDetailDO getRecordDetail(Long id) {
        return recordDetailMapper.selectById(id);
    }

    @Override
    public List<StockRecordDetailDO> getRecordDetailList(Collection<Long> ids) {
        return recordDetailMapper.selectBatchIds(ids);
    }

    /**
     * 3.7.2.11.获取入库货品及现有库存量
     * @param pageReqVO 分页查询
     * @return
     */
//    @Cacheable(value = "stockRecord", key = "'getRecordDetailPage'.concat('-').concat(#pageReqVO.goodsType)" +
//            ".concat('-').concat(#pageReqVO.stockBatchNo).concat('-').concat(#pageReqVO.goodsName)")
    @Override
    public Page<StockRecordDetailDO> getRecordDetailPage(StockRecordDetailPageReqVO pageReqVO) {
        // 获取指定仓库的入库id
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("warehouse_id", pageReqVO.getWarehouseId());
        queryWrapper.eq("operation_type", 0);
        List<StockRecordDO> list = recordMapper.selectList(queryWrapper);
        List<Long> ids = list.stream().map(sd -> sd.getId()).collect(Collectors.toList());

        Page<StockRecordDetailDO> page = new Page(pageReqVO.getPageNo(), pageReqVO.getPageSize());
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq(ObjectUtils.isNotEmpty(pageReqVO.getGoodsType()), "goods_type", pageReqVO.getGoodsType());
        wrapper.eq(ObjectUtils.isNotEmpty(pageReqVO.getStockBatchNo()), "stock_batch_no", pageReqVO.getStockBatchNo());
        wrapper.like(ObjectUtils.isNotEmpty(pageReqVO.getGoodsName()),"goods_name", pageReqVO.getGoodsName());
        wrapper.in("record_id", ids);
        // 现有库存数量大于0
        wrapper.gt("existing_inventory", 0);
        wrapper.orderByAsc("create_time");
        return recordDetailMapper.selectPage(page, wrapper);
    }

    /**
     * 获取出入库记录详情
     * @param pageReqVO 分页查询
     * @return
     */
    public Page<StockRecordDetailDO> getRecordDetailOutPage(StockRecordDetailPageInOutVO pageReqVO) {
        Page<StockRecordDetailDO> page = new Page<>(pageReqVO.getPageNo(), pageReqVO.getPageSize());
        // 获取出库详情
        if(StringUtils.equalsIgnoreCase(pageReqVO.getOperationType(), "1")) {
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("operation_type", 1);
            wrapper.eq(ObjectUtils.isNotEmpty(pageReqVO.getGoodsType()), "goods_type", pageReqVO.getGoodsType());
            wrapper.eq(ObjectUtils.isNotEmpty(pageReqVO.getGoodsName()), "goods_name", pageReqVO.getGoodsName());
            wrapper.eq(ObjectUtils.isNotEmpty(pageReqVO.getStockBatchNo()), "stock_batch_no", pageReqVO.getStockBatchNo());
            Page page1 = recordDetailMapper.selectPage(page, wrapper);
//            page1
            return page1;
        }
        // 获取入库详情
        return null;
    }

    @Cacheable(value = "stockRecord", key = "'getRecordDetailList'.concat('-').concat(#exportReqVO.operationType)" +
            ".concat('-').concat(#exportReqVO.stockBatchNo)")
    @Override
    public List<StockRecordDetailDO> getRecordDetailList(StockRecordDetailExportReqVO exportReqVO) {
        return recordDetailMapper.selectList(exportReqVO);
    }

    /**
     * 获得库存记录字表-明细列表, 用于连接打印机打印
     *
     * @param printVO 查询条件
     * @return 库存记录字表-明细列表
     */
    public List<StockRecordDetailPrintRespVO> getRecordDetailList(StockRecordDetailPrintVO printVO) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("stock_batch_no",printVO.getStockBatchNo());
        wrapper.eq("operation_type",printVO.getOperationType());
        List<StockRecordDetailDO> list = recordDetailMapper.selectList(wrapper);
        List<StockRecordDetailPrintRespVO> respVOS = list.stream().map(sv -> {
            StockRecordDetailPrintRespVO respVO = new StockRecordDetailPrintRespVO();
            BeanUtils.copyProperties(sv, respVO);
            Long id = Long.valueOf(sv.getDepartmentId());
            CommonResult<DeptRespDTO> dept = deptApi.getDept(id);
            respVO.setDepartmentName(dept.getCheckedData().getName());
            return respVO;
        }).collect(Collectors.toList());
        return respVOS;
    }

    /**
     * 3.7.2.13.修改出/入库记录
     *
     * @param updateReqVO 更新信息
     */
    @CachePut(value = "stockRecord", key = "#updateReqVO.id")
    @Override
    public void updateRecordDetailOutEnter(@Valid StockRecordDetailOutEnterVO updateReqVO) {
        // 查询当前记录是出库还是入库
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id", updateReqVO.getId());
        StockRecordDetailDO detailDO = recordDetailMapper.selectOne(wrapper);

        // 修改数据
        StockRecordDetailDO recordDetailDO = new StockRecordDetailDO();
        BeanUtils.copyProperties(updateReqVO, recordDetailDO);
        recordDetailDO.setId(updateReqVO.getId());
        BeanUtils.copyProperties(updateReqVO, recordDetailDO);
        if(detailDO.getOperationType() == false) { // 入库
            recordDetailDO.setReceiptQuantity(updateReqVO.getDeliveryQuantity());
            recordDetailMapper.updateById(recordDetailDO);
        } else if(detailDO.getOperationType() == true) { // 出库
            recordDetailDO.setDeliveryQuantity(updateReqVO.getDeliveryQuantity());
            recordDetailMapper.updateById(recordDetailDO);
        }
    }

    /**
     * 3.7.2.15.根据出入库id或批次号查询出入库明细
     * @param pageReqVO 分页查询
     * @return
     */
//    @Cacheable(value = "stockRecord", key = "'getRecordDetailPage'.concat('-').concat(#pageReqVO.stockBatchNo)" +
//            ".concat('-').concat(#pageReqVO.operationType).concat('-').concat(#pageReqVO.goodsType)")
    @Override
    public Page<StockRecordDetailDO> getRecordDetailPage(StockRecordDetailPageVO pageReqVO) {
        Page<StockRecordDetailDO> page = new Page(pageReqVO.getPageNo(), pageReqVO.getPageSize());
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("stock_batch_no", pageReqVO.getStockBatchNo());
        wrapper.like(StringUtils.isNotBlank(pageReqVO.getGoodsName()), "goods_name", pageReqVO.getGoodsName());
        wrapper.eq(ObjectUtils.isNotEmpty(pageReqVO.getGoodsType()), "goods_type", pageReqVO.getGoodsType());
        wrapper.eq("operation_type", pageReqVO.getOperationType());
        wrapper.orderByAsc("create_time");
        return recordDetailMapper.selectPage(page, wrapper);
    }

    /**
     * 3.7.2.20.临期时间管理
     * @param pageReqVO 分页查询
     * @return
     */
    @Cacheable(value = "stockRecord", key = "'getRecordDetailPage'.concat('-').concat(#pageReqVO.maxOrmin)" +
            ".concat('-').concat(#pageReqVO.pageNo).concat('-').concat(#pageReqVO.pageSize)")
    @Override
    public Page<StockRecordDetailDO> getRecordDetailPage(StockRecordTempPageVO pageReqVO) {
        Page<StockRecordDetailDO> page = new Page(pageReqVO.getPageNo(), pageReqVO.getPageSize());
        QueryWrapper wrapper = new QueryWrapper();
        if(pageReqVO.getMaxOrmin() > 0) {
            wrapper.lt("temporary_time", new Date());
            wrapper.orderByDesc("temporary_time");
        } else {
            wrapper.gt("temporary_time", new Date());
            wrapper.orderByAsc("temporary_time");
        }
        return recordDetailMapper.selectPage(page, wrapper);
    }
}
