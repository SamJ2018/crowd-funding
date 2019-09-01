create table t_project
(
    id int auto_increment
        primary key,
    name varchar(255) null,
    remark varchar(255) null,
    money bigint(11) null,
    day int null,
    status char null comment '0 - 即将开始， 1 - 众筹中， 2 - 众筹成功， 3 - 众筹失败',
    deploydate char(10) null,
    supportmoney bigint(11) null,
    supporter int null,
    completion int(3) null,
    memberid int null,
    createdate char(19) null,
    follower int null
);