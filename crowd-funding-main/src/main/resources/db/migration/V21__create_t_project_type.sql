create table t_project_type
(
    id int auto_increment
        primary key,
    projectid int null,
    typeid int null,
    constraint FK_Reference_5
        foreign key (projectid) references t_project (id),
    constraint FK_Reference_6
        foreign key (typeid) references t_type (id)
);