package cn.iocoder.yudao.module.system.service.area;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.area.vo.AreaCreateReqVO;
import cn.iocoder.yudao.module.system.controller.admin.area.vo.AreaExportReqVO;
import cn.iocoder.yudao.module.system.controller.admin.area.vo.AreaPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.area.vo.AreaUpdateReqVO;
import cn.iocoder.yudao.module.system.convert.area.AreaConvert;
import cn.iocoder.yudao.module.system.dal.dataobject.area.AreaDO;
import cn.iocoder.yudao.module.system.dal.mysql.area.AreaMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.AREA_NOT_EXISTS;

/**
 * 行政区划 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class AreaServiceImpl implements AreaService {

    @Resource
    private AreaMapper areaMapper;

    @Override
    public Long createArea(AreaCreateReqVO createReqVO) {
        // 插入
        AreaDO area = AreaConvert.INSTANCE.convert(createReqVO);
        areaMapper.insert(area);
        // 返回
        return area.getId();
    }

    @Override
    public void updateArea(AreaUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateAreaExists(updateReqVO.getId());
        // 更新
        AreaDO updateObj = AreaConvert.INSTANCE.convert(updateReqVO);
        areaMapper.updateById(updateObj);
    }

    @Override
    public void deleteArea(Long id) {
        // 校验存在
        this.validateAreaExists(id);
        // 删除
        areaMapper.deleteById(id);
    }

    private void validateAreaExists(Long id) {
        if (areaMapper.selectById(id) == null) {
            throw exception(AREA_NOT_EXISTS);
        }
    }

    @Override
    public AreaDO getArea(Long id) {
        return areaMapper.selectById(id);
    }

    @Override
    public List<AreaDO> getAreaList(Collection<String> ids) {
        return areaMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<AreaDO> getAreaPage(AreaPageReqVO pageReqVO) {
        return areaMapper.selectPage(pageReqVO);
    }

    @Override
    public List<AreaDO> getAreaList(AreaExportReqVO exportReqVO) {
        return areaMapper.selectList(exportReqVO);
    }

}
