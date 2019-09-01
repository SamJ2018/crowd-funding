create table t_project_tag
(
    id int auto_increment
        primary key,
    projectid int null,
    tagid int null,
    constraint FK_Reference_7
        foreign key (projectid) references t_project (id),
    constraint FK_Reference_8
        foreign key (tagid) references t_tag (id)
);