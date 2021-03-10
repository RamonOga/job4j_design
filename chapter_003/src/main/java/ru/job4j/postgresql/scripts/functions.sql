create or replace function  shit_func(delId integer)
    returns integer
    language 'plpgsql'
as $shit$
declare
begin
    delete from names as n where n.id = delId;
    return delId;
end;
$shit$;
