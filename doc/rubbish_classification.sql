/*
 Navicat MySQL Data Transfer

 Source Server         : myconnection
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : rubbish_classification

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 27/12/2019 11:38:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for configuration
-- ----------------------------
DROP TABLE IF EXISTS `configuration`;
CREATE TABLE `configuration`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `configuration_value` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of configuration
-- ----------------------------
INSERT INTO `configuration` VALUES (1, 1);

-- ----------------------------
-- Table structure for first_class
-- ----------------------------
DROP TABLE IF EXISTS `first_class`;
CREATE TABLE `first_class`  (
  `first_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_class_name` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` char(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `requirement` char(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`first_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of first_class
-- ----------------------------
INSERT INTO `first_class` VALUES (1, '可回收物', '指适宜回收和资源利用的垃圾，包括纸类、塑料、玻璃、金属、织物、橡胶、家具、家用电器和电子产品及其他大件垃圾等', '尽量保持清洁干燥，避免污染；废纸应保持平整；立体包装物应清空内容物，清洁后压扁投放；废玻璃制品应轻投轻放；有尖锐边角的应包裹后投放');
INSERT INTO `first_class` VALUES (2, '有害垃圾', '指含有害物质，需要特殊安全处理的生活垃圾，包括对人体健康或自然环境造成直接或潜在危险的灯管、家用化学品和电池等', '注意轻放；易破损的应连带包装或包裹后投放；废弃药品宜连带包装一并投放；杀虫剂等压力罐装容器，应排空内容物后投放');
INSERT INTO `first_class` VALUES (3, '湿垃圾', '指家庭、餐饮、集团单位食堂、集贸市场等产生的易腐性餐饮垃圾、厨余垃圾、废弃食材、废弃食物、废弃食用油脂等以及家庭产生的木竹、树枝、花草、落叶等', '应从产生时就与其他品种垃圾分开收集，投放前尽量沥干水分；盛放此类垃圾的容器，如塑料袋等，在投放时应予去除；有包装物的此类垃圾应将包装物去除后分类投放，包装物应投放到对应的可回收物或干垃圾/其他垃圾收集容器');
INSERT INTO `first_class` VALUES (4, '干垃圾', '指除可回收物、有害垃圾、湿垃圾/厨余垃圾/易腐垃圾以外的其他生活废弃物', '应投入相应的收集容器，并保持周边环境整洁');

-- ----------------------------
-- Table structure for second_class
-- ----------------------------
DROP TABLE IF EXISTS `second_class`;
CREATE TABLE `second_class`  (
  `second_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_id` int(11) NOT NULL,
  `second_class_name` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`second_id`) USING BTREE,
  INDEX `FK_Reference_1`(`first_id`) USING BTREE,
  CONSTRAINT `FK_1` FOREIGN KEY (`first_id`) REFERENCES `first_class` (`first_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of second_class
-- ----------------------------
INSERT INTO `second_class` VALUES (1, 1, '废纸张');
INSERT INTO `second_class` VALUES (2, 1, '废塑料');
INSERT INTO `second_class` VALUES (3, 1, '废玻璃制品');
INSERT INTO `second_class` VALUES (4, 1, '废金属');
INSERT INTO `second_class` VALUES (5, 1, '废织物');
INSERT INTO `second_class` VALUES (6, 1, '其他');
INSERT INTO `second_class` VALUES (7, 2, '废镉镍电池和废氧化汞电池');
INSERT INTO `second_class` VALUES (8, 2, '废荧光灯管');
INSERT INTO `second_class` VALUES (9, 2, '废药品及其包装物');
INSERT INTO `second_class` VALUES (10, 2, '废油漆和溶剂及其包装物');
INSERT INTO `second_class` VALUES (11, 2, '废矿物油及其包装物');
INSERT INTO `second_class` VALUES (12, 2, '废含汞温度计、废含汞血压计');
INSERT INTO `second_class` VALUES (13, 2, '废杀虫剂及其包装');
INSERT INTO `second_class` VALUES (14, 2, '废胶片及废相纸');
INSERT INTO `second_class` VALUES (15, 3, '食材废料');
INSERT INTO `second_class` VALUES (16, 3, '剩菜剩饭');
INSERT INTO `second_class` VALUES (17, 3, '过期食品');
INSERT INTO `second_class` VALUES (18, 3, '瓜皮果核');
INSERT INTO `second_class` VALUES (19, 3, '花卉植物');
INSERT INTO `second_class` VALUES (20, 3, '其他');
INSERT INTO `second_class` VALUES (21, 4, '常见干垃圾');

-- ----------------------------
-- Table structure for third_class
-- ----------------------------
DROP TABLE IF EXISTS `third_class`;
CREATE TABLE `third_class`  (
  `third_id` int(11) NOT NULL AUTO_INCREMENT,
  `object_name` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `second_id` int(11) NULL DEFAULT NULL,
  `pic_addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`third_id`) USING BTREE,
  INDEX `FK_Reference_2`(`second_id`) USING BTREE,
  CONSTRAINT `FK_2` FOREIGN KEY (`second_id`) REFERENCES `second_class` (`second_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 85 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of third_class
-- ----------------------------
INSERT INTO `third_class` VALUES (1, '纸板箱', 1, NULL);
INSERT INTO `third_class` VALUES (2, '报纸', 1, NULL);
INSERT INTO `third_class` VALUES (3, '快递纸袋', 1, NULL);
INSERT INTO `third_class` VALUES (4, '广告单', 1, NULL);
INSERT INTO `third_class` VALUES (5, '塑料瓶罐及瓶盖', 2, NULL);
INSERT INTO `third_class` VALUES (6, '食用油桶', 2, NULL);
INSERT INTO `third_class` VALUES (7, '塑料碗', 2, NULL);
INSERT INTO `third_class` VALUES (8, '食品保鲜盒', 2, NULL);
INSERT INTO `third_class` VALUES (9, '食用及日用品玻璃瓶罐', 3, NULL);
INSERT INTO `third_class` VALUES (10, '玻璃杯', 3, NULL);
INSERT INTO `third_class` VALUES (11, '放大镜', 3, NULL);
INSERT INTO `third_class` VALUES (12, '碎玻璃', 3, NULL);
INSERT INTO `third_class` VALUES (13, '易拉罐', 4, NULL);
INSERT INTO `third_class` VALUES (14, '菜刀', 4, NULL);
INSERT INTO `third_class` VALUES (15, '螺丝刀', 4, NULL);
INSERT INTO `third_class` VALUES (16, '铁钉', 4, NULL);
INSERT INTO `third_class` VALUES (17, '旧衣服', 5, NULL);
INSERT INTO `third_class` VALUES (18, '床单', 5, NULL);
INSERT INTO `third_class` VALUES (19, '枕头', 5, NULL);
INSERT INTO `third_class` VALUES (20, '棉被', 5, NULL);
INSERT INTO `third_class` VALUES (21, '电路板', 6, NULL);
INSERT INTO `third_class` VALUES (22, '充电宝', 6, NULL);
INSERT INTO `third_class` VALUES (23, '电线', 6, NULL);
INSERT INTO `third_class` VALUES (24, '插头', 6, NULL);
INSERT INTO `third_class` VALUES (25, '充电电池', 7, NULL);
INSERT INTO `third_class` VALUES (26, '镉镍电池', 7, NULL);
INSERT INTO `third_class` VALUES (27, '铅酸电池', 7, NULL);
INSERT INTO `third_class` VALUES (28, '蓄电池', 7, NULL);
INSERT INTO `third_class` VALUES (29, '荧光灯管', 8, NULL);
INSERT INTO `third_class` VALUES (30, '日光灯管', 8, NULL);
INSERT INTO `third_class` VALUES (31, '卤素灯', 8, NULL);
INSERT INTO `third_class` VALUES (32, '过期药物', 9, NULL);
INSERT INTO `third_class` VALUES (33, '药物胶囊', 9, NULL);
INSERT INTO `third_class` VALUES (34, '药片', 9, NULL);
INSERT INTO `third_class` VALUES (35, '药品内包装', 9, NULL);
INSERT INTO `third_class` VALUES (36, '废油漆桶', 10, NULL);
INSERT INTO `third_class` VALUES (37, '染发剂壳', 10, NULL);
INSERT INTO `third_class` VALUES (38, '过期的指甲油', 10, NULL);
INSERT INTO `third_class` VALUES (39, '洗甲水', 10, NULL);
INSERT INTO `third_class` VALUES (40, '废矿物油', 11, NULL);
INSERT INTO `third_class` VALUES (41, '废矿物油包装物', 11, NULL);
INSERT INTO `third_class` VALUES (42, '水银血压计', 12, NULL);
INSERT INTO `third_class` VALUES (43, '水银体温计', 12, NULL);
INSERT INTO `third_class` VALUES (44, '水银温度计', 12, NULL);
INSERT INTO `third_class` VALUES (45, '老鼠药', 13, NULL);
INSERT INTO `third_class` VALUES (46, '杀虫喷雾罐', 13, NULL);
INSERT INTO `third_class` VALUES (47, 'x光片', 14, NULL);
INSERT INTO `third_class` VALUES (48, '相片底片', 14, NULL);
INSERT INTO `third_class` VALUES (49, '米饭', 15, NULL);
INSERT INTO `third_class` VALUES (50, '面包', 15, NULL);
INSERT INTO `third_class` VALUES (51, '面条', 15, NULL);
INSERT INTO `third_class` VALUES (52, '鸡肉', 15, NULL);
INSERT INTO `third_class` VALUES (53, '鸭肉', 15, NULL);
INSERT INTO `third_class` VALUES (54, '鱼', 15, NULL);
INSERT INTO `third_class` VALUES (55, '鸡蛋', 15, NULL);
INSERT INTO `third_class` VALUES (56, '动物内脏', 15, NULL);
INSERT INTO `third_class` VALUES (57, '蔬菜', 15, NULL);
INSERT INTO `third_class` VALUES (58, '酱料', 15, NULL);
INSERT INTO `third_class` VALUES (59, '腊肉', 15, NULL);
INSERT INTO `third_class` VALUES (60, '鸡蛋壳', 15, NULL);
INSERT INTO `third_class` VALUES (61, '火锅汤底', 16, NULL);
INSERT INTO `third_class` VALUES (62, '碎骨头', 16, NULL);
INSERT INTO `third_class` VALUES (63, '茶叶渣', 16, NULL);
INSERT INTO `third_class` VALUES (64, '咖啡渣', 16, NULL);
INSERT INTO `third_class` VALUES (65, '糕饼', 17, NULL);
INSERT INTO `third_class` VALUES (66, '糖果', 17, NULL);
INSERT INTO `third_class` VALUES (67, '肉干', 17, NULL);
INSERT INTO `third_class` VALUES (68, '面粉', 17, NULL);
INSERT INTO `third_class` VALUES (69, '宠物饲料', 17, NULL);
INSERT INTO `third_class` VALUES (70, '椰子肉', 18, NULL);
INSERT INTO `third_class` VALUES (71, '香蕉皮', 18, NULL);
INSERT INTO `third_class` VALUES (72, '橘子皮', 18, NULL);
INSERT INTO `third_class` VALUES (73, '西瓜籽', 18, NULL);
INSERT INTO `third_class` VALUES (74, '家养绿植', 19, NULL);
INSERT INTO `third_class` VALUES (75, '花卉', 19, NULL);
INSERT INTO `third_class` VALUES (76, '花瓣', 19, NULL);
INSERT INTO `third_class` VALUES (77, '枝叶', 19, NULL);
INSERT INTO `third_class` VALUES (78, '中药药渣', 20, NULL);
INSERT INTO `third_class` VALUES (79, '餐巾纸', 21, NULL);
INSERT INTO `third_class` VALUES (80, '卫生纸', 21, NULL);
INSERT INTO `third_class` VALUES (81, '尿不湿', 21, NULL);
INSERT INTO `third_class` VALUES (82, '猫砂', 21, NULL);
INSERT INTO `third_class` VALUES (83, '干燥剂', 21, NULL);
INSERT INTO `third_class` VALUES (84, '烟蒂', 21, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` char(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `flag` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'hujun', 'hujun', 1);
INSERT INTO `user` VALUES (2, 'guxueqing', 'guxueqing', 0);
INSERT INTO `user` VALUES (3, 'fengyaping', 'fengyaping', 0);
INSERT INTO `user` VALUES (4, 'shenjiaming', 'shenjiaming', 0);
INSERT INTO `user` VALUES (5, 'chentao', 'chentao', 0);

SET FOREIGN_KEY_CHECKS = 1;
