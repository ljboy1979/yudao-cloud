-- 菜单 SQL
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    '采购单明细管理', '', 2, 0, 1314,
    'details', '', 'purchase/details/index', 0
);

-- 按钮父菜单ID
-- 暂时只支持 MySQL。如果你是 Oracle、PostgreSQL、SQLServer 的话，需要手动修改 @parentId 的部分的代码
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    '采购单明细查询', 'purchase:details:query', 3, 1, @parentId,
    '', '', '', 0
);
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    '采购单明细创建', 'purchase:details:create', 3, 2, @parentId,
    '', '', '', 0
);
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    '采购单明细更新', 'purchase:details:update', 3, 3, @parentId,
    '', '', '', 0
);
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    '采购单明细删除', 'purchase:details:delete', 3, 4, @parentId,
    '', '', '', 0
);
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    '采购单明细导出', 'purchase:details:export', 3, 5, @parentId,
    '', '', '', 0
);
