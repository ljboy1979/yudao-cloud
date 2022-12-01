package cn.acsm.module.transaction.sales.service.rawmaterialspecification;

import cn.acsm.module.transaction.sales.controller.admin.rawmaterialspecification.vo.RawMaterialSpecificationCreateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.rawmaterialspecification.vo.RawMaterialSpecificationExportReqVO;
import cn.acsm.module.transaction.sales.controller.admin.rawmaterialspecification.vo.RawMaterialSpecificationPageReqVO;
import cn.acsm.module.transaction.sales.controller.admin.rawmaterialspecification.vo.RawMaterialSpecificationUpdateReqVO;
import cn.acsm.module.transaction.sales.convert.rawmaterialspecification.RawMaterialSpecificationConvert;
import cn.acsm.module.transaction.sales.dal.dataobject.rawmaterialspecification.RawMaterialSpecificationDO;
import cn.acsm.module.transaction.sales.enums.ErrorCodeConstants;
import cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.sales.controller.admin.rawmaterialspecification.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.rawmaterialspecification.RawMaterialSpecificationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.sales.convert.rawmaterialspecification.RawMaterialSpecificationConvert;
import cn.acsm.module.transaction.sales.dal.mysql.rawmaterialspecification.RawMaterialSpecificationMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.*;

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
    public CommonResult<String> createRawMaterialSpecification(RawMaterialSpecificationCreateReqVO createReqVO) {
        RawMaterialSpecificationDO rawMaterialSpecificationDO = new RawMaterialSpecificationDO();
        rawMaterialSpecificationDO.setSpecificationsName(createReqVO.getSpecificationsName());
        rawMaterialSpecificationDO.setRawMaterialId(createReqVO.getRawMaterialId());
        Long num = rawMaterialSpecificationMapper.findSelectCount(rawMaterialSpecificationDO);
        if (num!=null && num>0){
            return CommonResult.error(ErrorCodeConstants.RAW_MATERIAL_SPECIFICATION_EXISTENCE);
        }
        // 插入
        RawMaterialSpecificationDO rawMaterialSpecification = RawMaterialSpecificationConvert.INSTANCE.convert(createReqVO);
        rawMaterialSpecification.setId(UUID.randomUUID().toString());
        rawMaterialSpecificationMapper.insert(rawMaterialSpecification);
        // 返回
        return CommonResult.success(rawMaterialSpecification.getId());
    }

    @Override
    public CommonResult<String> updateRawMaterialSpecification(RawMaterialSpecificationUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateRawMaterialSpecificationExists(updateReqVO.getId());

        RawMaterialSpecificationDO rawMaterialSpecificationDO = new RawMaterialSpecificationDO();
        rawMaterialSpecificationDO.setId(updateReqVO.getId());
        rawMaterialSpecificationDO.setSpecificationsName(updateReqVO.getSpecificationsName());
        rawMaterialSpecificationDO.setRawMaterialId(updateReqVO.getRawMaterialId());
        Long num = rawMaterialSpecificationMapper.findSelectCount(rawMaterialSpecificationDO);
        if (num!=null && num>0){
            return CommonResult.error(ErrorCodeConstants.RAW_MATERIAL_SPECIFICATION_EXISTENCE);
        }

        // 更新
        RawMaterialSpecificationDO updateObj = RawMaterialSpecificationConvert.INSTANCE.convert(updateReqVO);
        rawMaterialSpecificationMapper.updateById(updateObj);
        return CommonResult.success("成功");

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
            throw ServiceExceptionUtil.exception(ErrorCodeConstants.RAW_MATERIAL_SPECIFICATION_NOT_EXISTS);
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
