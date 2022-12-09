package cn.acsm.module.resource.dal.mysql.adoptcontent;

import java.util.*;

import cn.acsm.module.resource.controller.admin.adoptcontent.vo.AdoptContentExportReqVO;
import cn.acsm.module.resource.controller.admin.adoptcontent.vo.AdoptContentPageReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.resource.dal.dataobject.adoptcontent.AdoptContentDO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Mapper;

/**
 * 认养物/租凭物 Mapper
 *
 * @author smile
 */
@Mapper
public interface AdoptContentMapper extends BaseMapperX<AdoptContentDO> {

    default PageResult<AdoptContentDO> selectPage(AdoptContentPageReqVO reqVO) {
        LambdaQueryWrapper<AdoptContentDO> lambdaQueryWrapper = new LambdaQueryWrapperX<AdoptContentDO>()
                .likeIfPresent(AdoptContentDO::getName, reqVO.getName())
                .eqIfPresent(AdoptContentDO::getType, reqVO.getType())
                .eqIfPresent(AdoptContentDO::getAdoptState, reqVO.getAdoptState())
                .eqIfPresent(AdoptContentDO::getResourceType, reqVO.getResourceType())
                .orderByDesc(AdoptContentDO::getId);
        if(!StringUtils.isEmpty(reqVO.getAdoptIds())){
            lambdaQueryWrapper.inSql(AdoptContentDO::getId, reqVO.getAdoptIds());
        }
        return selectPage(reqVO, lambdaQueryWrapper);

    }

    default List<AdoptContentDO> selectList(AdoptContentExportReqVO reqVO) {
        LambdaQueryWrapperX<AdoptContentDO> lambdaQueryWrapperX = new LambdaQueryWrapperX<AdoptContentDO>()
                .likeIfPresent(AdoptContentDO::getName, reqVO.getName())
                .eqIfPresent(AdoptContentDO::getType, reqVO.getType())
                .eqIfPresent(AdoptContentDO::getAdoptState, reqVO.getAdoptState())
                .orderByDesc(AdoptContentDO::getId);
        if(!StringUtils.isEmpty(reqVO.getAdoptIds())){
            lambdaQueryWrapperX.notInSql(AdoptContentDO::getId, reqVO.getAdoptIds());
        }
        return selectList(lambdaQueryWrapperX);
    }

}
