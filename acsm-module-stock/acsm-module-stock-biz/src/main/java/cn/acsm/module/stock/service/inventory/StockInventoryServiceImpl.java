package cn.acsm.module.stock.service.inventory;

import cn.acsm.module.purchase.api.loss.dto.LossReqDTO;
import cn.acsm.module.stock.api.inventory.qo.InventoryQO;
import cn.acsm.module.stock.api.inventory.qo.InventoryVirtualQO;
import cn.acsm.module.stock.api.inventory.vo.StockInventoryApiReqVO;
import cn.acsm.module.stock.controller.admin.inventory.vo.*;
import cn.acsm.module.stock.convert.inventory.StockInventoryConvert;
import cn.acsm.module.stock.dal.dataobject.inventory.StockInventoryDO;
import cn.acsm.module.stock.dal.mysql.inventory.StockInventoryMapper;
import cn.acsm.module.stock.feign.LossApiFeignClient;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.stock.enums.ErrorCodeConstants.INVENTORY_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 库存清单 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
@Transactional
public class StockInventoryServiceImpl implements StockInventoryService {

    @Resource
    private StockInventoryMapper inventoryMapper;

    @Resource
    private LossApiFeignClient lossApiFeignClient;

    @Override
    public String createInventory(StockInventoryCreateReqVO createReqVO) {
        // 插入
        StockInventoryDO inventory = StockInventoryConvert.INSTANCE.convert(createReqVO);
        inventoryMapper.insert(inventory);
        // 返回
        return inventory.getId();
    }

    @Override
    public void updateInventory(StockInventoryUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateInventoryExists(updateReqVO.getId());
        // 更新
        StockInventoryDO updateObj = StockInventoryConvert.INSTANCE.convert(updateReqVO);
        inventoryMapper.updateById(updateObj);
    }

    @Override
    public void deleteInventory(String id) {
        // 校验存在
        this.validateInventoryExists(id);
        // 删除
        inventoryMapper.deleteById(id);
    }

    private void validateInventoryExists(String id) {
        if (inventoryMapper.selectById(id) == null) {
            throw exception(INVENTORY_NOT_EXISTS);
        }
    }

    @Override
    public StockInventoryDO getInventory(String id) {
        return inventoryMapper.selectById(id);
    }

    @Override
    public List<StockInventoryDO> getInventoryList(Collection<String> ids) {
        return inventoryMapper.selectBatchIds(ids);
    }

    @Override
    public Page<StockInventoryDO> getInventoryPage(StockInventoryPageReqVO pageReqVO) {
        Page<StockInventoryDO> page = new Page<>(pageReqVO.getPageNo(), pageReqVO.getPageSize());
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq(ObjectUtils.isNotEmpty(pageReqVO.getType()), "type", pageReqVO.getType());
        wrapper.like(ObjectUtils.isNotEmpty(pageReqVO.getGoodsName()), "goodsName", pageReqVO.getGoodsName());
        return inventoryMapper.selectPage(page, wrapper);
    }

    @Override
    public List<StockInventoryDO> getInventoryList(StockInventoryExportReqVO exportReqVO) {
        return inventoryMapper.selectList(exportReqVO);
    }

    /**
     * 3.7.2.6.更新库存量
     *
     * @param updateReqVO 更新信息
     */
    public void updateInventoryCount(@Valid StockInventoryUpdateCountVO updateReqVO) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("warehouse_id", updateReqVO.getWarehouseId());
        wrapper.eq("goods_id", updateReqVO.getGoodsId());
        wrapper.eq(StringUtils.isNotBlank(updateReqVO.getPackagingSpecificationId()),"packaging_specification_id", updateReqVO.getPackagingSpecificationId());
        wrapper.eq(StringUtils.isNotBlank(updateReqVO.getPackingSpecification()),"packing_specification", updateReqVO.getPackingSpecification());
        StockInventoryDO aDo = inventoryMapper.selectOne(wrapper);
        // 如果库存清单为空，则直接创建库存清单记录
        if(ObjectUtils.isEmpty(aDo)) {
            StockInventoryDO inventoryDO = new StockInventoryDO();
            BeanUtils.copyProperties(updateReqVO, inventoryDO);
            inventoryDO.setVirtualInventory(updateReqVO.getInventoryQuantity());
            inventoryDO.setGoodsName("此处需远程调用获取商品名称");
            inventoryMapper.insert(inventoryDO);
        } else { // 反之则更新记录【库存数量 = 已有库存+传参数量】
            UpdateWrapper updateWrapper = new UpdateWrapper();
            updateWrapper.eq("warehouse_id", updateReqVO.getWarehouseId());
            updateWrapper.eq("goods_id", updateReqVO.getGoodsId());
            updateWrapper.eq(StringUtils.isNotBlank(updateReqVO.getPackagingSpecificationId()), "packaging_specification_id", updateReqVO.getPackagingSpecificationId());
            updateWrapper.eq(StringUtils.isNotBlank(updateReqVO.getPackingSpecification()), "packing_specification", updateReqVO.getPackingSpecification());
            StockInventoryDO inventoryDO = new StockInventoryDO();
            inventoryDO.setInventoryQuantity(aDo.getInventoryQuantity() + updateReqVO.getInventoryQuantity());
            // 更新虚拟库存数量【“虚拟库存量”=“虚拟库存量”-出库数量】
            inventoryDO.setVirtualInventory(aDo.getVirtualInventory() + updateReqVO.getInventoryQuantity());
            inventoryMapper.update(inventoryDO, updateWrapper);
        }
    }

    /**
     * 3.7.2.8.报损
     * @param reportingVO 更新信息
     */
    public void lossReporting(@Valid StockLossReportingVO reportingVO) {
        LossReqDTO reqDTO = new LossReqDTO();
        BeanUtils.copyProperties(reportingVO, reqDTO);
        // 创建报损数据
        lossApiFeignClient.saveLossDto(reqDTO);

        // 查询库存量
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("warehouse_id", reportingVO.getWarehouseId());
        wrapper.eq("goods_id", reportingVO.getGoodsId());
        wrapper.eq("packing_specification", reportingVO.getPackingSpecification());
        StockInventoryDO aDo = inventoryMapper.selectOne(wrapper);

        // 更新库存
        StockInventoryUpdateCountVO countVO = new StockInventoryUpdateCountVO();
        countVO.setGoodsId(reportingVO.getGoodsId().toString());
        countVO.setPackingSpecification(reportingVO.getPackingSpecification());
        countVO.setInventoryQuantity(ObjectUtils.isNotEmpty(aDo) ? aDo.getInventoryQuantity() - reportingVO.getLossCount() : - reportingVO.getLossCount());
        countVO.setWarehouseId(reportingVO.getWarehouseId());
        updateInventoryCount(countVO);
    }

    //    --------------- 远程调用接口 ---------------
    /**
     * 根据条件获得库存清单列表
     * @param apiReqVO 查询条件
     * @return 库存清单列表
     */
    public StockInventoryApiReqVO getInventory(InventoryQO apiReqVO) {
        return inventoryMapper.getList(apiReqVO);
    }

    /**
     * 获取库存清单数据
     *
     * @param packagingSpecificationId
     * @return 编号
     */
    public StockInventoryApiReqVO getInventorysBySpId(String packagingSpecificationId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("packaging_specification_id", packagingSpecificationId);
        StockInventoryDO inventoryDO = inventoryMapper.selectOne(wrapper);
        StockInventoryApiReqVO vo = new StockInventoryApiReqVO();
        BeanUtils.copyProperties(inventoryDO, vo);
        return vo;
    }

    /**
     * 根据规格id修改虚拟库存量
     * @param qo
     */
    public Boolean updateInventorys(InventoryVirtualQO qo) {
        // 获取具体虚拟库存量
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("packaging_specification_id", qo.getPackagingSpecificatioId());
        StockInventoryDO inventoryDO = inventoryMapper.selectOne(wrapper);

        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("packaging_specification_id", qo.getPackagingSpecificatioId());
        StockInventoryDO inventoryDO1 = new StockInventoryDO();
        inventoryDO1.setVirtualInventory(ObjectUtils.isNotEmpty(inventoryDO.getVirtualInventory()) ? inventoryDO.getVirtualInventory() + qo.getVirtualInventory() : inventoryDO.getVirtualInventory());
        return true;
    }
}
