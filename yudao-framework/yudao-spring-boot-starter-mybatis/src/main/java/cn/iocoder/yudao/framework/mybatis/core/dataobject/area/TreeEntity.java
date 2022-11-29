package cn.iocoder.yudao.framework.mybatis.core.dataobject.area;

import com.baomidou.mybatisplus.annotation.TableField;
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
public class TreeEntity<T>
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
    @TableField(exist = false)
    private String ancestors;

    /** 子部门 */
    @TableField(exist = false)
    //    @TableField(typeHandler = Json) 用json序列化后存在数据库
    private List<T> children = new ArrayList<>();
}
