create table devices(
                        id serial primary key,
                        name varchar(255),
                        price float
);

create table people(
                       id serial primary key,
                       name varchar(255)
);

create table devices_people(
                               id serial primary key,
                               device_id int references devices(id),
                               people_id int references people(id)
);

insert into devices (name, price) values ('smartphone', 1000);
insert into devices (name, price) values ('computer', 2500);
insert into devices (name, price) values ('notebook', 3500);
insert into devices (name, price) values ('server', 12000);
insert into people (name) values ('Bogdan');
insert into people (name) values ('Herman');
insert into people (name) values ('Roman');
insert into people (name) values ('Albina');
insert into devices_people (device_id, people_id) values (1, 1);
insert into devices_people (device_id, people_id) values (1, 2);
insert into devices_people (device_id, people_id) values (1, 3);
insert into devices_people (device_id, people_id) values (1, 4);
insert into devices_people (device_id, people_id) values (2, 2);
insert into devices_people (device_id, people_id) values (3, 4);
insert into devices_people (device_id, people_id) values (4, 3);

-- Средная цена устройств.
select avg(d.price) from devices as d;

-- Таблица юзеров по девайсам
select p.name, d.name, d.price
from people as p
         join devices_people dp on p.id = dp.people_id
         join devices as d on dp.device_id = d.id;


-- Средная цена девайсов по именам.
select p.name, avg(d.price)
from people as p
         join devices_people dp on p.id = dp.people_id
         join devices as d on dp.device_id = d.id
group by p.name;

-- Средная цена девайсов по именам. учитываются только устройства дороже 5000
select p.name, avg(d.price)
from people as p
         join devices_people dp on p.id = dp.people_id
         join devices as d on dp.device_id = d.id
where d.price > 5000
group by p.name;


