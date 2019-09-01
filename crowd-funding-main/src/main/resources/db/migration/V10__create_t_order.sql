create table t_order
(
    id int auto_increment
        primary key,
    memberid int null,
    projectid int null,
    returnid int null,
    ordernum varchar(255) null,
    createdate char(19) null,
    money int null,
    rtncount int null,
    status char null comment '0 - 待付款， 1 - 交易完成， 9 - 交易关闭',
    address varchar(255) null,
    invoice char null comment '0 - 不开发票， 1 - 开发票',
    invoictitle varchar(255) null,
    remark varchar(255) null
);