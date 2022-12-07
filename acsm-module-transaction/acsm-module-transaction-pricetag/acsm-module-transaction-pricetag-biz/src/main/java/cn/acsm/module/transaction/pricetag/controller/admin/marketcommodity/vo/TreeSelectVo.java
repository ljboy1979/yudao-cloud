package cn.acsm.module.transaction.pricetag.controller.admin.marketcommodity.vo;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Treeselect树结构实体类
 * 
 * @author ruoyi
 */
public class TreeSelectVo<T> implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 节点ID */
    private Long id;

    /** 节点名称 */
    private String label;

    /** 子节点 */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TreeSelectVo> children;

    public TreeSelectVo()
    {

    }
    public <T extends TreeEntity<T>> TreeSelectVo(T t) {
        this.id = t.getId();
        this.label = t.getName();
        this.children = t.getChildren().stream().map(TreeSelectVo<T>::new).collect(Collectors.toList());
    }

//    public TreeSelect(SysDept dept)
//    {
//        this.id = dept.getDeptId();
//        this.label = dept.getDeptName();
//        this.children = dept.getChildren().stream().map(TreeSelect::new).collect(Collectors.toList());
//    }
//
//    public TreeSelect(SysMenu menu)
//    {
//        this.id = menu.getMenuId();
//        this.label = menu.getMenuName();
//        this.children = menu.getChildren().stream().map(TreeSelect::new).collect(Collectors.toList());
//    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public List<TreeSelectVo> getChildren()
    {
        return children;
    }

    public void setChildren(List<TreeSelectVo> children)
    {
        this.children = children;
    }
}
