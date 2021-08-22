drop table if exists employee CASCADE;
drop table if exists subdivision CASCADE;
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1 increment by 1;
create table employee
(
    id             bigint       not null,
    first_name     varchar(255) not null,
    last_name      varchar(255) not null,
    number         varchar(255) not null,
    subdivision_id bigint       not null,
    primary key (id)
);
create table subdivision
(
    id        bigint       not null,
    code      varchar(255) not null,
    parent_id bigint,
    primary key (id)
);
alter table employee
    add constraint UK_9d7tncgdpi8iceh7887pvl2y0 unique (number);
alter table subdivision
    add constraint UK_fe1gk112eoe19c4atfqa7il92 unique (code);
alter table employee
    add constraint FKnsoqgjbckhxwqsbewnbv237lw
        foreign key (subdivision_id)
            references subdivision;
alter table subdivision
    add constraint FKg6ar5y5ttun7wt4s0xmw6s8t
        foreign key (parent_id)
            references subdivision;