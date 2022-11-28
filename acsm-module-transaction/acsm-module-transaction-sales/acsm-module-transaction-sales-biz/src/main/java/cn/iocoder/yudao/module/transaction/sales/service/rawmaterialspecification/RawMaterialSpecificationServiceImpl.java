package cn.iocoder.yudao.module.transaction.sales.service.rawmaterialspecification;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.rawmaterialspecification.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.rawmaterialspecification.RawMaterialSpecificationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.transaction.sales.convert.rawmaterialspecification.RawMaterialSpecificationConvert;
import cn.iocoder.yudao.module.transaction.sales.dal.mysql.rawmaterialspecification.RawMaterialSpecificationMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.transaction.sales.enums.ErrorCodeConstants.*;

/**
 * 原料规格 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class RawMaterialSpecificationServiceImpl implements RawMaterialSpecificationService {

    @Resource
    private RawMaterialSpecificationMapper rawMaterialSpecificationMapper;

    @Override
    public String createRawMaterialSpecification(RawMaterialSpecificationCreateReqVO createReqVO) {
        // 插入
        RawMaterialSpecificationDO rawMaterialSpecification = RawMaterialSpecificationConvert.INSTANCE.convert(createReqVO);
        rawMaterialSpecificationMapper.insert(rawMaterialSpecification);
        // 返回
        return rawMaterialSpecification.getId();
    }

    @Override
    public void updateRawMaterialSpecification(RawMaterialSpecificationUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateRawMaterialSpecificationExists(updateReqVO.getId());
        // 更新
        RawMaterialSpecificationDO updateObj = RawMaterialSpecificationConvert.INSTANCE.convert(updateReqVO);
        rawMaterialSpecificationMapper.updateById(updateObj);
    }

    @Override
    public void deleteRawMaterialSpecification(String id) {
        // 校验存在
        this.validateRawMaterialSpecificationExists(id);
        // 删除
        rawMaterialSpecificationMapper.deleteById(id);
    }

    private void validateRawMaterialSpecificationExists(String id) {
        if (rawMaterialSpecificationMapper.selectById(id) == null) {
            throw exception(RAW_MATERIAL_SPECIFICATION_NOT_EXISTS);
        }
    }

    @Override
    public RawMaterialSpecificationDO getRawMaterialSpecification(String id) {
        return rawMaterialSpecificationMapper.selectById(id);
    }

    @Override
    public List<RawMaterialSpecificationDO> getRawMaterialSpecificationList(Collection<String> ids) {
        return rawMaterialSpecificationMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<RawMaterialSpecificationDO> getRawMaterialSpecificationPage(RawMaterialSpecificationPageReqVO pageReqVO) {
        return rawMaterialSpecificationMapper.selectPage(pageReqVO);
    }

    @Override
    public List<RawMaterialSpecificationDO> getRawMaterialSpecificationList(RawMaterialSpecificationExportReqVO exportReqVO) {
        return rawMaterialSpecificationMapper.selectList(exportReqVO);
    }

}
