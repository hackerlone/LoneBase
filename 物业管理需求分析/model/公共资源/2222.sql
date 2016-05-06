/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2005                    */
/* Created on:     2015-5-22 12:07:54                           */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('gamegoods') and o.name = 'FK_GAMEGOOD_A_G_ADMIN')
alter table gamegoods
   drop constraint FK_GAMEGOOD_A_G_ADMIN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('message') and o.name = 'FK_MESSAGE_MESSAGE_USER')
alter table message
   drop constraint FK_MESSAGE_MESSAGE_USER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('u_g') and o.name = 'FK_U_G_U_G_GAMEGOOD')
alter table u_g
   drop constraint FK_U_G_U_G_GAMEGOOD
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('u_g') and o.name = 'FK_U_G_U_G2_USER')
alter table u_g
   drop constraint FK_U_G_U_G2_USER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('u_r') and o.name = 'FK_U_R_U_R_RULE_SCO')
alter table u_r
   drop constraint FK_U_R_U_R_RULE_SCO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('u_r') and o.name = 'FK_U_R_U_R2_USER')
alter table u_r
   drop constraint FK_U_R_U_R2_USER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('"user"') and o.name = 'FK_USER_A_U_ADMIN')
alter table "user"
   drop constraint FK_USER_A_U_ADMIN
go

if exists (select 1
            from  sysobjects
           where  id = object_id('admin')
            and   type = 'U')
   drop table admin
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('gamegoods')
            and   name  = 'a_g_FK'
            and   indid > 0
            and   indid < 255)
   drop index gamegoods.a_g_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('gamegoods')
            and   type = 'U')
   drop table gamegoods
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('message')
            and   name  = 'message_FK'
            and   indid > 0
            and   indid < 255)
   drop index message.message_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('message')
            and   type = 'U')
   drop table message
go

if exists (select 1
            from  sysobjects
           where  id = object_id('rule_score')
            and   type = 'U')
   drop table rule_score
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('u_g')
            and   name  = 'u_g_FK'
            and   indid > 0
            and   indid < 255)
   drop index u_g.u_g_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('u_g')
            and   name  = 'u_g2_FK'
            and   indid > 0
            and   indid < 255)
   drop index u_g.u_g2_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('u_g')
            and   type = 'U')
   drop table u_g
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('u_r')
            and   name  = 'u_r_FK'
            and   indid > 0
            and   indid < 255)
   drop index u_r.u_r_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('u_r')
            and   name  = 'u_r2_FK'
            and   indid > 0
            and   indid < 255)
   drop index u_r.u_r2_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('u_r')
            and   type = 'U')
   drop table u_r
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('"user"')
            and   name  = 'a_u_FK'
            and   indid > 0
            and   indid < 255)
   drop index "user".a_u_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('"user"')
            and   type = 'U')
   drop table "user"
go

/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
create table admin (
   a_id                 int                  not null,
   a_name               varchar(20)          null,
   a_pwd                varchar(10)          null,
   constraint PK_ADMIN primary key nonclustered (a_id)
)
go

/*==============================================================*/
/* Table: gamegoods                                             */
/*==============================================================*/
create table gamegoods (
   g_id                 int                  not null,
   a_id                 int                  null,
   g_name               varchar(20)          null,
   g_regional           varchar(20)          null,
   g_Itemname           varchar(50)          null,
   g_price              int                  null,
   constraint PK_GAMEGOODS primary key nonclustered (g_id)
)
go

/*==============================================================*/
/* Index: a_g_FK                                                */
/*==============================================================*/
create index a_g_FK on gamegoods (
a_id ASC
)
go

/*==============================================================*/
/* Table: message                                               */
/*==============================================================*/
create table message (
   m_id                 int                  not null,
   u_id                 int                  null,
   m_message            varchar(500)         null,
   m_time               datetime             null,
   constraint PK_MESSAGE primary key nonclustered (m_id)
)
go

/*==============================================================*/
/* Index: message_FK                                            */
/*==============================================================*/
create index message_FK on message (
u_id ASC
)
go

/*==============================================================*/
/* Table: rule_score                                            */
/*==============================================================*/
create table rule_score (
   r_id                 int                  not null,
   r_name               varchar(20)          null,
   r_score              int                  null,
   constraint PK_RULE_SCORE primary key nonclustered (r_id)
)
go

/*==============================================================*/
/* Table: u_g                                                   */
/*==============================================================*/
create table u_g (
   g_id                 int                  not null,
   u_id1                int                  not null,
   u_id2                int                  null,
   state                varchar(10)          null,
   time                 datetime             null,
   constraint PK_U_G primary key nonclustered (g_id, u_id1)
)
go

/*==============================================================*/
/* Index: u_g2_FK                                               */
/*==============================================================*/
create index u_g2_FK on u_g (
u_id1 ASC
)
go

/*==============================================================*/
/* Index: u_g_FK                                                */
/*==============================================================*/
create index u_g_FK on u_g (
g_id ASC
)
go

/*==============================================================*/
/* Table: u_r                                                   */
/*==============================================================*/
create table u_r (
   r_id                 int                  not null,
   u_id                 int                  not null,
   time                 datetime             null,
   constraint PK_U_R primary key nonclustered (r_id, u_id)
)
go

/*==============================================================*/
/* Index: u_r2_FK                                               */
/*==============================================================*/
create index u_r2_FK on u_r (
u_id ASC
)
go

/*==============================================================*/
/* Index: u_r_FK                                                */
/*==============================================================*/
create index u_r_FK on u_r (
r_id ASC
)
go

/*==============================================================*/
/* Table: "user"                                                */
/*==============================================================*/
create table "user" (
   u_id                 int                  not null,
   a_id                 int                  null,
   u_name               varchar(20)          null,
   u_pwd                varchar(10)          null,
   u_score              int                  null,
   u_sex                varchar(4)           null,
   u_area               varchar(20)          null,
   u_phone              int                  null,
   u_email              varchar(50)          null,
   constraint PK_USER primary key nonclustered (u_id)
)
go

/*==============================================================*/
/* Index: a_u_FK                                                */
/*==============================================================*/
create index a_u_FK on "user" (
a_id ASC
)
go

alter table gamegoods
   add constraint FK_GAMEGOOD_A_G_ADMIN foreign key (a_id)
      references admin (a_id)
go

alter table message
   add constraint FK_MESSAGE_MESSAGE_USER foreign key (u_id)
      references "user" (u_id)
go

alter table u_g
   add constraint FK_U_G_U_G_GAMEGOOD foreign key (g_id)
      references gamegoods (g_id)
go

alter table u_g
   add constraint FK_U_G_U_G2_USER foreign key (u_id1)
      references "user" (u_id)
go

alter table u_r
   add constraint FK_U_R_U_R_RULE_SCO foreign key (r_id)
      references rule_score (r_id)
go

alter table u_r
   add constraint FK_U_R_U_R2_USER foreign key (u_id)
      references "user" (u_id)
go

alter table "user"
   add constraint FK_USER_A_U_ADMIN foreign key (a_id)
      references admin (a_id)
go

