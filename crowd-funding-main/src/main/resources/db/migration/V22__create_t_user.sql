create table t_user
(
    id int auto_increment
        primary key,
    loginacct varchar(255) not null,
    userpswd char(32) not null,
    username varchar(255) not null,
    email varchar(255) not null,
    createtime char(19) null
);