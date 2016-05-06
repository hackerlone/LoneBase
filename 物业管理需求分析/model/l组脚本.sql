/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2005                    */
/* Created on:     2015-5-26 16:29:20                           */
/*==============================================================*/
create database PmSystem
use PmSystem
if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('交费') and o.name = 'FK_交费_交费_业主')
alter table 交费
   drop constraint FK_交费_交费_业主
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('交费') and o.name = 'FK_交费_交费2_物业收费标准')
alter table 交费
   drop constraint FK_交费_交费2_物业收费标准
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('使用') and o.name = 'FK_使用_使用_业主')
alter table 使用
   drop constraint FK_使用_使用_业主
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('使用') and o.name = 'FK_使用_使用2_物业资源')
alter table 使用
   drop constraint FK_使用_使用2_物业资源
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('寻访') and o.name = 'FK_寻访_寻访_业主')
alter table 寻访
   drop constraint FK_寻访_寻访_业主
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('寻访') and o.name = 'FK_寻访_寻访2_外来人员')
alter table 寻访
   drop constraint FK_寻访_寻访2_外来人员
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('投诉') and o.name = 'FK_投诉_投诉_业主')
alter table 投诉
   drop constraint FK_投诉_投诉_业主
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('投诉') and o.name = 'FK_投诉_投诉2_物管人员')
alter table 投诉
   drop constraint FK_投诉_投诉2_物管人员
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('服务') and o.name = 'FK_服务_服务_生活服务公司')
alter table 服务
   drop constraint FK_服务_服务_生活服务公司
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('服务') and o.name = 'FK_服务_服务2_业主')
alter table 服务
   drop constraint FK_服务_服务2_业主
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('物业工作人员') and o.name = 'FK_物业工作人员_实施安装_物业资源')
alter table 物业工作人员
   drop constraint FK_物业工作人员_实施安装_物业资源
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('物业工作人员') and o.name = 'FK_物业工作人员_雇佣_物管人员')
alter table 物业工作人员
   drop constraint FK_物业工作人员_雇佣_物管人员
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('物业资源') and o.name = 'FK_物业资源_RELATIONS_仓库')
alter table 物业资源
   drop constraint FK_物业资源_RELATIONS_仓库
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('物业资源') and o.name = 'FK_物业资源_产生_物资账单')
alter table 物业资源
   drop constraint FK_物业资源_产生_物资账单
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('物业资源') and o.name = 'FK_物业资源_运输_资源市场')
alter table 物业资源
   drop constraint FK_物业资源_运输_资源市场
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('物管人员') and o.name = 'FK_物管人员_选择_资源市场')
alter table 物管人员
   drop constraint FK_物管人员_选择_资源市场
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('负责') and o.name = 'FK_负责_负责_物管人员')
alter table 负责
   drop constraint FK_负责_负责_物管人员
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('负责') and o.name = 'FK_负责_负责2_物业资源')
alter table 负责
   drop constraint FK_负责_负责2_物业资源
go

if exists (select 1
            from  sysobjects
           where  id = object_id('业主')
            and   type = 'U')
   drop table 业主
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('交费')
            and   name  = '交费2_FK'
            and   indid > 0
            and   indid < 255)
   drop index 交费.交费2_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('交费')
            and   name  = '交费_FK'
            and   indid > 0
            and   indid < 255)
   drop index 交费.交费_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('交费')
            and   type = 'U')
   drop table 交费
go

if exists (select 1
            from  sysobjects
           where  id = object_id('仓库')
            and   type = 'U')
   drop table 仓库
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('使用')
            and   name  = '使用2_FK'
            and   indid > 0
            and   indid < 255)
   drop index 使用.使用2_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('使用')
            and   name  = '使用_FK'
            and   indid > 0
            and   indid < 255)
   drop index 使用.使用_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('使用')
            and   type = 'U')
   drop table 使用
go

if exists (select 1
            from  sysobjects
           where  id = object_id('外来人员')
            and   type = 'U')
   drop table 外来人员
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('寻访')
            and   name  = '寻访2_FK'
            and   indid > 0
            and   indid < 255)
   drop index 寻访.寻访2_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('寻访')
            and   name  = '寻访_FK'
            and   indid > 0
            and   indid < 255)
   drop index 寻访.寻访_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('寻访')
            and   type = 'U')
   drop table 寻访
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('投诉')
            and   name  = '投诉2_FK'
            and   indid > 0
            and   indid < 255)
   drop index 投诉.投诉2_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('投诉')
            and   name  = '投诉_FK'
            and   indid > 0
            and   indid < 255)
   drop index 投诉.投诉_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('投诉')
            and   type = 'U')
   drop table 投诉
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('服务')
            and   name  = '服务2_FK'
            and   indid > 0
            and   indid < 255)
   drop index 服务.服务2_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('服务')
            and   name  = '服务_FK'
            and   indid > 0
            and   indid < 255)
   drop index 服务.服务_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('服务')
            and   type = 'U')
   drop table 服务
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('物业工作人员')
            and   name  = '实施安装_FK'
            and   indid > 0
            and   indid < 255)
   drop index 物业工作人员.实施安装_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('物业工作人员')
            and   name  = '雇佣_FK'
            and   indid > 0
            and   indid < 255)
   drop index 物业工作人员.雇佣_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('物业工作人员')
            and   type = 'U')
   drop table 物业工作人员
go

if exists (select 1
            from  sysobjects
           where  id = object_id('物业收费标准')
            and   type = 'U')
   drop table 物业收费标准
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('物业资源')
            and   name  = '产生_FK'
            and   indid > 0
            and   indid < 255)
   drop index 物业资源.产生_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('物业资源')
            and   name  = '运输_FK'
            and   indid > 0
            and   indid < 255)
   drop index 物业资源.运输_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('物业资源')
            and   name  = 'Relationship_9_FK'
            and   indid > 0
            and   indid < 255)
   drop index 物业资源.Relationship_9_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('物业资源')
            and   type = 'U')
   drop table 物业资源
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('物管人员')
            and   name  = '选择_FK'
            and   indid > 0
            and   indid < 255)
   drop index 物管人员.选择_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('物管人员')
            and   type = 'U')
   drop table 物管人员
go

if exists (select 1
            from  sysobjects
           where  id = object_id('物资账单')
            and   type = 'U')
   drop table 物资账单
go

if exists (select 1
            from  sysobjects
           where  id = object_id('生活服务公司')
            and   type = 'U')
   drop table 生活服务公司
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('负责')
            and   name  = '负责2_FK'
            and   indid > 0
            and   indid < 255)
   drop index 负责.负责2_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('负责')
            and   name  = '负责_FK'
            and   indid > 0
            and   indid < 255)
   drop index 负责.负责_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('负责')
            and   type = 'U')
   drop table 负责
go

if exists (select 1
            from  sysobjects
           where  id = object_id('资源市场')
            and   type = 'U')
   drop table 资源市场
go

/*==============================================================*/
/* Table: 业主                                                    */
/*==============================================================*/
create table 业主 (
   o_id                 int                  not null,
   o_xm                 varchar(20)          null,
   o_nl                 int                  null,
   o_jtzz               varchar(100)         null,
   o_sfzhm              int                  null,
   o_rzsj               datetime             null,
   o_lxfs               int                  null,
   o_zhmj               int                  null,
   constraint PK_业主 primary key nonclustered (o_id)
)
go

/*==============================================================*/
/* Table: 交费                                                    */
/*==============================================================*/
create table 交费 (
   o_id                 int                  not null,
   wy_id                int                  not null,
   constraint PK_交费 primary key (o_id, wy_id)
)
go

/*==============================================================*/
/* Index: 交费_FK                                                 */
/*==============================================================*/
create index 交费_FK on 交费 (
o_id ASC
)
go

/*==============================================================*/
/* Index: 交费2_FK                                                */
/*==============================================================*/
create index 交费2_FK on 交费 (
wy_id ASC
)
go

/*==============================================================*/
/* Table: 仓库                                                    */
/*==============================================================*/
create table 仓库 (
   k_name               varchar(16)          not null,
   k_leibie             varchar(20)          null,
   k_wuping             int                  null,
   k_shuliang           int                  null,
   constraint PK_仓库 primary key nonclustered (k_name)
)
go

/*==============================================================*/
/* Table: 使用                                                    */
/*==============================================================*/
create table 使用 (
   o_id                 int                  not null,
   zy_id                int                  not null,
   constraint PK_使用 primary key (o_id, zy_id)
)
go

/*==============================================================*/
/* Index: 使用_FK                                                 */
/*==============================================================*/
create index 使用_FK on 使用 (
o_id ASC
)
go

/*==============================================================*/
/* Index: 使用2_FK                                                */
/*==============================================================*/
create index 使用2_FK on 使用 (
zy_id ASC
)
go

/*==============================================================*/
/* Table: 外来人员                                                  */
/*==============================================================*/
create table 外来人员 (
   wl_id                int                  not null,
   wl_xm                varchar(20)          null,
   wl_xb                varchar(10)          null,
   wl_sfzhm             int                  null,
   wl_shiyou            char(10)             null,
   constraint PK_外来人员 primary key nonclustered (wl_id)
)
go

/*==============================================================*/
/* Table: 寻访                                                    */
/*==============================================================*/
create table 寻访 (
   o_id                 int                  not null,
   wl_id                int                  not null,
   constraint PK_寻访 primary key (o_id, wl_id)
)
go

/*==============================================================*/
/* Index: 寻访_FK                                                 */
/*==============================================================*/
create index 寻访_FK on 寻访 (
o_id ASC
)
go

/*==============================================================*/
/* Index: 寻访2_FK                                                */
/*==============================================================*/
create index 寻访2_FK on 寻访 (
wl_id ASC
)
go

/*==============================================================*/
/* Table: 投诉                                                    */
/*==============================================================*/
create table 投诉 (
   o_id                 int                  not null,
   w_id                 int                  not null,
   constraint PK_投诉 primary key (o_id, w_id)
)
go

/*==============================================================*/
/* Index: 投诉_FK                                                 */
/*==============================================================*/
create index 投诉_FK on 投诉 (
o_id ASC
)
go

/*==============================================================*/
/* Index: 投诉2_FK                                                */
/*==============================================================*/
create index 投诉2_FK on 投诉 (
w_id ASC
)
go

/*==============================================================*/
/* Table: 服务                                                    */
/*==============================================================*/
create table 服务 (
   sh_id                int                  not null,
   o_id                 int                  not null,
   constraint PK_服务 primary key (sh_id, o_id)
)
go

/*==============================================================*/
/* Index: 服务_FK                                                 */
/*==============================================================*/
create index 服务_FK on 服务 (
sh_id ASC
)
go

/*==============================================================*/
/* Index: 服务2_FK                                                */
/*==============================================================*/
create index 服务2_FK on 服务 (
o_id ASC
)
go

/*==============================================================*/
/* Table: 物业工作人员                                                */
/*==============================================================*/
create table 物业工作人员 (
   gz_bianhao           int                  not null,
   zy_id                int                  null,
   w_id                 int                  null,
   gz_xx                varchar(20)          null,
   gz_nb                varchar(20)          null,
   gz_qk                varchar(20)          null,
   constraint PK_物业工作人员 primary key nonclustered (gz_bianhao)
)
go

/*==============================================================*/
/* Index: 雇佣_FK                                                 */
/*==============================================================*/
create index 雇佣_FK on 物业工作人员 (
w_id ASC
)
go

/*==============================================================*/
/* Index: 实施安装_FK                                               */
/*==============================================================*/
create index 实施安装_FK on 物业工作人员 (
zy_id ASC
)
go

/*==============================================================*/
/* Table: 物业收费标准                                                */
/*==============================================================*/
create table 物业收费标准 (
   wy_id                int                  not null,
   wy_zl                varchar(50)          null,
   wy_bzjg              int                  null,
   wy_time              datetime             null,
   constraint PK_物业收费标准 primary key nonclustered (wy_id)
)
go

/*==============================================================*/
/* Table: 物业资源                                                  */
/*==============================================================*/
create table 物业资源 (
   zy_id                int                  not null,
   z_id                 int                  null,
   s_nb                 int                  null,
   k_name               varchar(16)          null,
   zy_leibie            varchar(20)          null,
   zy_name              varchar(20)          null,
   zy_qingkuang         varchar(50)          null,
   zy_guisu             varchar(50)          null,
   constraint PK_物业资源 primary key nonclustered (zy_id)
)
go

/*==============================================================*/
/* Index: Relationship_9_FK                                     */
/*==============================================================*/
create index Relationship_9_FK on 物业资源 (
k_name ASC
)
go

/*==============================================================*/
/* Index: 运输_FK                                                 */
/*==============================================================*/
create index 运输_FK on 物业资源 (
s_nb ASC
)
go

/*==============================================================*/
/* Index: 产生_FK                                                 */
/*==============================================================*/
create index 产生_FK on 物业资源 (
z_id ASC
)
go

/*==============================================================*/
/* Table: 物管人员                                                  */
/*==============================================================*/
create table 物管人员 (
   w_id                 int                  not null,
   s_nb                 int                  null,
   w_xm                 varchar(20)          null,
   w_nl                 int                  null,
   w_sg                 int                  null,
   w_jtzz               varchar(100)         null,
   w_jg                 varchar(40)          null,
   w_sfzhm              int                  null,
   w_lxfs               int                  null,
   w_time               datetime             null,
   constraint PK_物管人员 primary key nonclustered (w_id)
)
go

/*==============================================================*/
/* Index: 选择_FK                                                 */
/*==============================================================*/
create index 选择_FK on 物管人员 (
s_nb ASC
)
go

/*==============================================================*/
/* Table: 物资账单                                                  */
/*==============================================================*/
create table 物资账单 (
   z_id                 int                  not null,
   z_lei                varchar(20)          null,
   z_beizhu             varchar(50)          null,
   constraint PK_物资账单 primary key nonclustered (z_id)
)
go

/*==============================================================*/
/* Table: 生活服务公司                                                */
/*==============================================================*/
create table 生活服务公司 (
   sh_id                int                  not null,
   sh_gsmz              varchar(50)          null,
   sh_time              datetime             null,
   constraint PK_生活服务公司 primary key nonclustered (sh_id)
)
go

/*==============================================================*/
/* Table: 负责                                                    */
/*==============================================================*/
create table 负责 (
   w_id                 int                  not null,
   zy_id                int                  not null,
   constraint PK_负责 primary key (w_id, zy_id)
)
go

/*==============================================================*/
/* Index: 负责_FK                                                 */
/*==============================================================*/
create index 负责_FK on 负责 (
w_id ASC
)
go

/*==============================================================*/
/* Index: 负责2_FK                                                */
/*==============================================================*/
create index 负责2_FK on 负责 (
zy_id ASC
)
go

/*==============================================================*/
/* Table: 资源市场                                                  */
/*==============================================================*/
create table 资源市场 (
   s_nb                 int                  not null,
   s_name               varchar(20)          null,
   s_leibie             varchar(20)          null,
   constraint PK_资源市场 primary key nonclustered (s_nb)
)
go

alter table 交费
   add constraint FK_交费_交费_业主 foreign key (o_id)
      references 业主 (o_id)
go

alter table 交费
   add constraint FK_交费_交费2_物业收费标准 foreign key (wy_id)
      references 物业收费标准 (wy_id)
go

alter table 使用
   add constraint FK_使用_使用_业主 foreign key (o_id)
      references 业主 (o_id)
go

alter table 使用
   add constraint FK_使用_使用2_物业资源 foreign key (zy_id)
      references 物业资源 (zy_id)
go

alter table 寻访
   add constraint FK_寻访_寻访_业主 foreign key (o_id)
      references 业主 (o_id)
go

alter table 寻访
   add constraint FK_寻访_寻访2_外来人员 foreign key (wl_id)
      references 外来人员 (wl_id)
go

alter table 投诉
   add constraint FK_投诉_投诉_业主 foreign key (o_id)
      references 业主 (o_id)
go

alter table 投诉
   add constraint FK_投诉_投诉2_物管人员 foreign key (w_id)
      references 物管人员 (w_id)
go

alter table 服务
   add constraint FK_服务_服务_生活服务公司 foreign key (sh_id)
      references 生活服务公司 (sh_id)
go

alter table 服务
   add constraint FK_服务_服务2_业主 foreign key (o_id)
      references 业主 (o_id)
go

alter table 物业工作人员
   add constraint FK_物业工作人员_实施安装_物业资源 foreign key (zy_id)
      references 物业资源 (zy_id)
go

alter table 物业工作人员
   add constraint FK_物业工作人员_雇佣_物管人员 foreign key (w_id)
      references 物管人员 (w_id)
go

alter table 物业资源
   add constraint FK_物业资源_RELATIONS_仓库 foreign key (k_name)
      references 仓库 (k_name)
go

alter table 物业资源
   add constraint FK_物业资源_产生_物资账单 foreign key (z_id)
      references 物资账单 (z_id)
go

alter table 物业资源
   add constraint FK_物业资源_运输_资源市场 foreign key (s_nb)
      references 资源市场 (s_nb)
go

alter table 物管人员
   add constraint FK_物管人员_选择_资源市场 foreign key (s_nb)
      references 资源市场 (s_nb)
go

alter table 负责
   add constraint FK_负责_负责_物管人员 foreign key (w_id)
      references 物管人员 (w_id)
go

alter table 负责
   add constraint FK_负责_负责2_物业资源 foreign key (zy_id)
      references 物业资源 (zy_id)
go

