-- liquibase formatted sql
--------------------------------------------------------------------------------
create sequence if not exists CRM.OMS_USER_PK_SEQ start with 1 increment by 1;
select setval('CRM.OMS_USER_PK_SEQ', coalesce(max(ID), 1), coalesce(max(ID), 0) > 0) from CRM.OMS_USER;