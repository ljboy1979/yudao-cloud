package cn.acsm.module.transaction.shelves.service.stockrecord;

import cn.acsm.module.transaction.shelves.dal.dataobject.shelves.ShelvesDO;
import cn.acsm.module.transaction.shelves.dal.dataobject.specifications.SpecificationsDO;
import cn.acsm.module.transaction.shelves.dal.dataobject.stockrecord.StockRecordInfoDO;
import cn.acsm.module.transaction.shelves.dal.mysql.shelves.ShelvesMapper;
import cn.acsm.module.transaction.shelves.dal.mysql.specifications.SpecificationsMapper;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.*;
import cn.acsm.module.transaction.shelves.controller.admin.stockrecord.vo.*;
import cn.acsm.module.transaction.shelves.dal.dataobject.stockrecord.StockRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.shelves.convert.stockrecord.StockRecordConvert;
import cn.acsm.module.transaction.shelves.dal.mysql.stockrecord.StockRecordMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.shelves.enums.ErrorCodeConstants.*;

/**
 * 货架库存记录 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class StockRecordServiceImpl implements StockRecordService {

    @Resource
    private StockRecordMapper stockRecordMapper;
    @Resource
    private SpecificationsMapper specificationsMapper;
    @Resource
    private ShelvesMapper shelvesMapper;
    @Override
    @Transactional
    public String createStockRecord(StockRecordCreateReqVO createReqVO) {
        //Long tenantId = SecurityFrameworkUtils.getLoginUser().getTenantId();
        // 插入
        StockRecordDO stockRecord = StockRecordConvert.INSTANCE.convert(createReqVO);
        stockRecord.setId(UUID.randomUUID().toString());
        stockRecordMapper.insert(stockRecord);
        SpecificationsDO specificationsDO = specificationsMapper.selectById(createReqVO.getSpecificationsId());
        ShelvesDO shelvesDO = shelvesMapper.selectById(specificationsDO.getShelvesId());

        BigDecimal amount = specificationsDO.getAvailableNum();
        BigDecimal shelvesAmount = shelvesDO.getAvailableNum();
        //类型 0 上架 1下架 2销售 3报损 4退货
        if ("0".equals(createReqVO.getType())){
            amount = amount.add(createReqVO.getAmount());
            shelvesAmount = shelvesAmount.add(createReqVO.getAmount());
        }else if ("1".equals(createReqVO.getType()) || "3".equals(createReqVO.getType())){
            amount = amount.subtract(createReqVO.getAmount());
            shelvesAmount = shelvesAmount.subtract(createReqVO.getAmount());

        }
        specificationsDO.setAvailableNum(amount);
        specificationsMapper.updateById(specificationsDO);
        shelvesDO.setAvailableNum(shelvesAmount);
        //shelvesDO.setCreator()
        shelvesMapper.updateById(shelvesDO);
        // 返回
        return stockRecord.getId();
    }

    @Override
    public void updateStockRecord(StockRecordUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateStockRecordExists(updateReqVO.getId());
        // 更新
        StockRecordDO updateObj = StockRecordConvert.INSTANCE.convert(updateReqVO);
        stockRecordMapper.updateById(updateObj);
    }

    @Override
    public void deleteStockRecord(String id) {
        // 校验存在
        this.validateStockRecordExists(id);
        // 删除
        stockRecordMapper.deleteById(id);
    }

    private void validateStockRecordExists(String id) {
        if (stockRecordMapper.selectById(id) == null) {
            throw exception(STOCK_RECORD_NOT_EXISTS);
        }
    }

    @Override
    public StockRecordDO getStockRecord(String id) {
        return stockRecordMapper.selectById(id);
    }

    @Override
    public List<StockRecordDO> getStockRecordList(Collection<String> ids) {
        return stockRecordMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<StockRecordDO> getStockRecordPage(StockRecordPageReqVO pageReqVO) {
        return stockRecordMapper.selectPage(pageReqVO);
    }

    @Override
    public List<StockRecordDO> getStockRecordList(StockRecordExportReqVO exportReqVO) {
        return stockRecordMapper.selectList(exportReqVO);
    }

    @Override
    public PageResult<StockRecordInfoDO> findStockRecordPage(StockRecordPageReqVO pageVO) {
        PageResult<StockRecordInfoDO> page = new PageResult<>();
        pageVO.setPageNo((pageVO.getPageNo()-1)*pageVO.getPageSize());
        List<StockRecordInfoDO> stockRecordInfoDOS =  stockRecordMapper.findStockRecordList(pageVO);
        page.setList(stockRecordInfoDOS);
        page.setTotal(stockRecordMapper.findStockRecordCount(pageVO));
        return page;
    }

}
