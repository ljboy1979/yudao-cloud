package cn.acsm.module.transaction.sales.service.inputclassify;

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

import cn.acsm.module.transaction.sales.controller.admin.inputclassify.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.inputclassify.InputClassifyDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.sales.convert.inputclassify.InputClassifyConvert;
import cn.acsm.module.transaction.sales.dal.mysql.inputclassify.InputClassifyMapper;

import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.STOCK_CLASSIFY_OVER_LIMIT;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.INPUT_CLASSIFY_NOT_EXISTS;

/**
 * 投入品分类 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class InputClassifyServiceImpl implements InputClassifyService {

    @Resource
    private InputClassifyMapper inputClassifyMapper;

    @Override
    public CommonResult createInputClassify(InputClassifyCreateReqVO createReqVO) {
        if (StringUtils.isNotEmpty(createReqVO.getParentCode())) {
            InputClassifyDO parenMarketClassify = inputClassifyMapper.selectById(createReqVO.getParentCode());
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
        if (createReqVO.getTreeLevel().compareTo(new BigDecimal(3))==0){
            createReqVO.setTreeLeaf("1");
        }
        Integer uuid=UUID.randomUUID().toString().replaceAll("-","").hashCode();
        uuid = uuid < 0 ? -uuid : uuid;
        // 插入
        InputClassifyDO inputClassify = InputClassifyConvert.INSTANCE.convert(createReqVO);
        inputClassify.setId(uuid.toString());
        inputClassifyMapper.insert(inputClassify);
        // 返回
        return CommonResult.success(inputClassify.getId());
    }

    @Override
    public CommonResult updateInputClassify(InputClassifyUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateInputClassifyExists(updateReqVO.getId());
        if (StringUtils.isNotEmpty(updateReqVO.getParentCode())) {
            InputClassifyDO parenMarketClassify = inputClassifyMapper.selectById(updateReqVO.getParentCode());
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
        if (updateReqVO.getTreeLevel().compareTo(new BigDecimal(3))==0){
            updateReqVO.setTreeLeaf("1");
        }
        // 更新
        InputClassifyDO updateObj = InputClassifyConvert.INSTANCE.convert(updateReqVO);
        inputClassifyMapper.updateById(updateObj);
        return CommonResult.success("成功");
    }

    @Override
    public void deleteInputClassify(String id) {
        // 校验存在
        this.validateInputClassifyExists(id);
        // 删除
        inputClassifyMapper.deleteById(id);
    }

    private void validateInputClassifyExists(String id) {
        if (inputClassifyMapper.selectById(id) == null) {
            throw exception(INPUT_CLASSIFY_NOT_EXISTS);
        }
    }

    @Override
    public InputClassifyDO getInputClassify(String id) {
        return inputClassifyMapper.selectById(id);
    }

    @Override
    public List<InputClassifyDO> getInputClassifyList(Collection<String> ids) {
        return inputClassifyMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<InputClassifyDO> getInputClassifyPage(InputClassifyPageReqVO pageReqVO) {
        if (StringUtils.isEmpty(pageReqVO.getParentCode())){
            pageReqVO.setParentCode("0");
        }else {
            pageReqVO.setPageNo(1);
            pageReqVO.setPageSize(99999);
        }
        return inputClassifyMapper.selectPage(pageReqVO);
    }

    @Override
    public List<InputClassifyDO> getInputClassifyList(InputClassifyExportReqVO exportReqVO) {
        return inputClassifyMapper.selectList(exportReqVO);
    }

    @Override
    public List<TreeSelect> findTreeList(InputClassifyTreeVO inputClassifyTreeVO) {
        List<InputClassifyDO> inputClassifyDOS = inputClassifyMapper.selectListToTree(inputClassifyTreeVO);
        List<InputClassifyTreeVO> inputClassifyTreeVOS = inputClassifyDOS.stream().map(o -> InputClassifyConvert.convertListToTree(o)).collect(Collectors.toList());
        List<TreeSelect> treeSelects = TreeUtils.buildTreeSelect(inputClassifyTreeVOS);
        return treeSelects;
    }

}
