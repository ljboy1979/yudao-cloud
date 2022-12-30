package cn.acsm.module.transaction.sales.service.packageclassify;

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

import cn.acsm.module.transaction.sales.controller.admin.packageclassify.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.packageclassify.PackageClassifyDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.sales.convert.packageclassify.PackageClassifyConvert;
import cn.acsm.module.transaction.sales.dal.mysql.packageclassify.PackageClassifyMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.*;

/**
 * 套餐分类 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class PackageClassifyServiceImpl implements PackageClassifyService {

    @Resource
    private PackageClassifyMapper packageClassifyMapper;

    @Override
    public CommonResult createPackageClassify(PackageClassifyCreateReqVO createReqVO) {
        if (StringUtils.isNotEmpty(createReqVO.getParentCode())) {
            PackageClassifyDO parenMarketClassify = packageClassifyMapper.selectById(createReqVO.getParentCode());
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
        PackageClassifyDO packageClassify = PackageClassifyConvert.INSTANCE.convert(createReqVO);
        packageClassify.setId(uuid.toString());
        packageClassifyMapper.insert(packageClassify);
        // 返回
        return CommonResult.success(packageClassify.getId());
    }

    @Override
    public CommonResult updatePackageClassify(PackageClassifyUpdateReqVO updateReqVO) {
        // 校验存在
        this.validatePackageClassifyExists(updateReqVO.getId());
        if (StringUtils.isNotEmpty(updateReqVO.getParentCode())) {
            PackageClassifyDO parenMarketClassify = packageClassifyMapper.selectById(updateReqVO.getParentCode());
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
        PackageClassifyDO updateObj = PackageClassifyConvert.INSTANCE.convert(updateReqVO);
        packageClassifyMapper.updateById(updateObj);
        return CommonResult.success("成功");
    }

    @Override
    public void deletePackageClassify(String id) {
        // 校验存在
        this.validatePackageClassifyExists(id);
        // 删除
        packageClassifyMapper.deleteById(id);
    }

    private void validatePackageClassifyExists(String id) {
        if (packageClassifyMapper.selectById(id) == null) {
            throw exception(PACKAGE_CLASSIFY_NOT_EXISTS);
        }
    }

    @Override
    public PackageClassifyDO getPackageClassify(String id) {
        return packageClassifyMapper.selectById(id);
    }

    @Override
    public List<PackageClassifyDO> getPackageClassifyList(Collection<String> ids) {
        return packageClassifyMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<PackageClassifyDO> getPackageClassifyPage(PackageClassifyPageReqVO pageReqVO) {
        return packageClassifyMapper.selectPage(pageReqVO);
    }

    @Override
    public List<PackageClassifyDO> getPackageClassifyList(PackageClassifyExportReqVO exportReqVO) {
        return packageClassifyMapper.selectList(exportReqVO);
    }

    @Override
    public List<TreeSelect> findTreeList(PackageClassifyTreeVO packageClassifyTreeVO) {
        List<PackageClassifyDO> rawMaterialClassifyDOS =  packageClassifyMapper.selectListToTree(packageClassifyTreeVO);
        List<PackageClassifyTreeVO> areaTreeVos = rawMaterialClassifyDOS.stream().map(o -> PackageClassifyConvert.convertListToTree(o)).collect(Collectors.toList());
        List<TreeSelect> treeSelects = TreeUtils.buildTreeSelect(areaTreeVos);
        return treeSelects;
    }

}
