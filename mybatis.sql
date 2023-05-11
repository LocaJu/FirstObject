/*
 Navicat Premium Data Transfer

 Source Server         : loca
 Source Server Type    : MySQL
 Source Server Version : 80016 (8.0.16)
 Source Host           : localhost:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 80016 (8.0.16)
 File Encoding         : 65001

 Date: 12/05/2023 01:13:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_brand
-- ----------------------------
DROP TABLE IF EXISTS `tb_brand`;
CREATE TABLE `tb_brand`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `company_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ordered` int(11) NULL DEFAULT NULL,
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 124 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_brand
-- ----------------------------
INSERT INTO `tb_brand` VALUES (1, '三只松鼠', '三只松鼠股份有限公司', 5, '好吃不上火', 0);
INSERT INTO `tb_brand` VALUES (2, '华为', '华为技术有限公司', 100, '华为致力于把数字世界带入每个人、每个家庭、每个组织，构建万物互联的智能世界', 1);
INSERT INTO `tb_brand` VALUES (3, '小米', '小米科技有限公司', 50, 'are you ok ', 1);
INSERT INTO `tb_brand` VALUES (8, '格力', '格力', 100, '格力空调一夜一度电', 1);
INSERT INTO `tb_brand` VALUES (17, '联想酷睿', '联想', 200, '联想酷睿', 0);
INSERT INTO `tb_brand` VALUES (18, '三只松鼠', '三只松鼠股份有限公司', 5, '三只松鼠', 1);
INSERT INTO `tb_brand` VALUES (20, '格力', '格力', 100, '格力', 1);
INSERT INTO `tb_brand` VALUES (21, '三只松鼠', '三只松鼠股份有限公司', 5, '三只松鼠', 1);
INSERT INTO `tb_brand` VALUES (49, '鸿星尔克', '鸿星尔克', 10000, 'to be no 1', 1);
INSERT INTO `tb_brand` VALUES (101, '4', '1', 116, '1', 0);
INSERT INTO `tb_brand` VALUES (102, '11', '1', 1, '1', 1);
INSERT INTO `tb_brand` VALUES (103, '1', '1', 11111, '1', 1);
INSERT INTO `tb_brand` VALUES (111, '12626', '1', 12, '122', 0);
INSERT INTO `tb_brand` VALUES (112, 'ccscs', 'sfsfs', 1000, 'ddbd', 1);
INSERT INTO `tb_brand` VALUES (113, '1', '1ss', 111114, '1', 0);
INSERT INTO `tb_brand` VALUES (114, '1', '1', 11111, '1', 0);
INSERT INTO `tb_brand` VALUES (122, 'yzh', '11', 11, '46456', 0);
INSERT INTO `tb_brand` VALUES (123, 'sss', 'sss', 200, 'ss', 0);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `addr` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_tb_user_id`(`id` ASC) USING BTREE,
  UNIQUE INDEX `idx_tb_user_username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'zhangsan', '123', '男', '北京');
INSERT INTO `tb_user` VALUES (2, 'lisi', '234', '女', '天津');
INSERT INTO `tb_user` VALUES (3, 'wangwu', '11', '男', '西安');
INSERT INTO `tb_user` VALUES (4, 'liuqi', '345', NULL, NULL);
INSERT INTO `tb_user` VALUES (13, 'admin', 'geoserver', NULL, NULL);
INSERT INTO `tb_user` VALUES (14, 'adminxx', 'geoserver', NULL, NULL);
INSERT INTO `tb_user` VALUES (15, 'admina', 'geoserver', NULL, NULL);
INSERT INTO `tb_user` VALUES (16, 'adminaa', 'geoserver', NULL, NULL);
INSERT INTO `tb_user` VALUES (17, 'admind', 'geoserver', NULL, NULL);
INSERT INTO `tb_user` VALUES (18, 'admin1', 'geoserver', NULL, NULL);
INSERT INTO `tb_user` VALUES (19, 'jkj', 'geoserver', NULL, NULL);
INSERT INTO `tb_user` VALUES (20, 'adminvv', 'geoserver', NULL, NULL);
INSERT INTO `tb_user` VALUES (21, 'adminvvv', 'geoserver', NULL, NULL);
INSERT INTO `tb_user` VALUES (22, 'adminvvqw', 'geoserver', NULL, NULL);
INSERT INTO `tb_user` VALUES (23, 'adminvvqwf', 'geoserver', NULL, NULL);
INSERT INTO `tb_user` VALUES (24, 'yangzhihegn', '123', NULL, NULL);
INSERT INTO `tb_user` VALUES (25, '666', '666', NULL, NULL);
INSERT INTO `tb_user` VALUES (26, 'kkkkk', 'geoserver', NULL, NULL);
INSERT INTO `tb_user` VALUES (27, '111452', '1111', NULL, NULL);

-- ----------------------------
-- Table structure for tbl_book
-- ----------------------------
DROP TABLE IF EXISTS `tbl_book`;
CREATE TABLE `tbl_book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_book
-- ----------------------------
INSERT INTO `tbl_book` VALUES (2, '7', '7', '7');

SET FOREIGN_KEY_CHECKS = 1;
