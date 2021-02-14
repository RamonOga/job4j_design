/*Таблицы мастеров и клиентов*/
create table masters (
                 id serial primary key,
                 name varchar(255),
                 skill int
);
create table clients (
                id serial primary key,
                name varchar(255),
                master_id int references masters(id)
);
insert into masters (name, skill) values ('Roman', 89);
insert into masters (name, skill) values ('Ura_Zdesia', 0);
insert into masters (name, skill) values ('Rafa', 50);
insert into clients (name, master_id) values ('Mike', 1);
insert into clients (name, master_id) values ('Djon', 2);
insert into clients (name, master_id) values ('Ruslan', 3);
insert into clients (name, master_id) values ('Bob', 1);
insert into clients (name, master_id) values ('Boris', 2);
insert into clients (name, master_id) values ('Ivan', 3);

/*Выводит все мастеров с навыком больше нуля и их клиентов*/
select m.name as Имя_Мастера, c.name as Имя_Клиента from masters as m
    join clients as c on m.skill > 0 and c.master_id = m.id;
/*Выводит всех клиентов и привязаных к ним мастеров*/
select c.name, m.name from masters as m join clients as c on c.master_id = m.id;

/*Выводит тоько клиентов мастера по имени Roman */
select m.name, c.name from masters as m join clients as c on m.name = 'Roman' and c.master_id = m.id;

