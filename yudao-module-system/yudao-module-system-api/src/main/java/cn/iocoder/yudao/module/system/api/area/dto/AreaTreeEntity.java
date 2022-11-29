package cn.iocoder.yudao.module.system.api.area.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
/**
 * Tree基类
 * 
 * @author ruoyi
 */
public class AreaTreeEntity<T>
{
    /** 节点ID */
    private String id;

    /** 节点名称 */
    private String name;

    /** 显示顺序 */
    private Integer sort;

    /** 父菜单名称 */
    private String parentName;

    /** 父菜单ID */
    private String parentId;

//    /** 显示顺序 */
//    private Integer orderNum;

    /** 祖级列表 */
    private String ancestors;

    /** 子部门 */
    private List<T> children = new ArrayList<>();
}
