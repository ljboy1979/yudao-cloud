package cn.iocoder.yudao.module.transaction.sales.service.inputsinfo;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.inputsinfo.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.inputsinfo.InputsInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.transaction.sales.convert.inputsinfo.InputsInfoConvert;
import cn.iocoder.yudao.module.transaction.sales.dal.mysql.inputsinfo.InputsInfoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.transaction.sales.enums.ErrorCodeConstants.INPUTS_INFO_NOT_EXISTS;

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

    @Override
    public String createInputsInfo(InputsInfoCreateReqVO createReqVO) {
        // 插入
        InputsInfoDO inputsInfo = InputsInfoConvert.INSTANCE.convert(createReqVO);
        inputsInfoMapper.insert(inputsInfo);
        // 返回
        return inputsInfo.getId();
    }

    @Override
    public void updateInputsInfo(InputsInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateInputsInfoExists(updateReqVO.getId());
        // 更新
        InputsInfoDO updateObj = InputsInfoConvert.INSTANCE.convert(updateReqVO);
        inputsInfoMapper.updateById(updateObj);
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
            throw exception(INPUTS_INFO_NOT_EXISTS);
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
