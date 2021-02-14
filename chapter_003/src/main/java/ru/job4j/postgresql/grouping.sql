--таблица студентов
create table students(
                         id serial primary key,
                         name varchar(255)
);
-- таблица предметов
create table subjects(
                         id serial primary key,
                         name varchar(255)
);
-- связывающая таблица
create table students_subjects(
                                  id serial primary key,
                                  student_id int references students(id),
                                  subject_id int references subjects(id),
    -- оценка студента по предмету
                                  mark int
);

insert into students(name) values ('Аня');
insert into students(name) values ('Ваня');
insert into students(name) values ('Боря');

insert into subjects(name) values ('Математика');
insert into subjects(name) values ('Русский');
insert into subjects(name) values ('Информатика');

insert into students_subjects(student_id, subject_id, mark) values (1, 1, 5);
insert into students_subjects(student_id, subject_id, mark) values (1, 2, 5);
insert into students_subjects(student_id, subject_id, mark) values (1, 3, 5);


insert into students_subjects(student_id, subject_id, mark) values (2, 1, 5);
insert into students_subjects(student_id, subject_id, mark) values (2, 2, 4);
insert into students_subjects(student_id, subject_id, mark) values (2, 3, 4);

insert into students_subjects(student_id, subject_id, mark) values (3, 1, 3);
insert into students_subjects(student_id, subject_id, mark) values (3, 2, 5);
insert into students_subjects(student_id, subject_id, mark) values (3, 3, 3);

select s.name, avg(ss.mark) from students_subjects as ss join students s on ss.student_id = s.id
group by s.name
having avg(ss.mark) > 4.5;

select s.name, avg(ss.mark) from students_subjects as ss join students s on ss.subject_id = s.id
group by s.name
having avg(ss.mark) > 4.5;

select s.name, avg(ss.mark) from students_subjects as ss join students s on ss.subject_id = s.id
group by s.name
having avg(ss.mark) > 4.5;