create table t_role_permission
(
    id int auto_increment
        primary key,
    roleid int null,
    permissionid int null,
    constraint FK_Reference_3
        foreign key (roleid) references t_role (id),
    constraint FK_Reference_4
        foreign key (permissionid) references t_permission (id)
);
