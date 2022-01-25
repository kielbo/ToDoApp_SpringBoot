create table tasks_group(
    id int primary key auto_increment,
    description varchar(100) not null,
    done bit
);

alter table task  add column tasks_group int null;
alter table task add foreign key (tasks_group_id) references tasks_group (id);