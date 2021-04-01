/*1. В одном запросе получить
  - имена всех person, которые не состоят в компании с id = 5;
  - название компании для каждого человека.*/
select p.id, p.name, c.name  from person as p
join company as c on p.company_id = c.id and c.id != 5;

--2. Необходимо выбрать название компании с максимальным количеством человек + количество человек в этой компании.

-- Создаем представление:
create view presoncount as (select c.name, count(p.company_id) from company as c
join person as p on c.id = p.company_id
group by c.name, p.company_id);
-- И запрос
select name, max(count) from personcount group by name having  max(count) = (select max(count) from personcount);