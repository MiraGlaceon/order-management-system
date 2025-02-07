-- liquibase formatted sql
-------------------------------------------------------------------
create unique index if not exists DELIVERY_INFO_ORDER_ID_IDX on PRODUCT.DELIVERY_INFO(ORDER_ID);