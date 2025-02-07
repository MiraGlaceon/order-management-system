-- liquibase formatted sql
-------------------------------------------------------------------
alter table CRM.ADDRESS add constraint CRM_ADDRESS_001_CHK check (ID > 0);
alter table CRM.ADDRESS add constraint CRM_ADDRESS_002_CHK check (CREATED_BY <> '');
alter table CRM.ADDRESS add constraint CRM_ADDRESS_003_CHK check (LAST_MODIFIED_BY <> '');
alter table CRM.ADDRESS add constraint CRM_ADDRESS_004_CHK check (CITY <> '');
alter table CRM.ADDRESS add constraint CRM_ADDRESS_005_CHK check (STREET <> '');
alter table CRM.ADDRESS add constraint CRM_ADDRESS_006_CHK check (HOUSE <> '');
alter table CRM.ADDRESS add constraint CRM_ADDRESS_007_CHK check (FULL_ADDRESS <> '');

alter table CRM.ADDRESS add constraint CRM_ADDRESS_001_FK foreign key (USER_ID) references CRM.OMS_USER on delete cascade deferrable;