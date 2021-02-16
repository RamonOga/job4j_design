
-- 1. Написать запрос получение всех продуктов с типом "СЫР"
select p.name, t.name from product as p join type as t on p.type_id = t.id and t.name = 'cheese';

-- 2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select * from product where name like '%icecream%';

-- 3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select * from product where extract (month from expired_date) = extract (month from current_date) + 1;

-- 4. Написать запрос, который выводит самый дорогой продукт.
select * from product where price = (select max(price) from product);

-- 5. Написать запрос, который выводит количество всех продуктов определенного типа.
select t.name, sum(p.quantity) from type as t join product as p on p.type_id = t.id group by t.name, p.type_id, t.id having p.type_id = t.id;

-- 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select p.name, t.name, p.price, p.quantity, p.expired_date from product as p
          join type as t
          on p.type_id = t.id and (t.name = 'cheese' or t.name = 'milk');

-- 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
select t.name, sum(p.quantity) from type as t join product as p on p.type_id = t.id group by t.name, p.type_id, t.id having sum(p.quantity) > 10;

-- 8. Вывести все продукты и их тип.
select p.name, t.name from product as p
join type as t on p.type_id = t.id;