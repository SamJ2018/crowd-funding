create table t_message
(
    id int auto_increment
        primary key,
    memberid int null,
    content varchar(255) null,
    senddate char(19) null
);