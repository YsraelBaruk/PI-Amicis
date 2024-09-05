CREATE TABLE IF NOT EXISTS  agente_adocao(
    id bigint primary key NOT NULL AUTO_INCREMENT,
    nome varchar(300) NOT NULL,
    cpf varchar(11) NOT NULL
);

CREATE TABLE IF NOT EXISTS cachorro(
    id bigint primary key NOT NULL AUTO_INCREMENT,
    nome varchar(300) NOT NULL,
    data_nascimento date NOT NULL,
    descricao varchar(500),
    agente_adocao_id bigint NOT NULL,
    tutor_id bigint NOT NULL
);

CREATE TABLE IF NOT EXISTS tutor(
    id bigint primary key NOT NULL AUTO_INCREMENT,
    nome varchar(300) NOT NULL,
    cpf varchar(11) NOT NULL,
    telefone varchar(11) NOT NULL,
    email varchar(150) NOT NULL,
    data_nascimento date
);

CREATE TABLE IF NOT EXISTS  plano(
    id bigint primary key NOT NULL AUTO_INCREMENT,
    descricao varchar(600),
    preco double NOT NULL,
    tutor_id bigint NOT NULL,
    agente_servico_id NOT NULL
);

CREATE TABLE IF NOT EXISTS  servico(
    id bigint primary key NOT NULL AUTO_INCREMENT,
    nome varchar(150) NOT NULL,
    descricao varchar(300),
    plano_id bigint NOT NULL
);

CREATE TABLE IF NOT EXISTS  agente_servico(
    id bigint primary key NOT NULL AUTO_INCREMENT,
    nome varchar(300) NOT NULL,
    cpf varchar(11) NOT NULL
);

ALTER TABLE cachorro ADD CONSTRAINT fk_agente_adocao FOREIGN KEY (agente_adocao_id) REFERENCES agente_adocao(id);
ALTER TABLE cachorro ADD CONSTRAINT fk_tutor FOREIGN KEY (tutor_id) REFERENCES tutor(id);
ALTER TABLE plano ADD CONSTRAINT fk_tutor FOREIGN KEY (tutor_id) REFERENCES tutor(id);
ALTER TABLE plano ADD CONSTRAINT fk_agente_servico FOREIGN KEY (agente_servico_id) REFERENCES agente_servico(id);
ALTER TABLE servico ADD CONSTRAINT fk_plano FOREIGN KEY (plano_id) REFERENCES plano(id);