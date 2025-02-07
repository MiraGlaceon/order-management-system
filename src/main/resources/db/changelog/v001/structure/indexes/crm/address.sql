-- liquibase formatted sql
-------------------------------------------------------------------
create index if not exists ADDRESS_USER_ID_IDX on CRM.ADDRESS(USER_ID);