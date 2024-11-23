
/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : contact

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 27/10/2024 00:59:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `phone` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '123456' COMMENT '电话号码',
  `gender` tinyint(3) UNSIGNED NOT NULL COMMENT '性别, 说明: 1 男, 2 女',
  `isFavorite` int(10) UNSIGNED NULL DEFAULT 0 COMMENT '收藏？ 说明：1是 0否',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '电话表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES (2, '陈善林', '17750269016', 1, 0, '2024-10-26 10:19:16', '2024-10-27 00:58:38');
INSERT INTO `emp` VALUES (3, '张超祥', '13978337237', 1, 1, '2024-10-27 00:51:11', '2024-10-27 00:51:11');
INSERT INTO `emp` VALUES (4, '114514', '114514', 1, 0, '2024-10-27 00:45:14', '2024-10-27 00:45:14');
INSERT INTO `emp` VALUES (5, '11111', '114514', 2, 1, '2024-10-27 00:45:43', '2024-10-27 00:45:43');
INSERT INTO `emp` VALUES (6, '11', '11', 1, 0, '2024-10-27 00:52:36', '2024-10-27 00:52:41');

SET FOREIGN_KEY_CHECKS = 1;

