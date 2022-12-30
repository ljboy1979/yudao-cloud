package cn.acsm.module.transaction.sales.service.specialmedicalfoodclassify;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeSelect;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodclassify.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.specialmedicalfoodclassify.SpecialMedicalFoodClassifyDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.sales.convert.specialmedicalfoodclassify.SpecialMedicalFoodClassifyConvert;
import cn.acsm.module.transaction.sales.dal.mysql.specialmedicalfoodclassify.SpecialMedicalFoodClassifyMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.*;

/**
 * 特医食品分类 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class SpecialMedicalFoodClassifyServiceImpl implements SpecialMedicalFoodClassifyService {

    @Resource
    private SpecialMedicalFoodClassifyMapper specialMedicalFoodClassifyMapper;

    @Override
    public CommonResult createSpecialMedicalFoodClassify(SpecialMedicalFoodClassifyCreateReqVO createReqVO) {
        if (StringUtils.isNotEmpty(createReqVO.getParentCode())) {
            SpecialMedicalFoodClassifyDO parenMarketClassify = specialMedicalFoodClassifyMapper.selectById(createReqVO.getParentCode());
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
        if (createReqVO.getTreeLevel().compareTo(new BigDecimal(3))==1){
            return CommonResult.error(STOCK_CLASSIFY_OVER_LIMIT);
        }
        Integer uuid=UUID.randomUUID().toString().replaceAll("-","").hashCode();
        uuid = uuid < 0 ? -uuid : uuid;
        // 插入
        SpecialMedicalFoodClassifyDO specialMedicalFoodClassify = SpecialMedicalFoodClassifyConvert.INSTANCE.convert(createReqVO);
        specialMedicalFoodClassify.setId(uuid.toString());
        specialMedicalFoodClassifyMapper.insert(specialMedicalFoodClassify);
        // 返回
        return CommonResult.success(specialMedicalFoodClassify.getId());
    }

    @Override
    public CommonResult updateSpecialMedicalFoodClassify(SpecialMedicalFoodClassifyUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateSpecialMedicalFoodClassifyExists(updateReqVO.getId());
        if (StringUtils.isNotEmpty(updateReqVO.getParentCode())) {
            SpecialMedicalFoodClassifyDO parenMarketClassify = specialMedicalFoodClassifyMapper.selectById(updateReqVO.getParentCode());
            updateReqVO.setParentCodes(parenMarketClassify.getParentCodes()+updateReqVO.getParentCode()+",");
            updateReqVO.setTreeSort(new BigDecimal(0));
            updateReqVO.setTreeSorts(parenMarketClassify.getTreeSorts()+"0,");
            updateReqVO.setTreeLeaf("0");
            updateReqVO.setTreeLevel(parenMarketClassify.getTreeLevel().add(new BigDecimal(1)));
            updateReqVO.setTreeNames(parenMarketClassify.getTreeNames()+"/"+updateReqVO.getCategoryName());
        }else {
            updateReqVO.setParentCode("0");
            updateReqVO.setParentCodes("0,");
            updateReqVO.setTreeSort(new BigDecimal(0));
            updateReqVO.setTreeSorts("0,");
            updateReqVO.setTreeLeaf("0");
            updateReqVO.setTreeLevel(new BigDecimal(0));
            updateReqVO.setTreeNames(updateReqVO.getCategoryName());
        }
        if (updateReqVO.getTreeLevel().compareTo(new BigDecimal(3))==1){
            return CommonResult.error(STOCK_CLASSIFY_OVER_LIMIT);
        }
        // 更新
        SpecialMedicalFoodClassifyDO updateObj = SpecialMedicalFoodClassifyConvert.INSTANCE.convert(updateReqVO);
        specialMedicalFoodClassifyMapper.updateById(updateObj);
        return CommonResult.success("成功");
    }

    @Override
    public void deleteSpecialMedicalFoodClassify(String id) {
        // 校验存在
        this.validateSpecialMedicalFoodClassifyExists(id);
        // 删除
        specialMedicalFoodClassifyMapper.deleteById(id);
    }

    private void validateSpecialMedicalFoodClassifyExists(String id) {
        if (specialMedicalFoodClassifyMapper.selectById(id) == null) {
            throw exception(SPECIAL_MEDICAL_FOOD_CLASSIFY_NOT_EXISTS);
        }
    }

    @Override
    public SpecialMedicalFoodClassifyDO getSpecialMedicalFoodClassify(String id) {
        return specialMedicalFoodClassifyMapper.selectById(id);
    }

    @Override
    public List<SpecialMedicalFoodClassifyDO> getSpecialMedicalFoodClassifyList(Collection<String> ids) {
        return specialMedicalFoodClassifyMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<SpecialMedicalFoodClassifyDO> getSpecialMedicalFoodClassifyPage(SpecialMedicalFoodClassifyPageReqVO pageReqVO) {
        return specialMedicalFoodClassifyMapper.selectPage(pageReqVO);
    }

    @Override
    public List<SpecialMedicalFoodClassifyDO> getSpecialMedicalFoodClassifyList(SpecialMedicalFoodClassifyExportReqVO exportReqVO) {
        return specialMedicalFoodClassifyMapper.selectList(exportReqVO);
    }

    @Override
    public List<TreeSelect> findTreeList(SpecialMedicalFoodClassifyTreeVO specialMedicalFoodClassifyTreeVO) {
        List<SpecialMedicalFoodClassifyDO> selectListToTree =  specialMedicalFoodClassifyMapper.selectListToTree(specialMedicalFoodClassifyTreeVO);
        List< SpecialMedicalFoodClassifyTreeVO > areaTreeVos = selectListToTree.stream().map(o -> SpecialMedicalFoodClassifyConvert.convertListToTree(o)).collect(Collectors.toList());
        List<TreeSelect> treeSelects = TreeUtils.buildTreeSelect(areaTreeVos);
        return treeSelects;
    }
}
