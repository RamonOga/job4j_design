create view joinUM
	as  select u.id as user_id,
				u.name as user_name,
				m.id as meeting_id,
				m.name as meeting_name
	from users as u
	left join meetings as m
	on u.id = m.id;