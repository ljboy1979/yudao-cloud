-- 菜单 SQL
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    '采购询价电子管理', '', 2, 0, 1314,
    'quotation', '', 'purchase/quotation/index', 0
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
    '采购询价电子查询', 'purchase:quotation:query', 3, 1, @parentId,
    '', '', '', 0
);
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    '采购询价电子创建', 'purchase:quotation:create', 3, 2, @parentId,
    '', '', '', 0
);
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    '采购询价电子更新', 'purchase:quotation:update', 3, 3, @parentId,
    '', '', '', 0
);
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    '采购询价电子删除', 'purchase:quotation:delete', 3, 4, @parentId,
    '', '', '', 0
);
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    '采购询价电子导出', 'purchase:quotation:export', 3, 5, @parentId,
    '', '', '', 0
);
