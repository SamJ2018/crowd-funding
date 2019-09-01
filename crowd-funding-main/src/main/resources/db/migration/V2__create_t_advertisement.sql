create table t_advertisement
(
    id int auto_increment
        primary key,
    name varchar(255) null,
    iconpath varchar(255) null,
    status char null comment '0 - 草稿， 1 - 未审核， 2 - 审核完成， 3 - 发布',
    url varchar(255) null,
    userid int null
);