create table CARSERVICE_INDIVIDUAL (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PASSPORT_NO varchar(20) not null,
    --
    primary key (ID)
);
