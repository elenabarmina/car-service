alter table CARSERVICE_CITY add constraint FK_CARSERVICE_CITY_CAR_SERVICE_CENTER foreign key (CAR_SERVICE_CENTER_ID) references CARSERVICE_CAR_SERVICE_CENTER(ID);
create index IDX_CARSERVICE_CITY_CAR_SERVICE_CENTER on CARSERVICE_CITY (CAR_SERVICE_CENTER_ID);
