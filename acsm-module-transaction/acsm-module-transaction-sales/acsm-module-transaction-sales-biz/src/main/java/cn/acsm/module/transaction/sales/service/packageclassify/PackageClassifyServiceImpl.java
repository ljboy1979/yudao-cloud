package cn.acsm.module.transaction.sales.service.packageclassify;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeSelect;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

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
    public String createPackageClassify(PackageClassifyCreateReqVO createReqVO) {
        // 插入
        PackageClassifyDO packageClassify = PackageClassifyConvert.INSTANCE.convert(createReqVO);
        packageClassifyMapper.insert(packageClassify);
        // 返回
        return packageClassify.getId();
    }

    @Override
    public void updatePackageClassify(PackageClassifyUpdateReqVO updateReqVO) {
        // 校验存在
        this.validatePackageClassifyExists(updateReqVO.getId());
        // 更新
        PackageClassifyDO updateObj = PackageClassifyConvert.INSTANCE.convert(updateReqVO);
        packageClassifyMapper.updateById(updateObj);
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
