package cn.acsm.module.transaction.sales.service.nutritionfacts;

import cn.acsm.module.transaction.sales.util.ConfigNumberUtil;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.sales.controller.admin.nutritionfacts.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.nutritionfacts.NutritionFactsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.sales.convert.nutritionfacts.NutritionFactsConvert;
import cn.acsm.module.transaction.sales.dal.mysql.nutritionfacts.NutritionFactsMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.*;

/**
 * 营养成分 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class NutritionFactsServiceImpl implements NutritionFactsService {

    @Resource
    private NutritionFactsMapper nutritionFactsMapper;
    @Resource
    private ConfigNumberUtil configNumberUtil;

    @Override
    public String createNutritionFacts(NutritionFactsCreateReqVO createReqVO) {
        String number = configNumberUtil.getNumber("sales_nutrition_facts"+createReqVO.getType());
        // 插入
        NutritionFactsDO nutritionFacts = NutritionFactsConvert.INSTANCE.convert(createReqVO);
        nutritionFacts.setNumber("YYCF"+number);
        nutritionFacts.setId(UUID.randomUUID().toString());
        nutritionFactsMapper.insert(nutritionFacts);
        // 返回
        return nutritionFacts.getId();
    }

    @Override
    public void updateNutritionFacts(NutritionFactsUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateNutritionFactsExists(updateReqVO.getId());
        // 更新
        NutritionFactsDO updateObj = NutritionFactsConvert.INSTANCE.convert(updateReqVO);
        nutritionFactsMapper.updateById(updateObj);
    }

    @Override
    public void deleteNutritionFacts(String id) {
        // 校验存在
        this.validateNutritionFactsExists(id);
        // 删除
        nutritionFactsMapper.deleteById(id);
    }

    private void validateNutritionFactsExists(String id) {
        if (nutritionFactsMapper.selectById(id) == null) {
            throw exception(NUTRITION_FACTS_NOT_EXISTS);
        }
    }

    @Override
    public NutritionFactsDO getNutritionFacts(String id) {
        return nutritionFactsMapper.selectById(id);
    }

    @Override
    public List<NutritionFactsDO> getNutritionFactsList(Collection<String> ids) {
        return nutritionFactsMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<NutritionFactsDO> getNutritionFactsPage(NutritionFactsPageReqVO pageReqVO) {
        return nutritionFactsMapper.selectPage(pageReqVO);
    }

    @Override
    public List<NutritionFactsDO> getNutritionFactsList(NutritionFactsExportReqVO exportReqVO) {
        return nutritionFactsMapper.selectList(exportReqVO);
    }

}
