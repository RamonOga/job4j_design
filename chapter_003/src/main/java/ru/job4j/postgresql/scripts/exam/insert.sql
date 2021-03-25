insert into users (name) values ('Vasia Petrov');
insert into users (name) values ('Petia Vasin');
insert into users (name) values ('Ulia Mashina');
insert into users (name) values ('Masha Ulina');

insert into meetings (name) values ('Java');
insert into meetings (name) values ('C#');
insert into meetings (name) values ('JS');
insert into meetings (name) values ('Delphi');

insert into users_meetings (user_id, meeting_id, offer) values(1, 1, true);
insert into users_meetings (user_id, meeting_id, offer) values(1, 2, false);
insert into users_meetings (user_id, meeting_id, offer) values(1, 3, true);
insert into users_meetings (user_id, meeting_id, offer) values(1, 4, false);

insert into users_meetings (user_id, meeting_id, offer) values(2, 1, false);
insert into users_meetings (user_id, meeting_id, offer) values(2, 2, true);
insert into users_meetings (user_id, meeting_id, offer) values(2, 3, true);
insert into users_meetings (user_id, meeting_id, offer) values(2, 4, false);

insert into users_meetings (user_id, meeting_id, offer) values(3, 1, false);
insert into users_meetings (user_id, meeting_id, offer) values(3, 2, false);
insert into users_meetings (user_id, meeting_id, offer) values(3, 3, true);
insert into users_meetings (user_id, meeting_id, offer) values(3, 4, false);

insert into users_meetings (user_id, meeting_id, offer) values(4, 1, true);
insert into users_meetings (user_id, meeting_id, offer) values(4, 2, false);
insert into users_meetings (user_id, meeting_id, offer) values(4, 3, false);
insert into users_meetings (user_id, meeting_id, offer) values(4, 4, false);

select * from users;
select * from meetings;