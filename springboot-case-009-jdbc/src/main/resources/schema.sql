CREATE TABLE `article`
(
    `id`          int                       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id`     int                       NOT NULL COMMENT '作者ID',
    `title`       varchar(255)              NOT NULL COMMENT '文章标题',
    `summary`     varchar(255) DEFAULT NULL COMMENT '文章概要',
    `read_count`  int(11) unsigned zerofill NOT NULL COMMENT '阅读读数',
    `create_time` datetime                  NOT NULL COMMENT '创建时间',
    `update_time` datetime                  NOT NULL COMMENT '最后更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;