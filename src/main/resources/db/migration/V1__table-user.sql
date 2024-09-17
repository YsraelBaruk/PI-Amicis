CREATE TABLE IF NOT EXISTS user(
	id bigint PRIMARY KEY AUTO_INCREMENT NOT null,
  	login varchar(100) not null,
  	password varchar(200) NOT null
);

CREATE TABLE IF NOT EXISTS cachorro(
    id bigint PRIMARY KEY AUTO_INCREMENT NOT null,
    nome varchar(200) not null,
    data_nasc DATE not null,
    raca varchar(100),
    status_ boolean not null,
    user_id bigint not null,
    foreign key (user_id) REFERENCES user(id)
);