alter table CARSERVICE_EMPLOYEE add constraint FK_CARSERVICE_EMPLOYEE_CAR_SERVICE foreign key (CAR_SERVICE_ID) references CARSERVICE_CAR_SERVICE_CENTER(ID);
create index IDX_CARSERVICE_EMPLOYEE_CAR_SERVICE on CARSERVICE_EMPLOYEE (CAR_SERVICE_ID);
