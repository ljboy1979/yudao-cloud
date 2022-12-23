package cn.acsm.module.transaction.sales.service.commoditycategory;

import cn.acsm.module.transaction.sales.controller.admin.commoditycategory.vo.CommodityCategoryCreateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commoditycategory.vo.CommodityCategoryExportReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commoditycategory.vo.CommodityCategoryPageReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commoditycategory.vo.CommodityCategoryUpdateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.inputclassify.vo.InputClassifyTreeVO;
import cn.acsm.module.transaction.sales.convert.commoditycategory.CommodityCategoryConvert;
import cn.acsm.module.transaction.sales.dal.dataobject.commoditycategory.CommodityCategoryDO;
import cn.acsm.module.transaction.sales.dal.mysql.commoditycategory.CommodityCategoryMapper;
import cn.acsm.module.transaction.sales.enums.ErrorCodeConstants;
import cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeSelect;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import cn.acsm.module.transaction.sales.controller.admin.commoditycategory.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.commoditycategory.CommodityCategoryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.sales.convert.commoditycategory.CommodityCategoryConvert;
import cn.acsm.module.transaction.sales.dal.mysql.commoditycategory.CommodityCategoryMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.COMMODITY_CATEGORY_NOT_EXISTS;

/**
 * 商品分类 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class CommodityCategoryServiceImpl implements CommodityCategoryService {

    @Resource
    private CommodityCategoryMapper commodityCategoryMapper;

    @Override
    public String createCommodityCategory(CommodityCategoryCreateReqVO createReqVO) {
        if (StringUtils.isNotEmpty(createReqVO.getParentCode())) {
            CommodityCategoryDO parenMarketClassify = commodityCategoryMapper.selectById(createReqVO.getParentCode());
            createReqVO.setParentCodes(parenMarketClassify.getParentCodes()+createReqVO.getParentCode()+",");
            createReqVO.setTreeSort(new BigDecimal(0));
            createReqVO.setTreeSorts(parenMarketClassify.getTreeSorts()+"0,");
            createReqVO.setTreeLeaf("0");
            createReqVO.setTreeLevel(parenMarketClassify.getTreeLevel().add(new BigDecimal(1)));
            createReqVO.setTreeNames(parenMarketClassify.getTreeNames()+"/"+createReqVO.getCommodityCategoryName());
        }else {
            createReqVO.setParentCode("0");
            createReqVO.setParentCodes("0,");
            createReqVO.setTreeSort(new BigDecimal(0));
            createReqVO.setTreeSorts("0,");
            createReqVO.setTreeLeaf("0");
            createReqVO.setTreeLevel(new BigDecimal(0));
            createReqVO.setTreeNames(createReqVO.getCommodityCategoryName());
        }
        Integer uuid=UUID.randomUUID().toString().replaceAll("-","").hashCode();
        uuid = uuid < 0 ? -uuid : uuid;
        // 插入
        CommodityCategoryDO commodityCategory = CommodityCategoryConvert.INSTANCE.convert(createReqVO);
        commodityCategory.setId(uuid.toString());
        commodityCategoryMapper.insert(commodityCategory);
        // 返回
        return commodityCategory.getId();
    }

    @Override
    public void updateCommodityCategory(CommodityCategoryUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateCommodityCategoryExists(updateReqVO.getId());
        // 更新
        CommodityCategoryDO updateObj = CommodityCategoryConvert.INSTANCE.convert(updateReqVO);
        commodityCategoryMapper.updateById(updateObj);
    }

    @Override
    public void deleteCommodityCategory(String id) {
        // 校验存在
        this.validateCommodityCategoryExists(id);
        // 删除
        commodityCategoryMapper.deleteById(id);
    }

    private void validateCommodityCategoryExists(String id) {
        if (commodityCategoryMapper.selectById(id) == null) {
            throw ServiceExceptionUtil.exception(ErrorCodeConstants.COMMODITY_CATEGORY_NOT_EXISTS);
        }
    }

    @Override
    public CommodityCategoryDO getCommodityCategory(String id) {
        return commodityCategoryMapper.selectById(id);
    }

    @Override
    public List<CommodityCategoryDO> getCommodityCategoryList(Collection<String> ids) {
        return commodityCategoryMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<CommodityCategoryDO> getCommodityCategoryPage(CommodityCategoryPageReqVO pageReqVO) {
        return commodityCategoryMapper.selectPage(pageReqVO);
    }

    @Override
    public List<CommodityCategoryDO> getCommodityCategoryList(CommodityCategoryExportReqVO exportReqVO) {
        return commodityCategoryMapper.selectList(exportReqVO);
    }

    @Override
    public List<TreeSelect> findTreeList(CommodityCategoryTreeVO commodityCategoryTreeVO) {
        List<CommodityCategoryDO> commodityCategoryDOS = commodityCategoryMapper.selectListToTree(commodityCategoryTreeVO);
        List<CommodityCategoryTreeVO> commodityCategoryTreeVOS = commodityCategoryDOS.stream().map(o -> CommodityCategoryConvert.convertListToTree(o)).collect(Collectors.toList());
        List<TreeSelect> treeSelects = TreeUtils.buildTreeSelect(commodityCategoryTreeVOS);
        return treeSelects;
    }


}
