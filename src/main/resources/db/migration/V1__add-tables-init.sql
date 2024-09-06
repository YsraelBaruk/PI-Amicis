CREATE TABLE agente_adocao(
    id bigint primary key NOT NULL AUTO_INCREMENT,
    nome varchar(300) NOT NULL,
    cpf varchar(11) NOT NULL
);

CREATE TABLE agente_servico(
    id bigint primary key NOT NULL AUTO_INCREMENT,
    nome varchar(300) NOT NULL,
    cpf varchar(11) NOT NULL
);

CREATE TABLE tutor(
    id bigint primary key NOT NULL AUTO_INCREMENT,
    nome varchar(300) NOT NULL,
    cpf varchar(11) NOT NULL,
    telefone varchar(11) NOT NULL,
    email varchar(150) NOT NULL,
    data_nascimento date
);

CREATE TABLE cachorro(
    id bigint primary key NOT NULL AUTO_INCREMENT,
    nome varchar(300) NOT NULL,
    data_nascimento date NOT NULL,
    descricao varchar(500),
    agente_adocao_id bigint NOT NULL,
    tutor_id bigint NOT NULL,
    FOREIGN KEY (tutor_id) REFERENCES tutor(id),
    FOREIGN KEY (agente_adocao_id) REFERENCES agente_adocao(id)
);

CREATE TABLE plano (
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(300),
    preco DOUBLE NOT NULL,
    tutor_id BIGINT NOT NULL,
    agente_servico_id BIGINT NOT NULL,
    FOREIGN KEY (tutor_id) REFERENCES tutor(id),
    FOREIGN KEY (agente_servico_id) REFERENCES agente_servico(id)
) ENGINE=InnoDB;

CREATE TABLE servico(
    id bigint primary key NOT NULL AUTO_INCREMENT,
    nome varchar(150) NOT NULL,
    descricao varchar(300),
    plano_id bigint NOT NULL,
    FOREIGN KEY (plano_id) REFERENCES plano(id)
);