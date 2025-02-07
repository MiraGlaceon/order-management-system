-- liquibase formatted sql
-------------------------------------------------------------------
drop table if exists PRODUCT.ORDER;
--
create table PRODUCT.ORDER
(
 ID                     BIGINT PRIMARY KEY NOT NULL,
 CREATED_BY             VARCHAR(100) DEFAULT 'system' NOT NULL,
 CREATED_DATE           TIMESTAMP WITH TIME ZONE DEFAULT CLOCK_TIMESTAMP() NOT NULL,
 LAST_MODIFIED_BY       VARCHAR(100),
 LAST_MODIFIED_DATE     TIMESTAMP WITH TIME ZONE,
 VERSION                INTEGER DEFAULT 1 NOT NULL,
 ORDER_NUMBER           INTEGER NOT NULL,
 USER_ID                BIGINT NOT NULL,
 ORDER_STATUS_ID        BIGINT NOT NULL,
 TOTAL_PRICE            NUMERIC NOT NULL
);

comment on table PRODUCT.ORDER is 'Orders';

comment on column PRODUCT.ORDER.USER_ID is 'Owner of order';
comment on column PRODUCT.ORDER.ORDER_STATUS_ID is 'Status of order';