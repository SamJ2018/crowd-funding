create table t_user_role
(
    id int auto_increment
        primary key,
    userid int null,
    roleid int null,
    constraint FK_Reference_1
        foreign key (userid) references t_user (id),
    constraint FK_Reference_2
        foreign key (roleid) references t_role (id)
);