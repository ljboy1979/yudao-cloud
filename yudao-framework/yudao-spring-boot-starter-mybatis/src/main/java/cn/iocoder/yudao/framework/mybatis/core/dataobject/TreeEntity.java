package cn.iocoder.yudao.framework.mybatis.core.dataobject;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
/**
 * Tree基类
 * 
 * @author ruoyi
 */
public class TreeEntity<T> extends BaseDO
{
    private static final long serialVersionUID = 1L;


    /** 节点ID */
    private Long id;

    /** 节点名称 */
    private String name;

    /** 显示顺序 */
    private Integer sort;

    /** 父菜单名称 */
    private String parentName;

    /** 父菜单ID */
    private Long parentId;

//    /** 显示顺序 */
//    private Integer orderNum;

    /** 祖级列表 */
    @TableField(exist = false)
    private String ancestors;

    /** 子部门 */
    @TableField(exist = false)
    //    @TableField(typeHandler = Json) 用json序列化后存在数据库
    private List<T> children = new ArrayList<>();

//    public String getParentName()
//    {
//        return parentName;
//    }
//
//    public void setParentName(String parentName)
//    {
//        this.parentName = parentName;
//    }
//
//    public Long getParentId()
//    {
//        return parentId;
//    }
//
//    public void setParentId(Long parentId)
//    {
//        this.parentId = parentId;
//    }
//
//    public Integer getOrderNum()
//    {
//        return orderNum;
//    }
//
//    public void setOrderNum(Integer orderNum)
//    {
//        this.orderNum = orderNum;
//    }
//
//    public String getAncestors()
//    {
//        return ancestors;
//    }
//
//    public void setAncestors(String ancestors)
//    {
//        this.ancestors = ancestors;
//    }
//
//    public List<T> getChildren()
//    {
//        return children;
//    }
//
//    public void setChildren(List<T> children)
//    {
//        this.children = children;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getSort() {
//        return sort;
//    }
//
//    public void setSort(Integer sort) {
//        this.sort = sort;
//    }
}
