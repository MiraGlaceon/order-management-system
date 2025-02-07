-- liquibase formatted sql
-------------------------------------------------------------------
alter table CRM.OMS_USER add constraint CRM_OMS_USER_001_CHK check (ID > 0);
alter table CRM.OMS_USER add constraint CRM_OMS_USER_002_CHK check (CREATED_BY <> '');
alter table CRM.OMS_USER add constraint CRM_OMS_USER_003_CHK check (LAST_MODIFIED_BY <> '');
alter table CRM.OMS_USER add constraint CRM_OMS_USER_004_CHK check (LOGIN <> '');
alter table CRM.OMS_USER add constraint CRM_OMS_USER_005_CHK check (PASSWORD <> '');
alter table CRM.OMS_USER add constraint CRM_OMS_USER_006_CHK check (NICKNAME <> '');
alter table CRM.OMS_USER add constraint CRM_OMS_USER_007_CHK check (EMAIL <> '');
