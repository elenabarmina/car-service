-- begin CARSERVICE_CAR_SERVICE_CENTER
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
    CREATOR_ID uuid,
    CITY_ID uuid,
    PHONE varchar(15) not null,
    ADDRESS varchar(255) not null,
    --
    primary key (ID)
)^
-- end CARSERVICE_CAR_SERVICE_CENTER
-- begin CARSERVICE_CITY
create table CARSERVICE_CITY (
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
    IS_DEFAULT boolean not null,
    PHONE_CODE varchar(5) not null,
    --
    primary key (ID)
)^
-- end CARSERVICE_CITY

-- begin CARSERVICE_EMPLOYEE
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
    CENTER_ID uuid,
    LAST_NAME varchar(100) not null,
    EMAIL varchar(100) not null,
    DATE_BIRTH date not null,
    SALARY decimal(19, 2) not null,
    --
    primary key (ID)
)^
-- end CARSERVICE_EMPLOYEE
-- begin CARSERVICE_CUSTOMER
create table CARSERVICE_CUSTOMER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(100),
    --
    NAME varchar(200) not null,
    EMAIL varchar(100) not null,
    PHONE varchar(50) not null,
    --
    primary key (ID)
)^
-- end CARSERVICE_CUSTOMER
-- begin CARSERVICE_REPAIR
create table CARSERVICE_REPAIR (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DESCRIPTION text not null,
    CENTER_ID uuid,
    EMPLOYEE_ID uuid,
    --
    primary key (ID)
)^
-- end CARSERVICE_REPAIR
-- begin CARSERVICE_INDIVIDUAL
create table CARSERVICE_INDIVIDUAL (
    ID uuid,
    --
    PASSPORT_NO varchar(20) not null,
    --
    primary key (ID)
)^
-- end CARSERVICE_INDIVIDUAL
-- begin CARSERVICE_COMPANY
create table CARSERVICE_COMPANY (
    ID uuid,
    --
    INN varchar(100) not null,
    --
    primary key (ID)
)^
-- end CARSERVICE_COMPANY
-- begin CARSERVICE_CAR_SERVICE_CENTER_CUSTOMER_LINK
create table CARSERVICE_CAR_SERVICE_CENTER_CUSTOMER_LINK (
    CUSTOMER_ID uuid,
    CAR_SERVICE_CENTER_ID uuid,
    primary key (CUSTOMER_ID, CAR_SERVICE_CENTER_ID)
)^
-- end CARSERVICE_CAR_SERVICE_CENTER_CUSTOMER_LINK
