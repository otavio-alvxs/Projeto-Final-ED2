DROP DATABASE ed2;

CREATE DATABASE ed2;

use ed2;

DROP TABLE usuario, livro;

CREATE TABLE usuario (
	idUsuario INT PRIMARY KEY AUTO_INCREMENT,
	nome varchar(255),
	email varchar(255)
);

CREATE TABLE livro (
	idLivro INT PRIMARY KEY AUTO_INCREMENT,
	titulo varchar(255),
	anoPub char(4),
	autor varchar(255),
	disponivel BOOLEAN DEFAULT TRUE
);

CREATE TABLE emprestimo (
	idEmprestimo INT PRIMARY KEY AUTO_INCREMENT,
	idUsuario INT,
	idLivro INT,
	dataEmprestimo date,
	dataDevolucao date,
	CONSTRAINT fk_idUsuario FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario),
	CONSTRAINT fk_idLivro FOREIGN KEY (idLivro) REFERENCES livro(idLivro)
);
