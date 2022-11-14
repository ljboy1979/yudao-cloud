/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 14/11/2022 23:32:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '上级分类的编号：0表示一级分类',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '名称',
  `level` tinyint(1) NULL DEFAULT 0 COMMENT '分类级别：0->1级；1->2级',
  `show_status` tinyint(1) NULL DEFAULT 0 COMMENT '显示状态：0->不显示；1->显示',
  `sort` int(11) NULL DEFAULT 0 COMMENT '排序',
  `icon` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '图标',
  `description` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '描述',
  `parent_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '父菜单名称',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序2',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建者',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新者',
  `deleted` bit(1) NULL DEFAULT NULL COMMENT '删除标志0-不删除1-删除',
  `tenant_id` bigint(20) NULL DEFAULT NULL COMMENT '租户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品分类表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES (1, 0, '精选鞋服', 0, 1, 10, NULL, '鞋服', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL);
INSERT INTO `product_category` VALUES (2, 1, '男鞋新品', 1, 1, 20, NULL, '男鞋', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL);
INSERT INTO `product_category` VALUES (3, 1, '女鞋新品', 1, 1, 30, NULL, '女鞋', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL);
INSERT INTO `product_category` VALUES (4, 0, '家电数码', 0, 1, 20, NULL, '数码', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL);
INSERT INTO `product_category` VALUES (5, 4, '电子产品', 1, 1, 10, NULL, '电子', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL);

-- ----------------------------
-- Table structure for sku_package_search
-- ----------------------------
DROP TABLE IF EXISTS `sku_package_search`;
CREATE TABLE `sku_package_search`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `title` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '搜索内容',
  `source` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '来源',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态（0正常 1停用）',
  `creator` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '搜索内容表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sku_package_search
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
