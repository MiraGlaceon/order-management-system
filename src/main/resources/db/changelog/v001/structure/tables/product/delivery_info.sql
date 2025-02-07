-- liquibase formatted sql
-------------------------------------------------------------------
drop table if exists PRODUCT.DELIVERY_INFO;
--
create table PRODUCT.DELIVERY_INFO
(
 ID                     BIGINT PRIMARY KEY NOT NULL,
 CREATED_BY             VARCHAR(100) DEFAULT 'system' NOT NULL,
 CREATED_DATE           TIMESTAMP WITH TIME ZONE DEFAULT CLOCK_TIMESTAMP() NOT NULL,
 LAST_MODIFIED_BY       VARCHAR(100),
 LAST_MODIFIED_DATE     TIMESTAMP WITH TIME ZONE,
 VERSION                INTEGER DEFAULT 1 NOT NULL,
 ADDRESS_ID             BIGINT NOT NULL,
 ESTIMATED_DATE         TIMESTAMP WITH TIME ZONE,
 ORDER_ID               BIGINT
);

comment on table PRODUCT.DELIVERY_INFO is 'Delivery information for order';

comment on column PRODUCT.DELIVERY_INFO.ADDRESS_ID is 'Address where order must be delivered';
comment on column PRODUCT.DELIVERY_INFO.ESTIMATED_DATE is 'Date and time when order must be delivered';
comment on column PRODUCT.DELIVERY_INFO.ORDER_ID is 'Order which must be delivered';