package cn.acsm.module.service.service.ticketdetail;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.service.controller.admin.ticketdetail.vo.*;
import cn.acsm.module.service.dal.dataobject.ticketdetail.TicketDetailDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.service.convert.ticketdetail.TicketDetailConvert;
import cn.acsm.module.service.dal.mysql.ticketdetail.TicketDetailMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.service.enums.ErrorCodeConstants.*;

/**
 * 套票详情 Service 实现类
 *
 * @author smile
 */
@Service
@Validated
@Transactional(readOnly = false)
public class TicketDetailServiceImpl implements TicketDetailService {

    @Resource
    private TicketDetailMapper ticketDetailMapper;

    @Override
    public Long createTicketDetail(TicketDetailCreateReqVO createReqVO) {
        // 插入
        TicketDetailDO ticketDetail = TicketDetailConvert.INSTANCE.convert(createReqVO);
        ticketDetailMapper.insert(ticketDetail);
        // 返回
        return ticketDetail.getId();
    }

    @Override
    public void updateTicketDetail(TicketDetailUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateTicketDetailExists(updateReqVO.getId());
        // 更新
        TicketDetailDO updateObj = TicketDetailConvert.INSTANCE.convert(updateReqVO);
        ticketDetailMapper.updateById(updateObj);
    }

    @Override
    public void deleteTicketDetail(Long id) {
        // 校验存在
        this.validateTicketDetailExists(id);
        // 删除
        ticketDetailMapper.deleteById(id);
    }

    private void validateTicketDetailExists(Long id) {
        if (ticketDetailMapper.selectById(id) == null) {
            throw exception(TICKET_DETAIL_NOT_EXISTS);
        }
    }

    @Override
    public TicketDetailDO getTicketDetail(Long id) {
        return ticketDetailMapper.selectById(id);
    }

    @Override
    public List<TicketDetailDO> getTicketDetailList(Collection<Long> ids) {
        return ticketDetailMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<TicketDetailDO> getTicketDetailPage(TicketDetailPageReqVO pageReqVO) {
        return ticketDetailMapper.selectPage(pageReqVO);
    }

    @Override
    public List<TicketDetailDO> getTicketDetailList(TicketDetailExportReqVO exportReqVO) {
        return ticketDetailMapper.selectList(exportReqVO);
    }

}
