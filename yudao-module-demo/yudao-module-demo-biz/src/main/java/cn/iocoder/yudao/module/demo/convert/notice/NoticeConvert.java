package cn.iocoder.yudao.module.demo.convert.notice;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.demo.controller.admin.notice.vo.NoticeCreateReqVO;
import cn.iocoder.yudao.module.demo.controller.admin.notice.vo.NoticeRespVO;
import cn.iocoder.yudao.module.demo.controller.admin.notice.vo.NoticeUpdateReqVO;
import cn.iocoder.yudao.module.demo.dal.dataobject.notice.NoticeDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NoticeConvert {

    NoticeConvert INSTANCE = Mappers.getMapper(NoticeConvert.class);

    PageResult<NoticeRespVO> convertPage(PageResult<NoticeDO> page);

    NoticeRespVO convert(NoticeDO bean);

    NoticeDO convert(NoticeUpdateReqVO bean);

    NoticeDO convert(NoticeCreateReqVO bean);

}
