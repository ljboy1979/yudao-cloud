package cn.acsm.module.transaction.sales.service.dishescategory;

import cn.acsm.module.transaction.sales.controller.admin.dishescategory.vo.DishesCategoryCreateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.dishescategory.vo.DishesCategoryExportReqVO;
import cn.acsm.module.transaction.sales.controller.admin.dishescategory.vo.DishesCategoryPageReqVO;
import cn.acsm.module.transaction.sales.controller.admin.dishescategory.vo.DishesCategoryUpdateReqVO;
import cn.acsm.module.transaction.sales.convert.dishescategory.DishesCategoryConvert;
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

import cn.acsm.module.transaction.sales.controller.admin.dishescategory.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.dishescategory.DishesCategoryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.sales.convert.dishescategory.DishesCategoryConvert;
import cn.acsm.module.transaction.sales.dal.mysql.dishescategory.DishesCategoryMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.*;

/**
 * 菜品分类 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class DishesCategoryServiceImpl implements DishesCategoryService {

    @Resource
    private DishesCategoryMapper dishesCategoryMapper;

    @Override
    public String createDishesCategory(DishesCategoryCreateReqVO createReqVO) {
        if (StringUtils.isNotEmpty(createReqVO.getParentCode())) {
            DishesCategoryDO parenMarketClassify = dishesCategoryMapper.selectById(createReqVO.getParentCode());
            createReqVO.setParentCodes(parenMarketClassify.getParentCodes()+createReqVO.getParentCode()+",");
            createReqVO.setTreeSort(new BigDecimal(0));
            createReqVO.setTreeSorts(parenMarketClassify.getTreeSorts()+"0,");
            createReqVO.setTreeLeaf("0");
            createReqVO.setTreeLevel(parenMarketClassify.getTreeLevel().add(new BigDecimal(1)));
            createReqVO.setTreeNames(parenMarketClassify.getTreeNames()+"/"+createReqVO.getCategoryName());
        }else {
            createReqVO.setParentCode("0");
            createReqVO.setParentCodes("0,");
            createReqVO.setTreeSort(new BigDecimal(0));
            createReqVO.setTreeSorts("0,");
            createReqVO.setTreeLeaf("0");
            createReqVO.setTreeLevel(new BigDecimal(0));
            createReqVO.setTreeNames(createReqVO.getCategoryName());
        }
        Integer uuid=UUID.randomUUID().toString().replaceAll("-","").hashCode();
        uuid = uuid < 0 ? -uuid : uuid;
        // 插入
        DishesCategoryDO dishesCategory = DishesCategoryConvert.INSTANCE.convert(createReqVO);
        dishesCategory.setId(uuid.toString());
        dishesCategoryMapper.insert(dishesCategory);
        // 返回
        return dishesCategory.getId();
    }

    @Override
    public void updateDishesCategory(DishesCategoryUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateDishesCategoryExists(updateReqVO.getId());
        // 更新
        DishesCategoryDO updateObj = DishesCategoryConvert.INSTANCE.convert(updateReqVO);
        dishesCategoryMapper.updateById(updateObj);
    }

    @Override
    public void deleteDishesCategory(String id) {
        // 校验存在
        this.validateDishesCategoryExists(id);
        // 删除
        dishesCategoryMapper.deleteById(id);
    }

    private void validateDishesCategoryExists(String id) {
        if (dishesCategoryMapper.selectById(id) == null) {
            throw ServiceExceptionUtil.exception(ErrorCodeConstants.DISHES_CATEGORY_NOT_EXISTS);
        }
    }

    @Override
    public DishesCategoryDO getDishesCategory(String id) {
        return dishesCategoryMapper.selectById(id);
    }

    @Override
    public List<DishesCategoryDO> getDishesCategoryList(Collection<String> ids) {
        return dishesCategoryMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<DishesCategoryDO> getDishesCategoryPage(DishesCategoryPageReqVO pageReqVO) {
        return dishesCategoryMapper.selectPage(pageReqVO);
    }

    @Override
    public List<DishesCategoryDO> getDishesCategoryList(DishesCategoryExportReqVO exportReqVO) {
        return dishesCategoryMapper.selectList(exportReqVO);
    }

    @Override
    public List<TreeSelect> findTreeList(DishesCategoryTreeVO dishesCategoryTreeVO) {
        List<DishesCategoryDO> inputClassifyDOS = dishesCategoryMapper.selectListToTree(dishesCategoryTreeVO);
        List<DishesCategoryTreeVO> inputClassifyTreeVOS = inputClassifyDOS.stream().map(o -> DishesCategoryConvert.convertListToTree(o)).collect(Collectors.toList());
        List<TreeSelect> treeSelects = TreeUtils.buildTreeSelect(inputClassifyTreeVOS);
        return treeSelects;
    }

}
