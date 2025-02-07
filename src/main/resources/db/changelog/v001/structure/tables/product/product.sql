-- liquibase formatted sql
-------------------------------------------------------------------
drop table if exists PRODUCT.PRODUCT;
--
create table PRODUCT.PRODUCT
(
 ID                     BIGINT PRIMARY KEY NOT NULL,
 CREATED_BY             VARCHAR(100) DEFAULT 'system' NOT NULL,
 CREATED_DATE           TIMESTAMP WITH TIME ZONE DEFAULT CLOCK_TIMESTAMP() NOT NULL,
 LAST_MODIFIED_BY       VARCHAR(100),
 LAST_MODIFIED_DATE     TIMESTAMP WITH TIME ZONE,
 VERSION                INTEGER DEFAULT 1 NOT NULL,
 NAME                   VARCHAR(50) NOT NULL,
 PRICE                  NUMERIC NOT NULL,
 AVAILABLE_QUANTITY     INTEGER DEFAULT 0 NOT NULL
);

comment on table PRODUCT.PRODUCT is 'Products';