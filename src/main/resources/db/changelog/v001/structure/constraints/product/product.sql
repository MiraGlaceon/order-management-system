-- liquibase formatted sql
-------------------------------------------------------------------
alter table PRODUCT.PRODUCT add constraint PRODUCT_PRODUCT_001_CHK check (ID > 0);
alter table PRODUCT.PRODUCT add constraint PRODUCT_PRODUCT_002_CHK check (CREATED_BY <> '');
alter table PRODUCT.PRODUCT add constraint PRODUCT_PRODUCT_003_CHK check (LAST_MODIFIED_BY <> '');
alter table PRODUCT.PRODUCT add constraint PRODUCT_PRODUCT_004_CHK check (NAME <> '');
alter table PRODUCT.PRODUCT add constraint PRODUCT_PRODUCT_005_CHK check (PRICE > 0);
alter table PRODUCT.PRODUCT add constraint PRODUCT_PRODUCT_006_CHK check (AVAILABLE_QUANTITY > 0);

