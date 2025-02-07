-- liquibase formatted sql
--------------------------------------------------------------------------------
insert into DICT.ORDER_STATUS(ID, CODE)
values(nextval('DICT.ORDER_STATUS_PK_SEQ'), 'CREATED'),
      (nextval('DICT.ORDER_STATUS_PK_SEQ'), 'PROCESSING'),
      (nextval('DICT.ORDER_STATUS_PK_SEQ'), 'SHIPPED'),
      (nextval('DICT.ORDER_STATUS_PK_SEQ'), 'DELIVERED'),
      (nextval('DICT.ORDER_STATUS_PK_SEQ'), 'CANCELLED');