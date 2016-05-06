/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/10/27 22:09:49                          */
/*==============================================================*/


drop table if exists Student;

drop table if exists admin;

drop table if exists enterprise;

drop table if exists job;

drop table if exists jz;

drop table if exists model;

drop table if exists vita;

/*==============================================================*/
/* Table: Student                                               */
/*==============================================================*/
create table Student
(
   u_id                 int not null,
   u_name               varchar(20),
   u_pwd                varchar(32),
   u_sex                varchar(4),
   u_email              varchar(20),
   u_phone              varchar(11),
   u_touxiang           varchar(20),
   primary key (u_id)
);

/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
create table admin
(
   a_id                 int not null,
   a_name               varchar(20),
   a_pwd                varchar(32),
   a_emalil             varchar(20),
   a_phone              varchar(11),
   primary key (a_id)
);

/*==============================================================*/
/* Table: enterprise                                            */
/*==============================================================*/
create table enterprise
(
   q_id                 int not null,
   q_name               varchar(20),
   q_pwd                varchar(32),
   q_date               timestamp,
   q_xingzhi            varchar(10),
   q_guimo              varchar(10),
   q_area               varchar(20),
   q_youbian            int,
   q_email              varchar(10),
   q_phone              varchar(11),
   q_miaoshu            text,
   primary key (q_id)
);

/*==============================================================*/
/* Table: job                                                   */
/*==============================================================*/
create table job
(
   z_id                 int not null,
   q_id                 int,
   z_name               varchar(20),
   z_date               timestamp,
   z_area               varchar(20),
   z_renshu             varchar(6),
   z_zhineng            varchar(10),
   z_miaoshu            text,
   z_xinzi              varchar(10),
   primary key (z_id)
);

/*==============================================================*/
/* Table: jz                                                    */
/*==============================================================*/
create table jz
(
   z_id                 int not null,
   j_id                 int not null,
   t_date               date,
   k_date               date,
   primary key (z_id, j_id)
);

/*==============================================================*/
/* Table: model                                                 */
/*==============================================================*/
create table model
(
   m_id                 int not null,
   a_id                 int,
   j_id                 int,
   m_url                varchar(20),
   primary key (m_id)
);

/*==============================================================*/
/* Table: vita                                                  */
/*==============================================================*/
create table vita
(
   j_id                 int not null,
   u_id                 int,
   j_name               varchar(20),
   j_sex                tinyint,
   j_age                int,
   j_face               varchar(8),
   j_dizhi              varchar(20),
   j_byxx               varchar(20),
   j_zy                 varchar(20),
   j_gzjl               varchar(50),
   j_xl                 varchar(6),
   j_jianjie            text,
   primary key (j_id)
);

alter table job add constraint FK_fabu foreign key (q_id)
      references enterprise (q_id) on delete restrict on update restrict;

alter table jz add constraint FK_jz foreign key (z_id)
      references job (z_id) on delete restrict on update restrict;

alter table jz add constraint FK_jz2 foreign key (j_id)
      references vita (j_id) on delete restrict on update restrict;

alter table model add constraint FK_add foreign key (a_id)
      references admin (a_id) on delete restrict on update restrict;

alter table model add constraint FK_xuanze foreign key (j_id)
      references vita (j_id) on delete restrict on update restrict;

alter table vita add constraint FK_createing foreign key (u_id)
      references Student (u_id) on delete restrict on update restrict;

