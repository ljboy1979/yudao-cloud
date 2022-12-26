package cn.acsm.module.transaction.sales.service.rawmaterialclassify;

import cn.acsm.module.transaction.sales.dal.dataobject.rawmaterialclassify.RawMaterialClassifyDO;
import cn.acsm.module.transaction.sales.dal.mysql.rawmaterialclassify.RawMaterialClassifyMapper;
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

import cn.acsm.module.transaction.sales.controller.admin.rawmaterialclassify.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.rawmaterialclassify.RawMaterialClassifyDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.sales.convert.rawmaterialclassify.RawMaterialClassifyConvert;
import cn.acsm.module.transaction.sales.dal.mysql.rawmaterialclassify.RawMaterialClassifyMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.RAW_MATERIAL_CLASSIFY_NOT_EXISTS;

/**
 * 原料分类 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class RawMaterialClassifyServiceImpl implements RawMaterialClassifyService {

    @Resource
    private RawMaterialClassifyMapper rawMaterialClassifyMapper;

    @Override
    public String createRawMaterialClassify(RawMaterialClassifyCreateReqVO createReqVO) {
        if (StringUtils.isNotEmpty(createReqVO.getParentCode())) {
            RawMaterialClassifyDO parenMarketClassify = rawMaterialClassifyMapper.selectById(createReqVO.getParentCode());
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
        RawMaterialClassifyDO rawMaterialClassify = RawMaterialClassifyConvert.INSTANCE.convert(createReqVO);
        rawMaterialClassify.setId(uuid.toString());
        rawMaterialClassifyMapper.insert(rawMaterialClassify);
        // 返回
        return rawMaterialClassify.getId();
    }

    @Override
    public void updateRawMaterialClassify(RawMaterialClassifyUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateRawMaterialClassifyExists(updateReqVO.getId());
        // 更新
        RawMaterialClassifyDO updateObj = RawMaterialClassifyConvert.INSTANCE.convert(updateReqVO);
        rawMaterialClassifyMapper.updateById(updateObj);
    }

    @Override
    public void deleteRawMaterialClassify(String id) {
        // 校验存在
        this.validateRawMaterialClassifyExists(id);
        // 删除
        rawMaterialClassifyMapper.deleteById(id);
    }

    private void validateRawMaterialClassifyExists(String id) {
        if (rawMaterialClassifyMapper.selectById(id) == null) {
            throw ServiceExceptionUtil.exception(ErrorCodeConstants.RAW_MATERIAL_CLASSIFY_NOT_EXISTS);
        }
    }

    @Override
    public RawMaterialClassifyDO getRawMaterialClassify(String id) {
        return rawMaterialClassifyMapper.selectById(id);
    }

    @Override
    public List<RawMaterialClassifyDO> getRawMaterialClassifyList(Collection<String> ids) {
        return rawMaterialClassifyMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<RawMaterialClassifyDO> getRawMaterialClassifyPage(RawMaterialClassifyPageReqVO pageReqVO) {
        return rawMaterialClassifyMapper.selectPage(pageReqVO);
    }

    @Override
    public List<RawMaterialClassifyDO> getRawMaterialClassifyList(RawMaterialClassifyExportReqVO exportReqVO) {
        return rawMaterialClassifyMapper.selectList(exportReqVO);
    }

    @Override
    public List<TreeSelect> findTreeList(RawMaterialClassifyTreeVO rawMaterialClassifyTreeVO) {
        List<RawMaterialClassifyDO> rawMaterialClassifyDOS =  rawMaterialClassifyMapper.selectListToTree(rawMaterialClassifyTreeVO);
        List< RawMaterialClassifyTreeVO > areaTreeVos = rawMaterialClassifyDOS.stream().map(o -> RawMaterialClassifyConvert.convertListToTree(o)).collect(Collectors.toList());
        List<TreeSelect> treeSelects = TreeUtils.buildTreeSelect(areaTreeVos);
        return treeSelects;
    }

}
