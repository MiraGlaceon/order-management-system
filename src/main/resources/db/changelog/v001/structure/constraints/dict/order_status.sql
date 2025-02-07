-- liquibase formatted sql
-------------------------------------------------------------------
alter table DICT.ORDER_STATUS add constraint DICT_ORDER_STATUS_001_CHK check (ID > 0);
alter table DICT.ORDER_STATUS add constraint DICT_ORDER_STATUS_002_CHK check (CODE <> '');