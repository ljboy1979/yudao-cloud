-- 菜单 SQL
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    '服务资源-认养物/租凭物就医记录管理', '', 2, 0, 1446,
    'adopt-content-health', '', 'service/adoptContentHealth/index', 0
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
    '服务资源-认养物/租凭物就医记录查询', 'service:adopt-content-health:query', 3, 1, @parentId,
    '', '', '', 0
);
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    '服务资源-认养物/租凭物就医记录创建', 'service:adopt-content-health:create', 3, 2, @parentId,
    '', '', '', 0
);
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    '服务资源-认养物/租凭物就医记录更新', 'service:adopt-content-health:update', 3, 3, @parentId,
    '', '', '', 0
);
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    '服务资源-认养物/租凭物就医记录删除', 'service:adopt-content-health:delete', 3, 4, @parentId,
    '', '', '', 0
);
INSERT INTO system_menu(
    name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    '服务资源-认养物/租凭物就医记录导出', 'service:adopt-content-health:export', 3, 5, @parentId,
    '', '', '', 0
);
