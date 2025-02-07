-- liquibase formatted sql
--------------------------------------------------------------------------------
create sequence if not exists CRM.ADDRESS_PK_SEQ start with 1 increment by 1;
select setval('CRM.ADDRESS_PK_SEQ', coalesce(max(ID), 1), coalesce(max(ID), 0) > 0) from CRM.ADDRESS;