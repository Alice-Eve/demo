/*
    Navicat Premium Data Transfer
    巷陌商城
    xmomall@foxmail.com
    Date: 20/2/2022 17:20:22
*/
-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
                                `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                                `username` varchar(64) COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户账号（第三方token）',
                                `password` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户密码',
                                `nickname` varchar(16) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户昵称',
                                `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户头像',
                                `email` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户邮箱',
                                `phone` varchar(11) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户电话',
                                `gender` char(4) DEFAULT NULL COMMENT '性别',
                                `login_type` tinyint(1) DEFAULT NULL COMMENT '登陆类型（1 邮箱 2账号密码 3QQ）',
                                `last_login_time` datetime DEFAULT NULL COMMENT '最后登陆时间',
                                `login_ip` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '登陆ip',
                                `login_address` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '登陆地区',
                                `enabled` tinyint(1) DEFAULT 1 COMMENT '账号是否可用。默认为1（可用）',
                                `expired` tinyint(1) DEFAULT 1 COMMENT '是否过期。默认为1（没有过期）',
                                `locked` tinyint(1) DEFAULT 1 COMMENT '账号是否锁定。默认为1（没有锁定）',
                                `credentialsNotExpired` tinyint(1) DEFAULT '0' COMMENT '证书（密码）是否过期。默认为1（没有过期）',
                                `del_flag` tinyint(1) DEFAULT 1 COMMENT '账号是否删除。默认为1（没有删除）',
                                `create_user` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
                                `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                `update_user` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改者',
                                `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                `remark` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of njs_consumer
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1, 'admin', '$2a$10$AJQdBnx6.M9lPNIyCEUj2.Mb2Atc6X9SUkBD5HE6BjW9T15CCDcLG', '管理员', 'http://thirdqq.qlogo.cn/g?b=oidb&k=hvhPWld09XxGU20XFcTXJg&s=100&t=1633014230', 'xmomall@foxmail.com', '18077791377', '男', 0, '2021-11-15 21:04:50', '1.1.1.1', '广西河池', 1, 1, 1, 1, 1, '巷陌', '2021-11-15 21:04:50', '巷陌', '2021-11-15 21:04:50', '无');
INSERT INTO `sys_user` VALUES (2, 'xmomall', '$2a$10$AJQdBnx6.M9lPNIyCEUj2.Mb2Atc6X9SUkBD5HE6BjW9T15CCDcLG', '超级管理员', 'http://thirdqq.qlogo.cn/g?b=oidb&k=nRicWhbNHnibgvCyDbNljhJQ&s=100&t=1633014176', 'xmomall@foxmail.com', '18077791377', '女', 1, '2021-11-15 21:04:50', '1.1.1.1', '广西南宁', 1, 1, 1, 1, 1, '巷陌', '2021-11-16 11:40:52', '巷陌', '2021-11-15 21:04:50', '无');
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
                            `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色主键',
                            `name` varchar(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
                            `description` varchar(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色标识',
                            `num` tinyint(3) DEFAULT 99 COMMENT '角色排序',
                            `enabled` tinyint(1) DEFAULT 1 COMMENT '角色状态是否可用。默认为1（可用）',
                            `del_flag` tinyint(1) DEFAULT 1 COMMENT '账号是否删除。默认为1（没有删除）',
                            `create_user` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_user` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改者',
                            `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                            `remark` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'super_admin', 1, 1, 0, '巷陌', '2021-11-15 21:04:50', '巷陌', '2021-11-15 21:04:55', '无');
INSERT INTO `sys_role` VALUES (2, '管理员', 'admin', 2, 1, 0, '巷陌', '2021-11-15 21:04:50', '巷陌', '2021-11-15 21:04:50', '无');
INSERT INTO `sys_role` VALUES (3, '用户', 'consumer', 3, 1, 0, '巷陌', '2021-11-15 21:04:50', '巷陌', '2021-11-15 21:04:50', '无');
COMMIT;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
                            `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单主键',
                            `name` varchar(16) COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单名称',
                            `url` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '路由路径',
                            `path` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '路由地址',
                            `component` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '组件名称',
                            `icon` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单图标',
                            `order_num` tinyint(3) DEFAULT 99 COMMENT '菜单排序',
                            `parent_id` int(11) DEFAULT 1 COMMENT '父级菜单id',
                            `hide` tinyint(1) DEFAULT 1 COMMENT '菜单显示状态是否隐藏。默认为1（显示）',
                            `enabled` tinyint(1) DEFAULT 1 COMMENT '菜单禁用状态是否可用。默认为1（可用）',
                            `del_flag` tinyint(1) DEFAULT 1 COMMENT '删除标识（0 正常。1 删除）',
                            `create_user` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_user` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改者',
                            `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                            `remark` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注信息',
                            PRIMARY KEY (`id`),
                            KEY `parentId` (`parent_id`),
                            CONSTRAINT `sys_menu_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `sys_menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
# INSERT INTO `sys_menu` VALUES (1, '根', null,null, null, null, null, null, null, 1, null, null, null, null, null, null);
INSERT INTO `sys_menu` VALUES (2, '网站管理', '/','/home', 'Home', 'el-icon-eleme', 2, null, 1, 1, 0, '巷陌', '2021-11-13 20:46:44', '巷陌', '2021-11-13 20:46:44', '无');
INSERT INTO `sys_menu` VALUES (3, '信息管理', '/','/home', 'Home', 'el-icon-eleme', 2, null, 1, 1, 0, '巷陌', '2021-11-13 20:46:44', '巷陌', '2021-11-13 20:46:44', '无');
INSERT INTO `sys_menu` VALUES (4, '系统管理', '/','/home', 'Home', 'el-icon-s-tools', 3, null, 1, 1, 0, '巷陌', '2021-11-13 20:46:44', '巷陌', '2021-11-13 20:46:44', '无');
INSERT INTO `sys_menu` VALUES (5, '监控中心', '/','/home', 'Home', 'el-icon-document-copy', 4, null, 1, 1, 0, '巷陌', '2021-11-13 20:46:44', '巷陌', '2021-11-13 20:46:44', '无');
INSERT INTO `sys_menu` VALUES (6, '百度优化', '/baidu/**','/baidu', 'Baidu.vue', 'el-icon-eleme', 2, null, 1, 1, 0, '巷陌', '2021-11-13 20:46:44', '巷陌', '2021-11-13 20:46:44', '无');
INSERT INTO `sys_menu` VALUES (9, '友情链接', '/link/**','/link', 'Link.vue', 'el-icon-link', 5, null, 1, 1, 0, '巷陌', '2021-11-13 20:46:44', '巷陌', '2021-11-13 20:46:44', '无');
INSERT INTO `sys_menu` VALUES (10, '用户管理', '/system/user/**','/system/user', 'system/User.vue', 'el-icon-user-solid', 1, 4, 1, 1, 0, '巷陌', '2021-11-13 20:46:44', '巷陌', '2021-11-13 20:46:44', '无');
INSERT INTO `sys_menu` VALUES (11, '角色管理', '/system/role/**','/system/role', 'system/Role.vue', 'el-icon-coordinate', 2, 4, 1, 1, 0, '巷陌', '2021-11-13 20:46:44', '巷陌', '2021-11-13 20:46:44', '无');
INSERT INTO `sys_menu` VALUES (12, '菜单管理', '/system/menu/**','/system/menu', 'system/Menu.vue', 'el-icon-menu', 3, 4, 1, 1, 0, '巷陌', '2021-11-13 20:46:44', '巷陌', '2021-11-13 20:46:44', '无');
INSERT INTO `sys_menu` VALUES (13, '权限管理', '/system/perm/**','/system/perm', 'system/Perm.vue', 'el-icon-set-up', 4, 4, 1, 1, 0, '巷陌', '2021-11-13 20:46:44', '巷陌', '2021-11-13 20:46:44', '无');
INSERT INTO `sys_menu` VALUES (90, '操作日志', '/log/oplog/**','/log/oplog', 'log/Oplog.vue', 'el-icon-mouse', 1, 5, 1, 1, 0, '巷陌', '2021-11-30 11:22:58', '巷陌', '2021-11-30 11:22:58', '操作日志菜单');
INSERT INTO `sys_menu` VALUES (91, '登录日志', '/log/LoginLog/**','/log/LoginLog', 'log/LoginLog.vue', 'el-icon-warning-outline', 2, 5, 1, 1, 0, '巷陌', '2021-11-30 11:22:58', '巷陌', '2021-11-30 11:22:58', '登录日志菜单');
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
                                     `id` int(11) NOT NULL AUTO_INCREMENT,
                                     `user_id` int(11) NULL COMMENT '用户主键',
                                     `role_id` int(11) NULL COMMENT '角色主键',
                                     PRIMARY KEY (`id`),
                                     KEY `role_id` (`role_id`),
                                     KEY `user_role_ibfk_1` (`user_id`),
                                     CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`) ON DELETE CASCADE,
                                     CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES (1, 1, 1);
INSERT INTO `sys_user_role` VALUES (2, 1, 2);
INSERT INTO `sys_user_role` VALUES (3, 1, 3);
INSERT INTO `sys_user_role` VALUES (4, 2, 1);
INSERT INTO `sys_user_role` VALUES (5, 2, 2);
INSERT INTO `sys_user_role` VALUES (6, 2, 3);
COMMIT;

-- ----------------------------
-- Table structure for sys_menu_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_role`;
CREATE TABLE `sys_menu_role` (
                                 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                 `menu_id` int(11) NOT NULL COMMENT '菜单id',
                                 `role_id` int(11) NOT NULL COMMENT '角色id',
                                 PRIMARY KEY (`id`),
                                 KEY `menu_id` (`menu_id`),
                                 KEY `role_id` (`role_id`),
                                 CONSTRAINT `sys_menu_role_ibfk_1` FOREIGN KEY (`menu_id`) REFERENCES `sys_menu` (`id`),
                                 CONSTRAINT `sys_menu_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of sys_menu_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu_role` VALUES (1, 10, 1);
INSERT INTO `sys_menu_role` VALUES (2, 11, 1);
INSERT INTO `sys_menu_role` VALUES (3, 12, 1);
INSERT INTO `sys_menu_role` VALUES (4, 13, 1);
INSERT INTO `sys_menu_role` VALUES (5, 90, 1);
INSERT INTO `sys_menu_role` VALUES (6, 91, 1);
INSERT INTO `sys_menu_role` VALUES (7, 6, 1);
INSERT INTO `sys_menu_role` VALUES (8, 9, 1);
INSERT INTO `sys_menu_role` VALUES (9, 11, 3);
COMMIT;

-- ----------------------------
-- Table structure for oplog
-- ----------------------------
DROP TABLE IF EXISTS `oplog`;
CREATE TABLE `oplog` (
                               `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志id',
                               `title` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '模块标题',
                               `business_type` tinyint(1) DEFAULT NULL COMMENT '业务类型（1 新增 2 修改 3 删除 ）',
                               `method_name` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '方法名称',
                               `method_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '方法路径',
                               `request_type` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '请求方式',
                               `opt_name` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '操作者',
                               `opt_url` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '请求路径',
                               `opt_ip` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '操作者ip',
                               `opt_address` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '操作者地址',
                               `request_param` longtext COLLATE utf8mb4_general_ci COMMENT '请求参数',
                               `response_data` longtext COLLATE utf8mb4_general_ci COMMENT '返回信息',
                               `opt_time` datetime DEFAULT NULL COMMENT '操作日期',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of oplog
-- ----------------------------
BEGIN;
INSERT INTO `oplog` VALUES (12, '菜单模块', 1, '新增菜单信息', 'com.nanjustar.web.controller.security.MenuController.saveMenu', 'POST', 'ᯤ⁸ᴳ⁺(超级管理员)', '/menu/saveMenu', '192.168.0.112', '本地局域网', '[{\"component\":\"Layout\",\"icon\":\"el-icon-rank\",\"isHidden\":false,\"menuId\":-1,\"menuName\":\"测试菜单\",\"orderNum\":4,\"parentId\":-1,\"path\":\"/test\",\"remark\":\"测试菜单\"}]', '{\"code\":20000,\"message\":\"菜单新增成功！\",\"status\":true}', '2021-12-01 09:05:40');
INSERT INTO `oplog` VALUES (13, '菜单模块', 1, '新增菜单信息', 'com.nanjustar.web.controller.security.MenuController.saveMenu', 'POST', 'ᯤ⁸ᴳ⁺(超级管理员)', '/menu/saveMenu', '192.168.0.112', '本地局域网', '[{\"component\":\"/test/test.vue\",\"icon\":\"el-icon-turn-off\",\"isHidden\":false,\"menuId\":-1,\"menuName\":\"测试目录\",\"orderNum\":19,\"parentId\":-1,\"path\":\"/testc\",\"remark\":\"测试目录\"}]', '{\"code\":20000,\"message\":\"菜单新增成功！\",\"status\":true}', '2021-12-01 09:06:30');
INSERT INTO `oplog` VALUES (14, '菜单模块', 1, '新增菜单信息', 'com.nanjustar.web.controller.security.MenuController.saveMenu', 'POST', 'ᯤ⁸ᴳ⁺(超级管理员)', '/menu/saveMenu', '192.168.0.112', '本地局域网', '[{\"component\":\"Layout\",\"icon\":\"el-icon-picture-outline-round\",\"isHidden\":false,\"menuId\":-1,\"menuName\":\"111\",\"orderNum\":2,\"parentId\":-1,\"path\":\"111\",\"remark\":\"111\"}]', '{\"code\":20000,\"message\":\"菜单新增成功！\",\"status\":true}', '2021-12-01 09:09:40');
INSERT INTO `oplog` VALUES (15, '菜单模块', 2, '修改菜单信息', 'com.nanjustar.web.controller.security.MenuController.updateMenu', 'PUT', 'ᯤ⁸ᴳ⁺(超级管理员)', '/menu/updateMenu', '192.168.0.112', '本地局域网', '[{\"component\":\"Layout\",\"icon\":\"el-icon-rank\",\"isHidden\":false,\"menuId\":32,\"menuName\":\"测试菜单\",\"orderNum\":4,\"path\":\"/test\",\"remark\":\"测试菜单\"}]', '{\"code\":20000,\"message\":\"菜单修改成功！\",\"status\":true}', '2021-12-01 09:29:48');
INSERT INTO `oplog` VALUES (16, '菜单模块', 1, '新增菜单信息', 'com.nanjustar.web.controller.security.MenuController.saveMenu', 'POST', 'ᯤ⁸ᴳ⁺(超级管理员)', '/menu/saveMenu', '192.168.43.195', '本地局域网', '[{\"component\":\"ddd\",\"icon\":\"el-icon-zoom-in\",\"isHidden\":false,\"menuId\":-1,\"menuName\":\"ddd\",\"orderNum\":1,\"parentId\":32,\"path\":\"ddd\",\"remark\":\"ddd\"}]', '{\"code\":20000,\"message\":\"菜单新增成功！\",\"status\":true}', '2021-12-01 16:44:42');
INSERT INTO `oplog` VALUES (17, '菜单模块', 3, '删除菜单信息', 'com.nanjustar.web.controller.security.MenuController.deleteMenu', 'DELETE', 'ᯤ⁸ᴳ⁺(超级管理员)', '/menu/deleteMenu/35', '192.168.43.195', '本地局域网', '[35]', '{\"code\":20000,\"message\":\"菜单删除成功！\",\"status\":true}', '2021-12-01 16:45:24');
INSERT INTO `oplog` VALUES (18, '菜单模块', 3, '删除菜单信息', 'com.nanjustar.web.controller.security.MenuController.deleteMenu', 'DELETE', 'ᯤ⁸ᴳ⁺(超级管理员)', '/menu/deleteMenu/32', '192.168.43.195', '本地局域网', '[32]', '{\"code\":20000,\"message\":\"菜单删除成功！\",\"status\":true}', '2021-12-01 16:57:33');
INSERT INTO `oplog` VALUES (19, '菜单模块', 1, '新增菜单信息', 'com.nanjustar.web.controller.security.MenuController.saveMenu', 'POST', 'ᯤ⁸ᴳ⁺(超级管理员)', '/menu/saveMenu', '192.168.43.195', '本地局域网', '[{\"component\":\"Layout\",\"icon\":\"el-icon-s-goods\",\"isHidden\":true,\"menuId\":-1,\"menuName\":\"eee\",\"orderNum\":1,\"parentId\":-1,\"path\":\"eee\",\"remark\":\"ddd\"}]', '{\"code\":20000,\"message\":\"菜单新增成功！\",\"status\":true}', '2021-12-01 17:07:31');
INSERT INTO `oplog` VALUES (20, '菜单模块', 2, '修改菜单信息', 'com.nanjustar.web.controller.security.MenuController.updateMenu', 'PUT', 'ᯤ⁸ᴳ⁺(超级管理员)', '/menu/updateMenu', '192.168.43.195', '本地局域网', '[{\"component\":\"Layout\",\"icon\":\"el-icon-s-goods\",\"isHidden\":false,\"menuId\":36,\"menuName\":\"eee\",\"orderNum\":1,\"path\":\"eee\",\"remark\":\"ddd\"}]', '{\"code\":20000,\"message\":\"菜单修改成功！\",\"status\":true}', '2021-12-01 17:07:43');
INSERT INTO `oplog` VALUES (21, '菜单模块', 3, '删除菜单信息', 'com.nanjustar.web.controller.security.MenuController.deleteMenu', 'DELETE', 'ᯤ⁸ᴳ⁺(超级管理员)', '/menu/deleteMenu/36', '192.168.43.195', '本地局域网', '[36]', '{\"code\":20000,\"message\":\"菜单删除成功！\",\"status\":true}', '2021-12-01 17:07:53');
COMMIT;

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log` (
                         `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志id',
                         `username` varchar(64) COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户账号（第三方token）',
                         `nickname` varchar(16) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户昵称',
                         `ip_address` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'ip地址',
                         `ip_source` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'ip来源',
                         `browser` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '浏览器',
                         `os` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '操作系统',
                         `remark` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '操作信息',
                         `state` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '状态',
                         `login_time` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '登录时间',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- ----------------------------
-- Records of login_log
-- ----------------------------
BEGIN;
INSERT INTO `login_log` VALUES (1, 'xmomall', '超级管理员', '171.107.65.106', '广西壮族自治区河池市 电信', 'Chrome 8', 'Windows 10', '登陆成功', 1, '2022-02-20 04:59:12');
COMMIT;
