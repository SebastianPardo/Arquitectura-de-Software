/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     25/02/2017 03:38:01 p.m.                     */
/*==============================================================*/

/* Correccion BD - Creacion tabla de rompimiento Usuario - Interes */
/* 

USE RED;

drop table if exists AUTENTICACION;

drop table if exists VISIBILIDAD_INFORMACION;

/*==============================================================*/
/* Table: AUTENTICACION                                         */
/*==============================================================*/
create table AUTENTICACION
(
   ID_USUARIO           int not null,
   USERNAME             varchar(1024) not null,
   PASS                 varchar(1024) not null,
   primary key (ID_USUARIO)
);

/*==============================================================*/
/* Table: VISIBILIDAD_INFORMACION                               */
/*==============================================================*/
create table VISIBILIDAD_INFORMACION
(
   ID_USUARIO           int not null,
   VIS_ALIAS            int,
   VIS_CORREO           int,
   VIS_SEXO             int,
   VIS_TELEFONO         int,
   VIS_FECHA_NAC        int,
   primary key (ID_USUARIO)
);
