package cn.iocoder.yudao.framework.mybatis.core.dataobject.area;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Treeselect树结构实体类
 * 
 * @author ruoyi
 */
public class AreaTreeSelect<T> implements Serializable
{
    /** 节点ID */
    private String id;

    /** 节点名称 */
    private String label;

    /** 子节点 */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List< AreaTreeSelect > children;

    public AreaTreeSelect()
    {

    }
    public <T extends AreaTreeEntity<T> > AreaTreeSelect(T t) {
        this.id = t.getId();
        this.label = t.getName();
        this.children = t.getChildren().stream().map(AreaTreeSelect<T>::new).collect(Collectors.toList());
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

    public String getId()
    {
        return id;
    }

    public void setId(String id)
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

    public List< AreaTreeSelect > getChildren()
    {
        return children;
    }

    public void setChildren(List< AreaTreeSelect > children)
    {
        this.children = children;
    }
}
