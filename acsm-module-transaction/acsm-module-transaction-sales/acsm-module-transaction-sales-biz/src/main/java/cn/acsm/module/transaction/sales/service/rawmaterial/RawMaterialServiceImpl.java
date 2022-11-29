package cn.acsm.module.transaction.sales.service.rawmaterial;

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

    @Override
    public String createRawMaterial(RawMaterialCreateReqVO createReqVO) {
        // 插入
        RawMaterialDO rawMaterial = RawMaterialConvert.INSTANCE.convert(createReqVO);
        rawMaterialMapper.insert(rawMaterial);
        // 返回
        return rawMaterial.getId();
    }

    @Override
    public void updateRawMaterial(RawMaterialUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateRawMaterialExists(updateReqVO.getId());
        // 更新
        RawMaterialDO updateObj = RawMaterialConvert.INSTANCE.convert(updateReqVO);
        rawMaterialMapper.updateById(updateObj);
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

}
