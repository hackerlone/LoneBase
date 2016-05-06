/*==============================================================*/
/* DBMS name:      Sybase SQL Anywhere 11                       */
/* Created on:     2015-5-26 17:45:56                           */
/*==============================================================*/


if exists(select 1 from sys.sysforeignkey where role='FK_GAMEGOOD_A_G_ADMIN') then
    alter table gamegoods
       delete foreign key FK_GAMEGOOD_A_G_ADMIN
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_MESSAGE_MESSAGE_USER') then
    alter table "message"
       delete foreign key FK_MESSAGE_MESSAGE_USER
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_U_G_U_G_USER') then
    alter table u_g
       delete foreign key FK_U_G_U_G_USER
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_U_G_U_G2_GAMEGOOD') then
    alter table u_g
       delete foreign key FK_U_G_U_G2_GAMEGOOD
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_U_R_U_R_USER') then
    alter table u_r
       delete foreign key FK_U_R_U_R_USER
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_U_R_U_R2_RULE_SCO') then
    alter table u_r
       delete foreign key FK_U_R_U_R2_RULE_SCO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_USER_A_U_ADMIN') then
    alter table "user"
       delete foreign key FK_USER_A_U_ADMIN
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='admin_PK'
     and t.table_name='admin'
) then
   drop index admin.admin_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='admin'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table admin
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='a_g_FK'
     and t.table_name='gamegoods'
) then
   drop index gamegoods.a_g_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='gamegoods_PK'
     and t.table_name='gamegoods'
) then
   drop index gamegoods.gamegoods_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='gamegoods'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table gamegoods
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='message_FK'
     and t.table_name='message'
) then
   drop index "message".message_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='message_PK'
     and t.table_name='message'
) then
   drop index "message".message_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='message'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table "message"
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='rule_score_PK'
     and t.table_name='rule_score'
) then
   drop index rule_score.rule_score_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='rule_score'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table rule_score
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='u_g2_FK'
     and t.table_name='u_g'
) then
   drop index u_g.u_g2_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='u_g_FK'
     and t.table_name='u_g'
) then
   drop index u_g.u_g_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='u_g_PK'
     and t.table_name='u_g'
) then
   drop index u_g.u_g_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='u_g'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table u_g
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='u_r2_FK'
     and t.table_name='u_r'
) then
   drop index u_r.u_r2_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='u_r_FK'
     and t.table_name='u_r'
) then
   drop index u_r.u_r_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='u_r_PK'
     and t.table_name='u_r'
) then
   drop index u_r.u_r_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='u_r'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table u_r
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='a_u_FK'
     and t.table_name='user'
) then
   drop index "user".a_u_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='user_PK'
     and t.table_name='user'
) then
   drop index "user".user_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='user'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table "user"
end if;

/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
create table admin 
(
   a_id                 integer                        not null,
   a_name               varchar(20)                    null,
   a_pwd                varchar(10)                    null,
   constraint PK_ADMIN primary key (a_id)
);

/*==============================================================*/
/* Index: admin_PK                                              */
/*==============================================================*/
create unique index admin_PK on admin (
a_id ASC
);

/*==============================================================*/
/* Table: gamegoods                                             */
/*==============================================================*/
create table gamegoods 
(
   g_id                 integer                        not null,
   a_id                 integer                        null,
   g_name               varchar(20)                    null,
   g_regional           varchar(20)                    null,
   g_Itemname           varchar(50)                    null,
   g_price              integer                        null,
   constraint PK_GAMEGOODS primary key (g_id)
);

/*==============================================================*/
/* Index: gamegoods_PK                                          */
/*==============================================================*/
create unique index gamegoods_PK on gamegoods (
g_id ASC
);

/*==============================================================*/
/* Index: a_g_FK                                                */
/*==============================================================*/
create index a_g_FK on gamegoods (
a_id ASC
);

/*==============================================================*/
/* Table: "message"                                             */
/*==============================================================*/
create table "message" 
(
   m_id                 integer                        not null,
   u_id                 integer                        null,
   m_message            varchar(500)                   null,
   m_time               time                           null,
   constraint PK_MESSAGE primary key (m_id)
);

/*==============================================================*/
/* Index: message_PK                                            */
/*==============================================================*/
create unique index message_PK on "message" (
m_id ASC
);

/*==============================================================*/
/* Index: message_FK                                            */
/*==============================================================*/
create index message_FK on "message" (
u_id ASC
);

/*==============================================================*/
/* Table: rule_score                                            */
/*==============================================================*/
create table rule_score 
(
   r_id                 integer                        not null,
   r_name               varchar(20)                    null,
   r_score              integer                        null,
   constraint PK_RULE_SCORE primary key (r_id)
);

/*==============================================================*/
/* Index: rule_score_PK                                         */
/*==============================================================*/
create unique index rule_score_PK on rule_score (
r_id ASC
);

/*==============================================================*/
/* Table: u_g                                                   */
/*==============================================================*/
create table u_g 
(
   u_id                 integer                        not null,
   g_id                 integer                        not null,
   constraint PK_U_G primary key clustered (u_id, g_id)
);

/*==============================================================*/
/* Index: u_g_PK                                                */
/*==============================================================*/
create unique clustered index u_g_PK on u_g (
u_id ASC,
g_id ASC
);

/*==============================================================*/
/* Index: u_g_FK                                                */
/*==============================================================*/
create index u_g_FK on u_g (
u_id ASC
);

/*==============================================================*/
/* Index: u_g2_FK                                               */
/*==============================================================*/
create index u_g2_FK on u_g (
g_id ASC
);

/*==============================================================*/
/* Table: u_r                                                   */
/*==============================================================*/
create table u_r 
(
   u_id                 integer                        not null,
   r_id                 integer                        not null,
   constraint PK_U_R primary key clustered (u_id, r_id)
);

/*==============================================================*/
/* Index: u_r_PK                                                */
/*==============================================================*/
create unique clustered index u_r_PK on u_r (
u_id ASC,
r_id ASC
);

/*==============================================================*/
/* Index: u_r_FK                                                */
/*==============================================================*/
create index u_r_FK on u_r (
u_id ASC
);

/*==============================================================*/
/* Index: u_r2_FK                                               */
/*==============================================================*/
create index u_r2_FK on u_r (
r_id ASC
);

/*==============================================================*/
/* Table: "user"                                                */
/*==============================================================*/
create table "user" 
(
   u_id                 integer                        not null,
   a_id                 integer                        null,
   u_name               varchar(20)                    null,
   u_pwd                varchar(10)                    null,
   u_score              integer                        null,
   u_sex                varchar(4)                     null,
   u_area               varchar(20)                    null,
   u_phone              integer                        null,
   u_email              varchar(50)                    null,
   constraint PK_USER primary key (u_id)
);

/*==============================================================*/
/* Index: user_PK                                               */
/*==============================================================*/
create unique index user_PK on "user" (
u_id ASC
);

/*==============================================================*/
/* Index: a_u_FK                                                */
/*==============================================================*/
create index a_u_FK on "user" (
a_id ASC
);

alter table gamegoods
   add constraint FK_GAMEGOOD_A_G_ADMIN foreign key (a_id)
      references admin (a_id)
      on update restrict
      on delete restrict;

alter table "message"
   add constraint FK_MESSAGE_MESSAGE_USER foreign key (u_id)
      references "user" (u_id)
      on update restrict
      on delete restrict;

alter table u_g
   add constraint FK_U_G_U_G_USER foreign key (u_id)
      references "user" (u_id)
      on update restrict
      on delete restrict;

alter table u_g
   add constraint FK_U_G_U_G2_GAMEGOOD foreign key (g_id)
      references gamegoods (g_id)
      on update restrict
      on delete restrict;

alter table u_r
   add constraint FK_U_R_U_R_USER foreign key (u_id)
      references "user" (u_id)
      on update restrict
      on delete restrict;

alter table u_r
   add constraint FK_U_R_U_R2_RULE_SCO foreign key (r_id)
      references rule_score (r_id)
      on update restrict
      on delete restrict;

alter table "user"
   add constraint FK_USER_A_U_ADMIN foreign key (a_id)
      references admin (a_id)
      on update restrict
      on delete restrict;

