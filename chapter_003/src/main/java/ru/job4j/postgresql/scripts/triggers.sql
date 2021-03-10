<!--
create or replace function trig_func()
    returns trigger
as $$
BEGIN
    INSERT INTO other_names(name, lastName) VALUES (NEW.name, NEW.lastName);

    RETURN NEW;
end;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger AFTER INSERT ON names
    FOR EACH ROW EXECUTE PROCEDURE trig_func()


