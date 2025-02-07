-- liquibase formatted sql
-------------------------------------------------------------------
create index if not exists ORDER_USER_ID_IDX on PRODUCT.ORDER(USER_ID);
create index if not exists ORDER_STATUS_ID_IDX on PRODUCT.ORDER(ORDER_STATUS_ID);