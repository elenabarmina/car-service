alter table CARSERVICE_CAR_SERVICE_CENTER add constraint FK_CARSERVICE_CAR_SERVICE_CENTER_CITY foreign key (CITY_ID) references CARSERVICE_CITY(ID);
create index IDX_CARSERVICE_CAR_SERVICE_CENTER_CITY on CARSERVICE_CAR_SERVICE_CENTER (CITY_ID);
