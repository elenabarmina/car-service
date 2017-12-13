CREATE FUNCTION public.trg_func_reset_default_city()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    NOT LEAKPROOF 
AS $BODY$
BEGIN
if NEW.is_default = true
then update carservice_city set is_default = false where is_default = true;
end if;
return new;
end;
$BODY$;

ALTER FUNCTION public.trg_func_reset_default_city()
    OWNER TO postgres;

CREATE TRIGGER trg_reset_default_city
    BEFORE UPDATE ON carservice_city
    FOR EACH ROW
    EXECUTE PROCEDURE public.trg_func_reset_default_city();
