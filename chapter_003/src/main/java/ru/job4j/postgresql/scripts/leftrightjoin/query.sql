-- Используя left и right join написать запросы, которые давали бы одинаковый результат.
select d.name as Отдел, e.name as Работник
from deportments d
         left join emploees e on d.id = e.depo_id;

select d.name as Отдел, e.name as Работник
from emploees e
         right join  deportments d on d.id = e.depo_id;

-- Используя left join найти департаменты, у которых нет работников
select d.name as Отдел, e.name as Работник
from deportments d
    left join emploees e on d.id = e.depo_id
where e.depo_id is null;

-- Создать таблицу teens с атрибутами name, gender и заполнить ее.
-- Используя cross join составить все возможные разнополые пары
select t1.name, t2.name from teens as t1
                                 cross join teens as t2
where t1.gender != t2.gender and t1.gender != 'Female';
