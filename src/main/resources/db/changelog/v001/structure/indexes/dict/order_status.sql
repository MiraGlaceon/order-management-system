-- liquibase formatted sql
-------------------------------------------------------------------
create unique index if not exists ORDER_STATUS_CODE_IDX on DICT.ORDER_STATUS(CODE);