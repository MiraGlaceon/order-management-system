-- liquibase formatted sql
-------------------------------------------------------------------
drop table if exists CRM.ADDRESS;
--
create table CRM.ADDRESS
(
 ID                     BIGINT PRIMARY KEY NOT NULL,
 CREATED_BY             VARCHAR(100) DEFAULT 'system' NOT NULL,
 CREATED_DATE           TIMESTAMP WITH TIME ZONE DEFAULT CLOCK_TIMESTAMP() NOT NULL,
 LAST_MODIFIED_BY       VARCHAR(100),
 LAST_MODIFIED_DATE     TIMESTAMP WITH TIME ZONE,
 VERSION                INTEGER DEFAULT 1 NOT NULL,
 CITY                   VARCHAR(50) NOT NULL,
 STREET                 VARCHAR(50) NOT NULL,
 HOUSE                  VARCHAR(50) NOT NULL,
 FULL_ADDRESS           VARCHAR(150),
 USER_ID                BIGINT
);

comment on table CRM.ADDRESS is 'Address of customer';

comment on column CRM.ADDRESS.FULL_ADDRESS is 'Full address in free form';
comment on column CRM.ADDRESS.USER_ID is 'Owner of addess';