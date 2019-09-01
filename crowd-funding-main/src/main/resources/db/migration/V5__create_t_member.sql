create table t_member
(
    id int auto_increment
        primary key,
    loginacct varchar(255) not null,
    userpswd char(32) not null,
    username varchar(255) not null,
    email varchar(255) not null,
    authstatus char not null comment '实名认证状态 0 - 未实名认证， 1 - 实名认证申请中， 2 - 已实名认证',
    usertype char not null comment ' 0 - 个人， 1 - 企业',
    realname varchar(255) null,
    cardnum varchar(255) null,
    accttype char null comment '0 - 企业， 1 - 个体， 2 - 个人， 3 - 政府'
);