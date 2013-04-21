# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table area_conhecimento (
  id                        bigint auto_increment not null,
  nome                      varchar(255),
  constraint uq_area_conhecimento_nome unique (nome),
  constraint pk_area_conhecimento primary key (id))
;

create table bolsista (
  id                        bigint auto_increment not null,
  nome                      varchar(255),
  matricula                 bigint,
  curso_id                  bigint,
  campus_id                 bigint,
  projeto_id                bigint,
  constraint uq_bolsista_matricula unique (matricula),
  constraint pk_bolsista primary key (id))
;

create table campus (
  id                        bigint auto_increment not null,
  nome                      varchar(255),
  constraint uq_campus_nome unique (nome),
  constraint pk_campus primary key (id))
;

create table curso (
  id                        bigint auto_increment not null,
  nome                      varchar(255),
  constraint uq_curso_nome unique (nome),
  constraint pk_curso primary key (id))
;

create table edital (
  id                        bigint auto_increment not null,
  titulo                    varchar(255),
  descricao                 longtext,
  url                       varchar(255),
  data_cadastro             datetime,
  autor_id                  bigint,
  constraint uq_edital_titulo unique (titulo),
  constraint pk_edital primary key (id))
;

create table grupo_pesquisa (
  id                        bigint auto_increment not null,
  nome                      varchar(255),
  campus_id                 bigint,
  constraint uq_grupo_pesquisa_nome unique (nome),
  constraint pk_grupo_pesquisa primary key (id))
;

create table projeto (
  id                        bigint auto_increment not null,
  titulo                    varchar(255),
  resumo                    longtext,
  introducao                longtext,
  fundamentacao_teorica     longtext,
  justificativa             longtext,
  objetivos                 longtext,
  metodologia               longtext,
  referencias               longtext,
  area_conhecimento_id      bigint,
  grupo_pesquisa_id         bigint,
  edital_id                 bigint,
  autor_id                  bigint,
  campus_id                 bigint,
  usuario_avaliar           bigint,
  situacao                  integer,
  primeiro_bolsista_nome    varchar(255),
  primeiro_bolsista_matricula varchar(255),
  primeiro_bolsista_ira     integer,
  curso_id                  bigint,
  constraint uq_projeto_titulo unique (titulo),
  constraint uq_projeto_primeiro_bolsista_mat unique (primeiro_bolsista_matricula),
  constraint pk_projeto primary key (id))
;

create table projeto_avaliado (
  id                        integer auto_increment not null,
  relevancia_tema           integer,
  qualidade_trabalho        integer,
  originalidade             integer,
  apresentacao_estrutura    integer,
  execucao_projeto          integer,
  pontuacao_obtida          integer,
  comentarios               longtext,
  recomendacao              varchar(255),
  usuario_id                bigint,
  projeto_id                bigint,
  constraint pk_projeto_avaliado primary key (id))
;

create table usuario (
  id                        bigint auto_increment not null,
  login                     varchar(255),
  senha                     varchar(255),
  nome                      varchar(255),
  email                     varchar(255),
  area_conhecimento_id      bigint,
  grupo_pesquisa_id         bigint,
  chave_redefinicao_senha   varchar(255),
  is_professor              tinyint(1) default 0,
  is_gestor                 tinyint(1) default 0,
  is_administrador          tinyint(1) default 0,
  is_avaliador              tinyint(1) default 0,
  is_coordenador            tinyint(1) default 0,
  is_ativo                  tinyint(1) default 0,
  campus_id                 bigint,
  constraint uq_usuario_login unique (login),
  constraint uq_usuario_email unique (email),
  constraint pk_usuario primary key (id))
;

alter table bolsista add constraint fk_bolsista_curso_1 foreign key (curso_id) references curso (id) on delete restrict on update restrict;
create index ix_bolsista_curso_1 on bolsista (curso_id);
alter table bolsista add constraint fk_bolsista_campus_2 foreign key (campus_id) references campus (id) on delete restrict on update restrict;
create index ix_bolsista_campus_2 on bolsista (campus_id);
alter table bolsista add constraint fk_bolsista_projeto_3 foreign key (projeto_id) references projeto (id) on delete restrict on update restrict;
create index ix_bolsista_projeto_3 on bolsista (projeto_id);
alter table edital add constraint fk_edital_autor_4 foreign key (autor_id) references usuario (id) on delete restrict on update restrict;
create index ix_edital_autor_4 on edital (autor_id);
alter table grupo_pesquisa add constraint fk_grupo_pesquisa_campus_5 foreign key (campus_id) references campus (id) on delete restrict on update restrict;
create index ix_grupo_pesquisa_campus_5 on grupo_pesquisa (campus_id);
alter table projeto add constraint fk_projeto_areaConhecimento_6 foreign key (area_conhecimento_id) references area_conhecimento (id) on delete restrict on update restrict;
create index ix_projeto_areaConhecimento_6 on projeto (area_conhecimento_id);
alter table projeto add constraint fk_projeto_grupoPesquisa_7 foreign key (grupo_pesquisa_id) references grupo_pesquisa (id) on delete restrict on update restrict;
create index ix_projeto_grupoPesquisa_7 on projeto (grupo_pesquisa_id);
alter table projeto add constraint fk_projeto_edital_8 foreign key (edital_id) references edital (id) on delete restrict on update restrict;
create index ix_projeto_edital_8 on projeto (edital_id);
alter table projeto add constraint fk_projeto_autor_9 foreign key (autor_id) references usuario (id) on delete restrict on update restrict;
create index ix_projeto_autor_9 on projeto (autor_id);
alter table projeto add constraint fk_projeto_campus_10 foreign key (campus_id) references campus (id) on delete restrict on update restrict;
create index ix_projeto_campus_10 on projeto (campus_id);
alter table projeto add constraint fk_projeto_curso_11 foreign key (curso_id) references curso (id) on delete restrict on update restrict;
create index ix_projeto_curso_11 on projeto (curso_id);
alter table projeto_avaliado add constraint fk_projeto_avaliado_usuario_12 foreign key (usuario_id) references usuario (id) on delete restrict on update restrict;
create index ix_projeto_avaliado_usuario_12 on projeto_avaliado (usuario_id);
alter table projeto_avaliado add constraint fk_projeto_avaliado_projeto_13 foreign key (projeto_id) references projeto (id) on delete restrict on update restrict;
create index ix_projeto_avaliado_projeto_13 on projeto_avaliado (projeto_id);
alter table usuario add constraint fk_usuario_areaConhecimento_14 foreign key (area_conhecimento_id) references area_conhecimento (id) on delete restrict on update restrict;
create index ix_usuario_areaConhecimento_14 on usuario (area_conhecimento_id);
alter table usuario add constraint fk_usuario_grupoPesquisa_15 foreign key (grupo_pesquisa_id) references grupo_pesquisa (id) on delete restrict on update restrict;
create index ix_usuario_grupoPesquisa_15 on usuario (grupo_pesquisa_id);
alter table usuario add constraint fk_usuario_campus_16 foreign key (campus_id) references campus (id) on delete restrict on update restrict;
create index ix_usuario_campus_16 on usuario (campus_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table area_conhecimento;

drop table bolsista;

drop table campus;

drop table curso;

drop table edital;

drop table grupo_pesquisa;

drop table projeto;

drop table projeto_avaliado;

drop table usuario;

SET FOREIGN_KEY_CHECKS=1;

