/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/10/27 9:53:41                           */
/*==============================================================*/


drop table if exists admin;

drop table if exists car;

drop table if exists cartype;

drop table if exists user;

/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
create table admin
(
   a_id                 int not null,
   a_name               varchar(20),
   a_pwd                varchar(20),
   primary key (a_id)
);

/*==============================================================*/
/* Table: car                                                   */
/*==============================================================*/
create table car
(
   c_id                 int not null,
   u_id                 int,
   ct_id                int,
   a_id                 int,
   brand                varchar(20),
   carseries            varchar(20),
   chexing              varchar(30),
   c_area               varchar(20),
   kilometre            float,
   registration         date,
   price                float,
   image                varchar(100),
   introduce            varchar(200),
   tel                  varchar(11),
   realname             varchar(20),
   area                 varchar(50),
   nianjian             date,
   insurance            date,
   upkeep               char(2),
   "use"                varchar(20),
   primary key (c_id)
);

/*==============================================================*/
/* Table: cartype                                               */
/*==============================================================*/
create table cartype
(
   ct_id                int not null,
   a_id                 int,
   ct_name              varchar(20),
   ct_pid               int,
   primary key (ct_id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   u_id                 int not null,
   a_id                 int,
   u_name               varchar(20),
   u_pwd                varchar(20),
   u_img                varchar(40),
   coin                 int,
   u_phone              varchar(11),
   u_type               char(2),
   u_adress             varchar(50),
   primary key (u_id)
);

alter table car add constraint FK_a_c foreign key (a_id)
      references admin (a_id);

alter table car add constraint FK_c_type foreign key (ct_id)
      references cartype (ct_id);

alter table car add constraint FK_u_c foreign key (u_id)
      references user (u_id);

alter table cartype add constraint FK_a_type foreign key (a_id)
      references admin (a_id);

alter table user add constraint FK_a_u foreign key (a_id)
      references admin (a_id);

