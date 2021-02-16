-- 1. Вывести список всех машин и все привязанные к ним детали.
select c.name as car, b as Body, t as Transmission, e as Engine from car c
join body b on c.body_id = b.id
join transmission t on c.trans_id = t.id
join engine e on c.engine_id = e.id;

-- 2.  Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.

-- Вариант №1
select * from car c join body b on c.body_id != b.id;

-- Вариант №2
select c.id, c.name as Машина , b.name as Кузов, t.name as Трансмиссия, e.name двиготель
from car c left
join body b on c.body_id != b.id
join transmission t on c.trans_id != t.id
join engine e on c.engine_id != e.id;