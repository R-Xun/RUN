/*
Navicat MySQL Data Transfer

Source Server         : lzx
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : staff_manage

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2023-03-24 16:02:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for depart_msg
-- ----------------------------
DROP TABLE IF EXISTS `depart_msg`;
CREATE TABLE `depart_msg` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `dname` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '部门名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='部门';

-- ----------------------------
-- Records of depart_msg
-- ----------------------------
INSERT INTO `depart_msg` VALUES ('1', '创新部');
INSERT INTO `depart_msg` VALUES ('2', '营销部');
INSERT INTO `depart_msg` VALUES ('3', '人力资源部');
INSERT INTO `depart_msg` VALUES ('4', '技术部');
INSERT INTO `depart_msg` VALUES ('5', '财务部');

-- ----------------------------
-- Table structure for job_msg
-- ----------------------------
DROP TABLE IF EXISTS `job_msg`;
CREATE TABLE `job_msg` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `job_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '职位名',
  `depart_id` int(11) DEFAULT NULL COMMENT '所属部门',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='职位';

-- ----------------------------
-- Records of job_msg
-- ----------------------------
INSERT INTO `job_msg` VALUES ('1', '创意总监', '1');
INSERT INTO `job_msg` VALUES ('2', '产品经理', '1');
INSERT INTO `job_msg` VALUES ('3', '用户体验设计师', '1');
INSERT INTO `job_msg` VALUES ('4', '数据分析师', '1');
INSERT INTO `job_msg` VALUES ('5', '市场总监', '2');
INSERT INTO `job_msg` VALUES ('6', '销售经理', '2');
INSERT INTO `job_msg` VALUES ('7', '社交媒体营销专员', '2');
INSERT INTO `job_msg` VALUES ('8', '品牌策划师', '2');
INSERT INTO `job_msg` VALUES ('9', '人力资源总监', '3');
INSERT INTO `job_msg` VALUES ('10', '招聘经理', '3');
INSERT INTO `job_msg` VALUES ('11', '绩效考核专员', '3');
INSERT INTO `job_msg` VALUES ('12', '员工关系协调员', '3');
INSERT INTO `job_msg` VALUES ('13', '技术总监', '4');
INSERT INTO `job_msg` VALUES ('14', '软件工程师', '4');
INSERT INTO `job_msg` VALUES ('15', '网络安全专家', '4');
INSERT INTO `job_msg` VALUES ('16', '数据库管理员', '4');
INSERT INTO `job_msg` VALUES ('17', '财务总监', '5');
INSERT INTO `job_msg` VALUES ('18', '财务分析师', '5');
INSERT INTO `job_msg` VALUES ('19', '会计师', '5');
INSERT INTO `job_msg` VALUES ('20', '成本控制专员', '5');

-- ----------------------------
-- Table structure for staff_msg
-- ----------------------------
DROP TABLE IF EXISTS `staff_msg`;
CREATE TABLE `staff_msg` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `staff_no` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '职工号',
  `real_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `celphone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '联系电话',
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `depart_id` int(11) DEFAULT NULL COMMENT '所属部门',
  `job_id` int(11) DEFAULT NULL COMMENT '职位',
  `create_date` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='员工';

-- ----------------------------
-- Records of staff_msg
-- ----------------------------
INSERT INTO `staff_msg` VALUES ('1', '001', '李宗逊', '18980465753', '2650450547@qq.com', '1', '4', '13', '2023-03-14');
INSERT INTO `staff_msg` VALUES ('2', '002', '刘冬梅', '13800003125', 'liudm@163.com', '2', '2', '6', '2023-04-04');
INSERT INTO `staff_msg` VALUES ('3', '003', '王建国', '13975349632', 'wangjg@gmail.com', '1', '2', '5', '2023-02-24');
INSERT INTO `staff_msg` VALUES ('4', '004', '张艳红', '13645678756', 'zhangyh@126.com', '2', '1', '4', '2023-01-10');
INSERT INTO `staff_msg` VALUES ('5', '005', '李伟', '13775895678', 'liwei@qq.com', '1', '1', '3', '2023-03-19');
INSERT INTO `staff_msg` VALUES ('6', '006', '刘娟', '13515522345', 'liujuan@hotmail.com', '2', '1', '2', '2023-03-14');
INSERT INTO `staff_msg` VALUES ('7', '007', '王志刚', '13812347890', 'wangzg@163.com', '1', '1', '1', '2023-03-14');
INSERT INTO `staff_msg` VALUES ('8', '008', '赵丽华', '13956764567', 'zhaolh@126.com', '2', '2', '7', '2023-03-14');
INSERT INTO `staff_msg` VALUES ('9', '009', '陈伟', '13652638912', 'chenwei@gmail.com', '1', '2', '8', '2023-03-19');
INSERT INTO `staff_msg` VALUES ('10', '010', '李秀英', '13523676789', 'lixuoying@qq.com', '2', '3', '9', '2023-03-14');
INSERT INTO `staff_msg` VALUES ('11', '011', '王刚', '13755671234', 'wanggang@hotmail.com', '1', '3', '10', '2023-01-10');
INSERT INTO `staff_msg` VALUES ('12', '012', '李雪', '13985758901', 'lixue@163.com', '2', '3', '11', '2023-03-14');
INSERT INTO `staff_msg` VALUES ('13', '013', '张健', '13815752345', 'zhangjian@126.com', '1', '3', '12', '2023-03-14');
INSERT INTO `staff_msg` VALUES ('14', '014', '王丽', '13645675678', 'wangli@qq.com', '2', '3', '12', '2023-03-19');
INSERT INTO `staff_msg` VALUES ('15', '015', '李明', '13785209012', 'liming@gmail.com', '1', '4', '14', '2023-03-14');
INSERT INTO `staff_msg` VALUES ('16', '016', '刘颖', '13945673456', 'liuying@hotmail.com', '2', '5', '17', '2023-01-10');
INSERT INTO `staff_msg` VALUES ('17', '017', '张建国', '13845667890', 'zhangjg@163.com', '1', '5', '18', '2023-03-14');
INSERT INTO `staff_msg` VALUES ('18', '018', '王红', '13512341234', 'wanghong@qq.com', '2', '1', '4', '2023-03-19');
INSERT INTO `staff_msg` VALUES ('19', '019', '李华', '13678348901', 'lihua@gmail.com', '1', '2', '6', '2023-03-14');

-- ----------------------------
-- Table structure for user_msg
-- ----------------------------
DROP TABLE IF EXISTS `user_msg`;
CREATE TABLE `user_msg` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `login_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '登录名',
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `user_type` int(11) DEFAULT NULL COMMENT '权限类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户';

-- ----------------------------
-- Records of user_msg
-- ----------------------------
INSERT INTO `user_msg` VALUES ('2', 'root2', '123456', '2');
INSERT INTO `user_msg` VALUES ('4', 'root1', '123456', '2');
INSERT INTO `user_msg` VALUES ('5', 'admin', '123456', '1');
