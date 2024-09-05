CREATE TABLE agente_adocao(
    id bigint primary key not null auto_increment,
    nome varchar(300) not null,
    cpf varchar(300) not null
);

CREATE TABLE cachorro(
    id bigint primary key not null auto_increment,
    nome varchar(300) not null,
    data_nascimento date,
    descricao varchar(500),
    agente_adocao_id bigint not null,
    tutor_id bigint not null
);

CREATE TABLE tutor(
    id bigint primary key not null auto_increment,
    nome varchar(300) not null,
    cpf varchar(300) not null,
    data_nascimento date
);

CREATE TABLE plano(
    id bigint primary key not null auto_increment,
    descricao varchar(600),
    preco double not null,
    tutor_id bigint not null,
    agente_servico_id not null
);

CREATE TABLE servico(
    id bigint primary key not null auto_increment,
    nome varchar(150) not null,
    descricao varchar(300),
    plano_id bigint not null
);

CREATE TABLE agente_servico(
    id bigint primary key not null auto_increment,
    nome varchar(300) not null,
    cpf varchar(300) not null
);

ALTER TABLE cachorro ADD CONSTRAINT fk_agente_adocao FOREIGN KEY (agente_adocao_id) REFERENCES agente_adocao(id);
ALTER TABLE cachorro ADD CONSTRAINT fk_tutor FOREIGN KEY (tutor_id) REFERENCES tutor(id);
ALTER TABLE plano ADD CONSTRAINT fk_tutor FOREIGN KEY (tutor_id) REFERENCES tutor(id);
ALTER TABLE plano ADD CONSTRAINT fk_agente_servico FOREIGN KEY (agente_servico_id) REFERENCES agente_servico(id);
ALTER TABLE servico ADD CONSTRAINT fk_plano FOREIGN KEY (plano_id) REFERENCES plano(id);