/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/11/21 20:31:51                          */
/*==============================================================*/


drop table if exists BLOGTEXT;

drop table if exists COLLECTION_TEXT;

drop table if exists PICTURE;

drop table if exists TEXT_TYPE;

drop table if exists TEXT_TYPE_MANAGER;

drop table if exists USER;

/*==============================================================*/
/* Table: BLOGTEXT                                              */
/*==============================================================*/
create table BLOGTEXT
(
   BT_ID                int not null,
   USER_ID              int,
   TEXTTYPE_ID          int,
   TITLE                varchar(30) not null,
   AUTHORNAME           varchar(30) not null,
   BT_TYPE              varchar(30) not null,
   BLOGTEXT             text not null,
   READTIMES            int not null,
   BTURL                varchar(50) not null,
   GOOD                 int not null,
   BAD                  int not null,
   COLLECTION           int not null,
   PUBLISHTIME          date not null,
   LASTMODIFY           date not null,
   EXP0                 varchar(20),
   EXP1                 varchar(30),
   EXP2                 varchar(50),
   EXP3                 date,
   EXP4                 date,
   EXP5                 int,
   EXP6                 bigint,
   EXP7                 smallint,
   EXP8                 double,
   primary key (BT_ID)
);

/*==============================================================*/
/* Table: COLLECTION_TEXT                                       */
/*==============================================================*/
create table COLLECTION_TEXT
(
   COL_USER_ID          int not null,
   COL_TEXT_ID          int not null,
   COL_TEXT             varchar(30) not null,
   COL_USERNAME         varchar(30) not null,
   COL_URL              varchar(50) not null,
   COL_TIME             date not null,
   EXP0                 varchar(20),
   EXP1                 varchar(30),
   EXP2                 varchar(50),
   EXP3                 date,
   EXP4                 date,
   EXP5                 int,
   EXP6                 bigint,
   EXP7                 smallint,
   EXP8                 double,
   primary key (COL_USER_ID, COL_TEXT_ID)
);

/*==============================================================*/
/* Table: PICTURE                                               */
/*==============================================================*/
create table PICTURE
(
   PIC_ID               int not null,
   USER_ID              int,
   FORUSER              varchar(30) not null,
   PICURL               varchar(50) not null,
   UPLOADTIME           date not null,
   EXP0                 varchar(20),
   EXP1                 varchar(30),
   EXP2                 varchar(50),
   EXP3                 date,
   EXP4                 date,
   EXP5                 int,
   EXP6                 bigint,
   EXP7                 smallint,
   EXP8                 double,
   primary key (PIC_ID)
);

/*==============================================================*/
/* Table: TEXT_TYPE                                             */
/*==============================================================*/
create table TEXT_TYPE
(
   TEXTTYPE_ID          int not null,
   TT_NAME              varchar(30) not null,
   TTF_NAME             varchar(20) not null,
   EXP0                 varchar(20),
   EXP1                 varchar(30),
   EXP2                 varchar(50),
   EXP3                 date,
   EXP4                 date,
   EXP5                 int,
   EXP6                 bigint,
   EXP7                 smallint,
   EXP8                 double,
   primary key (TEXTTYPE_ID)
);

/*==============================================================*/
/* Table: TEXT_TYPE_MANAGER                                     */
/*==============================================================*/
create table TEXT_TYPE_MANAGER
(
   TYPE_ID              int not null,
   USER_ID              int,
   USERNAME             varchar(30) not null,
   CODELANGUAGE         int not null,
   ALGORITHM            int not null,
   FRONT                int not null,
   BACK                 int not null,
   MOBILE               int not null,
   BIGDATA              int not null,
   MACHINELEARNING      int not null,
   CLOUD                int not null,
   AI                   int not null,
   OTHERTYPE            int not null,
   EXP0                 varchar(20),
   EXP1                 varchar(30),
   EXP2                 varchar(50),
   EXP3                 date,
   EXP4                 date,
   EXP5                 int,
   EXP6                 bigint,
   EXP7                 smallint,
   EXP8                 double,
   primary key (TYPE_ID)
);

/*==============================================================*/
/* Table: USER                                                  */
/*==============================================================*/
create table USER
(
   USER_ID              int not null,
   TYPE_ID              int,
   USERNAME             varchar(30) not null,
   SEX                  smallint not null,
   PASSWORD             varchar(15) not null,
   TRUENAME             varchar(20) not null,
   EMAIL                varchar(30) not null,
   BIRTHDAY             date not null,
   CREATETIME           date not null,
   BLOGNUM              int not null,
   ACCESSTIMES          int not null,
   EXP0                 varchar(20),
   EXP1                 varchar(30),
   EXP2                 varchar(50),
   EXP3                 date,
   EXP4                 date,
   EXP5                 int,
   EXP6                 bigint,
   EXP7                 smallint,
   EXP8                 double,
   primary key (USER_ID)
);

alter table BLOGTEXT add constraint FK_TEXT_TEXTTYPE foreign key (TEXTTYPE_ID)
      references TEXT_TYPE (TEXTTYPE_ID) on delete restrict on update restrict;

alter table BLOGTEXT add constraint FK_USER_BLOGTEXT foreign key (USER_ID)
      references USER (USER_ID) on delete restrict on update restrict;

alter table PICTURE add constraint FK_USER_PICTURE foreign key (USER_ID)
      references USER (USER_ID) on delete restrict on update restrict;

alter table TEXT_TYPE_MANAGER add constraint FK_USER_TEXTMANAGER2 foreign key (USER_ID)
      references USER (USER_ID) on delete restrict on update restrict;

alter table USER add constraint FK_USER_TEXTMANAGER foreign key (TYPE_ID)
      references TEXT_TYPE_MANAGER (TYPE_ID) on delete restrict on update restrict;

