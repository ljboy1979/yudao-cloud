package cn.acsm.module.transaction.sales.service.dishesspecification;

import cn.acsm.module.transaction.sales.controller.admin.dishesspecification.vo.DishesSpecificationCreateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.dishesspecification.vo.DishesSpecificationExportReqVO;
import cn.acsm.module.transaction.sales.controller.admin.dishesspecification.vo.DishesSpecificationPageReqVO;
import cn.acsm.module.transaction.sales.controller.admin.dishesspecification.vo.DishesSpecificationUpdateReqVO;
import cn.acsm.module.transaction.sales.convert.dishesspecification.DishesSpecificationConvert;
import cn.acsm.module.transaction.sales.dal.dataobject.dishesspecification.DishesSpecificationDO;
import cn.acsm.module.transaction.sales.dal.mysql.dishesspecification.DishesSpecificationMapper;
import cn.acsm.module.transaction.sales.enums.ErrorCodeConstants;
import cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.sales.controller.admin.dishesspecification.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.dishesspecification.DishesSpecificationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.sales.convert.dishesspecification.DishesSpecificationConvert;
import cn.acsm.module.transaction.sales.dal.mysql.dishesspecification.DishesSpecificationMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.*;

/**
 * 菜品规格 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class DishesSpecificationServiceImpl implements DishesSpecificationService {

    @Resource
    private DishesSpecificationMapper dishesSpecificationMapper;

    @Override
    public String createDishesSpecification(DishesSpecificationCreateReqVO createReqVO) {
        // 插入
        DishesSpecificationDO dishesSpecification = DishesSpecificationConvert.INSTANCE.convert(createReqVO);
        dishesSpecification.setId(UUID.randomUUID().toString());
        dishesSpecificationMapper.insert(dishesSpecification);
        // 返回
        return dishesSpecification.getId();
    }

    @Override
    public void updateDishesSpecification(DishesSpecificationUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateDishesSpecificationExists(updateReqVO.getId());
        // 更新
        DishesSpecificationDO updateObj = DishesSpecificationConvert.INSTANCE.convert(updateReqVO);
        dishesSpecificationMapper.updateById(updateObj);
    }

    @Override
    public void deleteDishesSpecification(String id) {
        // 校验存在
        this.validateDishesSpecificationExists(id);
        // 删除
        dishesSpecificationMapper.deleteById(id);
    }

    private void validateDishesSpecificationExists(String id) {
        if (dishesSpecificationMapper.selectById(id) == null) {
            throw ServiceExceptionUtil.exception(ErrorCodeConstants.DISHES_SPECIFICATION_NOT_EXISTS);
        }
    }

    @Override
    public DishesSpecificationDO getDishesSpecification(String id) {
        return dishesSpecificationMapper.selectById(id);
    }

    @Override
    public List<DishesSpecificationDO> getDishesSpecificationList(Collection<String> ids) {
        return dishesSpecificationMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<DishesSpecificationDO> getDishesSpecificationPage(DishesSpecificationPageReqVO pageReqVO) {
        return dishesSpecificationMapper.selectPage(pageReqVO);
    }

    @Override
    public List<DishesSpecificationDO> getDishesSpecificationList(DishesSpecificationExportReqVO exportReqVO) {
        return dishesSpecificationMapper.selectList(exportReqVO);
    }

}
