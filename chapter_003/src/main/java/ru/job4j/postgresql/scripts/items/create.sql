create table rules_role (
                            id serial primary key,
                            name varchar(255)

);
create table rules (
                       id serial primary key,
                       name varchar(255),
                       write bool,
                       read bool,
                       creating bool,
                       delete bool
);
create table role (
                      id serial primary key,
                      name varchar(255),
                      permissions int
);
alter table rules_role add column role_id int references role(id) unique;
alter table rules_role add column rules_id int references rules(id) unique;
create table item_user (
                           id serial primary key,
                           name varchar(255),
                           role_id int references role(id)
);
create table state (
                       id serial primary key,
                       status varchar(255)
);
create table category (
                          id serial primary key,
                          name varchar(255)
);
create table item (
                      id serial primary key,
                      name varchar(255),
                      preority int,
                      user_id int references item_user(id),
                      state_id int references state(id),
                      category_id int references category(id)
);
create table comments (
                          id serial primary key,
                          text text,
                          item_id int references item(id)
);
create table attaches (
                          id serial primary key,
                          path varchar(255),
                          item_id int references item(id)
);
