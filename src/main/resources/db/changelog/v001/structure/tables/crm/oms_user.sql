-- liquibase formatted sql
--------------------------------------------------------------------------------
drop table if exists CRM.OMS_USER;
--
create table CRM.OMS_USER
(
 ID                     BIGINT PRIMARY KEY NOT NULL,
 CREATED_BY             VARCHAR(100) DEFAULT 'system' NOT NULL,
 CREATED_DATE           TIMESTAMP WITH TIME ZONE DEFAULT CLOCK_TIMESTAMP() NOT NULL,
 LAST_MODIFIED_BY       VARCHAR(100),
 LAST_MODIFIED_DATE     TIMESTAMP WITH TIME ZONE,
 VERSION                INTEGER DEFAULT 1 NOT NULL,
 LOGIN                  VARCHAR(50) NOT NULL,
 PASSWORD               VARCHAR(50) NOT NULL,
 NICKNAME               VARCHAR(50) NOT NULL,
 EMAIL                  VARCHAR(250)
);

comment on table CRM.OMS_USER is 'Authorized customers';