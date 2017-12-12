alter table CARSERVICE_EMPLOYEE add column CENTER_ID uuid ;
alter table CARSERVICE_EMPLOYEE drop column CAR_SERVICE_ID cascade ;
