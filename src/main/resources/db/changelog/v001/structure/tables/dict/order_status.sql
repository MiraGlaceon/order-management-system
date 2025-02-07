-- liquibase formatted sql
-------------------------------------------------------------------
drop table if exists DICT.ORDER_STATUS;
--
create table DICT.ORDER_STATUS
(
 ID                 BIGINT PRIMARY KEY NOT NULL,
 CODE               VARCHAR NOT NULL
);

comment on table DICT.ORDER_STATUS is 'Status of order';

comment on column DICT.ORDER_STATUS.CODE is 'Code of status (CREATED, PROCESSING, SHIPPED, DELIVERED, CANCELLED)'