-- liquibase formatted sql
-------------------------------------------------------------------
alter table PRODUCT.DELIVERY_INFO add constraint PRODUCT_DELIVERY_INFO_001_CHK check (ID > 0);
alter table PRODUCT.DELIVERY_INFO add constraint PRODUCT_DELIVERY_INFO_002_CHK check (CREATED_BY <> '');
alter table PRODUCT.DELIVERY_INFO add constraint PRODUCT_DELIVERY_INFO_003_CHK check (LAST_MODIFIED_BY <> '');

alter table PRODUCT.DELIVERY_INFO add constraint PRODUCT_DELIVERY_INFO_001_UNQ unique (ADDRESS_ID);

alter table PRODUCT.DELIVERY_INFO add constraint PRODUCT_DELIVERY_INFO_001_FK foreign key (ADDRESS_ID) references CRM.ADDRESS(ID) deferrable;
alter table PRODUCT.DELIVERY_INFO add constraint RPODUCR_DELIVERY_INFO_002_FK foreign key (ORDER_ID) references PRODUCT.ORDER on delete cascade deferrable;