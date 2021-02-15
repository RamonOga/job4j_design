select d.name as Отдел, e.name as Работник from deporment d left join emploees e on d.id = e.depo_id;
select d.name as Отдел, e.name as Работник from emploees e right join  deportments d on d.id = e.depo_id;
select d.name as Отдел, e.name as Работник from emploees e right join  deportments d on d.id = e.depo_id where e.dep;
