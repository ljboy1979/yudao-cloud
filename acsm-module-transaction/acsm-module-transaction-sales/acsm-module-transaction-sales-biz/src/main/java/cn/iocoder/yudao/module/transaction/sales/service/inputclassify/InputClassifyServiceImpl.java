package cn.iocoder.yudao.module.transaction.sales.service.inputclassify;

import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import org.apache.catalina.startup.UserConfig;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.inputclassify.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.inputclassify.InputClassifyDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.transaction.sales.convert.inputclassify.InputClassifyConvert;
import cn.iocoder.yudao.module.transaction.sales.dal.mysql.inputclassify.InputClassifyMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.transaction.sales.enums.ErrorCodeConstants.INPUT_CLASSIFY_NOT_EXISTS;

/**
 * 投入品分类 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class InputClassifyServiceImpl implements InputClassifyService {

    @Resource
    private InputClassifyMapper inputClassifyMapper;

    @Override
    public String createInputClassify(InputClassifyCreateReqVO createReqVO) {
        // 插入
        InputClassifyDO inputClassify = InputClassifyConvert.INSTANCE.convert(createReqVO);
        inputClassifyMapper.insert(inputClassify);
        // 返回
        return inputClassify.getId();
    }

    @Override
    public void updateInputClassify(InputClassifyUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateInputClassifyExists(updateReqVO.getId());
        // 更新
        InputClassifyDO updateObj = InputClassifyConvert.INSTANCE.convert(updateReqVO);
        inputClassifyMapper.updateById(updateObj);
    }

    @Override
    public void deleteInputClassify(String id) {
        // 校验存在
        this.validateInputClassifyExists(id);
        // 删除
        inputClassifyMapper.deleteById(id);
    }

    private void validateInputClassifyExists(String id) {
        if (inputClassifyMapper.selectById(id) == null) {
            throw exception(INPUT_CLASSIFY_NOT_EXISTS);
        }
    }

    @Override
    public InputClassifyDO getInputClassify(String id) {
        return inputClassifyMapper.selectById(id);
    }

    @Override
    public List<InputClassifyDO> getInputClassifyList(Collection<String> ids) {
        return inputClassifyMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<InputClassifyDO> getInputClassifyPage(InputClassifyPageReqVO pageReqVO) {
        return inputClassifyMapper.selectPage(pageReqVO);
    }

    @Override
    public List<InputClassifyDO> getInputClassifyList(InputClassifyExportReqVO exportReqVO) {
        return inputClassifyMapper.selectList(exportReqVO);
    }

}
