insert into item_user (name) values ('Admin');
insert into item_user (name) values ('User');
insert into item_user (name) values ('User2');
insert into item_user (name) values ('User3');
insert into role (name, permissions) values ('admin_role', 10);
insert into role (name, permissions) values ('user_role', 1);
insert into rules (name, write, read, creating, delete) values ('admin_rule', true, true, true, true);
insert into rules (name, write, read, creating, delete) values ('user_rule', false, true, true, false);
insert into rules_role (name, role_id, rules_id) values ('admin_role_to_admin_rule', 1, 1);
insert into rules_role (name, role_id, rules_id) values ('user_role_to_user_role', 2, 2);
update item_user set role_id=1 where name='Admin';
update item_user set role_id=2 where name='User';
update item_user set role_id=2 where name='User2';
update item_user set role_id=2 where name='User3';

insert into item (name, preority, user_id) values ('need help', '2', 2);
insert into category (name, item_id) values ('stuped user', 1);
insert into comments (name, text, item_id) values ('need help', 'I don.t see my comp', 1);
insert into attaches (name, path, item_id) values ('photo', 'c:\img\1.jpg', 1);
insert into state (name, done, item_id) values ('need help', false, 1);

insert into item (name, preority, user_id) values ('network don.t work', '5', 3);
insert into category (name, item_id) values ('network', 2);
insert into comments (name, text, item_id) values ('network', 'don.t open pornohub', 2);
insert into attaches (name, path, item_id) values ('photo', 'c:\img\p.jpg', 2);
insert into state (name, done, item_id) values ('network', false, 2);

insert into item (name, preority, user_id) values ('we have a backups?', '10', 4);
insert into category (name, item_id) values ('backups', 3);
insert into comments (name, text, item_id) values ('backups', 'where are ours backups, man?', 3);
insert into attaches (name, path, item_id) values ('backups', 'c:\img\b.jpg', 3);
insert into state (name, done, item_id) values ('backups', true, 3);

select * from item_user;
select * from role;
select * from rules;
select * from rules_role;
select * from item;
select * from category;
select * from comments;
select * from attaches;
select * from state;

