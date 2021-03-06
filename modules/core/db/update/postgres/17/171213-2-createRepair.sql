alter table CARSERVICE_REPAIR add constraint FK_CARSERVICE_REPAIR_CENTER foreign key (CENTER_ID) references CARSERVICE_CAR_SERVICE_CENTER(ID);
alter table CARSERVICE_REPAIR add constraint FK_CARSERVICE_REPAIR_EMPLOYEE foreign key (EMPLOYEE_ID) references CARSERVICE_EMPLOYEE(ID);
create index IDX_CARSERVICE_REPAIR_CENTER on CARSERVICE_REPAIR (CENTER_ID);
create index IDX_CARSERVICE_REPAIR_EMPLOYEE on CARSERVICE_REPAIR (EMPLOYEE_ID);
