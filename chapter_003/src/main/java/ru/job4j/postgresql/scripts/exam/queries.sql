--2. Нужно написать запрос, который получит список всех заяков и количество подтвердивших участников.
select m.name, coalesce(count(meeting_id), 1) as count from meetings as m
join users_meetings as u_m on m.id = u_m.meeting_id and offer = true
group by m.name;


-- 3. Нужно получить все совещания, где не было ни одной заявки на посещения
select m.name, coalesce(count(meeting_id), 1) as count from meetings as m
left join users_meetings as u_m on m.id = u_m.meeting_id and offer = true
group by m.name
having count(offer) = 0;