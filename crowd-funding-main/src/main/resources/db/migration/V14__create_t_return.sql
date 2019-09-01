create table t_return
(
    id int auto_increment
        primary key,
    projectid int null,
    type char null comment '0 - 实物回报， 1 虚拟物品回报',
    supportmoney int null,
    content varchar(255) null,
    count int null comment '“0”为不限回报数量',
    signalpurchase int null,
    purchase int null,
    freight int null,
    invoice char null comment '0 - 不开发票， 1 - 开发票',
    rtndate int null
);