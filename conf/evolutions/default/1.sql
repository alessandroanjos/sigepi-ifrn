# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table bolsista (
  id                        bigint auto_increment not null,
  nome                      varchar(255),
  email                     varchar(255),
  matricula                 varchar(255),
  cpf                       varchar(255),
  constraint pk_bolsista primary key (id))
;

create table edital (
  id_edital                 bigint auto_increment not null,
  descricao                 varchar(255),
  data_inscricao            datetime,
  periodo_inscricao_inicial datetime,
  perido_inscricao_final    datetime,
  date                      datetime,
  constraint pk_edital primary key (id_edital))
;

create table usuario (
  id                        bigint auto_increment not null,
  login                     varchar(255),
  senha                     varchar(255),
  nome                      varchar(255),
  email                     varchar(255),
  chave_redefinicao_senha   varchar(255),
  is_avaliador              tinyint(1) default 0,
  is_professor              tinyint(1) default 0,
  is_gestor                 tinyint(1) default 0,
  is_administrador          tinyint(1) default 0,
  is_ativo                  tinyint(1) default 0,
  constraint uq_usuario_login unique (login),
  constraint uq_usuario_email unique (email),
  constraint pk_usuario primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table bolsista;

drop table edital;

drop table usuario;

SET FOREIGN_KEY_CHECKS=1;

