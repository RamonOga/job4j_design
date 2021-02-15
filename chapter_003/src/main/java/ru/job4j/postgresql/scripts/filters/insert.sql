insert into type (name) values ('bread');
insert into type (name) values ('cheese');
insert into type (name) values ('milk');
insert into type (name) values ('beer');
insert into type (name) values ('chocolate');

insert into product (name, type_id, expired_date, price, quantity ) values ('white bread', 1, date '2021-02-02', 10, 5);
insert into product (name, type_id, expired_date, price, quantity ) values ('grey bread', 1, date '2021-03-03', 20, 10);
insert into product (name, type_id, expired_date, price, quantity ) values ('black bread', 1, date '2021-04-04', 30, 15);

insert into product (name, type_id, expired_date, price, quantity ) values ('junior cheese', 2, date '2021-02-02', 200, 5);
insert into product (name, type_id, expired_date, price, quantity ) values ('middle cheese', 2, date '2021-03-03', 300, 10);
insert into product (name, type_id, expired_date, price, quantity ) values ('senior cheese', 2, date '2021-04-04', 400, 15);

insert into product (name, type_id, expired_date, price, quantity ) values ('junior milk', 3, date '2021-02-02', 40, 5);
insert into product (name, type_id, expired_date, price, quantity ) values ('middle milk', 3, date '2021-03-03', 50, 10);
insert into product (name, type_id, expired_date, price, quantity ) values ('senior milk', 3, date '2021-04-04', 60, 15);
insert into product (name, type_id, expired_date, price, quantity ) values ('icecream', 3, date '2021-04-04', 95, 5);

insert into product (name, type_id, expired_date, price, quantity ) values ('russian beer', 4, date '2021-02-02', 40, 5);
insert into product (name, type_id, expired_date, price, quantity ) values ('middle beer', 4, date '2021-03-03', 60, 10);
insert into product (name, type_id, expired_date, price, quantity ) values ('export beer', 4, date '2021-04-04', 100, 15);

insert into product (name, type_id, expired_date, price, quantity ) values ('budget chocolate', 5, date '2021-02-02', 60, 5);
insert into product (name, type_id, expired_date, price, quantity ) values ('milk chocolate', 5, date '2021-03-03', 100, 10);
insert into product (name, type_id, expired_date, price, quantity ) values ('premium chocolate ', 5, date '2021-04-04', 200, 15);

select * from product;
select * from type;
