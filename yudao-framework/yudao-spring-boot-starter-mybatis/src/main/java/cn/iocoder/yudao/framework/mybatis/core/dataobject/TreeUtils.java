package cn.iocoder.yudao.framework.mybatis.core.dataobject;

import cn.iocoder.yudao.framework.common.util.collection.CollectionUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 树状结构工具类
 *
 * @author enkidu66
 */
public class TreeUtils {
    /**
     * 构建前端所需要下拉树结构
     *
     * @param list 列表
     * @return 树结构列表
     */
//    public static <T extends TreeEntity<T>> List<TreeSelect> buildTreeSelect(List<T> list) {
//        List<T> trees = buildTree(list);
//        return trees.stream().map((Function<T, TreeSelect>) TreeSelect::new).collect(Collectors.toList());
//    }

    /**
     * 构建前端所需要树列表
     *
     * @param list 列表
     * @return 树结构列表
     */
//    public static <T extends TreeEntity<T>> List<T> buildTree(List<T> list) {
//        List<T> returnList = new ArrayList<>();
//        List<Long> tempList = new ArrayList<>();
//        for (T t : list) {
//            tempList.add(t.getId());
//        }
//        for (T t : list) {
//            // 如果是顶级节点, 遍历该父节点的所有子节点
//            if (!tempList.contains(t.getParentId())) {
//                recursionFn(list, t);
//                returnList.add(t);
//            }
//        }
//        if (returnList.isEmpty()) {
//            returnList = list;
//        }
//        return returnList;
//    }

    /**
     * 构建前端所需要指定节点的下拉树结构
     *
     * @param list 列表
     * @param id   节点ID
     * @return 树结构列表
     */
    public static <T extends TreeEntity<T>> List<TreeSelect> buildTreeSelect(List<T> list, Long id) {
        List<T> trees = buildTree(list, id);
        return trees.stream().map((Function<T, TreeSelect>) TreeSelect::new).collect(Collectors.toList());
    }

    /**
     * 构建前端所需要树结构，获取指定节点的树列表
     *
     * @param list 列表
     * @param id   节点ID
     * @return 树结构列表
     */
    public static <T extends TreeEntity<T>> List<T> buildTree(List<T> list, Long id) {
        List<T> returnList = new ArrayList<>();
        for (T t : list) {
            // 如果是指定节点, 遍历该父节点的所有子节点
            if (t.getId().equals(id)) {
                recursionFn(list, t);
                returnList.add(t);
                break;
            }
        }
        if (returnList.isEmpty()) {
            returnList = list;
        }
        return returnList;
    }

    public static <T extends TreeEntity<T>> List<TreeSelect> buildTreeSelect(List<T> list) {
        List<T> trees = buildTree(list);
        return trees.stream().map((Function<T, TreeSelect>) TreeSelect::new).collect(Collectors.toList());
    }

    public static <T extends TreeEntity<T>> List<T>  buildTree(List<T> list) {
        // 排序，保证树的有序性
        list.sort(Comparator.comparing(T::getSort));
        // 构建树
        // 使用 LinkedHashMap 的原因，是为了排序 。实际也可以用 Stream API ，就是太丑了。
        Map<Long, T> treeNodeMap = new LinkedHashMap<>();
        list.forEach(t -> treeNodeMap.put(t.getId(), t));
        // 处理父子关系
        treeNodeMap.values().stream().filter(node -> !node.getParentId().equals(0L)).//not root node
                forEach(childNode -> {
            // 获得父节点
            T parentNode = treeNodeMap.get(childNode.getParentId());
            if (parentNode == null) {
//                LoggerFactory.getLogger(getClass()).error("[buildRouterTree][resource({}) 找不到父资源({})]",
//                        childNode.getId(), childNode.getParentId());
                return;
            }
            // 将自己添加到父节点中
            if (parentNode.getChildren() == null) {
                parentNode.setChildren(new ArrayList<>());
            }
            parentNode.getChildren().add(childNode);
        });
        // 获得到所有的根节点
        return CollectionUtils.filterList(treeNodeMap.values(), node -> new Long(0).equals(node.getParentId()));
    }
    /**
     * 获取指定节点和其所有子节点和叶子节点的列表
     *
     * @param list 列表
     * @param id   节点ID
     * @return 列表
     */
    public static <T extends TreeEntity<T>> List<T> buildList(List<T> list, Long id) {
        List<T> returnList = new ArrayList<>();
        for (T t : list) {
            // 如果是指定节点, 将其添加到返回值, 并遍历该父节点的所有子节点
            if (t.getId().equals(id)) {
                returnList.add(t);
                recursionFn(list, t, returnList);
                break;
            }
        }
        return returnList;
    }

    /**
     * 递归列表
     */
    private static <T extends TreeEntity<T>> void recursionFn(List<T> list, T t) {
        // 得到子节点列表
        List<T> childList = getChildList(list, t);
        t.setChildren(childList);
        for (T tChild : childList) {
            if (hasChild(list, tChild)) {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 递归列表并统计
     */
    private static <T extends TreeEntity<T>> void recursionFn(List<T> list, T t, List<T> returnList) {
        // 得到子节点列表
        List<T> childList = getChildList(list, t);
        returnList.addAll(childList);
        for (T tChild : childList) {
            if (hasChild(list, tChild)) {
                recursionFn(list, tChild, returnList);
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private static <T extends TreeEntity<T>> List<T> getChildList(List<T> list, T t) {
        List<T> childList = new ArrayList<>();
        for (T n : list) {
            if ( n.getParentId() != null && n.getParentId().longValue() == t.getId().longValue()) {
                childList.add(n);
            }
        }
        return childList;
    }

    /**
     * 判断是否有子节点
     */
    private static <T extends TreeEntity<T>> boolean hasChild(List<T> list, T t) {
        return getChildList(list, t).size() > 0;
    }

}

