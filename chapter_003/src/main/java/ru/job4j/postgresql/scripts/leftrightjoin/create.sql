create table deportments (
        id serial primary key,
        name varchar(255)
);

create table emploees (
        id serial primary key,
        name varchar(255),
        depo_id int references deportments(id)
);