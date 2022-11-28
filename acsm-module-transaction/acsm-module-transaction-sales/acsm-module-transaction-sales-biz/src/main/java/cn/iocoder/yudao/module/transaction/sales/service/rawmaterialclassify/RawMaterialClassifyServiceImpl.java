package cn.iocoder.yudao.module.transaction.sales.service.rawmaterialclassify;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.rawmaterialclassify.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.rawmaterialclassify.RawMaterialClassifyDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.transaction.sales.convert.rawmaterialclassify.RawMaterialClassifyConvert;
import cn.iocoder.yudao.module.transaction.sales.dal.mysql.rawmaterialclassify.RawMaterialClassifyMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.transaction.sales.enums.ErrorCodeConstants.RAW_MATERIAL_CLASSIFY_NOT_EXISTS;

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
        // 插入
        RawMaterialClassifyDO rawMaterialClassify = RawMaterialClassifyConvert.INSTANCE.convert(createReqVO);
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
            throw exception(RAW_MATERIAL_CLASSIFY_NOT_EXISTS);
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

}
