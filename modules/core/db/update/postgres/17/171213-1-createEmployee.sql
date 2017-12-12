create table CARSERVICE_EMPLOYEE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIRST_NAME varchar(100) not null,
    CAR_SERVICE_ID uuid,
    LAST_NAME varchar(100) not null,
    EMAIL varchar(100) not null,
    DATE_BIRTH date not null,
    SALARY decimal(19, 2) not null,
    --
    primary key (ID)
);
