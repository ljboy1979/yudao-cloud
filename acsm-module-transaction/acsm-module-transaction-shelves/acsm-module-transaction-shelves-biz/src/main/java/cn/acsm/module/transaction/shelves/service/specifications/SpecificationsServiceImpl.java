package cn.acsm.module.transaction.shelves.service.specifications;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.shelves.controller.admin.specifications.vo.*;
import cn.acsm.module.transaction.shelves.dal.dataobject.specifications.SpecificationsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.shelves.convert.specifications.SpecificationsConvert;
import cn.acsm.module.transaction.shelves.dal.mysql.specifications.SpecificationsMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.shelves.enums.ErrorCodeConstants.*;

/**
 * 货架规格 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class SpecificationsServiceImpl implements SpecificationsService {

    @Resource
    private SpecificationsMapper specificationsMapper;

    @Override
    public String createSpecifications(SpecificationsCreateReqVO createReqVO) {
        // 插入
        SpecificationsDO specifications = SpecificationsConvert.INSTANCE.convert(createReqVO);
        specifications.setId(UUID.randomUUID().toString());

        specificationsMapper.insert(specifications);
        // 返回
        return specifications.getId();
    }

    @Override
    public void updateSpecifications(SpecificationsUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateSpecificationsExists(updateReqVO.getId());
        // 更新
        SpecificationsDO updateObj = SpecificationsConvert.INSTANCE.convert(updateReqVO);
        specificationsMapper.updateById(updateObj);
    }

    @Override
    public void deleteSpecifications(String id) {
        // 校验存在
        this.validateSpecificationsExists(id);
        // 删除
        specificationsMapper.deleteById(id);
    }

    private void validateSpecificationsExists(String id) {
        if (specificationsMapper.selectById(id) == null) {
            throw exception(SPECIFICATIONS_NOT_EXISTS);
        }
    }

    @Override
    public SpecificationsDO getSpecifications(String id) {
        return specificationsMapper.selectById(id);
    }

    @Override
    public List<SpecificationsDO> getSpecificationsList(Collection<String> ids) {
        return specificationsMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<SpecificationsDO> getSpecificationsPage(SpecificationsPageReqVO pageReqVO) {
        return specificationsMapper.selectPage(pageReqVO);
    }

    @Override
    public List<SpecificationsDO> getSpecificationsList(SpecificationsExportReqVO exportReqVO) {
        return specificationsMapper.selectList(exportReqVO);
    }

}
