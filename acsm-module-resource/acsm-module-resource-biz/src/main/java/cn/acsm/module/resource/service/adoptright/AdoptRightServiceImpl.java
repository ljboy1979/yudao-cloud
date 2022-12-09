package cn.acsm.module.resource.service.adoptright;

import cn.acsm.module.resource.controller.admin.adoptright.vo.*;
import cn.acsm.module.resource.dal.mysql.adoptright.AdoptRightMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.DateUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import cn.acsm.module.resource.dal.dataobject.adoptright.AdoptRightDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.resource.convert.adoptright.AdoptRightConvert;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.resource.enums.ErrorCodeConstants.*;

/**
 * 认养/租凭权益 Service 实现类
 *
 * @author smile
 */
@Service
@Validated
@Transactional(readOnly = false)
public class AdoptRightServiceImpl implements AdoptRightService {

    @Resource
    private AdoptRightMapper adoptRightMapper;

    @Override
    public Long createAdoptRight(AdoptRightCreateReqVO createReqVO) {
        // 插入
        AdoptRightDO adoptRight = AdoptRightConvert.INSTANCE.convert(createReqVO);
        adoptRightMapper.insert(adoptRight);
        // 返回
        return adoptRight.getId();
    }

    @Override
    public void updateAdoptRight(AdoptRightUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateAdoptRightExists(updateReqVO.getId());
        // 更新
        AdoptRightDO updateObj = AdoptRightConvert.INSTANCE.convert(updateReqVO);
        adoptRightMapper.updateById(updateObj);
    }

    @Override
    public void deleteAdoptRight(Long id) {
        // 校验存在
        this.validateAdoptRightExists(id);
        // 删除
        adoptRightMapper.deleteById(id);
    }

    private void validateAdoptRightExists(Long id) {
        if (adoptRightMapper.selectById(id) == null) {
            throw exception(ADOPT_RIGHT_NOT_EXISTS);
        }
    }

    @Override
    public AdoptRightDO getAdoptRight(Long id) {
        return adoptRightMapper.selectById(id);
    }

    @Override
    public List<AdoptRightDO> getAdoptRightList(Collection<Long> ids) {
        return adoptRightMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<AdoptRightDO> getAdoptRightPage(AdoptRightPageReqVO pageReqVO) {
        return adoptRightMapper.selectPage(pageReqVO);
    }

    @Override
    public List<AdoptRightDO> getAdoptRightList(AdoptRightExportReqVO exportReqVO) {
        return adoptRightMapper.selectList(exportReqVO);
    }

    /**
     * 根据权益id 查询到户对应的权益集合
     *
     * @param stringList 权益id 集合
     * @return key 权益id  value 权益实体
     */
    public Map<Long, AdoptRightRespVO> findListByIds(List<String> stringList) {
        if (CollectionUtils.isEmpty(stringList)
                || CollectionUtils.isEmpty(stringList = stringList.stream().filter(StringUtils::isNotBlank).collect(Collectors.toList()))) {
            return Collections.emptyMap();
        }
        List<AdoptRightRespVO> adoptRightList = adoptRightMapper.findListByIds(stringList);
        adoptRightList.stream().parallel().forEach(c -> {
            String incomeItemAmountScale;
            if (StringUtils.isNotBlank(incomeItemAmountScale = c.getIncomeItemAmountScale())) {
                List<Map<String, String>> list = getMaps(incomeItemAmountScale);
                c.setIncomeItemAmountScaleMapList(list);
            }
        });
        if (!CollectionUtils.isEmpty(adoptRightList)) {
            return adoptRightList.stream().filter(Objects::nonNull).collect(Collectors.toMap(AdoptRightRespVO::getId, Function.identity(), (e, r) -> r));
        } else {
            return Collections.emptyMap();
        }
    }
    private List<Map<String, String>> getMaps(String incomeItemAmountScale) {
        final String[] split = incomeItemAmountScale.split(",");
        List<Map<String, String>> list = new ArrayList<>(split.length);
        for (String s : split) {
            if (StringUtils.isNotBlank(s)) {
                HashMap<String, String> map = new HashMap<>(8);
                final String[] split1 = s.split(":");
                map.put("item", split1.length >= 1 ? split1[0] : "");
                map.put("amount", split1.length >= 2 ? split1[1] : "");
                map.put("scale", split1.length >= 3 ? split1[2] : "");
                if (split1.length >= 4 && StringUtils.isNotBlank(split1[3])) {
                    setAdoptRightTime(map, split1[3], "adoptTime");
                }
                if (split1.length >= 5 && StringUtils.isNotBlank(split1[4])) {
                    setAdoptRightTime(map, split1[4], "adoptEndTime");
                }
                list.add(map);
            }
        }
        return list;
    }
    private void setAdoptRightTime(HashMap<String, String> map, String s1, String key) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(Long.parseLong(s1));
        map.put(key, DateUtils.formatDate(instance.getTime(), "yyyy-MM-dd HH:mm:ss"));
    }
}
