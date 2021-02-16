insert into body (name, type, color) values ('rs', 'sedan', 'yellow');
insert into body (name, type, color) values ('rh', 'hatchback', 'red');
insert into body (name, type, color) values ('ru', 'universal', 'blue');
insert into body (name, type, color) values ('cs', 'segan', 'silver');

insert into transmission (name, type) values ('r1', 'manual');
insert into transmission (name, type) values ('a1', 'auto');
insert into transmission (name, type) values ('a1', 'auto');

insert into engine (name, type, power) values ('w8', 'gasoline', 1600);
insert into engine (name, type, power) values ('d8', 'diesel', 1600);
insert into engine (name, type, power) values ('e8', 'electric', 1600);
insert into engine (name, type, power) values ('w7', 'gasoline', 1400);

insert into car (name, body_id, trans_id, engine_id) values ('rio sedan', 1, 1, 1);
insert into car (name, body_id, trans_id, engine_id) values ('rio hatchback', 2, 2, 2);
insert into car (name, body_id, trans_id, engine_id) values ('rio universal', 3, 1, 3);

select * from body;
select * from transmission;
select * from engine;
select * from car;