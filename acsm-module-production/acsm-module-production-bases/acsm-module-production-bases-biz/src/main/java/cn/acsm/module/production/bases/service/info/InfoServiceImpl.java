package cn.acsm.module.production.bases.service.info;

import cn.acsm.module.production.bases.controller.admin.info.vo.InfoCreateReqVO;
import cn.acsm.module.production.bases.controller.admin.info.vo.InfoExportReqVO;
import cn.acsm.module.production.bases.controller.admin.info.vo.InfoPageReqVO;
import cn.acsm.module.production.bases.controller.admin.info.vo.InfoUpdateReqVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.production.bases.controller.admin.info.vo.*;
import cn.acsm.module.production.bases.dal.dataobject.info.InfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.production.bases.convert.info.InfoConvert;
import cn.acsm.module.production.bases.dal.mysql.info.InfoMapper;

import static cn.acsm.module.production.bases.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 基地信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class InfoServiceImpl implements InfoService {

    @Resource
    private InfoMapper infoMapper;

    @Override
    public Long createInfo(InfoCreateReqVO createReqVO) {
        // 插入
        InfoDO info = InfoConvert.INSTANCE.convert(createReqVO);
        infoMapper.insert(info);
        // 返回
        return info.getId();
    }

    @Override
    public void updateInfo(InfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateInfoExists(updateReqVO.getId());
        // 更新
        InfoDO updateObj = InfoConvert.INSTANCE.convert(updateReqVO);
        infoMapper.updateById(updateObj);
    }

    @Override
    public void deleteInfo(Long id) {
        // 校验存在
        this.validateInfoExists(id);
        // 删除
        infoMapper.deleteById(id);
    }

    private void validateInfoExists(Long id) {
        if (infoMapper.selectById(id) == null) {
            throw exception(INFO_NOT_EXISTS);
        }
    }

    @Override
    public InfoDO getInfo(Long id) {
        return infoMapper.selectById(id);
    }

    @Override
    public List<InfoDO> getInfoList(Collection<Long> ids) {
        return infoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<InfoDO> getInfoPage(InfoPageReqVO pageReqVO) {
        return infoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<InfoDO> getInfoList(InfoExportReqVO exportReqVO) {
        return infoMapper.selectList(exportReqVO);
    }

}
