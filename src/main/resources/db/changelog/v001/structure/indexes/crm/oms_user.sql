-- liquibase formatted sql
-------------------------------------------------------------------
create unique index if not exists OMS_USER_LOGIN_PASSWORD_IDX on CRM.OMS_USER(LOGIN, PASSWORD);