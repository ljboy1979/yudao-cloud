package cn.acsm.module.transaction.sales.service.inputsinfospecification;

import cn.acsm.module.transaction.sales.controller.admin.inputsinfospecification.vo.InputsInfoSpecificationCreateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.inputsinfospecification.vo.InputsInfoSpecificationExportReqVO;
import cn.acsm.module.transaction.sales.controller.admin.inputsinfospecification.vo.InputsInfoSpecificationPageReqVO;
import cn.acsm.module.transaction.sales.controller.admin.inputsinfospecification.vo.InputsInfoSpecificationUpdateReqVO;
import cn.acsm.module.transaction.sales.convert.inputsinfospecification.InputsInfoSpecificationConvert;
import cn.acsm.module.transaction.sales.dal.dataobject.inputsinfospecification.InputsInfoSpecificationDO;
import cn.acsm.module.transaction.sales.dal.mysql.inputsinfospecification.InputsInfoSpecificationMapper;
import cn.acsm.module.transaction.sales.enums.ErrorCodeConstants;
import cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.sales.controller.admin.inputsinfospecification.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.inputsinfospecification.InputsInfoSpecificationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.sales.convert.inputsinfospecification.InputsInfoSpecificationConvert;
import cn.acsm.module.transaction.sales.dal.mysql.inputsinfospecification.InputsInfoSpecificationMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.*;

/**
 * 投入品规格 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class InputsInfoSpecificationServiceImpl implements InputsInfoSpecificationService {

    @Resource
    private InputsInfoSpecificationMapper inputsInfoSpecificationMapper;

    @Override
    public String createInputsInfoSpecification(InputsInfoSpecificationCreateReqVO createReqVO) {
        // 插入
        InputsInfoSpecificationDO inputsInfoSpecification = InputsInfoSpecificationConvert.INSTANCE.convert(createReqVO);
        inputsInfoSpecificationMapper.insert(inputsInfoSpecification);
        // 返回
        return inputsInfoSpecification.getId();
    }

    @Override
    public void updateInputsInfoSpecification(InputsInfoSpecificationUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateInputsInfoSpecificationExists(updateReqVO.getId());
        // 更新
        InputsInfoSpecificationDO updateObj = InputsInfoSpecificationConvert.INSTANCE.convert(updateReqVO);
        inputsInfoSpecificationMapper.updateById(updateObj);
    }

    @Override
    public void deleteInputsInfoSpecification(String id) {
        // 校验存在
        this.validateInputsInfoSpecificationExists(id);
        // 删除
        inputsInfoSpecificationMapper.deleteById(id);
    }

    private void validateInputsInfoSpecificationExists(String id) {
        if (inputsInfoSpecificationMapper.selectById(id) == null) {
            throw ServiceExceptionUtil.exception(ErrorCodeConstants.INPUTS_INFO_SPECIFICATION_NOT_EXISTS);
        }
    }

    @Override
    public InputsInfoSpecificationDO getInputsInfoSpecification(String id) {
        return inputsInfoSpecificationMapper.selectById(id);
    }

    @Override
    public List<InputsInfoSpecificationDO> getInputsInfoSpecificationList(Collection<String> ids) {
        return inputsInfoSpecificationMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<InputsInfoSpecificationDO> getInputsInfoSpecificationPage(InputsInfoSpecificationPageReqVO pageReqVO) {
        return inputsInfoSpecificationMapper.selectPage(pageReqVO);
    }

    @Override
    public List<InputsInfoSpecificationDO> getInputsInfoSpecificationList(InputsInfoSpecificationExportReqVO exportReqVO) {
        return inputsInfoSpecificationMapper.selectList(exportReqVO);
    }

}
