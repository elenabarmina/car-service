alter table CARSERVICE_CITY add column IS_DEFAULT boolean ^
update CARSERVICE_CITY set IS_DEFAULT = false where IS_DEFAULT is null ;
alter table CARSERVICE_CITY alter column IS_DEFAULT set not null ;
