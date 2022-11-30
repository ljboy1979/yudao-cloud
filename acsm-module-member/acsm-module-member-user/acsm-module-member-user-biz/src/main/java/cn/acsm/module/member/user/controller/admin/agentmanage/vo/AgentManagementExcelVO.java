package cn.acsm.module.member.user.controller.admin.agentmanage.vo;

import lombok.*;

import java.time.LocalDateTime;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 代理商管理 Excel VO
 *
 * @author lihongyan
 */
@Data
public class AgentManagementExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("代理商名称")
    private String agentName;

    @ExcelProperty("代理区域")
    private String agentAera;

    @ExcelProperty("地址")
    private String address;

    @ExcelProperty("手机号")
    private String phone;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
