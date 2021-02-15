create table body (
    id serial primary key,
    name varchar(255),
    type varchar(255),
    color varchar(255)
);
create table transmission (
    id serial primary key,
    name varchar(255),
    type varchar(255)
);
create table engine (
    id serial primary key,
    name varchar(255),
    type varchar(255),
    power int
);
create table car (
    id serial primary key,
    name varchar(255),
    body_id int references body(id),
    trans_id int references transmission(id),
    engine_id int references engine(id)
);