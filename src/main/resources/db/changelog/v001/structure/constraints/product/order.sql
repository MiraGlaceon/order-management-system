-- liquibase formatted sql
-------------------------------------------------------------------
alter table PRODUCT.ORDER add constraint PRODUCT_ORDER_001_CHK check (ID > 0);
alter table PRODUCT.ORDER add constraint PRODUCT_ORDER_002_CHK check (CREATED_BY <> '');
alter table PRODUCT.ORDER add constraint PRODUCT_ORDER_003_CHK check (LAST_MODIFIED_BY <> '');
alter table PRODUCT.ORDER add constraint PRODUCT_ORDER_004_CHK check (TOTAL_PRICE > 0);
alter table PRODUCT.ORDER add constraint PRODUCT_ORDER_005_CHK check (ORDER_NUMBER > 0);

alter table PRODUCT.ORDER add constraint PRODUCT_ORDER_001_FK foreign key (USER_ID) references CRM.OMS_USER(ID) deferrable;
alter table PRODUCT.ORDER add constraint PRODUCT_ORDER_002_FK foreign key (ORDER_STATUS_ID) references DICT.ORDER_STATUS(ID) deferrable;