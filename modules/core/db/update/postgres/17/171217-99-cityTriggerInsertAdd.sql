DROP TRIGGER trg_reset_default_city ON carservice_city;
CREATE TRIGGER trg_reset_default_city
    BEFORE UPDATE OR INSERT ON carservice_city
    FOR EACH ROW
    EXECUTE PROCEDURE public.trg_func_reset_default_city();
