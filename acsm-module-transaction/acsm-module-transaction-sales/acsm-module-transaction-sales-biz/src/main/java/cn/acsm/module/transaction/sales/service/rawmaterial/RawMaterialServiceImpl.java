package cn.acsm.module.transaction.sales.service.rawmaterial;

import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import cn.acsm.module.transaction.sales.dal.dataobject.shelves.ShelvesSalesRespDo;
import cn.acsm.module.transaction.sales.enums.ErrorCodeConstants;
import cn.acsm.module.transaction.sales.util.ConfigNumberUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.sales.controller.admin.rawmaterial.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.rawmaterial.RawMaterialDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.sales.convert.rawmaterial.RawMaterialConvert;
import cn.acsm.module.transaction.sales.dal.mysql.rawmaterial.RawMaterialMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.*;

/**
 * 原料 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class RawMaterialServiceImpl implements RawMaterialService {

    @Resource
    private RawMaterialMapper rawMaterialMapper;
    @Resource
    private ConfigNumberUtil configNumberUtil;


    @Override
    public CommonResult<String> createRawMaterial(RawMaterialCreateReqVO createReqVO) {
        RawMaterialDO rawMaterialDO = new RawMaterialDO();
        rawMaterialDO.setClassify(createReqVO.getClassify());
        rawMaterialDO.setName(createReqVO.getName());
        Long num = rawMaterialMapper.findSelectCount(rawMaterialDO);
        if (num!=null && num>0){
            return CommonResult.error(ErrorCodeConstants.RAW_MATERIAL_EXISTENCE);
        }
        String number = configNumberUtil.getNumber("sales_raw_material"+SecurityFrameworkUtils.getLoginUser().getTenantId());
        // 插入
        RawMaterialDO rawMaterial = RawMaterialConvert.INSTANCE.convert(createReqVO);
        rawMaterial.setIngredientNumber(number);
        rawMaterial.setId(UUID.randomUUID().toString());
        rawMaterialMapper.insert(rawMaterial);
        // 返回
        return CommonResult.success("成功");
    }

    @Override
    public CommonResult<String> updateRawMaterial(RawMaterialUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateRawMaterialExists(updateReqVO.getId());
        RawMaterialDO rawMaterialDO = new RawMaterialDO();
        rawMaterialDO.setId(updateReqVO.getId());
        rawMaterialDO.setClassify(updateReqVO.getClassify());
        rawMaterialDO.setName(updateReqVO.getName());
        Long num = rawMaterialMapper.findSelectCount(rawMaterialDO);
        if (num!=null && num>0){
            return CommonResult.error(ErrorCodeConstants.RAW_MATERIAL_EXISTENCE);
        }
        // 更新
        RawMaterialDO updateObj = RawMaterialConvert.INSTANCE.convert(updateReqVO);
        rawMaterialMapper.updateById(updateObj);
        return CommonResult.success("成功");

    }

    @Override
    public void deleteRawMaterial(String id) {
        // 校验存在
        this.validateRawMaterialExists(id);
        // 删除
        rawMaterialMapper.deleteById(id);
    }

    private void validateRawMaterialExists(String id) {
        if (rawMaterialMapper.selectById(id) == null) {
            throw exception(RAW_MATERIAL_NOT_EXISTS);
        }
    }

    @Override
    public RawMaterialDO getRawMaterial(String id) {
        return rawMaterialMapper.selectById(id);
    }

    @Override
    public List<RawMaterialDO> getRawMaterialList(Collection<String> ids) {
        return rawMaterialMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<RawMaterialDO> getRawMaterialPage(RawMaterialPageReqVO pageReqVO) {
        return rawMaterialMapper.selectPage(pageReqVO);
    }

    @Override
    public List<RawMaterialDO> getRawMaterialList(RawMaterialExportReqVO exportReqVO) {
        return rawMaterialMapper.selectList(exportReqVO);
    }

    @Override
    public List<RawMaterialDO> findList(RawMaterialReqVO rawMaterialReqVO) {
        return rawMaterialMapper.findList(rawMaterialReqVO);
    }

}
