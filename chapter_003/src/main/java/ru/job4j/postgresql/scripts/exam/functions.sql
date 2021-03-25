create view joinUM
	as  select u.id as user_id,
				u.name as user_name,
				m.id as meeting_id,
				m.name as meeting_name
	from users as u
	left join meetings as m
	on u.id = m.id;

select * from joinUM;

select u.name, m.name from users as u
	left join users_meetings as um on um.user_id = u.id and um.offer = true
	join meetings as m on um.meeting_id = m.id;
