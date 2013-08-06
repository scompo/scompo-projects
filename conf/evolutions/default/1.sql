# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table material (
  id                        bigint not null,
  name                      varchar(255),
  description               varchar(255),
  constraint pk_material primary key (id))
;

create table project (
  id                        bigint not null,
  name                      varchar(255),
  project_description       varchar(255),
  constraint pk_project primary key (id))
;

create table step (
  id                        bigint not null,
  title                     varchar(255),
  description               varchar(255),
  constraint pk_step primary key (id))
;

create table task (
  id                        bigint not null,
  label                     varchar(255),
  constraint pk_task primary key (id))
;


create table project_step (
  project_id                     bigint not null,
  step_id                        bigint not null,
  constraint pk_project_step primary key (project_id, step_id))
;

create table step_material (
  step_id                        bigint not null,
  material_id                    bigint not null,
  constraint pk_step_material primary key (step_id, material_id))
;
create sequence material_seq;

create sequence project_seq;

create sequence step_seq;

create sequence task_seq;




alter table project_step add constraint fk_project_step_project_01 foreign key (project_id) references project (id) on delete restrict on update restrict;

alter table project_step add constraint fk_project_step_step_02 foreign key (step_id) references step (id) on delete restrict on update restrict;

alter table step_material add constraint fk_step_material_step_01 foreign key (step_id) references step (id) on delete restrict on update restrict;

alter table step_material add constraint fk_step_material_material_02 foreign key (material_id) references material (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists material;

drop table if exists project;

drop table if exists project_step;

drop table if exists step;

drop table if exists step_material;

drop table if exists task;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists material_seq;

drop sequence if exists project_seq;

drop sequence if exists step_seq;

drop sequence if exists task_seq;

