create table CARSERVICE_CAR_SERVICE_CENTER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(100) not null,
    PHONE varchar(15) not null,
    ADDRESS varchar(255) not null,
    --
    primary key (ID)
);
