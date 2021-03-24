create table users (
    id serial primary key,
    name varchar(255)
);

create table meetings (
    id serial primary key,
    name varchar(255)
);

create table users_meetings (
    id serial primary key,
    user_id int references users(id),
    meeting_id int references meetings(id),
    offer bool
)