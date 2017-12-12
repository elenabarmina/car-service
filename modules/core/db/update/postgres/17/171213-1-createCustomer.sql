create table CARSERVICE_CUSTOMER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(200) not null,
    EMAIL varchar(100) not null,
    PHONE varchar(50) not null,
    --
    primary key (ID)
);
