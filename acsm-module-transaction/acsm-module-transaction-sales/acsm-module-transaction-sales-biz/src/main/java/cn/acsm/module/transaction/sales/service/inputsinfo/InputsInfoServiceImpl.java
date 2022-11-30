package cn.acsm.module.transaction.sales.service.inputsinfo;

import cn.acsm.module.transaction.sales.enums.ErrorCodeConstants;
import cn.acsm.module.transaction.sales.util.ConfigNumberUtil;
import cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.sales.controller.admin.inputsinfo.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.inputsinfo.InputsInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.sales.convert.inputsinfo.InputsInfoConvert;
import cn.acsm.module.transaction.sales.dal.mysql.inputsinfo.InputsInfoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.INPUTS_INFO_NOT_EXISTS;

/**
 * 投入品 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class InputsInfoServiceImpl implements InputsInfoService {

    @Resource
    private InputsInfoMapper inputsInfoMapper;
    @Resource
    private ConfigNumberUtil configNumberUtil;
    @Override
    public CommonResult<String> createInputsInfo(InputsInfoCreateReqVO createReqVO) {
        InputsInfoDO inputsInfoDO = new InputsInfoDO();
        inputsInfoDO.setInputsName(createReqVO.getInputsName());
        inputsInfoDO.setInputsKind(createReqVO.getInputsKind());
        Long num = inputsInfoMapper.findSelectCount(inputsInfoDO);
        if (num!=null && num>0 ){
            return CommonResult.error(ErrorCodeConstants.INPUTS_INFO_EXISTENCE);
        }
        Long tenantId = SecurityFrameworkUtils.getLoginUser().getTenantId();
        String number = configNumberUtil.getNumber("sales_inputs_info"+tenantId);
        // 插入
        InputsInfoDO inputsInfo = InputsInfoConvert.INSTANCE.convert(createReqVO);
        inputsInfo.setInputsCode("TRP"+number);
        inputsInfo.setId(UUID.randomUUID().toString());
        inputsInfoMapper.insert(inputsInfo);
        // 返回
        return CommonResult.success(inputsInfo.getId());
    }

    @Override
    public CommonResult<String> updateInputsInfo(InputsInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateInputsInfoExists(updateReqVO.getId());

        InputsInfoDO inputsInfoDO = new InputsInfoDO();
        inputsInfoDO.setInputsName(updateReqVO.getInputsName());
        inputsInfoDO.setInputsKind(updateReqVO.getInputsKind());
        inputsInfoDO.setId(updateReqVO.getId());
        Long num = inputsInfoMapper.findSelectCount(inputsInfoDO);
        if (num!=null && num>0 ){
            return CommonResult.error(ErrorCodeConstants.INPUTS_INFO_EXISTENCE);
        }
        // 更新
        InputsInfoDO updateObj = InputsInfoConvert.INSTANCE.convert(updateReqVO);
        inputsInfoMapper.updateById(updateObj);
        return CommonResult.success("成功");
    }

    @Override
    public void deleteInputsInfo(String id) {
        // 校验存在
        this.validateInputsInfoExists(id);
        // 删除
        inputsInfoMapper.deleteById(id);
    }

    private void validateInputsInfoExists(String id) {
        if (inputsInfoMapper.selectById(id) == null) {
            throw ServiceExceptionUtil.exception(ErrorCodeConstants.INPUTS_INFO_NOT_EXISTS);
        }
    }

    @Override
    public InputsInfoDO getInputsInfo(String id) {
        return inputsInfoMapper.selectById(id);
    }

    @Override
    public List<InputsInfoDO> getInputsInfoList(Collection<String> ids) {
        return inputsInfoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<InputsInfoDO> getInputsInfoPage(InputsInfoPageReqVO pageReqVO) {
        return inputsInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<InputsInfoDO> getInputsInfoList(InputsInfoExportReqVO exportReqVO) {
        return inputsInfoMapper.selectList(exportReqVO);
    }

}
