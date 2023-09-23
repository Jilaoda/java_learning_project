# 创建数据库personal_blog
create database personal_blog;

# 创建personal_user表,管理用户
DROP TABLE IF EXISTS `person_user`;
CREATE TABLE `person_user` (
   `id`                 INT             NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
   `username`           VARCHAR(255)    NOT NULL                            COMMENT '用户名',
   `password`           VARCHAR(255)    NOT NULL                            COMMENT '密码',
   `email`              VARCHAR(64)         NULL                            COMMENT '邮箱',
   `last_login_time`    datetime            NULL                            COMMENT '上次登录时间',
   `phone`              BIGINT(11)      NOT NULL DEFAULT 0                  COMMENT '手机号',
   `nickname`			  VARCHAR(64)         NULL                            COMMENT '昵称',
   `create_time`        DATETIME            NULL DEFAULT CURRENT_TIMESTAMP      COMMENT '创建时间',
   `update_time`        DATETIME            NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = Dynamic
  COMMENT '用户管理表';

# 创建personal_category表,实现文章的分类功能
DROP TABLE IF EXISTS `person_category`;
CREATE TABLE `person_category` (
   `category_id`        INT             NOT NULL PRIMARY KEY AUTO_INCREMENT     COMMENT '主键',
   `category_name`      VARCHAR(128)    NOT NULL                                COMMENT '分类名称',
   `create_time`        DATETIME            NULL DEFAULT CURRENT_TIMESTAMP      COMMENT '创建时间',
   `update_time`        DATETIME            NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = Dynamic
    COMMENT '文章分类管理表';

# 创建personal_notice表,实现通知公告功能
DROP TABLE IF EXISTS `person_notice`;
CREATE TABLE `person_notice` (
     `notice_id`        INT             NOT NULL PRIMARY KEY AUTO_INCREMENT     COMMENT '主键',
     `notice_title`		VARCHAR(255)      NOT NULL                                COMMENT '公告标题',
     `notice_type`		TINYINT    		  NOT NULL DEFAULT 0                      COMMENT '公告类型，默认0, 0-公告, 1-通知, 2-提醒',
     `status`           TINYINT           NOT NULL DEFAULT 0                      COMMENT '状态，默认0, 0-正常, 1-关闭',
     `noticeContent`    text                  NULL                                COMMENT '公告内容',
     `createBy`   		VARCHAR(128)      NOT NULL                                COMMENT '创建者',
     `create_time`      DATETIME              NULL DEFAULT CURRENT_TIMESTAMP      COMMENT '创建时间',
     `update_time`      DATETIME              NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = Dynamic
    COMMENT '通知公告表';

# 创建person_tag表,实现标签功能
DROP TABLE IF EXISTS `person_tag`;
CREATE TABLE `person_tag` (
      `id`                 INT             NOT NULL PRIMARY KEY AUTO_INCREMENT     COMMENT '主键',
      `tag_name`			  VARCHAR(255)        NULL                                COMMENT '标签名',
      `create_time`        DATETIME            NULL DEFAULT CURRENT_TIMESTAMP      COMMENT '创建时间',
      `update_time`        DATETIME            NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = Dynamic
    COMMENT '标签管理表';


# 创建person_article表,文章除了要包含作者、文章标题、id、内容、总字数、状态等，还要包含标签id、分类id
DROP TABLE IF EXISTS `person_article`;
CREATE TABLE `person_article` (
      `id`             INT             NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
      `author`         VARCHAR(128)    NOT NULL                            COMMENT '作者',
      `title`          VARCHAR(255)    NOT NULL                            COMMENT '文章标题',
      `user_id`        	 INT(11)       NOT NULL                            COMMENT '用户id',
      `category_id`    	 INT(11)       NOT NULL                            COMMENT '分类id',
      `content`        	 LONGTEXT          NULL                            COMMENT '文章内容',
      `views`          BIGINT          NOT NULL DEFAULT 0                  COMMENT '文章浏览量',
      `total_words`      BIGINT        NOT NULL DEFAULT 0                  COMMENT '文章总字数',
      `commentable_id` INT    		       NULL                            COMMENT '评论id',
      `art_status`       TINYINT       NOT NULL DEFAULT 0                  COMMENT '发布，默认0, 0-发布, 1-草稿',
      `description`      VARCHAR(255)  NOT NULL                            COMMENT '描述',
      `image_url`        VARCHAR(255)  NOT NULL                            COMMENT '文章logo',
      `create_time`    DATETIME            NULL DEFAULT CURRENT_TIMESTAMP  COMMENT '创建时间',
      `update_time`    DATETIME            NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = Dynamic
    COMMENT '文章管理表';