package cn.iocoder.yudao.module.system.service.area;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.area.vo.*;
import cn.iocoder.yudao.module.system.convert.area.AreaConvert;
import cn.iocoder.yudao.module.system.dal.dataobject.area.AreaDO;
import cn.iocoder.yudao.module.system.dal.mysql.area.AreaMapper;
import cn.iocoder.yudao.module.system.dal.redis.area.AreaRedisDAO;
import cn.iocoder.yudao.module.system.enums.enterprisebaseinfo.AreaEnum;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

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
    @Resource
    private AreaRedisDAO areaRedisDAO;

    private static final String FORMAT_STRING = "0000000000";

    /**
     * tree_sorts字符串前用零补齐   10位
     * @param src 原始字符串
     * @return 补齐后的字符串
     */
    public static String formatWithMakingUp(String src) {
        if (null == src) {
            return null;
        }
        int delta = FORMAT_STRING.length() - src.length();
        if (delta <= 0) {
            return src;
        }
        return FORMAT_STRING.substring(0, delta) + src;
    }

    /**
     * @Description:新增行政区划
     * @param createReqVO
     * @Date: 2022/12/9
     * @author: lihongyan
     * @throws
     * @return:java.lang.Long
     */
    @Override
    public Long createArea(AreaCreateReqVO createReqVO) {
        // 清除缓存
        areaRedisDAO.delete();
        AreaDO existsArea = areaMapper.selectByAreaCode(createReqVO.getAreaCode());
        if(existsArea != null){
            throw exception(AREACODE_ALREADY_EXISTS);
        }
        AreaDO area = AreaConvert.INSTANCE.convert(createReqVO);
        area = getAssemblyArea(area, "1");
        // 插入
        areaMapper.insert(area);
        // 修改父节点TreeLeaf
        updateTreeLeafByParentCode(area.getParentCode());
        // 返回
        return area.getId();
    }
    @Override
    public void updateArea(AreaUpdateReqVO updateReqVO) {
        // 清除缓存
        areaRedisDAO.delete();
        // 校验存在
        this.validateAreaExists(updateReqVO.getId());

        // 判断区域编码是否已存在
        Long num = areaMapper.selectCount4UpdateAreaCode(updateReqVO.getId(),updateReqVO.getAreaCode());
        if (num > 0){
            throw exception(AREACODE_ALREADY_EXISTS);
        }
        // 更新
        AreaDO updateObj = AreaConvert.INSTANCE.convert(updateReqVO);
//        updateObj = getAssemblyArea(updateObj, "2");
        areaMapper.updateById(updateObj);
    }

    /**
     * @Description：
     * @param area
     * @param type 类型 1-新增 2-修改
     * @Date: 2022/12/12
     * @author: lihongyan 
     * @throws
     * @return:cn.iocoder.yudao.module.system.dal.dataobject.area.AreaDO 
     */
    public AreaDO getAssemblyArea (AreaDO area, String type){
        // 查询父级节点
        AreaDO parentArea = areaMapper.selectByAreaCode(area.getParentCode());
        // 拼接treeSorts
        String treeSort = formatWithMakingUp(area.getTreeSort().toString());
        String treeSorts = parentArea.getTreeSorts() + treeSort + ",";
        if ("1".equals(type)){
            area.setTreeLeaf("1"); // 新增默认为最末级
        }
        area.setTreeSorts(treeSorts);
        area.setParentCodes(parentArea.getParentCodes() + area.getParentCode()+ ",");
        area.setTreeNames(area.getTreeNames() + "/" + area.getAreaName());
        // 计算层次级别
        String[] parentCodes = area.getParentCodes().split(",");
        area.setTreeLevel(new BigDecimal(parentCodes.length-1));
        return area;
    }

    @Override
    public void deleteArea(Long id) {
        // 清除缓存
        areaRedisDAO.delete();
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

	@Override
	public List< AreaDO > getAreaTreeList() {
        List< AreaDO > areaDOList = areaRedisDAO.get();
        if(CollectionUtils.isEmpty(areaDOList)){
            areaDOList = areaMapper.selectListToTree();
            areaRedisDAO.set(areaDOList);
        }
        return areaDOList;
	}

    @Override
    public List<AreaDO> getAreaList4Query(AreaListReqVO reqVO) {
        return areaMapper.getAreaList4Query(reqVO);
    }

    @Override
    public void updateStatus(Long id) {
        // 清除缓存
        areaRedisDAO.delete();
        AreaDO areaDO = areaMapper.selectById(id);
        if(AreaEnum.UNUSED.getStatus().equals(areaDO.getStatus())){
            areaDO.setStatus(AreaEnum.NORMAL.getStatus());
        }else if(AreaEnum.NORMAL.getStatus().equals(areaDO.getStatus())){
            areaDO.setStatus(AreaEnum.UNUSED.getStatus());
        }
        areaMapper.updateById(areaDO);
    }

    /**
     * @Description:修改父级是否最末级
     * @param areaCode
     * @Date: 2022/12/9
     * @author: lihongyan
     * @throws
     * @return:void
     */
    public void updateTreeLeafByParentCode(String areaCode) {
        // 清除缓存
        areaRedisDAO.delete();
        AreaDO updateArea = areaMapper.selectByAreaCode(areaCode);
        if(updateArea != null){
            updateArea.setTreeLeaf("0");
            areaMapper.updateById(updateArea);
        }else {
            throw exception(PARENT_NOT_EXISTS);
        }
    }
}
